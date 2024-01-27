package com.example.LibraryManagementSystem;

import com.example.LibraryManagementSystem.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestH2Repository extends JpaRepository<Book, Integer> {
}
