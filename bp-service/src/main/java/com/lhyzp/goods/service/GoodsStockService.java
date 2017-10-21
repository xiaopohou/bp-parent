package com.lhyzp.goods.service;

import com.lhyzp.bases.BaseService;
import com.lhyzp.goods.model.GoodsStock;

/**
 * Created by Administrator on 2017-9-28.
 */
public interface GoodsStockService extends BaseService<GoodsStock>{

    /**
     * 更新库存数量
     * @param num 减少的库存数量
     * @param id
     * @return
     */
    int updateStockAmount(Integer num, Integer id);
}
