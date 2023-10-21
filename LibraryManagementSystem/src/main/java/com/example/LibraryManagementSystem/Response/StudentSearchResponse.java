package com.example.LibraryManagementSystem.Response;

import com.example.LibraryManagementSystem.Model.AccoutStatus;
import com.example.LibraryManagementSystem.Model.Book;
import com.example.LibraryManagementSystem.Model.Transaction;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
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
    private AccoutStatus accoutStatus;
    private boolean isActive;
}
