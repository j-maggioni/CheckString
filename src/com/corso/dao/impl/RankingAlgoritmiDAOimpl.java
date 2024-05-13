package com.corso.dao.impl;

import com.corso.dao.RankingAlgoritmiDAO;
import com.corso.model.RankingAlgoritmi;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class RankingAlgoritmiDAOimpl extends BaseDAOimpl implements RankingAlgoritmiDAO {

    @PersistenceContext
    EntityManager manager;

    @Override
    @Transactional
    public void add(RankingAlgoritmi algoritmo) {
        manager.persist(algoritmo);
    }

    @Override
    @Transactional
    public void update(RankingAlgoritmi algoritmo) {
        manager.merge(algoritmo);
    }

    @Override
    @Transactional
    public List<RankingAlgoritmi> all() {
        Query q = manager.createNamedQuery("RankingAlgoritmi.SortingResults");
        List<RankingAlgoritmi> algoritmi = q.getResultList();
        return algoritmi;
    }

    @Override
    public RankingAlgoritmi find(String id) {
        RankingAlgoritmi algoritmo =  manager.find(RankingAlgoritmi.class,id);
        //	manager.lock(categoria, LockModeType.OPTIMISTIC );
        return algoritmo;
    }

    @Override
    public List<RankingAlgoritmi> algoritmiAttivi() {
        Query q = manager.createNamedQuery("RankingAlgoritmi.ActiveAlgorithms");
        List<RankingAlgoritmi> algoritmi = q.getResultList();
        return algoritmi;
    }

}
