package com.corso.bean;

public class PaeseSpeciale implements Bean{

	private Integer id;
	private String sigla;
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
		return "PaeseSpeciale[" +
				"id=" + id +
				", sigla='" + sigla + '\'' +
				", paese='" + paese + '\'' +
				']';
	}
}