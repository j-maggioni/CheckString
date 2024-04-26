package com.corso.standard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public abstract class DBConfig {

	public static String dbName = "checkstring" ;
	public static String dburl = "jdbc:mysql://localhost:3306/"+dbName ;
	public static String dbuser = "root";
	public static String dbpass = "Ramadan14" ;
	
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
    public static Connection getConnection () {
    	try {
			Connection cn = DriverManager.getConnection(dburl, dbuser, dbpass);
			//System.out.println("Connection ok !! to DB name : " +dbName);
			return cn ;
		} catch (Exception e) {
			System.out.println("Error connecting to db " +dburl+ " msg : " +e);
			return null ;
		}
    }
    public static Statement getStatement (Connection cn) {
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
	public static void connectToDB() throws Exception {
  	  loadDriver() ;
  	  //getConnection() ;
  	  Connection connection = getConnection() ;
  	  //getStatement(connection);
  	  Statement statement = getStatement(connection);
  	  
      try {
    	  statement.execute("use "+dbName);
    	  String queryTest = "Select name from world ;" ;
    	  ResultSet rs1 = statement.executeQuery(queryTest) ;
    	  String nomiPaesiDB = rs1.getString(1);
    	  System.out.println("Nome pese :  "+nomiPaesiDB);
	} catch (SQLException e) {
		statement.cancel();
		System.out.println("error while connecting to db");
	} finally {
		//connection.close();
		System.out.println("Closing connection to db !! ");

	}
	}
}
