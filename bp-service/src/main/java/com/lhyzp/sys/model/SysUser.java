package com.lhyzp.sys.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 系统用户
 */
@Entity
@Table
public class SysUser implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false,length=30)
    private String userName;

    @Column(nullable = false,length=30,unique = true)
    private String email;

    @Column(nullable = false,length=32)
    private String password;

    @Column(nullable = false,length=1,columnDefinition = "int(1) default 1")
    private Integer active;

    @Column(nullable = false,length=1,columnDefinition = "int(1) default 1")
    private Integer state;

    @Column(nullable = false,length=11,unique = true)
    private String phone;

    @Column(nullable = false,updatable = false)
    private Integer createUser;

    @Column(nullable = false,updatable = false)
    private Date createDate;

    @Column(insertable = false)
    private Integer updateUser;

    @Column(insertable = false)
    private Date updateDate;


    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "sys_user_role", joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private List<SysRole> roles;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_detail_id")
    private SysUserDetail userDetail;

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }

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

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public SysUserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(SysUserDetail userDetail) {
        this.userDetail = userDetail;
    }
}
