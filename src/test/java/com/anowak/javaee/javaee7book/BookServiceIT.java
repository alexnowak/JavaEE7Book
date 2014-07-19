package com.anowak.javaee.javaee7book;

/*
 * Copyright (c) 2014 by Alexander Nowak
 * To be used only with permission.
 */

import com.anowak.javaee.javaee7book.entities.Book;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import com.anowak.javaee.javaee7book.services.BookService;

/**
 *
 * @author Alexander Nowak
 */
public class BookServiceIT {
    
    public BookServiceIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void shouldCheckNumberIsMOCK() {
	Weld weld = new Weld();
	
	WeldContainer container = weld.initialize();
	BookService bookService = container.instance().select(BookService.class).get();
	
	Book book = bookService.createBook("H2G2", 32.6f, "Geeky SiFi Book",123,false);

	System.out.println("Book="+book);
	assertTrue(book.getNumber().startsWith("13-"));

	//book = bookService.createBook(null, 12.6f, "Geeky SiFi Book");

	weld.shutdown();
    }
}
