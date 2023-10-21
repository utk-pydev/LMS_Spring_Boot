package com.example.LibraryManagementSystem.Controller;

import com.example.LibraryManagementSystem.Exceptions.TxnServiceException;
import com.example.LibraryManagementSystem.Model.Transaction;
import com.example.LibraryManagementSystem.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/transaction/issue")
    public String issueTxn(@RequestParam("studentId") int studentId, @RequestParam("bookId") int bookId) throws TxnServiceException {
        return transactionService.issueTxn(studentId, bookId);
    }

}
