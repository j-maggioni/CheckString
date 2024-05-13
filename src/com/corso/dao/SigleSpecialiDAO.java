package com.corso.dao;

import com.corso.model.SigleSpeciali;

import java.sql.SQLException;
import java.util.List;

public interface SigleSpecialiDAO  {
     boolean add(SigleSpeciali siglaSpeciale);
    SigleSpeciali findById(int id);
    List<SigleSpeciali> findAll ();
    SigleSpeciali findBySigla(String sigla);

}
