package com.dddn.DDDnyang.config;

import com.dddn.DDDnyang.exception.Unauthorized;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        /*String accessToken = request.getParameter("accessToken");
        if(accessToken != null && accessToken.equals("validToken")) {
            return true;
        }
        throw new Unauthorized();*/
        return true;
    }

}
