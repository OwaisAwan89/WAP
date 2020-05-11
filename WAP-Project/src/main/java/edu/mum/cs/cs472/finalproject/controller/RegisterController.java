package edu.mum.cs.cs472.finalproject.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;

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

        response.sendRedirect("home");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(request, response);
    }
}
