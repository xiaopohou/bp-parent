package com.lhyzp.sys.service.impl;

import org.springframework.stereotype.Service;

import com.lhyzp.sys.common.BaseServiceImpl;
import com.lhyzp.sys.mapper.SysDeptMapper;
import com.lhyzp.sys.model.SysDept;
import com.lhyzp.sys.service.SysDeptService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2017-11-15.
 */
@Service
public class SysDeptServiceImpl extends BaseServiceImpl<SysDept> implements SysDeptService {

    @Autowired
    private SysDeptMapper sysDeptMapper;

    @Override
    public void saveOrUpdate(SysDept dept) {
        if(dept.getId()==null){
            sysDeptMapper.save(dept);
        }else{
            sysDeptMapper.update(dept);
        }
    }
}
