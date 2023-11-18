package com.example.LibraryManagementSystem.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
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

    @Column(unique = true)
    private String username;
    private String password;
    @OneToOne
    @JoinColumn(name="myUser_id")
    @JsonIgnoreProperties({"student", "admin", "password"})
    private MyUser myUser;

    @OneToMany(mappedBy = "student")
    private List<Transaction>transactionList;

    @Enumerated(value = EnumType.STRING)
    private AccountStatus accountStatus;

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
