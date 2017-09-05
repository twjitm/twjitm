package com.twjitm.user.controller;

import com.twjitm.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
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
    public List userInfor(){
        System.out.println("----------------------------------------------");
        System.out.println( userService.getUser().size());
        return userService.getUser();
    }
}
