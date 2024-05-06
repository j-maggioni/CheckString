package com.corso.model;

import com.sun.istack.NotNull;
import javax.persistence.*;
import java.util.Date;

@Entity(name = "ricerche_recenti")
@NamedQueries({
		@NamedQuery(
				name = "RicercheRecenti.findInput",
				query = "SELECT rr FROM ricerche_recenti rr WHERE rr.input = :input"
		)
})

public class RicercheRecenti {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="data_inserimento")
	private String data_inserimento;

	@Column(name="input")
	private String input;

	@Column(name="standard")
	private String standard;

	@Column(name="algoritmo")
	private String algortimo;

	@Column(name="approvazione")
	private boolean approvazione;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDataInserimento() {
		return data_inserimento;
	}

	public void setDataInserimento(String dataInserimento) {
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

	public boolean getApprovazione() {
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
