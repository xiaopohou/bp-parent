package com.lhyzp.sys.service;

import com.lhyzp.sys.model.SysRole;

import java.util.List;

/**
 * Created by Administrator on 2017-9-4.
 */
public interface SysRoleService {

    List<SysRole> list();

    SysRole save(SysRole model);
}
