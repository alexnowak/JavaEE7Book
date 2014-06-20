/*
 * Copyright (c) 2014 by Alexander Nowak
 * To be used only with permission.
 */

package com.anowak.javaee.javaee7book.logging;

import java.util.logging.Logger;
import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.AroundConstruct;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 *
 * @author Alexander Nowak
 */
@Interceptor
@Loggable
//@Priority(Interceptor.Priority.LIBRARY_BEFORE + 10)
public class LoggingInterceptor {
    @Inject
    private Logger logger;
    
    @AroundInvoke
    public Object logMethod(InvocationContext ic) throws Exception {
	
	    logger.entering(ic.getTarget().getClass().getName(),ic.getMethod().getName());
	try {
	    return ic.proceed();
	} finally {
	    logger.exiting(ic.getTarget().getClass().getName(), ic.getMethod().getName());
	}
    }
    
    @AroundConstruct
    public Object logConstructor(InvocationContext ic) throws Exception {
	System.out.println("logConstructor, logger=" + logger + " ic="+ic);
	
	// Note, ic.getTarget() is null whne called befor ic.proceed()!!
	logger.entering("Constructor",ic.getConstructor().getName());

	try {
	    return ic.proceed();
	} finally {
	    	System.out.println(ic.getTarget().getClass().getName() + ": "+ ic.getConstructor().getName() + " - EXIT");

		logger.exiting(ic.getTarget().getClass().getName(), ic.getConstructor().getName());
	}
    }
    
  
}
