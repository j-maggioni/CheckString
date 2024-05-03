package com.corso.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "ranking_algoritmi")
//TODO: aggiungere namedQuery
public class RankingAlgoritmi {

	@Id
	@Column(name="nome", unique = true)
	@NotNull
	private String nome;

	@Column(name="occorrenze")
	@NotNull
	private int occorrenze;

	@Column(name="esatti")
	@NotNull
	private int esatti;

	@Column(name="totali")
	@NotNull
	private int totali;

	@Column(name="score")
	@NotNull
	private double score;

	@Column(name="attivo")
	@NotNull
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
		return "RankingAlgoritmi{" +
				"nome='" + nome + '\'' +
				", occorrenze=" + occorrenze +
				", esatti=" + esatti +
				", totali=" + totali +
				", score=" + score +
				", attivo=" + attivo +
				'}';
	}
}
