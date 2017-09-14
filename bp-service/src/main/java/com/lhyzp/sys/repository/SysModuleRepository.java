package com.lhyzp.sys.repository;

import com.lhyzp.sys.model.SysModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017-9-12.
 */
@Repository
public interface SysModuleRepository extends JpaRepository<SysModule,Integer>,JpaSpecificationExecutor<SysModule>{

}
