package com.example.LibraryManagementSystem.Service;

import com.example.LibraryManagementSystem.Exceptions.TxnServiceException;
import com.example.LibraryManagementSystem.Model.Book;
import com.example.LibraryManagementSystem.Model.Student;
import com.example.LibraryManagementSystem.Model.Transaction;
import com.example.LibraryManagementSystem.Model.TransactionType;
import com.example.LibraryManagementSystem.Repository.BookRepository;
import com.example.LibraryManagementSystem.Repository.StudentRepository;
import com.example.LibraryManagementSystem.Repository.TransactionRepository;
import com.example.LibraryManagementSystem.Request.BookFilterType;
import com.zaxxer.hikari.util.IsolationLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TransactionService{

    @Autowired
    StudentService studentService;

    @Autowired
    BookService bookService;

    @Autowired
    TransactionRepository transactionRepository;

    @Value("${book.return.due_date}")
    int number_of_days;

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public String issueTxn(int bookId, int studentId) throws TxnServiceException {
        Student student = studentService.getStudentById(studentId);
        if(student == null){
            throw new TxnServiceException("No Student Such Found");
        }
        List<Book> books = bookService.find(BookFilterType.BOOK_ID, String.valueOf(bookId));
        if(books.isEmpty()){
            throw new TxnServiceException("No Book Found");
        }
        Book book = books.get(0);
        if(book.getStudent() != null){
            throw new TxnServiceException("Book is already issued");
        }
        book.setStudent(student);
        Transaction transaction = Transaction.builder()
        .externalTxnId(UUID.randomUUID().toString())
                .my_book(book)
                .payment(book.getCost())
                .my_student(student)
                .transactionType(TransactionType.ISSUE)
                .build();

        transactionRepository.save(transaction);
        bookService.create(book);
        return transaction.getExternalTxnId();
    }
    public void returnTxn(int bookId, int studentId){

    }

}
