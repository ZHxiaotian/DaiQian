package com.zonesun.daiqian.entity;

public class CreditCard1 {

	private String transok;// 流程控制变量
	private String ERR_NO;// 出错信息
	private String TSF_STAT;// 通信区传输状态
	private String TRXNO; // 外围交易编号
	private String CKUSR_F;// 柜员检查标志
	private String FLAG1; // COMMIT标志
	private String FLAG6;// 24小时标志
	private String FLAG7; // 登记外围明细标志
	private String TRXCODE; // 交易代码
	private String VERNO; // 版本号
	private String TZONENO; // 交易地区号
	private String TBRNO; // 交易网点号
	private String TELLERNO; // 柜员号
	private String AUTHTLNO; // 授权柜员号
	private String AUTHCODE; // 授权代码
	private String VAGEN_LEVEL; // 柜员级别
	private String CARDNO; // 卡号
	private String AUTHPWD;// 授权密码
	private String DUTYNO; // 岗位编号
	private String AUTHAMT; // 授权金额
	private String WORKDATE; // 工作日期
	private String SERVFACE;// 服务界面
	private String TERMID;// 终端号
	private String APPNO; // 申请表编号
	private String OPENZONE;// 开户地区号
	private String ACPTTLNO;// 收表柜员号
	private String SCANTLNO;// 扫描柜员号
	private String SCANDATE;// 扫描日期
	private String SCANTIME;// 扫描时间
	private String EXAMTLNO;// 质检柜员号
	private String EXAMSDATE;// 质检开始日期
	private String EXAMSTIME;// 质检开始时间
	private String EXAMEDATE;// 质检完成日期
	private String EXAMETIME;// 质检完成时间
	private String IMGSCNCOD;// 影像扫描码
	private String REGTZONO;// 录入/复核地区号
	private String REGTBRNO;// 录入/复核网点号
	private String REGTTLNO;// 录入柜员号
	private String CHKTLNO;// 复核柜员号
	private String SCANZONO;// 扫描/质检地区号
	private String SCANBRNO;// 扫描/质检网点号
	private String RLTFLANG;// 关系标志
	private String RELTNO;// 关系账号
	private String TRTIDEA;// 受理意见
	private String DSCODE; // 营销代码
	private String CORGPCODE;// 单位集团编码
	private String AGNZONO;// 受理地区号
	private String AGNBRNO;// 受理网点号
	private String DRAWZONO;// 领卡地区号
	private String DRAWBRNO;// 领卡网点号
	private String CUSTSORT;// 证件类型
	private String CUSTCODE;// 证件号码
	private String CHNSNAME;// 姓名
	private String ENGNAME;// 姓名拼音或英文名
	private String SEX;// 性别
	private String MRTLSTAT;// 婚姻状况
	private String BIRTHDATE;// 出生日期
	private String EDULVL;// 教育程度
	private String HOMESTAT;// 住宅状况
	private String HPROVINCE;// 住宅地址省份
	private String HCITY;// 住宅地址市
	private String HCOUNTY;// 住宅地址县（区）
	private String HADDRESS; // 住宅地址
	private String HOMEZIP; // 住宅邮编
	private String INDATE;// 何时入住现址
	private String EMAIL;// 电子邮箱
	private String HPHONZONO;// 住宅电话区号
	private String HPHONENO;// 住宅电话号码
	private String HPHONEXT;// 住宅电话分机
	private String MBLCHOIC;// 手机选择
	private String MVBLNO;// 手机号码
	private String UNITNAME;// 工作单位
	private String DEPTNAME;// 所在部门
	private String ICBCFLAG;// 本行职工标志
	private String COPHOZONO;// 单位电话区号
	private String COPHONENO;// 单位电话号码
	private String COPHONEXT;// 单位电话分机
	private String DUTY; // 职务
	private String CADRCHOIC;// 单位地址选择
	private String CPROVINCE;// 单位地址省份
	private String CCITY;// 单位地址市
	private String CCOUNTY;// 单位地址县（区）
	private String CADDRESS;// 工作单位地址
	private String CADDRID;// 单位地址ID
	private String CORPZIP;// 单位邮编
	private String JOINDATE;// 进入现单位工作时间
	private String YEARINCOME;// 本人年收入
	private String MODELCODE;// 单位性质
	private String OCCPTN;// 职业
	private String COMCHOIC; // 通讯地址选择
	private String COMMPROV;// 通讯地址省份
	private String COMMCITY;// 通讯地址市
	private String COMMADDR;// 通讯地址
	private String COMMADDRID;// 通讯地址ID
	private String COMMAZIP;// 通讯地址邮编
	private String OPENTYPE1;// 住房汽车按揭户
	private String OPENTYPE2;// 个人理财金户
	private String OPENTYPE3;// 大额存款户
	private String OPENTYPE4;// 存款户
	private String OTHOPSTAT1;// 他行住房车贷户
	private String OTHOPSTAT2;// 他行大额存款户
	private String OTHOPSTAT3;// 他行存款户
	private String OPENBANK;// 开户行
	private String DEPTYPE1;// 电费
	private String DEPTYPE2;// 水费
	private String DEPTYPE3;// 煤气费
	private String DEPTYPE4;// 电话费
	private String DEPTYPE5;// 手机费
	private String DEPTYPE6;// 其他
	private String INSTDPAY;// 在我行代发工资
	private String OBNKCRDF;// 是否持有他行信用卡
	private String OBNKCRD1;// 中行
	private String OBNKCRD2;// 农行
	private String OBNKCRD3;// 建行
	private String OBNKCRD4;// 交行
	private String OBNKCRD5;// 招行
	private String OBNKCRD6;// 其他
	private String CARSTAT;// 自购车状况
	private String CARLOGO;// 自购车品牌
	private String IMPNO;// 质押品编号
	private String RELTNAME1;// 联系人一姓名
	private String RELTSEX1;// 联系人一性别
	private String RELTSHIP1;// 联系人一与主卡申请人关系
	private String RELTMOBL1;// 联系人一手机
	private String RELTADDR1; // 联系人一住址
	private String RELTPHZON1;// 联系人一联系电话区号
	private String RELAPHONE1;// 联系人一联系电话号
	private String RELTPHEXT1;// 联系人一联系电话分
	private String RELTNAME2;// 联系人二姓名
	private String RELTSEX2;// 联系人二性别
	private String RELTSHIP2;// 联系人二与主卡申请人关系
	private String RELTMOBL2;// 联系人二手机
	private String RELTUNAME2;// 联系人二工作单位
	private String RTCOPHZN2;// 联系人二联系电话区号
	private String RTCOPHON2;// 联系人二联系电话号
	private String RTCOPHET2;// 联系人二联系电话分机
	private String DEIDYPE1;// 副卡一证件类型
	private String DEIDCODE1;// 副卡一证件号码
	private String DECHNNAM1;// 副卡一姓名
	private String DEENGNAM1;// 副卡一姓名拼音或英文名
	private String DESEX1;// 副卡一性别
	private String DEBIRTH1;// 副卡一出生日期

