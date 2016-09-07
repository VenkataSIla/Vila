package com.vsi.boot.config;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class CustomHandlerExceptionResolver implements HandlerExceptionResolver {

	protected final Log logger = LogFactory.getLog(getClass());
	
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object command, Exception e) {
			logger.error(e.getMessage());
		
		Map<String, Object> modelData = new HashMap<String, Object>();
	
		
		return new ModelAndView("redirect:error1", modelData);	
	}

}
