package com.corso.service;

import com.corso.dao.*;
import com.corso.model.SigleSpeciali;

import java.sql.SQLException;
import java.util.List;

public interface SigleSpecialiService {


     void setDao(SigleSpecialiDAO sigleSpecialiDAO); //c'è gia la set dao nell'implementazione

     boolean addPaeseSpeciale(SigleSpeciali paese);
     SigleSpeciali findById(int id) throws SQLException;
     List<SigleSpeciali> findAll() throws SQLException;
     SigleSpeciali findBySigla (String sigla) throws SQLException;


     }
