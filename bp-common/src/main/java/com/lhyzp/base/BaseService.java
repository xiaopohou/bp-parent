package com.lhyzp.base;

import java.util.List;
import java.util.Map;

/**
 * 基础service
 * Created by zp on 2017-7-27.
 */
public interface BaseService<T> {

    List<T> list(Map<String,Object> map);

    T getObject(Long id);

    void save(T model);

    void update(T model);

    void delete(Long id);

}
