/*
 * Copyright (c) 2014 by Alexander Nowak
 * To be used only with permission.
 */

package com.anowak.javaee.javaee7book.entities;

import com.anowak.javaee.javaee7book.entities.Customer;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Alexander Nowak
 */
public class CustomerTest {
    private static ValidatorFactory vf;
    private static Validator validator;

    @BeforeClass
    public static void setUpClass() {
	vf = Validation.buildDefaultValidatorFactory();
	validator = vf.getValidator();
    }
    
    @AfterClass
    public static void tearDownClass() {
	vf.close();
    }

    
    public CustomerTest() {
    }
    
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void shouldRaiseNoConstraintViolation() {
	// new GregorianCalendar(1968, Calendar.MAY, 1)).getTime()
	Customer customer = new Customer("joe", "Smoe", "jsmoe@email.com", new Date());
	Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
	assertEquals(0, violations.size());
    }
    
    @Test
    public void shouldRaiseConstraintViolationCauseInvalidEmail() {
	Customer customer = new Customer("joe", "Smoe", "jsmoe-email.com", new Date(System.currentTimeMillis()-1));
	Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
	
	System.out.println("Found " + violations.size()+" violation(s):");
	for (ConstraintViolation<Customer> v : violations) {
	    System.out.println(" - VIOLATION: "+v.getMessage());
	}
	
		
	assertEquals(1, violations.size());
	System.out.println("Msg"+ violations.iterator().next().getMessage());
	//assertEquals("invalid email address", violations.iterator().next().getMessage());
	assertEquals("jsmoe-email.com", violations.iterator().next().getInvalidValue());
	assertEquals("{validator.Email.message}", violations.iterator().next().getMessageTemplate());
    }
	    
    
}
