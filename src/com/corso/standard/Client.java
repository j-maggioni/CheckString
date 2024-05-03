package com.corso.standard;
 
import com.corso.algoritmi.*;
import com.corso.algoritmi.Esito;
 
public class Client {
    
	public Client () {
    	boolean setRanking = false;
        try {
        	ParoleStandard s = new FileParoleStandard();
        	//ParoleStandard s = new DBParoleStandard();
        	//ParoleStandard s = new LocaleParoleStandard();
        	CheckString.setParoleStandard(s);
    		
        	if(setRanking) {
    			AlgorithmRanking.algorithmRanking();
    		}
    		
    		CheckString algoritmo = AlgorithmRanking.getFirstAlgorithm();
    		Esito esito = algoritmo.check("Isole b");
    		RicercaRapida.addInDB(esito.getParolaInput(), esito.getParolaStandard(), esito.getAlgoritmo());
    		System.out.println(esito);
    		
    		Esito esito1 = algoritmo.check("italia");
    		RicercaRapida.addInDB(esito1.getParolaInput(), esito1.getParolaStandard(), esito1.getAlgoritmo());
    		
    		System.out.println(esito1);
    		
    		Esito esito2 = algoritmo.check("german");
    		RicercaRapida.addInDB(esito2.getParolaInput(), esito2.getParolaStandard(), esito2.getAlgoritmo());
    		
    		System.out.println(esito2);
    	} catch (Exception e) {
    	  e.printStackTrace();
    	}
    	
    }

}