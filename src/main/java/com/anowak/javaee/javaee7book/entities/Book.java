/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.anowak.javaee.javaee7book.entities;

import java.io.Serializable;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.anowak.javaee.javaee7book.logging.Loggable;

/**
 *
 * @author Alex
 */
@Entity
@NamedQuery(name = "findBookH2G2", query = "SELECT b FROM Book b WHERE b.title='H2G2'")
public class Book implements Serializable {
    @Inject
    private Logger logger;

    @Id @GeneratedValue
    private Long id;
    
	    
    @NotNull
    private String title;
    @NotNull @Min(20)
    private Float price;
    @Size(max=200)
    private String description;
    private String number;
    private Integer nbOfPages;
    private Boolean illustrations;

    

    // ---------------------------------------------------
    // Constructors, Getters and Setters
    // ---------------------------------------------------
    public Book() {
    
    }
    
    @Loggable
    public Book(String title, Float price, String description,Integer nbOfPages, Boolean illustrations) {
	System.out.println("NEW BOOK: " + title + ", " + price + ", " + description + ", logger="+logger);
	this.title = title;
	this.price = price;
	this.description = description;
	this.nbOfPages = nbOfPages;
	this.illustrations = illustrations;
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
    
    @Override
    public String toString() {
	return "Title=\"" + getTitle() + "\", Number=" + getNumber() + ", Desc=\"" + getDescription() 
		+ "\", Price=$"+getPrice();
    }
    
    
}
