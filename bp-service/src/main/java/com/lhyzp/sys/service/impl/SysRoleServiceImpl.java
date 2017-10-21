package com.lhyzp.sys.service.impl;

import com.lhyzp.sys.model.SysRole;
import com.lhyzp.sys.repository.SysRoleRepository;
import com.lhyzp.sys.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017-9-4.
 */
@Service
public class SysRoleServiceImpl implements SysRoleService{

    @Autowired
    private SysRoleRepository sysRoleRepository;

    @Override
    public Page<SysRole> list(Map<String, Object> condition, Pageable pageable) {
        return null;
    }

    @Override
    public SysRole save(SysRole model) {
        return sysRoleRepository.save(model);
    }

    @Override
    public void delete(Integer id) {
        sysRoleRepository.delete(id);
    }

    @Override
    public void batchDelete(List<SysRole> roles) {
        sysRoleRepository.deleteInBatch(roles);
    }

    @Override
    public SysRole findById(Integer id) {
        return sysRoleRepository.findOne(id);
    }
}
