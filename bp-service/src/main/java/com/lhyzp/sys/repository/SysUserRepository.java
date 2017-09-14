package com.lhyzp.sys.repository;

import com.lhyzp.sys.model.SysUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017-9-4.
 */
@Repository
public interface SysUserRepository extends JpaRepository<SysUser,Integer>,JpaSpecificationExecutor<SysUser>{
    Page<SysUser> findByUserNameLike(String userName, Pageable pageable);
}
