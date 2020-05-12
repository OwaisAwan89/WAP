package edu.mum.cs.cs472.finalproject.service;

import edu.mum.cs.cs472.finalproject.model.Account;
import edu.mum.cs.cs472.finalproject.model.History;

import java.util.Arrays;
import java.util.List;

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


    public List<History> getHistories(int userId, long accountId) {
        return Arrays.asList();
    }


}
