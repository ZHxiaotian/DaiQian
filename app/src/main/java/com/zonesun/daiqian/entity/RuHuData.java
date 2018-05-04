package com.zonesun.daiqian.entity;



import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * 此为入户调查界面的当系统异常关闭或是平板没电用来缓存没有上传的数据的；
 * 
 * @author Administrator
 * 
 */
public class RuHuData extends RealmObject {

	private String gcpp;// 购车品牌
	private String gcyy; // 购车原因
	private String lcjg; // 裸车价格
	private String hktj; // 还款途径
	private String jkcbz;// 进口车标志
	private String cx; // 车型
	private String pql;// 排气量
	private String fqje;// 分期金额
	private String fqfkqs;// 分期付款期数
	private String xyzed;// 信用总额度
	private String sxfje;// 手续费金额
	private String cs;// 成数
	private String sqrjthdb;// 申请人家庭还贷
	private String yhkje;// 月还款金额
	private String syhkje;// 首月还款金额
	private String fqfksxfl;// 分期付款手续费率
	private String name;// 申请人姓名
	private String tel;// 申请人手机号码；
	private String zjlx;// 证件类型
	private String zjhm;// 证件号码
	private String sex;// 性别
	private String brithday;// 出生年月
	private String hyzk;// 婚姻状况
	private String dbrhgtczr;// 担保人或共同偿债人；
	private String hkszdSheng;// 户口所在地省
	private String hkszdshi;// 户口所在地市
	private String hkszdxian;// 户口所在地县;
	private String xiangxiaddress;// 户口所在地详细地址
	private String zzqk;// 住宅情况
   

	public String getZzqk() {
		return zzqk;
	}

	public void setZzqk(String zzqk) {
		this.zzqk = zzqk;
	}

	private String xjuxjzdsheng;// 现居住地省
	private String xjzdshi; // 县居住市
	private String xjzdxian; // 县居住地县
	private String xjzdxxdz; // 县居住地详细地址

	public String getXjuxjzdsheng() {
		return xjuxjzdsheng;
	}

	public void setXjuxjzdsheng(String xjuxjzdsheng) {
		this.xjuxjzdsheng = xjuxjzdsheng;
	}

	public String getXjzdshi() {
		return xjzdshi;
	}

	public void setXjzdshi(String xjzdshi) {
		this.xjzdshi = xjzdshi;
	}

	public String getXjzdxian() {
		return xjzdxian;
	}

	public void setXjzdxian(String xjzdxian) {
		this.xjzdxian = xjzdxian;
	}

	public String getXjzdxxdz() {
		return xjzdxxdz;
	}

	public void setXjzdxxdz(String xjzdxxdz) {
		this.xjzdxxdz = xjzdxxdz;
	}

	private String szdw;// 所在单位
	private String dwxz;// 单位性质
	private String dwdh;// 单位电话
	private String zwlb;// 职务类别；
	private String yjsr;// 月均收入

	private String dwdzSheng;// 单位地址省
	private String dwdzShi; // 单位地址市
	private String dwdzXian;// 单位地址县
	private String dwxianxiaddress;// 单位详细地址
	private String jtyyyhkje;// 家庭已有月还款金额
	private String sqrzxqk;// 申请人征信情况
	private String sqrxl;// 申请人学历

	// 申请人配偶资料或是共同偿债人或是担保人
	private String sqrpozxzk;// 申请人配偶征信情况

	private String Dname;// 配偶姓名/偿债人/担保人姓名
	private String telnuber;// 配偶姓名/偿债人/担保人姓名电话号码
	private String Dzjlx;// 配偶姓名/偿债人/担保人姓名证件类型
	private String Dzjhm;// 配偶姓名/偿债人/担保人姓名证件号码
	private String Dcsny;// 配偶姓名/偿债人/担保人出生年月
	private String Dszdw;// 配偶姓名/偿债人/担保人所在单位
	private String Ddwxz;// 配偶姓名/偿债人/担保人单位性质
	private String Ddwzw;// 配偶姓名/偿债人/担保人单位职务 
	private String Dyjsr;//配偶姓名/偿债人/担保人月均收入
	private String Ddwdh;// 配偶姓名/偿债人/担保人单位电话
	private String DdwszSheng;// 配偶姓名/偿债人/担保人单位所在地址省
	private String DdwszShi;// 配偶姓名/偿债人/担保人单位所在地址市
	private String DdwszXian;// 配偶姓名/偿债人/担保人单位所在地址县
	private String Ddwszdi;// 配偶姓名/偿债人/担保人单位所在地址

