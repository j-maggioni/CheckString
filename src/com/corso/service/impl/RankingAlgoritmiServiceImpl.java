package com.corso.service.impl;

import com.corso.dao.RankingAlgoritmiDAO;
import com.corso.dao.SigleSpecialiDAO;
import com.corso.model.RankingAlgoritmi;
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
    public RankingAlgoritmi addAlgoritmo(RankingAlgoritmi algoritmo) {
        return dao.add(algoritmo);
    }

    @Override
    public void updateRankingAlgoritmi(RankingAlgoritmi algoritmo) {
        dao.update(algoritmo);
    }

    @Override
    public List<RankingAlgoritmi> getAlgoritmi() {
        return dao.all();
    }

    @Override
    public void truncateRankingTable() {
        dao.truncate();
    }

    @Override
    public void sortRankingTable() {
        dao.sortTable();
    }
}
