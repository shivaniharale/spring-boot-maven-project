package com.example.employeepayroll.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        boolean auth=false;
        final String authHeaderValue=request.getHeader("Authorization");

        if(authHeaderValue !=null && authHeaderValue.startsWith("Bearer")){
            auth=true;
        }
        else {
            throw new AuthenticationException("Authentication exception");
        }

        return true;
    }
}
