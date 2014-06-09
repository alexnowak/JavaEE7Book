/*
 * Copyright (c) 2014 by Alexander Nowak
 * To be used only with permission.
 */
package com.anowak.javaee.javaee7book.services;

import com.anowak.javaee.javaee7book.entities.Book;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.inject.Named;
import com.anowak.javaee.javaee7book.logging.Loggable;

/**
 * The BookService Using Dependency Injection and Interception The interceptor binding @Loggable logs the method entry
 * and exit if enabled.
 *
 * @author Alexander Nowak
 */
@Loggable
@Named
public class BookService {

    @Inject
    private Logger logger;

    @Inject
    @ThirteenDigits
    private NumberGenerator numberGenerator;

    private String title, description;
    private Float price;
    private Book book;
    private Integer nbOfPages;
    private Boolean illustrations;

    public String createBook() {
	book = new Book(title, price, description,nbOfPages,illustrations);
	book.setNumber(numberGenerator.generateNumber());
	return "customer.xhtml";

    }

    public Book createBook(String title, Float price, String description,Integer nbOfPages, Boolean illustrations) {
	logger.info("createBook() called");
	book = new Book(title, price, description,nbOfPages,illustrations);
	book.setNumber(numberGenerator.generateNumber());
	return book;
    }

}
