package com.corso.algoritmi;

public class Esito {
    private  boolean esito;
    private String parola;
    private String algoritmo;

    public Esito(boolean esito, String parola, String algoritmo){
        this.esito = esito;
        this.parola = parola;
        this.algoritmo = algoritmo;
    }

    public boolean getEsito(){
        return this.esito;
    }
    
    public String getParola(){
        return this.parola;
    }
    
    public String getAlgoritmo(){
        return this.algoritmo;
    }

}
