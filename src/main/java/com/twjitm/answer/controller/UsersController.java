package com.twjitm.answer.controller;

import com.twjitm.answer.entity.AnswerVo;
import com.twjitm.answer.entity.Users;
import com.twjitm.answer.enums.Qtypes;
import com.twjitm.answer.service.AnswerService;
import com.twjitm.answer.service.IUsersService;
import com.twjitm.base.BaseController;
import com.twjitm.user.entity.User;
import com.twjitm.user.service.IUserService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/26.
 */
@Controller
@RequestMapping("/users")
public class UsersController extends BaseController {
    private static final Logger logger = LogManager.getLogger(UsersController.class.getName());
    @Resource
    public AnswerService answerService;
    @Autowired
    public IUsersService userService;

    @RequestMapping("info")
    public List userInfor(HttpServletRequest request) {
        logger.info("进入这个方法了");
        return userService.getUser();
    }

    @RequestMapping("login")
    @ResponseBody
    public String login(HttpServletRequest request, String userName, String userPsd) {
        List<AnswerVo> list = new ArrayList<AnswerVo>();
        AnswerVo answerVo = new AnswerVo();
        answerVo.setType(Qtypes.TYPE_CHOICES.getValue());
        answerVo.setNumber(2);
        answerVo.setScore(2);
        list.add(answerVo);
        answerService.combination("title", list);
        Users user = userService.login(userName, userPsd);
        if (user != null) {
            setconcurrentUser(user, request);
            return "success";
        }
        return "error";
    }

    @RequestMapping("register")
    public String register(HttpServletRequest request, Users user) {
        userService.register(user);
        return "/login/register";
    }

    @RequestMapping("index")
    public String index(HttpServletRequest request) {
        return "/answer/aindex";

    }

}
