package com.corso.dao;

import com.corso.enums.GiochiEnum;
import com.corso.model.Gioco;

import javax.transaction.Transactional;
import java.util.List;

public interface GiocoDAO {
    @Transactional
    public void add(Gioco gioco);

    @Transactional
    List<Gioco> findAll(GiochiEnum gioco);

    @Transactional
    List<Gioco> findAllBest(GiochiEnum gioco);

    @Transactional
    List<Gioco> findAllPerUser(String utente, GiochiEnum gioco);

    @Transactional
    List<Gioco> findBestPerUser(String utente, GiochiEnum gioco);
}
