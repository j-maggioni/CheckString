package com.corso.bean;

import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

public class AlgoritmoEseguito implements Bean{

	private String nome;
	private int occorrenze;
	private int esatti;
	private int totali;
	private double score;
	private boolean attivo;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getOccorrenze() {
		return occorrenze;
	}

	public void setOccorrenze(int occorrenze) {
		this.occorrenze = occorrenze;
	}

	public int getEsatti() {
		return esatti;
	}

	public void setEsatti(int esatti) {
		this.esatti = esatti;
	}

	public int getTotali() {
		return totali;
	}

	public void setTotali(int totali) {
		this.totali = totali;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public boolean isAttivo() {
		return attivo;
	}

	public void setAttivo(boolean attivo) {
		this.attivo = attivo;
	}

	@Override
	public String toString() {
		return "AlgoritmoEseguito[" +
				"nome='" + nome + '\'' +
				", occorrenze=" + occorrenze +
				", esatti=" + esatti +
				", totali=" + totali +
				", score=" + score +
				", attivo=" + attivo +
				']';
	}
}
