package com.lhyzp.biz.system.service;

import com.lhyzp.biz.system.model.SysDept;
import com.lhyzp.common.BaseService;

/**
 * Created by Administrator on 2017-11-15.
 */
public interface SysDeptService extends BaseService<SysDept>{

    /**
     * 新增部门
     * @param dept
     */
    void saveOrUpdate(SysDept dept);

}
