package com.corso.standard;

import com.corso.algoritmi.CheckString;
import com.corso.algoritmi.Esito;
import com.corso.algoritmi.Ranking;
import com.corso.config.Beans;
import com.corso.model.Paesi;
import com.corso.model.RankingAlgoritmi;
import com.corso.model.RicercheRecenti;
import com.corso.model.SigleSpeciali;
import com.corso.service.PaesiService;
import com.corso.service.RankingAlgoritmiService;
import com.corso.service.RicercheRecentiService;
import com.corso.service.SigleSpecialiService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Client {

	private static BeanFactory factory;
	private static RicercheRecentiService serviceRicerche;
	private static RankingAlgoritmiService serviceRanking;
	private static PaesiService servicePaesi;
	private static SigleSpecialiService serviceSigleSpeciali;

	static{
		factory = new AnnotationConfigApplicationContext(Beans.class);
		serviceRicerche = factory.getBean("ricercheRecentiService", RicercheRecentiService.class);
		serviceRanking = factory.getBean("rankingAlgoritmiService", RankingAlgoritmiService.class);
		servicePaesi = factory.getBean("paesiService", PaesiService.class);
		serviceSigleSpeciali = factory.getBean("sigleSpecialiService", SigleSpecialiService.class);
		servicePaesi.addPaese();
    }

	public Client () {
		Scanner in;
		if(serviceRanking.getAlgoritmi().isEmpty()){
			Ranking.setRanking(true);
		} else {
			System.out.print("\nAddestrare gli algoritmi? Y/N ");
			in = new Scanner(System.in);
			switch (in.next().charAt(0)) {
				case 'Y':
				case 'y':
					Ranking.setRanking(true);
					break;
				default: // case 'N' o 'n'
					Ranking.setRanking(false);
					break;
			}
		}
		try {
			if (Ranking.isRanking()) {
				Ranking.algorithmRanking();
			}
			CheckString algoritmo = Ranking.getFirstAlgorithm();
			System.out.print("\nInput: ");
			in = new Scanner(System.in);
			String response = in.nextLine();
			if (!response.isEmpty()) {
				Esito esito = algoritmo.check(response);
				saveEsito(esito);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

    	
    }

	private void saveEsito(Esito esito) {
		RicercheRecenti nuovaRicerca = new RicercheRecenti(esito.getParolaInput(),
				servicePaesi.findBySigla(esito.getParolaStandard()),
				serviceRanking.findAlgoritmo(esito.getAlgoritmo()));
		if (approvazioneUtente(esito)) {
			nuovaRicerca.setApprovazione(true);
			serviceRicerche.addRicerca(nuovaRicerca);
			serviceRanking.updateOccorrenzeAlgoritmo(nuovaRicerca.getAlgortimo().getNome());
		} else {
			System.out.print("Inserisci la parola corrispondente all'input fornito \"" + esito.getParolaInput() + "\": ");
			Scanner in = new Scanner(System.in);
			String response = in.nextLine();
			if (servicePaesi.findBySigla(response) != null) {
				nuovaRicerca.setStandard(servicePaesi.findBySigla(response));
				nuovaRicerca.setAlgortimo(serviceRanking.findAlgoritmo("InserimentoManuale"));
				serviceRicerche.addRicerca(nuovaRicerca);

			} else {
				SigleSpeciali sigla = new SigleSpeciali(esito.getParolaInput(), response);
				serviceSigleSpeciali.addPaeseSpeciale(sigla);
			}
			serviceRanking.updateOccorrenzeAlgoritmo("InserimentoManuale");
		}
	}

	private boolean approvazioneUtente(Esito esito){
		System.out.println("\nInput: " + esito.getParolaInput() + "\tParola trovata: " +
				servicePaesi.findBySigla(esito.getParolaStandard()).getNome());
		System.out.print("\nLa parola trovata corrisponde all'input inserito? Y/N ");
		Scanner in = new Scanner(System.in);
		char response = in.next().charAt(0);

		switch (response) {
			case 'Y':
			case 'y':
				return true;
			default: // case 'N' o 'n'
				return false;
		}
	}

}