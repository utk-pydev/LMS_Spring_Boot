package com.example.LibraryManagementSystem.Service;

import com.example.LibraryManagementSystem.Model.Author;
import com.example.LibraryManagementSystem.Model.Book;
import com.example.LibraryManagementSystem.Model.Genre;
import com.example.LibraryManagementSystem.Repository.AuthorRepository;
import com.example.LibraryManagementSystem.Repository.BookRepository;
import com.example.LibraryManagementSystem.Request.BookCreateRequest;
import com.example.LibraryManagementSystem.Request.BookFilterType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    public void create(BookCreateRequest bookCreateRequest){
        Book book = bookCreateRequest.to();
        Author author = book.getAuthor();


        /*
        * Always use JPQL queries because JPA will validate all the queries then only our application will start where as native queries will not be validated and might give error during runtime
        *JPQL checks with JAVA class whereas Native Query interacts with DB
        * Cache is used only when hit ratio > 60%
        *
        * */

        Author authorFromDB = authorRepository.findByEmail(author.getEmail());
        if(authorFromDB == null){
            authorFromDB = authorRepository.save(author);
        }

        book.setAuthor(authorFromDB);
        bookRepository.save(book);
    }
    public List<Book> find(BookFilterType bookFilterType, String value){
        switch (bookFilterType){
            case NAME:
                return bookRepository.findByName(value);
            case AUTHOR_NAME:
                return bookRepository.findByAuthor_Name(value);
            case GENRE:
                return bookRepository.findByGenre(Genre.valueOf(value));
            default:
                return new ArrayList<>();

    }
}
    public List<Book> find2(BookFilterType bookFilterType, String value){
        switch (bookFilterType){
            case NAME:
                return bookRepository.findByName(value);
            case AUTHOR_NAME:
                return bookRepository.findByAuthor_Name(value);
            case GENRE:
                return bookRepository.findByGenre(Genre.valueOf(value));
            default:
                return new ArrayList<>();
        }
    }
}