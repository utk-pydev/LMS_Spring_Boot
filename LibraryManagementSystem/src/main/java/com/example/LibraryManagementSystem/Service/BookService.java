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
        Author author = book.getAuthor();


        /*
        * Always use JPQL queries because JPA will validate all the queries then only our application will start where as native queries will not be validated and might give error during runtime
        *JPQL checks with JAVA class whereas Native Query interacts with DB
        * Cache is used only when hit ratio > 60%
        *
        * */

        Author authorFromDB = authorRepository.getAuthorGivenEmailIdJPQL(author.getEmail());
        if(authorFromDB == null){
            authorFromDB = authorRepository.save(author);
        }

        book.setAuthor(authorFromDB);
        bookRepository.save(book);
    }
}
