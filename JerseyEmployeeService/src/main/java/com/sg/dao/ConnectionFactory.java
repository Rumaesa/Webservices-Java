package com.sg.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	// Step 1
	
	private String dbName = "employee";
	private String dbUser = "root";
	private String dbPassword = "Admin123";
	private String url = "jdbc:mysql://localhost:3306/" + dbName;
	private String driver = "com.mysql.cj.jdbc.Driver";

	public Connection con;

	// Step 2

	public Connection dbConnect() {
		try {
			Class.forName(driver); // loads the driver
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			con = DriverManager.getConnection(url, dbUser, dbPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public void dbClose() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
