package com.corso.vo;

import com.corso.enums.GiochiEnum;

import javax.validation.constraints.NotNull;

public class GiocoVO {

    @NotNull
    private String data;

    @NotNull
    private int punti;

    @NotNull
    private GiochiEnum gioco;

    @NotNull
    private String utente;

    public GiocoVO() {

    }

    public GiocoVO(String data, int punti, GiochiEnum gioco, String utente) {
        this.data = data;
        this.punti = punti;
        this.gioco = gioco;
        this.utente = utente;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getPunti() {
        return punti;
    }

    public void setPunti(int punti) {
        this.punti = punti;
    }

    public GiochiEnum getGioco() {
        return gioco;
    }

    public void setGioco(GiochiEnum gioco) {
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

