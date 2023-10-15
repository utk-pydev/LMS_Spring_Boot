package com.example.LibraryManagementSystem.Response;

import com.example.LibraryManagementSystem.Model.Author;
import com.example.LibraryManagementSystem.Model.Genre;
import com.example.LibraryManagementSystem.Model.Student;
import com.example.LibraryManagementSystem.Model.Transaction;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookSearchResponse {

    private int id;
    private String name;
    private int cost;
    private Genre genre;
    @JsonIgnoreProperties("bookList")
    private Author author;
    private Student student;
    private List<Transaction> transactionList;
}
