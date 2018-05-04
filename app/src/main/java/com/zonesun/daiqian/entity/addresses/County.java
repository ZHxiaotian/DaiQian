package com.zonesun.daiqian.entity.addresses;

/**
 * Created by Administrator on 2018/1/25 0025.
 */

public class County {


//                        "code":"110105",
//                                "region":"朝阳区"

    private String code;
    private String region;

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

    @Override
    public String toString() {
        return "County{" +
                "code='" + code + '\'' +
                ", region='" + region + '\'' +
                '}';
    }
}
