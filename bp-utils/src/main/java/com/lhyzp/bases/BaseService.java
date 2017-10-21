package com.lhyzp.bases;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

/**
 * 通用基础service
 * Created by Administrator on 2017-9-22.
 */
public interface BaseService<T> {


    /**
     * jpa 分页查询
     * @param condition
     * @param pageable
     * @return
     */
    Page<T> list(Map<String,Object> condition, Pageable pageable);

    T save(T model);

    void delete(Integer id);

    void batchDelete(Integer[] ids);

    T findById(Integer id);

}
