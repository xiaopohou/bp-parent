package com.lhyzp.biz.goods.service.impl;

import com.lhyzp.biz.goods.model.GoodsOrderItem;
import com.lhyzp.biz.goods.repository.GoodsOrderItemRepository;
import com.lhyzp.biz.goods.service.GoodsOrderItemService;
import com.lhyzp.biz.goods.service.GoodsStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017-9-28.
 */
@Service
public class GoodsOrderItemServiceImpl implements GoodsOrderItemService {

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
        int s = goodsStockService.updateStockAmount(model.getAmount(), model.getStock().getId());
        if(s>0){
            model.setOrderNumber(String.valueOf(System.currentTimeMillis()));
            return goodsOrderItemRepository.save(model);
        }

        return null;
    }

    @Override
    public void delete(Integer id) {
        goodsOrderItemRepository.delete(id);
    }

    @Override
    public void batchDelete(List<GoodsOrderItem> ids) {

    }

    @Override
    public GoodsOrderItem findById(Integer id) {
        return goodsOrderItemRepository.findOne(id);
    }
}
