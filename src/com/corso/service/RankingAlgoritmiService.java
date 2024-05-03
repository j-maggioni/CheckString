package com.corso.service;

import com.corso.bean.AlgoritmoEseguito;
import com.corso.bean.PaeseSpeciale;
import com.corso.dao.RankingAlgoritmiDAO;
import com.corso.dao.SigleSpecialiDAO;

import java.util.List;

public interface RankingAlgoritmiService {

    public void setDao(RankingAlgoritmiDAO rankingAlgoritmiDAO);

    public AlgoritmoEseguito addAlgoritmo(AlgoritmoEseguito algoritmo);
    public void updateRankingAlgoritmi(AlgoritmoEseguito algoritmo);
    public List<AlgoritmoEseguito> getAlgoritmi();

}
