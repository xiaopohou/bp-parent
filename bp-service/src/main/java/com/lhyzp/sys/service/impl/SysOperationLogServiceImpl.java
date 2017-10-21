package com.lhyzp.sys.service.impl;

import com.lhyzp.sys.model.SysOperationLog;
import com.lhyzp.sys.service.SysOperationLogService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

/**
 * Created by Administrator on 2017-10-21.
 */
public class SysOperationLogServiceImpl implements SysOperationLogService {
    @Override
    public Page<SysOperationLog> list(Map<String, Object> condition, Pageable pageable) {
        return null;
    }

    @Override
    public SysOperationLog save(SysOperationLog model) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void batchDelete(Integer[] ids) {

    }

    @Override
    public SysOperationLog findById(Integer id) {
        return null;
    }
}
