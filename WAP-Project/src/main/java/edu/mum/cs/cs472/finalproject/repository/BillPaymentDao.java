package edu.mum.cs.cs472.finalproject.repository;

import edu.mum.cs.cs472.finalproject.dbConnection.HibernateUtil;
import edu.mum.cs.cs472.finalproject.model.BillPayment;
import edu.mum.cs.cs472.finalproject.model.FundTransfer;
import edu.mum.cs.cs472.finalproject.model.User;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.*;
import java.io.Serializable;


public class BillPaymentDao {

    public void pay(BillPayment billPayment) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(billPayment);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
