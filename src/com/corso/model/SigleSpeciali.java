package com.corso.model;

import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.sql.DataSource;
import java.util.List;



// PER RICHIAMARE QUERY IN SigleSpecialiDAOimpl
// Query query = manager.createNamedQuery("Categoria.CountDescrizione");
//query.setParameter("nome", "%Nome%" );
//List<Object[]> results = query.getResultList();
//return results;
@Entity
@Table(name = "sigle_speciali")
@NamedNativeQueries({
		@NamedNativeQuery(name = "SigleSpeciali.BySigla",
				query = "SELECT * FROM sigle_speciali  WHERE sigla = :siglaInput ;",
				resultClass = SigleSpeciali.class),
		@NamedNativeQuery(name = "SigleSpeciali.ById",
				query = "SELECT * FROM sigle_speciali WHERE id = :id ;",
				resultClass = SigleSpeciali.class),
		@NamedNativeQuery(name = "SigleSpeciali.All",
				query = "SELECT * FROM sigle_speciali ;",
				resultClass = SigleSpeciali.class)
		// SELECT s FROM SigleSpeciali s
})

public class SigleSpeciali {


	//
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "sigla", unique = true)
	@NotNull
	private String sigla;

	@Column(name = "paese")
	@NotNull
	private String paese;

	public SigleSpeciali(String sigla, String paese) {
		this.sigla = sigla;
		this.paese = paese;
	}
	public SigleSpeciali() {

	}


	public Integer getId() {
		return id;
	}

//	public void setId(Integer id) {
//		this.id = id;
//	}

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