package com.lhyzp.filter;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 用户操作日志,切面处理类
 * @author zp
 *
 */
@Aspect
@Component
public class OpLogAspect {

    //@annotation是针对方法的注解
    @Pointcut("@annotation(com.lhyzp.annotation.OpLog)")
    public void opLogPointCut() {

    }

    @Before("opLogPointCut()")
    public void saveSysLog(JoinPoint joinPoint) {

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        //SysOpLog sysOpLog = new SysOpLog();
        //OpLog opLog = method.getAnnotation(OpLog.class);
        //if(opLog != null){
        //    //获取注解的value
        //    sysOpLog.setOperation(opLog.value());
        //}
        //
        ////请求的方法
        //sysOpLog.setMethod(joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        //
        ////请求的参数
        //Object[] args = joinPoint.getArgs();
        //String params = JSON.toJSONString(args[0]);
        //sysOpLog.setParams(params);
        //
        ////获取request
        //ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        //HttpServletRequest request = attributes.getRequest();
        //sysOpLog.setIp(HttpUtils.getRemortIP(request));
        //sysOpLog.setCreateUser(ShiroUtils.getUserEntity().getId());
        //sysOpLog.setCreateDate(DateUtils.getCurrentDate());


    }
}
