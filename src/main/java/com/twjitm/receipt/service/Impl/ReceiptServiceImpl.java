package com.twjitm.receipt.service.Impl;

import com.twjitm.mail.MailMessage;
import com.twjitm.mail.MailServer;
import com.twjitm.receipt.dao.IReceiptDao;
import com.twjitm.receipt.entity.Equzlize;
import com.twjitm.receipt.entity.Receipt;
import com.twjitm.receipt.enums.ReceiptStateType;
import com.twjitm.receipt.service.IReceiptService;
import com.twjitm.user.entity.User;
import com.twjitm.user.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by 文江 on 2017/9/6.
 */
@Service
public class ReceiptServiceImpl implements IReceiptService {
    @Resource
    IReceiptDao receiptDao;
    @Resource
    IUserService userService;

    public void addReceipt(Receipt receipt, boolean needSendMail) {
        receiptDao.insertReceipt(receipt);
        MailMessage message = new MailMessage();
        User user = userService.getUserById((int) receipt.getUid());
        if (needSendMail) {
            SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd HH:mm:ss am");
            String datStr = format.format(new Date());
            message.setContext(user.getUsername() + "在" + datStr + "购买了" + receipt.getMoney() + "元的" + receipt.getRemarke() + "消费记录已计入小助手");
            List<User> concurrentJoin = userService.getUser();
            this.sendMailToConcurrentPerson(message, concurrentJoin);
        }
    }

    public void updateReceipt(Receipt receipt) {
        receiptDao.updateReceipt(receipt);
    }

    public List<Receipt> getReceiptByState(ReceiptStateType type) {
        List<Receipt> list = receiptDao.getReceiptByState(type.getValue());
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setUserNameVS(userService.getUserById(list.get(i).getUid()).getUsername());
        }
        return list;
    }

    public List<Equzlize> getEquzlizeList(List<Receipt> reports, List<Integer> uIds) {
        List<Equzlize> list = new ArrayList<Equzlize>();
        float allNum = 0;
        Map<Integer, Double> anyOne = new HashMap<Integer, Double>();
        for (Receipt report : reports) {
            allNum += report.getMoney();
            if (anyOne.containsKey(report.getUid())) {
                anyOne.put(report.getUid(), anyOne.get(report) + report.getMoney());
            } else {
                anyOne.put(report.getUid(), report.getMoney());
            }
        }
        float avg = allNum / uIds.size();
        Map<Integer, Double> havgMap = new HashMap<Integer, Double>();//insert
        Map<Integer, Double> davgMap = new ConcurrentHashMap<Integer, Double>();//out
        for (int i = 0; i < uIds.size(); i++) {
            double value = anyOne.get(uIds.get(i)) - avg;
            if (value > 0) {
                havgMap.put(uIds.get(i), value);
            } else {
                davgMap.put(uIds.get(i), value);
            }
        }
        for (Map.Entry<Integer, Double> entry : havgMap.entrySet()) {
            double inmoney = entry.getValue();
            double chamoney = entry.getValue();
            for (Map.Entry<Integer, Double> dentry : davgMap.entrySet()) {
                inmoney = inmoney - Math.abs(dentry.getValue());
                if (inmoney < 0) {
                    Equzlize equzlize = new Equzlize();
                    equzlize.setEquxUid(dentry.getKey());
                    equzlize.setBeqUzUid(entry.getKey());
                    //dentry->entry all
                    equzlize.setMuchMoney(Math.abs(chamoney));
                    davgMap.put(dentry.getKey(), davgMap.get(dentry.getKey()) + Math.abs(chamoney));
                    list.add(equzlize);
                    break;
                } else {
                    Equzlize equzlize = new Equzlize();
                    equzlize.setEquxUid(dentry.getKey());
                    equzlize.setBeqUzUid(entry.getKey());
                    //dentry->entry little
                    chamoney = inmoney;
                    equzlize.setMuchMoney(Math.abs(dentry.getValue()));
                    list.add(equzlize);
                    davgMap.remove(dentry.getKey());
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getEquxUid() + "->give-->" + list.get(i).getBeqUzUid() + ":---->" + list.get(i).getMuchMoney());
        }
        return list;
    }

    /**
     * @param mailMessage
     * @param users
     * @return
     */
    public boolean sendMailToConcurrentPerson(MailMessage mailMessage, List<User> users) {
        return MailServer.sendMail(mailMessage, users);
    }

}
