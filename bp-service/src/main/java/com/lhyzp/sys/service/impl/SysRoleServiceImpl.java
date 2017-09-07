package com.lhyzp.sys.service.impl;

import com.lhyzp.sys.model.SysRole;
import com.lhyzp.sys.repository.SysRoleRepository;
import com.lhyzp.sys.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017-9-4.
 */
@Service
public class SysRoleServiceImpl implements SysRoleService{

    @Autowired
    private SysRoleRepository sysRoleRepository;

    @Override
    public List<SysRole> list() {
        return sysRoleRepository.findAll();
    }

    @Override
    public SysRole save(SysRole model) {
        return sysRoleRepository.save(model);
    }
}
