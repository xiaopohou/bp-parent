package com.lhyzp.api.sys.controller;

import com.lhyzp.base.BaseController;
import com.lhyzp.sys.model.SysRole;
import com.lhyzp.sys.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 角色控制器
 */
@RestController
@RequestMapping("api/role")
public class SysRoleController extends BaseController{

    @Autowired
    private SysRoleService sysRoleService;

    @GetMapping
    public String list(@RequestParam(value="page",required = false,defaultValue = "1")Integer page,
                       @RequestParam(value="size",required = false,defaultValue = "10")Integer size,
                       @RequestParam(value="sort",required = false,defaultValue = "id")String sort,
                       @RequestParam(value="name",required = false)String name){


        return json(sysRoleService.list(null,null));
    }

    @PostMapping
    public String save(@RequestBody SysRole model){
        sysRoleService.save(model);
        return "OK";
    }

    @GetMapping("{id}")
    public String get(@PathVariable("id")Integer id){

        return json("");
    }

}
