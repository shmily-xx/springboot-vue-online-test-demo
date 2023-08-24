package com.exam.entity;

import lombok.Data;

/**
 * @author weidie
 */
@Data
public class ApiResult<T> {
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

}
