package com.corso.algoritmi;

public class Soundex extends CheckString {
    
    public static String encode(String word) {
        if (word == null || word.isEmpty()) return "";
        
        // Converti la parola in maiuscolo
        word = word.toUpperCase();
        
        // Rimuovi le vocali eccetto la prima lettera
        word = word.charAt(0) + word.substring(1).replaceAll("[AEIOUYHW]", "");
        
        // Rimuovi le consonanti duplicate
        StringBuilder encoded = new StringBuilder();
        char lastChar = '-';
        for (char c : word.toCharArray()) {
            if (c != lastChar) {
                encoded.append(c);
                lastChar = c;
            }
        }
        
        // Mappa le consonanti rimanenti ai corrispondenti numeri secondo la tabella Soundex
        encoded = new StringBuilder(encoded.toString().replaceAll("[BFPV]", "1")
                .replaceAll("[CGJKQSXZ]", "2")
                .replaceAll("[DT]", "3")
                .replaceAll("[L]", "4")
                .replaceAll("[MN]", "5")
                .replaceAll("[R]", "6"));
        
        // Aggiungi padding fino a raggiungere la lunghezza desiderata
        while (encoded.length() < 4) {
            encoded.append("0");
        }
        
        // Restituisci solo i primi 4 caratteri
        return encoded.substring(0, 4);
    }

	@Override
	protected boolean check(String input, String standard) {
		// TODO Auto-generated method stub
		return false;
	}
}

	