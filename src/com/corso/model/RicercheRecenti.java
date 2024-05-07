package com.corso.model;

import com.sun.istack.NotNull;
import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@Entity(name = "ricerche_recenti")
@NamedNativeQueries({
		@NamedNativeQuery(
				name = "RicercheRecenti.findInput",
				query = "SELECT * FROM ricerche_recenti WHERE input=:input ",
				resultClass = RicercheRecenti.class
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

	public RicercheRecenti() {
	}

	public RicercheRecenti(String input, String standard, String algortimo) {
		setDataInserimento();
		this.input = input;
		this.standard = standard;
		this.algortimo = algortimo;
		this.approvazione = false;
	}

	public Integer getId() {
		return id;
	}

	public String getDataInserimento() {
		return data_inserimento;
	}

	private void setDataInserimento() {
		//this.data_inserimento = dataInserimento;
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		this.data_inserimento = dateFormat.format(currentDate);
	}

	public String getInput() {
		return input;
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
