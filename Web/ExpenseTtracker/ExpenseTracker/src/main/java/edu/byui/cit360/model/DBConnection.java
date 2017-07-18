package edu.byui.cit360.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

import com.mysql.cj.jdbc.MysqlDataSource;

public class DBConnection {
	
	public Connection getDBConnection() {
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setServerName("localhost");
		dataSource.setDatabaseName("expense_tracker");
		dataSource.setPortNumber(3306); 
		dataSource.setUser("root");
		//dataSource.setPassword("pass");
		
		try {
			Connection conn = dataSource.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM user");
			return conn;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;	
	}  
	
	public void closeConnection(Connection conn, Statement stmt, ResultSet rs) {
		try {
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	public static void main(String[] args) {
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setServerName("localhost");
		dataSource.setDatabaseName("expense_tracker");
		dataSource.setPortNumber(3306); 
		dataSource.setUser("root");
		//dataSource.setPassword("pass");
		
		try {
			Connection conn = dataSource.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM user");
			if(rs.next()){
				System.out.println(rs.getString("password"));
			}
			
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
		  
}
