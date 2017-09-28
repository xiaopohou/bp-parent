package com.lhyzp.page.controller;

import com.lhyzp.sys.service.SysUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Administrator on 2017-7-27.
 */
@Controller
@RequestMapping
public class HomeController {

    @Autowired
    private SysUserInfoService sysUserInfoService;

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("home")
    public String home(@RequestParam(value = "id",required = false)Integer id, ModelMap map){
        map.addAttribute("user",sysUserInfoService.findById(id));
        return "extjs";
    }
    @RequestMapping("login")
    public String login(){
        return "login";
    }
}
