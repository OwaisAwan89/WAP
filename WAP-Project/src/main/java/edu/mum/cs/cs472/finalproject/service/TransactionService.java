package edu.mum.cs.cs472.finalproject.service;

import edu.mum.cs.cs472.finalproject.model.Account;

public class TransactionService {
    private static TransactionService transactionService;
    private TransactionService() {}
    public TransactionService getInstance() {
        if(transactionService == null) {
            transactionService = new TransactionService();
        }
        return transactionService;
    }

    public boolean transfer(Account from, Account to, double amount) {
        return true;
    }

    public boolean deposit(Account from, double amount) {
        return true;
    }

    public boolean withdraw(Account from, double amount) {
        return true;
    }
}
