package edu.mum.cs.cs472.finalproject.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(description = "Restful service controller", urlPatterns = {"/api/getaccounts", "/api/transfer", "/api/deposit", "/api/withdraw"})
public class RestfulController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();
        switch (path) {
            case "/api/getaccounts":
                getAccounts(req, resp);
                break;
            default:
                resp.sendError(404);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();
        switch (path) {
            case "/api/transfer":
                transfer(req, resp);
                break;
            case "/api/deposit":
                deposit(req, resp);
                break;
            case "/api/withdraw":
                withdraw(req, resp);
                break;
            default:
                resp.sendError(404);
                break;
        }
    }

    private void getAccounts(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    private void transfer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    private void deposit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    private void withdraw(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
