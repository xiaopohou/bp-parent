package com.lhyzp.goods.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 商品库存
 * Created by Administrator on 2017-9-26.
 */
@Entity
@Table
public class StockGoods implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false,length=50)
    private String goodsName;//商品名称

    @Column(nullable = false,length = 4)
    private Integer amount;//数量

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
