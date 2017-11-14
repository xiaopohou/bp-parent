package com.lhyzp.biz.im.model;

/**
 * 后台响应消息实体
 * Created by Administrator on 2017-11-14.
 */
public class WiselyResponse {
    private String responseMessage;


    public WiselyResponse(String responseMessage) {
        this.responseMessage=responseMessage;
    }

    public WiselyResponse() {
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
