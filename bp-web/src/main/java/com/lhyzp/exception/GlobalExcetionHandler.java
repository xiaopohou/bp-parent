package com.lhyzp.exception;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.lhyzp.bases.ResponseMessage;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.UndeclaredThrowableException;

/**
 * 全局异常处理
 * @author zp
 *
 */
@ControllerAdvice
public class GlobalExcetionHandler{
	private static final Logger logger = LoggerFactory.getLogger(GlobalExcetionHandler.class);
	
//	@ExceptionHandler
//	public ModelAndView error(Exception ex,HttpServletRequest req) {
//		ModelAndView mv = new ModelAndView("500");
//		mv.addObject("excetion", ex);
//		mv.addObject("message", ex.getMessage());
//		mv.addObject("url", req.getRequestURL());
//		return mv;
//	}

	/**
	 * json方式返回
	 * @param ex
	 * @param req
	 * @return
	 */
	@ExceptionHandler
	@ResponseBody
	public String error(Exception ex, HttpServletRequest req) {
		ResponseMessage rm;
		//没有权限异常
		if(ex instanceof UnauthorizedException){
			rm=new ResponseMessage(401,"权限不足");
			return JSON.toJSONString(rm, SerializerFeature.DisableCircularReferenceDetect);
		}
		//自定义异常1
		if(ex instanceof CustomException){
			rm=new ResponseMessage(500,ex.getMessage());
			return JSON.toJSONString(rm, SerializerFeature.DisableCircularReferenceDetect);
		}
		//自定义被代理的异常
		if(ex instanceof UndeclaredThrowableException){
			ex= (Exception) ((UndeclaredThrowableException) ex).getUndeclaredThrowable();
			rm=new ResponseMessage(500,ex.getMessage());
			return JSON.toJSONString(rm, SerializerFeature.DisableCircularReferenceDetect);
		}
		logger.error(ex.getMessage(),ex);
		rm=new ResponseMessage(500,"出错了!!!");
		return JSON.toJSONString(rm,SerializerFeature.DisableCircularReferenceDetect);
	}
}
