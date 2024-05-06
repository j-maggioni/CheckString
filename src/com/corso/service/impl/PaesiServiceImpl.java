package com.corso.service.impl;


import com.corso.dao.PaesiDAO;
import com.corso.model.Paesi;
import com.corso.service.PaesiService;

import java.util.List;

public class PaesiServiceImpl implements PaesiService {

    PaesiDAO dao = null;

    @Override
    public void setDao(PaesiDAO paesiDAO) {
        dao = paesiDAO;
    }

    @Override
    public Paesi findPaese(Integer id) {
        return  dao.find(id);
    }

    @Override
    public List<Paesi> getPaesi() {
        return dao.all();
    }
}
