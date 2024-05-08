package com.corso.dao;

import com.corso.model.Paesi;
import com.corso.model.SigleSpeciali;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;

@Transactional
public interface PaesiDAO {
     void initPaesi() throws SQLException ;
    // Paesi findById(int id) throws SQLException;
     Paesi findByCodice2(String Codice2) throws SQLException;
     Paesi findByCodice3(String Codice3) throws SQLException;
     List<Paesi> findAll();
     boolean addPaese(Paesi paese) throws SQLException ;
}
