package edu.mum.cs.cs472.finalproject.controller;

import edu.mum.cs.cs472.finalproject.model.Account;
import edu.mum.cs.cs472.finalproject.model.User;
import edu.mum.cs.cs472.finalproject.repository.AccountDao;
import edu.mum.cs.cs472.finalproject.repository.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        description = "LoginController",
        urlPatterns = {
                "/billPay"
        })
public class BillPayController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String waterBill = request.getParameter("waterBill");
        if (waterBill != "" || waterBill != null) {
            // get user from session
            int user_id = 1;
//            UserDao userDao = new UserDao();
//            User thisUser = userDao.getUserById(user_id);
            // get account of that user
            AccountDao accountDao = new AccountDao();
            Account thisAccount = accountDao.getAccountByUserId(user_id);
            // deduce amount
            accountDao.deduct(5, thisAccount);
        }
//        response.sendRedirect("home");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/billPay.jsp").forward(request, response);
    }
}
