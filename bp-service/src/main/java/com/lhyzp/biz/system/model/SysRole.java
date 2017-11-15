package com.lhyzp.biz.system.model;


import java.io.Serializable;

/**
 * 角色表
 */
public class SysRole implements Serializable{

    private Integer id;

    private String name;//角色名称

    private String remark;//备注描述

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
