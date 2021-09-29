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
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return Category return the category
     */
    public Category getCategory() {
        return category;
    }

	public void setCategory(com.udemy.Teste.Book.Category.Category  category2) {
	}

	
    /**
     * @param category2 the category to set
     */
   


    /**
     * @return BookStatus return the BookStatus
     */
    public BookStatus getBookStatus() {
        return BookStatus;
    }

    /**
     * @param BookStatus the BookStatus to set
     */
    public void setBookStatus(BookStatus BookStatus) {
        this.BookStatus = BookStatus;
    }


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
     * @return User return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @return int return the categoryid
     */
    public int getCategoryid() {
        return categoryid;
    }

    /**
     * @param categoryid the categoryid to set
     */
    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

}