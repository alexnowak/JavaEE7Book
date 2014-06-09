/*
 * Copyright 2014 by Alexander NowakTo change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anowak.javaee.javaee7book.logging;

import java.util.logging.Logger;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

/**
 * Because Logger belongs to the JDK, it is not injectable by default (the rt.jar file does not have a beans.xml file) 
 * and it must be produced. 
 * @author Alex
 */
public class LoggingProducer {

    /**
     * The producer method annotated with  @Produces that will create and return a Logger parameterized 
     * with the injection point class name.
     * @param injectionPoint The injection Point
     * @return Logger
     */
    @Produces
    public Logger produceLogger(InjectionPoint injectionPoint) {
	return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
    }
    
}
