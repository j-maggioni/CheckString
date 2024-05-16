package com.corso.service.impl;

import com.corso.dao.UtenteDAO;
import com.corso.service.UtenteService;
import com.corso.model.Utente;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UtenteServiceImpl implements UtenteService {
    UtenteDAO dao = null;

    @Override
    @Transactional
    public void setDao(UtenteDAO utenteDAO) {
        dao = utenteDAO;
    }

    @Override
    @Transactional
    public Utente getUtenteByEmail(String email) {
        return dao.getByEmail(email);
    }

    @Override
    @Transactional
    public void addUtente(Utente utente) {
        dao.add(utente);
    }

    @Override
    @Transactional
    public void updateUtente(Utente utente) {
        dao.update(utente);
    }
}
