package com.corso.dao.impl;

import com.corso.dao.UtenteDAO;
import com.corso.model.Utente;

import javax.persistence.*;
import java.sql.SQLException;
import java.util.List;

public class UtenteDAOimpl implements UtenteDAO {

    @PersistenceContext
    EntityManager manager;

    @Override
    public Utente getByEmail(String email) {
        /*System.out.println("Dao , Argument email :  " +email);
        //Utente utente = (Utente) manager.find(Utente.class,email) ;
        try {
            TypedQuery<Utente> query = manager.createQuery("SELECT u FROM Utente u WHERE u.email = :email",Utente.class) ;
            query.setParameter("email",email) ;
           System.out.println("result of the query is " +query.getSingleResult() );
         return query.getSingleResult();
        }
        catch (NoResultException e) {
          System.out.println("Error , msg : " +e);
            return new Utente(null,null) ;

        }*/
        Utente utente =  manager.find(Utente.class,email);
        return utente;
    }


    @Override
    public void add(Utente utente) {
        manager.persist(utente);
        /*Utente cercaUtente = manager.find(Utente.class,utente.getEmail()) ;
        if (!(cercaUtente == null)) {
            System.out.println("Utente con email : " +utente.getEmail() + " è stato inserito correttamente nel sistema");
            return  true ;
        }
        else  {
            System.out.println("Utente con email : " +utente.getEmail() + " non è stato inserito correttamente nel sistema");
            return false ;
        }*/
    }

    @Override
    public void update(Utente utente) {
        manager.merge(utente) ;
    }

//    @Override
//    public boolean update(Utente utente) {
//        Utente utenteVecchio = manager.find(Utente.class, utente.getEmail()) ;
//        manager.merge(utente);
//        boolean sonoUguali = manager.find(Utente.class,utente.getEmail()).equals(utenteVecchio) ;
//        if (!sonoUguali ) {
//            System.out.println("Utente con email : " +utente.getEmail() + " è stato modificato correttamente");
//            return true ;
//        }
//        else {
//            System.out.println("Utente con email : " +utente.getEmail() + " non è stato modificato correttamente");
//            return false ;
//        }
//    }

    @Override
    public void delete(Utente utente) {
        manager.remove(utente);
    }
}
