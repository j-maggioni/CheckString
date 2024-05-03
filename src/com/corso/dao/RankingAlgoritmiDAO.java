package com.corso.dao;

import com.corso.model.RankingAlgoritmi;

import javax.transaction.Transactional;
import java.util.List;

public interface RankingAlgoritmiDAO {

    @Transactional
    public RankingAlgoritmi add(RankingAlgoritmi algoritmo);

    @Transactional
    public void update(RankingAlgoritmi algoritmo);

    @Transactional
    public List<RankingAlgoritmi> all();

    @Transactional
    public RankingAlgoritmi find(String id);

    @Transactional
    public void truncate();

    @Transactional
    public void sortTable();
}
