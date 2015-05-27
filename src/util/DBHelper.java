package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBHelper {
	// Database Driver
	private static final String driver = "com.mysql.jdbc.Driver";
	// URL address for database connection
	private static final String url = "jdbc:mysql://localhost:3306/shopping?useUnicode=true&characterEncoding=UTF-8";
	// Username of database
	private static final String username = "root";
	// password of database
	private static final String password = "123456";

	private static Connection conn = null;

	// static code for load driver
	static {
		try {
			Class.forName(driver);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// return database connection object via single sample model
	public static Connection getConnection() throws Exception {
		if (conn == null) {
			conn = DriverManager.getConnection(url, username, password);
			return conn;
		}
		return conn;
	}

	/*
	 * public static void main(String[] args){
	 * 
	 * try{ Connection conn = DBHelper.getConnection(); if(conn != null){
	 * System.out.println("Database Connects successfully!"); }else{
	 * System.out.println("Database Connects unsuccessfully£¡"); }
	 * }catch(Exception ex){ ex.printStackTrace(); } }
	 */
}
