package com.lhyzp.sys.service;

import com.lhyzp.sys.model.SysUser;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * Created by Administrator on 2017-9-4.
 */
public interface SysUserService {

    List<SysUser> list(String userName,String email);

    SysUser save(SysUser model);

}
