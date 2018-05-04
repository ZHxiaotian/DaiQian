package com.zonesun.daiqian.entity;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class RuHuSurveyEntity implements Serializable {

	private List<VisitalrearyEntity> visitalready;//已走访数据
	private List<VisityetEntity> visityet;//未走访数据
	private List<VisitalrearyEntity> visitfinished;//已完成数据

	public List<VisitalrearyEntity> getVisitfinished() {
		return visitfinished;
	}

	public void setVisitfinished(List<VisitalrearyEntity> visitfinished) {
		this.visitfinished = visitfinished;
	}

	public void setVisitalreary(List<VisitalrearyEntity> visitalready) {
		this.visitalready = visitalready;
	}

	public void setVisityet(List<VisityetEntity> visityet) {
		this.visityet = visityet;
	}

	public List<VisitalrearyEntity> getVisitalready() {
		return visitalready;
	}

	public List<VisityetEntity> getVisityet() {
		return visityet;
	}

	public static class VisitalrearyEntity {

		private String mcredit;//申请人配偶征信情况
		//开卡资料申请
		private String homezip;// 住宅邮编
		private String indate; // 合适入住现地址
		private String reltship1;// 联系人一与主卡申请人关系
		private String engname;// 姓名拼音或英文名
		private String hphoneno;// 住宅电话号码
		private String corpzip;// 单位邮编
		private String joindate;// 进入现单位工作时间
		private String occptn;// 职业
		private String reltname1;// 联系人一姓名
		private String relaphone1;// 联系人一联系电话号
		private String reltname2;// 联系人二姓名
		private String reltship2;// 联系人二与主卡申请人关系
		private String islongterm;// 证件是否长期有效
		private String deptname;// 所在部门
		private String cophonext;// 单位电话分机
		private String hprovince;// 住宅地址省份
		private String hcity;// 住宅地址市
        private String hcounty;//住宅地址县
		private String hphonzono;//住宅电话区号
		private String cphozono;//单位电话区号
		private String cprovince;//单位地址省份
		private String ccity;//单位地址市
		private String yearincome;//年收入
		private String commazip;//单位地址邮编
		private String reltsex1;//联系人一性别
		private String reltaddr1;//联系人一住址
		private String reltphzon1;//联系人一住宅电话区号
		private String reltsex2;//联系人二性别
		private String reltmobl1;//联系人一电话
		private String reltuname2;//联系人二工作单位
		private String rtcophzn2;//联系人二联系电话区号
		private String rtcophon2;//联系人二联系电话号
		private String rtcophet2;// 	联系人二联系电话分机
		private String reltmobl2;//联系人二电话
		private String cardbin;//cardBin;
		private String cardlogo;//申请卡品种
		private String cardtype;//申请卡类别
		private String cardmedm;//卡片介质
		private String saleno;//产品编
		private String statdate;//证件有效期
		private String email;//email；

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		private String primnat;// 国籍
		private String suggestionrate1;// 分期付款手续费率
		private String suggestionperiods1;// 分期付款期数
		private String suggestionpercentage2;// 月还款金额
		private String suggestionpercentage1;// 成数
		private String suggestionlimit1;// 分期付款信用总额度
		private String suggestionfee1;// 分期付款手续费金额
		private String personrepay;// 申请人家庭还贷
		private String suggestionmoney2;// 首月还款金额

		private String phone;

		private String usercode;

		private String lh_url;

		private String reason;

		private String yyhke;

		private String cartype;

		private String nowadd_shi;

		private String togather_url;

		private String username;

		private String mph_url;

		private String personedu;

		private String cert1_url;

		private String mworkaddress;

		private String credit;

		private String mworktype;

		private String cert3_url;

		private String marry;

		private String workphone;

		private String zzzm_url;

		private String mcertnum;

		private String zzzk;

		private String workadd_all;

		private String workname;

		private String status;

		private String workadd_shi;

		private String mworkphone;

		private String job;

		private String nowadd_sheng;

		private String hkfs;

		private String mavgmoney;

		private String nowadd_all;

		private String hkadd_xian;

		private String dy_url;

		private String applybc_id;

		private String worktype;

		private String hkadd_shi;

		private String birth;

		private String sex;

		private String workadd_sheng;

		private String plantime;

		private String onlycar;

		private String mbirth;

		private String nowadd_detail;

		private String dkyt;

		private String ed;

		private String workadd_xian;

		private String cert2_url;

		private String hkadd_sheng;

		private String name;

		private String certtype;

		private String isjk;

		private String pql;

		private String avgmoney;
		

		private String dw_url;

		private String mname;

		private String mjob;

		private String mcerttype;

		private String applyid;

		private String hkadd_all;

		private String hkadd_detail;

		private String workadd_detail;

		private String nowadd_xian;

		private String customerid;

		private String mworkname;

		private String certnum;

		private String mphone;

		private String xq_url;

		private String pp;

		private String hkly;

		public String getDeptname() {
			return deptname;
		}

		public void setDeptname(String deptname) {
			this.deptname = deptname;
		}

		public String getCophonext() {
			return cophonext;
		}

		public void setCophonext(String cophonext) {
			this.cophonext = cophonext;
		}

		public String getHprovince() {
			return hprovince;
		}

		public void setHprovince(String hprovince) {
			this.hprovince = hprovince;
		}

		public String getHcity() {
			return hcity;
		}

		public void setHcity(String hcity) {
			this.hcity = hcity;
		}

		public String getHcounty() {
			return hcounty;
		}

		public void setHcounty(String hcounty) {
			this.hcounty = hcounty;
		}

		public String getCphozono() {
			return cphozono;
		}

		public void setCphozono(String cphozono) {
			this.cphozono = cphozono;
		}

		public String getHphonzono() {
			return hphonzono;
		}

		public void setHphonzono(String hphonzono) {
			this.hphonzono = hphonzono;
		}

		public String getCprovince() {
			return cprovince;
		}

		public void setCprovince(String cprovince) {
			this.cprovince = cprovince;
		}

		public String getCcity() {
			return ccity;
		}

		public void setCcity(String ccity) {
			this.ccity = ccity;
		}

		public String getYearincome() {
			return yearincome;
		}

		public void setYearincome(String yearincome) {
			this.yearincome = yearincome;
		}

		public String getCommazip() {
			return commazip;
		}

		public void setCommazip(String commazip) {
			this.commazip = commazip;
		}

		public String getReltsex1() {
			return reltsex1;
		}

		public void setReltsex1(String reltsex1) {
			this.reltsex1 = reltsex1;
		}

		public String getReltaddr1() {
			return reltaddr1;
		}

		public void setReltaddr1(String reltaddr1) {
			this.reltaddr1 = reltaddr1;
		}

		public String getReltphzon1() {
			return reltphzon1;
		}

		public void setReltphzon1(String reltphzon1) {
			this.reltphzon1 = reltphzon1;
		}

		public String getReltsex2() {
			return reltsex2;
		}

		public void setReltsex2(String reltsex2) {
			this.reltsex2 = reltsex2;
		}

		public String getReltmobl1() {
			return reltmobl1;
		}

		public void setReltmobl1(String reltmobl1) {
			this.reltmobl1 = reltmobl1;
		}

		public String getReltuname2() {
			return reltuname2;
		}

		public void setReltuname2(String reltuname2) {
			this.reltuname2 = reltuname2;
		}

		public String getRtcophzn2() {
			return rtcophzn2;
		}

		public void setRtcophzn2(String rtcophzn2) {
			this.rtcophzn2 = rtcophzn2;
		}

		public String getRtcophon2() {
			return rtcophon2;
		}

		public void setRtcophon2(String rtcophon2) {
			this.rtcophon2 = rtcophon2;
		}

		public String getRtcophet2() {
			return rtcophet2;
		}

		public void setRtcophet2(String rtcophet2) {
			this.rtcophet2 = rtcophet2;
		}

		public String getReltmobl2() {
			return reltmobl2;
		}

		public void setReltmobl2(String reltmobl2) {
			this.reltmobl2 = reltmobl2;
		}

		public String getCardbin() {
			return cardbin;
		}

		public void setCardbin(String cardbin) {
			this.cardbin = cardbin;
		}

		public String getCardlogo() {
			return cardlogo;
		}

		public void setCardlogo(String cardlogo) {
			this.cardlogo = cardlogo;
		}

		public String getCardtype() {
			return cardtype;
		}

		public void setCardtype(String cardtype) {
			this.cardtype = cardtype;
		}

		public String getCardmedm() {
			return cardmedm;
		}

		public void setCardmedm(String cardmedm) {
			this.cardmedm = cardmedm;
		}

		public String getSaleno() {
			return saleno;
		}

		public void setSaleno(String saleno) {
			this.saleno = saleno;
		}

		public String getStatdate() {
			return statdate;
		}

		public void setStatdate(String statdate) {
			this.statdate = statdate;
		}

		public VisitalrearyEntity(String suggestionrate1,
								  String suggestionperiods1, String suggestionpercentage2,
								  String suggestionpercentage1, String suggestionlimit1,
								  String suggestionfee1, String personrepay,
								  String suggestionmoney2, String phone, String usercode,
								  String lh_url, String reason, String yyhke, String cartype,
								  String nowadd_shi, String togather_url, String username,
								  String mph_url, String personedu, String cert1_url,
								  String mworkaddress, String credit, String mworktype,
								  String cert3_url, String marry, String workphone,
								  String zzzm_url, String mcertnum, String zzzk,
								  String workadd_all, String workname, String status,
								  String workadd_shi, String mworkphone, String job,
								  String nowadd_sheng, String hkfs, String mavgmoney,
								  String nowadd_all, String hkadd_xian, String dy_url,
								  String applybc_id, String worktype, String hkadd_shi,
								  String birth, String sex, String workadd_sheng,
								  String plantime, String onlycar, String mbirth,
								  String nowadd_detail, String dkyt, String ed,
								  String workadd_xian, String cert2_url, String hkadd_sheng,
								  String name, String certtype, String isjk, String pql,
								  String avgmoney, String dw_url, String mname, String mjob,
								  String mcerttype, String applyid, String hkadd_all,
								  String hkadd_detail, String workadd_detail, String nowadd_xian,
								  String customerid, String mworkname, String certnum,
								  String mphone, String xq_url, String pp, String hkly) {
			super();
			this.suggestionrate1 = suggestionrate1;
			this.suggestionperiods1 = suggestionperiods1;
			this.suggestionpercentage2 = suggestionpercentage2;
			this.suggestionpercentage1 = suggestionpercentage1;
			this.suggestionlimit1 = suggestionlimit1;
			this.suggestionfee1 = suggestionfee1;
			this.personrepay = personrepay;
			this.suggestionmoney2 = suggestionmoney2;
			this.phone = phone;
			this.usercode = usercode;
			this.lh_url = lh_url;
			this.reason = reason;
			this.yyhke = yyhke;
			this.cartype = cartype;
			this.nowadd_shi = nowadd_shi;
			this.togather_url = togather_url;
			this.username = username;
			this.mph_url = mph_url;
			this.personedu = personedu;
			this.cert1_url = cert1_url;
			this.mworkaddress = mworkaddress;
			this.credit = credit;
			this.mworktype = mworktype;
			this.cert3_url = cert3_url;
			this.marry = marry;
			this.workphone = workphone;
			this.zzzm_url = zzzm_url;
			this.mcertnum = mcertnum;
			this.zzzk = zzzk;
			this.workadd_all = workadd_all;
			this.workname = workname;
			this.status = status;
			this.workadd_shi = workadd_shi;
			this.mworkphone = mworkphone;
			this.job = job;
			this.nowadd_sheng = nowadd_sheng;
			this.hkfs = hkfs;
			this.mavgmoney = mavgmoney;
			this.nowadd_all = nowadd_all;
			this.hkadd_xian = hkadd_xian;
			this.dy_url = dy_url;
			this.applybc_id = applybc_id;
			this.worktype = worktype;
			this.hkadd_shi = hkadd_shi;
			this.birth = birth;
			this.sex = sex;
			this.workadd_sheng = workadd_sheng;
			this.plantime = plantime;
			this.onlycar = onlycar;
			this.mbirth = mbirth;
			this.nowadd_detail = nowadd_detail;
			this.dkyt = dkyt;
			this.ed = ed;
			this.workadd_xian = workadd_xian;
			this.cert2_url = cert2_url;
			this.hkadd_sheng = hkadd_sheng;
			this.name = name;
			this.certtype = certtype;
			this.isjk = isjk;
			this.pql = pql;
			this.avgmoney = avgmoney;
			this.dw_url = dw_url;
			this.mname = mname;
			this.mjob = mjob;
			this.mcerttype = mcerttype;
			this.applyid = applyid;
			this.hkadd_all = hkadd_all;
			this.hkadd_detail = hkadd_detail;
			this.workadd_detail = workadd_detail;
			this.nowadd_xian = nowadd_xian;
			this.customerid = customerid;
			this.mworkname = mworkname;
			this.certnum = certnum;
			this.mphone = mphone;
			this.xq_url = xq_url;
			this.pp = pp;
			this.hkly = hkly;
		}

		public String getMcredit() {
			return mcredit;
		}

		public void setMcredit(String mcredit) {
			this.mcredit = mcredit;
		}

		public VisitalrearyEntity() {
			super();
		}

		public String getHomezip() {
			return homezip;
		}

		public void setHomezip(String homezip) {
			this.homezip = homezip;
		}

		public String getIndate() {
			return indate;
		}

		public void setIndate(String indate) {
			this.indate = indate;
		}

		public String getReltship1() {
			return reltship1;
		}

		public void setReltship1(String reltship1) {
			this.reltship1 = reltship1;
		}

		public String getEngname() {
			return engname;
		}

		public void setEngname(String engname) {
			this.engname = engname;
		}

		public String getHphoneno() {
			return hphoneno;
		}

		public void setHphoneno(String hphoneno) {
			this.hphoneno = hphoneno;
		}

		public String getCorpzip() {
			return corpzip;
		}

		public void setCorpzip(String corpzip) {
			this.corpzip = corpzip;
		}

		public String getJoindate() {
			return joindate;
		}

		public void setJoindate(String joindate) {
			this.joindate = joindate;
		}

		public String getOccptn() {
			return occptn;
		}

		public void setOccptn(String occptn) {
			this.occptn = occptn;
		}

		public String getReltname1() {
			return reltname1;
		}

		public void setReltname1(String reltname1) {
			this.reltname1 = reltname1;
		}

		public String getRelaphone1() {
			return relaphone1;
		}

		public void setRelaphone1(String relaphone1) {
			this.relaphone1 = relaphone1;
		}

		public String getReltname2() {
			return reltname2;
		}

		public void setReltname2(String reltname2) {
			this.reltname2 = reltname2;
		}

		public String getReltship2() {
			return reltship2;
		}

		public void setReltship2(String reltship2) {
			this.reltship2 = reltship2;
		}

		public String getIslongterm() {
			return islongterm;
		}

		public void setIslongterm(String islongterm) {
			this.islongterm = islongterm;
		}

		public String getPrimnat() {
			return primnat;
		}

		public void setPrimnat(String primnat) {
			this.primnat = primnat;
		}

		public String getSuggestionrate1() {
			return suggestionrate1;
		}

		public void setSuggestionrate1(String suggestionrate1) {
			this.suggestionrate1 = suggestionrate1;
		}

		public String getSuggestionperiods1() {
			return suggestionperiods1;
		}

		public void setSuggestionperiods1(String suggestionperiods1) {
			this.suggestionperiods1 = suggestionperiods1;
		}

		public String getSuggestionpercentage2() {
			return suggestionpercentage2;
		}

		public void setSuggestionpercentage2(String suggestionpercentage2) {
			this.suggestionpercentage2 = suggestionpercentage2;
		}

		public String getSuggestionpercentage1() {
			return suggestionpercentage1;
		}

		public void setSuggestionpercentage1(String suggestionpercentage1) {
			this.suggestionpercentage1 = suggestionpercentage1;
		}

		public String getSuggestionlimit1() {
			return suggestionlimit1;
		}

		public void setSuggestionlimit1(String suggestionlimit1) {
			this.suggestionlimit1 = suggestionlimit1;
		}

		public String getSuggestionfee1() {
			return suggestionfee1;
		}

		public void setSuggestionfee1(String suggestionfee1) {
			this.suggestionfee1 = suggestionfee1;
		}

		public String getPersonrepay() {
			return personrepay;
		}

		public void setPersonrepay(String personrepay) {
			this.personrepay = personrepay;
		}

		public String getSuggestionmoney2() {
			return suggestionmoney2;
		}

		public void setSuggestionmoney2(String suggestionmoney2) {
			this.suggestionmoney2 = suggestionmoney2;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getUsercode() {
			return usercode;
		}

		public void setUsercode(String usercode) {
			this.usercode = usercode;
		}

		public String getLh_url() {
			return lh_url;
		}

		public void setLh_url(String lh_url) {
			this.lh_url = lh_url;
		}

		public String getReason() {
			return reason;
		}

		public void setReason(String reason) {
			this.reason = reason;
		}

		public String getYyhke() {
			return yyhke;
		}

		public void setYyhke(String yyhke) {
			this.yyhke = yyhke;
		}

		public String getCartype() {
			return cartype;
		}

		public void setCartype(String cartype) {
			this.cartype = cartype;
		}

		public String getNowadd_shi() {
			return nowadd_shi;
		}

		public void setNowadd_shi(String nowadd_shi) {
			this.nowadd_shi = nowadd_shi;
		}

		public String getTogather_url() {
			return togather_url;
		}

		public void setTogather_url(String togather_url) {
			this.togather_url = togather_url;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getMph_url() {
			return mph_url;
		}

		public void setMph_url(String mph_url) {
			this.mph_url = mph_url;
		}

		public String getPersonedu() {
			return personedu;
		}

		public void setPersonedu(String personedu) {
			this.personedu = personedu;
		}

		public String getCert1_url() {
			return cert1_url;
		}

		public void setCert1_url(String cert1_url) {
			this.cert1_url = cert1_url;
		}

		public String getMworkaddress() {
			return mworkaddress;
		}

		public void setMworkaddress(String mworkaddress) {
			this.mworkaddress = mworkaddress;
		}

		public String getCredit() {
			return credit;
		}

		public void setCredit(String credit) {
			this.credit = credit;
		}

		public String getMworktype() {
			return mworktype;
		}

		public void setMworktype(String mworktype) {
			this.mworktype = mworktype;
		}

		public String getCert3_url() {
			return cert3_url;
		}

		public void setCert3_url(String cert3_url) {
			this.cert3_url = cert3_url;
		}

		public String getMarry() {
			return marry;
		}

		public void setMarry(String marry) {
			this.marry = marry;
		}

		public String getWorkphone() {
			return workphone;
		}

		public void setWorkphone(String workphone) {
			this.workphone = workphone;
		}

		public String getZzzm_url() {
			return zzzm_url;
		}

		public void setZzzm_url(String zzzm_url) {
			this.zzzm_url = zzzm_url;
		}

		public String getMcertnum() {
			return mcertnum;
		}

		public void setMcertnum(String mcertnum) {
			this.mcertnum = mcertnum;
		}

		public String getZzzk() {
			return zzzk;
		}

		public void setZzzk(String zzzk) {
			this.zzzk = zzzk;
		}

		public String getWorkadd_all() {
			return workadd_all;
		}

		public void setWorkadd_all(String workadd_all) {
			this.workadd_all = workadd_all;
		}

		public String getWorkname() {
			return workname;
		}

		public void setWorkname(String workname) {
			this.workname = workname;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getWorkadd_shi() {
			return workadd_shi;
		}

		public void setWorkadd_shi(String workadd_shi) {
			this.workadd_shi = workadd_shi;
		}

		public String getMworkphone() {
			return mworkphone;
		}

		public void setMworkphone(String mworkphone) {
			this.mworkphone = mworkphone;
		}

		public String getJob() {
			return job;
		}

		public void setJob(String job) {
			this.job = job;
		}

		public String getNowadd_sheng() {
			return nowadd_sheng;
		}

		public void setNowadd_sheng(String nowadd_sheng) {
			this.nowadd_sheng = nowadd_sheng;
		}

		public String getHkfs() {
			return hkfs;
		}

		public void setHkfs(String hkfs) {
			this.hkfs = hkfs;
		}

		public String getMavgmoney() {
			return mavgmoney;
		}

		public void setMavgmoney(String mavgmoney) {
			this.mavgmoney = mavgmoney;
		}

		public String getNowadd_all() {
			return nowadd_all;
		}

		public void setNowadd_all(String nowadd_all) {
			this.nowadd_all = nowadd_all;
		}

		public String getHkadd_xian() {
			return hkadd_xian;
		}

		public void setHkadd_xian(String hkadd_xian) {
			this.hkadd_xian = hkadd_xian;
		}

		public String getDy_url() {
			return dy_url;
		}

		public void setDy_url(String dy_url) {
			this.dy_url = dy_url;
		}

		public String getApplybc_id() {
			return applybc_id;
		}

		public void setApplybc_id(String applybc_id) {
			this.applybc_id = applybc_id;
		}

		public String getWorktype() {
			return worktype;
		}

		public void setWorktype(String worktype) {
			this.worktype = worktype;
		}

		public String getHkadd_shi() {
			return hkadd_shi;
		}

		public void setHkadd_shi(String hkadd_shi) {
			this.hkadd_shi = hkadd_shi;
		}

		public String getBirth() {
			return birth;
		}

		public void setBirth(String birth) {
			this.birth = birth;
		}

		public String getSex() {
			return sex;
		}

		public void setSex(String sex) {
			this.sex = sex;
		}

		public String getWorkadd_sheng() {
			return workadd_sheng;
		}

		public void setWorkadd_sheng(String workadd_sheng) {
			this.workadd_sheng = workadd_sheng;
		}

		public String getPlantime() {
			return plantime;
		}

		public void setPlantime(String plantime) {
			this.plantime = plantime;
		}

		public String getOnlycar() {
			return onlycar;
		}

		public void setOnlycar(String onlycar) {
			this.onlycar = onlycar;
		}

		public String getMbirth() {
			return mbirth;
		}

		public void setMbirth(String mbirth) {
			this.mbirth = mbirth;
		}

		public String getNowadd_detail() {
			return nowadd_detail;
		}

		public void setNowadd_detail(String nowadd_detail) {
			this.nowadd_detail = nowadd_detail;
		}

		public String getDkyt() {
			return dkyt;
		}

		public void setDkyt(String dkyt) {
			this.dkyt = dkyt;
		}

		public String getEd() {
			return ed;
		}

		public void setEd(String ed) {
			this.ed = ed;
		}

		public String getWorkadd_xian() {
			return workadd_xian;
		}

		public void setWorkadd_xian(String workadd_xian) {
			this.workadd_xian = workadd_xian;
		}

		public String getCert2_url() {
			return cert2_url;
		}

		public void setCert2_url(String cert2_url) {
			this.cert2_url = cert2_url;
		}

		public String getHkadd_sheng() {
			return hkadd_sheng;
		}

		public void setHkadd_sheng(String hkadd_sheng) {
			this.hkadd_sheng = hkadd_sheng;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getCerttype() {
			return certtype;
		}

		public void setCerttype(String certtype) {
			this.certtype = certtype;
		}

		public String getIsjk() {
			return isjk;
		}

		public void setIsjk(String isjk) {
			this.isjk = isjk;
		}

		public String getPql() {
			return pql;
		}

		public void setPql(String pql) {
			this.pql = pql;
		}

		public String getAvgmoney() {
			return avgmoney;
		}

		public void setAvgmoney(String avgmoney) {
			this.avgmoney = avgmoney;
		}

		public String getDw_url() {
			return dw_url;
		}

		public void setDw_url(String dw_url) {
			this.dw_url = dw_url;
		}

		public String getMname() {
			return mname;
		}

		public void setMname(String mname) {
			this.mname = mname;
		}

		public String getMjob() {
			return mjob;
		}

		public void setMjob(String mjob) {
			this.mjob = mjob;
		}

		public String getMcerttype() {
			return mcerttype;
		}

		public void setMcerttype(String mcerttype) {
			this.mcerttype = mcerttype;
		}

		public String getApplyid() {
			return applyid;
		}

		public void setApplyid(String applyid) {
			this.applyid = applyid;
		}

		public String getHkadd_all() {
			return hkadd_all;
		}

		public void setHkadd_all(String hkadd_all) {
			this.hkadd_all = hkadd_all;
		}

		public String getHkadd_detail() {
			return hkadd_detail;
		}

		public void setHkadd_detail(String hkadd_detail) {
			this.hkadd_detail = hkadd_detail;
		}

		public String getWorkadd_detail() {
			return workadd_detail;
		}

		public void setWorkadd_detail(String workadd_detail) {
			this.workadd_detail = workadd_detail;
		}

		public String getNowadd_xian() {
			return nowadd_xian;
		}

		public void setNowadd_xian(String nowadd_xian) {
			this.nowadd_xian = nowadd_xian;
		}

		public String getCustomerid() {
			return customerid;
		}

		public void setCustomerid(String customerid) {
			this.customerid = customerid;
		}

		public String getMworkname() {
			return mworkname;
		}

		public void setMworkname(String mworkname) {
			this.mworkname = mworkname;
		}

		public String getCertnum() {
			return certnum;
		}

		public void setCertnum(String certnum) {
			this.certnum = certnum;
		}

		public String getMphone() {
			return mphone;
		}

		public void setMphone(String mphone) {
			this.mphone = mphone;
		}

		public String getXq_url() {
			return xq_url;
		}

		public void setXq_url(String xq_url) {
			this.xq_url = xq_url;
		}

		public String getPp() {
			return pp;
		}

		public void setPp(String pp) {
			this.pp = pp;
		}

		public String getHkly() {
			return hkly;
		}

		public void setHkly(String hkly) {
			this.hkly = hkly;
		}

		@Override
		public String toString() {
			return "VisitalrearyEntity [homezip=" + homezip + ", indate="
					+ indate + ", reltship1=" + reltship1 + ", engname="
					+ engname + ", hphoneno=" + hphoneno + ", corpzip="
					+ corpzip + ", joindate=" + joindate + ", occptn=" + occptn
					+ ", reltname1=" + reltname1 + ", relaphone1=" + relaphone1
					+ ", reltname2=" + reltname2 + ", reltship2=" + reltship2
					+ ", islongterm=" + islongterm + ", primnat=" + primnat
					+ ", suggestionrate1=" + suggestionrate1
					+ ", suggestionperiods1=" + suggestionperiods1
					+ ", suggestionpercentage2=" + suggestionpercentage2
					+ ", suggestionpercentage1=" + suggestionpercentage1
					+ ", suggestionlimit1=" + suggestionlimit1
					+ ", suggestionfee1=" + suggestionfee1 + ", personrepay="
					+ personrepay + ", suggestionmoney2=" + suggestionmoney2
					+ ", phone=" + phone + ", usercode=" + usercode
					+ ", lh_url=" + lh_url + ", reason=" + reason + ", yyhke="
					+ yyhke + ", cartype=" + cartype + ", nowadd_shi="
					+ nowadd_shi + ", togather_url=" + togather_url
					+ ", username=" + username + ", mph_url=" + mph_url
					+ ", personedu=" + personedu + ", cert1_url=" + cert1_url
					+ ", mworkaddress=" + mworkaddress + ", credit=" + credit
					+ ", mworktype=" + mworktype + ", cert3_url=" + cert3_url
					+ ", marry=" + marry + ", workphone=" + workphone
					+ ", zzzm_url=" + zzzm_url + ", mcertnum=" + mcertnum
					+ ", zzzk=" + zzzk + ", workadd_all=" + workadd_all
					+ ", workname=" + workname + ", status=" + status
					+ ", workadd_shi=" + workadd_shi + ", mworkphone="
					+ mworkphone + ", job=" + job + ", nowadd_sheng="
					+ nowadd_sheng + ", hkfs=" + hkfs + ", mavgmoney="
					+ mavgmoney + ", nowadd_all=" + nowadd_all
					+ ", hkadd_xian=" + hkadd_xian + ", dy_url=" + dy_url
					+ ", applybc_id=" + applybc_id + ", worktype=" + worktype
					+ ", hkadd_shi=" + hkadd_shi + ", birth=" + birth
					+ ", sex=" + sex + ", workadd_sheng=" + workadd_sheng
					+ ", plantime=" + plantime + ", onlycar=" + onlycar
					+ ", mbirth=" + mbirth + ", nowadd_detail=" + nowadd_detail
					+ ", dkyt=" + dkyt + ", ed=" + ed + ", workadd_xian="
					+ workadd_xian + ", cert2_url=" + cert2_url
					+ ", hkadd_sheng=" + hkadd_sheng + ", name=" + name
					+ ", certtype=" + certtype + ", isjk=" + isjk + ", pql="
					+ pql + ", avgmoney=" + avgmoney + ", dw_url=" + dw_url
					+ ", mname=" + mname + ", mjob=" + mjob + ", mcerttype="
					+ mcerttype + ", applyid=" + applyid + ", hkadd_all="
					+ hkadd_all + ", hkadd_detail=" + hkadd_detail
					+ ", workadd_detail=" + workadd_detail + ", nowadd_xian="
					+ nowadd_xian + ", customerid=" + customerid
					+ ", mworkname=" + mworkname + ", certnum=" + certnum
					+ ", mphone=" + mphone + ", xq_url=" + xq_url + ", pp="
					+ pp + ", hkly=" + hkly + "]";
		}

	}

	public static class VisityetEntity {
		private String phone;

		private String usercode;

		private String lh_url;

		private String reason;

		private String yyhke;

		private String cartype;

		private String nowadd_shi;

		private String togather_url;

		private String username;

		private String mph_url;

		private String personedu;

		private String cert1_url;

		private String mworkaddress;

		private String credit;

		private String mworktype;

		private String cert3_url;

		private String marry;

		private String workphone;

		private String zzzm_url;

		private String mcertnum;

		private String zzzk;

		private String workadd_all;

		private String workname;

		private String status;

		private String workadd_shi;

		private String mworkphone;

		private String job;

		private String nowadd_sheng;

		private String hkfs;

		private String mavgmoney;

		private String nowadd_all;

		private String hkadd_xian;

		private String dy_url;

		private String applybc_id;

		private String worktype;

		private String hkadd_shi;

		private String birth;

		private String sex;

		private String workadd_sheng;

		private String plantime;

		private String onlycar;

		private String mbirth;

		private String nowadd_detail;

		private String dkyt;

		private String ed;

		private String workadd_xian;

		private String cert2_url;

		private String hkadd_sheng;

		private String name;

		private String certtype;

		private String isjk;

		private String pql;

		private String avgmoney;

		private String dw_url;

		private String mname;

		private String mjob;

		private String mcerttype;

		private String applyid;

		private String hkadd_all;

		private String hkadd_detail;

		private String workadd_detail;

		private String nowadd_xian;

		private String customerid;

		private String mworkname;

		private String certnum;

		private String mphone;

		private String xq_url;

		private String pp;

		private String hkly;

		public VisityetEntity(String phone, String usercode, String lh_url,
				String reason, String yyhke, String cartype, String nowadd_shi,
				String togather_url, String username, String mph_url,
				String personedu, String cert1_url, String mworkaddress,
				String credit, String mworktype, String cert3_url,
				String marry, String workphone, String zzzm_url,
				String mcertnum, String zzzk, String workadd_all,
				String workname, String status, String workadd_shi,
				String mworkphone, String job, String nowadd_sheng,
				String hkfs, String mavgmoney, String nowadd_all,
				String hkadd_xian, String dy_url, String applybc_id,
				String worktype, String hkadd_shi, String birth, String sex,
				String workadd_sheng, String plantime, String onlycar,
				String mbirth, String nowadd_detail, String dkyt, String ed,
				String workadd_xian, String cert2_url, String hkadd_sheng,
				String name, String certtype, String isjk, String pql,
				String avgmoney, String dw_url, String mname, String mjob,
				String mcerttype, String applyid, String hkadd_all,
				String hkadd_detail, String workadd_detail, String nowadd_xian,
				String customerid, String mworkname, String certnum,
				String mphone, String xq_url, String pp, String hkly) {
			super();
			this.phone = phone;
			this.usercode = usercode;
			this.lh_url = lh_url;
			this.reason = reason;
			this.yyhke = yyhke;
			this.cartype = cartype;
			this.nowadd_shi = nowadd_shi;
			this.togather_url = togather_url;
			this.username = username;
			this.mph_url = mph_url;
			this.personedu = personedu;
			this.cert1_url = cert1_url;
			this.mworkaddress = mworkaddress;
			this.credit = credit;
			this.mworktype = mworktype;
			this.cert3_url = cert3_url;
			this.marry = marry;
			this.workphone = workphone;
			this.zzzm_url = zzzm_url;
			this.mcertnum = mcertnum;
			this.zzzk = zzzk;
			this.workadd_all = workadd_all;
			this.workname = workname;
			this.status = status;
			this.workadd_shi = workadd_shi;
			this.mworkphone = mworkphone;
			this.job = job;
			this.nowadd_sheng = nowadd_sheng;
			this.hkfs = hkfs;
			this.mavgmoney = mavgmoney;
			this.nowadd_all = nowadd_all;
			this.hkadd_xian = hkadd_xian;
			this.dy_url = dy_url;
			this.applybc_id = applybc_id;
			this.worktype = worktype;
			this.hkadd_shi = hkadd_shi;
			this.birth = birth;
			this.sex = sex;
			this.workadd_sheng = workadd_sheng;
			this.plantime = plantime;
			this.onlycar = onlycar;
			this.mbirth = mbirth;
			this.nowadd_detail = nowadd_detail;
			this.dkyt = dkyt;
			this.ed = ed;
			this.workadd_xian = workadd_xian;
			this.cert2_url = cert2_url;
			this.hkadd_sheng = hkadd_sheng;
			this.name = name;
			this.certtype = certtype;
			this.isjk = isjk;
			this.pql = pql;
			this.avgmoney = avgmoney;
			this.dw_url = dw_url;
			this.mname = mname;
			this.mjob = mjob;
			this.mcerttype = mcerttype;
			this.applyid = applyid;
			this.hkadd_all = hkadd_all;
			this.hkadd_detail = hkadd_detail;
			this.workadd_detail = workadd_detail;
			this.nowadd_xian = nowadd_xian;
			this.customerid = customerid;
			this.mworkname = mworkname;
			this.certnum = certnum;
			this.mphone = mphone;
			this.xq_url = xq_url;
			this.pp = pp;
			this.hkly = hkly;
		}

		public VisityetEntity() {
			super();
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getUsercode() {
			return usercode;
		}

		public void setUsercode(String usercode) {
			this.usercode = usercode;
		}

		public String getLh_url() {
			return lh_url;
		}

		public void setLh_url(String lh_url) {
			this.lh_url = lh_url;
		}

		public String getReason() {
			return reason;
		}

		public void setReason(String reason) {
			this.reason = reason;
		}

		public String getYyhke() {
			return yyhke;
		}

		public void setYyhke(String yyhke) {
			this.yyhke = yyhke;
		}

		public String getCartype() {
			return cartype;
		}

		public void setCartype(String cartype) {
			this.cartype = cartype;
		}

		public String getNowadd_shi() {
			return nowadd_shi;
		}

		public void setNowadd_shi(String nowadd_shi) {
			this.nowadd_shi = nowadd_shi;
		}

		public String getTogather_url() {
			return togather_url;
		}

		public void setTogather_url(String togather_url) {
			this.togather_url = togather_url;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getMph_url() {
			return mph_url;
		}

		public void setMph_url(String mph_url) {
			this.mph_url = mph_url;
		}

		public String getPersonedu() {
			return personedu;
		}

		public void setPersonedu(String personedu) {
			this.personedu = personedu;
		}

		public String getCert1_url() {
			return cert1_url;
		}

		public void setCert1_url(String cert1_url) {
			this.cert1_url = cert1_url;
		}

		public String getMworkaddress() {
			return mworkaddress;
		}

		public void setMworkaddress(String mworkaddress) {
			this.mworkaddress = mworkaddress;
		}

		public String getCredit() {
			return credit;
		}

		public void setCredit(String credit) {
			this.credit = credit;
		}

		public String getMworktype() {
			return mworktype;
		}

		public void setMworktype(String mworktype) {
			this.mworktype = mworktype;
		}

		public String getCert3_url() {
			return cert3_url;
		}

		public void setCert3_url(String cert3_url) {
			this.cert3_url = cert3_url;
		}

		public String getMarry() {
			return marry;
		}

		public void setMarry(String marry) {
			this.marry = marry;
		}

		public String getWorkphone() {
			return workphone;
		}

		public void setWorkphone(String workphone) {
			this.workphone = workphone;
		}

		public String getZzzm_url() {
			return zzzm_url;
		}

		public void setZzzm_url(String zzzm_url) {
			this.zzzm_url = zzzm_url;
		}

		public String getMcertnum() {
			return mcertnum;
		}

		public void setMcertnum(String mcertnum) {
			this.mcertnum = mcertnum;
		}

		public String getZzzk() {
			return zzzk;
		}

		public void setZzzk(String zzzk) {
			this.zzzk = zzzk;
		}

		public String getWorkadd_all() {
			return workadd_all;
		}

		public void setWorkadd_all(String workadd_all) {
			this.workadd_all = workadd_all;
		}

		public String getWorkname() {
			return workname;
		}

		public void setWorkname(String workname) {
			this.workname = workname;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getWorkadd_shi() {
			return workadd_shi;
		}

		public void setWorkadd_shi(String workadd_shi) {
			this.workadd_shi = workadd_shi;
		}

		public String getMworkphone() {
			return mworkphone;
		}

		public void setMworkphone(String mworkphone) {
			this.mworkphone = mworkphone;
		}

		public String getJob() {
			return job;
		}

		public void setJob(String job) {
			this.job = job;
		}

		public String getNowadd_sheng() {
			return nowadd_sheng;
		}

		public void setNowadd_sheng(String nowadd_sheng) {
			this.nowadd_sheng = nowadd_sheng;
		}

		public String getHkfs() {
			return hkfs;
		}

		public void setHkfs(String hkfs) {
			this.hkfs = hkfs;
		}

		public String getMavgmoney() {
			return mavgmoney;
		}

		public void setMavgmoney(String mavgmoney) {
			this.mavgmoney = mavgmoney;
		}

		public String getNowadd_all() {
			return nowadd_all;
		}

		public void setNowadd_all(String nowadd_all) {
			this.nowadd_all = nowadd_all;
		}

		public String getHkadd_xian() {
			return hkadd_xian;
		}

		public void setHkadd_xian(String hkadd_xian) {
			this.hkadd_xian = hkadd_xian;
		}

		public String getDy_url() {
			return dy_url;
		}

		public void setDy_url(String dy_url) {
			this.dy_url = dy_url;
		}

		public String getApplybc_id() {
			return applybc_id;
		}

		public void setApplybc_id(String applybc_id) {
			this.applybc_id = applybc_id;
		}

		public String getWorktype() {
			return worktype;
		}

		public void setWorktype(String worktype) {
			this.worktype = worktype;
		}

		public String getHkadd_shi() {
			return hkadd_shi;
		}

		public void setHkadd_shi(String hkadd_shi) {
			this.hkadd_shi = hkadd_shi;
		}

		public String getBirth() {
			return birth;
		}

		public void setBirth(String birth) {
			this.birth = birth;
		}

		public String getSex() {
			return sex;
		}

		public void setSex(String sex) {
			this.sex = sex;
		}

		public String getWorkadd_sheng() {
			return workadd_sheng;
		}

		public void setWorkadd_sheng(String workadd_sheng) {
			this.workadd_sheng = workadd_sheng;
		}

		public String getPlantime() {
			return plantime;
		}

		public void setPlantime(String plantime) {
			this.plantime = plantime;
		}

		public String getOnlycar() {
			return onlycar;
		}

		public void setOnlycar(String onlycar) {
			this.onlycar = onlycar;
		}

		public String getMbirth() {
			return mbirth;
		}

		public void setMbirth(String mbirth) {
			this.mbirth = mbirth;
		}

		public String getNowadd_detail() {
			return nowadd_detail;
		}

		public void setNowadd_detail(String nowadd_detail) {
			this.nowadd_detail = nowadd_detail;
		}

		public String getDkyt() {
			return dkyt;
		}

		public void setDkyt(String dkyt) {
			this.dkyt = dkyt;
		}

		public String getEd() {
			return ed;
		}

		public void setEd(String ed) {
			this.ed = ed;
		}

		public String getWorkadd_xian() {
			return workadd_xian;
		}

		public void setWorkadd_xian(String workadd_xian) {
			this.workadd_xian = workadd_xian;
		}

		public String getCert2_url() {
			return cert2_url;
		}

		public void setCert2_url(String cert2_url) {
			this.cert2_url = cert2_url;
		}

		public String getHkadd_sheng() {
			return hkadd_sheng;
		}

		public void setHkadd_sheng(String hkadd_sheng) {
			this.hkadd_sheng = hkadd_sheng;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getCerttype() {
			return certtype;
		}

		public void setCerttype(String certtype) {
			this.certtype = certtype;
		}

		public String getIsjk() {
			return isjk;
		}

		public void setIsjk(String isjk) {
			this.isjk = isjk;
		}

		public String getPql() {
			return pql;
		}

		public void setPql(String pql) {
			this.pql = pql;
		}

		public String getAvgmoney() {
			return avgmoney;
		}

		public void setAvgmoney(String avgmoney) {
			this.avgmoney = avgmoney;
		}

		public String getDw_url() {
			return dw_url;
		}

		public void setDw_url(String dw_url) {
			this.dw_url = dw_url;
		}

		public String getMname() {
			return mname;
		}

		public void setMname(String mname) {
			this.mname = mname;
		}

		public String getMjob() {
			return mjob;
		}

		public void setMjob(String mjob) {
			this.mjob = mjob;
		}

		public String getMcerttype() {
			return mcerttype;
		}

		public void setMcerttype(String mcerttype) {
			this.mcerttype = mcerttype;
		}

		public String getApplyid() {
			return applyid;
		}

		public void setApplyid(String applyid) {
			this.applyid = applyid;
		}

		public String getHkadd_all() {
			return hkadd_all;
		}

		public void setHkadd_all(String hkadd_all) {
			this.hkadd_all = hkadd_all;
		}

		public String getHkadd_detail() {
			return hkadd_detail;
		}

		public void setHkadd_detail(String hkadd_detail) {
			this.hkadd_detail = hkadd_detail;
		}

		public String getWorkadd_detail() {
			return workadd_detail;
		}

		public void setWorkadd_detail(String workadd_detail) {
			this.workadd_detail = workadd_detail;
		}

		public String getNowadd_xian() {
			return nowadd_xian;
		}

		public void setNowadd_xian(String nowadd_xian) {
			this.nowadd_xian = nowadd_xian;
		}

		public String getCustomerid() {
			return customerid;
		}

		public void setCustomerid(String customerid) {
			this.customerid = customerid;
		}

		public String getMworkname() {
			return mworkname;
		}

		public void setMworkname(String mworkname) {
			this.mworkname = mworkname;
		}

		public String getCertnum() {
			return certnum;
		}

		public void setCertnum(String certnum) {
			this.certnum = certnum;
		}

		public String getMphone() {
			return mphone;
		}

		public void setMphone(String mphone) {
			this.mphone = mphone;
		}

		public String getXq_url() {
			return xq_url;
		}

		public void setXq_url(String xq_url) {
			this.xq_url = xq_url;
		}

		public String getPp() {
			return pp;
		}

		public void setPp(String pp) {
			this.pp = pp;
		}

		public String getHkly() {
			return hkly;
		}

		public void setHkly(String hkly) {
			this.hkly = hkly;
		}

		@Override
		public String toString() {
			return "VisityetEntity [phone=" + phone + ", usercode=" + usercode
					+ ", lh_url=" + lh_url + ", reason=" + reason + ", yyhke="
					+ yyhke + ", cartype=" + cartype + ", nowadd_shi="
					+ nowadd_shi + ", togather_url=" + togather_url
					+ ", username=" + username + ", mph_url=" + mph_url
					+ ", personedu=" + personedu + ", cert1_url=" + cert1_url
					+ ", mworkaddress=" + mworkaddress + ", credit=" + credit
					+ ", mworktype=" + mworktype + ", cert3_url=" + cert3_url
					+ ", marry=" + marry + ", workphone=" + workphone
					+ ", zzzm_url=" + zzzm_url + ", mcertnum=" + mcertnum
					+ ", zzzk=" + zzzk + ", workadd_all=" + workadd_all
					+ ", workname=" + workname + ", status=" + status
					+ ", workadd_shi=" + workadd_shi + ", mworkphone="
					+ mworkphone + ", job=" + job + ", nowadd_sheng="
					+ nowadd_sheng + ", hkfs=" + hkfs + ", mavgmoney="
					+ mavgmoney + ", nowadd_all=" + nowadd_all
					+ ", hkadd_xian=" + hkadd_xian + ", dy_url=" + dy_url
					+ ", applybc_id=" + applybc_id + ", worktype=" + worktype
					+ ", hkadd_shi=" + hkadd_shi + ", birth=" + birth
					+ ", sex=" + sex + ", workadd_sheng=" + workadd_sheng
					+ ", plantime=" + plantime + ", onlycar=" + onlycar
					+ ", mbirth=" + mbirth + ", nowadd_detail=" + nowadd_detail
					+ ", dkyt=" + dkyt + ", ed=" + ed + ", workadd_xian="
					+ workadd_xian + ", cert2_url=" + cert2_url
					+ ", hkadd_sheng=" + hkadd_sheng + ", name=" + name
					+ ", certtype=" + certtype + ", isjk=" + isjk + ", pql="
					+ pql + ", avgmoney=" + avgmoney + ", dw_url=" + dw_url
					+ ", mname=" + mname + ", mjob=" + mjob + ", mcerttype="
					+ mcerttype + ", applyid=" + applyid + ", hkadd_all="
					+ hkadd_all + ", hkadd_detail=" + hkadd_detail
					+ ", workadd_detail=" + workadd_detail + ", nowadd_xian="
					+ nowadd_xian + ", customerid=" + customerid
					+ ", mworkname=" + mworkname + ", certnum=" + certnum
					+ ", mphone=" + mphone + ", xq_url=" + xq_url + ", pp="
					+ pp + ", hkly=" + hkly + "]";
		}

	}

}
