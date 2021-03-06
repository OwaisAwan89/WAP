package edu.mum.cs.cs472.finalproject.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table( name = "account")
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_number", updatable = false, nullable = false)
    private long accountNumber;

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey=@ForeignKey(name="id"))
    private User user;

    @Column(name = "balance")
    private double balance;

    @Column(name = "account_title")
    private String accountTitle;

    @Column(name = "account_type")
    private String accountType;

    public User getUser() {
        return user;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountTitle() {
        return accountTitle;
    }

    public void setAccountTitle(String accountTitle) {
        this.accountTitle = accountTitle;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", user=" + user +
                ", balance=" + balance +
                ", accountTitle='" + accountTitle + '\'' +
                ", accountType='" + accountType + '\'' +
                '}';
    }
}
