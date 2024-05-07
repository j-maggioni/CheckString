package com.corso.algoritmi;

public class Contains extends CheckString{

	@Override
    public boolean check (String input, String standard) {
		input = input.toLowerCase();
		standard = standard.toLowerCase();
		
        return  input.contains(standard);
    }
}

