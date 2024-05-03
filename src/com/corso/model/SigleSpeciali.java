package com.corso.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity(name = "sigle_speciali")
//TODO: aggiungere namedNativeQuery
//@Table (name="sigle_speciali")
//@NamedNativeQuery(name="Categoria.CountDescrizioneSQL",
//		query=" select descrizione, count(descrizione) as cd "
//				+ "	from categoria "
//				+ " where nome like :nome"
//				+ "	group by (descrizione)"
//				+ "	having cd >= 1"
//				+ "	order by cd"
//				+ " limit 2")

// PER RICHIAMARE QUERY IN SigleSpecialiDAOimpl
// Query query = manager.createNamedQuery("Categoria.CountDescrizione");
//query.setParameter("nome", "%Nome%" );
//List<Object[]> results = query.getResultList();
//return results;

public class SigleSpeciali {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)   // AUTO: genera il valore Hibernate
	private Integer id;

	@Column(name = "sigla", unique = true)
	@NotNull
	private String sigla;

	@Column(name = "paese")
	@NotNull
	private String paese;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getPaese() {
		return paese;
	}

	public void setPaese(String paese) {
		this.paese = paese;
	}

	@Override
	public String toString() {
		return "PaesiSpeciali{" +
				"id=" + id +
				", sigla='" + sigla + '\'' +
				", paese='" + paese + '\'' +
				'}';
	}
}