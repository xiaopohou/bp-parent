package com.lhyzp.shiro;

import com.lhyzp.sys.model.SysUserInfo;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * 身份验证核心类
 * @author zp
 *
 */
public class MyShiroRealm extends AuthorizingRealm {

    //@Autowired
    //private BaseUserService baseUserService;
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
		SysUserInfo user=new SysUserInfo();
		user.setEmail(email);
        //
        ////用户检测
        //BaseUser user = baseUserService.loginValidate(username,password);
        //
        //账号或密码错误
        if(user==null) {
            throw new IncorrectCredentialsException("账号或密码不正确");
        }

        //账号锁定
        //if(user.getActive()==0){
        //	throw new LockedAccountException("账号已被锁定,请联系管理员");
        //}

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
        return info;

    }
    
    /**
     * 权限验证
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    	
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
