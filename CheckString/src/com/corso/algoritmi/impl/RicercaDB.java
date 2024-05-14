package com.corso.algoritmi.impl;

import com.corso.algoritmi.CheckString;
import com.corso.algoritmi.CheckStringImpl;
import com.corso.algoritmi.Esito;
import com.corso.algoritmi.Ranking;
import com.corso.config.Beans;
import com.corso.model.RicercheRecenti;
import com.corso.service.RicercheRecentiService;
import com.corso.service.SigleSpecialiService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class RicercaDB extends CheckString {

    private static BeanFactory factory;
    private static RicercheRecentiService serviceRicerche;

    static {
        factory = new AnnotationConfigApplicationContext(Beans.class);
        serviceRicerche = factory.getBean("ricercheRecentiService", RicercheRecentiService.class);
    }

    @Override
    public Esito checkInput(String input) {
        System.out.println("Provo con l'algoritmo " + this.getName());
        RicercheRecenti ricerca = serviceRicerche.findRicerca(input);
        if (ricerca != null) {
            return new Esito(true, ricerca.getInput(), ricerca.getStandard().getCodice2(),
                    this.getName());
        }
        if (super.getNext() != null){
            return super.getNext().checkInput(input);
        } else {
            return new Esito(false, input, "NESSUNA PAROLA TROVATA", "None");
        }
    }
}
