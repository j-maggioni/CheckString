package com.corso.algoritmi;
 
import java.util.*;

import com.corso.config.Beans;
import com.corso.model.RicercheRecenti;
import com.corso.service.RankingAlgoritmiService;
import com.corso.service.RicercheRecentiService;
import com.corso.standard.Standard;
import com.corso.paesiSpeciali.ManagerRicerca;
import com.corso.standard.*;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public abstract class CheckString {

	private static List<Standard> standards = new ArrayList<Standard>();
    private CheckString next;

	private static BeanFactory factory;
	private static RicercheRecentiService serviceRicerche;
	static {
		factory = new AnnotationConfigApplicationContext(Beans.class);
		serviceRicerche = factory.getBean("ricercheRecentiService", RicercheRecentiService.class);
	}

    public Esito check(String input) throws Exception{
		System.out.println("Provo con l'algoritmo " + this.getName());
      	ArrayList<String> tokens = Tokenizer.tokenize(input);
      	
    	// RICERCA PAROLA NEL DB RICERCHE RECENTI
		RicercheRecenti ricerca = serviceRicerche.findRicerca(input);
		if (ricerca != null) {
            return new Esito (true, ricerca.getInput(), ricerca.getStandard(), ricerca.getAlgortimo());
        }

		// RICERCA DI SIGLE DI 2 o 3 CARATTERI
      	if (input.length() == 2 || input.length() == 3 ) {
      		ManagerRicerca manager = new ManagerRicerca();
      		String res1 = manager.getParola(input) ;
      		if (!(res1.isEmpty())) {
				return new Esito(true, input, res1,this.getName());
        	}
		}

		// CHECK CON ALGORITMI
    	for(Standard standard : standards) {
        	if (tokens.size() == 1) {
	        	if(check(input,standard.getValue())){
					return new Esito(true, input, standard.getValue(),this.getName());
	        	} 
        	} else if (tokens.size() > 1) {
        		String res = checkTokens(tokens);
        		if (!(res.isEmpty())) {
					return new Esito(true, input, res, this.getName());
        		}
        	}
        }
    	if (next != null){
    		return next.check(input);
    	} else {
    		return new Esito(false, input, "NESSUNA PAROLA TROVATA", "None");
    	}
    }

    private String checkTokens(ArrayList<String> tokens) {
		ArrayList<String> results = new ArrayList<String>();
        
    	for(String word : tokens){
			for(Standard standard : standards) {
				if(check(word,standard.getValue())){
	        		results.add(standard.getValue());
	            }
	        }
    	}
    	
    	// Crea una mappa per tenere traccia delle occorrenze delle stringhe
        HashMap<String, Integer> conteggioOccorrenze = new HashMap<>();
 
        // Conta le occorrenze di ciascuna stringa nell'array
        for (String elemento : results) {
			int occorrenzeAttuali = conteggioOccorrenze.getOrDefault(elemento, 0) + 1;
			conteggioOccorrenze.put(elemento, occorrenzeAttuali);         
		}         
        
        // Trova la parola con il maggior numero di occorrenzeString
        String parolaMaxOccorrenze = "";
 
        int maxOccorrenze = 0;
        for (Map.Entry<String, Integer> entry : conteggioOccorrenze.entrySet()) {
        	if (entry.getValue() > maxOccorrenze) {
        		maxOccorrenze = entry.getValue();
        		parolaMaxOccorrenze = entry.getKey();
        	}
        }       
 
        return parolaMaxOccorrenze;  
	}
    
	public void setNext(CheckString checkString){
		this.next = checkString;
    }
    
    // TEMPLATE
    protected abstract boolean check(String input, String standard);
 
    protected String getName() {
    	return this.getClass().getSimpleName();
    }
    
    public static void setParoleStandard(ParoleStandard s) {
    	standards = s.getStandards();
    }
}