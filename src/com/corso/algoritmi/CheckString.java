package com.corso.algoritmi;

 import java.util.ArrayList;
import java.util.Collection;

public abstract class CheckString {

    private Collection<String> standards;
    private CheckString next;


    public boolean check( String input){
        standards = new ArrayList<>();
        standards.add("Philippines");
        standards.add("Philippine");
        standards.add("The islands of Philippine");

        System.out.println("Provo con l'algoritmo " + this.getClass().getSimpleName());

        for(String standard : standards){
            if(check(input,standard)){
                System.out.println("Parola " + standard + " trovata con " + this.getClass().getSimpleName());
                return true;
            }
            else{
                // passa un altro algoritmo con setNext()
            }
        }
        if( next != null){
            System.out.println("procedo con il successivo\n");
            next.check(input);

        }
        else {
            return false;
        }
        return true;
    }

    public void setNext(CheckString checkString){
        this.next = checkString;
    }
    // TEMPLATE
    protected abstract boolean check(String input, String standard);



}
