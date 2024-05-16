package com.corso.dao;

import com.corso.model.Utente;

public interface UtenteDAO {
    public Utente getByEmail(String email);

    public void add(Utente utente);

    public void update(Utente utente);
}
