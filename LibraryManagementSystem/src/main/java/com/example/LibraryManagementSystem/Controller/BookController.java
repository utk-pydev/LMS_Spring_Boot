package com.example.LibraryManagementSystem.Controller;

import com.example.LibraryManagementSystem.Request.BookCreateRequest;
import com.example.LibraryManagementSystem.Service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/book")
    public void createBook(@Valid @RequestBody BookCreateRequest bookCreateRequest) {
        bookService.create(bookCreateRequest);
    }
}
