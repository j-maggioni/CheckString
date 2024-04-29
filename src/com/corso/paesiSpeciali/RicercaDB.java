package com.corso.paesiSpeciali;

import java.util.ArrayList;

import com.corso.standard.*;

public class RicercaDB implements RichercaPaesiSpeciali {
	private final static ArrayList<Standard> StandardsFromDB = (ArrayList<Standard>) new FileParoleStandard().getStandards() ;

	// Logica 2 : via classe DBParole
	@Override
	public String cercaPaeseSpeciale(String paeseSpeciale) {
		String stringToReturn = "" ;
		for (Standard standard : StandardsFromDB) {
			if (standard.getCode().equals(paeseSpeciale)) {
			    stringToReturn = standard.getValue() ;
				System.out.println("Paese trovato : "+stringToReturn+ " via 'RicercaDB' ");
				return stringToReturn ;
			}
		}
		   System.out.println("Paese non trovato via RicercaDB");
		   return stringToReturn ;
	}

}
