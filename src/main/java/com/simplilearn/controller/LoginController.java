package com.simplilearn.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.simplilearn.dao.LoginDAO;
import com.simplilearn.model.User;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginDAO loginDAO;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public void init() {
        loginDAO = new LoginDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    private String getBasePath(HttpServletRequest request, HttpServletResponse response) {
    	String path = request.getContextPath();
    	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    	return basePath;
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String page = this.getBasePath(request, response)+"login.jsp";
		response.sendRedirect(page);
		//RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		//dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			this.auth(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@SuppressWarnings("rawtypes")
	protected void auth(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		
		if(loginDAO.validateUser(email, pass)) {
			User usr = loginDAO.getUser(email, pass);
			HttpSession session = request.getSession(true);
			session.setAttribute("user", usr);
			session.setAttribute("firstname",usr.getFirstname());
			session.setAttribute("lastname", usr.getLastname());
			session.setAttribute("email", usr.getEmail());
			String page = this.getBasePath(request, response)+"dashboard?pageid=da";
			response.sendRedirect(page);
			//RequestDispatcher dispatcher = request.getRequestDispatcher("template.jsp?id=da");
            //dispatcher.forward(request, response);
		}else {
			 String message = "Invalid email/password";
             request.setAttribute("message", message);
             RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
             dispatcher.forward(request, response);
		}
		
	}
	
	protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession(false);
		if(session != null) {
		   session.removeAttribute("user");
		   session.invalidate();
		   RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
           dispatcher.forward(request, response);
		}
		
	}
	

}
