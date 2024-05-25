package com.corso.converters;

import com.corso.model.Gioco;
import com.corso.model.Utente;
import com.corso.vo.GiocoVO;
import org.springframework.beans.BeanUtils;

public class ConverterFromGiocoVoToGioco {

    public static Gioco convertGiocoVoToGioco(GiocoVO giocoVO, Utente utente){
        Gioco gioco = new Gioco();

        BeanUtils.copyProperties(giocoVO, gioco);
        gioco.setUtente(utente);

        return gioco;
    }
}
