package com.simplilearn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.simplilearn.model.ClassList;
import com.simplilearn.model.Student;
import com.simplilearn.model.Subject;
import com.simplilearn.util.Dbconnection;
import com.simplilearn.util.HibernateUtil;



public class StudentDAO {
	
	private Connection con = Dbconnection.connect();

	public void save(Student student) {
		String sql = "INSERT INTO student (class_id, firstname,lastname,gender,address, email, phone, created, updated) VALUES(?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,student.getclassId());
			pstmt.setString(2, student.getFirstname());
			pstmt.setString(3, student.getLastname());
			pstmt.setString(4, student.getGender());
			pstmt.setString(5, student.getAddress());
			pstmt.setString(6, student.getEmail());
			pstmt.setString(7, student.getPhone());
			pstmt.setString(7, student.getCreated());
			pstmt.setString(8, student.getUpdated());
			pstmt.executeUpdate();
			//Dbconnection.disconnect();
			pstmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void updateStudent(Student student) {
	
		String sql = "UPDATE student SET class_id=?, firstname=?,lastname=?, gender=?,address=?, email=?,  "
				+ "phone=?, updated=?,  WHERE id=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,student.getclassId());
			pstmt.setString(2, student.getFirstname());
			pstmt.setString(3, student.getLastname());
			pstmt.setString(4, student.getGender());
			pstmt.setString(5, student.getAddress());
			pstmt.setString(6, student.getEmail());
			pstmt.setString(7, student.getPhone());
			pstmt.setString(8, student.getUpdated());
			pstmt.setInt(9, student.getId());
			pstmt.executeUpdate();
			//Dbconnection.disconnect();
			pstmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void deleteStudent(int id) {
		String sql = "DELETE FROM student WHERE id=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			//Dbconnection.disconnect();
			pstmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public Student getStudent(int id) {
		String sql = "SELECT class_id, firstname,lastname,gender,address, email, phone, updated FROM student WHERE id=?";
		Student student = null;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				int classId = rs.getInt("class_id");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				String gender = rs.getString("gender");
				String updated = rs.getString("updated");
				String address = rs.getString("address");
				
				student = new Student(firstname,lastname,gender,address,email,phone,updated, classId);
				
			}
			//Dbconnection.disconnect();
			rs.close();
			pstmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return student;
	}
	
	
	public List<Student> getAllStudents(){
		List<Student> allUsrs = new ArrayList<>();
		String sql = "SELECT id, class_id, firstname,lastname,gender,address, email, phone, created, updated FROM student";
		Statement statement = null;
		try{
			statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt("id");
				int classId = rs.getInt("class_id");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String gender = rs.getString("gender");
				String created = rs.getString("created");
				String updated = rs.getString("updated");
				String phone = rs.getString("phone");
				
				
				Student student = new Student(id,firstname,lastname,gender,address,email,phone,created,updated, classId);
				allUsrs.add(student);
				
			}
			//Dbconnection.disconnect();
			rs.close();
			statement.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return allUsrs;
				
	}
	
	public int getTotalStudents() {
		String sql = "SELECT * FROM student";
		int count = 0;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			rs.last();
			count = rs.getRow();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public boolean validateSubject(Student student) {
		String sql = "SELECT firstname, lastname FROM student  WHERE id = ?";
		boolean flag = false;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, student.getId());
			ResultSet rs = ps.executeQuery();
			rs.last();
			if(rs.getRow() > 0) {
				flag = true;
			} 	
			//Dbconnection.disconnect();
			ps.close();
			rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return flag;
		
	}

}
