package com.corso.model;

import com.corso.dao.impl.PaesiDAOimpl;
import com.sun.istack.NotNull;
import org.springframework.cglib.proxy.Factory;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.*;
import java.sql.SQLException;

@Entity(name = "paesi")
@NamedNativeQueries({
		@NamedNativeQuery(
				name = "Paesi.init",
				query = "SELECT Code as codice3,Code2 as codice2, Name as nome " +
						"FROM world.country",
						//"WHERE NOT EXISTS (SELECT 1 FROM checkstring.paesi);",
				resultClass = Paesi.class),

		@NamedNativeQuery(name = "Paesi.All",
				query = "SELECT * FROM paesi ",
				resultClass = Paesi.class),

		@NamedNativeQuery(name = "Paesi.ByCode2",
				query = "SELECT * FROM paesi WHERE codice2 = :codice2 ",
				resultClass = Paesi.class) ,

		@NamedNativeQuery(name = "Paesi.ByCode3",
				query = "SELECT * FROM paesi WHERE codice3 = :codice3 ;",
				resultClass = Paesi.class)
})

public class Paesi {

//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)    // AUTO: genera il valore Hibernate
//	private Integer id;


	@Column(name="nome")
	//@NotNull
	private String nome;

	@Id
	@Column(name="codice2")
	private String codice2;

	@Column(name="codice3")
	private String codice3;

//	@Transactional
//	static private void initPaese () throws SQLException {
//		PaesiDAOimpl dao = new PaesiDAOimpl() ;
//		dao.initPaesi() ;
//	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public Paesi() {

	}
	public Paesi(String nome, String codice2, String codice3) {
		this.nome = nome;
		this.codice2 = codice2;
		this.codice3 = codice3 ;
	}

	@Override
	public String toString() {
		return "Paesi{" +
				"nome='" + nome + '\'' +
				", codice2='" + codice2 + '\'' +
				", codice3='" + codice3 + '\'' +
				'}';
	}
}
