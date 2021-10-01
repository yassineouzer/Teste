package com.udemy.Borrow;

import java.util.List;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowRepository  extends CrudRepository<Borrow, Integer> {
   List<Borrow> findbyBorrowerId(Integer borrowerid);
   List<Borrow>   findbyBookId(Integer bookId);
}