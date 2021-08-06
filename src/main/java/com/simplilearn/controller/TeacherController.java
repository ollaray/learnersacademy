package com.simplilearn.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.dao.ClassDAO;
import com.simplilearn.dao.StudentDAO;
import com.simplilearn.dao.SubjectDAO;
import com.simplilearn.dao.TeacherDAO;
import com.simplilearn.model.ClassList;
import com.simplilearn.model.Student;
import com.simplilearn.model.Subject;
import com.simplilearn.model.Teacher;

public class TeacherController extends LearningAcademyServlet {
	private static final long serialVersionUID = 1L;
    private TeacherDAO teachDao;
   
    public TeacherController() {
       teachDao = new TeacherDAO();
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
						insertTeacher(request, response);
						break;
					case "delete":
						deleteTeacher(request, response);
						break;
					case "edit":
						showEditForm(request, response);
						break;
					case "update":
						updateTeacher(request, response);
						break;
					default:
						listTeachers(request, response);
						break;
							
				}
			}catch(Exception e) {
				throw new ServletException(e);
			}
		}
	

	private void listTeachers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		List <Teacher> teacher = teachDao.getAllTeachers();
		request.setAttribute("teacher", teacher);
		RequestDispatcher rd = request.getRequestDispatcher("template.jsp?pageid=te");
		rd.forward(request, response);
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		ClassDAO classDao = new ClassDAO();
		SubjectDAO subjectDao = new SubjectDAO();
		List <ClassList> cL = classDao.getAllClass();
		List <Subject> subject = subjectDao.getAllSubjects();
		request.setAttribute("cL", cL);
		request.setAttribute("subject", subject);
        RequestDispatcher dispatcher = request.getRequestDispatcher("template.jsp?pageid=tef");
        dispatcher.forward(request, response);
	}
	
	private void insertTeacher(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		int classId = Integer.parseInt(request.getParameter("class_id"));
		int subjectId = Integer.parseInt(request.getParameter("subject_id"));
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String gender = request.getParameter("gender");
		String address = request.getParameter("name");
		String email = request.getParameter("address");
		String phone = request.getParameter("phone");
		Long created = super.getUnixTimeStamp();
		Long updated= super.getUnixTimeStamp();
		
		Teacher teacher = new Teacher(firstname,lastname,gender, address,email,phone,
				classId,subjectId,created.toString(),updated.toString());
		
		teachDao.save(teacher);
		response.sendRedirect("template.jsp?pageid=te");
	}
	
	private void deleteTeacher(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		teachDao.deleteTeacher(id);
		response.sendRedirect("template.jsp?pageid=te");
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		Teacher teacher = new Teacher();
		teacher = teachDao.getTeacher(id);
		RequestDispatcher rd = request.getRequestDispatcher("template.jsp?pageid=tef");
		request.setAttribute("teacher", teacher);
		rd.forward(request, response);
		
	}

	private void updateTeacher(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		int classId = Integer.parseInt(request.getParameter("class_id"));
		int subjectId = Integer.parseInt(request.getParameter("subject_id"));
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String gender = request.getParameter("gender");
		String address = request.getParameter("name");
		String email = request.getParameter("address");
		String phone = request.getParameter("phone");
		Long updated= super.getUnixTimeStamp();
		Teacher teacher = new Teacher(firstname,lastname,gender, address,email,phone,classId,subjectId,updated.toString());
		teacher.setId(id);
		teachDao.updateTeacher(teacher);
		response.sendRedirect("template.jsp?id=cl");
	}
    

}
