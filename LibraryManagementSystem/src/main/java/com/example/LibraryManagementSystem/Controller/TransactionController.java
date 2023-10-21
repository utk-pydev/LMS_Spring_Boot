package com.example.LibraryManagementSystem.Controller;

import com.example.LibraryManagementSystem.Exceptions.TxnServiceException;
import com.example.LibraryManagementSystem.Service.TransactionService;
import jakarta.transaction.TransactionalException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @Autowired
    TransactionService transactionService;
    private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);
    @PostMapping("/transaction/issue")
    public ResponseEntity<String> issueTxn(@RequestParam("studentId") int studentId, @RequestParam("bookId") int bookId) {
        try {
            return ResponseEntity.ok(transactionService.issueTxn(bookId, studentId));
        }
        catch (TransactionalException | TxnServiceException exception) {
            logger.info(exception.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
        }
    }
    @PutMapping("/transaction/return")
    public ResponseEntity<String> returnTxn(@RequestParam("studentId") int studentId, @RequestParam("bookId") int bookId) throws TxnServiceException{
        try {
            return ResponseEntity.ok(transactionService.returnTxn(bookId, studentId));
        }catch (TxnServiceException exception){
            logger.info(exception.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
        }
    }
}
