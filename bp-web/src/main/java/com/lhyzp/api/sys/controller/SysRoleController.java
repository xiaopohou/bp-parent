package com.lhyzp.api.sys.controller;

import com.lhyzp.commons.base.BaseController;
import com.lhyzp.commons.utils.SpecificationFactory;
import com.lhyzp.sys.model.SysRoleInfo;
import com.lhyzp.sys.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
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

        Specification specification = Specifications.where(SpecificationFactory.like("name", name));

        return json(sysRoleService.list(specification,null));
    }

    @PostMapping
    public String save(@RequestBody SysRoleInfo model){
        sysRoleService.save(model);
        return "OK";
    }

    @GetMapping("{id}")
    public String get(@PathVariable("id")Integer id){

        return json("");
    }

}
