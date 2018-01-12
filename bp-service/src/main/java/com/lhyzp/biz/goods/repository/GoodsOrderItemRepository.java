package com.lhyzp.biz.goods.repository;

import com.lhyzp.biz.goods.model.GoodsOrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017-9-28.
 */
@Repository
public interface GoodsOrderItemRepository extends JpaRepository<GoodsOrderItem,Integer>,JpaSpecificationExecutor<GoodsOrderItem>{
}
