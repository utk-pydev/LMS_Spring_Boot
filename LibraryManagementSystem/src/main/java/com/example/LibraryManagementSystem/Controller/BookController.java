package com.example.LibraryManagementSystem.Controller;

import com.example.LibraryManagementSystem.Model.Book;
import com.example.LibraryManagementSystem.Request.BookCreateRequest;
import com.example.LibraryManagementSystem.Request.BookFilterType;
import com.example.LibraryManagementSystem.Response.BookSearchResponse;
import com.example.LibraryManagementSystem.Service.BookService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);
    @PostMapping("/book")
    public ResponseEntity<Boolean> createBook(@Valid @RequestBody BookCreateRequest bookCreateRequest) {
        try {
            bookService.create(bookCreateRequest);
            return ResponseEntity.ok(true);
        }
        catch (Exception exception){
            logger.info(exception.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }

    @GetMapping("/book/search")
    public ResponseEntity<List<BookSearchResponse>> getBookFilter(@RequestParam("FilterType") String filterType, @RequestParam("value")String value){
        try {
            List<BookSearchResponse>books = bookService
                    .find(BookFilterType.valueOf(filterType), value)
                    .stream()
                    .map(Book::to)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(books);
        }catch (Exception exception) {
            logger.info(exception.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/book")
    public ResponseEntity<List<BookSearchResponse>> getAllBooks() {
        try {
            List<BookSearchResponse> books = bookService.getListOfBooks()
                    .stream()
                    .map(Book::to)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(books);
        }catch (Exception exception) {
            logger.info(exception.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @DeleteMapping("/book/{id}")
    public ResponseEntity<Boolean> deleteBook(@PathVariable("id") Integer id) {
        try{
             bookService.delete(id);
             return ResponseEntity.ok(true);
        }catch (Exception exception){
            logger.info(exception.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }
    @PutMapping("/book")
    public ResponseEntity<Boolean> updateBook(@Valid @RequestBody BookCreateRequest bookCreateRequest){
        try{
            bookService.create(bookCreateRequest);
            return ResponseEntity.ok(true);
        }catch (Exception exception){
            logger.info(exception.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }
    @GetMapping("/book/{id}")
    public ResponseEntity<BookSearchResponse> findBookById(Integer id){
        try{
            BookSearchResponse book =  bookService.findBookById(id).to();
            return ResponseEntity.ok(book);
        }catch (Exception exception) {
            logger.info(exception.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
