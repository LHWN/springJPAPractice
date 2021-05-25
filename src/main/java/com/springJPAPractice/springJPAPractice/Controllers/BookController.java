package com.springJPAPractice.springJPAPractice.Controllers;

import com.springJPAPractice.springJPAPractice.DAO.BookDAO;
import com.springJPAPractice.springJPAPractice.Models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/books")
public class BookController {

    @Autowired
    private BookDAO bookDAO;

    @RequestMapping(value = "/create")
    public Book create() {
        Book book = new Book();

        book.setId(1L);
        book.setName("Flyway");
        book.setAuthor("LHWN");

        bookDAO.save(book);

        return book;
    }
}
