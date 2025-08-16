package com.cqupt.handler;

import com.cqupt.utils.ResultVo;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    //定义异常处理方法,统一返回异常
    //SignatureException.class token非法异常
    @ExceptionHandler(SignatureException.class)
    @ResponseBody
    public ResultVo SignatureExceptionHandler(SignatureException e) {
        return ResultVo.fail("token的非法异常","token_error");
    }

    //MalformedJwtException.class token格式错误异常
    @ExceptionHandler(MalformedJwtException.class)
    @ResponseBody
    public ResultVo MalformedJwtExceptionHandler(MalformedJwtException e) {
        return ResultVo.fail("token的解析异常","token_error");
    }
    //ExpiredJwtException.class token过期异常
    @ExceptionHandler(ExpiredJwtException.class)
    @ResponseBody
    public ResultVo ExpiredJwtExceptionHandler(ExpiredJwtException e) {
        return ResultVo.fail("登录超时，请重新登录", "token_error");
    }

    //统一处理其他异常
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultVo ExceptionHandler(Exception e) {
        if (e.getMessage().contains("token")) {
            return ResultVo.fail(e.getMessage(), "token_error");
        }
        return ResultVo.fail(e.getMessage());
    }

}
