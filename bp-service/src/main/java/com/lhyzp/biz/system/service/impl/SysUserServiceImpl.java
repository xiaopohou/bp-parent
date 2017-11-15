package com.lhyzp.biz.system.service.impl;

import com.lhyzp.biz.system.mapper.SysUserMapper;
import com.lhyzp.biz.system.model.SysUser;
import com.lhyzp.biz.system.service.SysUserService;
import com.lhyzp.common.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017-11-15.
 */
@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUser> implements SysUserService{

    @Autowired
    private SysUserMapper sysUserMapper;


    @Override
    public SysUser findByEmail(String email) {
        return sysUserMapper.findByEmail(email);
    }
}
