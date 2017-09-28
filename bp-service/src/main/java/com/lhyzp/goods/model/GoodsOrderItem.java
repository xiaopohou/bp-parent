package com.lhyzp.goods.model;

import com.lhyzp.sys.model.SysUserInfo;
import org.omg.CORBA.PRIVATE_MEMBER;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 用户秒杀订单记录
 * Created by Administrator on 2017-9-26.
 */
@Entity
@Table
public class GoodsOrderItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private Integer amount;//秒杀的数量

    @Transient
    private Integer stockId;

    @Transient
    private Integer userId;

    @ManyToOne(optional = false)//optional:是否可选,表示外键是否可以为空
    @JoinColumn(name = "stock_id")//指明外键的名称
    private GoodsStock stock;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private SysUserInfo user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public GoodsStock getStock() {
        return stock;
    }

    public void setStock(GoodsStock stock) {
        this.stock = stock;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getStockId() {
        return stockId;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    public SysUserInfo getUser() {
        return user;
    }

    public void setUser(SysUserInfo user) {
        this.user = user;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
