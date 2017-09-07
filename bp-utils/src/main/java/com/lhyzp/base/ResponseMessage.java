package com.lhyzp.base;

import java.io.Serializable;

/**
 * 响应消息体
 * Created by Administrator on 2017-9-7.
 */
public class ResponseMessage implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 状态码
     */
    private Integer code;
    //提示消息
    private String message;
    //错误信息
    private String error;
    //结果集
    private Object data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ResponseMessage() {
    }

    public ResponseMessage(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseMessage(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResponseMessage(Integer code, String message, String error, Object data) {
        this.code = code;
        this.message = message;
        this.error = error;
        this.data = data;
    }
}
