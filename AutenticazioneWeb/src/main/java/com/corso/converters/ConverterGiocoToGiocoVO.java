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
        return giocoVO;
    }

    public static List<GiocoVO> convertList(List<Gioco> giochi){
        List<GiocoVO> giocoVOList = new ArrayList<GiocoVO>();
        for(Gioco gioco: giochi) {
            GiocoVO giocoVO = new GiocoVO();
            BeanUtils.copyProperties(gioco, giocoVO);
            giocoVOList.add(giocoVO);
        }
        return giocoVOList;
    }
}
