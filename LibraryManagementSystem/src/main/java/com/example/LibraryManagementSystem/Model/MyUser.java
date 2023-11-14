package com.example.LibraryManagementSystem.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
@Entity
public class MyUser implements UserDetails, Serializable {


    public static final String AUTHORITY_DELIMITER=",";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String authority;
    private String password;
    @Column(unique = true, nullable = false)
    private String username;
/*
    @OneToOne(mappedBy = "myUser")
    @JsonIgnoreProperties("myUser")
    private Student student;

    @OneToOne(mappedBy = "myUser")
    @JsonIgnoreProperties("myUser")
    private Admin admin;
  */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String []arr = this.authority.split(AUTHORITY_DELIMITER);

        return Arrays
                .stream(arr)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
