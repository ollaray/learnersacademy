package com.simplilearn.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.simplilearn.dao.SubjectDAO;
import com.simplilearn.model.ClassList;
import com.simplilearn.model.Subject;

/**
 * Servlet implementation class SubjectController
 */
public class SubjectController extends LearningAcademyServlet {
	private static final long serialVersionUID = 1L;
    private SubjectDAO subjectDao;
    
    public void init() {
    	subjectDao = new SubjectDAO();
    }
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.makeRedirect(request, response);
		//this.makeRedirect(request, response);
		String action = request.getParameter("action");
		
			try {
				switch(action) {
					case "new":
						showNewForm(request, response);
						break;
					case "insert":
						insertSubject(request, response);
						break;
					case "delete":
						deleteSubject(request, response);
						break;
					case "edit":
						showEditForm(request, response);
						break;
					case "update":
						updateSubject(request, response);
						break;
					default:
						listSubjects(request, response);
						break;
							
				}
			}catch(Exception e) {
				throw new ServletException(e);
			}
		}
	

	private void listSubjects(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		List <Subject> subject = subjectDao.getAllSubjects();
		request.setAttribute("subject", subject);
		RequestDispatcher rd = request.getRequestDispatcher("template.jsp?pageid=su");
		rd.forward(request, response);
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("template.jsp?pageid=suf");
        dispatcher.forward(request, response);
	}
	
	private void insertSubject(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		String title = request.getParameter("title");
		String type = request.getParameter("type");
		Subject subject = new Subject(title,type);
		subjectDao.save(subject);
		response.sendRedirect("template.jsp?pageid=su");
	}
	
	private void deleteSubject(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		subjectDao.deleteSubject(id);
		response.sendRedirect("template.jsp?pageid=su");
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		Subject subject = subjectDao.getSubject(id);
		RequestDispatcher rd = request.getRequestDispatcher("template.jsp?pageid=suf");
		request.setAttribute("subject", subject);
		rd.forward(request, response);
		
	}

	private void updateSubject(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String type = request.getParameter("type");
		Subject subject = new Subject(id, title.trim(),type.trim());
		subjectDao.updateSubject(subject);
		response.sendRedirect("template.jsp?id=su");
	}
    



	
}
