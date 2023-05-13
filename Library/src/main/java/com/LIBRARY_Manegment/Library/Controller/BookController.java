package com.LIBRARY_Manegment.Library.Controller;

import com.LIBRARY_Manegment.Library.Modal.Book;
import com.LIBRARY_Manegment.Library.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping("/add")
    public String addBook(@RequestBody Book book) throws Exception{
        return bookService.addBook(book);
    }
    //return book in transaction control
    //find all book
    //find all book of a particular author
    //find name of book written by a author
}
