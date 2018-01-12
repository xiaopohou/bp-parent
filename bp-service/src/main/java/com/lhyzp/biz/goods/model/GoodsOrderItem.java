package com.lhyzp.biz.goods.model;

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

    @Column(nullable = false,length=15)
    private String orderNumber;//订单号

    @Column(nullable = false)
    private Integer amount;//秒杀的数量

    @ManyToOne(optional = false)//optional:是否可选,表示外键是否可以为空
    @JoinColumn(name = "stock_id")//指明外键的名称
    //@JsonIgnoreProperties("items")  //注明该变量中的哪个属性不被序列化
    private GoodsStock stock;

    private Integer userId;

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

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
}
