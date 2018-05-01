package com.vocoole.controller;

import com.vocoole.bo.NearbyMallBo;
import com.vocoole.service.MallService;
import com.vocoole.support.message.RespMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author GLGGAG
 * @date 2018-04-04 14:49
 * @Description:
 * 商城类
 */
@RestController("mall")
public class Mall {

    @Autowired
    private MallService mallService;


    /**
     *  计算当前用户所在的城市的 商超与用户的距离
     * @param cityId 城市id
     * @param longitude 经度
     * @param latitude 纬度
     */
    @RequestMapping("nearby")
    public RespMsg<NearbyMallBo> nearbyMall(double cityId,double longitude,double latitude){








        return  null;

    }




}
