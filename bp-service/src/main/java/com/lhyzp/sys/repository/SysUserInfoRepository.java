package com.lhyzp.sys.repository;

import com.lhyzp.sys.model.SysUserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017-9-4.
 */
@Repository
public interface SysUserInfoRepository extends JpaRepository<SysUserInfo,Integer>,JpaSpecificationExecutor<SysUserInfo>{

    SysUserInfo findByEmail(String mail);




    /**
     *（1）可以通过自定义的 JPQL 完成 UPDATE 和 DELETE 操作。 注意： JPQL 不支持使用 INSERT；
     *（2）在 @Query 注解中编写 JPQL 语句， 但必须使用 @Modifying 进行修饰. 以通知 SpringData， 这是一个 UPDATE 或 DELETE 操作
     *（3）UPDATE 或 DELETE 操作需要使用事务，此时需要定义 Service 层，在 Service 层的方法上添加事务操作；
     *（4）默认情况下， SpringData 的每个方法上有事务， 但都是一个只读事务。 他们不能完成修改操作。
     */


}
