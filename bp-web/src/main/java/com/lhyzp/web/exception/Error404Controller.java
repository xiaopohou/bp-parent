package com.lhyzp.web.exception;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 404处理
 * @author zp
 *
 */
@Controller
public class Error404Controller implements ErrorController {

	private static final String ERROR_PATH = "/error";

	@RequestMapping(value = ERROR_PATH)
	public String handleError() {
		return "404";
	}
	
	@Override
	public String getErrorPath() {
		
		return ERROR_PATH;
	}

}
