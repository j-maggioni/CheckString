package com.corso.service.impl;

import com.corso.dao.UtenteDAO;
import com.corso.model.Utente;
import com.corso.service.UtenteService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UtenteServiceImpl implements UtenteService {
    UtenteDAO dao = null;

    @Override
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
    public boolean addUtente(Utente utente) {
        Utente utenteInDB = dao.getByEmail(utente.getEmail());
        if (utenteInDB == null) {
            dao.add(utente);
            return true;
        } else {
            return false;
        }
    }

    @Override
    @Transactional
    public boolean login(String email, String password) {
        Utente utenteInDB = dao.getByEmail(email);
        if (utenteInDB != null){
            if (utenteInDB.getPassword().equals(password)) {
                System.out.println("Utente trovato in DB : " + utenteInDB.toString());
                return true;
            }
        }
        System.out.println("Utente non trovato in DB");
        return false;
    }

    @Override
    @Transactional
    public Utente updateUtente(Utente utente) {
        Utente utenteInDB = dao.getByEmail(utente.getEmail());
        if (utenteInDB != null) {
            utenteInDB.setNome(utente.getNome());
            utenteInDB.setCognome(utente.getCognome());
            utenteInDB.setEmail(utente.getEmail());
            String password;
            if (!utente.getPassword().isEmpty()) {
                password = utente.getPassword();
            } else {
                password = utenteInDB.getPassword();
            }
            utenteInDB.setPassword(password);
            utenteInDB.setNazione(utente.getNazione());
            utenteInDB.setPrefisso(utente.getPrefisso());
            utenteInDB.setTelefono(utente.getTelefono());
            dao.update(utenteInDB);
            return utenteInDB;
        } else {
            System.out.println("NO UPDATE");
            return null;
        }

    }

    @Override
    @Transactional
    public void delete(String email) {
        dao.delete(email) ;
    }

}
