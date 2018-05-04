package com.zonesun.daiqian.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/7/11 0011.
 */
public class CardBinRoot implements Serializable {

    String total;
    String page;
    String totalSize;
    List<CardBinmsg> rows;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }


    public String getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(String totalSize) {
        this.totalSize = totalSize;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public List<CardBinmsg> getRows() {
        return rows;
    }

    public void setRows(List<CardBinmsg> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "CardBinRoot{" +
                "totalSize='" + totalSize + '\'' +
                ", page='" + page + '\'' +
                ", total='" + total + '\'' +
                '}';
    }
}
