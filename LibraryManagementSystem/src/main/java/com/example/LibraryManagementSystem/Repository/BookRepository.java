package com.example.LibraryManagementSystem.Repository;

import com.example.LibraryManagementSystem.Model.Book;
import com.example.LibraryManagementSystem.Model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book>findByName(String name);

    List<Book>findByAuthor_Name(String authorName);
    List<Book>findByGenre(Genre genre);

}
