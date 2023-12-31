package com.example.LibraryManagementSystem.Response;

import com.example.LibraryManagementSystem.Model.Author;
import com.example.LibraryManagementSystem.Model.Genre;
import com.example.LibraryManagementSystem.Model.Student;
import com.example.LibraryManagementSystem.Model.Transaction;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.Date;
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
    @JsonIgnoreProperties({"bookList", "addedOn"})
    private Author author;
    @JsonIgnoreProperties({"bookList"})
    private Student student;
    @JsonIgnoreProperties({"book"})
    private List<Transaction> transactionList;
    private Date createdAt;
    private Date updatedAt;
}
