package edu.mum.cs.cs472.finalproject.controller;

import edu.mum.cs.cs472.finalproject.model.Account;
import edu.mum.cs.cs472.finalproject.model.BillPayment;
import edu.mum.cs.cs472.finalproject.model.User;
import edu.mum.cs.cs472.finalproject.repository.AccountDao;
import edu.mum.cs.cs472.finalproject.repository.BillPaymentDao;
import edu.mum.cs.cs472.finalproject.repository.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

@WebServlet(
        description = "LoginController",
        urlPatterns = {
                "/billPay"
        })
public class BillPayController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String generateWaterBill = request.getParameter("billNumber");
        if (generateWaterBill!=null) {

            // Generate a random bill amount with range 15 to 75.
            int waterBillAmount = ThreadLocalRandom.current().nextInt(15,75);

            // Get the Bill Payment Dao object to apply pay() function.
            BillPaymentDao waterBillPaymentDao = new BillPaymentDao();

            // Create a new object to keep it ready to write to table: bill_payment
            BillPayment waterBillPaymentObj = new BillPayment();
            waterBillPaymentObj.setBillAmount(waterBillAmount);
            waterBillPaymentObj.setBillCompany("Water Incorporation"+"-"+"Wells Fargo Bank");
            waterBillPaymentObj.setBillNumber(request.getParameter("billNumber"));

            // get user ID from session
            int accountNumber = 1;
            waterBillPaymentObj.setAccount_number(accountNumber);

            // get account of that user
            int userId = 1;
            UserDao userDao = new UserDao();
            User user = userDao.getUserById(userId);
            waterBillPaymentObj.setUser(user);
            waterBillPaymentDao.pay(waterBillPaymentObj);

            // Deduct amount from Account
        }
        else{
            request.setAttribute("response",false);
            request.getRequestDispatcher("/WEB-INF/views/billPay.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/billPay.jsp").forward(request, response);
    }
}
