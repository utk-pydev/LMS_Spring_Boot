package com.example.LibraryManagementSystem.Controller;

import com.example.LibraryManagementSystem.Exceptions.TxnServiceException;
import com.example.LibraryManagementSystem.Model.MyUser;
import com.example.LibraryManagementSystem.Service.TransactionService;
import jakarta.transaction.TransactionalException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    public ResponseEntity<String> issueTxn(@RequestParam("bookId") int bookId) {
        try {

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            MyUser myUser = (MyUser) authentication.getPrincipal();
            if(myUser.getStudent() == null){
                throw new Exception("User requesting the details is not a student");
            }
            int studentId = myUser.getStudent().getId();
            return ResponseEntity.ok(transactionService.issueTxn(bookId, studentId));
        }
        catch (Exception exception) {
            logger.info(exception.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
        }
    }
    @PutMapping("/transaction/return")
    public ResponseEntity<String> returnTxn(@RequestParam("bookId") int bookId) throws TxnServiceException{
        try {

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            MyUser myUser = (MyUser) authentication.getPrincipal();
            if(myUser.getStudent() == null){
                throw new TxnServiceException("User requesting the details is not a student");
            }
            int studentId = myUser.getStudent().getId();
            return ResponseEntity.ok(transactionService.returnTxn(bookId, studentId));
        }catch (TxnServiceException exception){
            logger.info(exception.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
        }
    }
}
