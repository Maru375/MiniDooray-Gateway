package com.nhnacademy.minidooray.gateway.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("member") == null) {
            log.info("login required");

            response.sendRedirect("/login");
            return false;
        }
        // 로그인 되어있을 떄
        return true;
    }
}