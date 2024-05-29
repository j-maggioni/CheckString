package com.corso.service;

import com.corso.dao.PaesiDAO;
import com.corso.model.Paesi;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

public interface PaesiService {

     void setDao(PaesiDAO paesiDAO);
     @Transactional
     List<Paesi> findAll();
     @Transactional
     Paesi findBySigla(String codice);
     @Transactional
     Paesi findByNome(String nome);
     @Transactional
     void addPaese();

}