	public String getTransok() {
		return transok;
	}

	public void setTransok(String transok) {
		this.transok = transok;
	}

	public String getERR_NO() {
		return ERR_NO;
	}

	public void setERR_NO(String eRR_NO) {
		ERR_NO = eRR_NO;
	}

	public String getTSF_STAT() {
		return TSF_STAT;
	}

	public void setTSF_STAT(String tSF_STAT) {
		TSF_STAT = tSF_STAT;
	}

	public String getTRXNO() {
		return TRXNO;
	}

	public void setTRXNO(String tRXNO) {
		TRXNO = tRXNO;
	}

	public String getCKUSR_F() {
		return CKUSR_F;
	}

	public void setCKUSR_F(String cKUSR_F) {
		CKUSR_F = cKUSR_F;
	}

	public String getFLAG1() {
		return FLAG1;
	}

	public void setFLAG1(String fLAG1) {
		FLAG1 = fLAG1;
	}

	public String getFLAG6() {
		return FLAG6;
	}

	public void setFLAG6(String fLAG6) {
		FLAG6 = fLAG6;
	}

	public String getFLAG7() {
		return FLAG7;
	}

	public void setFLAG7(String fLAG7) {
		FLAG7 = fLAG7;
	}

	public String getTRXCODE() {
		return TRXCODE;
	}

