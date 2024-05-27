package com.corso.vo;

import javax.validation.GroupSequence;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

interface EmptyPasswordValidator {}
interface MatchingPasswordValidator {}

@GroupSequence({FormUtenteModificato.class, EmptyPasswordValidator.class, MatchingPasswordValidator.class})
public class FormUtenteModificato {
    @NotEmpty(message = "Inserisci un nome")
    private String nome;

    @NotEmpty(message = "Inserisci un cognome")
    private String cognome;

    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "La password deve avere almeno 8 caratteri e contenere almeno una lettera maiuscola, una minuscola, un numero e un carattere speciale",
            groups = {EmptyPasswordValidator.class})
    private String password;

    @NotEmpty(groups = {MatchingPasswordValidator.class})
    private String confermaPassword;

    @AssertTrue(message = "Le password non corrispondono",
            groups = {MatchingPasswordValidator.class})
    private boolean isValidPassword() {
        return password.equals(confermaPassword);
    }

    @NotEmpty(message = "Inserisci una nazione")
    private String nazione;

    @NotEmpty
    @Pattern(regexp = "^(\\d{3,4}\\s?){2,3}\\d{3,4}$", message = "Inserisci un numero di telefono valido")
    private String telefono;

    @NotEmpty
    @Pattern(regexp = "(\\+\\d{1,3}\\s?)", message = "Inserisci un numero di telefono valido")
    private String prefisso;


    public String getNome() {
        return nome;
    }

    public void setNome (String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfermaPassword() {
        return confermaPassword;
    }

    public void setConfermaPassword(String confermaPassword) {
        this.confermaPassword = confermaPassword;
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
    public String toString() {
        return "FormUtenteModificato{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", password='" + password + '\'' +
                ", confermaPassword='" + confermaPassword + '\'' +
                ", nazione='" + nazione + '\'' +
                ", prefisso='" + prefisso + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
