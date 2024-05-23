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
    public boolean login(String email, String password) {
        Utente utenteInDB = dao.getByEmail(email);
        if (utenteInDB.getPassword().equals(password)) {
            System.out.println("Utente trovato in DB : " +utenteInDB.toString());
            return true;
        }
        else {
            System.out.println("Utente non trovato in DB : " +utenteInDB.toString());
            return false;
        }
    }

    @Override
    @Transactional
    public boolean updateUtente(Utente utente) {
        Utente utenteInDB = dao.getByEmail(utente.getEmail());
        if (utenteInDB != null && !utenteInDB.equals(utente)) {
            dao.update(utente);
            System.out.println(utente);
            return true;
        } else {
            System.out.println("NO UPDATE");
            return false;
        }

        /*if (!(utente == null)) {
            Utente utenteVecchio = dao.getByEmail(utente.getEmail());
            dao.update(utente);
            boolean utenteAggiornato = utenteVecchio.equals((Utente) dao.getByEmail(utente.getEmail()));
            if (utenteAggiornato) {
                return true;
            } else {
                System.out.println("Utente con email : " + utente.getEmail() + " non è stato aggiornato correttamente ");
            }
        }
        return false;*/
    }

    @Override
    public boolean delete(Utente utente) {
        Utente utenteVecchio = dao.getByEmail(utente.getEmail()) ;
        dao.delete(utente) ;
        boolean nonEsiste = dao.getByEmail(utente.getEmail()) == null;
        if (nonEsiste) {
            System.out.println("utente cancellato");
            return true ;
        }
        else {
            System.out.println("utente non cancellato , prova di nuovo");
            return false ;
        }
    }

}
