package com.corso.service.impl;


import com.corso.dao.PaesiDAO;
import com.corso.model.Paesi;
import com.corso.service.PaesiService;
import org.springframework.transaction.annotation.Transactional;

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
    public Paesi findBySigla(String codice){
        switch (codice.length()) {
            case 2 :
                return dao.findByCodice2(codice);
            case 3 :
                return dao.findByCodice3(codice);
        }
        return null;
    }

    @Transactional
    @Override
    public Paesi findByNome(String nome){
        return dao.findByNome(nome);
    }

    @Override
    public void addPaese(){
        List<Paesi> paesi = dao.initPaesi();

        for (Paesi paese : paesi) {
            try {
                dao.addPaese(paese);
            } catch (Exception e){
                System.out.println("Paese già esistente");
                e.printStackTrace();
            }
        }
    }

}
