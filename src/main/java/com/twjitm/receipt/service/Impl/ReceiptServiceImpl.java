package com.twjitm.receipt.service.Impl;

import com.twjitm.receipt.dao.IReceiptDao;
import com.twjitm.receipt.entity.Equzlize;
import com.twjitm.receipt.entity.Receipt;
import com.twjitm.receipt.enums.ReceiptStateType;
import com.twjitm.receipt.service.IReceiptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by 文江 on 2017/9/6.
 */
@Service
public class ReceiptServiceImpl implements IReceiptService {
    @Resource
    IReceiptDao receiptDao;

    public void addReceipt(Receipt receipt) {
        receiptDao.insertReceipt(receipt);
    }

    public void updateReceipt(Receipt receipt) {
        receiptDao.updateReceipt(receipt);
    }

    public List<Receipt> getReceiptByState(ReceiptStateType type) {
        return receiptDao.getReceiptByState(type);
    }

    public List<Equzlize> getEquzlizeList(List<Receipt> reports, List<Long> uIds) {
        List<Equzlize> list = new ArrayList<Equzlize>();
        float allNum = 0;
        Map<Long, Double> anyOne = new HashMap<Long, Double>();
        for (Receipt report : reports) {
            allNum += report.getMoney();
            if (anyOne.containsKey(report.getUid())) {
                anyOne.put(report.getUid(), anyOne.get(report) + report.getMoney());
            } else {
                anyOne.put(report.getUid(), report.getMoney());
            }
        }
        float avg = allNum / uIds.size();
        Map<Long, Double> havgMap = new HashMap<Long, Double>();//insert
        Map<Long, Double> davgMap = new ConcurrentHashMap<Long, Double>();//out
        for (int i = 0; i < uIds.size(); i++) {
            double value = anyOne.get(uIds.get(i)) - avg;
            if (value > 0) {
                havgMap.put(uIds.get(i), value);
            } else {
                davgMap.put(uIds.get(i), value);
            }
        }
        for (Map.Entry<Long, Double> entry : havgMap.entrySet()) {
            double inmoney = entry.getValue();
            double chamoney = entry.getValue();
            for (Map.Entry<Long, Double> dentry : davgMap.entrySet()) {
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
     * @param mailContext
     * @param mails
     * @return
     */
    public boolean sendMailToConcurrentPerson(String mailContext, List<String> mails) {

        return false;

    }

    private MimeMessage createMineContext(Session session, String sendMail, String receiveMail) {
        // 1. 创建一封邮件
        MimeMessage message = new MimeMessage(session);

        // 2. From: 发件人（昵称有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改昵称）
        try {
            message.setFrom(new InternetAddress(sendMail, "某宝网", "UTF-8"));


            // 3. To: 收件人（可以增加多个收件人、抄送、密送）
            message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, "XX用户", "UTF-8"));

            // 4. Subject: 邮件主题（标题有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改标题）
            message.setSubject("打折钜惠", "UTF-8");

            // 5. Content: 邮件正文（可以使用html标签）（内容有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改发送内容）
            message.setContent("XX用户你好, 今天全场5折, 快来抢购, 错过今天再等一年。。。", "text/html;charset=UTF-8");

            // 6. 设置发件时间
            message.setSentDate(new Date());

            // 7. 保存设置
            message.saveChanges();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return message;
    }

    ;
}
