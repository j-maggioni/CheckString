package com.corso.dao;

import com.corso.model.Utente;

import java.util.ArrayList;
import java.util.List;

public interface UtenteDAO {
    public Utente getByEmail(String email);

    public void add(Utente utente);

    public void update(Utente utente);

    public void delete (Utente utente) ;
}
