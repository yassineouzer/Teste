package com.udemy.Teste.Book.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import lombok.*;


@Data
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





    }
    