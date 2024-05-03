package com.corso.algoritmi;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

import com.corso.config.Beans;
import com.corso.dao.PaesiDAO;
import com.corso.dao.RankingAlgoritmiDAO;
import com.corso.model.Paesi;
import com.corso.model.RankingAlgoritmi;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ranking {

	private static ArrayList<String> paesiFromDB;
	private static RankingAlgoritmiDAO daoRanking;
	private static String[] algoritmiName = {"ContainedCheckString","ContainsCheckString","Levenstein 1",
											"Levenstein 2","Levenstein 3","Levenstein 4","Soundex"};
	
	public static void algorithmRanking() throws Exception {
		paesiFromDB = new ArrayList<String>();

		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		PaesiDAO daoPaesi = factory.getBean("paesiDAO", PaesiDAO.class);

		for (Paesi p: daoPaesi.all()){
			paesiFromDB.add(p.getNome());
		}

		daoRanking = factory.getBean("rankingAlgoritmiDAO", RankingAlgoritmiDAO.class);
		daoRanking.truncate();

		for (String name: algoritmiName) {
			insertRow(createCheckStringInstance("com.corso.algoritmi."+name));  
		}
		System.out.println(daoRanking.all());
		daoRanking.sortTable();
		System.out.println(daoRanking.all());
		
	}

	private static void insertRow(CheckString checkString) throws Exception {
		int esatti = 0;
		for (String nomePaese: paesiFromDB) {
			Esito esito = checkString.check(nomePaese);
			if(esito.getEsito()) {
				esatti++;
			}
		}
		double score = (double) esatti/paesiFromDB.size();

		RankingAlgoritmi algoritmo = new RankingAlgoritmi(checkString.getName(),esatti,paesiFromDB.size(),score);
		RankingAlgoritmi algoritmoAggiunto = daoRanking.add(algoritmo);
		System.out.println(algoritmoAggiunto);
	}
	
	public static CheckString getFirstAlgorithm() throws Exception {

		ArrayList<CheckString> algoritmi = new ArrayList<CheckString>();
		for (RankingAlgoritmi algoritmo : daoRanking.all()) {
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
	
}
