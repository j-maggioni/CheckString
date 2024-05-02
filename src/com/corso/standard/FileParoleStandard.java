package com.corso.standard;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.corso.bean.Standard;

public class FileParoleStandard implements ParoleStandard {
    private List<Standard> paroleStandard = new ArrayList<Standard>();

    public FileParoleStandard()  {
        readFile();
    }

    private void readFile() {
        try{
            File file = new File("./res/Nazioni2.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String parola = scanner.nextLine();
                String codice = parola.substring(0, parola.indexOf(',')-1).trim();
                String nome = parola.substring(parola.indexOf(',')+1, parola.length()).trim();
                Standard standard = new Standard(codice, nome);
                paroleStandard.add(standard);
            }
            scanner.close();
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }


	@Override
	public List<Standard> getStandards() {
		
	    return paroleStandard;
	}
}
