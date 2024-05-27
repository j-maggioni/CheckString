package com.corso.converters;

import com.corso.model.Utente;
import com.corso.vo.UtenteVO;
import org.springframework.beans.BeanUtils;

public class ConverterUtenteVOToUtente {

    public static Utente convert(UtenteVO utenteVO){
        Utente utente = new Utente();
        BeanUtils.copyProperties(utenteVO, utente);
        return utente;
    }
}
