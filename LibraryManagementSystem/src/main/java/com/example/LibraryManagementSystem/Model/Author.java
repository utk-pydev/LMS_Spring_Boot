package com.example.LibraryManagementSystem.Model;

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
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(name = "land")
    private String country;
    private int age;

    @Column(unique = true, nullable = false)
    private String email;

    @OneToMany(mappedBy = "author")

    private List<Book> bookList;
    @CreationTimestamp
    private Date addedOn;
}
