package com.corso.vo;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class FormRegistrazione {
    @NotEmpty(message = "Inserisci un nome")
    private String nome;

    @NotEmpty(message = "Inserisci un cognome")
    private String cognome;

    @NotEmpty
    @Pattern(regexp = "^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$", message = "Inserisci una e-mail valida")
    private String email;

    @NotEmpty
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "La password deve avere almeno 8 caratteri e contenere almeno una lettera maiuscola, "+
                    "minuscola, numero e carattere speciale")
    private String password;

    @NotEmpty
    private String confermaPassword;

    @AssertTrue(message = "Le password non corrispondono")
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

    @AssertTrue(message = "Devi accettare i termini e le condizioni per proseguire")
    private boolean accettaTermini;

    private String existingEmailError;

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

    public boolean isAccettaTermini() {
        return accettaTermini;
    }

    public void setAccettaTermini(boolean accettaTermini) {
        this.accettaTermini = accettaTermini;
    }

    public String getExistingEmailError() {
        return existingEmailError;
    }

    public void setExistingEmailError(String existingEmailError) {
        this.existingEmailError = existingEmailError;
    }

    @Override
    public String toString() {
        return "FormRegistrazioneFE{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", confermaPassword='" + confermaPassword + '\'' +
                ", nazione='" + nazione + '\'' +
                ", prefisso='" + prefisso + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
