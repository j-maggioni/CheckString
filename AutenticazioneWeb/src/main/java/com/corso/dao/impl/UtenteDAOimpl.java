package com.corso.dao.impl;

import com.corso.dao.UtenteDAO;
import com.corso.model.Utente;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class UtenteDAOimpl implements UtenteDAO {

    @PersistenceContext
    EntityManager manager;

    @Override
    public Utente getByEmail(String email) {
        return manager.find(Utente.class,email);
    }

    @Override
    public void add(Utente utente) {
        manager.persist(utente);
    }

    @Override
    public void update(Utente utente) {
        manager.merge(utente);
    }
}
