package edu.mum.cs.cs472.finalproject.controller;

import edu.mum.cs.cs472.finalproject.model.Account;
import edu.mum.cs.cs472.finalproject.model.BillPayment;
import edu.mum.cs.cs472.finalproject.model.TransactionSummary;
import edu.mum.cs.cs472.finalproject.model.User;
import edu.mum.cs.cs472.finalproject.repository.AccountDao;
import edu.mum.cs.cs472.finalproject.repository.BillPaymentDao;
import edu.mum.cs.cs472.finalproject.repository.TransactionSummaryDao;
import edu.mum.cs.cs472.finalproject.repository.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

@WebServlet(
        description = "LoginController",
        urlPatterns = {
                "/billPay"
        })
public class BillPayController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String generateBill = request.getParameter("billNumber");
        if (generateBill!=null && generateBill!="") {

            // STEP 1 of 3: Add entry to table: bill_payment.

            // Generate a random bill amount with range 15 to 75.
            int billAmount = ThreadLocalRandom.current().nextInt(15,75);

            // Get the Bill Payment Dao object to apply pay() function.
            BillPaymentDao billPaymentDao = new BillPaymentDao();

            // Create a new object to keep it ready to write to table: bill_payment
            BillPayment waterBillPaymentObj = new BillPayment();
            waterBillPaymentObj.setBillAmount(billAmount);
            waterBillPaymentObj.setBillCompany(request.getParameter("beneficiary")+"-"+request.getParameter("bank"));
            waterBillPaymentObj.setBillNumber(request.getParameter("billNumber"));

            // get user ID from session
            int accountNumber = 1;
            waterBillPaymentObj.setAccount_number(accountNumber);

            // get account of that user
            int userId = 1;
            UserDao userDao = new UserDao();
            User user = userDao.getUserById(userId);
            waterBillPaymentObj.setUser(user);
            billPaymentDao.pay(waterBillPaymentObj);

            // STEP 2 of 3: Deduce amount from table: account.
            AccountDao accountDao = new AccountDao();
            Account account = accountDao.getAccount(Long.parseLong(request.getParameter("account_number"), 10));
            accountDao.deduct(billAmount, account);

            // STEP 3 of 3: Add entry to table: transaction_summary.
            TransactionSummary transactionSummary = new TransactionSummary();
            transactionSummary.setAmount(billAmount);
            transactionSummary.setFromAccount(Long.parseLong(request.getParameter("account_number")));
            transactionSummary.setToAccount(111); // Bank Account number
            ZoneId zoneId = ZoneId.systemDefault();
            ZonedDateTime zdt = LocalDateTime.now().atZone(zoneId);
            Date date = Date.from(zdt.toInstant());
            transactionSummary.setTransactionDate(date);
            transactionSummary.setTransactionType("bill payment");
            transactionSummary.setTransactionDesc("Debit");
            Account accountFrom = accountDao.getAccount(Long.parseLong(request.getParameter("account_number")));
            transactionSummary.setUser(accountFrom.getUser());
            TransactionSummaryDao transactionSummaryDao = new TransactionSummaryDao();
            transactionSummaryDao.saveTransaction(transactionSummary);
            //Account accountTo = accountDao.getAccount(111);// Bank Account number
            //transactionSummary.setUser(accountTo.getUser());
//            transactionSummaryDao.saveTransaction(transactionSummary);

        }

        request.setAttribute("response",false);
        request.getRequestDispatcher("/WEB-INF/views/billPay.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/billPay.jsp").forward(request, response);
    }
}