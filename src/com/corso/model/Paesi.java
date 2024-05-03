package com.corso.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity(name = "paesi")

//TODO: aggiungere namedQuery

public class Paesi {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)   // AUTO: genera il valore Hibernate
	private Integer id;

	@Column(name="nome")
	@NotNull
	private String nome;

	@Column(name="codice2", length = 2, unique = true)
	@NotNull
	private String codice2;

	@Column(name="codice3", length = 3, unique = true)
	@NotNull
	private String codice3;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodice2() {
		return codice2;
	}

	public void setCodice2(String codice2) {
		this.codice2 = codice2;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodice3() {
		return codice3;
	}

	public void setCodice3(String codice3) {
		this.codice3 = codice3;
	}

	@Override
	public String toString() {
		return "Paesi{" +
				"id=" + id +
				", nome='" + nome + '\'' +
				", codice2='" + codice2 + '\'' +
				", codice3='" + codice3 + '\'' +
				'}';
	}
}
