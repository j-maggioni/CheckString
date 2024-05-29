package com.corso.dao.impl;

import com.corso.dao.PaesiDAO;
import com.corso.model.Paesi;
import com.corso.standard.Standard;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

public class PaesiDAOimpl extends BaseDAOimpl implements PaesiDAO {

    @PersistenceContext
    EntityManager manager;

    @Transactional
    @Override
    public List<Paesi> initPaesi() {
        Query queryinit = manager.createNamedQuery("Paesi.init", Paesi.class);
        List<Paesi> resultList = queryinit.getResultList();

        for (Paesi paese : resultList) {
            Optional<Locale> countryLocale = Arrays.stream(Locale.getAvailableLocales())
                .filter(locale -> locale.getCountry().equalsIgnoreCase(paese.getCodice2()))
                .findFirst();

            countryLocale.ifPresentOrElse(
                locale -> paese.setNomeITA(locale.getDisplayCountry(Locale.ITALIAN)),
                () -> paese.setNomeITA(paese.getNomeENG())
            );
        }

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
        return true;
    }

    @Override
    @Transactional
    public void update(Paesi paese) {
        manager.merge(paese);
    }

    @Override
    @Transactional
    public Paesi findByCodice2(String codice2) {
        Query queryCodice2 = manager.createNamedQuery("Paesi.ByCode2",Paesi.class);
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
    public Paesi findByNome(String nomeITA){
        Query query = manager.createNamedQuery("Paesi.ByNome",Paesi.class) ;
        query.setParameter("nome", nomeITA);
        if (!query.getResultList().isEmpty()) {
            Paesi result = (Paesi) query.getResultList().get(0);
            return manager.find(Paesi.class, result.getNomeITA());
        }
        return null;
    }
}
