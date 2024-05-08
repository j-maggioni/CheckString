package com.corso.dao;

import com.corso.model.Paesi;
import com.corso.model.SigleSpeciali;
import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;


public interface PaesiDAO {

    @Transactional
    List<Paesi> initPaesi() throws SQLException ;
    // Paesi findById(int id) throws SQLException;
    @Transactional
    Paesi findByCodice2(String Codice2) throws SQLException;
    @Transactional
    Paesi findByCodice3(String Codice3) throws SQLException;
    @Transactional
    List<Paesi> findAll();
    @Transactional
    boolean addPaese(Paesi paese) throws SQLException ;
}
