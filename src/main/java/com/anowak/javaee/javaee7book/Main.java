package com.anowak.javaee.javaee7book;

import com.anowak.javaee.javaee7book.entities.Book;
import com.anowak.javaee.javaee7book.services.BookService;
import java.util.Random;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

/*
 * Copyright (c) 2014 by Alexander Nowak
 * To be used only with permission.
 */
/**
 *
 * @author Alexander Nowak
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

	System.out.println("Classpath: " + System.getProperty("java.class.path"));
	Weld weld = new Weld();

	System.out.println("CWD: " + System.getProperty("user.dir"));

	WeldContainer container = weld.initialize();
	BookService bookService = container.instance().select(BookService.class).get();

	Book book = bookService.createBook("Huhu", 12.6f, "Geeky SiFi Book", 250, true);
	System.out.println(book);

	storeABook();

	weld.shutdown();
    }

    private static void storeABook() {
	System.out.println("----------------- Enter storeABook --------------------");
	// 1-Creates an instance of a book (POJO)
	Book book = new Book("H2G2", 12.5f, "The Hitchhiker's Guide to the Galaxy", 354, false);
	book.setNumber("8-" + Math.abs(new Random().nextInt()));

	// 2-Obtain an entity manager
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("BookStorePU");
	EntityManager em = emf.createEntityManager();

	// 3-Get transaction and persist the book in the database
	try {
	    EntityTransaction tx = em.getTransaction();
	    tx.begin();
	    em.persist(book);
	    tx.commit();

	    // 4-Execute named Query.
	    Book bookH2G2 = em.createNamedQuery("findBookH2G2", Book.class).getSingleResult();
	    System.out.println("Found book:" + book);

	} catch(ConstraintViolationException cve){
	    System.out.println("ConstraintViolationException caught: ");
	    //cve.printStackTrace();
	    Set<ConstraintViolation<?>> violations = cve.getConstraintViolations();
	    for (ConstraintViolation cv : violations) {
		System.out.println(" - Invalid value="+ cv.getInvalidValue() + ", " + cv.getMessage());
	    }
	} catch (Exception e) {
	    System.out.println("Exception caught: ");
	    e.printStackTrace();
	    em.flush();
	} finally {
	    // 5-Close entity manager and the factory
	    em.close();
	    emf.close();
	}

	System.out.println("Exit storeABook");

    }

}
