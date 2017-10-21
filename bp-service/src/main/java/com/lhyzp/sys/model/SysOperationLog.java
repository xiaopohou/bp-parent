package com.lhyzp.sys.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 操作日志
 * Created by Administrator on 2017-9-23.
 */
@Entity
@Table
public class SysOperationLog implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length=50,nullable =false)
    private String description;//操作描述

    @Column(length=15,nullable = false)
    private String ip;

    //一对一的关系
    @OneToOne(optional = false)//optional:是否可选,表示外键是否可以为空
    @JoinColumn(name="user_id")//指明外键的名称
    private SysUserInfo user;

    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date operationDate;//操作日期

    @Column(length=200)
    private String params;//参数

    @Column(length=80,nullable = false)
    private String method;//方法名

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public SysUserInfo getUser() {
        return user;
    }

    public void setUser(SysUserInfo user) {
        this.user = user;
    }

    public Date getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(Date operationDate) {
        this.operationDate = operationDate;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
