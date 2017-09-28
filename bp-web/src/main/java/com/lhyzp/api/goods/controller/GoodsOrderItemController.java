package com.lhyzp.api.goods.controller;

import com.lhyzp.commons.base.BaseController;
import com.lhyzp.goods.model.GoodsOrderItem;
import com.lhyzp.goods.model.GoodsStock;
import com.lhyzp.goods.service.GoodsOrderItemService;
import com.lhyzp.goods.service.GoodsStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017-9-28.
 */
@RestController
@RequestMapping("api/goods/order")
public class GoodsOrderItemController extends BaseController{

    @Autowired
    private GoodsStockService goodsStockService;

    @Autowired
    private GoodsOrderItemService goodsOrderItemService;

    @PostMapping
    public String addOrUpdate(@RequestBody  GoodsOrderItem model) throws InterruptedException {

        Thread.sleep(1000);//模拟网络延时

        //检查库存数量
        GoodsStock stock = goodsStockService.findById(model.getStockId());
        if(stock.getAmount()<model.getAmount()){
            return error("库存数量不足");
        }
        goodsOrderItemService.save(model);
        return success();
    }



}