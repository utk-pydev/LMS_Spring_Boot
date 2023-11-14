package com.example.LibraryManagementSystem.Response;

import com.example.LibraryManagementSystem.Model.AccountStatus;
import com.example.LibraryManagementSystem.Model.Book;
import com.example.LibraryManagementSystem.Model.Transaction;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentSearchResponse {
    private int id;
    private String name;
    private String contact;
    private String address;
    private String email;
    @JsonIgnoreProperties({"student", "author", "transactionList"})
    private List<Book> bookList;
    @JsonIgnoreProperties({"book"})
    private List<Transaction>transactionList;
    private AccountStatus accoutStatus;
    private boolean isActive;
}
