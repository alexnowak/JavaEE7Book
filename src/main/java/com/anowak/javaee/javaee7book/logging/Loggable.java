/*
 * Copyright (c) 2014 by Alexander Nowak
 * To be used only with permission.
 */

package com.anowak.javaee.javaee7book.logging;

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import javax.interceptor.InterceptorBinding;

/**
 *
 * @author Alexander Nowak
 */
@InterceptorBinding
@Target({METHOD, TYPE, CONSTRUCTOR})
@Retention(RUNTIME)
public @interface Loggable { }
