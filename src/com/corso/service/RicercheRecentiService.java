package com.corso.service;

import com.corso.dao.RicercheRecentiDAO;
import com.corso.dao.SigleSpecialiDAO;
import com.corso.model.RicercheRecenti;

public interface RicercheRecentiService {

    void setDao(RicercheRecentiDAO ricercheRecentiDAO);
    void addRicerca(RicercheRecenti ricerca);
    void updateRicerche(RicercheRecenti ricerca);
    RicercheRecenti findRicerca(String id);

}
