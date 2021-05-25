package com.springJPAPractice.springJPAPractice.DAO;

import com.springJPAPractice.springJPAPractice.Models.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDAO extends CrudRepository<Book, Long> {
}
