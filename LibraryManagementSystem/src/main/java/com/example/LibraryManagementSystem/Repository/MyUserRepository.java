package com.example.LibraryManagementSystem.Repository;

import com.example.LibraryManagementSystem.Model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyUserRepository extends JpaRepository<MyUser, Integer> {

    MyUser findByUsername(String username);
}
