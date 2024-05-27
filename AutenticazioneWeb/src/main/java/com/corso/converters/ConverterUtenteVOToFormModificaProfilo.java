package com.corso.converters;


import com.corso.vo.FormUtenteModificato;
import com.corso.vo.UtenteVO;
import org.springframework.beans.BeanUtils;

public class ConverterUtenteVOToFormModificaProfilo {

    public static FormUtenteModificato convert(UtenteVO utenteVO){
        FormUtenteModificato utenteModificato = new FormUtenteModificato();
        BeanUtils.copyProperties(utenteVO, utenteModificato);
        utenteModificato.setPassword("");
        utenteModificato.setConfermaPassword("");
        return utenteModificato;
    }
}
