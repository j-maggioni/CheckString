package com.corso.algoritmi;

public class Main {
    public static void main(String[] args) {

        CheckString checkStringContained = new ContainedCheckString();
        CheckString checkStringContains = new ContainsCheckString();

        checkStringContains.setNext(checkStringContained);


        checkStringContains.check("Phili");

    }
}