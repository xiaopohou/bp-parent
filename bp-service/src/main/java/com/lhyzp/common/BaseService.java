package com.lhyzp.common;

import java.util.List;
import java.util.Map;

/**
 * 基础service -- mybatis版
 * Created by zhoupeng on 2017/11/7.
 */
public interface BaseService<T> {
    /**
     * 列表条件查询
     * @param map
     * @return
     */
    List<T> list(Map<String,Object> map);

    /**
     * 根据外键查询列表
     * @param id
     * @return
     */
    List<T> listByFkId(Object id);

    /**
     * 获取单个对象
     * @param id
     * @return
     */
    T getObject(Object id);

    /**
     * 保存对象
     * @param t
     */
    void save(T t);

    /**
     * 批量新增
     * @param list
     */
    void saveBatch(List<T> list);

    /**
     * 更新对象
     * @param t
     * @return
     */
    int update(T t);

    /**
     * 删除数据
     * @param id
     * @return
     */
    int delete(Object id);

    /**
     * 批量删除数据
     * @param id
     * @return
     */
    int deleteBatch(Object[] ids);

    /**
     * 获取记录总条数
     * @return
     */
    int total();
}
