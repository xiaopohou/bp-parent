package com.lhyzp.sys.service;

import com.lhyzp.sys.model.SysRole;
import com.lhyzp.sys.model.SysRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

/**
 * Created by Administrator on 2017-9-4.
 */
public interface SysRoleService {

    Page<SysRole> list(Specification specification, Pageable pageable);

    SysRole save(SysRole model);
}
