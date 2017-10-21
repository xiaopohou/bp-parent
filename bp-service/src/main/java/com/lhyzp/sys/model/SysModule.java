package com.lhyzp.sys.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 权限模块
 */
@Entity
@Table
public class SysModule implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length=20,nullable = false)
    private String name;//模块名称

    @Column(length = 50)
    private String url;//菜单url

    @Column(length = 20)
    private String icon;//图标

    @Column(nullable = false,length = 30,unique = true)
    private String permCode;//权限编码

    @Column(nullable = false,length = 11)
    private Integer parentId;//父级ID

    @Column(nullable = false)
    private Short active=1;//启用,默认启用

    @Column(nullable = false)
    private Short sortNo;//排序

    @Column(nullable = false)
    private Short permType;//权限类型  1-菜单  2-按钮  3-其他权限

    @Column(nullable = false,length=1)
    private Integer expand=0;//是否展开

    @Column(length=20)
    private String className;//类名,控制样式

    @Column(nullable = false)
    private Short bPosition=1;//位置,按钮权限位置,从1开始

    @Column(nullable = false,length=20,unique = true)
    private String code;//编码   格式：M001

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPermCode() {
        return permCode;
    }

    public void setPermCode(String permCode) {
        this.permCode = permCode;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Short getActive() {
        return active;
    }

    public void setActive(Short active) {
        this.active = active;
    }

    public Short getSortNo() {
        return sortNo;
    }

    public void setSortNo(Short sortNo) {
        this.sortNo = sortNo;
    }

    public Short getPermType() {
        return permType;
    }

    public void setPermType(Short permType) {
        this.permType = permType;
    }

    public Integer getExpand() {
        return expand;
    }

    public void setExpand(Integer expand) {
        this.expand = expand;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Short getbPosition() {
        return bPosition;
    }

    public void setbPosition(Short bPosition) {
        this.bPosition = bPosition;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}