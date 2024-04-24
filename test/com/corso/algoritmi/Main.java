package com.corso.algoritmi;

public class Main {
    public static void main(String[] args) {

        CheckString checkStringContained = new ContainedCheckString();
        CheckString checkStringContains = new ContainsCheckString();
        checkStringContains.setNext(checkStringContained);
        checkStringContains.check("Phili");
        
        Levenstein l1 = new Levenstein(1);
        Levenstein l2 = new Levenstein(2);
        Levenstein l3 = new Levenstein(3);
        String word1 = "Phiippi";
        l1.check("ciaoo","ciao");
        l1.setNext(l2);
        l2.setNext(l3);
        System.out.println("Il risultato è " + l1.check(word1));

    }
}