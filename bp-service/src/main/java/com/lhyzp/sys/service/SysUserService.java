package com.lhyzp.sys.service;

import com.lhyzp.sys.model.SysUser;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Administrator on 2017-9-4.
 */
public interface SysUserService {

    Page<SysUser> list(String userName, String email, Pageable pageable);

    SysUser save(SysUser model);

    SysUser findById(Integer id);

}
