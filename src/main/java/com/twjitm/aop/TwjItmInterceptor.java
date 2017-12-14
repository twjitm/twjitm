package com.twjitm.aop;


import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by twjitm on 2017/8/26.
 * spring拦截器
 */
public class TwjItmInterceptor implements HandlerInterceptor {
    private Logger logger = Logger.getLogger(TwjItmInterceptor.class);

    /**
     * 该方法将在请求处理之前进行调用，只有该方法返回true，才会继续执行后续的Interceptor和Controller，当返回值为true 时就会继续调用下一个Interceptor的preHandle
     * 方法，如果已经是最后一个Interceptor的时候就会是调用当前请求的Controller方法
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    public boolean preHandle(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object handler) throws Exception {
        String servletPath = request.getServletPath();
        if (servletPath.indexOf(".") < 0) {
            return false;
        }
        String type = servletPath.split("\\.")[1];
        logger.info("！！！！！这个是我的如部署文件啦");
        logger.info(type);
        if (type.equals(RequestEndType.DO_REQ)) {
            String sessionId = request.getSession().getId();
            Object object = request.getSession().getAttribute(sessionId);
            if (object == null) {//未登录
                response.sendRedirect("/");
                return false;
            }
            //前台请求
            request.setAttribute("reqType", (RequestEndType.DO_REQ));
        } else if (type.equals(RequestEndType.JSON_REQ)) {
            //后台服务器请求
            request.setAttribute("reqType", (RequestEndType.JSON_REQ));
        }
        return true;
    }

    /**
     * 该方法将在请求处理之后，DispatcherServlet进行视图返回渲染之前进行调用，
     * 可以在这个方法中对Controller 处理之后的ModelAndView 对象进行操作。
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    public void postHandle(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 该方法也是需要当前对应的Interceptor的preHandle方法的返回值为true时才会执行，该方法将在整个请求结束之后，也就是在DispatcherServlet
     * 渲染了对应的视图之后执行。用于进行资源清理
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    public void afterCompletion(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
