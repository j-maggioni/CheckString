package com.corso.dao.impl;

import com.corso.dao.PaesiDAO;
import com.corso.model.Paesi;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class PaesiDAOimpl extends BaseDAOimpl implements PaesiDAO {
    @PersistenceContext
    private EntityManager manager;

    public EntityManager getManager() {return manager;}

    @Override
    public Paesi find(Integer id) {
        Paesi paese =  manager.find(Paesi.class,id);
        //	manager.lock(paese, LockModeType.OPTIMISTIC );
        return paese;
    }

    @Override
    public List<Paesi> all() {
        Query q = manager.createQuery("from Paesi", Paesi.class);
        @SuppressWarnings("unchecked")
        List<Paesi> paesi = q.getResultList();
        return paesi;
    }
}
