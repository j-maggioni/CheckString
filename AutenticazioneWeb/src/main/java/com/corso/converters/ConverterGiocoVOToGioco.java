package com.corso.converters;

import com.corso.model.Gioco;
import com.corso.model.Utente;
import com.corso.vo.GiocoVO;
import org.springframework.beans.BeanUtils;

public class ConverterGiocoVOToGioco {

    public static Gioco convert(GiocoVO giocoVO, Utente utente){
        Gioco gioco = new Gioco();

        BeanUtils.copyProperties(giocoVO, gioco);
        gioco.setUtente(utente);

        return gioco;
    }
}
