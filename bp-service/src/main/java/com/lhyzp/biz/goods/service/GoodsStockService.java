package com.lhyzp.biz.goods.service;

import com.lhyzp.biz.common.BaseJPAService;
import com.lhyzp.biz.goods.model.GoodsStock;

/**
 * Created by Administrator on 2017-9-28.
 */
public interface GoodsStockService extends BaseJPAService<GoodsStock> {

    /**
     * 更新库存数量
     * @param num 减少的库存数量
     * @param id
     * @return
     */
    int updateStockAmount(Integer num, Integer id);
}
