package edu.mum.cs.cs472.finalproject.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table( name = "bill_payment")
public class BillPayment implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "bill_Company")
    private String billCompany;

    @Column(name = "bill_number")
    private String billNumber;

    public double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(double billAmount) {
        this.billAmount = billAmount;
    }

    @Column(name = "bill_amount")
    private double billAmount;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public long getAccount_number() {
        return account_number;
    }

    public void setAccount_number(long account_number) {
        this.account_number = account_number;
    }

    @Column(name = "account_number")
    private long account_number;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBillCompany() {
        return billCompany;
    }

    public void setBillCompany(String billCompany) {
        this.billCompany = billCompany;
    }

    public String getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(String billNumber) {
        this.billNumber = billNumber;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
