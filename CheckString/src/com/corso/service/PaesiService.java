package com.corso.service;

import com.corso.dao.PaesiDAO;
import com.corso.model.Paesi;

import java.sql.SQLException;
import java.util.List;

public interface PaesiService {

     void setDao(PaesiDAO paesiDAO);
     List<Paesi> findAll();
     Paesi findBySigla(String codice);
     Paesi findByNome(String nome);
     boolean addPaese ();

}