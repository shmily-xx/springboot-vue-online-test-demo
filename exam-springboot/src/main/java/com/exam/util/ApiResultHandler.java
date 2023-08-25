package com.exam.util;

import com.exam.entity.ApiResult;

/**
 * @author weidie
 */
public class ApiResultHandler {

    public static <T> ApiResult<T> success(T object) {
        ApiResult<T> apiResult = new ApiResult<T>();
        apiResult.setData(object);
        apiResult.setCode(200);
        apiResult.setMessage("ok");
        return apiResult;
    }

    public static ApiResult<String> success() {
        return success(null);
    }

    public static <T> ApiResult<T> buildApiResult(Integer code, String message, T data) {
        ApiResult<T> apiResult = new ApiResult<T>();
        apiResult.setCode(code);
        apiResult.setMessage(message);
        apiResult.setData(data);
        return apiResult;
    }
}
