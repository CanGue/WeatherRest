package com.jcn.weatherapp.Interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Interceptor
public class ExceptionLogger {
	

	
	@AroundInvoke
	public Object collectBasicLoggingInformation(InvocationContext context) throws Exception{
		
		Logger logger = LoggerFactory.getLogger(context.getClass());
		logger.info("Method Called: " + context.getMethod().getName());
		logger.info("Parameters: " + context.getParameters().toString());
		return context.proceed();
		
		
	}
}
