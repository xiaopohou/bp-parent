package com.lhyzp.biz.im.model;

import java.util.List;

/**
 * 接收前端消息实体
 * Created by Administrator on 2017-11-14.
 */
public class WiselyMessage {

    private String content;

    private List<String> users;

    public List<String> getUsers() {
        return users;
    }

    public void setUsers(List<String> users) {
        this.users = users;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
