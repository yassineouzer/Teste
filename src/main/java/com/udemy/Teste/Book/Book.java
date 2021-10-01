package com.udemy.Teste.Book;

import java.util.Locale.Category;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

import com.udemy.Teste.Book.User.User;

import lombok.*;

@Data
@Entity
public class Book {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

     @NotBlank
    private String title;

    @ManyToOne
    private Category category;

     @ManyToOne    
    private User  user;
    private BookStatus BookStatus; 

    @Transient
    private int categoryid;

    private  boolean deleted;
    /**
     * @return String return the title
     */
    

    /**
     * @return User return the user
     */
   

}