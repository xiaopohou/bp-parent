package com.lhyzp.sys.repository;

import com.lhyzp.sys.model.SysDept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017-10-21.
 */
@Repository
public interface SysDeptRepository extends JpaRepository<SysDept,Integer>,JpaSpecificationExecutor<SysDept>{
}
