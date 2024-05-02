package com.corso.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity

@Table (name="categoria")
@NamedQueries({
    @NamedQuery(name="Categoria.CountDescrizione",
                query="select descrizione, count(descrizione) as cd "
                	+ "	from Categoria "
                	+ " where nome like :nome" 
                	+ "	group by (descrizione)"
                	+ "	having count(descrizione) >= 1"
                	+ "	order by cd"
                	/*,lockMode = LockModeType.READ*/ )
})

@NamedNativeQuery(name="Categoria.CountDescrizioneSQL",
query=" select descrizione, count(descrizione) as cd "
	+ "	from categoria "
	+ " where nome like :nome" 
	+ "	group by (descrizione)"
	+ "	having cd >= 1"
	+ "	order by cd"
	+ " limit 2")

public class RicercheRecenti {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)   // AUTO: genera il valore Hibernate
	private Integer id; 
	
	@Column(name="nome", length = 20, unique = true)

	//@NotNull
	//@Size(min=2, max=30, message=" inserire almeno due caratteri e non superare i 30 caratteri")
	
	//@NotNull
	//@Pattern(regexp = "[a-zA-Z]{5}", message = "non rispetta il formato")
	private String nome; 

	
	@Column(name="descrizione")
	private String descrizione;
	
    private Integer version; // integer o timestamp 
	
	
	//@OneToMany(fetch = FetchType.EAGER, mappedBy = "categoria")
	//@Fetch(FetchMode.SELECT)
	//private List<Prodotto> prodotti; 

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
   
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	/*
	public List<Prodotto> getProdotti() {
		return prodotti;
	}

	public void setProdotti(List<Prodotto> prodotti) {
		this.prodotti = prodotti;
	}
*/
	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nome=" + nome + ", descrizione=" + descrizione + "]";
	}

	
	
}
