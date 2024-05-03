package com.corso.model;

import javax.persistence.*;
import javax.persistence.NamedNativeQuery;

@Entity(name = "ranking_algoritmi")

@Table (name="ranking_algoritmi")
@NamedNativeQueries({
		@NamedNativeQuery(name = "RankingAlgoritmi.TruncateTable",
				query = "TRUNCATE TABLE ranking_algoritmi;"),
		@NamedNativeQuery(name = "RankingAlgoritmi.SortTable",
				query = "ALTER TABLE ranking_algoritmi ORDER BY score ASC;")
})

public class RankingAlgoritmi {

	@Id
	@Column(name="nome", unique = true)
	private String nome;

	@Column(name="occorrenze")
	private int occorrenze;

	@Column(name="esatti")
	private int esatti;

	@Column(name="totali")
	private int totali;

	@Column(name="score")
	private double score;

	@Column(name="attivo")
	private boolean attivo;

	public RankingAlgoritmi() {
	}

	public RankingAlgoritmi(String nome, int esatti, int totali, double score) {
		this.nome = nome;
		this.occorrenze = 0;
		this.esatti = esatti;
		this.totali = totali;
		this.score = score;
		this.attivo = true;
	}

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
