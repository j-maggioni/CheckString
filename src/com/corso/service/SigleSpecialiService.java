package com.corso.service;

import com.corso.dao.PaesiDAO;
import com.corso.dao.SigleSpecialiDAO;
import com.corso.model.SigleSpeciali;

import java.util.List;

public interface SigleSpecialiService {

    public void setDao(SigleSpecialiDAO sigleSpecialiDAO);

    public SigleSpeciali addSigla(SigleSpeciali paese);
    public SigleSpeciali findPaese(Integer id);

}
