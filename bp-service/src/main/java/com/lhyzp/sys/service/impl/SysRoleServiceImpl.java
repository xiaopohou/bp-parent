package com.lhyzp.sys.service.impl;

import com.lhyzp.sys.model.SysRole;
import com.lhyzp.sys.repository.SysRoleRepository;
import com.lhyzp.sys.service.SysRoleService;
import com.lhyzp.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
    public Page<SysRole> list(Specification specification, Pageable pageable) {
        Page<SysRole> list = sysRoleRepository.findAll(specification,pageable);
        return list;
    }

    @Override
    public SysRole save(SysRole model) {
        return sysRoleRepository.save(model);
    }
}
