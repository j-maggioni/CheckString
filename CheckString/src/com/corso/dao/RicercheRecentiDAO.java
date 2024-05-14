package com.corso.dao;

import com.corso.model.RicercheRecenti;
import org.springframework.transaction.annotation.Transactional;

public interface RicercheRecentiDAO{

    @Transactional
    void add(RicercheRecenti ricerca);


    @Transactional
    void update(RicercheRecenti ricerca);

    @Transactional
    RicercheRecenti find(String input);
}
