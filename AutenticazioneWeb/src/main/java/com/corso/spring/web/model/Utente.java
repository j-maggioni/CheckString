package com.corso.spring.web.model;

import javax.persistence.*;

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

        public Utente() {

        }

        public Utente(String email, String password, String nome, String cognome, String nazione, String telefono) {
            this.email = email;
            this.password = password;
            this.nome = nome;
            this.cognome = cognome;
            this.nazione = nazione;
            this.telefono = telefono;
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
    }

