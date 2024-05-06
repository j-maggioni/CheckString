package com.corso.service;

import com.corso.dao.RankingAlgoritmiDAO;
import com.corso.model.RankingAlgoritmi;

import java.util.List;

public interface RankingAlgoritmiService {

    public void setDao(RankingAlgoritmiDAO rankingAlgoritmiDAO);

    public void addAlgoritmo(RankingAlgoritmi algoritmo);
    public void updateOccorrenzeAlgoritmo(String algoritmo);
    public List<RankingAlgoritmi> getAlgoritmi();
    public List<RankingAlgoritmi> getAlgoritmiAttivi();
    public boolean findAlgoritmo(RankingAlgoritmi algoritmo);
    public void changeAlgorithmActivation(String algoritmo, boolean attivo);
}
