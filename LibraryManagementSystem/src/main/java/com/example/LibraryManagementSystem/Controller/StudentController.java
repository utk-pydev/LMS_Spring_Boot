package com.example.LibraryManagementSystem.Controller;

import com.example.LibraryManagementSystem.Model.Student;
import com.example.LibraryManagementSystem.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {


    @Value("{$custom.my_prop}")
    private String my_text;

    /*
    * ymal:old
    * yml:New
    *
    * */

    @GetMapping("/sample")
    public String getMyString(){
        return this.my_text;
    }


    @Autowired
    StudentService studentService;


}
