package com.corso.vo;

import javax.validation.constraints.*;

public class FormRegistrazione {
    @NotNull(message = "inserisci un nome")
    private String nome;

    @NotNull(message = "inserisci un cognome")
    private String cognome;

    @NotNull
    @Pattern(regexp = "/^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$/", message = "Inserisci una e-mail valida")
    private String email;

    @NotNull
    @Pattern(regexp = "/^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$/",
            message = "Inserisci una password valida")
    private String password;

    @NotNull
    private String confermaPassword;

    @AssertTrue(message = "Le password non corrispondono")
    private boolean isValidPassword() {
        return password.equals(confermaPassword);
    }

    @NotNull(message = "inserisci una nazione")
    private String nazione;

    @NotNull
    @Pattern(regexp = "^(\\d{3,4}\\s?){2,3}\\d{3,4}$", message = "Inserisci un numero di telefono valido")
    private String telefono;

    @NotNull
    @Pattern(regexp = "^(\\+\\d{1,3}\\s?)$", message = "Inserisci un numero di telefono valido")
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
