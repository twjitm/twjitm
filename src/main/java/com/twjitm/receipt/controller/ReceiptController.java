package com.twjitm.receipt.controller;

import com.twjitm.receipt.entity.Equzlize;
import com.twjitm.receipt.entity.Receipt;
import com.twjitm.receipt.enums.ReceiptStateType;
import com.twjitm.receipt.service.IReceiptService;
import com.twjitm.user.entity.User;
import com.twjitm.user.service.IUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/9.
 */
@Controller
@RequestMapping("receipt")
public class ReceiptController {
    private Logger logger = LogManager.getLogger(ReceiptController.class);
    @Resource
    public IReceiptService receiptService;
    @Resource
    public IUserService userService;

    @RequestMapping("init")
    public String init(HttpServletRequest request) {
        List<Receipt> list = receiptService.getReceiptByState(ReceiptStateType.DOING);
        logger.info("list" + list.size());

        request.setAttribute("list", list);
        return "/receipt/list";
    }

    @RequestMapping("equzlize")
    @ResponseBody
    public List<Equzlize> equzlize(HttpServletRequest request) {
        List<Receipt> list = receiptService.getReceiptByState(ReceiptStateType.DOING);
        List<User> users = userService.getUser();
        List<Long> uIds = new ArrayList<Long>();
        for (int i = 0; i < users.size(); i++) {
            uIds.add(users.get(i).getId());
        }
        List<Equzlize> equzlizes = receiptService.getEquzlizeList(list, uIds);
        request.setAttribute("equzlizes", equzlizes);
        return equzlizes;
    }
}
