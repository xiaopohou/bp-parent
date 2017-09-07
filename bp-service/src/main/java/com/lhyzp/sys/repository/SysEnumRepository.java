package com.lhyzp.sys.repository;

import com.lhyzp.sys.model.SysEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017-9-5.
 */
@Repository
public interface SysEnumRepository extends JpaRepository<SysEnum,Integer>{

}
