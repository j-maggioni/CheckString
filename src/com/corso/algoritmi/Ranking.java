package com.corso.algoritmi;

import com.corso.config.Beans;
import com.corso.model.RankingAlgoritmi;
import com.corso.service.RankingAlgoritmiService;
import com.corso.standard.LocaleParoleStandard;
import com.corso.standard.ParoleStandard;
import com.corso.standard.Standard;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ranking {

	private static final String ALGORITMI_IMPL_PACKAGE = "com.corso.algoritmi.impl";
	private static boolean ranking;

	private static ArrayList<String> paesi;
	private static String[] algoritmiUsati = {"Contained","Contains","Levenstein 1",
											"Levenstein 2","Levenstein 3","Levenstein 4","Soundex",
											"InserimentoManuale", "RicercaDB", "SigleSpecialiDB"};
	private static String[] algoritmiNonAddestrati = {"InserimentoManuale", "RicercaDB", "SigleSpecialiDB"};
	private static String[] algoritmiIgnorati = {"InserimentoManuale"};

	private static BeanFactory factory;
	private static RankingAlgoritmiService serviceRanking;
	static {
		factory = new AnnotationConfigApplicationContext(Beans.class);
		serviceRanking = factory.getBean("rankingAlgoritmiService", RankingAlgoritmiService.class);
	}

	public static void algorithmRanking() throws Exception {
		paesi = new ArrayList<String>();

		//ParoleStandard s = new DBParoleStandard();
		ParoleStandard s = new LocaleParoleStandard();

		for (Standard p: s.getStandards()){
			paesi.add(p.getValue());
		}

		activateAll();

		for (String algoritmo: algoritmiUsati()) {
			insertRow(algoritmo);
		}

	}

	private static void insertRow(String nomeAlgoritmo) throws Exception {
		RankingAlgoritmi algoritmo;
		if (!Arrays.asList(algoritmiNonAddestrati).contains(nomeAlgoritmo)) {
			CheckString checkString = createCheckStringInstance(ALGORITMI_IMPL_PACKAGE +"."+nomeAlgoritmo);
			int esatti = 0;
			for (String nomePaese : paesi) {
				Esito esito = checkString.check(nomePaese);
				if (esito.getEsito()) {
					esatti++;
				}
			}
			RankingAlgoritmi algoritmoFind = serviceRanking.findAlgoritmo(nomeAlgoritmo);
			if(algoritmoFind != null) {
				algoritmo = algoritmoFind;
			} else {
				algoritmo = new RankingAlgoritmi(nomeAlgoritmo, esatti, paesi.size());
			}
		} else {
			RankingAlgoritmi algoritmoFind = serviceRanking.findAlgoritmo(nomeAlgoritmo);
			if(algoritmoFind != null) {
				algoritmo = algoritmoFind;
			} else {
				algoritmo = new RankingAlgoritmi(nomeAlgoritmo, 0, 0);
			}
			if (nomeAlgoritmo.equalsIgnoreCase("InserimentoManuale")){
				algoritmo.setAttivo(false);
			}
		}
		serviceRanking.addAlgoritmo(algoritmo);
	}

	public static CheckString getFirstAlgorithm() throws Exception {
		ranking = false;
		ArrayList<CheckString> algoritmi = new ArrayList<CheckString>();
		for (String algoritmo: algoritmiUsati()) {
			CheckString c = createCheckStringInstance(ALGORITMI_IMPL_PACKAGE +"."+algoritmo);
			algoritmi.add(c);
		}
		
		for (int i=0; i<algoritmi.size()-1; i++) {
			algoritmi.get(i).setNext(algoritmi.get(i+1));
		}
		
		return algoritmi.get(0);
    }
		
	private static CheckString createCheckStringInstance(String className) throws Exception {
		Object object = null;
		try {
			if (className.split(" ").length > 1) {	//caso per Levenstein
				Class c = Class.forName(className.split(" ")[0]);
				Class[] intArgsClass = new Class[] {int.class};
				Constructor constructor = c.getConstructor(intArgsClass);
				object = constructor.newInstance(Integer.parseInt(className.split(" ")[1]));
			} else {
				Class classDefinition = Class.forName(className);
				object = classDefinition.newInstance();
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return (CheckString) object;
   }

	public static void activateAll() {
		List<String> algoritmi = serviceRanking.getAlgoritmi().stream()
				.map(RankingAlgoritmi::getNome)
				.collect(Collectors.toList());

		for (String algoritmo: algoritmi){
			changeAlgorithmActivation(algoritmo, true);
		}
	}

	public static void changeAlgorithmActivation(String algoritmo, boolean attivo) {
		if(Arrays.asList(algoritmiIgnorati).contains(algoritmo)){
			attivo = false;
		}
		serviceRanking.changeAlgorithmActivation(algoritmo, attivo);
	}

	public static boolean isRanking() {
		return ranking;
	}

	public static void setRanking(boolean ranking) {
		Ranking.ranking = ranking;
	}

	private static List<String> algoritmiUsati(){
		if (serviceRanking.getAlgoritmiAttivi().isEmpty() || isRanking()){
			return Arrays.asList(algoritmiUsati);
		} else {
			return serviceRanking.getAlgoritmiAttivi().stream()
					.map(RankingAlgoritmi::getNome)
					.collect(Collectors.toList());
		}
	}
}
