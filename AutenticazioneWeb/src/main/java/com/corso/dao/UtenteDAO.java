package com.corso.dao;

import com.corso.model.Utente;

import javax.transaction.Transactional;

public interface UtenteDAO {
    @Transactional
    public Utente getByEmail(String email);
    @Transactional
    public void add(Utente utente);
    @Transactional
    public void update(Utente utente);
    @Transactional
    void delete(String utente);



}
