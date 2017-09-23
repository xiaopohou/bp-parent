package com.lhyzp.sys.service;

import com.lhyzp.base.BaseService;
import com.lhyzp.sys.model.SysUser;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017-9-4.
 */
public interface SysUserService extends BaseService<SysUser>{

    /**
     * 根据邮箱获取用户
     * @param mail
     * @return
     */
    SysUser findByEmail(String mail);

}
