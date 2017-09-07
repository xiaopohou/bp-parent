package com.lhyzp.api.sys.controller;

import com.lhyzp.commons.base.BaseController;
import com.lhyzp.commons.utils.PageUtil;
import com.lhyzp.sys.model.SysUser;
import com.lhyzp.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
    public String list(@RequestParam(value="page",required = false,defaultValue = "1")Integer page,
                       @RequestParam(value="size",required = false,defaultValue = "10")Integer size,
                       @RequestParam(value="sort",required = false,defaultValue = "id")String sort,
                       @RequestParam(value="userName",required = false)String userName,
                       @RequestParam(value="email",required = false)String email){

        Page<SysUser> list = sysUserService.list(userName, email, null);

        return json(list.getContent());
    }

    @PostMapping
    public String save(@RequestBody SysUser model){
        model.setCreateUser(0);
        sysUserService.save(model);
        return success();
    }

    @GetMapping("{id}")
    public String get(@PathVariable("id")Integer id){
        SysUser record = sysUserService.findById(id);
        return json(record);
    }
}
