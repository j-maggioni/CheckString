package com.corso.service;

import com.corso.dao.PaesiDAO;
import com.corso.model.Paesi;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PaesiService {

    public void setDao(PaesiDAO paesiDAO);
    public Paesi findPaese(Integer id);
    public List<Paesi> getPaesi();

}
