package com.example.LibraryManagementSystem.Request;

import com.example.LibraryManagementSystem.Model.Author;
import com.example.LibraryManagementSystem.Model.Book;
import com.example.LibraryManagementSystem.Model.Genre;
import jakarta.servlet.http.PushBuilder;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookCreateRequest {



    @NotBlank
    private String name;

    /*
    * Empty string will pass through with Not Null attribute
    * */
    @NotNull
    private Author author;
    @Positive
    private int cost;
    @NotNull
    private Genre genre;

    public Book to(){
        return Book.builder()
                .cost(this.cost)
                .genre(this.genre)
                .name(this.name)
                .author(this.author)
                .build();
    }


}
