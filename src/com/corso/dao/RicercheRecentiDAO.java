package com.corso.dao;

import com.corso.bean.Bean;
import com.corso.bean.RicercaUtente;

public interface RicercheRecentiDAO{
    public RicercaUtente add(RicercaUtente ricerca);

    public void update(RicercaUtente ricerca);

    public RicercaUtente find(String input);
}
