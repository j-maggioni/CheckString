package com.corso.algoritmi;

public class ContainsCheckString extends CheckString{

	@Override
    public boolean check (String input, String standard) {
		input = input.toLowerCase();
		standard = standard.toLowerCase();
		
        return  input.contains(standard);
    }
}

