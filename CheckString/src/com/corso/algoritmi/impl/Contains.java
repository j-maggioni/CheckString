package com.corso.algoritmi.impl;

import com.corso.algoritmi.CheckStringImpl;

public class Contains extends CheckStringImpl {

	@Override
    public boolean check (String input, String standard) {
		input = input.toLowerCase();
		standard = standard.toLowerCase();
		
        return  input.contains(standard);
    }
}

