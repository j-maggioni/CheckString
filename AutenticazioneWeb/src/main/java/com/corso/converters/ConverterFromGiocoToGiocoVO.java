package com.corso.converters;

import com.corso.model.Gioco;
import com.corso.vo.GiocoVO;
import org.springframework.beans.BeanUtils;

public class ConverterFromGiocoToGiocoVO {

    public static GiocoVO convertGiocoToGiocoVO(Gioco gioco){
        GiocoVO giocoVO = new GiocoVO();
        BeanUtils.copyProperties(gioco, giocoVO);
        return giocoVO;
    }
}
