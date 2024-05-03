package com.corso.service;

import com.corso.dao.RankingAlgoritmiDAO;
import com.corso.model.RankingAlgoritmi;

import java.util.List;

public interface RankingAlgoritmiService {

    public void setDao(RankingAlgoritmiDAO rankingAlgoritmiDAO);

    public RankingAlgoritmi addAlgoritmo(RankingAlgoritmi algoritmo);
    public void updateRankingAlgoritmi(RankingAlgoritmi algoritmo);
    public List<RankingAlgoritmi> getAlgoritmi();
    public void truncateRankingTable();
    public void sortRankingTable();
}
