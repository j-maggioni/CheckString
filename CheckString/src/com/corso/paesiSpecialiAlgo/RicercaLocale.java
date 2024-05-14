package com.corso.paesiSpecialiAlgo;

import com.corso.standard.LocaleParoleStandard;
import com.corso.standard.Standard;

import java.util.ArrayList;

public class RicercaLocale implements RichercaPaesiSpeciali {
	private final static ArrayList<Standard> StandardsFromLocaleJava = new LocaleParoleStandard().getParoleStandard() ;


	// Logica 1 : via classe Locale

	@Override
	public String cercaPaeseSpeciale(String paeseSpeciale) {
		String stringToReturn = "" ;
		for (Standard standard : StandardsFromLocaleJava) {
			if (standard.getCode().equals(paeseSpeciale)) {
			    stringToReturn = standard.getValue() ;
				System.out.println("Paese trovato : "+stringToReturn+ " via 'RicercaLocale' ");
				return stringToReturn ;
			}
		}
		   System.out.println("Paese non trovato via RicercaLocale ");
		   return stringToReturn ;

}
}
