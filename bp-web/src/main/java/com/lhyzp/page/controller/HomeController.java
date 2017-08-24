package com.lhyzp.page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017-7-27.
 */
@Controller
@RequestMapping
public class HomeController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("home")
    public String home(){
        return "extjs";
    }
}
