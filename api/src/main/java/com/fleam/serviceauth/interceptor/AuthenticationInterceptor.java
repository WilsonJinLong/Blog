package com.fleam.serviceauth.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.fleam.serviceauth.annotation.CheckToken;
import com.fleam.serviceauth.annotation.LoginToken;
import com.fleam.serviceauth.service.IUserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;


/**
 * 实现HandlerInterceptor接口
 */
public class AuthenticationInterceptor implements HandlerInterceptor {


    @Autowired
    private IUserService userService;

    /**
     * 拦截LoginToken和CheckToken注解
     * @param httpServletRequest
     * @param httpServletResponse
     * @param object
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {

        //todo 判断哪些url可以跨域
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");

        //headerToken
        String token = httpServletRequest.getHeader("token");

        //HandlerMethod
        if (!(object instanceof HandlerMethod)) {
            return true;
        }

        //LoginToken
        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();
        if (method.isAnnotationPresent(LoginToken.class)) {
            LoginToken loginToken = method.getAnnotation(LoginToken.class);
            if (loginToken.required()) {
                return true;
            }
        }

        //CheckToken
        if (method.isAnnotationPresent(CheckToken.class)) {
            CheckToken checkToken = method.getAnnotation(CheckToken.class);
            if (checkToken.required()) {
                if (token == null) {
                    throw new RuntimeException("令牌错误");
                }
                try {
                    Claims claims = Jwts.parser().setSigningKey("fleam").parseClaimsJws(token).getBody();
                } catch (JWTDecodeException j) {
                    throw new RuntimeException("访问异常");
                }
                return true;
            }
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }


}
