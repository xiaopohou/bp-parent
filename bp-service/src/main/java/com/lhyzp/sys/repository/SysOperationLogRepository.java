package com.lhyzp.sys.repository;

import com.lhyzp.sys.model.SysOperationLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by Administrator on 2017-10-21.
 */
public interface SysOperationLogRepository extends JpaRepository<SysOperationLog,Integer>,JpaSpecificationExecutor<SysOperationLog>{
}
