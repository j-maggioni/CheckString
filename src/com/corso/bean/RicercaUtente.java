package com.corso.bean;

import java.util.Date;

public class RicercaUtente implements Bean{

    private Integer id;
    private Date data;
    private String input;
    private String standard;
    private String algortimo;
    private boolean approvazione;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getAlgortimo() {
        return algortimo;
    }

    public void setAlgortimo(String algortimo) {
        this.algortimo = algortimo;
    }

    public boolean isApprovazione() {
        return approvazione;
    }

    public void setApprovazione(boolean approvazione) {
        this.approvazione = approvazione;
    }

    @Override
    public String toString() {
        return "RicercaUtente[" +
                "id=" + id +
                ", data=" + data +
                ", input='" + input + '\'' +
                ", standard='" + standard + '\'' +
                ", algortimo='" + algortimo + '\'' +
                ", approvazione=" + approvazione +
                ']';
    }
}
