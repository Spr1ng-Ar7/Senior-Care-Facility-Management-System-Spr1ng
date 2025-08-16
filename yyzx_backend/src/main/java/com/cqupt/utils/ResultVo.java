package com.cqupt.utils;

import lombok.Data;

@Data
public class ResultVo <T>{
    private boolean flag;
    private String message;
    private T data;

    //成功添加message
    public static ResultVo ok(String message) {
        ResultVo resultVo = new ResultVo();
        resultVo.setFlag(true);
        resultVo.setMessage(message);
        return resultVo;
    }
    //成功添加data
    public static <T>ResultVo ok(T data) {
        ResultVo resultVo = new ResultVo();
        resultVo.setFlag(true);
        resultVo.setData(data);
        return resultVo;
    }

    //成功添加message和data
    public static <T>ResultVo ok( T data,String message) {
        ResultVo resultVo = new ResultVo();
        resultVo.setFlag(true);
        resultVo.setMessage(message);
        resultVo.setData(data);
        return resultVo;
    }
    //失败添加message
    public static ResultVo error(String message) {
        ResultVo resultVo = new ResultVo();
        resultVo.setFlag(false);
        resultVo.setMessage(message);
        return resultVo;
    }
    //失败添加data
    public static <T>ResultVo fail(T data) {
        ResultVo resultVo = new ResultVo();
        resultVo.setFlag(false);
        resultVo.setData(data);
        return resultVo;
    }
    //失败添加message和data
    public static <T>ResultVo fail( T data,String message) {
        ResultVo resultVo = new ResultVo();
        resultVo.setFlag(false);
        resultVo.setMessage(message);
        resultVo.setData(data);
        return resultVo;
    }
    //异常
    public static ResultVo fail(Exception e) {
        ResultVo resultVo = new ResultVo();
        resultVo.setFlag(false);
        resultVo.setMessage("系统发生了异常："+e.getMessage());
        return resultVo;
    }
}
