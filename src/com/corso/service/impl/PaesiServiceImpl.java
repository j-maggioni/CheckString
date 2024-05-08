package com.corso.service.impl;


import com.corso.dao.PaesiDAO;
import com.corso.model.Paesi;
import com.corso.service.PaesiService;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

public class PaesiServiceImpl implements PaesiService {

    PaesiDAO dao ;

    @Override
    public void setDao(PaesiDAO paesiDAO) {
        dao = paesiDAO;
    }

    @Transactional
    @Override
    public List<Paesi> findAll() {
        return dao.findAll() ;
    }
    @Transactional
    @Override
    public Paesi findBySigla(String codice)  throws SQLException{
        int lunghezza = codice.length() ;
        Paesi p = null ;
        switch (lunghezza) {
            case 2 :
                p = dao.findByCodice2(codice) ;
                break;
            case 3 :
                p = dao.findByCodice3(codice) ;
                break;
        }
        return p;
    }

    @Override
    public boolean addPaese() throws SQLException {
        List<Paesi> p = dao.initPaesi();
        for (Paesi paesi : p) {
            dao.addPaese(paesi);
        }
        return false;
    }

}
