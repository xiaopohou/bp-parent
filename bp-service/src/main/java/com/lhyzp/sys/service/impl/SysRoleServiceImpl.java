package com.lhyzp.sys.service.impl;

import com.lhyzp.sys.model.SysRoleInfo;
import com.lhyzp.sys.repository.SysRoleRepository;
import com.lhyzp.sys.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017-9-4.
 */
@Service
public class SysRoleServiceImpl implements SysRoleService{

    @Autowired
    private SysRoleRepository sysRoleRepository;

    @Override
    public Page<SysRoleInfo> list(Specification specification, Pageable pageable) {
        Page<SysRoleInfo> list = sysRoleRepository.findAll(specification,pageable);
        return list;
    }

    @Override
    public SysRoleInfo save(SysRoleInfo model) {
        return sysRoleRepository.save(model);
    }
}
