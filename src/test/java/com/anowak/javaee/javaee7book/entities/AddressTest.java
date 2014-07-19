/*
 * Copyright (c) 2014 by Alexander Nowak
 * To be used only with permission.
 */

package com.anowak.javaee.javaee7book.entities;

import com.anowak.javaee.javaee7book.entities.Address;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
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
public class AddressTest {
    private static ValidatorFactory vf;
    private static Validator validator;

	public AddressTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
	vf = Validation.buildDefaultValidatorFactory();
	validator = vf.getValidator();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
	vf.close();
    }

    @Test
    public void shouldRaiseNoError() {
//	public Address(String street1, String street2, String city, String state, String zipCode, String country) {

	
	Address address = new Address("123 Spring St", null, "New York", "NY", "12345", "USA");
	
	Set<ConstraintViolation<Address>> validations = validator.validate(address);
	assertEquals(0, validations.size());
    }
    
}
