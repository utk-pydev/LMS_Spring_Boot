package com.example.LibraryManagementSystem.Service;

import com.example.LibraryManagementSystem.Model.Author;
import com.example.LibraryManagementSystem.Model.Book;
import com.example.LibraryManagementSystem.Repository.AuthorRepository;
import com.example.LibraryManagementSystem.Repository.BookRepository;
import com.example.LibraryManagementSystem.Request.BookCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    public void create(BookCreateRequest bookCreateRequest){
        Book book = bookCreateRequest.to();
        Author author = authorRepository.save(book.getAuthor());
        book.setAuthor(author);
        bookRepository.save(book);
    }
}
