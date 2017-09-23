package com.lhyzp.sys.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 用户信息
 * Created by Administrator on 2017-9-15.
 */
@Entity
@Table
public class SysUserDetail implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 50,unique = true,nullable = false)
    private String openId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }
}
