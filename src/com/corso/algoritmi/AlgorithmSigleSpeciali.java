package com.corso.algoritmi;

import com.corso.paesiSpecialiAlgo.RicercaFile;
import com.corso.paesiSpecialiAlgo.RicercaLocale;
//import com.corso.paesiSpecialiAlgo.RicercaQuery;
import com.corso.paesiSpecialiAlgo.RichercaPaesiSpeciali;

import java.util.ArrayList;

public class AlgorithmSigleSpeciali {
	public ArrayList<RichercaPaesiSpeciali> algoritmi ;
	
	public String getParola(String paeseSpeciale) {
		System.out.println("---ricerca in corso in metodo get .....");
	  String stringToReturn = ""  ;
	  for (RichercaPaesiSpeciali algo : algoritmi) {
		 String risultatoAlgoritmo = algo.cercaPaeseSpeciale(paeseSpeciale) ;
		 if (!("".equals(risultatoAlgoritmo)) // && !risultatoAlgoritmo.equals(null) &&
				 ) {
		  System.out.println("---Paese Speciale che corrisponde a " +paeseSpeciale+ " --> " +risultatoAlgoritmo + "get parola ManagerRicerca");
		  return risultatoAlgoritmo ;
	     }
	} // for
	System.out.println("-----Paese Speciale non trovato");
      return stringToReturn ;
	}
	
	// Costr
	public AlgorithmSigleSpeciali() {
		setAlgoritmi();
	}
	// setter
	private void setAlgoritmi() {
		ArrayList<RichercaPaesiSpeciali> x = new ArrayList<RichercaPaesiSpeciali>();
		x.add(new RicercaLocale()) ;
		x.add(new RicercaFile()) ;
	//	x.add(new RicercaQuery()) ;


		this.algoritmi = x ;
	}
}
