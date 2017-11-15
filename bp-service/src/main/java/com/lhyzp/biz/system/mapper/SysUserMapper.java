package com.lhyzp.biz.system.mapper;

import com.lhyzp.biz.system.model.SysUser;
import com.lhyzp.common.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserMapper extends BaseMapper<SysUser>{

    SysUser findByEmail(String email);

}