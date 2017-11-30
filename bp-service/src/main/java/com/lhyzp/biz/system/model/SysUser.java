package com.lhyzp.biz.system.model;

import java.io.Serializable;
import java.util.Date;

public class SysUser implements Serializable{
    private Integer id;

    private Boolean active;

    private Date createDate;

    private String email;

    private String idCard;

    private String password;

    private String phone;

    private Date updateDate;

    private String userName;

    private Boolean valid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "id=" + id +
                ", active=" + active +
                ", createDate=" + createDate +
                ", email='" + email + '\'' +
                ", idCard='" + idCard + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", updateDate=" + updateDate +
                ", userName='" + userName + '\'' +
                ", valid=" + valid +
                '}';
    }
}