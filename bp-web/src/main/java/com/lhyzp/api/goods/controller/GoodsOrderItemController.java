package com.lhyzp.api.goods.controller;

import com.google.common.collect.Maps;
import com.lhyzp.base.BaseController;
import com.lhyzp.goods.model.GoodsOrderItem;
import com.lhyzp.goods.model.GoodsStock;
import com.lhyzp.goods.service.GoodsOrderItemService;
import com.lhyzp.goods.service.GoodsStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
    public String addOrUpdate(GoodsOrderItem model) throws InterruptedException {
        //检查库存数量
        GoodsStock stock = goodsStockService.findById(model.getStock().getId());
        if(stock.getAmount()<model.getAmount()){
            return error("库存数量不足");
        }
        GoodsOrderItem item = goodsOrderItemService.save(model);
        if(item==null){
            return error("秒杀失败");
        }
        return success();
    }

    @GetMapping
    public String list(@RequestParam(value="page",required = false,defaultValue = "0")Integer page,
                       @RequestParam(value="size",required = false,defaultValue = "10")Integer size,
                       @RequestParam(value="sort",required = false,defaultValue = "id")String sort,
                       @RequestParam(value="order",required = false,defaultValue = "id")String order){
        Map<String,Object> map= Maps.newHashMap();
        Page<GoodsOrderItem> list = goodsOrderItemService.list(map, new PageRequest(page,size,new Sort(sort)));
        return json(list);
    }

    @GetMapping("{id}")
    public GoodsOrderItem get(@PathVariable("id")Integer id){

        GoodsOrderItem goodsOrderItem = goodsOrderItemService.findById(id);
        return goodsOrderItem;
    }


}
