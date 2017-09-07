package com.lhyzp.api.sys.controller;

import com.lhyzp.common.BaseController;
import com.lhyzp.sys.model.SysUser;
import com.lhyzp.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 系统用户控制器
 */
@RestController
@RequestMapping("api/user")
public class SysUserController extends BaseController{

    @Autowired
    private SysUserService sysUserService;

    @GetMapping
    public String list(@RequestParam(value="userName",required = false)String userName,@RequestParam(value="email",required = false)String email){

        return json(sysUserService.list(userName,email));
    }

    @PostMapping
    public String save(@RequestBody SysUser model){
        sysUserService.save(model);
        return success();
    }

    @GetMapping("{id}")
    public String get(@PathVariable("id")Integer id){
        SysUser record = sysUserService.findById(id);
        return json(record);
    }
}
