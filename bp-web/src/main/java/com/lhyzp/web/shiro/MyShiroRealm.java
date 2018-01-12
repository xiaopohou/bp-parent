package com.lhyzp.web.shiro;

import com.lhyzp.sys.model.SysUser;
import com.lhyzp.sys.service.SysUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 身份验证核心类
 * @author zp
 *
 */
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private SysUserService sysUserService;
    //@Autowired
    //private BaseModuleService baseModuleService;
    //
    //@Autowired
    //private BaseRoleService baseRoleService;


    /**
     * 认证信息.(身份验证)
     * Authentication 是用来验证用户身份
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {

        String email = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());

        //用户检测
        SysUser user = sysUserService.findByEmail(email);

        //账号或密码错误
        if(user==null) {
            throw new IncorrectCredentialsException("账号或密码不正确");
        }

        //账号锁定
        if(!user.getActive()){
        	throw new LockedAccountException("账号已被锁定,请联系管理员");
        }

        //加密方式;
        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(
                user, //用户
                user.getPassword(), //数据库加密的密码
                ByteSource.Util.bytes(email),//盐
                getName()
        );
        //明文: 若存在，将此用户存放到登录认证info中，无需自己做密码对比，Shiro会为我们进行密码对比校验
      //SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
      //     user, //用户
      //     password, //密码
      //       getName()  //realm name
      //);
        return info;

    }
    
    /**
     * 权限验证
     *
     * 此方法调用  hasRole,hasPermission的时候才会进行回调.
     * 权限信息.(授权):
     * 1、如果用户正常退出，缓存自动清空；
     * 2、如果用户非正常退出，缓存自动清空；
     * 3、如果我们修改了用户的权限，而用户不退出系统，修改的权限无法立即生效。
     * （需要手动编程进行实现；放在service进行调用）
     * 在权限修改后调用realm中的方法，realm已经由spring管理，所以从spring中获取realm实例，
     * 调用clearCached方法；
     * :Authorization 是授权访问控制，用于对用户进行的操作授权，证明该用户是否允许进行当前操作，如访问某个链接，某个资源文件等。
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    	/*
        * 当没有使用缓存的时候，不断刷新页面的话，这个代码会不断执行，
        * 当其实没有必要每次都重新设置权限信息，所以我们需要放到缓存中进行管理；
        * 当放到缓存中时，这样的话，doGetAuthorizationInfo就只会执行一次了，
        * 缓存过期之后会再次执行。
        */

//    	BaseUser user = (BaseUser)principals.getPrimaryPrincipal();
//
//		Long roleId = 0L;
//		if(user.getRoleId()!=null){
//			roleId=user.getRoleId();
//		}
////		BaseRole role=baseRoleService.findRoleById(roleId);
//		List<String> permsList = new ArrayList<String>();
//
//		if(user.getJobNumber().equals(BaseConstant.P_ADMIN)){
//			Map<String,Object> paramMap=new HashMap<String,Object>();
//			paramMap.put("sort", "id");
//			List<BaseModule> permList = baseModuleService.list(paramMap);
//			for(BaseModule menu : permList){
//				permsList.add(menu.getPermissionCode());
//			}
//		}else{
//			//用户权限
//			List<BaseModule> listModule= baseModuleService.listUserModule(user.getId());
//			if(listModule!=null){
//				for (BaseModule baseModule : listModule) {
//					permsList.add(baseModule.getPermissionCode());
//				}
//			}
//		}
//
//		//用户权限列表
//		Set<String> permsSet = new HashSet<String>();
//		for(String perms : permsList){
//			if(StringUtils.isEmptyString(perms)){
//				continue;
//			}
//			permsSet.addAll(Arrays.asList(perms.trim().split(",")));
//		}
//
//		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//		info.setStringPermissions(permsSet);
//		return info;
		return null;
    }

}
