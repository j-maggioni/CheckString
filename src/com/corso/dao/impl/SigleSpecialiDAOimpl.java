package com.corso.dao.impl;

import com.corso.dao.SigleSpecialiDAO;
import com.corso.model.SigleSpeciali;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SigleSpecialiDAOimpl extends BaseDAOimpl implements SigleSpecialiDAO {

    @PersistenceContext
    EntityManager manager;

    @Transactional
    @Override
    public boolean add(SigleSpeciali paese) throws SQLException {
        manager.persist(paese);
        return true ;
    }

    @Override
    @Transactional
    public SigleSpeciali findById(int id) throws SQLException {
        Query query  = manager.createNamedQuery("SigleSpeciali.ById" , SigleSpeciali.class) ;
        query.setParameter("id", id);
        SigleSpeciali sigla = (SigleSpeciali) query.getSingleResult();
        return sigla ;
    }


    @Override
    @Transactional
    public java.util.List<SigleSpeciali> findAll () throws SQLException {
        Query query = manager.createNamedQuery("SigleSpeciali.All", SigleSpeciali.class) ;
        //List<SigleSpeciali> listaSigle = new ArrayList<>(query.getResultList()); // va in errore
        List<SigleSpeciali> listaSigle = query.getResultList() ;
        return listaSigle ;
    }

    @Override
    @Transactional
    public SigleSpeciali findBySigla(String siglaInput) throws SQLException {
        TypedQuery<SigleSpeciali> query = manager.createNamedQuery("SigleSpeciali.BySigla", SigleSpeciali.class);
        query.setParameter("siglaInput", siglaInput );
        SigleSpeciali sigla = query.getSingleResult() ;
        return sigla;
    }
}
