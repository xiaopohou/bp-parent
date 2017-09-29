package com.lhyzp.goods.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * 商品库存
 * Created by Administrator on 2017-9-26.
 */
@Entity
@Table
public class GoodsStock implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false,length=50)
    private String goodsName;//商品名称

    @Column(nullable = false,length = 4)
    private Integer amount;//数量

    @Column(nullable = false,length=10)
    private String version;


    //一对多，多的一方为关系维护端，关系维护端负责外间更新，关系被维护端没有权利更新外检记录
    //mappedBy = "" 关系被维护端
    @OneToMany(mappedBy = "stock",cascade = CascadeType.ALL)
    private Set<GoodsOrderItem> items;

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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Set<GoodsOrderItem> getItems() {
        return items;
    }

    public void setItems(Set<GoodsOrderItem> items) {
        this.items = items;
    }
}
