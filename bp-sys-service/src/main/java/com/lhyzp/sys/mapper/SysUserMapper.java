package com.lhyzp.sys.mapper;

import com.lhyzp.common.base.BaseMapper;
import com.lhyzp.sys.model.SysUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

    SysUser findByEmail(String email);

}