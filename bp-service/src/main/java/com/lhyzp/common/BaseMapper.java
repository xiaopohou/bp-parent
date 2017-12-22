package com.lhyzp.common;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 基础mapper
 * Created by zhoupeng on 2017/11/7.
 */
@Mapper
public interface BaseMapper<T> {

    //列表条件查询
    List<T> list(Map<String,Object> map);

    //根据外键查询列表
    List<T> listByFkId(Object id);

    //获取单个对象
    T getObject(Object id);

    //保存对象
    void save(T t);

    //批量新增
    void saveBatch(List<T> list);

    //更新对象
    int update(T t);

    int update(Map<String, Object> map);

    //删除数据
    int delete(Object id);

    //批量删除数据
    int deleteBatch(Object[] ids);

    int delete(Map<String, Object> map);

    //获取记录总条数
    int total();


}
