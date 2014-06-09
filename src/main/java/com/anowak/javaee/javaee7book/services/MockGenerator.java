/*
 * Copyright (c) 2014 by Alexander Nowak
 * To be used only with permission.
 */

package com.anowak.javaee.javaee7book.services;

import java.util.Random;
import java.util.logging.Logger;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import com.anowak.javaee.javaee7book.logging.Loggable;

/**
 *
 * @author Alexander Nowak
 */
@Alternative
@ThirteenDigits
public class MockGenerator implements NumberGenerator {
    @Inject
    private Logger logger;
    
    @Override
    @Loggable
    public String generateNumber() {
	String mock = "MOCK-" + Math.abs(new Random().nextInt());
	logger.info("Generated Mock: "+mock);
	return mock;
    }
    
    
}
