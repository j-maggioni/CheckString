package com.corso.dao.impl;

import com.corso.bean.PaeseSpeciale;
import com.corso.bean.RicercaUtente;
import com.corso.dao.SigleSpecialiDAO;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class SigleSpecialiDAOimpl extends BaseDAOimpl implements SigleSpecialiDAO {
    @PersistenceContext
    private EntityManager manager;

    @Transactional
    @Override
    public PaeseSpeciale add(PaeseSpeciale paese) {
        manager.persist(paese);
        return paese;
    }

    @Override
    @Transactional
    public PaeseSpeciale find(Integer id) {
        PaeseSpeciale paeseSpeciale =  manager.find(PaeseSpeciale.class,id);
        //	manager.lock(categoria, LockModeType.OPTIMISTIC );
        return paeseSpeciale;
    }
}
