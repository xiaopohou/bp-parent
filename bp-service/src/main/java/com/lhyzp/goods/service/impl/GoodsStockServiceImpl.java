package com.lhyzp.goods.service.impl;

import com.lhyzp.goods.model.GoodsStock;
import com.lhyzp.goods.repository.GoodsStockRepository;
import com.lhyzp.goods.service.GoodsStockService;
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
public class GoodsStockServiceImpl implements GoodsStockService{

    @Autowired
    private GoodsStockRepository goodsStockRepository;

    @Override
    public Page<GoodsStock> list(Map<String, Object> condition, Pageable pageable) {

        return goodsStockRepository.findAll(pageable);
    }

    @Override
    public GoodsStock save(GoodsStock model) {
        return goodsStockRepository.save(model);
    }

    @Override
    public void delete(Integer id) {
        goodsStockRepository.delete(id);
    }

    @Override
    public void batchDelete(List<GoodsStock> ids) {

    }

    @Override
    public GoodsStock findById(Integer id) {
        return goodsStockRepository.findOne(id);
    }

    @Transactional
    @Override
    public int updateStockAmount(Integer num, Integer id) {
        return goodsStockRepository.updateStockAmount(num,id);
    }
}
