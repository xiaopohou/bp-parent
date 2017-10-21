package com.lhyzp.filter;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Enumeration;

/**
 * 请求日志-AOP
 * @author zp
 *
 */
@Aspect
@Component
public class WebLogAspect {
    private Logger logger = Logger.getLogger(getClass());
    
    ThreadLocal<Long> startTime = new ThreadLocal<Long>();
    
    @Pointcut("execution(public * com.lhyzp.api..*.*(..))")
    public void webLog(){}

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
    	startTime.set(System.currentTimeMillis());
    	
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //logger.info("URL : " + request.getRequestURL().toString());
        //logger.info("HTTP_METHOD : " + request.getMethod());
        //logger.info("IP : " + request.getRemoteAddr());
        //logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        //logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
        Enumeration<String> enu=request.getParameterNames(); 
        while(enu.hasMoreElements()){ 
            String paraName=(String)enu.nextElement();
            System.out.println("参数名: "+paraName+" 值: "+request.getParameter(paraName));
        } 
    }
    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        logger.info("响应内容 : " + ret);

        logger.info("耗时（毫秒） : " + (System.currentTimeMillis() - startTime.get()));
    }
}