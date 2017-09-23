package com.lhyzp.api.sys.controller;

import com.google.common.collect.Maps;
import com.lhyzp.commons.base.BaseController;
import com.lhyzp.sys.model.SysUser;
import com.lhyzp.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 系统用户控制器
 */
@RestController
@RequestMapping("api/user")
public class SysUserController extends BaseController{

    @Autowired
    private SysUserService sysUserService;

    @GetMapping
    public String list(@RequestParam(value="page",required = false,defaultValue = "0")Integer page,
                       @RequestParam(value="size",required = false,defaultValue = "10")Integer size,
                       @RequestParam(value="sort",required = false,defaultValue = "id")String sort,
                       @RequestParam(value="order",required = false,defaultValue = "id")String order,
                       @RequestParam(value="userName",required = false)String userName,
                       @RequestParam(value="email",required = false)String email,
                       @RequestParam(value="phone",required = false)String phone){

        Map<String,Object> map= Maps.newHashMap();
        map.put("userName",userName);
        map.put("email",email);
        map.put("phone",phone);
        Page<SysUser> list = sysUserService.list(map, new PageRequest(page,size,new Sort(sort)));



        return json(list);
    }

    @PostMapping
    public String save(SysUser model){
        model.setCreateUser(userId());
        sysUserService.save(model);
        return success();
    }

    @GetMapping("{id}")
    public String get(@PathVariable("id")Integer id){
        SysUser record = sysUserService.findById(id);
        return json(record);
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable("id")Integer id){
        return success();
    }
}
