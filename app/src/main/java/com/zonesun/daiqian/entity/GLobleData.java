package com.zonesun.daiqian.entity;

import com.zonesun.daiqian.entity.RuHuSurveyEntity.VisitalrearyEntity;
import com.zonesun.daiqian.entity.addresses.ProvinceAddress;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class GLobleData implements Serializable {

    public static List<DataChild> list = new ArrayList<DataChild>();
    public static LoginReturn logindata;
    public static HashMap<String, String> map = new HashMap<String, String>();
    public static String VideoPath;
    public static List<String> imgurllist = new ArrayList<String>();
    public static List<VisitalrearyEntity> visityetalrearyList;
    public static List<CardBinmsg> cardbinmsglist = new ArrayList<CardBinmsg>();
    public static String DeviceBrand = "alps";//设备品牌
    public static String Devicemodel = "T80V2";//设备类型
    //public static List<ProvinceAddress> addresslist = new ArrayList<ProvinceAddress>();

}
