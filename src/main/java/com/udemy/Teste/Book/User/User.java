package com.udemy.Teste.Book.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;




@Entity
public class User {
 

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    
    @Size(min=2 , max=25 ,message="le nom doit faire entre 2 et 25 caractères")
    private String firstName;
    @Size(min=2 , max=25 ,message="le nom doit faire entre 2 et 25 caractères")
    private String laststName;

    private String email;
    private String password;





    public User (String email) {
        this.email= email;
     }

    /**
     * @return String return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return String return the laststName
     */
    public String getLaststName() {
        return laststName;
    }

    /**
     * @param laststName the laststName to set
     */
    public void setLaststName(String laststName) {
        this.laststName = laststName;
    }

    /**
     * @return String return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return String return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
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

}