	public void setTRXCODE(String tRXCODE) {
		TRXCODE = tRXCODE;
	}

	public String getVERNO() {
		return VERNO;
	}

	public void setVERNO(String vERNO) {
		VERNO = vERNO;
	}

	public String getTZONENO() {
		return TZONENO;
	}

	public void setTZONENO(String tZONENO) {
		TZONENO = tZONENO;
	}

	public String getTBRNO() {
		return TBRNO;
	}

	public void setTBRNO(String tBRNO) {
		TBRNO = tBRNO;
	}

	public String getTELLERNO() {
		return TELLERNO;
	}

	public void setTELLERNO(String tELLERNO) {
		TELLERNO = tELLERNO;
	}

	public String getAUTHTLNO() {
		return AUTHTLNO;
	}

	public void setAUTHTLNO(String aUTHTLNO) {
		AUTHTLNO = aUTHTLNO;
	}

	public String getAUTHCODE() {
		return AUTHCODE;
	}

	public void setAUTHCODE(String aUTHCODE) {
		AUTHCODE = aUTHCODE;
	}

	public String getVAGEN_LEVEL() {
		return VAGEN_LEVEL;
	}

	public void setVAGEN_LEVEL(String vAGEN_LEVEL) {
		VAGEN_LEVEL = vAGEN_LEVEL;
	}

	public String getCARDNO() {
		return CARDNO;
	}

	public void setCARDNO(String cARDNO) {
		CARDNO = cARDNO;
	}

	public String getAUTHPWD() {
		return AUTHPWD;
	}

	public void setAUTHPWD(String aUTHPWD) {
		AUTHPWD = aUTHPWD;
	}

	public String getDUTYNO() {
		return DUTYNO;
	}

	public void setDUTYNO(String dUTYNO) {
		DUTYNO = dUTYNO;
	}

	public String getAUTHAMT() {
		return AUTHAMT;
	}

	public void setAUTHAMT(String aUTHAMT) {
		AUTHAMT = aUTHAMT;
	}

	public String getWORKDATE() {
		return WORKDATE;
	}

	public void setWORKDATE(String wORKDATE) {
		WORKDATE = wORKDATE;
	}

	public String getSERVFACE() {
		return SERVFACE;
	}

	public void setSERVFACE(String sERVFACE) {
		SERVFACE = sERVFACE;
	}

	public String getTERMID() {
		return TERMID;
	}

	public void setTERMID(String tERMID) {
		TERMID = tERMID;
	}

	public String getAPPNO() {
		return APPNO;
	}

	public void setAPPNO(String aPPNO) {
		APPNO = aPPNO;
	}

	public String getOPENZONE() {
		return OPENZONE;
	}

	public void setOPENZONE(String oPENZONE) {
		OPENZONE = oPENZONE;
	}

	public String getACPTTLNO() {
		return ACPTTLNO;
	}

	public void setACPTTLNO(String aCPTTLNO) {
		ACPTTLNO = aCPTTLNO;
	}

	public String getSCANTLNO() {
		return SCANTLNO;
	}

	public void setSCANTLNO(String sCANTLNO) {
		SCANTLNO = sCANTLNO;
	}

	public String getSCANDATE() {
		return SCANDATE;
	}

	public void setSCANDATE(String sCANDATE) {
		SCANDATE = sCANDATE;
	}

	public String getSCANTIME() {
		return SCANTIME;
	}

	public void setSCANTIME(String sCANTIME) {
		SCANTIME = sCANTIME;
	}

	public String getEXAMTLNO() {
		return EXAMTLNO;
	}

	public void setEXAMTLNO(String eXAMTLNO) {
		EXAMTLNO = eXAMTLNO;
	}

	public String getEXAMSDATE() {
		return EXAMSDATE;
	}

