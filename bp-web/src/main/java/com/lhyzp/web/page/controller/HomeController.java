package com.lhyzp.web.page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页
 * Created by Administrator on 2017-7-27.
 */
@Controller
@RequestMapping
public class HomeController{

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("login")
    public String login(){
        return "login";
    }
}
