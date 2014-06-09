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
 * The IsbnGenerator is qualified with @ThirteenDigits. This informs CDI that the number generated
 * is made of 13 digits. 
 * Notice that the IsbnGenerator class also uses injection to get a java.util.logging.Logger
 * and the interceptor binding @Loggable to log the method entry and exit
 * 
 * @author Alexander Nowak
 */
@ThirteenDigits
public class IsbnNumberGenerator implements NumberGenerator {
    @Inject
    private Logger logger;

    @Override
    @Loggable
    public String generateNumber() {
	String isbn = "13-123456-" + Math.abs(new Random().nextInt());
	logger.info("Generated ISBN: "+isbn);
	return isbn;
    }
    
    
}
