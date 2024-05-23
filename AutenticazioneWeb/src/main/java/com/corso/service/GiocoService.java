package com.corso.service;

import com.corso.dao.GiocoDAO;
import com.corso.dao.UtenteDAO;
import com.corso.model.Gioco;
import com.corso.model.Utente;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public interface GiocoService {

    void setDao(GiocoDAO giocoDAO);

    @Transactional
    void addGiocata(Gioco gioco);

    @Transactional
    List<Gioco> getAll();

    @Transactional
    List<Gioco> getAllBest();

    @Transactional
    List<Gioco> getUserAll(String utente);

    @Transactional
    List<Gioco> getUserAllBest(String utente);
}
