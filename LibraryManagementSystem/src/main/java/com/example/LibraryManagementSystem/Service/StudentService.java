package com.example.LibraryManagementSystem.Service;

import com.example.LibraryManagementSystem.Model.AccountStatus;
import com.example.LibraryManagementSystem.Model.MyUser;
import com.example.LibraryManagementSystem.Model.Student;
import com.example.LibraryManagementSystem.Repository.StudentRepository;
import com.example.LibraryManagementSystem.Request.StudentCreateRequest;
import com.example.LibraryManagementSystem.Request.UserCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    MyUserService myUserService;

    public void create(StudentCreateRequest studentCreateRequest){
        Student student = studentCreateRequest.to();
        UserCreateRequest userCreateRequest = studentCreateRequest.toUser();
        MyUser myUser = myUserService.createUser(userCreateRequest);
        student.setMyUser(myUser);
        studentRepository.save(student);
    }
    public Student getStudentById(int id){
        return studentRepository.findById(id).orElse(null);
    }

    public boolean deactivateStudent(int studentId) {
        Student student = this.getStudentById(studentId);
        if(student == null){
            return false;
        }
        student.setAccountStatus(AccountStatus.INACTIVE);
        return true;
    }
}
