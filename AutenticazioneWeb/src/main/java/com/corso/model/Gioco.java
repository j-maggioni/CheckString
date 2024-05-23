package com.corso.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "giochi")
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "Gioco.findAll",
                query = "SELECT * FROM giochi WHERE",
                resultClass = Gioco.class
        ),
        @NamedNativeQuery(
                name = "Gioco.findAllBest",
                query = "SELECT * FROM utenti.giochi ORDER BY punti DESC LIMIT 3; ;",
                resultClass = Gioco.class
        ),
        @NamedNativeQuery(
                name = "Gioco.findAllPerUser",
                query = "SELECT * FROM giochi WHERE utente=:utente ;",
                resultClass = Gioco.class
        ),
        @NamedNativeQuery(
                name = "Gioco.findBestPerUser",
                query = "SELECT * FROM utenti.giochi WHERE utente=:utente ORDER BY punti DESC LIMIT 3; ;",
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

    @OneToOne
    @JoinColumn(name="utente", referencedColumnName = "email")
    private Utente utente;

    public Gioco() {

    }

    public Gioco(Integer id, String data, int punti, Utente utente) {
        this.id = id;
        this.data = data;
        this.punti = punti;
        this.utente = utente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
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
}

