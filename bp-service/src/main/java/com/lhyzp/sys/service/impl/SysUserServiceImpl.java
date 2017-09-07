package com.lhyzp.sys.service.impl;

import com.lhyzp.sys.model.SysRole;
import com.lhyzp.sys.model.SysUser;
import com.lhyzp.sys.repository.SysUserRepository;
import com.lhyzp.sys.service.SysUserService;
import com.lhyzp.utils.DateUtils;
import com.lhyzp.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.List;

/**
 * Created by Administrator on 2017-9-4.
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserRepository sysUserRepository;

    @Override
    public Page<SysUser> list(final String userName, final String email, Pageable pageable) {
        Page<SysUser> userList = sysUserRepository.findAll(pageable);
        return userList;
    }

    @Override
    public SysUser save(SysUser model) {
        model.setCreateDate(DateUtils.getCurrentDate());
        return sysUserRepository.save(model);
    }


    //@CacheEvict 支持如下几个参数：
    //value：缓存位置名称，不能为空，同上
    //key：缓存的key，默认为空，同上
    //condition：触发条件，只有满足条件的情况才会清除缓存，默认为空，支持SpEL
    //allEntries：true表示清除value中的全部缓存，默认为false

    //将缓存保存进andCache，并使用参数中的userId加上一个字符串(这里使用方法名称)作为缓存的key
    //@Cacheable(value="SysUserCache",key="'findByIdSysUser_'+#id")
    @Override
    public SysUser findById(Integer id) {
        return sysUserRepository.findOne(id);
    }
}
