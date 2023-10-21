package com.example.LibraryManagementSystem.Controller;

import com.example.LibraryManagementSystem.Model.Book;
import com.example.LibraryManagementSystem.Request.BookCreateRequest;
import com.example.LibraryManagementSystem.Request.BookFilterType;
import com.example.LibraryManagementSystem.Response.BookSearchResponse;
import com.example.LibraryManagementSystem.Service.BookService;
import jakarta.validation.Valid;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    private static final Logger logger = (Logger) LoggerFactory.getLogger(BookController.class);
    @PostMapping("/book")
    public void createBook(@Valid @RequestBody BookCreateRequest bookCreateRequest) {
        try {
            bookService.create(bookCreateRequest);
        }
        catch (Exception exception){
            logger.info(exception.getMessage());
        }
    }

    @GetMapping("/book/search")
    public List<Book> getBookFilter(@RequestParam("FilterType") String filterType, @RequestParam("value")String value){
        try {
            return bookService.find(BookFilterType.valueOf(filterType), value);
        }catch (Exception exception){
            logger.info(exception.getMessage());
        }
        return null;
    }

    @GetMapping("/book")
    public List<BookSearchResponse> getAllBooks() {
        try {
            return bookService.getListOfBooks()
                    .stream()
                    .map(Book::to)
                    .collect(Collectors.toList());
        }catch (Exception exception){
            logger.info(exception.getMessage());
        }
        return null;
    }
    @DeleteMapping("/book/{id}")
    public boolean deleteBook(@PathVariable("id") Integer id) {
        try{
             bookService.delete(id);
        }catch (Exception exception){
            logger.info(exception.getMessage());
        }
        return true;
    }
    @PutMapping("/book")
    public void updateBook(@Valid @RequestBody BookCreateRequest bookCreateRequest){
        try{
            bookService.create(bookCreateRequest);
        }catch (Exception exception){
            logger.info(exception.getMessage());
        }
    }
    @GetMapping("/book/{id}")
    public BookSearchResponse findBookById(Integer id){
        try{
            return bookService.findBookById(id).to();
        }catch (Exception exception){
            logger.info(exception.getMessage());
        }
        return null;
    }
}
