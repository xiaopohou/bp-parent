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
    private String name;

    @Column(nullable = false,length = 50)
    private String url;

    @Column(length = 20)
    private String icon;

    @Column(nullable = false,length = 30,unique = true)
    private String permCode;

    @Column(nullable = false,length = 11)
    private Integer pId;

    @Column(nullable = false,length=1)
    private Integer active;

    @Column(nullable = false,length=4)
    private Integer sortNo;

    @Column(nullable = false,length=4)
    private Integer permType;

    @Column(nullable = false,length=1)
    private Integer open;

    @Column(length=20)
    private String className;

    @Column(nullable = false,length=4)
    private Integer bPosition;

    @Column(nullable = false,length=1)
    private Integer fieldControl;

    @Column(nullable = false,length=30)
    private String tableName;

    @Column(nullable = false,length=20)
    private String code;

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
        this.name = name == null ? null : name.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getPermCode() {
        return permCode;
    }

    public void setPermCode(String permCode) {
        this.permCode = permCode == null ? null : permCode.trim();
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Integer getSortNo() {
        return sortNo;
    }

    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }

    public Integer getPermType() {
        return permType;
    }

    public void setPermType(Integer permType) {
        this.permType = permType;
    }

    public Integer getOpen() {
        return open;
    }

    public void setOpen(Integer open) {
        this.open = open;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    public Integer getbPosition() {
        return bPosition;
    }

    public void setbPosition(Integer bPosition) {
        this.bPosition = bPosition;
    }

    public Integer getFieldControl() {
        return fieldControl;
    }

    public void setFieldControl(Integer fieldControl) {
        this.fieldControl = fieldControl;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName == null ? null : tableName.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }
}