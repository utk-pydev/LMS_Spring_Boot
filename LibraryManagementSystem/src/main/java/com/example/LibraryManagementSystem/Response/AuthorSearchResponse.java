package com.example.LibraryManagementSystem.Response;

import com.example.LibraryManagementSystem.Model.Book;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthorSearchResponse {
    private int id;
    private String name;
    private String country;
    private int age;
    private String email;
    @JsonIgnoreProperties({"student", "author", "transactionList"})
    private List<Book> bookList;
    private Date addedOn;
}
