package com.corso.algoritmi;
 
import java.util.*;
import com.corso.standard.*;
 
public abstract class CheckString {


    private static List<Standard> standards = new ArrayList<Standard>();
    private CheckString next;

    public Esito check(String input){
    	System.out.println("Provo con l'algoritmo " + this.getName());
      	ArrayList<String> tokens = Tokenizer.tokenize(input);
    	//AGGIUNTO METODO PER CERCARE PAROLA NEL DB RICERCHE RECENTI
    	Client c = new Client();
    	String output = c.isWordInDatabase(input);
    	if (output!=null) {
            System.out.println("Parola " + input + " trovata nel database ed è associata a " + output);
            return true;
        }
    	for(Standard standard : standards){
        	if(check(input,standard.getValue())){
                return new Esito(true, input, standard.getValue(),this.getName());
            }
        }
        if (next != null){
            return next.check(input);
        } else {
        	return new Esito(false, input, "", this.getName());
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