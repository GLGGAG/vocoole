package com.vocoole.util;

import static java.lang.Math.PI;

/**
 * @author GLGGAG
 * @date 2018-04-04 15:00
 * @Description:
 * 地理位置
 */
public class LocationU {

    private static final double R = 6378137;//地球半径

    /**
     * 计算地球上任意两点(经纬度)距离
     *
     * @param long1 第一点经度
     * @param lat1  第一点纬度
     * @param long2 第二点经度
     * @param lat2  第二点纬度
     * @return 返回距离 单位：米
     */
    public static double distanceByLongNLat(double long1, double lat1, double long2, double lat2) {
        double a, b;
        lat1 = lat1 * PI / 180.0;
        lat2 = lat2 * PI / 180.0;
        a = lat1 - lat2;
        b = (long1 - long2) * PI / 180.0;
        double d;
        double sa2, sb2;
        sa2 = Math.sin(a / 2.0);
        sb2 = Math.sin(b / 2.0);
        d = 2 * R * Math.asin(Math.sqrt(sa2 * sa2 + Math.cos(lat1) * Math.cos(lat2) * sb2 * sb2));
        return d;
    }

    /**
     * 根据经纬度和半径计算经纬度范围
     *
     * @param radius 单位米
     * @return minLat, minLng, maxLat, maxLng
     */
    public static double[] getAround(double lat, double lon, int radius) {

        Double latitude = lat;
        Double longitude = lon;

        Double degree = (24901 * 1609) / 360.0;

        Double dpmLat = 1 / degree;
        Double radiusLat = dpmLat * radius;
        Double minLat = latitude - radiusLat;
        Double maxLat = latitude + radiusLat;

        Double mpdLng = degree * Math.cos(latitude * (PI / 180));
        Double dpmLng = 1 / mpdLng;
        Double radiusLng = dpmLng * radius;
        Double minLng = longitude - radiusLng;
        Double maxLng = longitude + radiusLng;
        return new double[]{minLat, minLng, maxLat, maxLng};
    }

}
