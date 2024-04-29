package com.corso.algoritmi;

import java.util.*;
import com.corso.standard.*;

public abstract class CheckString {

    private List<Standard> standards;
    private CheckString next;


    public boolean check(String input){
        standards = new ArrayList<>();
        /*standards.add("Philippines");
        standards.add("Philippine");
        standards.add("The islands of Philippine");*/
    	
    	
    	//AGGIUNTO METODO PER CERCARE PAROLA NEL DB RICERCHE RECENTI
    	Client c = new Client();
    	String output = c.isWordInDatabase(input);
    	if (output!=null) {
            System.out.println("Parola " + input + " trovata nel database ed è associata a " + output);
            return true;
        }
    	
    	
    	ParoleStandard s = new FileParoleStandard();
    	/*ParoleStandard s = new DBParoleStandard();
    	ParoleStandard s = new LocaleParoleStandard();*/
    	standards = s.getStandards();
    	System.out.println(standards);

        System.out.println("Provo con l'algoritmo " + this.getClass().getSimpleName());

        /* TODO: fare controllo da DB world-country se lunghezza di input =2 o =3 
         * implementare lettura da DB*/
        
        
        
        for(Standard standard : standards){
            if(check(input,standard.getValue())){
                System.out.println("Parola " + standard.getValue() + " trovata con " + this.getClass().getSimpleName());
                c.addInDB(input, standard.getValue());
                return true;
            }
            else{
                // passa un altro algoritmo con setNext()
            }
        }
        if (next != null){
            System.out.println("procedo con il successivo\n");
            return next.check(input);

        }
        else {
            return false;
        }
        //return true;
    }

    public void setNext(CheckString checkString){
        this.next = checkString;
    }
    // TEMPLATE
    protected abstract boolean check(String input, String standard);

    protected String getName() {
    	return this.getClass().getSimpleName();
    }


}
