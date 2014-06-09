/*
 * Copyright (c) 2014 by Alexander Nowak
 * To be used only with permission.
 */

package com.anowak.javaee.javaee7book.services;

import java.util.Random;
import java.util.logging.Logger;
import javax.inject.Inject;
import com.anowak.javaee.javaee7book.logging.Loggable;

/**
 * The Issn number generator creates an eight-digit random number
 * 
 * @author Alexander Nowak
 */
@EightDigits
public class IssnGenerator implements NumberGenerator {
    @Inject
    private Logger logger;
    
    @Override
    @Loggable
    public String generateNumber() {
	String issn = "8-" + Math.abs(new Random().nextInt());
	logger.info("Generated ISSN:"+issn);
	return issn;
    }
    
}