	public void setEXAMSDATE(String eXAMSDATE) {
		EXAMSDATE = eXAMSDATE;
	}

	public String getEXAMSTIME() {
		return EXAMSTIME;
	}

	public void setEXAMSTIME(String eXAMSTIME) {
		EXAMSTIME = eXAMSTIME;
	}

	public String getEXAMEDATE() {
		return EXAMEDATE;
	}

	public void setEXAMEDATE(String eXAMEDATE) {
		EXAMEDATE = eXAMEDATE;
	}

	public String getEXAMETIME() {
		return EXAMETIME;
	}

	public void setEXAMETIME(String eXAMETIME) {
		EXAMETIME = eXAMETIME;
	}

	public String getIMGSCNCOD() {
		return IMGSCNCOD;
	}

	public void setIMGSCNCOD(String iMGSCNCOD) {
		IMGSCNCOD = iMGSCNCOD;
	}

	public String getREGTZONO() {
		return REGTZONO;
	}

	public void setREGTZONO(String rEGTZONO) {
		REGTZONO = rEGTZONO;
	}

	public String getREGTBRNO() {
		return REGTBRNO;
	}

	public void setREGTBRNO(String rEGTBRNO) {
		REGTBRNO = rEGTBRNO;
	}

	public String getREGTTLNO() {
		return REGTTLNO;
	}

	public void setREGTTLNO(String rEGTTLNO) {
		REGTTLNO = rEGTTLNO;
	}

	public String getCHKTLNO() {
		return CHKTLNO;
	}

	public void setCHKTLNO(String cHKTLNO) {
		CHKTLNO = cHKTLNO;
	}

	public String getSCANZONO() {
		return SCANZONO;
	}

	public void setSCANZONO(String sCANZONO) {
		SCANZONO = sCANZONO;
	}

	public String getSCANBRNO() {
		return SCANBRNO;
	}

	public void setSCANBRNO(String sCANBRNO) {
		SCANBRNO = sCANBRNO;
	}

	public String getRLTFLANG() {
		return RLTFLANG;
	}

	public void setRLTFLANG(String rLTFLANG) {
		RLTFLANG = rLTFLANG;
	}

	public String getRELTNO() {
		return RELTNO;
	}

	public void setRELTNO(String rELTNO) {
		RELTNO = rELTNO;
	}

	public String getTRTIDEA() {
		return TRTIDEA;
	}

	public void setTRTIDEA(String tRTIDEA) {
		TRTIDEA = tRTIDEA;
	}

	public String getDSCODE() {
		return DSCODE;
	}

	public void setDSCODE(String dSCODE) {
		DSCODE = dSCODE;
	}

	public String getCORGPCODE() {
		return CORGPCODE;
	}

	public void setCORGPCODE(String cORGPCODE) {
		CORGPCODE = cORGPCODE;
	}

	public String getAGNZONO() {
		return AGNZONO;
	}

	public void setAGNZONO(String aGNZONO) {
		AGNZONO = aGNZONO;
	}

	public String getAGNBRNO() {
		return AGNBRNO;
	}

	public void setAGNBRNO(String aGNBRNO) {
		AGNBRNO = aGNBRNO;
	}

	public String getDRAWZONO() {
		return DRAWZONO;
	}

	public void setDRAWZONO(String dRAWZONO) {
		DRAWZONO = dRAWZONO;
	}

	public String getDRAWBRNO() {
		return DRAWBRNO;
	}

	public void setDRAWBRNO(String dRAWBRNO) {
		DRAWBRNO = dRAWBRNO;
	}

	public String getCUSTSORT() {
		return CUSTSORT;
	}

	public void setCUSTSORT(String cUSTSORT) {
		CUSTSORT = cUSTSORT;
	}

	public String getCUSTCODE() {
		return CUSTCODE;
	}

	public void setCUSTCODE(String cUSTCODE) {
		CUSTCODE = cUSTCODE;
	}

	public String getCHNSNAME() {
		return CHNSNAME;
	}

	public void setCHNSNAME(String cHNSNAME) {
		CHNSNAME = cHNSNAME;
	}

