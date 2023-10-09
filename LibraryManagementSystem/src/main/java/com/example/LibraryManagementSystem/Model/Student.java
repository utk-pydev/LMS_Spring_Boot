package com.example.LibraryManagementSystem.Model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(unique = true, nullable = false)
    private String contact;
    private String address;
    @Column(unique = true)
    private String email;
    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;
    @OneToMany(mappedBy = "student")
    private List<Book> bookList;


    @OneToMany(mappedBy = "my_student")
    private List<Transaction>transactionList;

    @Enumerated(value = EnumType.STRING)
    private AccoutStatus accoutStatus;

    private boolean isActive;

    /*
    *   Two types of relationships in hibernate
    *
    * 1. Unidirectional
    * 2. Bidirectional
    *
    *
    * ------------Unidirectional---------------
    * book              student
    *
    *
    * student_id(fk)
    *
    *
    * ------------Bidirectional------------------
    * book                  Student
    *
    *
    * student_id(fk)        List<students>
                            Not storing in the db just having it in the java object.
    * Bidirectional
    * -----------------------------------------------
    *
    * */


}
