package edu.mum.cs.cs472.finalproject.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(description = "HistoryController", urlPatterns = {"/history"})
public class HistoryController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int totalPages = 10;
        int pageIndex = 5;
        int countPerPage = 10;

        req.setAttribute("totalPages", totalPages);
        req.setAttribute("pageIndex", pageIndex);
        req.setAttribute("countPerPage", countPerPage);

        req.getRequestDispatcher("WEB-INF/views/history.jsp").forward(req, resp);
    }
}
