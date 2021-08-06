package com.simplilearn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.simplilearn.util.Dbconnection;
import com.simplilearn.model.User;


public class LoginDAO {
		
private Connection con = Dbconnection.connect();

	public void save(User user) {
		String sql = "INSERT INTO user (firstname,lastname, email, password, gender, created, updated, status_id, groupType) VALUES(?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getFirstname());
			pstmt.setString(2, user.getLastname());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getPassword());
			pstmt.setString(5, user.getGender());
			pstmt.setString(6, user.getCreated());
			pstmt.setString(7, user.getUpdated());
			pstmt.setInt(8, user.getStatus());
			pstmt.setString(9, user.getGroup());
			int i = pstmt.executeUpdate();
			Dbconnection.disconnect();
			pstmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void updateUser(User user) {
	
		String sql = "UPDATE user SET firstname=?,lastname=?, email=?, password=?, gender=?, "
				+ "updated=?, status_id=?, groupType=? WHERE id=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getFirstname());
			pstmt.setString(2, user.getLastname());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getPassword());
			pstmt.setString(5, user.getGender());
			pstmt.setString(6, user.getUpdated());
			pstmt.setInt(7, user.getStatus());
			pstmt.setString(8, user.getGroup());
			int i = pstmt.executeUpdate();
			Dbconnection.disconnect();
			pstmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void deleteUser(int id) {
		String sql = "DELETE FROM user WHERE id=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			int i = pstmt.executeUpdate();
			Dbconnection.disconnect();
			pstmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public User getUserById(int id) {
		String sql = "SELECT id, firstname,lastname, email, gender, created, updated, status_id, groupType FROM user WHERE id=?";
		User user = null;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String email = rs.getString("email");
				String password = rs.getString("password");
				String gender = rs.getString("gender");
				String created = rs.getString("created");
				String updated = rs.getString("updated");
				int status_id = rs.getInt("status_id");
				String groupType = rs.getString("groupType");
				
				user = new User(id,firstname,lastname,email,password,gender,created,updated, groupType,status_id);
				
			}
			Dbconnection.disconnect();
			rs.close();
			pstmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	
	public List<User> getAllUsers(){
		List<User> allUsrs = new ArrayList<>();
		String sql = "SELECT id, firstname,lastname, email, password, gender, created, updated, status_id, groupType FROM user";
		Statement statement = null;
		try{
			statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt("id");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String email = rs.getString("email");
				String password = rs.getString("password");
				String gender = rs.getString("gender");
				String created = rs.getString("created");
				String updated = rs.getString("updated");
				int status_id = rs.getInt("status_id");
				String groupType = rs.getString("groupType");
				
				User user = new User(id,firstname,lastname,email,password,gender,created,updated, groupType,status_id);
				allUsrs.add(user);
				
			}
			Dbconnection.disconnect();
			rs.close();
			statement.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return allUsrs;
				
	}
	
	public int getTotalUsers() {
		String sql = "SELECT * FROM user";
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
	
	public boolean validateUser(String email, String pass) {
		String sql = "SELECT firstname, lastname, email, password FROM user  WHERE email = ? AND password = ?";
		boolean flag = false;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			rs.last();
			if(rs.getRow() > 0) {
				flag = true;
			} 	
			//Dbconnection.disconnect();
			//ps.close();
			//rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return flag;
		
	}
	
	public User getUser(String email,String pass) {
		String sql = "SELECT id, firstname, lastname, email,gender,created,updated,status_id,groupType FROM user  WHERE email = ? AND password = ?";
		User user = null;
		boolean flag = false;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int id = rs.getInt("id");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String emailId = rs.getString("email");
				String gender = rs.getString("gender");
				String created = rs.getString("created");
				String updated = rs.getString("updated");
				int statusId = rs.getInt("status_id");
				String group  = rs.getString("groupType");
				
				user = new User(id,firstname,lastname, emailId, gender,gender, created, updated,group,statusId);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return user;
		
	}
	
	

//	@SuppressWarnings("deprecation")
//	public User getSingleUser(String email,String pass) {
//		Transaction tranx = null;
//		User user = null;
//		try(Session session = HibernateUtil.getSessionFactory(cls).openSession()){
//			tranx  = session.beginTransaction();
//	@SuppressWarnings("unchecked")
//	Query<User> query = 
//	session.createQuery("select firstname, lastname, gender, group from user u WHERE u.email=:email AND u.password=:password");
//
//	query.setString("email",email);
//	query.setString("pass", pass);
//			return query.uniqueResult();
//		}catch(Exception e) {
//			return null;
//		}
//		
//	}
	

	
	
	
}
