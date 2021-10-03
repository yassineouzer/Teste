package com.udemy.Teste.Book.User;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    
@Autowired
private UserRepository UserRepository;

    @PostMapping(value="/users")
    public ResponseEntity addBook(@Valid @RequestBody User user){
      
  List<User>user1=UserRepository.findByEmail(user.getEmail());
  
  if(!user1.isEmpty()){
    return new ResponseEntity<>("user is already exist",HttpStatus.BAD_REQUEST);}
  
    UserRepository.save(user);
  
  return new ResponseEntity<>(user,HttpStatus.CREATED);
    
}}