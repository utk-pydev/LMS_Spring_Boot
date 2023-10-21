package com.example.LibraryManagementSystem.Repository;

import com.example.LibraryManagementSystem.Model.Book;
import com.example.LibraryManagementSystem.Model.Student;
import com.example.LibraryManagementSystem.Model.Transaction;
import com.example.LibraryManagementSystem.Model.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    Transaction findTopByBookAndStudentAndTransactionTypeOrderByTransactionDateDesc(Book book, Student student, TransactionType transactionType);
}
