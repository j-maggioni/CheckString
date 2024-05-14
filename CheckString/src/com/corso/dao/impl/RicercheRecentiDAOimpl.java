package com.corso.dao.impl;

import com.corso.dao.RicercheRecentiDAO;
import com.corso.model.RicercheRecenti;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class RicercheRecentiDAOimpl extends BaseDAOimpl implements RicercheRecentiDAO {

    @PersistenceContext
    EntityManager manager;

    @Transactional
    @Override
    public void add(RicercheRecenti ricerca) {
        manager.persist(ricerca);
        manager.flush();
    }

    @Override
    @Transactional
    public void update(RicercheRecenti ricerca) {
        manager.merge(ricerca);
    }

    @Override
    @Transactional
    public RicercheRecenti find(String input) {
        Query query = manager.createNamedQuery("RicercheRecenti.findInput");
        query.setParameter("input", input);

        List<RicercheRecenti> resultList = query.getResultList();
        if (!resultList.isEmpty()) {
            RicercheRecenti result = resultList.get(0);
            return manager.find(RicercheRecenti.class,result.getId());
        }
        return null;
    }

}
