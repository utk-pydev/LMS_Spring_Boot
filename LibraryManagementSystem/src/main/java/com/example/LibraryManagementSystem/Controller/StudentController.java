package com.example.LibraryManagementSystem.Controller;

import com.example.LibraryManagementSystem.Model.MyUser;
import com.example.LibraryManagementSystem.Model.Student;
import com.example.LibraryManagementSystem.Request.StudentCreateRequest;
import com.example.LibraryManagementSystem.Service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/student")
    public void createStudent(@Valid @RequestBody StudentCreateRequest studentCreateRequest){
        studentService.create(studentCreateRequest);
    }

    @GetMapping("/student")
    public Student getStudent() throws Exception{
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        MyUser myUser = (MyUser) authentication.getPrincipal();
        if(myUser.getStudent() == null){
            throw new Exception("User requesting the details is not a student");
        }
        int studentId = myUser.getStudent().getId();
        return studentService.getStudentById(studentId);
    }

    @GetMapping("/student_for_admin")
    public Student getStudentForAdmin(@RequestParam("studentId") int studentId) throws Exception{
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        MyUser myUser = (MyUser) authentication.getPrincipal();
        if(myUser.getAdmin() == null){
            throw new Exception("User requesting the details is not an admin");
        }
        return studentService.getStudentById(studentId);
    }

    @PatchMapping("/student_for_admin/deactivate")
    public boolean deactivateStudent(@RequestParam("studentId") int studentId) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        MyUser myUser = (MyUser) authentication.getPrincipal();
        if(myUser.getAdmin() == null){
            throw new Exception("This student cannot be deactivated");
        }
        return studentService.deactivateStudent(studentId);
    }
}
