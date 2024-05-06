package com.corso.service.impl;

import com.corso.dao.PaesiDAO;
import com.corso.dao.SigleSpecialiDAO;
import com.corso.model.SigleSpeciali;
import com.corso.service.PaesiService;
import com.corso.service.SigleSpecialiService;

import java.util.List;

public class SigleSpecialiServiceImpl implements SigleSpecialiService {

    SigleSpecialiDAO dao = null;

    @Override
    public void setDao(SigleSpecialiDAO sigleSpecialiDAO) {
        dao = sigleSpecialiDAO;
    }

    @Override
    public SigleSpeciali addSigla(SigleSpeciali paese) {
        //return dao.add(paese);
        return null;
    }

    @Override
    public SigleSpeciali findPaese(Integer id) {
        return null;
    }

}
