package com.lhyzp.web.api.sys.controller;

import com.lhyzp.web.base.BaseController;

import com.lhyzp.sys.model.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户账号控制器
 * Created by Administrator on 2017-9-21.
 */
@RestController
@RequestMapping("api/account")
public class AccountController extends BaseController {


    /**
     * 登录效验
     * @param user
     * @return
     */
    @RequestMapping(value="login",method= RequestMethod.POST)
    public String login(SysUser user, @RequestParam(value="vcode",required = false)String vcode,
                        @RequestParam(value="rememberMe",defaultValue = "false")boolean rememberMe){
        try{
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(user.getEmail(), user.getPassword(),rememberMe);
            subject.login(token);
        }catch (UnknownAccountException e) {
            return msg(1,e.getMessage());
        }catch (IncorrectCredentialsException e) {
            return msg(2,"账号或密码不正确");
        }catch (LockedAccountException e) {
            return msg(3,e.getMessage());
        }catch (ExcessiveAttemptsException e) {
            return msg(4,"密码错误次数超过5次,帐号被锁定");
        }catch (AuthenticationException e) {
            return msg(5,"账户验证失败");
        }

        return success();
    }
}
