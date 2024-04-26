package com.corso.standard;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class LocaleParoleStandard implements ParoleStandard{
	public ArrayList<Standard> paroleStandard ;
	public ArrayList<String> SoloNomiPaesi ; // messi a disposizione se servono 
	public ArrayList<String> SoloCodiciPaesi ; // messi a disposizione se servono 

	// Costr + getter + setter 

	public LocaleParoleStandard() {
		setParoleStandard();
	}
	public ArrayList<Standard> getParoleStandard() {
		return paroleStandard;
	}
	public void setParoleStandard() {
		this.paroleStandard = (ArrayList<Standard>) getStandards();
	}


	@Override
	public List<Standard> getStandards() {
		ArrayList<Standard> paroleStandardDaRitornare = new ArrayList<>(); 
		ArrayList<String> SoloNomiPaesiCopy = new ArrayList<>(); 
		ArrayList<String> SoloCodiciPaesicopy = new ArrayList<>(); 
		try {
			Locale [] locales = Locale.getAvailableLocales();
			for (Locale locale : locales) {
				String codicePaese = locale.getCountry();
				String nomePaese = locale.getDisplayCountry();
				Standard st = new Standard(codicePaese,nomePaese );
				SoloCodiciPaesicopy.add(codicePaese) ;
				SoloNomiPaesiCopy.add(nomePaese) ;
				paroleStandardDaRitornare.add(st); // <Standard> 
			}
			this.SoloCodiciPaesi = SoloCodiciPaesicopy ;
			this.SoloNomiPaesi = SoloNomiPaesiCopy ;
			System.out.println("Metodo getStandards ha recuperato con successo dalla classe Locale di java i standard!!");
			return paroleStandardDaRitornare ;
			
		} catch (Exception e) {
			System.out.println("Error while retreiving the Locale java class");
		}
		return paroleStandardDaRitornare;
	}
	

}
