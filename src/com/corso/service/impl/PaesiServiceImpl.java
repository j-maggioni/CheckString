package com.corso.service.impl;


import com.corso.dao.PaesiDAO;
import com.corso.model.Paesi;
import com.corso.model.RankingAlgoritmi;
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
            Paesi paeseFind = dao.findByCodice2(paesi.getCodice2());
            if(paeseFind == null){
                dao.addPaese(paeseFind);
                return true;
            } else {
                if(paesi.getCodice2().equalsIgnoreCase(paeseFind.getCodice2())) {
                    paeseFind.setNome(paesi.getNome());
                    paeseFind.setCodice2(paesi.getCodice2());
                    paeseFind.setCodice3(paesi.getCodice3());
                    dao.update(paeseFind);
                    return true;
                }
            }

        }
        return false;
    }

}
