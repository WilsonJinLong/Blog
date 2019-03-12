package com.fleam.serviceauth.interceptor;

import com.fleam.serviceauth.util.ResponseData;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

//全局异常拦截
@ControllerAdvice
public class ErrorIntercept {

    /**
     * 拦截所有运行时的全局异常
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResponseData defaultExceptionHandler(){
        ResponseData responseData = ResponseData.badRequest();
        return responseData;
    }


}

