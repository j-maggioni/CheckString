package com.corso.dao.impl;

import com.corso.dao.RicercheRecentiDAO;
import com.corso.model.RicercheRecenti;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class RicercheRecentiDAOimpl extends BaseDAOimpl implements RicercheRecentiDAO {

    @PersistenceContext
    EntityManager manager;

    @Transactional
    @Override
    public void add(RicercheRecenti ricerca) {
        // Controlla se l'input è già presente nella tabella
        RicercheRecenti existingRicerca = find(ricerca.getInput());

        if (existingRicerca == null) { // Se non c'è un record con lo stesso input, aggiungi la nuova riga
            RicercheRecenti nuovaRicerca = new RicercheRecenti();
            nuovaRicerca.setInput(ricerca.getInput());
            nuovaRicerca.setStandard(ricerca.getStandard());
            nuovaRicerca.setAlgortimo(ricerca.getAlgortimo());
            nuovaRicerca.setApprovazione(ricerca.getApprovazione());
            Date currentDate = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            String formattedDate = dateFormat.format(currentDate);
            nuovaRicerca.setDataInserimento(formattedDate);
            manager.persist(nuovaRicerca);
            manager.flush();
        } else {
            System.out.println("Input già presente nella tabella, non è necessario inserirlo di nuovo.");
        }
    }



    //per approvazione MI MANCA QUESTO
    @Override
    @Transactional
    public void update(RicercheRecenti ricerca) {
        manager.merge(ricerca);
    }

    @Override
    @Transactional
    public RicercheRecenti find(String input) {
        Query query = manager.createNamedQuery("RicercheRecenti.findInput");
        query.setParameter("input", input);
        RicercheRecenti result = null;
        try {
            result = (RicercheRecenti) query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("Eccezione: " + e);
        }
        return result;
    }

}
