package com.simplilearn.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dbconnection {
	
	private static Connection con;
	private final static String CLASS_lOADER = "com.mysql.jdbc.Driver";
	private final static String DB_URL = "jdbc:mysql://localhost/academydb";
	private final static String DB_PWD = "";
	private final static String DB_USR = "root";
	private static ResultSet rs = null;
	
	
	public static Connection connect() {
		try {
			Class.forName(CLASS_lOADER);
			con = DriverManager.getConnection(DB_URL,DB_USR,DB_PWD);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return con;
		
	}
	
	public static ResultSet selectSQL(Connection con, String sql) {
		//ResulSet rs = null;
		try {
			con = connect();
			Statement statement = con.createStatement();
			rs = statement.executeQuery(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
		
	}
	
	public static int insertSQL(Connection con, String sql) {
		int i = 0;
		try {
			con = connect();
			Statement statement = con.createStatement();
			i = statement.executeUpdate(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return i;
	}
	
	public static void disconnect() throws SQLException {
        if (con != null && !con.isClosed()) {
            con.close();
        }
    } 
	
	
}
