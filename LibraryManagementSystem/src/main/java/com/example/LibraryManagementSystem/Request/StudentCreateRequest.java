package com.example.LibraryManagementSystem.Request;

import com.example.LibraryManagementSystem.Model.*;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank
    private String username;
    @NotBlank
    private String password;

    public Student to(){
        return Student.builder()
                .name(this.name)
                .email(this.email)
                .address(this.address)
                .contact(this.contact)
                .username(this.username)
                .password(this.password)
                .accountStatus(AccountStatus.ACTIVE)
                .isActive(true)
                .build();
    }

    public UserCreateRequest toUser(){
        return UserCreateRequest.builder()
                .student(to())
                .username(this.username)
                .password(this.password)
                .build();
    }

}
