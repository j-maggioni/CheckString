package com.corso.algoritmi.impl;

import com.corso.algoritmi.CheckString;
import com.corso.algoritmi.Esito;
import com.corso.config.Beans;
import com.corso.model.RicercheRecenti;
import com.corso.model.SigleSpeciali;
import com.corso.service.RicercheRecentiService;
import com.corso.service.SigleSpecialiService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class SigleSpecialiDB extends CheckString {

    private static BeanFactory factory;
    private static SigleSpecialiService serviceSigleSpeciali;

    static {
        factory = new AnnotationConfigApplicationContext(Beans.class);
        serviceSigleSpeciali = factory.getBean("sigleSpecialiService", SigleSpecialiService.class);
    }

    @Override
    public Esito checkInput(String input) {
        System.out.println("Provo con l'algoritmo " + this.getName());
        SigleSpeciali ricerca = serviceSigleSpeciali.findBySigla(input);
        if (ricerca != null) {
            return new Esito(true, ricerca.getSigla(), ricerca.getPaese(),
                    this.getName());
        }
        if (super.getNext() != null) {
            return super.getNext().checkInput(input);
        } else {
            return new Esito(false, input, "NESSUNA PAROLA TROVATA", "None");
        }
    }
}
