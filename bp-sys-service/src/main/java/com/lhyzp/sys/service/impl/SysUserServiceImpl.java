package com.lhyzp.sys.service.impl;

import com.lhyzp.sys.common.BaseServiceImpl;
import com.lhyzp.sys.mapper.SysUserMapper;
import com.lhyzp.sys.model.SysUser;
import com.lhyzp.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017-11-15.
 */
@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUser> implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;


    @Override
    public SysUser findByEmail(String email) {
        return sysUserMapper.findByEmail(email);
    }
}
