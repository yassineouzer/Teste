package com.udemy.Teste.Book;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.udemy.Teste.Book.Category.Category;
import com.udemy.Teste.Book.User.User;
import com.udemy.Teste.Book.User.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Autowired
    private BookRepository BookRepository;

    @Autowired
    private UserRepository UserRepository;
    List<Book> books;
    @GetMapping(value = "/books")
    public ResponseEntity ListBooks(@RequestParam BookStatus status) {

//free books
if(status==BookStatus.free && status!=null){
    
    List<Book>books =BookRepository.FindBystatusAndUserIdNotAndDeletedFalse(status, getConnectedId());
} else  { 

  books= BookRepository.FindByUserIdAndDeletedFalse(getConnectedId());}

        return new ResponseEntity<>(books, HttpStatus.OK);

    }

    private Integer getConnectedId() {
        return 1;

    }

    @PostMapping(value = "/books")
    public ResponseEntity addBook(@Valid @RequestBody Book book) {

       
       
    }
}