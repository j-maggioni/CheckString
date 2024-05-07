package com.corso.dao;

import com.corso.model.SigleSpeciali;

import java.sql.SQLException;
import java.util.List;

public interface SigleSpecialiDAO  {
     boolean add(SigleSpeciali siglaSpeciale) throws SQLException;
    SigleSpeciali findById(int id) throws SQLException;
    List<SigleSpeciali> findAll () throws SQLException;
    SigleSpeciali findBySigla(String sigla) throws SQLException;

}
