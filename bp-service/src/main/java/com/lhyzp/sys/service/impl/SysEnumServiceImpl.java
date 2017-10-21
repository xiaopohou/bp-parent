package com.lhyzp.sys.service.impl;

import com.lhyzp.sys.model.SysEnum;
import com.lhyzp.sys.service.SysEnumService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017-10-21.
 */
public class SysEnumServiceImpl implements SysEnumService{
    @Override
    public Page<SysEnum> list(Map<String, Object> condition, Pageable pageable) {
        return null;
    }

    @Override
    public SysEnum save(SysEnum model) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void batchDelete(List<SysEnum> ids) {

    }

    @Override
    public SysEnum findById(Integer id) {
        return null;
    }
}
