package com.corso.vo;

import java.util.Objects;


public class UtenteVO {

    private String email;

    private String password;

    private String nome;

    private String cognome;

    private String nazione;

    private String telefono;

    private String prefisso;

    public UtenteVO() {

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
        UtenteVO utente = (UtenteVO) o;
        return Objects.equals(email, utente.email) && Objects.equals(password, utente.password)
                && Objects.equals(nome, utente.nome) && Objects.equals(cognome, utente.cognome)
                && Objects.equals(nazione, utente.nazione) && Objects.equals(telefono, utente.telefono)
                && Objects.equals(prefisso, utente.prefisso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password, nome, cognome, nazione, telefono, prefisso);
    }

    @Override
    public String toString() {
        return "UtenteVO{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", nazione='" + nazione + '\'' +
                ", telefono='" + telefono + '\'' +
                ", prefisso='" + prefisso + '\'' +
                '}';
    }
}

