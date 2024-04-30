package com.corso.standard;
import com.corso.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBParoleStandard implements ParoleStandard {
	private ArrayList<Standard> paroleStandard ;  
	
	@Override
	public List<Standard> getStandards()  {
        ArrayList<Standard> arrayStandard = new ArrayList<Standard>(); 
		Statement statement = DBConfig.connectToDB(); 
		String query1 = " Select * from Country order by name asc ;" ;
		try {
			ResultSet res = statement.executeQuery(query1) ;
			while (res.next()) {
				String nomePaese = res.getNString("name") ;
				String codePaese = res.getNString("Code") ; 
				Standard st = new Standard(codePaese,nomePaese) ;
                arrayStandard.add(st) ;
			};
			this.paroleStandard = arrayStandard ;
			return arrayStandard ;
		} catch (SQLException e) {
			System.out.println("Error while excetuting the query !!, sql error : " +e);
			e.printStackTrace();
			return arrayStandard ;
		}
	}	
	// Costr + getter , (setter presente nel metodo getParoleStandard ) 
	public DBParoleStandard() throws Exception {
		getStandards() ; 
	}
	public ArrayList<Standard> getParoleStandard() {
		return paroleStandard;
	}
}
