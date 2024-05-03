package com.corso.service.impl;

import com.corso.bean.PaeseSpeciale;
import com.corso.bean.RicercaUtente;
import com.corso.dao.RicercheRecentiDAO;
import com.corso.dao.SigleSpecialiDAO;
import com.corso.service.RicercheRecentiService;
import com.corso.service.SigleSpecialiService;

public class RicercheRecentiServiceImpl implements RicercheRecentiService {

    RicercheRecentiDAO dao = null;

    @Override
    public void setDao(RicercheRecentiDAO ricercheRecentiDAO) {
        dao = ricercheRecentiDAO;
    }

    @Override
    public RicercaUtente addRicerca(RicercaUtente ricerca) {
        return dao.add(ricerca);
    }

    @Override
    public void updateRicerche(RicercaUtente ricerca) {
        dao.update(ricerca);
    }

    @Override
    public RicercaUtente findRicerca(String input) {
        return dao.find(input);
    }
}
