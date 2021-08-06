package com.simplilearn.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.dao.ClassDAO;
import com.simplilearn.dao.StudentDAO;
import com.simplilearn.model.ClassList;
import com.simplilearn.model.Student;

public class StudentController extends LearningAcademyServlet {
	private static final long serialVersionUID = 1L;
    private StudentDAO studDao;
    
    public StudentController() {
      
    	studDao = new StudentDAO();
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
						insertStudent(request, response);
						break;
					case "delete":
						deleteStudent(request, response);
						break;
					case "edit":
						showEditForm(request, response);
						break;
					case "update":
						updateStudent(request, response);
						break;
					default:
						listStudents(request, response);
						break;
							
				}
			}catch(Exception e) {
				throw new ServletException(e);
			}
		}
	

	private void listStudents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		List <Student> student = studDao.getAllStudents();
		request.setAttribute("student", student);
		RequestDispatcher rd = request.getRequestDispatcher("template.jsp?pageid=st");
		rd.forward(request, response);
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		ClassDAO classDao = new ClassDAO();
		List <ClassList> cL = classDao.getAllClass();
		request.setAttribute("cL", cL);
		RequestDispatcher dispatcher = request.getRequestDispatcher("template.jsp?pageid=stf");
        dispatcher.forward(request, response);
	}
	
	private void insertStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		int classId = Integer.parseInt(request.getParameter("class_id"));
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String gender = request.getParameter("gender");
		String address = request.getParameter("name");
		String email = request.getParameter("address");
		String phone = request.getParameter("phone");
		Long created = super.getUnixTimeStamp();
		Long updated= super.getUnixTimeStamp();
		Student student = new Student(firstname,lastname,gender,address,email,phone,updated.toString(),created.toString(), classId);
		studDao.save(student);
		response.sendRedirect("template.jsp?pageid=st");
	}
	
	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		studDao.deleteStudent(id);
		response.sendRedirect("template.jsp?pageid=st");
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		Student student = studDao.getStudent(id);
		ClassDAO classDao = new ClassDAO();
		List <ClassList> cL = classDao.getAllClass();
		request.setAttribute("cL", cL);
		request.setAttribute("student", student);
		RequestDispatcher rd = request.getRequestDispatcher("template.jsp?pageid=stf");
		rd.forward(request, response);
		
	}

	private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		int studentId = Integer.parseInt(request.getParameter("student_id"));
		int classId = Integer.parseInt(request.getParameter("class_id"));
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String gender = request.getParameter("gender");
		String address = request.getParameter("name");
		String email = request.getParameter("address");
		String phone = request.getParameter("phone");
		Long created = super.getUnixTimeStamp();
		Long updated= super.getUnixTimeStamp();
		Student student = new Student(studentId,firstname,lastname,gender,address,email,phone,updated.toString(),created.toString(), classId);
		
		studDao.updateStudent(student);
		response.sendRedirect("template.jsp?id=st");
	}
    

	

}
