package com.corso.algoritmi;

import com.corso.dao.RankingAlgoritmiDAO;
import com.corso.service.RicercheRecentiService;
import com.corso.standard.FileParoleStandard;
import com.corso.standard.ParoleStandard;
import com.corso.standard.Standard;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.corso.config.Beans;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class CheckString {

    private CheckString next;

    public Esito check(String input){
        return checkInput(input);
    }

	public abstract Esito checkInput(String input);
    
	public void setNext(CheckString checkString){
		this.next = checkString;
    }

    protected CheckString getNext() {
        return next;
    }
 
    protected String getName() {
    	return this.getClass().getSimpleName();
    }

}