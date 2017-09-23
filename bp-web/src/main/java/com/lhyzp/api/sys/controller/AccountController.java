package com.lhyzp.api.sys.controller;

import com.lhyzp.commons.base.BaseController;
import com.lhyzp.commons.utils.ShiroUtils;
import com.lhyzp.sys.model.SysUser;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017-9-21.
 */
@RestController
@RequestMapping("api/account")
public class AccountController extends BaseController{


    /**
     * 登录效验
     * @param user
     * @return
     */
    @RequestMapping(value="login",method= RequestMethod.POST)
    public String login(SysUser user, String code){
        try{
            /*验证码*/
            //String imgCode=(String) ShiroUtils.getSession().getAttribute("code");
            //if(imgCode==null){
            //	return msg(6,"验证码已过期");
            //}
            //if(!imgCode.equalsIgnoreCase(code)){
            //	return msg(5,"验证码不正确");
            //}
            //ShiroUtils.getSession().setAttribute("code", null);

            Subject subject = ShiroUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(user.getEmail(), user.getPassword());
            subject.login(token);
        }catch (UnknownAccountException e) {
            return msg(1,e.getMessage());
        }catch (IncorrectCredentialsException e) {
            return msg(2,e.getMessage());
        }catch (LockedAccountException e) {
            return msg(3,e.getMessage());
        }catch (AuthenticationException e) {
            return msg(4,"账户验证失败");
        }

        return success();
    }
}
