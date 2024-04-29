package com.corso.standard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public abstract class DBConfig {

	private static String dbName = "checkstring" ;
	private static String dburl = "jdbc:mysql://localhost:3306/"+dbName ;
	private static String dbuser = "root";
	private static String dbpass = "";
	
	private static Connection connection;
	private static Statement statement;
	
	private static void loadDriver() {  
		try {
			Class.forName("com.mysql.cj.jdbc.Driver") ;
		} catch (Exception e) {
			System.out.println("Error loading driver, msg : " +e);
		}
	}
    
	private static void newConnection ()  {
    	try {
			connection = DriverManager.getConnection(dburl, dbuser, dbpass);
		} catch (Exception e) {
			System.out.println("Error connecting to db " +dburl+ " msg : " +e);
		}
    }
    
	private static void newStatement () {
	    try {
			statement = connection.createStatement();
			statement.execute("use "+dbName);
		} catch (SQLException e) {
	    	System.out.println("Error while creating Statement, msg : " +e);
			e.printStackTrace();
		}
    }

    public static Statement connectToDB()   { 	   
	    try {
	    	  loadDriver();
	      	  newConnection();
	      	  newStatement();
	    	  statement.execute("use "+dbName);
	    	  return statement;
		} catch (SQLException e) {
			System.out.println("error while connecting to db");
			return null;
		}
	}
	
    public static boolean closeConnection() {
		try {
			connection.close();
			statement.close();
			return true;
		} catch (Exception e) {
			System.out.println("error while closing the connection");
			return false;
		}
	}
}
