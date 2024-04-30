package com.corso.paesiSpeciali;

import java.util.ArrayList;
import java.util.List;

public class ManagerRicerca {
	public ArrayList<RichercaPaesiSpeciali> algoritmi ;
	
	public String getParola(String paeseSpeciale) {
		System.out.println("---ricerca in corso in metodo get .....");
	  String stringToReturn = ""  ;
	  for (RichercaPaesiSpeciali algo : algoritmi) {
		 String risultatoAlgoritmo = algo.cercaPaeseSpeciale(paeseSpeciale) ;
		 if (!(risultatoAlgoritmo.equals("")) // && !risultatoAlgoritmo.equals(null) &&
				 ) {
		  System.out.println("---Paese Speciale che corrisponde a " +paeseSpeciale+ " --> " +risultatoAlgoritmo + "get parola ManagerRicerca");
		  return risultatoAlgoritmo ;
	     }
	} // for
	System.out.println("-----Paese Speciale non trovato");
      return stringToReturn ;
	}
	
	// Costr
	public ManagerRicerca() {
		setAlgoritmi();
	}
	// setter
	private void setAlgoritmi() {
		ArrayList<RichercaPaesiSpeciali> x = new ArrayList<RichercaPaesiSpeciali>();
		x.add(new RicercaLocale()) ;
		x.add(new RicercaFile()) ;
		x.add(new RicercaQuery()) ;


		this.algoritmi = x ;
	}
}
