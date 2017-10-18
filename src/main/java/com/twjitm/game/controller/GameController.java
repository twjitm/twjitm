package com.twjitm.game.controller;

import com.twjitm.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 文江 on 2017/10/18.
 */
@Controller
@RequestMapping("game")
public class GameController extends BaseController {

    @RequestMapping("into")
    public String into(HttpServletRequest request) {
        request.setAttribute("user", getconcurrentUser(request));
        return "game/frame/gameCore";
    }

    @RequestMapping("gobang")
    public String intoGobangView(HttpServletRequest request) {
        return "/game/gobang/gobang";
    }
}
