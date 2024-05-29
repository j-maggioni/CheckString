package com.corso.model;

import javax.persistence.*;

@Entity
@Table(name = "giochi")
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "Gioco.findAll",
                query = "SELECT * FROM giochi WHERE gioco=:gioco ",
                resultClass = Gioco.class
        ),
        @NamedNativeQuery(
                name = "Gioco.findAllBest",
                query = "SELECT * FROM utenti.giochi WHERE gioco=:gioco ORDER BY punti DESC LIMIT 5 ;",
                resultClass = Gioco.class
        ),
        @NamedNativeQuery(
                name = "Gioco.findAllPerUser",
                query = "SELECT * FROM giochi WHERE utente=:utente AND gioco=:gioco ORDER BY data ;",
                resultClass = Gioco.class
        ),
        @NamedNativeQuery(
                name = "Gioco.findBestPerUser",
                query = "SELECT * FROM utenti.giochi WHERE utente=:utente AND gioco=:gioco ORDER BY punti DESC LIMIT 3; ;",
                resultClass = Gioco.class
        )
})
public class Gioco {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name="data")
    private String data;

    @Column(name="punti")
    private int punti;

    @ManyToOne
    @JoinColumn(name = "utente", referencedColumnName = "email", nullable = false)
    private Utente utente;

    @Column(name="gioco")
    private String gioco;

    public Gioco() {

    }

    public Gioco(String data, int punti, Utente utente, String gioco) {
        this.data = data;
        this.punti = punti;
        this.utente = utente;
        this.gioco = gioco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public java.lang.String getData() {
        return data;
    }

    public void setData(java.lang.String data) {
        this.data = data;
    }

    public int getPunti() {
        return punti;
    }

    public void setPunti(int punti) {
        this.punti = punti;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public String getGioco() {
        return gioco;
    }

    public void setGioco(String gioco) {
        this.gioco = gioco;
    }
}

