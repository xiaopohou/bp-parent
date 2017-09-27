package com.lhyzp.sys.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * 用户表
 * Created by zhoupeng on 2017/9/27.
 */
@Entity
@Table
public class SysUserInfo implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false,length=30)
    private String userName;

    @Column(nullable = false,length=25,unique = true)
    private String email;

    @Column(nullable = false,length=32)
    private String password;

    @Column(length=11,unique = true)
    private String phone;

    @Column(nullable = false,length=1)
    private Short active=1;

    @Column(nullable=false,length=1)
    private Short valid=1;

    @Temporal(TemporalType.TIMESTAMP)//日期类型
    @Column(nullable = false,updatable = false)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false,insertable = false)
    private Date updateDate;

    @ManyToMany(fetch = FetchType.LAZY)//延迟加载、立即加载
    @JoinTable(name="sys_user_role",joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name="role_id",referencedColumnName = "id"))
    private Set<SysRoleInfo> roles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Short getActive() {
        return active;
    }

    public void setActive(Short active) {
        this.active = active;
    }

    public Short getValid() {
        return valid;
    }

    public void setValid(Short valid) {
        this.valid = valid;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Set<SysRoleInfo> getRoles() {
        return roles;
    }

    public void setRoles(Set<SysRoleInfo> roles) {
        this.roles = roles;
    }
}
