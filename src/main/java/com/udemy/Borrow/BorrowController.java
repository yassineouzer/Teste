package com.udemy.Borrow;

import com.udemy.Teste.Book.Category.CategoryRepository;
import com.udemy.Teste.Book.User.User;
import com.udemy.Teste.Book.User.UserRepository;

import java.time.LocalDate;
import java.util.List;
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
import org.springframework.web.bind.annotation.DeleteMapping;

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
  Integer userconnected= BookController.getConnectedId();
Optional<Book> boroe =BookRepository.findById(Integer.valueOf(bookid));
Optional<User>userconnected1 =UserRepository.findById(userconnected);
if(!boroe.isPresent() && !userconnected1.isPresent()){
    return new ResponseEntity<>("book is unexisting",HttpStatus.BAD_REQUEST);
}
Borrow borow = new Borrow();
borow.setBook(boroe.get());
borow.setBorrower(userconnected1.get());
borow.setAskdate(LocalDate.now());
borow.setLender(boroe.get().getUser());
BorrowRepository.save(borow);
boroe.get().setBookStatus(BookStatus.borrowed);
BookRepository.save(boroe.get());
    return new ResponseEntity<>(HttpStatus.CREATED);
}


      
@DeleteMapping(value="/borrows/{birrowd}")
public ResponseEntity deleteborrow(@PathVariable("borrowid") String borrowid) {
Optional<Borrow>borrow1=BorrowRepository.findById(Integer.valueOf(borrowid));
 Borrow borow = borrow1.get();
 borow.setClosedate(LocalDate.now());
 BorrowRepository.save(borow);
  Book book= borow.getBook();
  book.setBookStatus(BookStatus.free);
BookRepository.save(book);
    return null;
 

}






}