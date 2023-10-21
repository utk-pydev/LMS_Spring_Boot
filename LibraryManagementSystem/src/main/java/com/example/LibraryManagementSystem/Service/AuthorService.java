package com.example.LibraryManagementSystem.Service;

import com.example.LibraryManagementSystem.Model.Author;
import com.example.LibraryManagementSystem.Repository.AuthorRepository;
import com.example.LibraryManagementSystem.Response.AuthorSearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;
    public Author getAuthorById(Integer id) throws Exception{
        return authorRepository.findById(id).orElse(null);
    }

    public List<Author> getAllAuthors() throws Exception{
        return authorRepository.findAll();
    }

    public void deleteAuthor(Integer id) throws Exception{
        authorRepository.deleteById(id);
    }

    public void updateAuthor() throws Exception{

    }

}
