/*
 * Copyright (c) 2014 by Alexander Nowak
 * To be used only with permission.
 */

package com.anowak.javaee.javaee7book.services;

import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.inject.Named;

/**
 *
 * @author Alexander Nowak
 */
@Dependent
@Named
@Stateless
public class MessageServerBean {
    public String getMessage() {
	return "Hello EJB!";
    }
}
