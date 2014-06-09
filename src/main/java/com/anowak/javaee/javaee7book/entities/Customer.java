/*
 * Copyright (c) 2014 by Alexander Nowak
 * To be used only with permission.
 */

package com.anowak.javaee.javaee7book.entities;

import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import com.anowak.javaee.javaee7book.validator.Email;

/**
 *
 * @author Alexander Nowak
 */
public class Customer {
    @NotNull @Size(min = 2, max = 200)
    private String firstName;
    private String lastName;
    @Email
    private String email;
    private String PhoneNr;
    @Past
    private Date dateOfBirth;
    private Address deliveryAddress;
    
    public Customer(String firstName, String lastName, String email, Date dateOfBirth) {
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
	this.dateOfBirth = dateOfBirth;		
    }
}
