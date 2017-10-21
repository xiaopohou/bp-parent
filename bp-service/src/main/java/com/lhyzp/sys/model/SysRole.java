package com.lhyzp.sys.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * 角色表
 */
@Entity
@Table
public class SysRole implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false,length=20)
    private String name;//角色名称

    @Column(length=50)
    private String remark;//备注描述

    @ManyToMany()
    @JoinTable(name="sys_role_module",joinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name="module_id",referencedColumnName = "id"))
    @JsonIgnore //标注该属性不被序列化
    private Set<SysModule> modules;

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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Set<SysModule> getModules() {
        return modules;
    }

    public void setModules(Set<SysModule> modules) {
        this.modules = modules;
    }
}
