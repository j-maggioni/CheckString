package com.corso.dao.impl;

import com.corso.dao.GiocoDAO;
import com.corso.enums.GiochiEnum;
import com.corso.model.Gioco;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class GiocoDAOimpl implements GiocoDAO {

    @PersistenceContext
    EntityManager manager;

    @Override
    public void add(Gioco gioco) {
        manager.persist(gioco);
    }

    @Override
    @Transactional
    public List<Gioco> findAll(String gioco) {
        Query query = manager.createNamedQuery("Gioco.findAll");
        query.setParameter("gioco", gioco);

        List<Gioco> giocate = query.getResultList();
        return giocate;
    }

    @Override
    @Transactional
    public List<Gioco> findAllBest(String gioco) {
        Query query = manager.createNamedQuery("Gioco.findAllBest");
        query.setParameter("gioco", gioco);

        List<Gioco> giocate = query.getResultList();
        return giocate;
    }

    @Override
    @Transactional
    public List<Gioco> findAllPerUser(String utente, String gioco) {
        Query query = manager.createNamedQuery("Gioco.findAllPerUser");
        query.setParameter("utente", utente);
        query.setParameter("gioco", gioco);

        List<Gioco> giocate = query.getResultList();
        return giocate;
    }

    @Override
    @Transactional
    public List<Gioco> findBestPerUser(String utente, String gioco) {
        Query query = manager.createNamedQuery("Gioco.findBestPerUser");
        query.setParameter("utente", utente);
        query.setParameter("gioco", gioco);

        List<Gioco> giocate = query.getResultList();
        return giocate;
    }

}
