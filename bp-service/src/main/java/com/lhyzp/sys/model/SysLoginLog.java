package com.lhyzp.sys.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 登录日志
 * Created by Administrator on 2017-10-21.
 */
@Entity
public class SysLoginLog implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne(optional = false)
    @JoinColumn(name="user_id")
    private SysUserInfo user;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false,updatable = false)
    private Date loginDate;//登录日期

    @Column(nullable = false,length = 15)
    private String ip;

    @Column(nullable = false)
    private Short success;//是否登录成功

    @Column(length=30)
    private String remark;//备注

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SysUserInfo getUser() {
        return user;
    }

    public void setUser(SysUserInfo user) {
        this.user = user;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Short getSuccess() {
        return success;
    }

    public void setSuccess(Short success) {
        this.success = success;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
