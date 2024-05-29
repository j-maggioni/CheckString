package com.corso.model;

import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity(name = "paesi")
@NamedNativeQueries({
		@NamedNativeQuery(
				name = "Paesi.init",
				query = "SELECT Code as codice3, Code2 as codice2, Name as nomeENG, null as nomeITA FROM world.country",
				resultClass = Paesi.class),

		@NamedNativeQuery(name = "Paesi.All",
				query = "SELECT * FROM paesi ",
				resultClass = Paesi.class),

		@NamedNativeQuery(name = "Paesi.ByCode2",
				query = "SELECT * FROM paesi WHERE codice2 = :codice2 ;",
				resultClass = Paesi.class),

		@NamedNativeQuery(name = "Paesi.ByCode3",
				query = "SELECT * FROM paesi WHERE codice3 = :codice3 ;",
				resultClass = Paesi.class),

		@NamedNativeQuery(name = "Paesi.ByNome",
				query = "SELECT * FROM paesi WHERE nomeITA = :nomeITA ;",
				resultClass = Paesi.class) ,
})

public class Paesi {

	@Column(name="nomeENG")
	private String nomeENG;

	@Id
	@Column(name="codice2")
	private String codice2;

	@Column(name="codice3")
	private String codice3;

	@Column(name="nomeITA", nullable = true)
	private String nomeITA;

	public Paesi() {

	}
	public Paesi(String nome, String codice2, String codice3) {
		this.nomeENG = nome;
		this.codice2 = codice2;
		this.codice3 = codice3;
		this.nomeITA = null;
	}

	public String getNomeENG() {
		return nomeENG;
	}

	public void setNomeENG(String nomeENG) {
		this.nomeENG = nomeENG;
	}

	public String getCodice2() {
		return codice2;
	}

	public void setCodice2(String codice2) {
		this.codice2 = codice2;
	}

	public String getCodice3() {
		return codice3;
	}

	public void setCodice3(String codice3) {
		this.codice3 = codice3;
	}

	public String getNomeITA() {
		return nomeITA;
	}

	public void setNomeITA(String nomeITA) {
		this.nomeITA = nomeITA;
	}

	@Override
	public String toString() {
		return "Paesi{" +
				"nomeENG='" + nomeENG + '\'' +
				", codice2='" + codice2 + '\'' +
				", codice3='" + codice3 + '\'' +
				", nomeITA='" + nomeITA + '\'' +
				'}';
	}
}
