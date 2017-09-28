package com.lhyzp.goods.service.impl;

import com.lhyzp.goods.model.GoodsOrderItem;
import com.lhyzp.goods.repository.GoodsOrderItemRepository;
import com.lhyzp.goods.service.GoodsOrderItemService;
import com.lhyzp.goods.service.GoodsStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Administrator on 2017-9-28.
 */
@Service
public class GoodsOrderItemServiceImpl implements GoodsOrderItemService{

    @Autowired
    private GoodsOrderItemRepository goodsOrderItemRepository;

    @Autowired
    private GoodsStockService goodsStockService;

    @Override
    public Page<GoodsOrderItem> list(Map<String, Object> condition, Pageable pageable) {
        return goodsOrderItemRepository.findAll(pageable);
    }

    @Transactional
    @Override
    public GoodsOrderItem save(GoodsOrderItem model) {
        int s = goodsStockService.updateStockAmount(model.getAmount(), model.getStockId());
        if(s>0){
            return goodsOrderItemRepository.save(model);
        }

        return null;
    }

    @Override
    public void delete(Integer id) {
        goodsOrderItemRepository.delete(id);
    }

    @Override
    public GoodsOrderItem findById(Integer id) {
        return goodsOrderItemRepository.findOne(id);
    }
}
