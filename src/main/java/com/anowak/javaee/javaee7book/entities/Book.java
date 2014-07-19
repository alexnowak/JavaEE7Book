/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.anowak.javaee.javaee7book.entities;

import com.anowak.javaee.javaee7book.logging.Loggable;
import java.io.Serializable;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Alex
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "findBookH2G2", query = "SELECT b FROM Book b WHERE b.title='H2G2'"),
    @NamedQuery(name = "findAllBooks", query = "SELECT b FROM Book b")
})

public class Book implements Serializable {
    // Don't map logger to database
    @Inject @Transient
    private Logger logger;

    @Id @GeneratedValue
    private Long id;
    
	    
    @NotNull
    private String title;
    @NotNull @Min(value=20, message="Min price is 20!!")
    private Float price;
    @Size(max=200, message="description must be shorter than 200 chars.")
    private String description;
    private String number;
    private Integer nbOfPages;
    private Boolean illustrations;

    private transient int age;
    
    // ---------------------------------------------------
    // Constructors, Getters and Setters
    // ---------------------------------------------------
    public Book() {
    }
    
    @Loggable
    public Book(String title, Float price, String description,Integer nbOfPages, Boolean illustrations) {
	System.out.println("NEW BOOK: Title=\"" + title + "\", Price=$" + price + ", Descr=\"" + description + "\", nbOfPages="+nbOfPages+" illustrations="+illustrations);
	this.title = title;
	this.price = price;
	this.description = description;
	this.nbOfPages = nbOfPages;
	this.illustrations = illustrations;
    }

    public int getAge() {
	return age;
    }
    public void setAge(int age) {
	this.age = age;
    }
    
    public String getTitle() {
	return title;
    }

    public void setTitle(String title) {
	this.title = title;
    }

    public Float getPrice() {
	return price;
    }

    public void setPrice(Float price) {
	this.price = price;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public String getNumber() {
	return number;
    }

    public void setNumber(String number) {
	this.number = number;
    }

    public Integer getNbOfPages() {
	return nbOfPages;
    }

    public void setNbOfPages(Integer nbOfPages) {
	this.nbOfPages = nbOfPages;
    }

    public Boolean isIllustrations() {
	return illustrations;
    }

    public void setIllustrations(Boolean illustrations) {
	this.illustrations = illustrations;
    }
    
    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    @Override
    public String toString() {
	return "ID="+getId()+" Title=\"" + getTitle() + "\", Number=" + getNumber() + ", Desc=\"" + getDescription() 
		+ "\", Price=$"+getPrice();
    }

    
    
}
