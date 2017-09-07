package com.lhyzp.base;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017-9-4.
 */
public abstract class BaseServiceImpl<T> implements BaseService<T>{

    @Override
    public List<T> list(Map<String, Object> map) {
        return null;
    }

    @Override
    public T getObject(Long id) {
        return null;
    }

    @Override
    public void save(T model) {

    }

    @Override
    public void update(T model) {

    }

    @Override
    public void delete(Long id) {

    }
}
