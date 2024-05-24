package com.corso.dao.impl;

import com.corso.dao.UtenteDAO;
import com.corso.model.Utente;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

public class UtenteDAOimpl implements UtenteDAO {

    @PersistenceContext
    EntityManager manager;

    @Override
    @Transactional
    public Utente getByEmail(String email) {
        Utente utente =  manager.find(Utente.class,email);
        return utente;
    }


@Override
    @Transactional
    public void add(Utente utente) {
        manager.persist(utente);
    }

    @Override
    @Transactional
    public void update(Utente utente) {
        manager.merge(utente) ;
    }


    @Override
    @Transactional
    public void delete(String utente) {
        Utente find = this.getByEmail(utente);
        if (find != null)
            manager.remove(find);
    }
}
