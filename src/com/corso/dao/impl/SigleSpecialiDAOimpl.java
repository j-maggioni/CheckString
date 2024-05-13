package com.corso.dao.impl;

import com.corso.dao.SigleSpecialiDAO;
import com.corso.model.Paesi;
import com.corso.model.SigleSpeciali;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.List;

public class SigleSpecialiDAOimpl extends BaseDAOimpl implements SigleSpecialiDAO {

    @PersistenceContext
    EntityManager manager;

    @Transactional
    @Override
    public boolean add(SigleSpeciali paese){
        manager.persist(paese);
        return true ;
    }

    @Override
    @Transactional
    public SigleSpeciali findById(int id){
        Query query  = manager.createNamedQuery("SigleSpeciali.ById" , SigleSpeciali.class) ;
        query.setParameter("id", id);
        SigleSpeciali sigla = (SigleSpeciali) query.getSingleResult();
        return sigla ;
    }


    @Override
    @Transactional
    public java.util.List<SigleSpeciali> findAll (){
        Query query = manager.createNamedQuery("SigleSpeciali.All", SigleSpeciali.class) ;
        List<SigleSpeciali> listaSigle = query.getResultList() ;
        return listaSigle ;
    }

    @Override
    @Transactional
    public SigleSpeciali findBySigla(String siglaInput){
        Query querySigla = manager.createNamedQuery("SigleSpeciali.BySigla", SigleSpeciali.class) ;
        querySigla.setParameter("siglaInput", siglaInput);
        if (!querySigla.getResultList().isEmpty()) {
            SigleSpeciali result = (SigleSpeciali) querySigla.getResultList().get(0);
            return manager.find(SigleSpeciali.class, result.getId());
        }
        return null;
    }
}
