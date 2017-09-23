package com.lhyzp.sys.service.impl;

import com.google.common.collect.Lists;
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
import java.util.Map;

/**
 * Created by Administrator on 2017-9-4.
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserRepository sysUserRepository;

    @Override
    public Page<SysUser> list(final Map<String,Object> map, Pageable pageable) {
        Page<SysUser> userList = sysUserRepository.findAll(new Specification<SysUser>() {
            /**
             * @param *root: 代表查询的实体类.
             * @param query: 可以从中可到 Root 对象, 即告知 JPA Criteria 查询要查询哪一个实体类. 还可以
             * 来添加查询条件, 还可以结合 EntityManager 对象得到最终查询的 TypedQuery 对象.
             * @param *cb: CriteriaBuilder 对象. 用于创建 Criteria 相关对象的工厂. 当然可以从中获取到 Predicate 对象
             * @return: *Predicate 类型, 代表一个查询条件.
             */
            @Override
            public Predicate toPredicate(Root<SysUser> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

                List<Predicate> predicates= Lists.newArrayList();

                if(StringUtils.isNotEmpty(map.get("userName"))){
                    predicates.add(cb.like(root.get("userName").as(String.class),"%"+map.get("userName")+"%"));
                }
                if(StringUtils.isNotEmpty(map.get("email"))){
                    predicates.add(cb.like(root.get("email").as(String.class),"%"+map.get("email")+"%"));
                }
                if(StringUtils.isNotEmpty(map.get("phone"))){
                    predicates.add(cb.like(root.get("phone").as(String.class),"%"+map.get("phone")+"%"));
                }

                Predicate[] arrayPredicates = new Predicate[predicates.size()];
                return cb.and(predicates.toArray(arrayPredicates));
            }
        },pageable);
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

    @Override
    public void delete(Integer id) {
        sysUserRepository.delete(id);
    }

    @Override
    public SysUser findByEmail(String mail) {
        return sysUserRepository.findByEmail(mail);
    }

}
