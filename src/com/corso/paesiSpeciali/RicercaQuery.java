package com.corso.paesiSpeciali;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.corso.standard.*;

public class RicercaQuery implements RichercaPaesiSpeciali {

	@Override
	public String cercaPaeseSpeciale(String paeseSpeciale) {		
		String s = "" ;
		String query = "Select name from country where code2 like '" +paeseSpeciale+ "%' limit 1 ;" ;
	    //System.out.println(query);
		try {
			Statement st = DBConfig.connectToDB();
			ResultSet result = st.executeQuery(query) ;
			if ( result.next()) {
			    String nomePaese = result.getNString(1) ;
			    s = nomePaese ;
			}
			else {
		        System.out.println("Paese non trovato via RicercaQuery ");
			}
//			while (result.next()) {
//				String nomePaese = result.getNString(1) ;
//			    s = result.getNString("Name") ;
//			    return nomePaese ;
//			};
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}
	

	}


