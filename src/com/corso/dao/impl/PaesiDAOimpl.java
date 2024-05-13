package com.corso.dao.impl;

import com.corso.dao.PaesiDAO;
import com.corso.model.Paesi;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.SQLException;
import java.util.List;

public class PaesiDAOimpl extends BaseDAOimpl implements PaesiDAO {

    @PersistenceContext
    EntityManager manager;

    @Transactional
    @Override
    public List<Paesi> initPaesi() {
        Query queryinit = manager.createNamedQuery("Paesi.init", Paesi.class);
        List<Paesi> resultList = queryinit.getResultList();
        return resultList;
    }

    @Transactional
    @Override
    public List<Paesi> findAll() {
        Query q = manager.createNamedQuery("Paesi.All", Paesi.class);
        return q.getResultList();
    }

    @Transactional
    @Override
    public boolean addPaese(Paesi paese){
        manager.persist(paese);
        return true ;
    }

    @Override
    @Transactional
    public void update(Paesi paese) {
        manager.merge(paese);
    }

    @Override
    @Transactional
    public Paesi findByCodice2(String codice2) {
        Query queryCodice2 = manager.createNamedQuery("Paesi.ByCode2",Paesi.class) ;
        queryCodice2.setParameter("codice2", codice2);
        if (!queryCodice2.getResultList().isEmpty()) {
            Paesi result = (Paesi) queryCodice2.getResultList().get(0);
            return manager.find(Paesi.class, result.getCodice2());
        }
        return null;
    }

    @Override
    @Transactional
    public Paesi findByCodice3(String codice3){
        Query queryCodice3 = manager.createNamedQuery("Paesi.ByCode3",Paesi.class) ;
        queryCodice3.setParameter("codice3", codice3);
        if (!queryCodice3.getResultList().isEmpty()) {
            Paesi result = (Paesi) queryCodice3.getResultList().get(0);
            return manager.find(Paesi.class, result.getCodice3());
        }
        return null;
    }

    @Override
    @Transactional
    public Paesi findByNome(String nome){
        Query query = manager.createNamedQuery("Paesi.ByNome",Paesi.class) ;
        query.setParameter("nome", nome);
        if (!query.getResultList().isEmpty()) {
            Paesi result = (Paesi) query.getResultList().get(0);
            return manager.find(Paesi.class, result.getNome());
        }
        return null;
    }
}
