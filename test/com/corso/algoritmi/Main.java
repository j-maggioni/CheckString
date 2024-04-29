package com.corso.algoritmi;


import com.corso.paesiSpeciali.ManagerRicerca;
import com.corso.standard.*;
public class Main {
    public static void main(String[] args) throws Exception {

//     System.out.println("Test main");
//     DBParoleStandard db = new DBParoleStandard() ;
//     System.out.println(db.getParoleStandard());
//     LocaleParoleStandard db2 = new LocaleParoleStandard();
//     System.out.println(db2.getParoleStandard() ); // Da piu risultati 
    	
    	// se mi passi una stringa con almeno 2 caratteri 
    	ManagerRicerca manager = new ManagerRicerca() ;
    	manager.getParola("Ind") ;
    	
    }
}