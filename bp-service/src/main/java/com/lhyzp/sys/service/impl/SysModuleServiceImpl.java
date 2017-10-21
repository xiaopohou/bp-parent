package com.lhyzp.sys.service.impl;

import com.lhyzp.sys.model.SysModule;
import com.lhyzp.sys.service.SysModuleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017-10-21.
 */
public class SysModuleServiceImpl implements SysModuleService{
    @Override
    public Page<SysModule> list(Map<String, Object> condition, Pageable pageable) {
        return null;
    }

    @Override
    public SysModule save(SysModule model) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void batchDelete(List<SysModule> ids) {

    }

    @Override
    public SysModule findById(Integer id) {
        return null;
    }
}
