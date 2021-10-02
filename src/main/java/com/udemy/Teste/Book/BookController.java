package com.udemy.Teste.Book;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.udemy.Borrow.Borrow;
import com.udemy.Borrow.BorrowRepository;
import com.udemy.Teste.Book.Category.Category;
import com.udemy.Teste.Book.Category.CategoryRepository;
import com.udemy.Teste.Book.User.User;
import com.udemy.Teste.Book.User.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Autowired
    private CategoryRepository  CategoryRepository;

    @Autowired
    private BookRepository BookRepository;

   @Autowired 
    private BorrowRepository BorrowRepository; 


    @Autowired
    private UserRepository UserRepository;


    List<Book> books;

    Integer userconnected=this.getConnectedId();

    @GetMapping(value = "/books")
    public ResponseEntity ListBooks(@RequestParam BookStatus status) {

//free books
if(status==BookStatus.free && status!=null){
    
    List<Book>books =BookRepository.FindBystatusAndUserIdNotAndDeletedFalse(status,userconnected);
} else  { 

  books= BookRepository.FindByUserIdAndDeletedFalse(userconnected);}

        return new ResponseEntity<>(books, HttpStatus.OK);

    }

    private Integer getConnectedId() {
        return 1;

    }

    @PostMapping(value = "/books")
    public ResponseEntity addBook(@Valid @RequestBody Book book) {

  books= BookRepository.FindByUserIdAndDeletedFalse(userconnected);
      Optional<User>user= UserRepository.findById(userconnected);
      Optional<Category> category = CategoryRepository.findById(book.getCategoryid());
      
if(category.isPresent()){
  book.setCategory(category.get());
}
else {
    return new ResponseEntity<>("you must provide a valid category" , HttpStatus.BAD_REQUEST);
}
  if(user.isPresent()){

book.setUser(user.get());
}
else {
    return new ResponseEntity<>("the user does'nt exixte" ,HttpStatus.BAD_REQUEST);}
    book.setDeleted(false);
    book.setBookStatus(BookStatus.free);
    BookRepository.save(book);
     return new ResponseEntity<>(book,HttpStatus.CREATED);

}
@DeleteMapping(value="/books/{bookid}")
public ResponseEntity delete(@PathVariable("bookid") String bookid) {
    
           Optional<Book>bookTodelete =BookRepository.findById(Integer.valueOf(bookid));
           if(!bookTodelete.isPresent()){
            return new ResponseEntity("you must provide an existing book",HttpStatus.BAD_REQUEST);
           }
          Book book = bookTodelete.get();
          
         List<Borrow>borrows= BorrowRepository.findbyBookId(book.getId());

         for(Borrow borrow:borrows){
             if(borrow.getClosedate()== null){
                 User borrower = borrow.getBorrower();
                 return new ResponseEntity<>(borrower,HttpStatus.CONFLICT);

         }    book.setDeleted(true);
              BookRepository.save(book);
        }
return null;
    
}

    @PutMapping(value="/books/bookid")
public ResponseEntity update(@PathVariable("bookid") String bookid,@RequestBody Book book) {

    Optional<Book>bookToupdate=BookRepository.findById(Integer.valueOf(bookid));
       if(!bookToupdate.isPresent()){
           return new ResponseEntity<>("book is unexisting",HttpStatus.BAD_REQUEST);
       }
     Book booktosave =  bookToupdate.get();
      Optional<Category> NewCategory = CategoryRepository.findById(book.getCategoryid());
      booktosave.setCategory(NewCategory.get());
      booktosave.setTitle(book.getTitle());
      BookRepository.save(booktosave);

    return new ResponseEntity<>(booktosave ,HttpStatus.OK);


}}
