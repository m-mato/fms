package com.mmajdis.fms.controller.interceptor;

import com.mmajdis.fms.Utils.FMSHeader;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token = request.getHeader(FMSHeader.X_FMS_TOKEN.getName());

        if (token != null && token.equals("validTokenMock")) {
            return true;
        } else {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            return false;
        }
    }
}
