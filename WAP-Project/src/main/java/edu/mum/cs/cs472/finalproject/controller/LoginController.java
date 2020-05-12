package edu.mum.cs.cs472.finalproject.controller;

import edu.mum.cs.cs472.finalproject.model.TransactionSummary;
import edu.mum.cs.cs472.finalproject.model.User;
import edu.mum.cs.cs472.finalproject.repository.TransactionSummaryDao;
import edu.mum.cs.cs472.finalproject.repository.UserDao;

import java.io.IOException;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomepageController
 */
@WebServlet(
		description = "LoginController",
		urlPatterns = {"",
				"/login"
		})
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	private UserDao loginDao;
	private TransactionSummaryDao transactionSummaryDao;

	public void init() {
		loginDao = new UserDao();
		transactionSummaryDao = new TransactionSummaryDao();
	}
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			authenticate(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void authenticate(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("username =>"+request.getParameter("username"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (loginDao.validate(username, password)) {
//			User newUser=new User();
//			newUser.setFirstName("Manoj");
//			newUser.setLastName("Gupta");
//			newUser.setUsername("manoj");
//			newUser.setPassword("123");
//			loginDao.saveUser(newUser);
			User loginUser=loginDao.getUser(username);
//			TransactionSummary t1= new TransactionSummary();
//			t1.setAmount(19);
//			t1.setFromAccount(1001001);
//			t1.setToAccount(1001004);
//			t1.setTransactionDate(new Date());
//			t1.setTransactionDesc("bill payment");
//			t1.setTransactionType("credit");
//			t1.setUser(loginUser);
//			transactionSummaryDao.saveTransaction(t1);
//			TransactionSummary t2= new TransactionSummary();
//			t2.setAmount(11);
//			t2.setFromAccount(1001001);
//			t2.setToAccount(1001002);
//			t2.setTransactionDate(new Date());
//			t2.setTransactionDesc("fund transfer");
//			t2.setTransactionType("credit");
//			t2.setUser(loginUser);
//			transactionSummaryDao.saveTransaction(t2);
//			TransactionSummary t3= new TransactionSummary();
//			t3.setAmount(2);
//			t3.setFromAccount(1001001);
//			t3.setToAccount(1001002);
//			t3.setTransactionDate(new Date());
//			t3.setTransactionDesc("fund transfer");
//			t3.setTransactionType("credit");
//			t3.setUser(loginUser);
//			transactionSummaryDao.saveTransaction(t3);

			request.setAttribute("userId", loginUser.getId());
			response.sendRedirect("home");

		}else {
//			throw new Exception("Login not successful..");
			request.setAttribute("response",false);
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		}
	}

}
