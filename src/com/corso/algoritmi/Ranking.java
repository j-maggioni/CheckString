package com.corso.algoritmi;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.corso.config.Beans;
import com.corso.model.RankingAlgoritmi;
import com.corso.service.RankingAlgoritmiService;
import com.corso.standard.LocaleParoleStandard;
import com.corso.standard.ParoleStandard;
import com.corso.standard.Standard;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ranking {

	private static boolean ranking;

	private static ArrayList<String> paesiFromDB;
	private static String[] algoritmiUsati = {"Contained","Contains","Levenstein 1",
											"Levenstein 2","Levenstein 3","Levenstein 4","Soundex"};
	private static String[] algoritmiIgnorati = {"InserimentoManuale"};

	private static BeanFactory factory;
	private static RankingAlgoritmiService serviceRanking;
	static {
		factory = new AnnotationConfigApplicationContext(Beans.class);
		serviceRanking = factory.getBean("rankingAlgoritmiService", RankingAlgoritmiService.class);
	}

	public static void algorithmRanking() throws Exception {
		paesiFromDB = new ArrayList<String>();

//		PaesiService daoPaesi = factory.getBean("paesiService", PaesiService.class);
//
//		for (Paesi p: daoPaesi.all()){
//			paesiFromDB.add(p.getNome());
//		}

		ParoleStandard s = new LocaleParoleStandard();
		for (Standard p: s.getStandards()){
			paesiFromDB.add(p.getValue());
		}

		for (RankingAlgoritmi algoritmo: serviceRanking.getAlgoritmiAttivi()) {
			insertRow(createCheckStringInstance("com.corso.algoritmi."+algoritmo.getNome()));
		}
		RankingAlgoritmi inserimentoManuale = new RankingAlgoritmi("InserimentoManuale",0,0);
		inserimentoManuale.setAttivo(false);
		serviceRanking.addAlgoritmo(inserimentoManuale);
	}

	private static void insertRow(CheckString checkString) throws Exception {
		int esatti = 0;
		for (String nomePaese : paesiFromDB) {
			Esito esito = checkString.check(nomePaese);
			if (esito.getEsito()) {
				esatti++;
			}
		}

		RankingAlgoritmi algoritmo = new RankingAlgoritmi(checkString.getName(),esatti,paesiFromDB.size());
		serviceRanking.addAlgoritmo(algoritmo);
	}

	public static CheckString getFirstAlgorithm() throws Exception {

		ArrayList<CheckString> algoritmi = new ArrayList<CheckString>();
		for (RankingAlgoritmi algoritmo : serviceRanking.getAlgoritmiAttivi()) {
			if(!Arrays.asList(algoritmiIgnorati).contains(algoritmo.getNome())){
				CheckString c = createCheckStringInstance("com.corso.algoritmi." + algoritmo.getNome());
				algoritmi.add(c);
			}
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

	public static void changeAllActivations() throws Exception {
		List<String> algoritmi = new ArrayList<>();
		for(RankingAlgoritmi r: serviceRanking.getAlgoritmi()){
			algoritmi.add(r.getNome());
		}

		for (String algoritmo: algoritmi){
			changeAlgorithmActivation(algoritmo);
		}
	}

	public static void changeAlgorithmActivation(String algoritmo) throws Exception {
		boolean active = true;
		if(!Arrays.asList(algoritmiIgnorati).contains(algoritmo)){
			if(serviceRanking.findAlgoritmo(algoritmo).isAttivo()){// && !ranking){
				active = false;
			}
		} else {
			active = false;
		}
		serviceRanking.changeAlgorithmActivation(algoritmo, active);
	}

	public static boolean isRanking() {
		return ranking;
	}

	public static void setRanking(boolean ranking) {
		Ranking.ranking = ranking;
	}
}
