package com.corso.dao.impl;

import com.corso.dao.SigleSpecialiDAO;
import com.corso.model.SigleSpeciali;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class SigleSpecialiDAOimpl extends BaseDAOimpl implements SigleSpecialiDAO {
    @PersistenceContext
    private EntityManager manager;

    @Transactional
    @Override
    public SigleSpeciali add(SigleSpeciali paese) {
        manager.persist(paese);
        return paese;
    }

    @Override
    @Transactional
    public SigleSpeciali find(Integer id) {
        SigleSpeciali paeseSpeciale =  manager.find(SigleSpeciali.class,id);
        //	manager.lock(categoria, LockModeType.OPTIMISTIC );
        return paeseSpeciale;
    }
}
