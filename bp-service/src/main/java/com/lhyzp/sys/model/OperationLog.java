package com.lhyzp.sys.model;

import javax.persistence.*;
import java.util.Date;

/**
 * 操作日志
 * Created by Administrator on 2017-9-23.
 */
@Entity
@Table
public class OperationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length=50,nullable =false)
    private String description;//操作描述

    @Column(length=15,nullable = false)
    private String ip;

    @Column(updatable = false)
    private Date createDate;//创建日期

    @Column(length=200)
    private String params;

    @Column(length=80)
    private String method;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private SysUser user;

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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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

    public SysUser getUser() {
        return user;
    }

    public void setUser(SysUser user) {
        this.user = user;
    }
}
