package com.corso.algoritmi;

import com.corso.standard.FileParoleStandard;
import com.corso.standard.ParoleStandard;
import com.corso.standard.Standard;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class CheckStringImpl extends CheckString {

	private static List<Standard> standards = new ArrayList<Standard>();

	static {
		ParoleStandard s = new FileParoleStandard();
		//ParoleStandard s = new DBParoleStandard();
		//ParoleStandard s = new LocaleParoleStandard();
        standards = s.getStandards();
	}

	public Esito checkInput(String input){
		ArrayList<String> tokens = Tokenizer.tokenize(input);
		if(!Ranking.isRanking()) {
			System.out.println("Provo con l'algoritmo " + this.getName());
		}

			// RICERCA DI SIGLE DI 2 o 3 CARATTERI
//      	if (input.length() == 2 || input.length() == 3 ) {
//      		RichercaPaesiSpeciali manager = new RicercaPaesiSpeciali();
//      		String res1 = manager.getParola(input) ;
//      		if (!(res1.isEmpty())) {
//				return new Esito(true, input, res1,this.getName());
//        	}
//		}

		// CHECK CON ALGORITMI
    	for(Standard standard : standards) {
        	if (tokens.size() == 1) {
	        	if(check(input,standard.getValue())){
					return new Esito(true, input, standard.getCode(), this.getName());
	        	}
        	} else if (tokens.size() > 1) {
        		String codiceStandard = checkTokens(tokens);
        		if (!(codiceStandard.isEmpty())) {
					return new Esito(true, input, codiceStandard, this.getName());
        		}
        	}
        }
    	if (super.getNext() != null){
    		return super.getNext().checkInput(input);
    	} else {
    		return new Esito(false, input, "NESSUNA PAROLA TROVATA", "None");
    	}
    }

    private String checkTokens(ArrayList<String> tokens) {
		ArrayList<String> results = new ArrayList<String>();

    	for(String word : tokens){
			for(Standard standard : standards) {
				if(check(word,standard.getValue())){
	        		results.add(standard.getCode());
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
        String codiceMaxOccorrenze = "";

        int maxOccorrenze = 0;
        for (Map.Entry<String, Integer> entry : conteggioOccorrenze.entrySet()) {
        	if (entry.getValue() > maxOccorrenze) {
        		maxOccorrenze = entry.getValue();
        		codiceMaxOccorrenze = entry.getKey();
        	}
        }

        return codiceMaxOccorrenze;
	}
    
    // TEMPLATE
    protected abstract boolean check(String input, String standard);

}