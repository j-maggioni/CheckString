package com.corso.algoritmi;

import java.util.ArrayList;
import java.util.Locale;

import com.corso.standard.DBConfig;
import com.corso.standard.DBParoleStandard;
import com.corso.standard.LocaleParoleStandard;
import com.corso.standard.Standard;

public class Main {
    public static void main(String[] args) {

//        CheckString checkStringContained = new ContainedCheckString();
//        CheckString checkStringContains = new ContainsCheckString();
//        checkStringContains.setNext(checkStringContained);
//        checkStringContains.check("Phili");
//        
//        Levenstein l1 = new Levenstein(1);
//        Levenstein l2 = new Levenstein(2);
//        Levenstein l3 = new Levenstein(3);
//        String word1 = "Phiippi";
//        l1.check("ciaoo","ciao");
//        l1.setNext(l2);
//        l2.setNext(l3);
//        System.out.println("Il risultato è " + l1.check(word1));
    	
    	
    	
        System.out.println("Test main");
        DBParoleStandard db = new DBParoleStandard() ;
        System.out.println(db.getParoleStandard());
        LocaleParoleStandard db2 = new LocaleParoleStandard();
        System.out.println(db2.getParoleStandard() );

        //System.out.println(db.getArraylistCountryNames() );
        //System.out.println(db.getArraylistContryCodes() ) ;
        //System.err.println(db.getParoleStandard());
        
        //db.getStandards();
//        db.getArraylistContryCodes();
//        db.getArraylistCountryNames();

        

//
//			
//		}
//		System.out.println(xx);

    }
}