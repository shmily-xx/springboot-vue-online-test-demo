package com.exam.util;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * 自定义异常
 *
 * @author weidie
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class RRException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private String message;
    private int code = -1;
    private Object exception = null;
    private Object object = null;

    public RRException(String message) {
        super(message);
        this.message = message;
    }

    public RRException(String message, Throwable e) {
        super(message, e);
        this.message = message;
    }

    public RRException(String message, int code) {
        super(message);
        this.message = message;
        this.code = code;
    }

    public RRException(String message, int code, Throwable e) {
        super(message, e);
        this.message = message;
        this.code = code;
    }
}

