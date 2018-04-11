package com.twjitm.base;

import com.twjitm.answer.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 文江 on 2017/9/28.
 */
@Controller
public class BaseController {
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));    //true:允许输入空�?，false:不能为空�?
    }

    /**
     * 获取当前用户
     *
     * @param request
     * @return
     */
    @Autowired
    private HttpServletRequest request;
    @Resource
    private HttpSession session;
    private Map<String, Users> linePerson = new HashMap<String, Users>();

    /**
     * 获取当前登录用户
     *
     * @param request
     * @return
     */
    protected Users getconcurrentUser(HttpServletRequest request) {
        //System.out.println("当前session=id"+request.getSession().getId());
        Users user = (Users) session.getServletContext().getAttribute(request.getSession().getId());
        //	    	(Users) this.request.getSession().getAttribute("user");
        if (user == null) {
            //默认用户
            user = new Users();
            user.setId(0);
        }
        return user;
    }

    /**
     * 设置当前用户
     *
     * @param request
     * @param user
     */
    protected void setconcurrentUser(Users user, HttpServletRequest request) {
        request.getSession().setAttribute(request.getSession().getId(),user);
        System.out.println("当前session=id" + request.getSession().getId());
        session.getServletContext().setAttribute(request.getSession().getId(), user);
        linePerson.put(request.getSession().getId(), user);
    }

    /**
     * 移除登录用户
     *
     * @param request
     */
    protected void removeconcurrentUser(HttpServletRequest request) {
        session.getServletContext().removeAttribute(request.getSession().getId());
        linePerson.remove(request.getSession().getId());
    }

    /**
     * 获取当前在线用户数量
     *
     * @return
     */
    protected Integer getOnLineUserNumber() {
        return linePerson.size();

    }

    public Users getUser(HttpServletRequest request) {
        return getconcurrentUser(request);
    }

    protected String formatDataTostring(Date date) {

        return null;
    }
}
