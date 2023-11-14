package com.example.LibraryManagementSystem.Model;


import com.example.LibraryManagementSystem.Response.BookSearchResponse;
/* import jakarta.persistence.*; */
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    @ManyToOne
    //For FK
    @JoinColumn
    private Student student;
    @Enumerated(value = EnumType.STRING)
    private Genre genre;
    @OneToMany(mappedBy = "book")
    private List<Transaction> transactionList;

    private int cost;
    @ManyToOne
    @JoinColumn
    private Author author;
    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;

    public BookSearchResponse to(){
        return BookSearchResponse.builder()
                .id(id)
                .name(name)
                .author(author)
                .cost(cost)
                .genre(genre)
                .student(student)
                .transactionList(transactionList)
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .build();
    }

}
