package com.corso.algoritmi;

import java.lang.reflect.Constructor;
import java.sql.*;
import java.util.ArrayList;

import com.corso.standard.DBConfig;

public class AlgorithmRanking {

	private static ArrayList<String> paesiFromDB;
	private static Connection connection;
	private static Statement statement;
	private static String[] algoritmiName = {"ContainedCheckString","ContainsCheckString","Levenstein 1",
											"Levenstein 2","Levenstein 3","Levenstein 4"};
	
	public static void algorithmRanking() throws Exception {
		paesiFromDB = new ArrayList<String>();		
		DBConfig.loadDriver();
		connection = DBConfig.getConnection();
		statement = DBConfig.getStatement(connection);

		try {
			statement.execute("use "+DBConfig.dbName);
			ResultSet result = statement.executeQuery("Select name from country;");
			while (result.next()) {
				paesiFromDB.add(result.getString("name"));
			};
			
		} catch (SQLException e) {
			statement.cancel();
			System.out.println("error while connecting to db");
			e.printStackTrace();
		}
		
		statement.execute("CREATE TABLE IF NOT EXISTS ranking_algoritmi(Nome VARCHAR(100),Esatti INT, Totali INT, Score DOUBLE);");
		statement.execute("TRUNCATE TABLE ranking_algoritmi;");
		
		for (String name: algoritmiName) {
			insertRow(createCheckStringInstance("com.corso.algoritmi."+name));  
		}
		
		statement.executeUpdate("ALTER TABLE ranking_algoritmi ORDER BY score ASC;");
		
		connection.close();
	}

	private static void insertRow(CheckString c) throws Exception {
		int count = 0;
		for (String nomePaese: paesiFromDB) {
			Esito esito = c.check(nomePaese);
			if(esito.getEsito()) {
				count++;
			}
		}
		double score = (double) count/paesiFromDB.size();
		String sql = "INSERT INTO ranking_algoritmi VALUES ('"+c.getName()+"', "+count+","+paesiFromDB.size()+","+score+");";
		statement.executeUpdate(sql);
	}
	
	public static CheckString getFirstAlgorithm() throws Exception {
		DBConfig.loadDriver();
		Connection connection = DBConfig.getConnection();
		Statement statement = DBConfig.getStatement(connection);
		
		statement.execute("use "+DBConfig.dbName);
		ResultSet result = statement.executeQuery("SELECT * FROM ranking_algoritmi;");
		
		ArrayList<CheckString> algoritmi = new ArrayList<CheckString>();
		while (result.next()) {
			CheckString c = createCheckStringInstance("com.corso.algoritmi."+result.getString("Nome"));
	        algoritmi.add(c);  
		}
		
		for (int i=0; i<algoritmi.size()-1; i++) {
			algoritmi.get(i).setNext(algoritmi.get(i+1));
		}
		
		return algoritmi.get(0);
		
    }
		
	private static CheckString createCheckStringInstance(String className) throws Exception {
		Object object = null;
		System.out.println(className);
		try {
			if (className.split(" ").length > 1) {	//caso per Levenstein
				Class c = Class.forName(className.split(" ")[0]);
				Class[] intArgsClass = new Class[] {int.class};
				Constructor constructor = c.getConstructor(intArgsClass);
				object = constructor.newInstance(Integer.parseInt(className.split(" ")[1]));
			} else {
				Class classDefinition = Class.forName(className);
				object = classDefinition.newInstance();
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return (CheckString) object;
   }
	
}
