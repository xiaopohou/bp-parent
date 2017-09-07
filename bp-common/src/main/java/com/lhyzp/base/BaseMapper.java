package com.lhyzp.base;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017-9-4.
 */
public interface BaseMapper<T> {

    List<T> list(Map<String,Object> map);

    T getObject(Long id);

    void save(T model);

    void update(T model);

    void delete(Long id);

}
