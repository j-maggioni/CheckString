package com.corso.standard;

import com.corso.config.Beans;
import com.corso.model.Paesi;
import com.corso.service.PaesiService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBParoleStandard implements ParoleStandard {
	private ArrayList<Standard> paroleStandard;

    private static BeanFactory factory;
    private static PaesiService servicePaesi;

    static {
        factory = new AnnotationConfigApplicationContext(Beans.class);
        servicePaesi = factory.getBean("paesiService", PaesiService.class);
    }

    public DBParoleStandard() throws Exception {
        readStandards();
    }

	private List<Standard> readStandards() throws SQLException {
        List<Paesi> paesi = servicePaesi.findAll();

        for (Paesi paese: paesi){
            paroleStandard.add(new Standard(paese.getCodice2(),paese.getNomeENG()));
        }
        return paroleStandard;
	}


    @Override
    public List<Standard> getStandards() {
        return paroleStandard;
    }
}
