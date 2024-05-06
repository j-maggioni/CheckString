package com.corso.algoritmi;

import java.util.ArrayList;
import java.util.List;
import com.corso.config.Beans;
import com.corso.dao.RicercheRecentiDAO;
import com.corso.model.RicercheRecenti;
import com.corso.standard.Standard;
import com.corso.standard.*;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class RicercaRapida {

    //TEORICAMENTE QUESTA CLASSE NON SERVE PIù

    private RicercheRecentiDAO dao;
    BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);

    public RicercaRapida() {
        dao = factory.getBean("ricercheRecentiDAO", RicercheRecentiDAO.class);
    }

    /*recupero di tutti gli input in ricerche recenti
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
    }*/

    public String isWordInDatabase(String input) {
        BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
        dao = factory.getBean("ricercheRecentiDAO", RicercheRecentiDAO.class);
        RicercheRecenti r = dao.find(input);
        return r.getStandard();
    }

    public void addInDB(RicercheRecenti r) {
        BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
        dao = factory.getBean("ricercheRecentiDAO", RicercheRecentiDAO.class);
    	 try {
             RicercheRecenti f = dao.find(r.getInput());
             if (f != null) {
                 dao.add(r);
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
    }
}
