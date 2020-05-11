package edu.mum.cs.cs472.finalproject.service;

import edu.mum.cs.cs472.finalproject.model.Account;

public class TransactionService {
    private static TransactionService transactionService;
    private TransactionService() {}
    static public TransactionService getInstance() {
        if(transactionService == null) {
            transactionService = new TransactionService();
        }
        return transactionService;
    }

    public boolean transfer(long from, long to, double amount) {
        return true;
    }


}
