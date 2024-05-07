package com.corso.service.impl;

import com.corso.dao.SigleSpecialiDAO;
import com.corso.model.SigleSpeciali;
import com.corso.service.SigleSpecialiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SigleSpecialiServiceImpl implements SigleSpecialiService {

    SigleSpecialiDAO dao = null;

    @Override
    public void setDao(SigleSpecialiDAO sigleSpecialiDAO) {
        this.dao = sigleSpecialiDAO;
    }


    @Override
    public boolean addPaeseSpeciale(SigleSpeciali paese)  {
        try {
            if ( !(paese.getSigla().isEmpty()) && !(paese.getPaese().isEmpty()) ) {
                SigleSpeciali siglaNuova = new SigleSpeciali(paese.getSigla(),paese.getPaese());
                dao.add(siglaNuova) ;
                return true ;            }
            else {
                System.out.println("mancano campi nell'argomento passato :  " +paese);
                return false ;
            }
        }catch (SQLException exception) {
            System.out.println("Error while adding a new SigleSpeciali nel db , error : " +exception);
        }
        return false;
    }

    @Override
    public SigleSpeciali findById(int id) throws SQLException {
        return dao.findById(id);
    }


    public SigleSpeciali findBySigla (String sigla) {
        if (!(sigla.isEmpty()) ) {
            try {
                return dao.findBySigla(sigla) ;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return null ;
    }

    @Override
    public List<SigleSpeciali> findAll() throws SQLException {
        return dao.findAll() ;
    }

}
