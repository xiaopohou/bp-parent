package com.lhyzp.sys.service.impl;

import com.lhyzp.sys.common.BaseServiceImpl;
import com.lhyzp.sys.mapper.SysEnumMapper;
import com.lhyzp.sys.model.SysEnum;
import com.lhyzp.sys.service.SysEnumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017-10-21.
 */
@Service
public class SysEnumServiceImpl extends BaseServiceImpl<SysEnum> implements SysEnumService {

    @Autowired
    private SysEnumMapper sysEnumMapper;
}
