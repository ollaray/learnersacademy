package com.simplilearn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.simplilearn.model.ClassList;
import com.simplilearn.model.Subject;
import com.simplilearn.util.Dbconnection;



public class ClassDAO {

	private Connection con = Dbconnection.connect();
	
	public void save(ClassList cL) {
		String sql = "INSERT INTO tbl_class (class_name) VALUES(?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cL.getClassName());
			int i = pstmt.executeUpdate();
			pstmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void updateClass(ClassList cL) {
	
		String sql = "UPDATE tbl_class SET class_name = ? WHERE id=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cL.getClassName());
			pstmt.setInt(2, cL.getId());
			int i = pstmt.executeUpdate();
			pstmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void deleteClass(int id) {
		String sql = "DELETE FROM tbl_class WHERE id=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			int i = pstmt.executeUpdate();
			pstmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public ClassList getClass(int id) {
		String sql = "SELECT id, class_name FROM tbl_class WHERE id=?";
		ClassList cL = null;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				int classId = rs.getInt("id");
				String className = rs.getString("class_name");
				cL = new ClassList(classId, className);
			}
			pstmt.close();
			rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return cL;
	}
	
	
	public List<ClassList> getAllClass(){
		List<ClassList> allCls = new ArrayList<>();
		String sql = "SELECT id, class_name FROM tbl_class";
		try{
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String className = rs.getString("class_name");
				ClassList cL = new ClassList(id,className);
				
				allCls.add(cL);
			}
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return allCls;
				
	}
	
	public int getTotalClasses() {
		String sql = "SELECT * FROM tbl_class";
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
	
	public boolean validateClass(ClassList cL) {
		String sql = "SELECT class_name  FROM tbl_class  WHERE id = ?";
		boolean flag = false;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, cL.getId());
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
