package com.corso.converters;

import com.corso.model.Gioco;
import com.corso.vo.GiocoVO;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class ConverterGiocoToGiocoVO {

    public static GiocoVO convert(Gioco gioco){
        GiocoVO giocoVO = new GiocoVO();
        BeanUtils.copyProperties(gioco, giocoVO);
        giocoVO.setUtente(gioco.getUtente().getEmail());
        return giocoVO;
    }

    public static List<GiocoVO> convertList(List<Gioco> giochi){
        List<GiocoVO> giocoVOList = new ArrayList<GiocoVO>();
        for(Gioco gioco: giochi) {
            giocoVOList.add(convert(gioco));
        }
        return giocoVOList;
    }
}
