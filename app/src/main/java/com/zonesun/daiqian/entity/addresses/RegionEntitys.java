package com.zonesun.daiqian.entity.addresses;

import java.util.List;

/**
 * Created by Administrator on 2018/1/25 0025.
 */

public class RegionEntitys {

//    "code":"110100",
//            "region":"市辖区",
//            "regionEntitys":[

       private String code ;
       private String region;
       private List<County> regionEntitys;

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

    public List<County> getRegionEntitys() {
        return regionEntitys;
    }

    public void setRegionEntitys(List<County> regionEntitys) {
        this.regionEntitys = regionEntitys;
    }

    @Override
    public String toString() {
        return "RegionEntitys{" +
                "code='" + code + '\'' +
                ", region='" + region + '\'' +
                ", regionEntitys=" + regionEntitys +
                '}';
    }
}
