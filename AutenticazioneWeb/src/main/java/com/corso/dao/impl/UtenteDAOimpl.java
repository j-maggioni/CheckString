package com.corso.dao.impl;

import com.corso.dao.UtenteDAO;
import com.corso.model.Utente;

import javax.persistence.*;
import java.sql.SQLException;

public class UtenteDAOimpl implements UtenteDAO {

    @PersistenceContext
    EntityManager manager;

    @Override
    public Utente getByEmail(String email) {
        System.out.println("Dao , Argument email :  " +email);
        //Utente utente = (Utente) manager.find(Utente.class,email) ;
        try {
            TypedQuery<Utente> query = manager.createQuery("SELECT u FROM Utente u WHERE u.email = :email",Utente.class) ;
            query.setParameter("email",email) ;
           System.out.println("result of the query is " +query.getSingleResult() );
         return query.getSingleResult();
        }
        catch (NoResultException e) {
          System.out.println("Error , msg : " +e);
        }
        return new Utente(null,null) ;
    }

    @Override
    public void add(Utente utente) {
        manager.persist(utente);
    }

    @Override
    public void update(Utente utente) {
        manager.merge(utente);
    }
}
