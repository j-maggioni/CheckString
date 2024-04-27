package com.corso.algoritmi;


import com.corso.standard.*;
public class Main {
    public static void main(String[] args) throws Exception {

     System.out.println("Test main");
     DBParoleStandard db = new DBParoleStandard() ;
     System.out.println(db.getParoleStandard());
     LocaleParoleStandard db2 = new LocaleParoleStandard();
     System.out.println(db2.getParoleStandard() ); // Da piu risultati 

    }
}