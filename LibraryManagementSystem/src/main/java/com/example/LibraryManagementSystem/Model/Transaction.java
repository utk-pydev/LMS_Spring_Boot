package com.example.LibraryManagementSystem.Model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String externalTxnId;

    @ManyToOne
    @JoinColumn
    private Student my_student;

    @ManyToOne
    @JoinColumn
    private Book my_book;


    @Enumerated(value = EnumType.STRING)
    private TransactionType transactionType;

    private double payment;


    @CreationTimestamp
    private Date transactionDate;

}
