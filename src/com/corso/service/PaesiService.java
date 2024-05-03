package com.corso.service;

import com.corso.bean.Paese;
import com.corso.dao.PaesiDAO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PaesiService {

    public void setDao(PaesiDAO paesiDAO);
    public Paese findPaese(Integer id);
    public List<Paese> getPaesi();

}
