package com.lhyzp.biz.system.mapper;

import com.lhyzp.biz.system.model.SysUser;
import com.lhyzp.common.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SysUserMapper extends BaseMapper<SysUser>{

    SysUser findByEmail(String email);

}