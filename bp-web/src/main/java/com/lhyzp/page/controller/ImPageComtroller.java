package com.lhyzp.page.controller;

import com.lhyzp.base.BaseController;
import com.lhyzp.util.ShiroUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017-11-22.
 */
@Controller
@RequestMapping("p/im")
public class ImPageComtroller extends BaseController{

    @RequestMapping("chat")
    public String ws(Model model){
        model.addAttribute("sid", ShiroUtils.getSession().getId());
        return "im/chat";
    }
}
