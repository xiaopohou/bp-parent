package com.lhyzp.web.page.controller;

import com.lhyzp.web.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 系统管理页面配置
 * Created by Administrator on 2017-12-22.
 */
@Controller
@RequestMapping("p/sys")
public class SystemPageController extends BaseController {


    /**
     * 模块资源管理页
     * @return
     */
    @GetMapping("module")
    public String modulePage(){
        return "mapping/system/module";
    }
    /**
     * 用户管理页
     * @return
     */
    @GetMapping("user")
    public String userPage(){
        return "mapping/system/user";
    }

    /**
     * 部门管理页
     * @return
     */
    @GetMapping("dept")
    public String deptPage(){
        return "mapping/system/dept";
    }

    /**
     * 角色管理页
     * @return
     */
    @GetMapping("role")
    public String rolePage(){
        return "mapping/system/role";
    }
    /**
     * 数据字典管理页
     * @return
     */
    @GetMapping("enum")
    public String enumPage(){
        return "mapping/system/enum";
    }
}
