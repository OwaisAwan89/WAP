package edu.mum.cs.cs472.finalproject.repository;

import edu.mum.cs.cs472.finalproject.dbConnection.HibernateUtil;
import edu.mum.cs.cs472.finalproject.model.Account;
import edu.mum.cs.cs472.finalproject.model.BillPayment;
import edu.mum.cs.cs472.finalproject.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;


public class AccountDao {

    public void saveAccount(Account account) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(account);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Account> getAccounts(int userId) {
        Transaction transaction = null;
        List<Account> accounts = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "from Account U WHERE U.user = :userId";

            Query query = session.createQuery(hql);
            query.setParameter("userId", userId);
            accounts = (List<Account>)  query.list();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        return accounts;
    }

    public List<Account> getAllAccount() {
        Transaction transaction = null;
        List<Account> accounts = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "from Account";

            /*
            Query query = session.createQuery(hql);
            accounts = (List<Account>)  query.list();
            */
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        return accounts;
    }


}
