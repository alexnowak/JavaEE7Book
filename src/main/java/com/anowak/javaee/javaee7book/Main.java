package com.anowak.javaee.javaee7book;


import com.anowak.javaee.javaee7book.entities.Book;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import com.anowak.javaee.javaee7book.services.BookService;




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
	
	Book book = bookService.createBook("Huhu", 12.6f, "Geeky SiFi Book",250,true);
	System.out.println(book);
	
	storeABook();
	
	weld.shutdown();
    }

    private static void storeABook() {
	System.out.println("Enter storeABook");
	// 1-Creates an instance of a book (POJO)
	Book book = new Book("H2G2",12.5f,"The Hitchhiker's Guide to the Galaxy",354,false);
	
	// 2-Obtain an entity manager
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("BookStorePU");
	EntityManager em = emf.createEntityManager();
	
	// 3-Get transaction and persist the book in the database
	EntityTransaction tx = em.getTransaction();
	tx.begin();
	em.persist(book);
	tx.commit();
	
	// 4-Execute named Query.
	Book bookH2G2 = em.createNamedQuery("findBookH2G2",Book.class).getSingleResult();
	
	// 5-Close entity manager and the factory
	em.close();
	emf.close();
	System.out.println("Exit storeABook");
	
    }
    
}
