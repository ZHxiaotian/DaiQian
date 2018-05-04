package com.zonesun.daiqian.entity;

/**
 * Created by Administrator on 2017/10/12 0012.
 */

public class GetIdCardInfo {


//    code": "10000",
//            "charge": true,
//            "msg": "查询成功,扣费",

      private String code;
      private String charge;
      private String  msg;
      private CardResult result;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public CardResult getResult() {
        return result;
    }

    public void setResult(CardResult result) {
        this.result = result;
    }
}
