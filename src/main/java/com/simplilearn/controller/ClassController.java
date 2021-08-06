package com.simplilearn.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.simplilearn.dao.ClassDAO;
import com.simplilearn.model.ClassList;


public class ClassController extends LearningAcademyServlet {
	private static final long serialVersionUID = 1L;
	private ClassDAO classDao;
	
	public void init() {
		classDao = new ClassDAO();
	}
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.makeRedirect(request, response);
		String action = request.getParameter("action");
		
			try {
				switch(action) {
					case "new":
						showNewForm(request, response);
						break;
					case "insert":
						insertClass(request, response);
						break;
					case "delete":
						deleteClass(request, response);
						break;
					case "edit":
						showEditForm(request, response);
						break;
					case "update":
						updateClass(request, response);
						break;
					default:
						listClasses(request, response);
						break;
							
				}
			}catch(Exception e) {
				throw new ServletException(e);
			}
		}
	

	private void listClasses(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		List <ClassList> classList = classDao.getAllClass();
		request.setAttribute("clsList", classList);
		RequestDispatcher rd = request.getRequestDispatcher("template.jsp?pageid=cl");
		rd.forward(request, response);
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("template.jsp?pageid=clf");
        dispatcher.forward(request, response);
	}
	
	private void insertClass(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		String name = request.getParameter("name");
		ClassList cL = new ClassList(name);
		classDao.save(cL);
		response.sendRedirect("template.jsp?pageid=cl");
	}
	
	private void deleteClass(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		classDao.deleteClass(id);
		response.sendRedirect("class?pageid=cl&action=");
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		ClassList cL = classDao.getClass(id);
		RequestDispatcher rd = request.getRequestDispatcher("template.jsp?pageid=clf");
		request.setAttribute("clsList", cL);
		rd.forward(request, response);
		
	}

	private void updateClass(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		ClassList cL = new ClassList(id, name);
		classDao.updateClass(cL);
		response.sendRedirect("template.jsp?pageid=cl");
	}
    

}
