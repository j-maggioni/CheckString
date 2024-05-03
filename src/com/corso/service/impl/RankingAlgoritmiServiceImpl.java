package com.corso.service.impl;

import com.corso.bean.AlgoritmoEseguito;
import com.corso.bean.PaeseSpeciale;
import com.corso.dao.RankingAlgoritmiDAO;
import com.corso.dao.SigleSpecialiDAO;
import com.corso.service.RankingAlgoritmiService;
import com.corso.service.SigleSpecialiService;

import java.util.List;

public class RankingAlgoritmiServiceImpl implements RankingAlgoritmiService {

    RankingAlgoritmiDAO dao = null;


    @Override
    public void setDao(RankingAlgoritmiDAO rankingAlgoritmiDAO) {
        dao = rankingAlgoritmiDAO;
    }

    @Override
    public AlgoritmoEseguito addAlgoritmo(AlgoritmoEseguito algoritmo) {
        return dao.add(algoritmo);
    }

    @Override
    public void updateRankingAlgoritmi(AlgoritmoEseguito algoritmo) {
        dao.update(algoritmo);
    }

    @Override
    public List<AlgoritmoEseguito> getAlgoritmi() {
        return dao.all();
    }
}
