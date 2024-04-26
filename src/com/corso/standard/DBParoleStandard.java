package com.corso.standard;
import com.corso.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBParoleStandard implements ParoleStandard {
	public ArrayList<Standard> paroleStandard ;
	public ArrayList<String> arraylistCountryNames ;
	public ArrayList<String> arraylistContryCodes ; 


	@Override
	public List<Standard> getStandards()  {
        ArrayList<Standard> arrayReturn = new ArrayList<Standard>(); 
		ArrayList<String> arraylistCountryNamesTransporter = new ArrayList<>() ;
		ArrayList<String> arraylistCountryCodeTransporter = new ArrayList<>() ;
			DBConfig.loadDriver(); // se tutto ok -> si stampa Driver OK !!
			Connection cn = DBConfig.getConnection();// se tutto ok -> si stampa 		Connection ok !! to DB name : checkstring
			Statement statement = DBConfig.getStatement(cn); // se tutto ok viene stampato -> 		Statement ok !!
			String query1 = " Select * from Country order by name asc ;" ;
		try {
			ResultSet res = statement.executeQuery(query1) ;
			while (res.next()) {
				String nomePaese = res.getNString("name") ;
				String codePaese = res.getNString("Code") ;   // Quale usare ??
				String codePaese2 = res.getNString("Code2") ;  // Quale Usare ??
                Standard st = new Standard(codePaese,nomePaese) ;
                arrayReturn.add(st) ;
                arraylistCountryCodeTransporter.add(codePaese);
                arraylistCountryNamesTransporter.add(nomePaese) ;
			};
			this.paroleStandard = arrayReturn ;
			this.arraylistContryCodes = arraylistCountryCodeTransporter ;
			this.arraylistCountryNames = arraylistCountryNamesTransporter;
			//System.out.println(arrayReturn);
			
			System.out.println("Metodo getStandards ha recuperato con successo dal Database i standard!!");
			return arrayReturn ;
		} catch (SQLException e) {
			System.out.println("Error while excetuting the query !!");
			e.printStackTrace();
		}
		return arrayReturn ;
	}
	
	
	// Costr 
	public DBParoleStandard() {
		setParoleStandard() ;
	}
	// Getters & setters 
	public ArrayList<Standard> getParoleStandard() {
		return paroleStandard;
	}
	private void setParoleStandard() {  // è private perchè viene settato in automatico da: getStandards();
		this.paroleStandard =  (ArrayList<Standard>) getStandards();
	};
	public ArrayList<String> getArraylistCountryNames() {
		return arraylistCountryNames;
	}
	public ArrayList<String> getArraylistContryCodes() {
		return arraylistContryCodes;
	}

}
