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
        RankingAlgoritmi existingAlgoritmo = dao.find(algoritmo.getNome());
        if(algoritmo != null && existingAlgoritmo == null){
            dao.add(algoritmo);
        } else {
            if(algoritmo.getNome().equalsIgnoreCase(existingAlgoritmo.getNome())) {
                existingAlgoritmo.setOccorrenze(algoritmo.getOccorrenze());
                existingAlgoritmo.setEsatti(algoritmo.getEsatti());
                existingAlgoritmo.setTotali(algoritmo.getTotali());
                existingAlgoritmo.setScore();
                existingAlgoritmo.setAttivo(algoritmo.isAttivo());
                dao.update(existingAlgoritmo);
            }
        }
    }

    @Override
    public void updateOccorrenzeAlgoritmo(String algoritmo) {
        if(!algoritmo.isEmpty()){
            RankingAlgoritmi alg = dao.find(algoritmo);
            if(alg != null){
                alg.setOccorrenze(alg.getOccorrenze()+1);
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
    public RankingAlgoritmi findAlgoritmo(String algoritmo) {
        if (!algoritmo.isEmpty()){
            return dao.find(algoritmo);
        }
        return null;
    }

    @Override
    public void changeAlgorithmActivation (String algoritmo, boolean attivo) {
        if(!algoritmo.isEmpty()){
            RankingAlgoritmi alg = dao.find(algoritmo);
            if(alg != null && attivo){
                dao.attivaAlgoritmo(algoritmo);
            } else {
                dao.disattivaAlgoritmo(algoritmo);
            }
        }
    }

}
