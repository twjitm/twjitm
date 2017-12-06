//package com.twjitm.user.controller;
//
//import com.twjitm.answer.entity.Users;
//import com.twjitm.answer.service.IUsersService;
//import com.twjitm.base.BaseController;
//import com.twjitm.user.entity.User;
//import com.twjitm.user.service.IUserService;
//import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.List;
//
///**
// * Created by Administrator on 2017/8/26.
// */
//@Controller
//@RequestMapping("/user")
//public class UserController extends BaseController {
//    private static final Logger logger = LogManager.getLogger(UserController.class.getName());
//
//    @Autowired
//    public IUsersService usersService;
//
//    @RequestMapping("info")
//    public List userInfor(HttpServletRequest request) {
//        logger.info("进入这个方法了");
//        return usersService.getUser();
//    }
//
//    @RequestMapping("login")
//    @ResponseBody
//    public String login(HttpServletRequest request, String userName, String userPsd) {
//        Users user = usersService.login(userName, userPsd);
//        if (user != null) {
//            setconcurrentUser(user, request);
//            return "success";
//        }
//        return "error";
//    }
//
//    @RequestMapping("register")
//    public String register(HttpServletRequest request, Users user) {
//        usersService.register(user);
//        return "/login/register";
//    }
//
//    @RequestMapping("index")
//    public String index(HttpServletRequest request) {
//        return "/chat";
//
//    }
//
//}
