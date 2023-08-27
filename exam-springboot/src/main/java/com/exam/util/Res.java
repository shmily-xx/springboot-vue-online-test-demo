package com.exam.util;

import lombok.Data;

/**
 * @author weidie
 */
@Data
public class Res<T> {

    /**
     * 错误码，表示一种错误类型
     * ok，状态码为200
     */
    private int code;

    /**
     * 对错误代码的详细解释
     */
    private String message;

    /**
     * 返回的结果包装在value中，value可以是单个对象
     */
    private T data;

    public static <T> Res<T> success(T object) {
        Res<T> apiResult = new Res<T>();
        apiResult.setData(object);
        apiResult.setCode(200);
        apiResult.setMessage("ok");
        return apiResult;
    }

    public static Res<String> success() {
        return success(null);
    }

    public static <T> Res<T> buildApiResult(Integer code, String message, T data) {
        Res<T> apiResult = new Res<T>();
        apiResult.setCode(code);
        apiResult.setMessage(message);
        apiResult.setData(data);
        return apiResult;
    }

    public static <T> Res<T> error() {
        Res<T> apiResult = new Res<T>();
        apiResult.setData(null);
        apiResult.setCode(-1);
        apiResult.setMessage(null);
        return apiResult;
    }

    public static <T> Res<T> error(String message, T object) {
        Res<T> apiResult = new Res<T>();
        apiResult.setData(object);
        apiResult.setCode(-1);
        apiResult.setMessage(message);
        return apiResult;
    }
}
