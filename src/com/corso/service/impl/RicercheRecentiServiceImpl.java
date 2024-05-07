package com.corso.service.impl;

import com.corso.algoritmi.Esito;
import com.corso.dao.RicercheRecentiDAO;
import com.corso.dao.SigleSpecialiDAO;
import com.corso.model.RicercheRecenti;
import com.corso.service.RicercheRecentiService;
import com.corso.service.SigleSpecialiService;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RicercheRecentiServiceImpl implements RicercheRecentiService {

    RicercheRecentiDAO dao = null;

    @Override
    public void setDao(RicercheRecentiDAO ricercheRecentiDAO) {
        this.dao = ricercheRecentiDAO;
    }

    @Override
    public void addRicerca(RicercheRecenti ricerca) {
        RicercheRecenti existingRicerca = dao.find(ricerca.getInput());

        if (existingRicerca == null) { // Se non c'è un record con lo stesso input, aggiungi la nuova riga
            dao.add(ricerca);
        } else {
            if(!ricerca.getStandard().equalsIgnoreCase(existingRicerca.getStandard())) {
                existingRicerca.setStandard(ricerca.getStandard());
                dao.update(existingRicerca);
            }
        }
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
