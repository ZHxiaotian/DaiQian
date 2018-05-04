package com.zonesun.daiqian.entity;

/**
 * Created by Administrator on 2017/10/12 0012.
 */

public class CardResult {

    private PhotoResult result;
    private String reason;
    private String error_code;

    public PhotoResult getResult() {
        return result;
    }

    public void setResult(PhotoResult result) {
        this.result = result;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }
}
