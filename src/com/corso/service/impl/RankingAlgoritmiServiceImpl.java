package com.corso.service.impl;

import com.corso.dao.RankingAlgoritmiDAO;
import com.corso.model.RankingAlgoritmi;
import com.corso.service.RankingAlgoritmiService;

import java.util.List;

public class RankingAlgoritmiServiceImpl implements RankingAlgoritmiService {

    RankingAlgoritmiDAO dao = null;

    @Override
    public void setDao(RankingAlgoritmiDAO rankingAlgoritmiDAO) {
        dao = rankingAlgoritmiDAO;
    }

    @Override
    public void addAlgoritmo(RankingAlgoritmi algoritmo) {
        if(algoritmo != null && dao.find(algoritmo.getNome()) == null){
                dao.add(algoritmo);
        }
    }

    @Override
    public void updateOccorrenzeAlgoritmo(String algoritmo) {
        if(!algoritmo.isEmpty()){
            RankingAlgoritmi alg = dao.find(algoritmo);
            if(alg != null){
                alg.setOccorrenze();
                alg.setScore();
                dao.update(alg);
            }
        }
    }

    @Override
    public List<RankingAlgoritmi> getAlgoritmi() {
        return dao.all();
    }

    @Override
    public List<RankingAlgoritmi> getAlgoritmiAttivi() {
        return dao.algoritmiAttivi();
    }

    @Override
    public boolean findAlgoritmo(RankingAlgoritmi algoritmo) {
        if ((dao.all()).contains(algoritmo)){
            return true;
        }
        return false;
    }

    @Override
    public void changeAlgorithmActivation (String algoritmo, boolean attivo) {
        if(!algoritmo.isEmpty()){
            RankingAlgoritmi alg = dao.find(algoritmo);
            if(alg != null && !alg.isAttivo() && attivo){
                dao.attivaAlgoritmo(algoritmo);
            } else {
                dao.disattivaAlgoritmo(algoritmo);
            }
        }
    }

}
