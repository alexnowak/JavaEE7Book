/*
 * Copyright (c) 2014 by Alexander Nowak
 * To be used only with permission.
 */

package com.anowak.javaee.javaee7book.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author Alexander Nowak
 */
public class ZipCodeValidator implements ConstraintValidator<ZipCode,String> {
    @Inject @USA
    private ZipCodeChecker checker = new ZipCodeChecker();
    private Pattern zipPattern = Pattern.compile("\\d{5}(\\d{5})?");

    @Override
    public void initialize(ZipCode zipCode) {
	System.out.println("initialize ZipCodeValidator: " + zipCode.message());
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
	if (value == null)
	    return true;
	
	
	Matcher m = zipPattern.matcher(value);
	System.out.println("ZipCode value="+value + " matches="+m.matches() + " checker="+checker);
	if (!m.matches())
	    return false;
	return checker.isZipCodeValid(value);
    }
    
}
