package com.twjitm.user.controller;

import com.twjitm.user.service.IUserService;
import com.twjitm.utils.IpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2017/8/26.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    public IUserService userService;

    @RequestMapping("info")
    public List userInfor(HttpServletRequest request) {
        System.out.println("----------------------------------------------");
        System.out.println("Ip=" + IpUtils.getClientIP(request));
        return userService.getUser();
    }
}
