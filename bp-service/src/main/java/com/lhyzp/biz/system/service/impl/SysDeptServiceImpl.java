package com.lhyzp.biz.system.service.impl;

import com.lhyzp.biz.system.mapper.SysDeptMapper;
import com.lhyzp.biz.system.model.SysDept;
import com.lhyzp.biz.system.service.SysDeptService;
import com.lhyzp.common.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017-11-15.
 */
@Service
public class SysDeptServiceImpl extends BaseServiceImpl<SysDept> implements SysDeptService{

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
