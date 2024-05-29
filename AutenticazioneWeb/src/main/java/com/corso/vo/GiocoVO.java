package com.corso.vo;

import javax.validation.constraints.NotNull;

public class GiocoVO {

    @NotNull
    private String data;

    @NotNull
    private int punti;

    @NotNull
    private String gioco;

    @NotNull
    private String utente;

    public GiocoVO() {

    }

    public GiocoVO(String data, int punti, String gioco, String utente) {
        this.data = data;
        this.punti = punti;
        this.gioco = gioco;
        this.utente = utente;
    }

    public String getData() {
        return data;
    }

    public void setData(java.lang.String data) {
        this.data = data;
    }

    public int getPunti() {
        return punti;
    }

    public void setPunti(int punti) {
        this.punti = punti;
    }

    public String getGioco() {
        return gioco;
    }

    public void setGioco(String gioco) {
        this.gioco = gioco;
    }

    public @NotNull String getUtente() {
        return utente;
    }

    public void setUtente(@NotNull String utente) {
        this.utente = utente;
    }

    @Override
    public String toString() {
        return "GiocoVO{" +
                "data='" + data + '\'' +
                ", punti=" + punti +
                ", gioco=" + gioco +
                ", utente='" + utente + '\'' +
                '}';
    }
}

