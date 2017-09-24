package com.twjitm.user.controller;

import com.twjitm.user.service.IUserService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
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
    private static final Logger logger = LogManager.getLogger(UserController.class.getName());

    @Autowired
    public IUserService userService;

    @RequestMapping("info")
    public List userInfor(HttpServletRequest request) {
        logger.info("进入这个方法了");
        return userService.getUser();
    }
}
