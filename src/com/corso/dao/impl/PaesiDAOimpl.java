package com.corso.dao.impl;

import com.corso.dao.PaesiDAO;
import com.corso.model.Paesi;
import com.corso.model.RankingAlgoritmi;
import com.corso.model.RicercheRecenti;
import com.corso.model.SigleSpeciali;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.SQLException;
import java.util.List;

public class PaesiDAOimpl extends BaseDAOimpl implements PaesiDAO {

    @PersistenceContext
    EntityManager manager;

//    public EntityManager getManager() {
//        return manager;
//    }


    @Transactional
    @Override
    public List<Paesi> initPaesi() throws SQLException {
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
    public boolean addPaese(Paesi paese) throws SQLException {
        manager.persist(paese);
        return true ;
    }

//    @Transactional
//    public Paesi findById(int id) throws SQLException {
//        Query query  = manager.createNamedQuery("Paesi.ById" , SigleSpeciali.class) ;
//        query.setParameter("id", id);
//        return (Paesi) query.getSingleResult();
//    }

    @Override
    @Transactional
    public void update(Paesi paese) {
        manager.merge(paese);
    }

    @Override
    @Transactional
    public Paesi findByCodice2(String codice2) throws SQLException {
        Query queryCodivce2 = manager.createNamedQuery("Paesi.ByCode2",Paesi.class) ;
        queryCodivce2.setParameter("codice2", codice2);
        if (!queryCodivce2.getResultList().isEmpty()) {
            Paesi result = (Paesi) queryCodivce2.getResultList().get(0);
            return manager.find(Paesi.class, result.getCodice2());
        }
        return null  ; // primo elemento
    }

    @Override
    @Transactional
    public Paesi findByCodice3(String Codice3) throws SQLException {
        Query queryCodivce3 = manager.createNamedQuery("Paesi.ByCode3",Paesi.class) ;
        queryCodivce3.setParameter("codice3", Codice3);
        return (Paesi) queryCodivce3.getSingleResult() ;
    }
}
