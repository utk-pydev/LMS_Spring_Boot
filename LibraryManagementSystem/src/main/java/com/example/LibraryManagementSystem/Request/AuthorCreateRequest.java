package com.example.LibraryManagementSystem.Request;
import com.example.LibraryManagementSystem.Model.Author;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthorCreateRequest {
    @NotBlank
    private String name;
    private String country;
    private int age;
    @NotBlank
    private String email;
    public Author to() {
        return Author.builder()
                .name(this.name)
                .country(this.country)
                .age(this.age)
                .email(this.email)
                .build();
    }
}
