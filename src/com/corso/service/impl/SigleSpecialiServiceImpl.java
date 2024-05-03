package com.corso.service.impl;

import com.corso.bean.Paese;
import com.corso.bean.PaeseSpeciale;
import com.corso.dao.PaesiDAO;
import com.corso.dao.SigleSpecialiDAO;
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
    public PaeseSpeciale addSigla(PaeseSpeciale paese) {
        return dao.add(paese);
    }

    @Override
    public PaeseSpeciale findPaese(Integer id) {
        return dao.find(id);
    }


}
