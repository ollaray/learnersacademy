package com.simplilearn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.simplilearn.model.ClassList;
import com.simplilearn.model.Teacher;
import com.simplilearn.util.Dbconnection;




public class TeacherDAO {
	
	private Connection con = Dbconnection.connect();

	public void save(Teacher teacher) {
		String sql = "INSERT INTO teacher (firstname,lastname,gender,email, address,phone, created, updated) VALUES(?,?,?,?,?,?,?,?)";
		int teacherId = 0;
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1,teacher.getFirstname());
			pstmt.setString(2, teacher.getLastname());
			pstmt.setString(3, teacher.getGender());
			pstmt.setString(4, teacher.getEmail());
			pstmt.setString(5, teacher.getAddress());
			pstmt.setString(6, teacher.getPhone());
			pstmt.setString(7, teacher.getCreated());
			pstmt.setString(8, teacher.getUpdated());
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if(rs.next()) {
				teacher.setId(rs.getInt(1));  
			}
			//Dbconnection.disconnect();
			pstmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		String query = "INSERT INTO class_subject_teacher (class_id, subject_id, teacher_id) VALUES(?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, teacher.getClassId());
			ps.setInt(2, teacher.getSubjectId());
			ps.setInt(3, teacher.getId());
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void updateTeacher(Teacher teacher) {
	
		String sql = "UPDATE teacher SET firstname=?,lastname=?, gender=?,address=?, email=?,  "
				+ "phone=?, updated=?,  WHERE id=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, teacher.getFirstname());
			pstmt.setString(2, teacher.getLastname());
			pstmt.setString(3, teacher.getGender());
			pstmt.setString(4, teacher.getAddress());
			pstmt.setString(5, teacher.getEmail());
			pstmt.setString(6, teacher.getPhone());
			pstmt.setString(7, teacher.getUpdated());
			pstmt.setInt(8, teacher.getId());
			pstmt.executeUpdate();
			//Dbconnection.disconnect();
			pstmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		String query = "UPDATE class_subject_teacher SET class_id=?, subject_id=?, teacher_id=? WHERE teacher_id=? AND class_id=? "
				+ "AND subject_id=?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, teacher.getClassId());
			ps.setInt(2, teacher.getSubjectId());
			ps.setInt(3, teacher.getId());
			ps.setInt(4, teacher.getId());
			ps.setInt(5, teacher.getClassId());
			ps.setInt(6, teacher.getSubjectId());
			ps.executeUpdate();
			//Dbconnection.disconnect();
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void deleteTeacher(int id) {
		String sql = "DELETE FROM teacher WHERE id=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			Dbconnection.disconnect();
			pstmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		String query = "DELETE FROM class_subject_teacher WHERE teacher_id=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			//Dbconnection.disconnect();
			pstmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	public Teacher getTeacher(int id) {
		String sql = "SELECT teacher.firstname,teacher.lastname, teacher.gender, teacher.email, teacher.address, teacher.status, teacher.created,"
				+ "teacher.updated, teacher.phone, tbl_class.id AS class_id, tbl_class.class_name, subject.id AS subject_id, subject.title FROM teacher JOIN class_subject_teacher ON teacher.id = class_subject_teacher.teacher_id"
				+ "JOIN tbl_class ON tbl_class.id = class_subject_teacher.class_id JOIN SUBJECT ON subject.id = class_subject_teacher.subject_id WHERE teacher.id=?";
		Teacher teacher = null;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				int classId = rs.getInt("class_id");
				int subjectId = rs.getInt("subject_id");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				String gender = rs.getString("gender");
				String updated = rs.getString("updated");
				String address = rs.getString("address");
				teacher = new Teacher(firstname,lastname,gender,address,email,phone,classId,subjectId, updated);
			}
			//Dbconnection.disconnect();
			rs.close();
			pstmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return teacher;
	}
	
	
	public List<Teacher> getAllTeachers(){
		List<Teacher> allTeachers = new ArrayList<>();
		String sql = "SELECT teacher.id AS teacher_id, teacher.firstname,teacher.lastname, teacher.gender, teacher.email, teacher.address, teacher.status, teacher.created,\r\n"
				+ "teacher.updated, teacher.phone, tbl_class.id AS class_id, tbl_class.class_name, subject.id AS subject_id, subject.title FROM teacher JOIN class_subject_teacher ON teacher.id = class_subject_teacher.teacher_id\r\n"
				+ "JOIN tbl_class ON tbl_class.id = class_subject_teacher.class_id JOIN SUBJECT ON subject.id = class_subject_teacher.subject_id";
		Statement statement = null;
		try{
			statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				int teacherId = rs.getInt("teacher_id");
				int classId = rs.getInt("class_id");
				int subjectId = rs.getInt("subject_id");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String gender = rs.getString("gender");
				String created = rs.getString("created");
				String updated = rs.getString("updated");
				String phone = rs.getString("phone");
				
				
				Teacher teacher = new Teacher(teacherId, firstname,lastname, gender, address, email,phone,
						classId,subjectId,created, updated);
				allTeachers.add(teacher);
				
			}
			//Dbconnection.disconnect();
			rs.close();
			statement.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return allTeachers;
				
	}
	
	public int getTotalTeachers() {
		String sql = "SELECT COUNT(*) FROM teacher";
		int count = 0;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			count = rs.getInt("count(*)");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public boolean validateTeacher(Teacher teacher) {
		String sql = "SELECT id, firstname FROM teacher  WHERE id = ?";
		boolean flag = false;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, teacher.getId());
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
		String query = "SELECT teacher_id, class_id, subject_id FROM class_subject_teacher  WHERE teacher_id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, teacher.getId());
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
