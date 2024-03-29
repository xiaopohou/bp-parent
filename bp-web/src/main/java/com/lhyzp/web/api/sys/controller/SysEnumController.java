package com.lhyzp.web.api.sys.controller;

import com.lhyzp.sys.model.SysEnum;
import com.lhyzp.sys.service.SysEnumService;
import com.lhyzp.web.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

/**
 * 数据字典
 * Created by Administrator on 2017-11-8.
 */
@RestController
@RequestMapping("api/enum")
@CacheConfig(cacheNames = "enumCache")
public class SysEnumController extends BaseController {

    @Autowired
    private SysEnumService sysEnumService;

    @PostMapping("save")
    public String save(SysEnum model){
        sysEnumService.save(model);
        return success();
    }
    @CacheEvict(key="'enum_'+#model.getId()")
    @PostMapping("update")
    public String update(@RequestBody SysEnum model){
        sysEnumService.update(model);
        return success();
    }

    @Cacheable(key = "'enum_'+#id")
    @GetMapping("/{id}")
    public String getUser(@PathVariable("id")Integer id){
        SysEnum sysEnum = sysEnumService.getObject(id);
        return json(sysEnum);
    }

}
