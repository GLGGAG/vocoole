package com.vocoole.util;

import com.vocoole.bo.UserSessionBo;
import com.vocoole.support.Constant;
import org.springframework.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * @author GLGGAG
 * @date 2018-04-04 10:57
 * @Description:
 * 会话工具类
 */
public class SessionU {


    public static UserSessionBo loginSession(HttpServletRequest request){
        return (UserSessionBo)request.getAttribute(Constant.SESSION_KEY);
    }


}
