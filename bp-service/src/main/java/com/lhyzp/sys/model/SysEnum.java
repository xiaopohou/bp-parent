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
}