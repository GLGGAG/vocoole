package com.vocoole.service;

import org.springframework.stereotype.Service;
import vocoole.commonTo.NearbyMallTo;

import java.util.List;

/**
 * @author GLGGAG
 * @date 2018-04-04 15:17
 * @Description:
 */
@Service
public class MallService {


    /**
     *
     *
     * @param cityId 城市id
     */
    public List<NearbyMallTo> nearbyMallTos(int cityId){
        // TODO  从redis 中获取当前用户附近的商超

        return  null;
    }

}
