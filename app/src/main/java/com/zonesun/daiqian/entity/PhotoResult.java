package com.zonesun.daiqian.entity;

/**
 * Created by Administrator on 2017/10/12 0012.
 */

public class PhotoResult {


   private String idcard;
    private boolean isok;
    private String idCardPhoto;
    private  IdCardInfo IdCardInfor ;

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public boolean isok() {
        return isok;
    }

    public void setIsok(boolean isok) {
        this.isok = isok;
    }

    public String getIdCardPhoto() {
        return idCardPhoto;
    }

    public void setIdCardPhoto(String idCardPhoto) {
        this.idCardPhoto = idCardPhoto;
    }

    public IdCardInfo getIdCardInfor() {
        return IdCardInfor;
    }

    public void setIdCardInfor(IdCardInfo idCardInfor) {
        IdCardInfor = idCardInfor;
    }
}