	public String getENGNAME() {
		return ENGNAME;
	}

	public void setENGNAME(String eNGNAME) {
		ENGNAME = eNGNAME;
	}

	public String getSEX() {
		return SEX;
	}

	public void setSEX(String sEX) {
		SEX = sEX;
	}

	public String getMRTLSTAT() {
		return MRTLSTAT;
	}

	public void setMRTLSTAT(String mRTLSTAT) {
		MRTLSTAT = mRTLSTAT;
	}

	public String getBIRTHDATE() {
		return BIRTHDATE;
	}

	public void setBIRTHDATE(String bIRTHDATE) {
		BIRTHDATE = bIRTHDATE;
	}

	public String getEDULVL() {
		return EDULVL;
	}

	public void setEDULVL(String eDULVL) {
		EDULVL = eDULVL;
	}

	public String getHOMESTAT() {
		return HOMESTAT;
	}

	public void setHOMESTAT(String hOMESTAT) {
		HOMESTAT = hOMESTAT;
	}

	public String getHPROVINCE() {
		return HPROVINCE;
	}

	public void setHPROVINCE(String hPROVINCE) {
		HPROVINCE = hPROVINCE;
	}

	public String getHCITY() {
		return HCITY;
	}

	public void setHCITY(String hCITY) {
		HCITY = hCITY;
	}

	public String getHCOUNTY() {
		return HCOUNTY;
	}

	public void setHCOUNTY(String hCOUNTY) {
		HCOUNTY = hCOUNTY;
	}

	public String getHADDRESS() {
		return HADDRESS;
	}

	public void setHADDRESS(String hADDRESS) {
		HADDRESS = hADDRESS;
	}

	public String getHOMEZIP() {
		return HOMEZIP;
	}

	public void setHOMEZIP(String hOMEZIP) {
		HOMEZIP = hOMEZIP;
	}

	public String getINDATE() {
		return INDATE;
	}

