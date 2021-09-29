package com.udemy.Borrow;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.udemy.Teste.Book.Book;
import com.udemy.Teste.Book.User.User;


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

    /**
     * @return int return the Id
     */
    public int getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(int Id) {
        this.Id = Id;
    }

    /**
     * @return User return the lender
     */
    public User getLender() {
        return lender;
    }

    /**
     * @param lender the lender to set
     */
    public void setLender(User lender) {
        this.lender = lender;
    }

    /**
     * @return User return the borrower
     */
    public User getBorrower() {
        return borrower;
    }

    /**
     * @param borrower the borrower to set
     */
    public void setBorrower(User borrower) {
        this.borrower = borrower;
    }

    /**
     * @return Book return the book
     */
    public Book getBook() {
        return book;
    }

    /**
     * @param book the book to set
     */
    public void setBook(Book book) {
        this.book = book;
    }

    /**
     * @return LocalDate return the askdate
     */
    public LocalDate getAskdate() {
        return askdate;
    }

    /**
     * @param askdate the askdate to set
     */
    public void setAskdate(LocalDate askdate) {
        this.askdate = askdate;
    }

}