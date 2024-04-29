package com.corso.standard;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;


public class Client implements ParoleStandard {
    
    private static final String DB_URL = "jdbc:mysql://localhost:3306/checkstring";
    private static final String USER = "root";
    private static final String PASSWORD = "Winnie2022.";
    private Connection connection;

    public Client() {
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connessione al database MySQL stabilita con successo.");
        } catch (SQLException e) {
            System.err.println("Errore durante la connessione al database MySQL:");
            e.printStackTrace();
        }
    }


    //recupero di tutti gli input in ricerche recenti
    @Override
    public List<Standard> getStandards() {
        List<Standard> standards = new ArrayList<>();
        String query = "SELECT * FROM ricerche_recenti";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
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
            String query = "SELECT standard FROM ricerche_recenti WHERE input = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, input);
            ResultSet resultSet = statement.executeQuery();
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
    public void addInDB(String input, String output) {
        try {
            String query = "INSERT INTO checkstring.ricerche_recenti (data_inserimento, input, standard) VALUES (CURDATE(), ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, input);
            statement.setString(2, output);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Riga aggiunta al database con successo.");
                return;
            } else {
                System.out.println("Errore durante l'aggiunta della riga al database.");
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
    }




    // Chiusura connessione db
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
