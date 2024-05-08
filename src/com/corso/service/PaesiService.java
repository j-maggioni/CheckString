package com.corso.service;

import com.corso.dao.PaesiDAO;
import com.corso.model.Paesi;

import java.sql.SQLException;
import java.util.List;

public interface PaesiService {

     void setDao(PaesiDAO paesiDAO);
     //Paesi findById(int id) throws SQLException;
     List<Paesi> findAll() throws SQLException;
     Paesi findBySigla(String codice) throws SQLException;
     boolean addPaese () throws SQLException;

}