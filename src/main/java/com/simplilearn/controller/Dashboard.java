package com.simplilearn.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.simplilearn.dao.ClassDAO;
import com.simplilearn.dao.StudentDAO;
import com.simplilearn.dao.SubjectDAO;
import com.simplilearn.dao.TeacherDAO;
import com.simplilearn.model.User;

/**
 * Servlet implementation class Dashboard
 */
public class Dashboard extends LearningAcademyServlet {
	private static final long serialVersionUID = 1L;
       
    private ClassDAO classDao;
    private StudentDAO studentDao;
    private SubjectDAO subjectDao;
    private TeacherDAO teacherDao;
    
    public Dashboard() {
       
       classDao = new ClassDAO();
       studentDao = new StudentDAO();
       subjectDao = new SubjectDAO();
       teacherDao = new TeacherDAO();
        
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String page = super.getBasePath(request, response)+"template.jsp?pageid=da";
		//response.sendRedirect(page);
		//let's load totals of all entities
		int totalClasses = classDao.getTotalClasses();
		int totalStudents = studentDao.getTotalStudents();
		int totalSubjects = subjectDao.getTotalSubjects();
		int totalTeachers = teacherDao.getTotalTeachers();
		request.setAttribute("classTotal", totalClasses);
		request.setAttribute("studentTotal", totalStudents);
		request.setAttribute("subjectTotal", totalSubjects);
		request.setAttribute("teacherTotal", totalTeachers);
		
		RequestDispatcher rd = request.getRequestDispatcher("template.jsp?pageid=da");
		rd.forward(request, response);
	
		
	}

}
