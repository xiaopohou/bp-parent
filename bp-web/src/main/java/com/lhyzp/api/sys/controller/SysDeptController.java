package com.lhyzp.api.sys.controller;

import com.lhyzp.base.BaseController;
import com.lhyzp.biz.system.model.SysDept;
import com.lhyzp.biz.system.service.SysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 部门管理
 * Created by Administrator on 2017-12-22.
 */
@RestController
@RequestMapping("api/dept")
public class SysDeptController extends BaseController{

    @Autowired
    private SysDeptService sysDeptService;

    @PostMapping
    public String saveOrUpdate(SysDept dept){
        sysDeptService.saveOrUpdate(dept);
        return success();
    }
}
