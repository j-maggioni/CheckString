package com.corso.service;

import com.corso.dao.GiocoDAO;
import com.corso.model.Gioco;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public interface GiocoService {

    void setDao(GiocoDAO giocoDAO);

    @Transactional
    void addGiocata(Gioco gioco);

    @Transactional
    List<Gioco> getAll(String gioco);

    @Transactional
    List<Gioco> getAllBest(String gioco);

    @Transactional
    List<Gioco> getUserAll(String utente, String gioco);

    @Transactional
    List<Gioco> getUserAllBest(String utente, String gioco);
}
