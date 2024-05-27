package com.corso.converters;

import com.corso.model.Utente;
import com.corso.vo.FormRegistrazione;
import com.corso.vo.FormUtenteModificato;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.BeanUtils;

public class ConverterFormModificaProfiloToUtente {

    public static Utente convert(FormUtenteModificato utenteModificato, String email){
        Utente utente = new Utente();
        BeanUtils.copyProperties(utenteModificato, utente);
        utente.setEmail(email);

        String password;
        if(utenteModificato.getPassword().isEmpty() && utenteModificato.getConfermaPassword().isEmpty()) {
            password = utente.getPassword();
        } else {
            password = DigestUtils.md5Hex(utente.getPassword());
        }
        utente.setPassword(password);
        return utente;
    }
}
