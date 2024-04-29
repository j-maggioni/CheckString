package com.corso.algoritmi;
 
import com.corso.standard.*;
 
public class Main {
    
	public static void main(String[] args) {
    	boolean setRanking = true;
        try {
        	ParoleStandard s = new FileParoleStandard();
        	//ParoleStandard s = new DBParoleStandard();
        	//ParoleStandard s = new LocaleParoleStandard();
        	CheckString.setParoleStandard(s);
    		
        	if(setRanking) {
    			AlgorithmRanking.algorithmRanking();
    		}
    		
    		CheckString algoritmo = AlgorithmRanking.getFirstAlgorithm();
    		Esito esito = algoritmo.check("Isole vergini della britannica");
    		System.out.println(esito);
    		
    		Esito esito1 = algoritmo.check("Aruba");
    		System.out.println(esito1);
    		
    		Esito esito2 = algoritmo.check("Banana");
    		System.out.println(esito2);
    	} catch (Exception e) {
    	  e.printStackTrace();
    	}
    	
    }
 
}