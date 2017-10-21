package com.lhyzp.sys.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 部门表
 * Created by Administrator on 2017-10-21.
 */
@Entity
public class SysDept implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false,length = 30)
    private String name;//部门名称

    @Column(nullable = false,length=10)
    private String code;//部门编码

    @Column(length=50)
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
