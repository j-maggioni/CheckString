package com.corso.converters;

import com.corso.model.Utente;
import com.corso.vo.UtenteVO;
import org.springframework.beans.BeanUtils;

public class ConverterUtenteToUtenteVO {

    public static UtenteVO convert(Utente utente){
        UtenteVO utenteVO = new UtenteVO();
        BeanUtils.copyProperties(utente, utenteVO);
        return utenteVO;
    }
}
