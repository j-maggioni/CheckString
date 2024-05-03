package com.corso.service;

import com.corso.bean.PaeseSpeciale;
import com.corso.bean.RicercaUtente;
import com.corso.dao.RicercheRecentiDAO;
import com.corso.dao.SigleSpecialiDAO;

public interface RicercheRecentiService {

    public void setDao(RicercheRecentiDAO ricercheRecentiDAO);

    public RicercaUtente addRicerca(RicercaUtente ricerca);
    public void updateRicerche(RicercaUtente ricerca);
    public RicercaUtente findRicerca(String input);

}
