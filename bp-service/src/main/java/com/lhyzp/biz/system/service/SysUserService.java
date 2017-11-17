package com.lhyzp.biz.system.service;

import com.lhyzp.biz.system.model.SysUser;
import com.lhyzp.common.BaseService;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017-11-15.
 */
public interface SysUserService extends BaseService<SysUser>{

    /**
     * 根据邮箱查找用户
     * @param email
     * @return
     */
    SysUser findByEmail(String email);

    List<SysUser> list(Map<String,Object> map);

}
