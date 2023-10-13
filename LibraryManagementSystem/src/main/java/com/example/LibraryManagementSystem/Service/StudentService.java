package com.example.LibraryManagementSystem.Service;

import com.example.LibraryManagementSystem.Model.Author;
import com.example.LibraryManagementSystem.Model.Book;
import com.example.LibraryManagementSystem.Model.Student;
import com.example.LibraryManagementSystem.Repository.StudentRepository;
import com.example.LibraryManagementSystem.Request.BookCreateRequest;
import com.example.LibraryManagementSystem.Request.StudentCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public void create(StudentCreateRequest studentCreateRequest){
        Student student = studentCreateRequest.to();
        studentRepository.save(student);
    }


}
