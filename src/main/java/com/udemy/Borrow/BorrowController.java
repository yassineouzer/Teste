package com.udemy.Borrow;

import com.udemy.Teste.Book.Category.CategoryRepository;
import com.udemy.Teste.Book.User.User;
import com.udemy.Teste.Book.User.UserRepository;

import java.time.LocalDate;
import java.util.Optional;

import com.udemy.Teste.Book.Book;
import com.udemy.Teste.Book.BookController;
import com.udemy.Teste.Book.BookRepository;
import com.udemy.Teste.Book.BookStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public class BorrowController {
    
    @Autowired
    private CategoryRepository  CategoryRepository;

    @Autowired
    private BookRepository BookRepository;

   @Autowired 
    private BorrowRepository BorrowRepository; 


    @Autowired
    private UserRepository UserRepository;

    @GetMapping(value = "/borrows")
    public ResponseEntity getMyBorrows() {
      Integer userconnected = BookController.getConnectedId();
      List<Borrow> borrows=BorrowRepository.findbyBorrowerId(userconnected);
        return new ResponseEntity<>(borrows,HttpStatus.OK);
}

@PostMapping(value = "/borrows")
public ResponseEntity addBorrow(@PathVariable("bookid") String bookid) {
Optional<Book>borroe= BookRepository.findById(Integer.valueOf(bookid));
Integer userconnected= BookController.getConnectedId();
Optional<User> borrower = UserRepository.findById(Integer.valueOf(userconnected));

if(borroe.isPresent()&& borrower.isPresent()){
    Borrow borrow = new Borrow();
    borrow.setBook(borroe.get());
    borrow.setBorrower(borrower.get());
    borrow.setLender(borroe.get().getUser());
    borrow.setAskdate(LocalDate.now());

    BorrowRepository.save(borrow);
    borroe.get().setBookStatus(BookStatus.borrowed);
    BookRepository.save(borroe.get());

    return new ResponseEntity<>(borroe, HttpStatus.CREATED);
}


    return new ResponseEntity<>(borroe,HttpStatus.BAD_REQUEST);

    
}}