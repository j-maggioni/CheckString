package com.corso.service.impl;

import com.corso.dao.GiocoDAO;
import com.corso.model.Gioco;
import com.corso.service.GiocoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GiocoServiceImpl implements GiocoService {
    GiocoDAO dao = null;

    @Override
    public void setDao(GiocoDAO giocoDAO) {
        dao = giocoDAO;
    }

    @Override
    @Transactional
    public void addGiocata(Gioco gioco) {
        dao.add(gioco);
    }

    @Override
    @Transactional
    public List<Gioco> getAll() {
        return dao.findAll();
    }

    @Override
    @Transactional
    public List<Gioco> getAllBest() {
        return dao.findAllBest();
    }

    @Override
    @Transactional
    public List<Gioco> getUserAll(String utente) {
        return dao.findAllPerUser(utente);
    }

    @Override
    @Transactional
    public List<Gioco> getUserAllBest(String utente) {
        return dao.findBestPerUser(utente);
    }
}
