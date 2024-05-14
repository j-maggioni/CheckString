package com.corso.model;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "ranking_algoritmi")

@Table (name="ranking_algoritmi")
@NamedNativeQueries({
		@NamedNativeQuery(name = "RankingAlgoritmi.SortingResults",
				query = "SELECT * FROM ranking_algoritmi ORDER BY score ASC",
				resultClass = RankingAlgoritmi.class),
		@NamedNativeQuery(name = "RankingAlgoritmi.ActiveAlgorithms",
				query = "SELECT * FROM ranking_algoritmi WHERE attivo ORDER BY score ASC;",
				resultClass = RankingAlgoritmi.class)
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

	public RankingAlgoritmi(String nome, int esatti, int totali) {
		this.nome = nome;
		this.occorrenze = 0;
		this.esatti = esatti;
		this.totali = totali;
		this.attivo = true;
		setScore();
	}

	public String getNome() {
		return nome;
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

	public void setScore() {
		if (totali != 0 || occorrenze != 0) {
			score = (double) (esatti + occorrenze) / (totali + occorrenze);
		} else {
			this.score = 0;
		}
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		return Objects.equals(this.nome, ((RankingAlgoritmi) o).nome);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(nome);
	}
}
