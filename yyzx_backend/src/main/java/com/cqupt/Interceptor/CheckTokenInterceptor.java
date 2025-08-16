package com.cqupt.Interceptor;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class CheckTokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if(request.getMethod().equalsIgnoreCase("OPTIONS")){
            return true;
        }

        if(request.getRequestURI().contains("/images")){
            return true;
        }

        String token = request.getHeader("token");
        if(token == null){
            throw new RuntimeException("token is null");
        }else{
            JwtParser parser = Jwts.parser();
            parser.setSigningKey("cqupt123456");
            Jws<Claims> claimsJws = parser.parseClaimsJws(token);
        }

        return true;
    }
}
