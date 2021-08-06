package com.simplilearn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.simplilearn.model.Subject;
import com.simplilearn.util.Dbconnection;




public class SubjectDAO {
	
private Connection con = Dbconnection.connect();
	
	public void save(Subject subject) {
		String sql = "INSERT INTO subject (title,type) VALUES(?,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, subject.getTitle());
			pstmt.setString(2,subject.getSubjectType());
			pstmt.executeUpdate();
			Dbconnection.disconnect();
			pstmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void updateSubject(Subject subject) {
	
		String sql = "UPDATE subject SET title = ?, type=?  WHERE id=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, subject.getTitle());
			pstmt.setString(2, subject.getSubjectType());
			pstmt.setInt(3, subject.getId());
			pstmt.executeUpdate();
			Dbconnection.disconnect();
			pstmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void deleteSubject(int id) {
		String sql = "DELETE FROM subject WHERE id=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			pstmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public Subject getSubject(int id) {
		String sql = "SELECT title, type FROM subject WHERE id=?";
		Subject subject = null;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				String title = rs.getString("title");
				String type = rs.getString("type");
				subject = new Subject(title,type);
			}
			Dbconnection.disconnect();
			pstmt.close();
			rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return subject;
	}
	
	
	public List<Subject> getAllSubjects(){
		List<Subject> allSubs = new ArrayList<>();
		String sql = "SELECT id,title,type FROM subject";
		try{
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String type = rs.getString("type");
				Subject subject = new Subject(id,title,type);
				allSubs.add(subject);
			}
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return allSubs;
				
	}
	
	public int getTotalSubjects() {
		String sql = "SELECT * FROM subject";
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
	
	public boolean validateSubject(Subject subject) {
		String sql = "SELECT title FROM subject  WHERE id = ?";
		boolean flag = false;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, subject.getId());
			ResultSet rs = ps.executeQuery();
			rs.last();
			if(rs.getRow() > 0) {
				flag = true;
			} 	
			Dbconnection.disconnect();
			ps.close();
			rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return flag;
		
	}
}
