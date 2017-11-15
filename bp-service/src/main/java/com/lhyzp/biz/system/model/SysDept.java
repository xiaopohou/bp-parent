package com.lhyzp.biz.system.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 部门表
 * Created by Administrator on 2017-10-21.
 */
public class SysDept implements Serializable{

    private Integer id;

    private String name;//部门名称

    private String code;//部门编码

    private String remark;//备注

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
