package com.example.LibraryManagementSystem.Repository;

import com.example.LibraryManagementSystem.Model.Student;
import jdk.jfr.StackTrace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
