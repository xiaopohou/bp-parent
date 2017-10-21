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
		//没有权限异常
		if(ex instanceof UnauthorizedException){
			ResponseMessage rm=new ResponseMessage(401,"Unauthorized");
			return JSON.toJSONString(rm, SerializerFeature.DisableCircularReferenceDetect);
		}
		logger.error(ex.getMessage(),ex);
		ResponseMessage rm=new ResponseMessage(500,"Internal Server Error");
		return JSON.toJSONString(rm,SerializerFeature.DisableCircularReferenceDetect);
	}
}
