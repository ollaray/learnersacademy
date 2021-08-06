package com.simplilearn.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutController extends LearningAcademyServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LogoutController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session != null) {
		   session.removeAttribute("user");
		   session.invalidate();
		   RequestDispatcher dispatcher = request.getRequestDispatcher("/");
           dispatcher.forward(request, response);
		}
	}

}
