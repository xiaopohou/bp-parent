package com.lhyzp.biz.common;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018-1-12.
 */
public interface BaseJPAService<T> {

    Page<T> list(Map<String, Object> condition, Pageable pageable);

    T save(T t);

    void delete(Integer t);

    T findById(Integer t);

    void batchDelete(List<T> ids);
}
