package com.corso.algoritmi;

import java.util.ArrayList;
import java.util.List;

import com.corso.bean.Standard;
import com.corso.standard.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;


public class RicercaRapida implements ParoleStandard {
	
	private static Statement statement;
	
    public RicercaRapida() throws Exception {
    	statement = DBConfig.connectToDB();
    	statement.execute("CREATE TABLE IF NOT EXISTS ricerche_recenti (PK INT AUTO_INCREMENT PRIMARY KEY, data_inserimento DATE,"
    			+ "input VARCHAR(255),"
    			+ "standard VARCHAR(255)," 
    			+ "algoritmo VARCHAR(200));" );
    }


    //recupero di tutti gli input in ricerche recenti
    @Override
    public List<Standard> getStandards() {
        List<Standard> standards = new ArrayList<>();
        String query = "SELECT * FROM ricerche_recenti";
        try (ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
            	String code = resultSet.getString("code");
                String word = resultSet.getString("standard");
                Standard s = new Standard(code, word);
                standards.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return standards;
    }

    
    //ricerca input nel db ricerche recenti
    public String isWordInDatabase(String input) {
        try {
            String query = "SELECT standard FROM ricerche_recenti WHERE input = \'" + input + "\';";
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                return resultSet.getString("standard");
            } else {
                return null; // Se non trova una corrispondenza, restituisce null
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
    
    //aggiunta riga nel db ricerche recenti
    public static void addInDB(String input, String output, String algoritmo) {
    	 try {
             String query = "SELECT * FROM ricerche_recenti WHERE input = \'" + input + "\';";
             ResultSet resultSet = statement.executeQuery(query);
             if (!resultSet.next()) {
            	 String query1 = "INSERT INTO checkstring.ricerche_recenti (data_inserimento, input, standard, algoritmo) "
                 		+ "VALUES (CURDATE(), \'" + input + "\', \'" + output + "\', \'" + algoritmo + "\' );";
                 int rowsInserted = statement.executeUpdate(query1);
                 if (rowsInserted > 0) {
                     System.out.println("Riga aggiunta al database con successo.");
                 } else {
                     System.out.println("Errore durante l'aggiunta della riga al database.");
                 }
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }
    }
}
