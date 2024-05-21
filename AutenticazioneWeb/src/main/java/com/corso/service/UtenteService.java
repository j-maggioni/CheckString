package com.corso.service;

import com.corso.dao.UtenteDAO;
import com.corso.model.Utente;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public interface UtenteService {

    public void setDao(UtenteDAO utenteDAO);

    @Transactional
    public Utente getUtenteByEmail(String email);

    @Transactional
    public void addUtente(Utente utente);

    @Transactional
    public boolean Login(String mail , String password) ;

    @Transactional
    public boolean updateUtente(Utente utente);

    @Transactional
    public boolean delete(Utente utente) ;
}