	public void setINDATE(String iNDATE) {
		INDATE = iNDATE;
	}

	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}

	public String getHPHONZONO() {
		return HPHONZONO;
	}

	public void setHPHONZONO(String hPHONZONO) {
		HPHONZONO = hPHONZONO;
	}

	public String getHPHONENO() {
		return HPHONENO;
	}

	public void setHPHONENO(String hPHONENO) {
		HPHONENO = hPHONENO;
	}

	public String getHPHONEXT() {
		return HPHONEXT;
	}

	public void setHPHONEXT(String hPHONEXT) {
		HPHONEXT = hPHONEXT;
	}

	public String getMBLCHOIC() {
		return MBLCHOIC;
	}

	public void setMBLCHOIC(String mBLCHOIC) {
		MBLCHOIC = mBLCHOIC;
	}

	public String getMVBLNO() {
		return MVBLNO;
	}

	public void setMVBLNO(String mVBLNO) {
		MVBLNO = mVBLNO;
	}

	public String getUNITNAME() {
		return UNITNAME;
	}

	public void setUNITNAME(String uNITNAME) {
		UNITNAME = uNITNAME;
	}

	public String getDEPTNAME() {
		return DEPTNAME;
	}

	public void setDEPTNAME(String dEPTNAME) {
		DEPTNAME = dEPTNAME;
	}

	public String getICBCFLAG() {
		return ICBCFLAG;
	}

	public void setICBCFLAG(String iCBCFLAG) {
		ICBCFLAG = iCBCFLAG;
	}

	public String getCOPHOZONO() {
		return COPHOZONO;
	}

	public void setCOPHOZONO(String cOPHOZONO) {
		COPHOZONO = cOPHOZONO;
	}

	public String getCOPHONENO() {
		return COPHONENO;
	}

	public void setCOPHONENO(String cOPHONENO) {
		COPHONENO = cOPHONENO;
	}

	public String getCOPHONEXT() {
		return COPHONEXT;
	}

	public void setCOPHONEXT(String cOPHONEXT) {
		COPHONEXT = cOPHONEXT;
	}

	public String getDUTY() {
		return DUTY;
	}

	public void setDUTY(String dUTY) {
		DUTY = dUTY;
	}

	public String getCADRCHOIC() {
		return CADRCHOIC;
	}

	public void setCADRCHOIC(String cADRCHOIC) {
		CADRCHOIC = cADRCHOIC;
	}

	public String getCPROVINCE() {
		return CPROVINCE;
	}

	public void setCPROVINCE(String cPROVINCE) {
		CPROVINCE = cPROVINCE;
	}

	public String getCCITY() {
		return CCITY;
	}

	public void setCCITY(String cCITY) {
		CCITY = cCITY;
	}

	public String getCCOUNTY() {
		return CCOUNTY;
	}

	public void setCCOUNTY(String cCOUNTY) {
		CCOUNTY = cCOUNTY;
	}

	public String getCADDRESS() {
		return CADDRESS;
	}

	public void setCADDRESS(String cADDRESS) {
		CADDRESS = cADDRESS;
	}

	public String getCADDRID() {
		return CADDRID;
	}

	public void setCADDRID(String cADDRID) {
		CADDRID = cADDRID;
	}

	public String getCORPZIP() {
		return CORPZIP;
	}

	public void setCORPZIP(String cORPZIP) {
		CORPZIP = cORPZIP;
	}

	public String getJOINDATE() {
		return JOINDATE;
	}

	public void setJOINDATE(String jOINDATE) {
		JOINDATE = jOINDATE;
	}

	public String getYEARINCOME() {
		return YEARINCOME;
	}

	public void setYEARINCOME(String yEARINCOME) {
		YEARINCOME = yEARINCOME;
	}

	public String getMODELCODE() {
		return MODELCODE;
	}

	public void setMODELCODE(String mODELCODE) {
		MODELCODE = mODELCODE;
	}

	public String getOCCPTN() {
		return OCCPTN;
	}

	public void setOCCPTN(String oCCPTN) {
		OCCPTN = oCCPTN;
	}

	public String getCOMCHOIC() {
		return COMCHOIC;
	}

	public void setCOMCHOIC(String cOMCHOIC) {
		COMCHOIC = cOMCHOIC;
	}

	public String getCOMMPROV() {
		return COMMPROV;
	}

	public void setCOMMPROV(String cOMMPROV) {
		COMMPROV = cOMMPROV;
	}

	public String getCOMMCITY() {
		return COMMCITY;
	}

	public void setCOMMCITY(String cOMMCITY) {
		COMMCITY = cOMMCITY;
	}

	public String getCOMMADDR() {
		return COMMADDR;
	}

	public void setCOMMADDR(String cOMMADDR) {
		COMMADDR = cOMMADDR;
	}

	public String getCOMMADDRID() {
		return COMMADDRID;
	}

	public void setCOMMADDRID(String cOMMADDRID) {
		COMMADDRID = cOMMADDRID;
	}

	public String getCOMMAZIP() {
		return COMMAZIP;
	}

	public void setCOMMAZIP(String cOMMAZIP) {
		COMMAZIP = cOMMAZIP;
	}

	public String getOPENTYPE1() {
		return OPENTYPE1;
	}

	public void setOPENTYPE1(String oPENTYPE1) {
		OPENTYPE1 = oPENTYPE1;
	}

	public String getOPENTYPE2() {
		return OPENTYPE2;
	}

	public void setOPENTYPE2(String oPENTYPE2) {
		OPENTYPE2 = oPENTYPE2;
	}

	public String getOPENTYPE3() {
		return OPENTYPE3;
	}

	public void setOPENTYPE3(String oPENTYPE3) {
		OPENTYPE3 = oPENTYPE3;
	}

	public String getOPENTYPE4() {
		return OPENTYPE4;
	}

	public void setOPENTYPE4(String oPENTYPE4) {
		OPENTYPE4 = oPENTYPE4;
	}

	public String getOTHOPSTAT1() {
		return OTHOPSTAT1;
	}

	public void setOTHOPSTAT1(String oTHOPSTAT1) {
		OTHOPSTAT1 = oTHOPSTAT1;
	}

	public String getOTHOPSTAT2() {
		return OTHOPSTAT2;
	}

	public void setOTHOPSTAT2(String oTHOPSTAT2) {
		OTHOPSTAT2 = oTHOPSTAT2;
	}

	public String getOTHOPSTAT3() {
		return OTHOPSTAT3;
	}

	public void setOTHOPSTAT3(String oTHOPSTAT3) {
		OTHOPSTAT3 = oTHOPSTAT3;
	}

	public String getOPENBANK() {
		return OPENBANK;
	}

	public void setOPENBANK(String oPENBANK) {
		OPENBANK = oPENBANK;
	}

	public String getDEPTYPE1() {
		return DEPTYPE1;
	}

	public void setDEPTYPE1(String dEPTYPE1) {
		DEPTYPE1 = dEPTYPE1;
	}

	public String getDEPTYPE2() {
		return DEPTYPE2;
	}

	public void setDEPTYPE2(String dEPTYPE2) {
		DEPTYPE2 = dEPTYPE2;
	}

	public String getDEPTYPE3() {
		return DEPTYPE3;
	}

	public void setDEPTYPE3(String dEPTYPE3) {
		DEPTYPE3 = dEPTYPE3;
	}

	public String getDEPTYPE4() {
		return DEPTYPE4;
	}

	public void setDEPTYPE4(String dEPTYPE4) {
		DEPTYPE4 = dEPTYPE4;
	}

	public String getDEPTYPE5() {
		return DEPTYPE5;
	}

	public void setDEPTYPE5(String dEPTYPE5) {
		DEPTYPE5 = dEPTYPE5;
	}

	public String getDEPTYPE6() {
		return DEPTYPE6;
	}

	public void setDEPTYPE6(String dEPTYPE6) {
		DEPTYPE6 = dEPTYPE6;
	}

	public String getINSTDPAY() {
		return INSTDPAY;
	}

	public void setINSTDPAY(String iNSTDPAY) {
		INSTDPAY = iNSTDPAY;
	}

	public String getOBNKCRDF() {
		return OBNKCRDF;
	}

	public void setOBNKCRDF(String oBNKCRDF) {
		OBNKCRDF = oBNKCRDF;
	}

	public String getOBNKCRD1() {
		return OBNKCRD1;
	}

	public void setOBNKCRD1(String oBNKCRD1) {
		OBNKCRD1 = oBNKCRD1;
	}

	public String getOBNKCRD2() {
		return OBNKCRD2;
	}

	public void setOBNKCRD2(String oBNKCRD2) {
		OBNKCRD2 = oBNKCRD2;
	}

	public String getOBNKCRD3() {
		return OBNKCRD3;
	}

	public void setOBNKCRD3(String oBNKCRD3) {
		OBNKCRD3 = oBNKCRD3;
	}

	public String getOBNKCRD4() {
		return OBNKCRD4;
	}

	public void setOBNKCRD4(String oBNKCRD4) {
		OBNKCRD4 = oBNKCRD4;
	}

	public String getOBNKCRD5() {
		return OBNKCRD5;
	}

	public void setOBNKCRD5(String oBNKCRD5) {
		OBNKCRD5 = oBNKCRD5;
	}

	public String getOBNKCRD6() {
		return OBNKCRD6;
	}

	public void setOBNKCRD6(String oBNKCRD6) {
		OBNKCRD6 = oBNKCRD6;
	}

	public String getCARSTAT() {
		return CARSTAT;
	}

	public void setCARSTAT(String cARSTAT) {
		CARSTAT = cARSTAT;
	}

	public String getCARLOGO() {
		return CARLOGO;
	}

	public void setCARLOGO(String cARLOGO) {
		CARLOGO = cARLOGO;
	}

	public String getIMPNO() {
		return IMPNO;
	}

	public void setIMPNO(String iMPNO) {
		IMPNO = iMPNO;
	}

	public String getRELTNAME1() {
		return RELTNAME1;
	}

	public void setRELTNAME1(String rELTNAME1) {
		RELTNAME1 = rELTNAME1;
	}

	public String getRELTSEX1() {
		return RELTSEX1;
	}

	public void setRELTSEX1(String rELTSEX1) {
		RELTSEX1 = rELTSEX1;
	}

	public String getRELTSHIP1() {
		return RELTSHIP1;
	}

	public void setRELTSHIP1(String rELTSHIP1) {
		RELTSHIP1 = rELTSHIP1;
	}

	public String getRELTMOBL1() {
		return RELTMOBL1;
	}

	public void setRELTMOBL1(String rELTMOBL1) {
		RELTMOBL1 = rELTMOBL1;
	}

	public String getRELTADDR1() {
		return RELTADDR1;
	}

	public void setRELTADDR1(String rELTADDR1) {
		RELTADDR1 = rELTADDR1;
	}

	public String getRELTPHZON1() {
		return RELTPHZON1;
	}

	public void setRELTPHZON1(String rELTPHZON1) {
		RELTPHZON1 = rELTPHZON1;
	}

	public String getRELAPHONE1() {
		return RELAPHONE1;
	}

	public void setRELAPHONE1(String rELAPHONE1) {
		RELAPHONE1 = rELAPHONE1;
	}

	public String getRELTPHEXT1() {
		return RELTPHEXT1;
	}

	public void setRELTPHEXT1(String rELTPHEXT1) {
		RELTPHEXT1 = rELTPHEXT1;
	}

	public String getRELTNAME2() {
		return RELTNAME2;
	}

	public void setRELTNAME2(String rELTNAME2) {
		RELTNAME2 = rELTNAME2;
	}

	public String getRELTSEX2() {
		return RELTSEX2;
	}

	public void setRELTSEX2(String rELTSEX2) {
		RELTSEX2 = rELTSEX2;
	}

	public String getRELTSHIP2() {
		return RELTSHIP2;
	}

	public void setRELTSHIP2(String rELTSHIP2) {
		RELTSHIP2 = rELTSHIP2;
	}

	public String getRELTMOBL2() {
		return RELTMOBL2;
	}

	public void setRELTMOBL2(String rELTMOBL2) {
		RELTMOBL2 = rELTMOBL2;
	}

	public String getRELTUNAME2() {
		return RELTUNAME2;
	}

	public void setRELTUNAME2(String rELTUNAME2) {
		RELTUNAME2 = rELTUNAME2;
	}

	public String getRTCOPHZN2() {
		return RTCOPHZN2;
	}

	public void setRTCOPHZN2(String rTCOPHZN2) {
		RTCOPHZN2 = rTCOPHZN2;
	}

	public String getRTCOPHON2() {
		return RTCOPHON2;
	}

	public void setRTCOPHON2(String rTCOPHON2) {
		RTCOPHON2 = rTCOPHON2;
	}

	public String getRTCOPHET2() {
		return RTCOPHET2;
	}

	public void setRTCOPHET2(String rTCOPHET2) {
		RTCOPHET2 = rTCOPHET2;
	}

	public String getDEIDYPE1() {
		return DEIDYPE1;
	}

	public void setDEIDYPE1(String dEIDYPE1) {
		DEIDYPE1 = dEIDYPE1;
	}

	public String getDEIDCODE1() {
		return DEIDCODE1;
	}

	public void setDEIDCODE1(String dEIDCODE1) {
		DEIDCODE1 = dEIDCODE1;
	}

	public String getDECHNNAM1() {
		return DECHNNAM1;
	}

	public void setDECHNNAM1(String dECHNNAM1) {
		DECHNNAM1 = dECHNNAM1;
	}

	public String getDEENGNAM1() {
		return DEENGNAM1;
	}

	public void setDEENGNAM1(String dEENGNAM1) {
		DEENGNAM1 = dEENGNAM1;
	}

	public String getDESEX1() {
		return DESEX1;
	}

	public void setDESEX1(String dESEX1) {
		DESEX1 = dESEX1;
	}

	public String getDEBIRTH1() {
		return DEBIRTH1;
	}

	public void setDEBIRTH1(String dEBIRTH1) {
		DEBIRTH1 = dEBIRTH1;
	}

}
