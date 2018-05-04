package com.zonesun.daiqian.util;

import com.zonesun.daiqian.entity.RuHuData;
import com.zonesun.daiqian.entity.RuHuSurveyEntity.VisitalrearyEntity;
import com.zonesun.daiqian.entity.RuHuSurveyEntity.VisityetEntity;

import java.util.ArrayList;

public class MyEvent {

	private VisitalrearyEntity visitalreadyEntity;// 已走访
	private VisityetEntity visityetEntity;// 未走访
	private VisitalrearyEntity myEntity;// 今日预约
	private ArrayList<String> listImagePath;// 身份证正面集合
	private RuHuData data;
	private boolean flag;
	private int flag1;
	private String result;
    private boolean isrefresh;
    
    private int NoCode;

	public MyEvent(String result, int noCode) {
		this.result = result;
		NoCode = noCode;
	}

	public RuHuData getData() {
		return data;
	}

	public void setData(RuHuData data) {
		this.data = data;
	}

	public MyEvent(RuHuData data, int flag1) {
		super();
		this.data = data;
		this.flag1 = flag1;
	}

	public MyEvent(String result) {
		super();
		this.result = result;
	}

	public MyEvent(boolean flag) {
		super();
		this.flag = flag;
	}

	public MyEvent(ArrayList<String> listImagePath) {
		super();
		this.listImagePath = listImagePath;
	}

	public MyEvent(VisitalrearyEntity visitalreadyEntity, int flag1) {
		super();
		this.visitalreadyEntity = visitalreadyEntity;
		this.flag1 = flag1;
	}

	public MyEvent(VisityetEntity visityetEntity, int flag1) {
		super();
		this.visityetEntity = visityetEntity;
		this.flag1 = flag1;

	}

	public MyEvent() {
		super();
	}

	public int getFlag1() {
		return flag1;
	}

	public void setFlag1(int flag1) {
		this.flag1 = flag1;
	}

	public int getNoCode() {
		return NoCode;
	}

	public void setNoCode(int noCode) {
		NoCode = noCode;
	}

	public VisitalrearyEntity getVisitalreadyEntity() {
		return visitalreadyEntity;
	}

	public VisityetEntity getVisityetEntity() {
		return visityetEntity;
	}

	public VisitalrearyEntity getMyEntity() {
		return myEntity;
	}

	public ArrayList<String> getListImagePath() {
		return listImagePath;
	}

	public boolean isFlag() {
		return flag;
	}

	public String getResult() {
		return result;
	}

}
