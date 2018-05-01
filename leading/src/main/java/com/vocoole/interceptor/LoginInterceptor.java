package com.vocoole.interceptor;

import com.vocoole.util.SessionU;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author GLGGAG
 * @date 2018-04-04 10:53
 * @Description:
 * 登录拦截器
 *
 * 目前版本实现本机session存储
 * 后期实现连接 momecahe存储
 */
public class LoginInterceptor implements HandlerInterceptor{

    /**
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        StringBuffer requestURL = request.getRequestURL();
        return requestURL.toString().lastIndexOf("login.html") != -1 &&  SessionU.loginSession(request) != null;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
