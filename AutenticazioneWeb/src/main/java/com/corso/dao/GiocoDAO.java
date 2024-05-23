package com.corso.dao;

import com.corso.model.Gioco;


import javax.transaction.Transactional;
import java.util.List;

public interface GiocoDAO {
    @Transactional
    public void add(Gioco gioco);

    @Transactional
    List<Gioco> findAll();

    @Transactional
    List<Gioco> findAllBest();

    @Transactional
    List<Gioco> findAllPerUser(String utente);

    @Transactional
    List<Gioco> findBestPerUser(String utente);
}
