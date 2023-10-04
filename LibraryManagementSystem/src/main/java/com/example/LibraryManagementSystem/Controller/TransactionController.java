package com.example.LibraryManagementSystem.Controller;

import com.example.LibraryManagementSystem.Model.Transaction;
import com.example.LibraryManagementSystem.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @Autowired
    TransactionService transactionService;


    @PostMapping("/issueTransaction")
    public void issueTxn(){
        transactionService.issueTxn();
    }

}
