package com.corso.dao;

import com.corso.bean.Bean;
import com.corso.bean.Paese;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface PaesiDAO {
    public Paese find(Integer id);

    public List<Paese> all();

}
