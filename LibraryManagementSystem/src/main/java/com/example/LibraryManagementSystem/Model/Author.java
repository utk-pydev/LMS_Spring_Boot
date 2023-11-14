package com.example.LibraryManagementSystem.Model;

import com.example.LibraryManagementSystem.Response.AuthorSearchResponse;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;
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

    public AuthorSearchResponse to(){
        return AuthorSearchResponse.builder()
                .id(id)
                .age(age)
                .email(email)
                .country(country)
                .addedOn(addedOn)
                .build();
    }
}
