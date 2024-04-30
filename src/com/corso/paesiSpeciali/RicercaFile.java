package com.corso.paesiSpeciali;

import java.util.ArrayList;

import com.corso.standard.FileParoleStandard;
import com.corso.standard.Standard;

public class RicercaFile implements RichercaPaesiSpeciali {
		private final static ArrayList<Standard> StandardsFromFile = (ArrayList<Standard>) new FileParoleStandard().getStandards() ;
		// Logica 2 : via classe File

		@Override
		public String cercaPaeseSpeciale(String paeseSpeciale) {
			String stringToReturn = "" ;
			for (Standard standard : StandardsFromFile) {
				if (standard.getCode().equals(paeseSpeciale)) {
				    stringToReturn = standard.getValue() ;
					System.out.println("Paese trovato : "+stringToReturn+ " via 'RicercaFile' ");
					return stringToReturn ;
				}
			}
			   System.out.println("Paese non trovato via RicercaFile");
			   return stringToReturn ;
		}
	}



