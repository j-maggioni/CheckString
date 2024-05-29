package com.corso.converters;

import com.corso.vo.FormPasswordModificata;
import com.corso.vo.FormUtenteModificato;
import com.corso.vo.UtenteVO;
import org.springframework.beans.BeanUtils;

public class ConverterUtenteVOToFormModificaPassword {

        public static FormPasswordModificata convert(UtenteVO utenteVO){
            FormPasswordModificata pswModificata = new FormPasswordModificata();
            BeanUtils.copyProperties(utenteVO, pswModificata);
            return pswModificata;
        }
}


