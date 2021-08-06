package com.simplilearn.util;

import java.util.List;

import com.simplilearn.dao.ClassDAO;
import com.simplilearn.dao.LoginDAO;
import com.simplilearn.dao.StudentDAO;
import com.simplilearn.dao.SubjectDAO;
import com.simplilearn.dao.TeacherDAO;
import com.simplilearn.model.ClassList;
import com.simplilearn.model.Subject;
import com.simplilearn.model.User;

public class Demo {

	public static void main(String[] args) {
//		ClassList cL = new ClassList();
//		ClassDAO classDao = new ClassDAO();
//		cL = classDao.getClass(1);
//		System.out.println(cL);
		
//		LoginDAO login = new LoginDAO();
//		List<User> user = login.getAllUsers();
//		System.out.println(user);
		
		//SubjectDAO sub = new SubjectDAO();
		//List<Subject> subject = sub.getAllSubjects();
		//System.out.println(subject);
		
		TeacherDAO t = new TeacherDAO();
		SubjectDAO sub = new SubjectDAO();
		StudentDAO std = new StudentDAO();
		ClassDAO classDao = new ClassDAO();
		System.out.println(t.getTotalTeachers());
		System.out.println(sub.getTotalSubjects());
		System.out.println(std.getTotalStudents());
		System.out.println(classDao.getTotalClasses());
		

	}

}
