package com.lhyzp.api.sys.controller;

import com.lhyzp.sys.model.SysRole;
import com.lhyzp.sys.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 角色控制器
 */
@RestController
@RequestMapping("api/role")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    @GetMapping
    public Object list(){

        return sysRoleService.list();
    }

    @PostMapping
    public String save(@RequestBody SysRole model){
        sysRoleService.save(model);
        return "OK";
    }

}
