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

    private String msg;
    private int code = 500;
    private Object exception = null;
    private Object object = null;

    public RRException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public RRException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public RRException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public RRException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }

    public void setException(Object exception) {
        this.exception = exception;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setCode(int code) {
        this.code = code;
    }
}

