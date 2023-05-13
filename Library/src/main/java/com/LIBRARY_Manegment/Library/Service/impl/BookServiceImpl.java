package com.LIBRARY_Manegment.Library.Service.impl;

import com.LIBRARY_Manegment.Library.Modal.Author;
import com.LIBRARY_Manegment.Library.Modal.Book;
import com.LIBRARY_Manegment.Library.Repository.AuthorRepository;
import com.LIBRARY_Manegment.Library.Repository.BookRepository;
import com.LIBRARY_Manegment.Library.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService  {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;
    @Override
    public String addBook(Book book) throws Exception {
        Author author;
        try{
             author=authorRepository.findById(book.getAuthor().getId()).get();
        }
        catch (Exception e)
        {
           throw  new Exception("Author not present");
        }
        author.getBooks().add(book);
       book.setAuthor(author);

       authorRepository.save(author);
       return " Book added";
    }

}
