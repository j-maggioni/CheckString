package com.corso.dao;

import com.corso.model.Paesi;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface PaesiDAO {
    public Paesi find(Integer id);

    public List<Paesi> all();

}
