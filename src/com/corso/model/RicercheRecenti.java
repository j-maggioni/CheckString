package com.corso.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "ricerche_recenti")
//TODO: aggiungere namedQuery
public class RicercheRecenti {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)   // AUTO: genera il valore Hibernate
	private Integer id;

	@Column(name="data_inserimento")
	@NotNull
	private Date data_inserimento;

	@Column(name="input")
	@NotNull
	private String input;

	@Column(name="standard")
	@NotNull
	private String standard;

	@Column(name="algoritmo")
	@NotNull
	private String algortimo;

	@Column(name="approvazione")
	@NotNull
	private boolean approvazione;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataInserimento() {
		return data_inserimento;
	}

	public void setDataInserimento(Date dataInserimento) {
		this.data_inserimento = dataInserimento;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public String getAlgortimo() {
		return algortimo;
	}

	public void setAlgortimo(String algortimo) {
		this.algortimo = algortimo;
	}

	public boolean isApprovazione() {
		return approvazione;
	}

	public void setApprovazione(boolean approvazione) {
		this.approvazione = approvazione;
	}

	@Override
	public String toString() {
		return "RicercheRecenti{" +
				"id=" + id +
				", data=" + data_inserimento +
				", input='" + input + '\'' +
				", standard='" + standard + '\'' +
				", algortimo='" + algortimo + '\'' +
				", approvazione=" + approvazione +
				'}';
	}
}
