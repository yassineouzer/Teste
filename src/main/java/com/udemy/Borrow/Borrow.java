package com.udemy.Borrow;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.udemy.Teste.Book.Book;
import com.udemy.Teste.Book.User.User;
import lombok.*;


@Data
@Entity
public class Borrow {
    
   
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   
    private int Id;
    @ManyToOne
    private User lender;
    @ManyToOne
    private User borrower;
    @ManyToOne
    private Book book;
    private LocalDate askdate;
    private LocalDate  closedate;

   



}