package com.corso.algoritmi;


public class Esito {
    private  boolean esito;
    private String parolaInput;
    private String parolaStandard;
    private String algoritmo;

    public Esito(boolean esito, String parolaInput, String parolaStandard, String algoritmo){
        this.esito = esito;
        this.parolaInput = parolaInput.trim();
        this.parolaStandard = parolaStandard.trim();
        this.algoritmo = algoritmo;
    }

    public boolean getEsito(){
        return this.esito;
    }
    
    public String getParolaInput(){
        return this.parolaInput;
    }
    
    public String getParolaStandard(){
        return this.parolaStandard;
    }
    
    public String getAlgoritmo(){
        return this.algoritmo;
    }

	@Override
	public String toString() {
		return "Esito [esito=" + esito + ", parolaInput=" + parolaInput + ", parolaStandard=" + parolaStandard
				+ ", algoritmo=" + algoritmo + "]";
	}
    

}
