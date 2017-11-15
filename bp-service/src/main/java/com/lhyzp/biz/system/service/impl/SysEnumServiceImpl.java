package com.lhyzp.biz.system.service.impl;

import com.lhyzp.biz.system.mapper.SysEnumMapper;
import com.lhyzp.biz.system.model.SysEnum;
import com.lhyzp.biz.system.service.SysEnumService;
import com.lhyzp.common.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017-10-21.
 */
@Service
public class SysEnumServiceImpl extends BaseServiceImpl<SysEnum> implements SysEnumService{

    @Autowired
    private SysEnumMapper sysEnumMapper;
}
