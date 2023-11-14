package com.example.LibraryManagementSystem.Request;

import com.example.LibraryManagementSystem.Model.Admin;
import com.example.LibraryManagementSystem.Model.Student;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateRequest {

    private String authority;
    private String password;
    private String username;

    private Student student;
    private Admin admin;
}
