package com.corso.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users")
public class Utente {

    @Id
    @Column(unique = true)
    private String email;

    @Column
    private String password;

    @Column
    private String nome;

    @Column
    private String cognome;

    @Column
    private String nazione;

    @Column
    private String telefono;

    @Column
    private String prefisso;

    public Utente() {

    }

    public Utente(String email, String password, String nome, String cognome, String nazione,
                  String prefisso, String telefono) {
        this.email = email;
        this.password = password;
        this.nome = nome;
        this.cognome = cognome;
        this.nazione = nazione;
        this.telefono = telefono;
        this.prefisso = prefisso;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNazione() {
        return nazione;
    }

    public void setNazione(String nazione) {
        this.nazione = nazione;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPrefisso() {
        return prefisso;
    }

    public void setPrefisso(String prefisso) {
        this.prefisso = prefisso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Utente utente = (Utente) o;
        return Objects.equals(email, utente.email) && Objects.equals(password, utente.password)
                && Objects.equals(nome, utente.nome) && Objects.equals(cognome, utente.cognome)
                && Objects.equals(nazione, utente.nazione) && Objects.equals(telefono, utente.telefono)
                && Objects.equals(prefisso, utente.prefisso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password, nome, cognome, nazione, telefono, prefisso);
    }
}

