package com.corso.converters;

import com.corso.model.Utente;
import com.corso.vo.FormRegistrazione;
import org.springframework.beans.BeanUtils;
import org.apache.commons.codec.digest.DigestUtils;

public class ConverterFormRegistrazioneToUtente {

    public static Utente converterFormRegistrazioneToUtente(FormRegistrazione registrazione){
        Utente utente = new Utente();
        BeanUtils.copyProperties(registrazione, utente);
        utente.setPassword(DigestUtils.md5Hex(utente.getPassword()));
        return utente;
    }
}
