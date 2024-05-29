package com.corso.standard;

import com.corso.algoritmi.CheckString;
import com.corso.algoritmi.Esito;
import com.corso.algoritmi.Ranking;
import com.corso.config.Beans;
import com.corso.model.RicercheRecenti;
import com.corso.model.SigleSpeciali;
import com.corso.service.PaesiService;
import com.corso.service.RankingAlgoritmiService;
import com.corso.service.RicercheRecentiService;
import com.corso.service.SigleSpecialiService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class ClientCheckstring {

	private static BeanFactory factory;
	private static RicercheRecentiService serviceRicerche;
	private static RankingAlgoritmiService serviceRanking;
	private static PaesiService servicePaesi;

	static {
		factory = new AnnotationConfigApplicationContext(Beans.class);
		serviceRicerche = factory.getBean("ricercheRecentiService", RicercheRecentiService.class);
		serviceRanking = factory.getBean("rankingAlgoritmiService", RankingAlgoritmiService.class);
		servicePaesi = factory.getBean("paesiService", PaesiService.class);
		servicePaesi.addPaese();
    }

	public static String clientCheckstring(String input) {
		if(serviceRanking.getAlgoritmi().isEmpty()){
			Ranking.setRanking(true);
		}
		try {
			if (Ranking.isRanking()) {
				Ranking.algorithmRanking();
			}
			CheckString algoritmo = Ranking.getFirstAlgorithm();
			System.out.println("\nInput: "+input);

			if (!input.isEmpty()) {
				Esito esito = algoritmo.check(input);
				return saveEsito(esito);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static String saveEsito(Esito esito) {
		RicercheRecenti nuovaRicerca = new RicercheRecenti(esito.getParolaInput(),
				servicePaesi.findBySigla(esito.getParolaStandard()),
				serviceRanking.findAlgoritmo(esito.getAlgoritmo()));
		System.out.println("\nInput: " + esito.getParolaInput() + "\tParola trovata: " +
				servicePaesi.findBySigla(esito.getParolaStandard()).getNomeITA() +
				"\tAlgoritmo: "+nuovaRicerca.getAlgortimo().getNome());

		nuovaRicerca.setApprovazione(true);
		serviceRicerche.addRicerca(nuovaRicerca);
		serviceRanking.updateOccorrenzeAlgoritmo(nuovaRicerca.getAlgortimo().getNome());

		return servicePaesi.findBySigla(esito.getParolaStandard()).getNomeITA();
	}
}