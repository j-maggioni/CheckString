package com.corso.service;

import com.corso.bean.Paese;
import com.corso.bean.PaeseSpeciale;
import com.corso.dao.PaesiDAO;
import com.corso.dao.SigleSpecialiDAO;

import java.util.List;

public interface SigleSpecialiService {

    public void setDao(SigleSpecialiDAO sigleSpecialiDAO);

    public PaeseSpeciale addSigla(PaeseSpeciale paese);
    public PaeseSpeciale findPaese(Integer id);

}
