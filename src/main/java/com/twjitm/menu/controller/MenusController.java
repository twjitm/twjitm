package com.twjitm.menu.controller;

import com.twjitm.base.BaseController;
import com.twjitm.menu.entity.Menu;
import com.twjitm.menu.service.IMenuService;
import com.twjitm.user.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RequestMapping("menu")
@Controller
public class MenusController extends BaseController {
    @Resource
    private IMenuService menuService;

    /**
     * 菜单控制权限
     *
     * @param request
     * @return
     */
    @RequestMapping("menus")
    @ResponseBody
    public List<Menu> list(HttpServletRequest request) {
      /*  User user = getconcurrentUser(request);
        if (user == null) {
            user = new User();
            user.setRole("3");
        }*/
        List<Menu> menus = menuService.getMenuByuserType(Integer.parseInt("3"));
        return menus;
    }
}
