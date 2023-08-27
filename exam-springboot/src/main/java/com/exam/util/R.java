package com.exam.util;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据
 *
 * @see
 * @see
 */
@ApiModel(value = "R接口结果集")
public class R<T> extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "code : 返回代码，0表示OK，其它的都有对应问题")
    private int code = 0;

    @ApiModelProperty(value = "message : 如果code!=1,错误信息")
    private String message = "未知异常，请联系管理员";

    @ApiModelProperty(value = "如果code!=0,message的补充信息")
    private Object exception;

    @SuppressWarnings("unchecked")
    @ApiModelProperty(value = "code为1时返回结果集")
    private T data = (T) new Object();

    public R() {
        setCode(0);
    }

    public static <T> R error() {
        return error(500, "未知异常，请联系管理员");
    }

    public static <T> R error(String message) {
        return error(500, message);
    }

    public static <T> R error(Exception exception) {
        R r = error();
        r.setException(exception);
        return r;
    }

    public static <T> R error(int code, String message) {
        R<T> r = new R<T>();
        r.setCode(code);
        r.setMsg(message);
        return r;
    }

    public static <T> R ok(String message) {
        R<T> r = new R<T>();
        r.setMsg(message);
        return r;
    }

    public static <T> R ok(Map<String, Object> map) {
        R<T> r = new R<T>();
        r.putAll(map);
        return r;
    }

    public static <T> R ok() {
        return new R<T>();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
        this.put("code", code);
    }

    public String getMsg() {
        return message;
    }

    public void setMsg(String message) {
        this.message = message;
        this.put("message", message);
    }

    public Object getException() {
        return exception;
    }

    public void setException(Object exception) {
        this.exception = exception;
        this.put("exception", exception);
    }

    public T getData() {
        return data;
    }

    public R<T> setData(T data) {
        this.data = data;
        this.put("data", data);
        return this;
    }
}