	//开卡资料申请
//	private String homezip;// 住宅邮编
//	private String indate; // 合适入住现地址
	private String reltship1;// 联系人一与主卡申请人关系
	private String engname;// 姓名拼音或英文名
//	private String hphoneno;// 住宅电话号码
//	private String corpzip;// 单位邮编
	private String joindate;// 进入现单位工作时间
//	private String occptn;// 职业
	private String reltname1;// 联系人一姓名
	private String relaphone1;// 联系人一联系电话号
	private String reltname2;// 联系人二姓名
	private String reltship2;// 联系人二与主卡申请人关系
//	private String islongterm;// 证件是否长期有效
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

	public String getJoindate() {
		return joindate;
	}

	public void setJoindate(String joindate) {
		this.joindate = joindate;
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

	public String getHphonzono() {
		return hphonzono;
	}

	public void setHphonzono(String hphonzono) {
		this.hphonzono = hphonzono;
	}

	public String getCphozono() {
		return cphozono;
	}

	public void setCphozono(String cphozono) {
		this.cphozono = cphozono;
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

	public String getReltsex2() {
		return reltsex2;
	}

	public void setReltsex2(String reltsex2) {
		this.reltsex2 = reltsex2;
	}

	public String getReltphzon1() {
		return reltphzon1;
	}

	public void setReltphzon1(String reltphzon1) {
		this.reltphzon1 = reltphzon1;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	private String sfzl;// 身份资料
	private String dzxq;// 地址详情
	private String dw; // 定位
	private String srwjzm;// 收入文件证明
	private String gcfpwj;// 购车发票文件
	private String sfkzmwj;// 首付款证明文件
	private String cldyzmwj;// 车辆抵押证明文件
	private String clbxdwj;// 车辆保险单文件
	private String gchtwj;// 购车合同文件
	private String zxbgwj;// 征信报告文件

	public String getDyjsr() {
		return Dyjsr;
	}

	public void setDyjsr(String dyjsr) {
		Dyjsr = dyjsr;
	}


	public String getGcpp() {
		return gcpp;
	}

	public void setGcpp(String gcpp) {
		this.gcpp = gcpp;
	}

	public String getGcyy() {
		return gcyy;
	}

	public void setGcyy(String gcyy) {
		this.gcyy = gcyy;
	}

	public String getLcjg() {
		return lcjg;
	}

	public void setLcjg(String lcjg) {
		this.lcjg = lcjg;
	}

	public String getHktj() {
		return hktj;
	}

	public void setHktj(String hktj) {
		this.hktj = hktj;
	}

	public String getJkcbz() {
		return jkcbz;
	}

	public void setJkcbz(String jkcbz) {
		this.jkcbz = jkcbz;
	}

	public String getCx() {
		return cx;
	}

	public void setCx(String cx) {
		this.cx = cx;
	}

	public String getPql() {
		return pql;
	}

	public void setPql(String pql) {
		this.pql = pql;
	}

	public String getFqje() {
		return fqje;
	}

	public void setFqje(String fqje) {
		this.fqje = fqje;
	}

	public String getFqfkqs() {
		return fqfkqs;
	}

	public void setFqfkqs(String fqfkqs) {
		this.fqfkqs = fqfkqs;
	}

	public String getXyzed() {
		return xyzed;
	}

	public void setXyzed(String xyzed) {
		this.xyzed = xyzed;
	}

	public String getSxfje() {
		return sxfje;
	}

	public void setSxfje(String sxfje) {
		this.sxfje = sxfje;
	}

	public String getCs() {
		return cs;
	}

	public void setCs(String cs) {
		this.cs = cs;
	}

	public String getSqrjthdb() {
		return sqrjthdb;
	}

	public void setSqrjthdb(String sqrjthdb) {
		this.sqrjthdb = sqrjthdb;
	}

	public String getSyhkje() {
		return syhkje;
	}

	public void setSyhkje(String syhkje) {
		this.syhkje = syhkje;
	}

	public String getYhkje() {
		return yhkje;
	}

	public void setYhkje(String yhkje) {
		this.yhkje = yhkje;
	}

	public String getFqfksxfl() {
		return fqfksxfl;
	}

	public void setFqfksxfl(String fqfksxfl) {
		this.fqfksxfl = fqfksxfl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getZjlx() {
		return zjlx;
	}

	public void setZjlx(String zjlx) {
		this.zjlx = zjlx;
	}

	public String getZjhm() {
		return zjhm;
	}

	public void setZjhm(String zjhm) {
		this.zjhm = zjhm;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBrithday() {
		return brithday;
	}

	public void setBrithday(String brithday) {
		this.brithday = brithday;
	}

	public String getHyzk() {
		return hyzk;
	}

	public void setHyzk(String hyzk) {
		this.hyzk = hyzk;
	}

	public String getDbrhgtczr() {
		return dbrhgtczr;
	}

	public void setDbrhgtczr(String dbrhgtczr) {
		this.dbrhgtczr = dbrhgtczr;
	}

	public String getHkszdSheng() {
		return hkszdSheng;
	}

	public void setHkszdSheng(String hkszdSheng) {
		this.hkszdSheng = hkszdSheng;
	}

	public String getHkszdshi() {
		return hkszdshi;
	}

	public void setHkszdshi(String hkszdshi) {
		this.hkszdshi = hkszdshi;
	}

	public String getHkszdxian() {
		return hkszdxian;
	}

	public void setHkszdxian(String hkszdxian) {
		this.hkszdxian = hkszdxian;
	}

	public String getXiangxiaddress() {
		return xiangxiaddress;
	}

	public void setXiangxiaddress(String xiangxiaddress) {
		this.xiangxiaddress = xiangxiaddress;
	}

	public String getSzdw() {
		return szdw;
	}

	public void setSzdw(String szdw) {
		this.szdw = szdw;
	}

	public String getDwxz() {
		return dwxz;
	}

	public void setDwxz(String dwxz) {
		this.dwxz = dwxz;
	}

	public String getDwdh() {
		return dwdh;
	}

	public void setDwdh(String dwdh) {
		this.dwdh = dwdh;
	}

	public String getZwlb() {
		return zwlb;
	}

	public void setZwlb(String zwlb) {
		this.zwlb = zwlb;
	}

	public String getYjsr() {
		return yjsr;
	}

	public void setYjsr(String yjsr) {
		this.yjsr = yjsr;
	}

	public String getDwdzSheng() {
		return dwdzSheng;
	}

	public void setDwdzSheng(String dwdzSheng) {
		this.dwdzSheng = dwdzSheng;
	}

	public String getDwdzShi() {
		return dwdzShi;
	}

	public void setDwdzShi(String dwdzShi) {
		this.dwdzShi = dwdzShi;
	}

	public String getDwdzXian() {
		return dwdzXian;
	}

	public void setDwdzXian(String dwdzXian) {
		this.dwdzXian = dwdzXian;
	}

	public String getDwxianxiaddress() {
		return dwxianxiaddress;
	}

	public void setDwxianxiaddress(String dwxianxiaddress) {
		this.dwxianxiaddress = dwxianxiaddress;
	}

	public String getJtyyyhkje() {
		return jtyyyhkje;
	}

	public void setJtyyyhkje(String jtyyyhkje) {
		this.jtyyyhkje = jtyyyhkje;
	}

	public String getSqrzxqk() {
		return sqrzxqk;
	}

	public void setSqrzxqk(String sqrzxqk) {
		this.sqrzxqk = sqrzxqk;
	}

	public String getSqrxl() {
		return sqrxl;
	}

	public void setSqrxl(String sqrxl) {
		this.sqrxl = sqrxl;
	}

	public String getDname() {
		return Dname;
	}

	public void setDname(String dname) {
		Dname = dname;
	}

	public String getTelnuber() {
		return telnuber;
	}

	public void setTelnuber(String telnuber) {
		this.telnuber = telnuber;
	}

	public String getDzjlx() {
		return Dzjlx;
	}

	public void setDzjlx(String dzjlx) {
		Dzjlx = dzjlx;
	}

	public String getDzjhm() {
		return Dzjhm;
	}

	public void setDzjhm(String dzjhm) {
		Dzjhm = dzjhm;
	}

	public String getDcsny() {
		return Dcsny;
	}

	public void setDcsny(String dcsny) {
		Dcsny = dcsny;
	}

	public String getDszdw() {
		return Dszdw;
	}

	public String getSqrpozxzk() {
		return sqrpozxzk;
	}

	public void setSqrpozxzk(String sqrpozxzk) {
		this.sqrpozxzk = sqrpozxzk;
	}

	public void setDszdw(String dszdw) {
		Dszdw = dszdw;
	}

	public String getDdwxz() {
		return Ddwxz;
	}

	public void setDdwxz(String ddwxz) {
		Ddwxz = ddwxz;
	}

	public String getDdwzw() {
		return Ddwzw;
	}

	public void setDdwzw(String ddwzw) {
		Ddwzw = ddwzw;
	}

	public String getDdwdh() {
		return Ddwdh;
	}

	public void setDdwdh(String ddwdh) {
		Ddwdh = ddwdh;
	}

	public String getDdwszSheng() {
		return DdwszSheng;
	}

	public void setDdwszSheng(String ddwszSheng) {
		DdwszSheng = ddwszSheng;
	}

	public String getDdwszShi() {
		return DdwszShi;
	}

	public void setDdwszShi(String ddwszShi) {
		DdwszShi = ddwszShi;
	}

	public String getDdwszXian() {
		return DdwszXian;
	}

	public void setDdwszXian(String ddwszXian) {
		DdwszXian = ddwszXian;
	}

	public String getDdwszdi() {
		return Ddwszdi;
	}

	public void setDdwszdi(String ddwszdi) {
		Ddwszdi = ddwszdi;
	}

	public String getSfzl() {
		return sfzl;
	}

	public void setSfzl(String sfzl) {
		this.sfzl = sfzl;
	}

	public String getDzxq() {
		return dzxq;
	}

	public void setDzxq(String dzxq) {
		this.dzxq = dzxq;
	}

	public String getDw() {
		return dw;
	}

	public void setDw(String dw) {
		this.dw = dw;
	}

	public String getSrwjzm() {
		return srwjzm;
	}

	public void setSrwjzm(String srwjzm) {
		this.srwjzm = srwjzm;
	}

	public String getGcfpwj() {
		return gcfpwj;
	}

	public void setGcfpwj(String gcfpwj) {
		this.gcfpwj = gcfpwj;
	}

	public String getSfkzmwj() {
		return sfkzmwj;
	}

	public void setSfkzmwj(String sfkzmwj) {
		this.sfkzmwj = sfkzmwj;
	}

	public String getCldyzmwj() {
		return cldyzmwj;
	}

	public void setCldyzmwj(String cldyzmwj) {
		this.cldyzmwj = cldyzmwj;
	}

	public String getClbxdwj() {
		return clbxdwj;
	}

	public void setClbxdwj(String clbxdwj) {
		this.clbxdwj = clbxdwj;
	}

	public String getGchtwj() {
		return gchtwj;
	}

	public void setGchtwj(String gchtwj) {
		this.gchtwj = gchtwj;
	}

	public String getZxbgwj() {
		return zxbgwj;
	}

	public void setZxbgwj(String zxbgwj) {
		this.zxbgwj = zxbgwj;
	}

	@Override
	public String toString() {
		return "RuHuData [, gcpp=" + gcpp + ", gcyy=" + gcyy
				+ ", lcjg=" + lcjg + ", hktj=" + hktj + ", jkcbz=" + jkcbz
				+ ", cx=" + cx + ", pql=" + pql + ", fqje=" + fqje
				+ ", fqfkqs=" + fqfkqs + ", xyzed=" + xyzed + ", sxfje="
				+ sxfje + ", cs=" + cs + ", sqrjthdb=" + sqrjthdb + ", yhkje="
				+ yhkje + ", syhkje=" + syhkje + ", fqfksxfl=" + fqfksxfl
				+ ", name=" + name + ", tel=" + tel + ", zjlx=" + zjlx
				+ ", zjhm=" + zjhm + ", sex=" + sex + ", brithday=" + brithday
				+ ", hyzk=" + hyzk + ", dbrhgtczr=" + dbrhgtczr
				+ ", hkszdSheng=" + hkszdSheng + ", hkszdshi=" + hkszdshi
				+ ", hkszdxian=" + hkszdxian + ", xiangxiaddress="
				+ xiangxiaddress + ", zzqk=" + zzqk + ", xjuxjzdsheng="
				+ xjuxjzdsheng + ", xjzdshi=" + xjzdshi + ", xjzdxian="
				+ xjzdxian + ", xjzdxxdz=" + xjzdxxdz + ", szdw=" + szdw
				+ ", dwxz=" + dwxz + ", dwdh=" + dwdh + ", zwlb=" + zwlb
				+ ", yjsr=" + yjsr + ", dwdzSheng=" + dwdzSheng + ", dwdzShi="
				+ dwdzShi + ", dwdzXian=" + dwdzXian + ", dwxianxiaddress="
				+ dwxianxiaddress + ", jtyyyhkje=" + jtyyyhkje + ", sqrzxqk="
				+ sqrzxqk + ", sqrxl=" + sqrxl + ", sqrpozxzk=" + sqrpozxzk
				+ ", Dname=" + Dname + ", telnuber=" + telnuber + ", Dzjlx="
				+ Dzjlx + ", Dzjhm=" + Dzjhm + ", Dcsny=" + Dcsny + ", Dszdw="
				+ Dszdw + ", Ddwxz=" + Ddwxz + ", Ddwzw=" + Ddwzw + ", Ddwdh="
				+ Ddwdh + ", DdwszSheng=" + DdwszSheng + ", DdwszShi="
				+ DdwszShi + ", DdwszXian=" + DdwszXian + ", Ddwszdi="
				+ Ddwszdi + ", sfzl=" + sfzl + ", dzxq=" + dzxq + ", dw=" + dw
				+ ", srwjzm=" + srwjzm + ", gcfpwj=" + gcfpwj + ", sfkzmwj="
				+ sfkzmwj + ", cldyzmwj=" + cldyzmwj + ", clbxdwj=" + clbxdwj
				+ ", gchtwj=" + gchtwj + ", zxbgwj=" + zxbgwj + "]";
	}

}
