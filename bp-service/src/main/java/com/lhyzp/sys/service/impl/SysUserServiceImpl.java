package com.lhyzp.sys.service.impl;

import com.lhyzp.sys.model.SysRole;
import com.lhyzp.sys.model.SysUser;
import com.lhyzp.sys.repository.SysUserRepository;
import com.lhyzp.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
    public List<SysUser> list(final String userName, final String email) {
        List<SysUser> userList = sysUserRepository.findAll(new Specification<SysUser>() {
            /**
             * @param *root: 代表查询的实体类.
             * @param query: 可以从中可到 Root 对象, 即告知 JPA Criteria 查询要查询哪一个实体类. 还可以
             * 来添加查询条件, 还可以结合 EntityManager 对象得到最终查询的 TypedQuery 对象.
             * @param *cb: CriteriaBuilder 对象. 用于创建 Criteria 相关对象的工厂. 当然可以从中获取到 Predicate 对象
             * @return: *Predicate 类型, 代表一个查询条件.
             */
            @Override
            public Predicate toPredicate(Root<SysUser> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

                //连接的时候，要以声明的根查询对象（这里是root，也可以自己创建）进行join
                //Join<Z,X>是Join生成的对象，这里的Z是被连接的对象，X是目标对象，
                //  连接的属性字段是被连接的对象在目标对象的属性，这里是我们在MyOrder内声明的customer
                //join的第二个参数是可选的，默认是JoinType.INNER(内连接 inner join)，也可以是JoinType.LEFT（左外连接 left join）
                Join<SysUser,SysRole> join = root.join("roles",JoinType.LEFT);

                Path<String> userName1 = root.get("userName");
                Path<String> email1 = root.get("email");
                Predicate predicate1 = cb.like(userName1, "%"+userName+"%");
                Predicate predicate2 = cb.like(email1,"%"+email+"%");

                return cb.and(predicate1,predicate2);
            }
        });
        return userList;
    }

    @Override
    public SysUser save(SysUser model) {
        
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
