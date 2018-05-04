package com.zonesun.daiqian.entity.addresses;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/1/25 0025.
 */

public class ProvinceAddress {
//
//     "code":"110000",
//             "region":"北京市",
//             "regionEntitys":[
      private String code;
      private String region;
      private ArrayList<RegionEntitys> regionEntitys;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public ArrayList<RegionEntitys> getRegionEntitys() {
        return regionEntitys;
    }

    public void setRegionEntitys(ArrayList<RegionEntitys> regionEntitys) {
        this.regionEntitys = regionEntitys;
    }

    @Override
    public String toString() {
        return "ProvinceAddress{" +
                "code='" + code + '\'' +
                ", region='" + region + '\'' +
                ", regionEntitys=" + regionEntitys +
                '}';
    }
}
