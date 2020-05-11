package edu.mum.cs.cs472.finalproject.service;

import edu.mum.cs.cs472.finalproject.model.Account;
import edu.mum.cs.cs472.finalproject.model.User;

import java.util.Arrays;
import java.util.List;

public class UserService {
    private UserService userService;
    private UserService() {

    }

    public UserService getInstance() {
        if(userService == null) {
            userService = new UserService();
        }
        return userService;
    }

    public List<Account> getAccountsByUserId(int userId) {
        Account my = new Account();
        my.setId(1);
        my.setName("James Zhao");
        my.setUserId(1);
        my.setBalance(1000);

        return Arrays.asList(my);
    }

    public List<Account> getAllAccounts() {
        Account acc1 = new Account();
        acc1.setId(2);
        acc1.setName("Lucy");
        acc1.setUserId(1);
        acc1.setBalance(23);

        Account acc2 = new Account();
        acc2.setId(3);
        acc2.setName("Anna");
        acc2.setUserId(1);
        acc2.setBalance(56);

        Account acc3 = new Account();
        acc3.setId(4);
        acc3.setName("Chandler");
        acc3.setUserId(1);
        acc3.setBalance(799);

        Account acc4 = new Account();
        acc4.setId(5);
        acc4.setName("Banon");
        acc4.setUserId(1);
        acc4.setBalance(188.23);

        return Arrays.asList(acc1, acc2, acc3, acc4);
    }
}
