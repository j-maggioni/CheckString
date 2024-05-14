package com.corso.model;

import com.sun.istack.NotNull;

import javax.persistence.*;


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
})

public class SigleSpeciali {


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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