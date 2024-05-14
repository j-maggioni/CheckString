package com.corso.service.impl;

import com.corso.dao.RicercheRecentiDAO;
import com.corso.model.RicercheRecenti;
import com.corso.service.RicercheRecentiService;

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
            if(!ricerca.getStandard().getNome().equalsIgnoreCase(existingRicerca.getStandard().getNome())) {
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
