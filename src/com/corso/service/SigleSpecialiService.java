package com.corso.service;

import com.corso.dao.SigleSpecialiDAO;
import com.corso.model.SigleSpeciali;

import java.sql.SQLException;
import java.util.List;

public interface SigleSpecialiService {


     public void setDao(SigleSpecialiDAO sigleSpecialiDAO); //c'è gia la set dao nell'implementazione

     public void addPaeseSpeciale(SigleSpeciali paese);
     public SigleSpeciali findById(int id);
     public List<SigleSpeciali> findAll();
     public SigleSpeciali findBySigla (String sigla);

}
