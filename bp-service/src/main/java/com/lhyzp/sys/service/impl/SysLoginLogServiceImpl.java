package com.lhyzp.sys.service.impl;

import com.lhyzp.sys.model.SysLoginLog;
import com.lhyzp.sys.service.SysLoginLogService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017-10-21.
 */
public class SysLoginLogServiceImpl implements SysLoginLogService{
    @Override
    public Page<SysLoginLog> list(Map<String, Object> condition, Pageable pageable) {
        return null;
    }

    @Override
    public SysLoginLog save(SysLoginLog model) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void batchDelete(List<SysLoginLog> ids) {

    }

    @Override
    public SysLoginLog findById(Integer id) {
        return null;
    }
}
