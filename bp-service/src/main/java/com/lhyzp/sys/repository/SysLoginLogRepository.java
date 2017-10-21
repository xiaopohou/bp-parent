package com.lhyzp.sys.repository;

import com.lhyzp.sys.model.SysLoginLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by Administrator on 2017-10-21.
 */
public interface SysLoginLogRepository extends JpaRepository<SysLoginLog,Integer>,JpaSpecificationExecutor<SysLoginLog>{
}
