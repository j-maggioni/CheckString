package com.corso.dao;

import com.corso.bean.Bean;
import com.corso.bean.PaeseSpeciale;

public interface SigleSpecialiDAO {
    public PaeseSpeciale add(PaeseSpeciale categoria);

    public PaeseSpeciale find(Integer id);


}
