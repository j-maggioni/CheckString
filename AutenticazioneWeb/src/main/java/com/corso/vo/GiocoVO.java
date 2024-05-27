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

    public GiocoVO() {

    }

    public GiocoVO(String data, int punti, GiochiEnum gioco) {
        this.data = data;
        this.punti = punti;
        this.gioco = gioco;
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
}

