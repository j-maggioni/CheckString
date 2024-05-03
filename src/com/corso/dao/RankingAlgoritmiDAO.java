package com.corso.dao;

import com.corso.bean.AlgoritmoEseguito;

import java.util.List;

public interface RankingAlgoritmiDAO {
    public AlgoritmoEseguito add(AlgoritmoEseguito algoritmo);

    public void update(AlgoritmoEseguito algoritmo);

    public List<AlgoritmoEseguito> all();

}
