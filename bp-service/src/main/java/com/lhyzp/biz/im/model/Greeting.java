package com.lhyzp.biz.im.model;

/**
 * 消息响应
 * Created by Administrator on 2017-11-16.
 */
public class Greeting {

    private String content;

    public Greeting() {
    }
    public Greeting(String content) {
        this.content = content;
    }
    public String getContent() {
        return content;
    }
}
