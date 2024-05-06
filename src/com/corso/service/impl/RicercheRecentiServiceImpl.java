package com.corso.service.impl;

import com.corso.dao.RicercheRecentiDAO;
import com.corso.dao.SigleSpecialiDAO;
import com.corso.model.RicercheRecenti;
import com.corso.service.RicercheRecentiService;
import com.corso.service.SigleSpecialiService;

public class RicercheRecentiServiceImpl implements RicercheRecentiService {

    RicercheRecentiDAO dao = null;

    @Override
    public void setDao(RicercheRecentiDAO ricercheRecentiDAO) {
        this.dao = ricercheRecentiDAO;
    }

    @Override
    public void addRicerca(RicercheRecenti ricerca) {
        dao.add(ricerca);
    }

    @Override
    public void updateRicerche(RicercheRecenti ricerca) {
        this.dao.update(ricerca);
    }

    @Override
    public RicercheRecenti findRicerca(String id) {
        return this.dao.find(id);
    }
}
