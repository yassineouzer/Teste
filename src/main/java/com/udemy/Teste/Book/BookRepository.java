package com.udemy.Teste.Book;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
    List<Book> FindBystatusAndUserIdNotAndDeletedFalse(BookStatus status, Integer userid);
    List<Book> FindByUserIdAndDeletedFalse(Integer id);
}