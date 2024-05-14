package com.corso.dao;

import com.corso.model.Paesi;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;


public interface PaesiDAO {

    @Transactional
    List<Paesi> initPaesi();
    @Transactional
    public void update(Paesi paese);
    @Transactional
    Paesi findByCodice2(String Codice2);
    @Transactional
    Paesi findByCodice3(String Codice3);
    @Transactional
    Paesi findByNome(String nome);
    @Transactional
    List<Paesi> findAll();
    @Transactional
    boolean addPaese(Paesi paese);
}
