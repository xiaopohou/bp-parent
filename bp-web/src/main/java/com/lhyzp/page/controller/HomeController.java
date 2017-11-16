package com.lhyzp.page.controller;

import com.lhyzp.util.ShiroUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017-7-27.
 */
@Controller
@RequestMapping
public class HomeController{

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("im")
    public String ws(Model model){
        model.addAttribute("email", ShiroUtils.getUserEntity().getEmail());
        return "im";
    }

    @RequestMapping("login")
    public String login(){
        return "login";
    }
}
