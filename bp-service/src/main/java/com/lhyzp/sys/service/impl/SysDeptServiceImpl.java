package com.lhyzp.sys.service.impl;

import com.lhyzp.sys.model.SysDept;
import com.lhyzp.sys.service.SysDeptService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017-10-21.
 */
public class SysDeptServiceImpl implements SysDeptService{
    @Override
    public Page<SysDept> list(Map<String, Object> condition, Pageable pageable) {
        return null;
    }

    @Override
    public SysDept save(SysDept model) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void batchDelete(List<SysDept> ids) {

    }

    @Override
    public SysDept findById(Integer id) {
        return null;
    }
}
