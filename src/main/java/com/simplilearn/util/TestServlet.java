package com.simplilearn.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.simplilearn.dao.LoginDAO;
import com.simplilearn.model.User;

/**
 * Servlet implementation class TestServlet
 */
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Class cls = com.simplilearn.model.User.class;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = this.getBasePath(request, response)+"template.jsp?id=table";
		response.sendRedirect(page);
		
		/*
		PrintWriter out = response.getWriter();
		//User usr = new User();
		String email = "admin@gmail.com";
		String pass = "admin1234";
		LoginDAO log = new LoginDAO();
		
		if(log.validateUser(email, pass)) {
			User usr = log.getUser(email,pass);
			HttpSession session = request.getSession();
			session.setAttribute("user", usr);
			User ur = (User)session.getAttribute("user");
			out.println("Firstname "+ur.getFirstname()+" Lastname "+ur.getLastname());
			//RequestDispatcher dispatcher = request.getRequestDispatcher("template.jsp?id=da");
            //dispatcher.forward(request, response);
		}else {
			out.println("Something went wrong");
			/*
			 String message = "Invalid email/password";
             request.setAttribute("message", message);
             RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
             dispatcher.forward(request, response);
             */
		//}
	
		
		
	}
	
	 private String getBasePath(HttpServletRequest request, HttpServletResponse response) {
	    	String path = request.getContextPath();
	    	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	    	return basePath;
	    }

}
