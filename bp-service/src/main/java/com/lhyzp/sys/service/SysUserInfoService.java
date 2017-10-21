package com.lhyzp.sys.service;

import com.lhyzp.bases.BaseService;
import com.lhyzp.sys.model.SysUserInfo;

/**
 * Created by Administrator on 2017-9-4.
 */
public interface SysUserInfoService extends BaseService<SysUserInfo>{

    /**
     * 根据邮箱获取用户
     * @param mail
     * @return
     */
    SysUserInfo findByEmail(String mail);

}
