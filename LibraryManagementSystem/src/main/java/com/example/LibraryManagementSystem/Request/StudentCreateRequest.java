package com.example.LibraryManagementSystem.Request;

import com.example.LibraryManagementSystem.Model.Author;
import com.example.LibraryManagementSystem.Model.Book;
import com.example.LibraryManagementSystem.Model.Genre;
import com.example.LibraryManagementSystem.Model.Student;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentCreateRequest {

    @NotBlank
    private String name;
    @NotBlank
    private String contact;
    private String address;
    private String email;


    public Student to(){
        return Student.builder()
                .name(this.name)
                .email(this.email)
                .address(this.address)
                .contact(this.contact)
                .build();
    }

}