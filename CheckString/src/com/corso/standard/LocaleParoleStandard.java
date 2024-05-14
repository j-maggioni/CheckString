package com.corso.standard;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LocaleParoleStandard implements ParoleStandard{
	private ArrayList<Standard> paroleStandard ;
	
	public void setParoleStandard() {
		this.paroleStandard = (ArrayList<Standard>) getStandards();
	}
	
	// Costr + getter (setter presente nel metodo getParoleStandard ) 
	public LocaleParoleStandard() {
		setParoleStandard() ;
		}
	public ArrayList<Standard> getParoleStandard() {
		return paroleStandard;
	}


	@Override
	public List<Standard> getStandards() {
		ArrayList<Standard> paroleStandardDaRitornare = new ArrayList<>(); 
		try {
			Locale [] locales = Locale.getAvailableLocales();  // no valori null o blank ;
			for (Locale locale : locales) {
				if (locale.getDisplayCountry() != "" && locale.getDisplayCountry() != null && 
						locale.getCountry() != null && locale.getCountry() != "") {
					String codicePaese = locale.getCountry();
					String nomePaese = locale.getDisplayCountry();
					Standard st = new Standard(codicePaese,nomePaese );
					paroleStandardDaRitornare.add(st); 
				} //  if
			} // for 
			this.paroleStandard = paroleStandardDaRitornare ;
			return paroleStandardDaRitornare ;
		
		} // try
		catch (Exception e) {
			System.out.println("Error while getting the Locale java class");
		}
		return paroleStandardDaRitornare;
	}
	@Override
	public String toString() {
		return "LocaleParoleStandard [paroleStandard=" + paroleStandard + "]";
	}
	

}
