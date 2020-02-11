package com.example.demo.handler;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler
{
	@ExceptionHandler(Exception.class)//需要捕获的异常类型
	@ResponseBody
	private Map<String, Object> exceptionHandler(HttpServletRequest req, Exception e)
	{
		Map<String, Object> modelMap =  new HashMap<>();
		modelMap.put("success", false);
		modelMap.put("errMsg", e.getMessage());
		return modelMap;
	}
}
