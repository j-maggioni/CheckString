package com.corso.converters;

import com.corso.model.Utente;
import com.corso.vo.*;
import com.corso.vo.FormUtenteModificato;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.BeanUtils;

public class ConverterFormModificaPasswordToUtente {
    public static Utente convert(FormPasswordModificata form, Utente utente) {
        utente.setPassword(form.getPassword());
        utente.setPassword(DigestUtils.md5Hex(utente.getPassword()));
        return utente;
    }
}
