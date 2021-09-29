package com.udemy.Teste.Book;

import java.util.Arrays;

import javax.validation.Valid;

import com.udemy.Teste.Book.Category.Category;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    

    @GetMapping(value="/books")
    public ResponseEntity ListBooks(){
        Book book = new Book(); 
         book.setTitle("My Book"); 
         book.setCategory(new Category("BD"));

         return new ResponseEntity<>(Arrays.asList(book), HttpStatus.OK);
       
    }

    @PostMapping(value="/books")
    public ResponseEntity addBook(@Valid @RequestBody Book book){
      

         return new ResponseEntity<>(book, HttpStatus.CREATED);
       
    }
}