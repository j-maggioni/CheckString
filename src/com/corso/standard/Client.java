package com.corso.standard;
 
import com.corso.algoritmi.*;
import com.corso.algoritmi.Esito;
import com.corso.config.Beans;
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

	static{
		ParoleStandard s = new FileParoleStandard();
		//ParoleStandard s = new DBParoleStandard();
		//ParoleStandard s = new LocaleParoleStandard();
		CheckString.setParoleStandard(s);

		factory = new AnnotationConfigApplicationContext(Beans.class);
		serviceRicerche = factory.getBean("ricercheRecentiService", RicercheRecentiService.class);
		serviceRanking = factory.getBean("rankingAlgoritmiService", RankingAlgoritmiService.class);
	}

	public Client () {
    	boolean setRanking = false;
        try {

			if(setRanking) {
    			Ranking.algorithmRanking();
    		}

    		CheckString algoritmo = Ranking.getFirstAlgorithm();
    		Esito esito = algoritmo.check("Ciaoxyzxyzxyz");
			saveEsito(esito);
    		
//    		Esito esito1 = algoritmo.check("italia");
//			saveEsito(esito1);
//
//    		Esito esito2 = algoritmo.check("german");
//			saveEsito(esito2);
    	} catch (Exception e) {
    	  e.printStackTrace();
    	}
    	
    }

	private void saveEsito(Esito esito){
		RicercheRecenti nuovaRicerca = new RicercheRecenti(esito.getParolaInput(), esito.getParolaStandard(),
				esito.getAlgoritmo());
		if (approvazioneUtente(esito)){
			nuovaRicerca.setApprovazione(true);
			serviceRicerche.addRicerca(nuovaRicerca);
			serviceRanking.updateOccorrenzeAlgoritmo(nuovaRicerca.getAlgortimo());
		} else {
			System.out.print("Inserisci la parola corrispondente all'input fornito \""+esito.getParolaInput()+"\": ");
			Scanner in = new Scanner(System.in);
			String response = in.nextLine();
			nuovaRicerca.setStandard(response);
			nuovaRicerca.setAlgortimo("Manual Checkstring");
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