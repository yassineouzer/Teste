package com.udemy.Teste.Book.Category;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.*;

@Data
@Entity
public class Category {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String label;

}

    

  