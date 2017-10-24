package com.twjitm.receipt.controller;

import com.twjitm.aop.RequestEndType;
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
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
    public ModelAndView init(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        String type = (String) request.getAttribute("reqType");

        List<Receipt> list = receiptService.getReceiptByState(ReceiptStateType.DOING);
        logger.info("list" + list.size());
        List<User> userList = userService.getUser();
        request.setAttribute("userList", userList);
        request.setAttribute("list", list);
        if (type.equals(RequestEndType.DO_REQ)) {
            modelAndView.setViewName("/receipt/list");
        } else {
            modelAndView.addObject("user", userList);
        }
        modelAndView.setViewName("");
        return modelAndView;
    }

    @RequestMapping("equzlize")
    @ResponseBody
    public List<Equzlize> equzlize(HttpServletRequest request, List<Integer> uIds, List<Integer> eqIds) {
        List<Receipt> list = receiptService.getReceiptByState(ReceiptStateType.DOING);
        List<Equzlize> equzlizes = receiptService.getEquzlizeList(list, uIds);
        request.setAttribute("equzlizes", equzlizes);
        return equzlizes;
    }
}
