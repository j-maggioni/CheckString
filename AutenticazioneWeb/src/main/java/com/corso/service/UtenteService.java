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
    public boolean addUtente(Utente utente);

    @Transactional
    public boolean login(String email, String password);

    @Transactional
    public boolean updateUtente(Utente utente);

    @Transactional
    public void delete(String utente);
}
