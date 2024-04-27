package com.corso.standard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public abstract class DBConfig {

	public static String dbName = "checkstring" ;
	private static String dburl = "jdbc:mysql://localhost:3306/"+dbName ;
	private static String dbuser = "root";
	private static String dbpass = "Ramadan14" ;
	
	public static void loadDriver () {  
	try {
		Class.forName("com.mysql.cj.jdbc.Driver") ;
		final Connection connection = DriverManager.getConnection(dburl, dbuser, dbpass);
		//System.out.println("Driver OK !!");
		}
	catch (Exception e) {
		System.out.println("Error loading driver, msg : " +e);
	    }
	}// LoadDriver method
    public static Connection newConnection ()  {
    	try {
			Connection cn = DriverManager.getConnection(dburl, dbuser, dbpass);
			System.out.println("Connection ok !! to DB name : " +dbName);
			return cn ;
		} catch (Exception e) {
			System.out.println("Error connecting to db " +dburl+ " msg : " +e);
			return null ;
		}
    }
    public static Statement newStatement (Connection cn) {
    Statement st = null;
	try {
		st = cn.createStatement();
		st.execute("use "+dbName) ;
		//System.out.println("Statement ok !!");
		return st ;	} 
    catch (SQLException e) {
    	System.out.println("Error while creating Statement, msg : " +e);
		e.printStackTrace();
		return st ;
	}
    };

    // ****** Main Method of the class 
	public static Statement connectToDB()   { 	   
      try {
    	  loadDriver() ;
      	  Connection connection = newConnection() ;
      	  Statement statement = newStatement(connection);
    	  statement.execute("use "+dbName); 
    	  System.out.println("Statement created ok !!");
    	  return statement;
	} catch (SQLException e) {
		System.out.println("error while connecting to db");
		return null ;
	} 
//      finally {
//		//connection.close();
//		System.out.println("Closing connection to db !! ");
//
//	}
	}
	public boolean closeConnection (Connection cn , Statement st) {
		try {
			cn.close();
			st.close();
			return true ;
		} catch (Exception e) {
			System.out.println("error while closing the connection");
			return false ;
		}
	}
}
