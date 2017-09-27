package com.lhyzp.sys.repository;

import com.lhyzp.sys.model.SysRoleInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017-9-4.
 */
@Repository
public interface SysRoleRepository extends JpaRepository<SysRoleInfo,Integer>,JpaSpecificationExecutor<SysRoleInfo>{

}
