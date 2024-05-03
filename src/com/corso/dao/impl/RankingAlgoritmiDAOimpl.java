package com.corso.dao.impl;

import com.corso.bean.AlgoritmoEseguito;
import com.corso.dao.RankingAlgoritmiDAO;
import com.corso.model.RankingAlgoritmi;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

public class RankingAlgoritmiDAOimpl extends BaseDAOimpl implements RankingAlgoritmiDAO {

    @Override
    @Transactional
    public AlgoritmoEseguito add(AlgoritmoEseguito algoritmo) {
        manager.persist(algoritmo);
        return algoritmo;
    }

    @Override
    @Transactional
    public void update(AlgoritmoEseguito algoritmo) {
        manager.merge(algoritmo);
    }

    @Override
    public List<AlgoritmoEseguito> all() {
        Query q = manager.createQuery("from ranking_algoritmi", RankingAlgoritmi.class);
        @SuppressWarnings("unchecked")
        List<AlgoritmoEseguito> algoritmi = q.getResultList();
        return algoritmi;
    }
}
