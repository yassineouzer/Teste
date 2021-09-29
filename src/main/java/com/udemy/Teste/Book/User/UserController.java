package com.udemy.Teste.Book.User;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    



    @PostMapping(value="/users")
    public ResponseEntity addBook(@Valid @RequestBody User user){
      
  User userOLd = new User("yassine@gmail.com");
         return new ResponseEntity<>(user, HttpStatus.CREATED);
       
    }
}