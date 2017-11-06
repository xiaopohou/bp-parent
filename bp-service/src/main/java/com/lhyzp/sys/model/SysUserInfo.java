package com.lhyzp.sys.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lhyzp.utils.DateUtils;

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
    private String userName;//姓名

    @Column(nullable = false,length=25,unique = true)
    private String email;//邮箱

    @Column(nullable = false,length=32)
    //@JsonIgnore  //标注该属性不被序列化
    private String password;

    @Column(length=11,unique = true)
    private String phone;

    @Column(length=18,unique = true)
    private String idCard;//身份证号

    @Column(nullable = false,length=1)
    private Short active=1;

    @Column(nullable=false,length=1)
    private Short valid=1;

    @Temporal(TemporalType.TIMESTAMP)//日期类型
    @Column(nullable = false,updatable = false)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(insertable = false)
    private Date updateDate;

    //用户角色 多对多
    @ManyToMany(fetch = FetchType.LAZY)//延迟加载、立即加载
    @JoinTable(name="sys_user_role",joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name="role_id",referencedColumnName = "id"))
    @JsonIgnoreProperties({"modules","remark"})  //注明该变量中的哪个属性不被序列化
    private Set<SysRole> roles;


    //一对多，多的一方为关系维护端，关系维护端负责外间更新，关系被维护端没有权利更新外检记录
    //mappedBy = "" 关系被维护端

    //用户部门 多对多
    @ManyToMany()
    @JoinTable(name="sys_user_dept",joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name="dept_id",referencedColumnName = "id"))
    @JsonIgnoreProperties("remark")
    private Set<SysDept> depts;

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

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
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

    public Set<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<SysRole> roles) {
        this.roles = roles;
    }

    public Set<SysDept> getDepts() {
        return depts;
    }

    public void setDepts(Set<SysDept> depts) {
        this.depts = depts;
    }

    @Override
    public String toString() {
        return "id="+this.id;
    }
}
