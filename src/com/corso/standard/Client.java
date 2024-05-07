package com.corso.standard;
 
import com.corso.algoritmi.*;
import com.corso.algoritmi.Esito;
import com.corso.config.Beans;
import com.corso.dao.RankingAlgoritmiDAO;
import com.corso.model.RankingAlgoritmi;
import com.corso.model.RicercheRecenti;
import com.corso.service.RankingAlgoritmiService;
import com.corso.service.RicercheRecentiService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Client {

	private static BeanFactory factory;
	private static RicercheRecentiService serviceRicerche;
	private static RankingAlgoritmiService serviceRanking;
	private static RankingAlgoritmiDAO daoRicerche;

	static{
		factory = new AnnotationConfigApplicationContext(Beans.class);
		serviceRicerche = factory.getBean("ricercheRecentiService", RicercheRecentiService.class);
		serviceRanking = factory.getBean("rankingAlgoritmiService", RankingAlgoritmiService.class);
		daoRicerche = factory.getBean("rankingAlgoritmiDAO", RankingAlgoritmiDAO.class);
	}

	public Client () {
    	boolean setRanking = true;
        try {

			if(setRanking) {
    			Ranking.algorithmRanking();
    		}

    		CheckString algoritmo = Ranking.getFirstAlgorithm();
			System.out.print("\nInput: ");
			Scanner in = new Scanner(System.in);
			String response = in.nextLine();
    		Esito esito = algoritmo.check(response);
			saveEsito(esito);

    	} catch (Exception e) {
    	  e.printStackTrace();
    	}
    	
    }

	private void saveEsito(Esito esito){
		RicercheRecenti nuovaRicerca = new RicercheRecenti(esito.getParolaInput(), esito.getParolaStandard(),
				daoRicerche.find(esito.getAlgoritmo()));
		if (approvazioneUtente(esito)){
			nuovaRicerca.setApprovazione(true);
			serviceRicerche.addRicerca(nuovaRicerca);
			serviceRanking.updateOccorrenzeAlgoritmo(nuovaRicerca.getAlgortimo().getNome());
		} else {
			System.out.print("Inserisci la parola corrispondente all'input fornito \""+esito.getParolaInput()+"\": ");
			Scanner in = new Scanner(System.in);
			String response = in.nextLine();
			nuovaRicerca.setStandard(response);
			nuovaRicerca.setAlgortimo(daoRicerche.find("Manual CheckString"));
			serviceRicerche.addRicerca(nuovaRicerca);
		}
	}

	private boolean approvazioneUtente(Esito esito){
		System.out.println("\nInput: "+esito.getParolaInput()+"\tParola trovata: "+esito.getParolaStandard());
		System.out.print("\nLa parola trovata corrisponde all'input inserito? Y/N ");
		Scanner in = new Scanner(System.in);
		char response = in.next().charAt(0);

		switch (response){
			case 'Y':
            case 'y':
                return true;
            default: // case 'N' o 'n'
				return false;
		}

	}



}