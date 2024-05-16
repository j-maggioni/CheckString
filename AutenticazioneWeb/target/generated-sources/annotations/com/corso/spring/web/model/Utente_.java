package com.corso.spring.web.model;

import com.corso.model.Utente;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Utente.class)
public abstract class Utente_ {

	public static volatile SingularAttribute<Utente, String> password;
	public static volatile SingularAttribute<Utente, String> cognome;
	public static volatile SingularAttribute<Utente, String> nazione;
	public static volatile SingularAttribute<Utente, String> nome;
	public static volatile SingularAttribute<Utente, String> telefono;
	public static volatile SingularAttribute<Utente, String> email;

	public static final String PASSWORD = "password";
	public static final String COGNOME = "cognome";
	public static final String NAZIONE = "nazione";
	public static final String NOME = "nome";
	public static final String TELEFONO = "telefono";
	public static final String EMAIL = "email";

}

