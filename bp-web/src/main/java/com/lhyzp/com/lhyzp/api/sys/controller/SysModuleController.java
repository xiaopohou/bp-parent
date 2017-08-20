package com.lhyzp.com.lhyzp.api.sys.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 模块
 * Created by Administrator on 2017-7-27.
 */
@RestController
@RequestMapping("api/module")
public class SysModuleController {

    @GetMapping
    public String list(){
        return "[]";
    }
}
