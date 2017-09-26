package com.lhyzp.goods.model;

import com.lhyzp.sys.model.SysUser;

import javax.persistence.*;

/**
 * 用户秒杀记录
 * Created by Administrator on 2017-9-26.
 */
@Entity
@Table
public class SecKillOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false,length=4)
    private Integer amount;//秒杀的数量

    @Column(nullable = false,length=10)
    private String version;

    @ManyToOne
    @JoinColumn(name = "stock_id")
    private StockGoods stock;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private SysUser user;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public StockGoods getStock() {
        return stock;
    }

    public void setStock(StockGoods stock) {
        this.stock = stock;
    }

    public SysUser getUser() {
        return user;
    }

    public void setUser(SysUser user) {
        this.user = user;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
