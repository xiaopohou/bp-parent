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
    private String user_name;

    @Column(nullable = false,length=30,unique = true)
    private String email;

    @Column(nullable = false,length=32)
    private String password;

    @Column(nullable = false,length=1,columnDefinition = "int(1) default 1")
    private Integer active;

    @Column(nullable = false,length=1,columnDefinition = "int(1) default 1")
    private Integer state;

    @Column(nullable = false,length=11)
    private String phone;

    @Column(nullable = false,updatable = false)
    private Integer createUser;

    @Column(nullable = false,updatable = false)
    private Date createDate;

    @Column(insertable = false)
    private Integer updateUser;

    @Column(insertable = false)
    private Date updateDate;


    @OneToMany(cascade = CascadeType.ALL)
    private List<SysRole> role;

    public List<SysRole> getRole() {
        return role;
    }

    public void setRole(List<SysRole> role) {
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
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
}
