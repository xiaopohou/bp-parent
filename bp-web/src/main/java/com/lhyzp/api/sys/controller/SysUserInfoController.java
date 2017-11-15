package com.lhyzp.api.sys.controller;

import com.google.common.collect.Maps;
import com.lhyzp.annotation.OpLog;
import com.lhyzp.base.BaseController;
import com.lhyzp.biz.system.model.SysUser;
import com.lhyzp.biz.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 系统用户控制器
 */
@RestController
@RequestMapping("api/user")
public class SysUserInfoController extends BaseController{

    @Autowired
    private SysUserService sysUserService;

    @GetMapping
    public String list(@RequestParam(value="page",required = false,defaultValue = "0")Integer page,
                       @RequestParam(value="size",required = false,defaultValue = "10")Integer size,
                       @RequestParam(value="sort",required = false,defaultValue = "id")String sort,
                       @RequestParam(value="order",required = false,defaultValue = "id")String order,
                       @RequestParam(value="userName",required = false)String userName,
                       @RequestParam(value="email",required = false)String email,
                       @RequestParam(value="phone",required = false)String phone,
                       @RequestParam(value="dept",required = false)String dept){

        Map<String,Object> map= Maps.newHashMap();
        map.put("userName",userName);
        map.put("email",email);
        map.put("phone",phone);
        map.put("dept",dept);
        List<SysUser> list = sysUserService.list(map);
        return json(list);
    }

    @OpLog("新增用户")
    @PostMapping
    public String save(@RequestBody SysUser model){
        sysUserService.save(model);
        return success();
    }

    @PutMapping
    public String update(SysUser model){
        sysUserService.save(model);
        return success();
    }

    @GetMapping("{id}")
    public String get(@PathVariable("id")Integer id){
        SysUser record = sysUserService.getObject(id);
        return json(record);
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable("id")Integer id){
        return success();
    }

}
