package com.corso.dao;


import com.corso.model.Gioco;

import javax.transaction.Transactional;
import java.util.List;

public interface GiocoDAO {
    @Transactional
    public void add(Gioco gioco);

    @Transactional
    List<Gioco> findAll(String gioco);

    @Transactional
    List<Gioco> findAllBest(String gioco);

    @Transactional
    List<Gioco> findAllPerUser(String utente, String gioco);

    @Transactional
    List<Gioco> findBestPerUser(String utente, String gioco);
}
