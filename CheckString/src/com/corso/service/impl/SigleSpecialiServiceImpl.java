package com.corso.service.impl;

import com.corso.dao.SigleSpecialiDAO;
import com.corso.model.SigleSpeciali;
import com.corso.service.SigleSpecialiService;

import java.sql.SQLException;
import java.util.List;

public class SigleSpecialiServiceImpl implements SigleSpecialiService {

    SigleSpecialiDAO dao = null;

    @Override
    public void setDao(SigleSpecialiDAO sigleSpecialiDAO) {
        this.dao = sigleSpecialiDAO;
    }


    @Override
    public void addPaeseSpeciale(SigleSpeciali sigla)  {
        if (sigla != null) {
            dao.add(sigla);
        }
    }

    @Override
    public SigleSpeciali findById(int id) {
        return dao.findById(id);
    }


    public SigleSpeciali findBySigla (String sigla) {
        if (!(sigla.isEmpty()) ) {
            return dao.findBySigla(sigla) ;
        }
        return null ;
    }

    @Override
    public List<SigleSpeciali> findAll() {
        return dao.findAll() ;
    }

}
