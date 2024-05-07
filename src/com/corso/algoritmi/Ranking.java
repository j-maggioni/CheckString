package com.corso.algoritmi;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

import com.corso.config.Beans;
import com.corso.dao.PaesiDAO;
import com.corso.model.Paesi;
import com.corso.model.RankingAlgoritmi;
import com.corso.service.RankingAlgoritmiService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ranking {

	private static ArrayList<String> paesiFromDB;
	private static String[] algoritmiUsati = {"ContainedCheckString","ContainsCheckString","Levenstein 1",
											"Levenstein 2","Levenstein 3","Levenstein 4","Soundex"};

	private static BeanFactory factory;
	private static RankingAlgoritmiService serviceRanking;
	static {
		factory = new AnnotationConfigApplicationContext(Beans.class);
		serviceRanking = factory.getBean("rankingAlgoritmiService", RankingAlgoritmiService.class);
	}

	public static void algorithmRanking() throws Exception {
		paesiFromDB = new ArrayList<String>();

		PaesiDAO daoPaesi = factory.getBean("paesiDAO", PaesiDAO.class);

		for (Paesi p: daoPaesi.all()){
			paesiFromDB.add(p.getNome());
		}

		for (String name: algoritmiUsati) {
			insertRow(createCheckStringInstance("com.corso.algoritmi."+name));  
		}
		
	}

	private static void insertRow(CheckString checkString) throws Exception {
		int esatti = 0;
		for (String nomePaese: paesiFromDB) {
			Esito esito = checkString.check(nomePaese);
			if(esito.getEsito()) {
				esatti++;
			}
		}

		RankingAlgoritmi algoritmo = new RankingAlgoritmi(checkString.getName(),esatti,paesiFromDB.size());
		if (!serviceRanking.findAlgoritmo(algoritmo)){
			serviceRanking.addAlgoritmo(algoritmo);
		}
	}

	public static CheckString getFirstAlgorithm() throws Exception {

		ArrayList<CheckString> algoritmi = new ArrayList<CheckString>();
		for (RankingAlgoritmi algoritmo : serviceRanking.getAlgoritmiAttivi()) {
			CheckString c = createCheckStringInstance("com.corso.algoritmi."+algoritmo.getNome());
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

	public static void changeAlgorithmActivation(String algoritmo, boolean active) throws Exception {
		serviceRanking.changeAlgorithmActivation(algoritmo, active);
	}

}
