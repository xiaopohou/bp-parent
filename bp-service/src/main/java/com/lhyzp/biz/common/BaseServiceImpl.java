package com.lhyzp.biz.common;

import com.lhyzp.common.base.BaseMapper;
import com.lhyzp.common.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * 基础service实现类
 * Created by zhoupeng on 2017/11/7.
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {

    @Autowired
    private BaseMapper<T> baseMapper;

    /**
     * 列表条件查询
     *
     * @param map
     * @return
     */
    @Override
    public List<T> list(Map<String, Object> map) {
        return baseMapper.list(map);
    }

    /**
     * 根据外键查询列表
     *
     * @param id
     * @return
     */
    @Override
    public List<T> listByFkId(Object id) {
        return baseMapper.listByFkId(id);
    }

    /**
     * 获取单个对象
     *
     * @param id
     * @return
     */
    @Override
    public T getObject(Object id) {
        return baseMapper.getObject(id);
    }

    /**
     * 保存对象
     *
     * @param t
     */
    @Override
    public void save(T t) {
        baseMapper.save(t);
    }

    /**
     * 批量新增
     *
     * @param list
     */
    @Override
    public void saveBatch(List<T> list) {
        baseMapper.saveBatch(list);
    }

    /**
     * 更新对象
     *
     * @param t
     * @return
     */
    @Override
    public int update(T t) {
        return baseMapper.update(t);
    }

    /**
     * 删除数据
     *
     * @param id
     * @return
     */
    @Override
    public int delete(Object id) {
        return baseMapper.delete(id);
    }

    @Override
    public int deleteBatch(Object[] ids) {
        return baseMapper.deleteBatch(ids);
    }

    /**
     * 获取记录总条数
     *
     * @return
     */
    @Override
    public int total() {
        return baseMapper.total();
    }
}
