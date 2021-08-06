package com.simplilearn.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LearningAcademyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public LearningAcademyServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void makeRedirect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
//		String action = null;
//		String pageid = null;
//		action = request.getParameter("action");
//		pageid = request.getParameter("pageid");
		if(session == null) {
			String page = this.getBasePath(request, response)+"login.jsp";
			response.sendRedirect(page);
		}
//		PrintWriter out = response.getWriter();
//		response.setContentType("text/html");
//		if(action == null) {
//			out.println("<h3>Error: Wrong page route</h3>");
//			out.println("<a href='dashboard'>Go Back</a>");
//		}
		
	}
	
	 protected String getBasePath(HttpServletRequest request, HttpServletResponse response) {
	    	String path = request.getContextPath();
	    	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	    	return basePath;
	 }
	 
	 protected Long getUnixTimeStamp() {
		 long unixTime = Instant.now().getEpochSecond();
		 return unixTime;
	 }
	 
	 protected String convertUnixTimeStamp(Long unixTime) {
		 unixTime = unixTime * 1000;
		 String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date(unixTime));
		 
		 return date;
	 }
	 
	 protected void setMessageAttribute(HttpServletRequest request, HttpServletResponse response, String message) {
	    	request.setAttribute("msg", message);
	 }
	 
}
