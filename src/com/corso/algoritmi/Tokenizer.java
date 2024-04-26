package com.corso.algoritmi;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Tokenizer {

    public static ArrayList<String> tokenize(String input) {
        ArrayList<String> tokens = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(input);
        
        
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            // Se il token non è incluso tra le parole escluse, lo aggiungiamo alla lista dei token
            if (!isExcluded(token)) {
                tokens.add(token);
            }
        }
        return tokens;
    }

    private static boolean isExcluded(String word) {
    	// Definire le parole da escludere
        String[] excludedWords = {"de", "di", "of", "des", "delle", "du", "del", "et", "e", "and", "d\'", "-", "l\'", "dans", "nell'", "in", "the", "\'", "les", ","}; 
    	
    	for (String excludedWord : excludedWords) {
            if (word.equalsIgnoreCase(excludedWord)) {
                return true; // La parola è esclusa
            }
        }
        return false; // La parola non è esclusa
    }
}


