package com.corso.model;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

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

	@OneToOne
	@JoinColumn (name="standard", referencedColumnName = "codice2")
	private Paesi standard;

	@OneToOne
	@JoinColumn(name="algoritmo", referencedColumnName = "nome")
	private RankingAlgoritmi algortimo;

	@Column(name="approvazione")
	private boolean approvazione;

	public RicercheRecenti() {
	}

	public RicercheRecenti(String input, Paesi standard, RankingAlgoritmi algortimo) {
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

	public Paesi getStandard() {
		return standard;
	}

	public void setStandard(Paesi standard) {
		this.standard = standard;
	}

	public RankingAlgoritmi getAlgortimo() {
		return algortimo;
	}

	public void setAlgortimo(RankingAlgoritmi algortimo) {
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
