package com.example.LibraryManagementSystem.Exceptions;

import com.example.LibraryManagementSystem.Service.TransactionService;

public class TxnServiceException extends Exception{
    public TxnServiceException(String message){
        super(message);
    }
}
