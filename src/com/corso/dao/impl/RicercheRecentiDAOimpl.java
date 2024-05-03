package com.corso.dao.impl;

import com.corso.bean.RicercaUtente;
import com.corso.dao.RicercheRecentiDAO;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class RicercheRecentiDAOimpl extends BaseDAOimpl implements RicercheRecentiDAO {

    @Transactional
    @Override
    public RicercaUtente add(RicercaUtente ricerca) {
        manager.persist(ricerca);
        return ricerca;
    }

    @Override
    @Transactional
    public void update(RicercaUtente ricerca) {
        manager.merge(ricerca);
    }

    @Override
    @Transactional
    public RicercaUtente find(String input) {
        int pk = 0; //risultato della query ricerca input
        RicercaUtente ricercaUtente =  manager.find(RicercaUtente.class,pk);
        //	manager.lock(categoria, LockModeType.OPTIMISTIC );
        return ricercaUtente;
    }
}
