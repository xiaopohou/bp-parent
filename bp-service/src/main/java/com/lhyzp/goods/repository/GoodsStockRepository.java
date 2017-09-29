package com.lhyzp.goods.repository;

import com.lhyzp.goods.model.GoodsStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017-9-28.
 */
@Repository
public interface GoodsStockRepository extends JpaRepository<GoodsStock,Integer>,JpaSpecificationExecutor<GoodsStock>{


    /**
     * 更新库存数量
     * @param num 减少的库存数量
     * @param id
     * @return
     */
    @Query("update GoodsStock s set s.amount=s.amount-:num where s.id=:id and s.amount>:num")
    @Modifying(clearAutomatically = true)
    int updateStockAmount(@Param("num")Integer num,@Param("id")Integer id);

}
