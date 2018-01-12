package com.lhyzp.sys.service;

import com.lhyzp.common.base.BaseService;
import com.lhyzp.sys.model.SysDept;

/**
 * Created by Administrator on 2017-11-15.
 */
public interface SysDeptService extends BaseService<SysDept> {

    /**
     * 新增部门
     * @param dept
     */
    void saveOrUpdate(SysDept dept);

}
