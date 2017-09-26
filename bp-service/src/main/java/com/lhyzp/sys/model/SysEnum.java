package com.lhyzp.sys.model;

import javax.persistence.*;

/**
 * 数据字典
 */
@Entity
@Table
public class SysEnum {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false,length=30)
    private String name;

    @Column(nullable = false,length = 30)
    private String value;

    @Column(nullable = false,length=30)
    private String parent;

    @Column(nullable = false,length=4)
    private Integer sortNo;//排序号

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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public Integer getSortNo() {
        return sortNo;
    }

    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }
}
