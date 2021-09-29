package com.udemy.Borrow;

import java.util.List;

import com.udemy.Teste.Book.Book;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowRepository  extends CrudRepository<Borrow, Integer> {
   List<Borrow> findbyBorrowerId(Integer borrowerid);
   List<Book>   findbyBookId(Integer bookId);
}