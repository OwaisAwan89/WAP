package edu.mum.cs.cs472.finalproject.controller;

import edu.mum.cs.cs472.finalproject.model.Account;
import edu.mum.cs.cs472.finalproject.model.User;
import edu.mum.cs.cs472.finalproject.repository.AccountDao;
import edu.mum.cs.cs472.finalproject.repository.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        description = "LoginController",
        urlPatterns = {
                "/register"
        })
public class RegisterController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        if (firstName == "" || firstName == null) {
            // go back to the form page
            String errMsg = "<span style='color:red'>Your First Name is required</span>";
            request.setAttribute("errMsg", errMsg);
            // forward back to the form servlet
            request.setAttribute("response",false);
            request.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(request, response);
        }

        String lastName = request.getParameter("lastName");
        if (lastName == "" || lastName == null) {
            // go back to the form page
            String errMsg = "<span style='color:red'>Your First Name is required</span>";
            request.setAttribute("errMsg", errMsg);
            // forward back to the form servlet
            request.setAttribute("response",false);
            request.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(request, response);
        }

        String inputEmail = request.getParameter("inputEmail");
        if (inputEmail == "" || inputEmail == null) {
            // go back to the form page
            String errMsg = "<span style='color:red'>Your First Name is required</span>";
            request.setAttribute("errMsg", errMsg);
            // forward back to the form servlet
            request.setAttribute("response",false);
            request.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(request, response);
        }

        String inputPassword = request.getParameter("inputPassword");
        if (inputPassword == "" || inputPassword == null) {
            // go back to the form page
            String errMsg = "<span style='color:red'>Your First Name is required</span>";
            request.setAttribute("errMsg", errMsg);
            // forward back to the form servlet
            request.setAttribute("response",false);
            request.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(request, response);
        }

        String bankAccountNumber = request.getParameter("bankAccountNumber");
        if (bankAccountNumber == "" || bankAccountNumber == null) {
            // go back to the form page
            String errMsg = "<span style='color:red'>Your First Name is required</span>";
            request.setAttribute("errMsg", errMsg);
            // forward back to the form servlet
            request.setAttribute("response",false);
            request.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(request, response);
        }

        try {
            register(request, response);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void register(HttpServletRequest request, HttpServletResponse response)
        throws Exception {

        User newUser = new User();
        newUser.setFirstName(request.getParameter("firstName"));
        newUser.setLastName(request.getParameter("lastName"));
        newUser.setEmail(request.getParameter("inputEmail"));
        newUser.setPassword(request.getParameter("inputPassword"));
        newUser.setAccountNumber(request.getParameter("bankAccountNumber"));
        newUser.setUsername(request.getParameter("userName"));

        UserDao userDao = new UserDao();
        if (userDao.saveUser(newUser)) {
            response.sendRedirect("home");
        } else {
            request.setAttribute("response",false);

            request.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(request, response);
        }

        Account newAccount = new Account();
        newAccount.setAccountType("SAVINGS");
        newAccount.setBalance(ThreadLocalRandom.current().nextInt(5000,10000));
        newAccount.setAccountTitle("account-"+request.getParameter("firstName")+request.getParameter("lastName"));
        newAccount.setUser(newUser);

        AccountDao userAccount = new AccountDao();
        if (userAccount.saveAccount(newAccount)) {
            response.sendRedirect("home");
        } else {
            request.setAttribute("response",false);
            request.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(request, response);
    }
}
