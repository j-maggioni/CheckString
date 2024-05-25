package com.corso.converters;

import com.corso.model.Utente;
import com.corso.vo.UtenteVO;
import org.springframework.beans.BeanUtils;

public class ConverterFromUtenteToUtenteVO {

    public static UtenteVO convertUtenteToUtenteVO(Utente utente){
        UtenteVO utenteVO = new UtenteVO();
        BeanUtils.copyProperties(utente, utenteVO);
        return utenteVO;
    }
}
