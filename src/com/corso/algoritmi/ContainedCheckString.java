package com.corso.algoritmi;

public class ContainedCheckString extends CheckString {
    @Override
    public boolean check (String input, String standard) {
    	input = input.toLowerCase();
		standard = standard.toLowerCase();
		
        return  standard.contains(input);
    }
}
