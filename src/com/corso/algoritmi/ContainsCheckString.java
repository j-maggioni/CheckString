package com.corso.algoritmi;

public class ContainsCheckString extends CheckString{

	@Override
    public boolean check (String input, String standard) {

        return  input.contains(standard);
    }
}
