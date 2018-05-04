package com.zonesun.daiqian.entity;

import java.util.List;

public class ResearchReportEntity {

	private List<Applybc_file> applybc_file;

	private List<Applybc> applybc;

	public void setApplybc_file(List<Applybc_file> applybc_file) {
		this.applybc_file = applybc_file;
	}

	public List<Applybc_file> getApplybc_file() {
		return this.applybc_file;
	}

	public void setApplybc(List<Applybc> applybc) {
		this.applybc = applybc;
	}

	public List<Applybc> getApplybc() {
		return this.applybc;
	}

	public ResearchReportEntity() {
		super();
	}

	public ResearchReportEntity(List<Applybc_file> applybc_file,
			List<Applybc> applybc) {
		super();
		this.applybc_file = applybc_file;
		this.applybc = applybc;
	}

	@Override
	public String toString() {
		return "ResearchReportEntity [applybc_file=" + applybc_file
				+ ", applybc=" + applybc + "]";
	}

	public class Applybc {
		private String levelsigntime;

		private String suggestionpercentage1;

		private String suggestionpercentage2;

		private String carcoowner;

		private String implementtime;

		private String installmentperiods;

		private String userid;

		private String createdate;

		private String partnercomptype;

		private String level1date;

		private String username;

		private String zoneno;

		private String familyrepay;

		private String personcredit;

		private String personedu;

		private String branchno;

		private String shenchausername;

		private String carlogo;

		private String personhousetype;

		private String level3date;

		private String guaranteecredit;

		private String personmarriage;

		private String backreason;

		private String partnercerttype;

		private String comprehsubmitdate;

		private String task1flag;

		private String guarantyname;

		private String spousecerttype;

		private String spousesalary;

		private String personfamily;

		private String personid;

		private String level4date;

		private String taskexamine1userid;

		private String partnercredit;

		private String businessno;

		private String personsex;

		private String backlevel;

		private String task1date;

		private String task2userid;

		private String task1userid;

		private String contact;

		private String taskcomprehdate;

		private String partnercompaddr;

		private String level3username;

		private String taskcomprehtime;

		private String level3userid;

		private String taskcomprehuserid;

		private String taskexamine1flag;

		private String submittime;

		private String level4username;

		private String partnercomp;

		private String partnerrelation;

		private String personbirth;

		private String taskcomprehflag;

		private String spousecompaddr;

		private String guaranteetype;

		private String carseller;

		private String qianpiusername;

		private String persontype;

		private String spousename;

		private String guarantyprice;

		private String spouseduty;

		private String personrepay;

		private String institutionaddr;

		private String carmanufacturer;

		private String personcerttype;

		private String salesmanphone;

		private String remark;

		private String submitdate;

		private String suggestionlimit2;

		private String spousecomptype;

		private String suggestionlimit1;

		private String cartype;

		private String level4userid;

		private String spousecomphone;

		private String shenchasubmittime;

		private String partnermobile;

		private String carguideprice;

		private String level2time;

		private String suggestionperiods2;

		private String suggestionperiods1;

		private String carexhaust;

		private String guaranteehousetype;

		private String spousecredit;

		private String status;

		private String salesmanid;

		private String taskexamine1date;

		private String personcompaddr;

		private String shenchasubmitdate;

		private String task2flag;

		private String suggestionfee2;

		private String tasksigndate;

		private String salesman;

		private String suggestionfee1;

		private String levelsigndate;

		private String partnercomphone;

		private String tasksigntime;

		private String personmobile;

		private String partnername;

		private String partnerbirth;

		private String contactphone;

		private String comprehsubmittime;

		private String carflag;

		private String cardno;

		private String personduty;

		private String implementdate;

		private String personname;

		private String partnerduty;

		private String personcertno;

		private String personhome;

		private String spousebirth;

		private String personcomp;

		private String spousecomp;

		private String tasksignuserid;

		private String task1time;

		private String guaranteecomp;

		private String personcomphone;

		private String taskexamine1time;

		private String createtime;

		private String guaranteesalary;

		private String level2userid;

		private String spousemobile;

		private String spousecertno;

		private String tasksignflag;

		private String carlogotype;

		private String personsalary;

		private String suggestionrate2;

		private String suggestionrate1;

		private String institution;

		private String level1time;

		private String personhouseaddr;

		private String level1userid;

		private String level2date;

		private String implementflag;

		private String task2date;

		private String branchsuggestion;

		private String partnercertno;

		private String applyid;

		private String installmentamount;

		private String partnersalary;

		private String carprice;

		private String task2time;

		private String level2username;

		private String level1username;

		private String level3time;

		private String guaranteename;

		private String personcomptype;

		private String suggestionmoney2;

		private String suggestionmoney1;

		public void setLevelsigntime(String levelsigntime) {
			this.levelsigntime = levelsigntime;
		}

		public String getLevelsigntime() {
			return this.levelsigntime;
		}

		public void setSuggestionpercentage1(String suggestionpercentage1) {
			this.suggestionpercentage1 = suggestionpercentage1;
		}

		public String getSuggestionpercentage1() {
			return this.suggestionpercentage1;
		}

		public void setSuggestionpercentage2(String suggestionpercentage2) {
			this.suggestionpercentage2 = suggestionpercentage2;
		}

		public String getSuggestionpercentage2() {
			return this.suggestionpercentage2;
		}

		public void setCarcoowner(String carcoowner) {
			this.carcoowner = carcoowner;
		}

		public String getCarcoowner() {
			return this.carcoowner;
		}

		public void setImplementtime(String implementtime) {
			this.implementtime = implementtime;
		}

		public String getImplementtime() {
			return this.implementtime;
		}

		public void setInstallmentperiods(String installmentperiods) {
			this.installmentperiods = installmentperiods;
		}

		public String getInstallmentperiods() {
			return this.installmentperiods;
		}

		public void setUserid(String userid) {
			this.userid = userid;
		}

		public String getUserid() {
			return this.userid;
		}

		public void setCreatedate(String createdate) {
			this.createdate = createdate;
		}

		public String getCreatedate() {
			return this.createdate;
		}

		public void setPartnercomptype(String partnercomptype) {
			this.partnercomptype = partnercomptype;
		}

		public String getPartnercomptype() {
			return this.partnercomptype;
		}

		public void setLevel1date(String level1date) {
			this.level1date = level1date;
		}

		public String getLevel1date() {
			return this.level1date;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getUsername() {
			return this.username;
		}

		public void setZoneno(String zoneno) {
			this.zoneno = zoneno;
		}

		public String getZoneno() {
			return this.zoneno;
		}

		public void setFamilyrepay(String familyrepay) {
			this.familyrepay = familyrepay;
		}

		public String getFamilyrepay() {
			return this.familyrepay;
		}

		public void setPersoncredit(String personcredit) {
			this.personcredit = personcredit;
		}

		public String getPersoncredit() {
			return this.personcredit;
		}

		public void setPersonedu(String personedu) {
			this.personedu = personedu;
		}

		public String getPersonedu() {
			return this.personedu;
		}

		public void setBranchno(String branchno) {
			this.branchno = branchno;
		}

		public String getBranchno() {
			return this.branchno;
		}

		public void setShenchausername(String shenchausername) {
			this.shenchausername = shenchausername;
		}

		public String getShenchausername() {
			return this.shenchausername;
		}

		public void setCarlogo(String carlogo) {
			this.carlogo = carlogo;
		}

		public String getCarlogo() {
			return this.carlogo;
		}

		public void setPersonhousetype(String personhousetype) {
			this.personhousetype = personhousetype;
		}

		public String getPersonhousetype() {
			return this.personhousetype;
		}

		public void setLevel3date(String level3date) {
			this.level3date = level3date;
		}

		public String getLevel3date() {
			return this.level3date;
		}

		public void setGuaranteecredit(String guaranteecredit) {
			this.guaranteecredit = guaranteecredit;
		}

		public String getGuaranteecredit() {
			return this.guaranteecredit;
		}

		public void setPersonmarriage(String personmarriage) {
			this.personmarriage = personmarriage;
		}

		public String getPersonmarriage() {
			return this.personmarriage;
		}

		public void setBackreason(String backreason) {
			this.backreason = backreason;
		}

		public String getBackreason() {
			return this.backreason;
		}

		public void setPartnercerttype(String partnercerttype) {
			this.partnercerttype = partnercerttype;
		}

		public String getPartnercerttype() {
			return this.partnercerttype;
		}

		public void setComprehsubmitdate(String comprehsubmitdate) {
			this.comprehsubmitdate = comprehsubmitdate;
		}

		public String getComprehsubmitdate() {
			return this.comprehsubmitdate;
		}

		public void setTask1flag(String task1flag) {
			this.task1flag = task1flag;
		}

		public String getTask1flag() {
			return this.task1flag;
		}

		public void setGuarantyname(String guarantyname) {
			this.guarantyname = guarantyname;
		}

		public String getGuarantyname() {
			return this.guarantyname;
		}

		public void setSpousecerttype(String spousecerttype) {
			this.spousecerttype = spousecerttype;
		}

		public String getSpousecerttype() {
			return this.spousecerttype;
		}

		public void setSpousesalary(String spousesalary) {
			this.spousesalary = spousesalary;
		}

		public String getSpousesalary() {
			return this.spousesalary;
		}

		public void setPersonfamily(String personfamily) {
			this.personfamily = personfamily;
		}

		public String getPersonfamily() {
			return this.personfamily;
		}

		public void setPersonid(String personid) {
			this.personid = personid;
		}

		public String getPersonid() {
			return this.personid;
		}

		public void setLevel4date(String level4date) {
			this.level4date = level4date;
		}

		public String getLevel4date() {
			return this.level4date;
		}

		public void setTaskexamine1userid(String taskexamine1userid) {
			this.taskexamine1userid = taskexamine1userid;
		}

		public String getTaskexamine1userid() {
			return this.taskexamine1userid;
		}

		public void setPartnercredit(String partnercredit) {
			this.partnercredit = partnercredit;
		}

		public String getPartnercredit() {
			return this.partnercredit;
		}

		public void setBusinessno(String businessno) {
			this.businessno = businessno;
		}

		public String getBusinessno() {
			return this.businessno;
		}

		public void setPersonsex(String personsex) {
			this.personsex = personsex;
		}

		public String getPersonsex() {
			return this.personsex;
		}

		public void setBacklevel(String backlevel) {
			this.backlevel = backlevel;
		}

		public String getBacklevel() {
			return this.backlevel;
		}

		public void setTask1date(String task1date) {
			this.task1date = task1date;
		}

		public String getTask1date() {
			return this.task1date;
		}

		public void setTask2userid(String task2userid) {
			this.task2userid = task2userid;
		}

		public String getTask2userid() {
			return this.task2userid;
		}

		public void setTask1userid(String task1userid) {
			this.task1userid = task1userid;
		}

		public String getTask1userid() {
			return this.task1userid;
		}

		public void setContact(String contact) {
			this.contact = contact;
		}

		public String getContact() {
			return this.contact;
		}

		public void setTaskcomprehdate(String taskcomprehdate) {
			this.taskcomprehdate = taskcomprehdate;
		}

		public String getTaskcomprehdate() {
			return this.taskcomprehdate;
		}

		public void setPartnercompaddr(String partnercompaddr) {
			this.partnercompaddr = partnercompaddr;
		}

		public String getPartnercompaddr() {
			return this.partnercompaddr;
		}

		public void setLevel3username(String level3username) {
			this.level3username = level3username;
		}

		public String getLevel3username() {
			return this.level3username;
		}

		public void setTaskcomprehtime(String taskcomprehtime) {
			this.taskcomprehtime = taskcomprehtime;
		}

		public String getTaskcomprehtime() {
			return this.taskcomprehtime;
		}

		public void setLevel3userid(String level3userid) {
			this.level3userid = level3userid;
		}

		public String getLevel3userid() {
			return this.level3userid;
		}

		public void setTaskcomprehuserid(String taskcomprehuserid) {
			this.taskcomprehuserid = taskcomprehuserid;
		}

		public String getTaskcomprehuserid() {
			return this.taskcomprehuserid;
		}

		public void setTaskexamine1flag(String taskexamine1flag) {
			this.taskexamine1flag = taskexamine1flag;
		}

		public String getTaskexamine1flag() {
			return this.taskexamine1flag;
		}

		public void setSubmittime(String submittime) {
			this.submittime = submittime;
		}

		public String getSubmittime() {
			return this.submittime;
		}

		public void setLevel4username(String level4username) {
			this.level4username = level4username;
		}

		public String getLevel4username() {
			return this.level4username;
		}

		public void setPartnercomp(String partnercomp) {
			this.partnercomp = partnercomp;
		}

		public String getPartnercomp() {
			return this.partnercomp;
		}

		public void setPartnerrelation(String partnerrelation) {
			this.partnerrelation = partnerrelation;
		}

		public String getPartnerrelation() {
			return this.partnerrelation;
		}

		public void setPersonbirth(String personbirth) {
			this.personbirth = personbirth;
		}

		public String getPersonbirth() {
			return this.personbirth;
		}

		public void setTaskcomprehflag(String taskcomprehflag) {
			this.taskcomprehflag = taskcomprehflag;
		}

		public String getTaskcomprehflag() {
			return this.taskcomprehflag;
		}

		public void setSpousecompaddr(String spousecompaddr) {
			this.spousecompaddr = spousecompaddr;
		}

		public String getSpousecompaddr() {
			return this.spousecompaddr;
		}

		public void setGuaranteetype(String guaranteetype) {
			this.guaranteetype = guaranteetype;
		}

		public String getGuaranteetype() {
			return this.guaranteetype;
		}

		public void setCarseller(String carseller) {
			this.carseller = carseller;
		}

		public String getCarseller() {
			return this.carseller;
		}

		public void setQianpiusername(String qianpiusername) {
			this.qianpiusername = qianpiusername;
		}

		public String getQianpiusername() {
			return this.qianpiusername;
		}

		public void setPersontype(String persontype) {
			this.persontype = persontype;
		}

		public String getPersontype() {
			return this.persontype;
		}

		public void setSpousename(String spousename) {
			this.spousename = spousename;
		}

		public String getSpousename() {
			return this.spousename;
		}

		public void setGuarantyprice(String guarantyprice) {
			this.guarantyprice = guarantyprice;
		}

		public String getGuarantyprice() {
			return this.guarantyprice;
		}

		public void setSpouseduty(String spouseduty) {
			this.spouseduty = spouseduty;
		}

		public String getSpouseduty() {
			return this.spouseduty;
		}

		public void setPersonrepay(String personrepay) {
			this.personrepay = personrepay;
		}

		public String getPersonrepay() {
			return this.personrepay;
		}

		public void setInstitutionaddr(String institutionaddr) {
			this.institutionaddr = institutionaddr;
		}

		public String getInstitutionaddr() {
			return this.institutionaddr;
		}

		public void setCarmanufacturer(String carmanufacturer) {
			this.carmanufacturer = carmanufacturer;
		}

		public String getCarmanufacturer() {
			return this.carmanufacturer;
		}

		public void setPersoncerttype(String personcerttype) {
			this.personcerttype = personcerttype;
		}

		public String getPersoncerttype() {
			return this.personcerttype;
		}

		public void setSalesmanphone(String salesmanphone) {
			this.salesmanphone = salesmanphone;
		}

		public String getSalesmanphone() {
			return this.salesmanphone;
		}

		public void setRemark(String remark) {
			this.remark = remark;
		}

		public String getRemark() {
			return this.remark;
		}

		public void setSubmitdate(String submitdate) {
			this.submitdate = submitdate;
		}

		public String getSubmitdate() {
			return this.submitdate;
		}

		public void setSuggestionlimit2(String suggestionlimit2) {
			this.suggestionlimit2 = suggestionlimit2;
		}

		public String getSuggestionlimit2() {
			return this.suggestionlimit2;
		}

		public void setSpousecomptype(String spousecomptype) {
			this.spousecomptype = spousecomptype;
		}

		public String getSpousecomptype() {
			return this.spousecomptype;
		}

		public void setSuggestionlimit1(String suggestionlimit1) {
			this.suggestionlimit1 = suggestionlimit1;
		}

		public String getSuggestionlimit1() {
			return this.suggestionlimit1;
		}

		public void setCartype(String cartype) {
			this.cartype = cartype;
		}

		public String getCartype() {
			return this.cartype;
		}

		public void setLevel4userid(String level4userid) {
			this.level4userid = level4userid;
		}

		public String getLevel4userid() {
			return this.level4userid;
		}

		public void setSpousecomphone(String spousecomphone) {
			this.spousecomphone = spousecomphone;
		}

		public String getSpousecomphone() {
			return this.spousecomphone;
		}

		public void setShenchasubmittime(String shenchasubmittime) {
			this.shenchasubmittime = shenchasubmittime;
		}

		public String getShenchasubmittime() {
			return this.shenchasubmittime;
		}

		public void setPartnermobile(String partnermobile) {
			this.partnermobile = partnermobile;
		}

		public String getPartnermobile() {
			return this.partnermobile;
		}

		public void setCarguideprice(String carguideprice) {
			this.carguideprice = carguideprice;
		}

		public String getCarguideprice() {
			return this.carguideprice;
		}

		public void setLevel2time(String level2time) {
			this.level2time = level2time;
		}

		public String getLevel2time() {
			return this.level2time;
		}

		public void setSuggestionperiods2(String suggestionperiods2) {
			this.suggestionperiods2 = suggestionperiods2;
		}

		public String getSuggestionperiods2() {
			return this.suggestionperiods2;
		}

		public void setSuggestionperiods1(String suggestionperiods1) {
			this.suggestionperiods1 = suggestionperiods1;
		}

		public String getSuggestionperiods1() {
			return this.suggestionperiods1;
		}

		public void setCarexhaust(String carexhaust) {
			this.carexhaust = carexhaust;
		}

		public String getCarexhaust() {
			return this.carexhaust;
		}

		public void setGuaranteehousetype(String guaranteehousetype) {
			this.guaranteehousetype = guaranteehousetype;
		}

		public String getGuaranteehousetype() {
			return this.guaranteehousetype;
		}

		public void setSpousecredit(String spousecredit) {
			this.spousecredit = spousecredit;
		}

		public String getSpousecredit() {
			return this.spousecredit;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getStatus() {
			return this.status;
		}

		public void setSalesmanid(String salesmanid) {
			this.salesmanid = salesmanid;
		}

		public String getSalesmanid() {
			return this.salesmanid;
		}

		public void setTaskexamine1date(String taskexamine1date) {
			this.taskexamine1date = taskexamine1date;
		}

		public String getTaskexamine1date() {
			return this.taskexamine1date;
		}

		public void setPersoncompaddr(String personcompaddr) {
			this.personcompaddr = personcompaddr;
		}

		public String getPersoncompaddr() {
			return this.personcompaddr;
		}

		public void setShenchasubmitdate(String shenchasubmitdate) {
			this.shenchasubmitdate = shenchasubmitdate;
		}

		public String getShenchasubmitdate() {
			return this.shenchasubmitdate;
		}

		public void setTask2flag(String task2flag) {
			this.task2flag = task2flag;
		}

		public String getTask2flag() {
			return this.task2flag;
		}

		public void setSuggestionfee2(String suggestionfee2) {
			this.suggestionfee2 = suggestionfee2;
		}

		public String getSuggestionfee2() {
			return this.suggestionfee2;
		}

		public void setTasksigndate(String tasksigndate) {
			this.tasksigndate = tasksigndate;
		}

		public String getTasksigndate() {
			return this.tasksigndate;
		}

		public void setSalesman(String salesman) {
			this.salesman = salesman;
		}

		public String getSalesman() {
			return this.salesman;
		}

		public void setSuggestionfee1(String suggestionfee1) {
			this.suggestionfee1 = suggestionfee1;
		}

		public String getSuggestionfee1() {
			return this.suggestionfee1;
		}

		public void setLevelsigndate(String levelsigndate) {
			this.levelsigndate = levelsigndate;
		}

		public String getLevelsigndate() {
			return this.levelsigndate;
		}

		public void setPartnercomphone(String partnercomphone) {
			this.partnercomphone = partnercomphone;
		}

		public String getPartnercomphone() {
			return this.partnercomphone;
		}

		public void setTasksigntime(String tasksigntime) {
			this.tasksigntime = tasksigntime;
		}

		public String getTasksigntime() {
			return this.tasksigntime;
		}

		public void setPersonmobile(String personmobile) {
			this.personmobile = personmobile;
		}

		public String getPersonmobile() {
			return this.personmobile;
		}

		public void setPartnername(String partnername) {
			this.partnername = partnername;
		}

		public String getPartnername() {
			return this.partnername;
		}

		public void setPartnerbirth(String partnerbirth) {
			this.partnerbirth = partnerbirth;
		}

		public String getPartnerbirth() {
			return this.partnerbirth;
		}

		public void setContactphone(String contactphone) {
			this.contactphone = contactphone;
		}

		public String getContactphone() {
			return this.contactphone;
		}

		public void setComprehsubmittime(String comprehsubmittime) {
			this.comprehsubmittime = comprehsubmittime;
		}

		public String getComprehsubmittime() {
			return this.comprehsubmittime;
		}

		public void setCarflag(String carflag) {
			this.carflag = carflag;
		}

		public String getCarflag() {
			return this.carflag;
		}

		public void setCardno(String cardno) {
			this.cardno = cardno;
		}

		public String getCardno() {
			return this.cardno;
		}

		public void setPersonduty(String personduty) {
			this.personduty = personduty;
		}

		public String getPersonduty() {
			return this.personduty;
		}

		public void setImplementdate(String implementdate) {
			this.implementdate = implementdate;
		}

		public String getImplementdate() {
			return this.implementdate;
		}

		public void setPersonname(String personname) {
			this.personname = personname;
		}

		public String getPersonname() {
			return this.personname;
		}

		public void setPartnerduty(String partnerduty) {
			this.partnerduty = partnerduty;
		}

		public String getPartnerduty() {
			return this.partnerduty;
		}

		public void setPersoncertno(String personcertno) {
			this.personcertno = personcertno;
		}

		public String getPersoncertno() {
			return this.personcertno;
		}

		public void setPersonhome(String personhome) {
			this.personhome = personhome;
		}

		public String getPersonhome() {
			return this.personhome;
		}

		public void setSpousebirth(String spousebirth) {
			this.spousebirth = spousebirth;
		}

		public String getSpousebirth() {
			return this.spousebirth;
		}

		public void setPersoncomp(String personcomp) {
			this.personcomp = personcomp;
		}

		public String getPersoncomp() {
			return this.personcomp;
		}

		public void setSpousecomp(String spousecomp) {
			this.spousecomp = spousecomp;
		}

		public String getSpousecomp() {
			return this.spousecomp;
		}

		public void setTasksignuserid(String tasksignuserid) {
			this.tasksignuserid = tasksignuserid;
		}

		public String getTasksignuserid() {
			return this.tasksignuserid;
		}

		public void setTask1time(String task1time) {
			this.task1time = task1time;
		}

		public String getTask1time() {
			return this.task1time;
		}

		public void setGuaranteecomp(String guaranteecomp) {
			this.guaranteecomp = guaranteecomp;
		}

		public String getGuaranteecomp() {
			return this.guaranteecomp;
		}

		public void setPersoncomphone(String personcomphone) {
			this.personcomphone = personcomphone;
		}

		public String getPersoncomphone() {
			return this.personcomphone;
		}

		public void setTaskexamine1time(String taskexamine1time) {
			this.taskexamine1time = taskexamine1time;
		}

		public String getTaskexamine1time() {
			return this.taskexamine1time;
		}

		public void setCreatetime(String createtime) {
			this.createtime = createtime;
		}

		public String getCreatetime() {
			return this.createtime;
		}

		public void setGuaranteesalary(String guaranteesalary) {
			this.guaranteesalary = guaranteesalary;
		}

		public String getGuaranteesalary() {
			return this.guaranteesalary;
		}

		public void setLevel2userid(String level2userid) {
			this.level2userid = level2userid;
		}

		public String getLevel2userid() {
			return this.level2userid;
		}

		public void setSpousemobile(String spousemobile) {
			this.spousemobile = spousemobile;
		}

		public String getSpousemobile() {
			return this.spousemobile;
		}

		public void setSpousecertno(String spousecertno) {
			this.spousecertno = spousecertno;
		}

		public String getSpousecertno() {
			return this.spousecertno;
		}

		public void setTasksignflag(String tasksignflag) {
			this.tasksignflag = tasksignflag;
		}

		public String getTasksignflag() {
			return this.tasksignflag;
		}

		public void setCarlogotype(String carlogotype) {
			this.carlogotype = carlogotype;
		}

		public String getCarlogotype() {
			return this.carlogotype;
		}

		public void setPersonsalary(String personsalary) {
			this.personsalary = personsalary;
		}

		public String getPersonsalary() {
			return this.personsalary;
		}

		public void setSuggestionrate2(String suggestionrate2) {
			this.suggestionrate2 = suggestionrate2;
		}

		public String getSuggestionrate2() {
			return this.suggestionrate2;
		}

		public void setSuggestionrate1(String suggestionrate1) {
			this.suggestionrate1 = suggestionrate1;
		}

		public String getSuggestionrate1() {
			return this.suggestionrate1;
		}

		public void setInstitution(String institution) {
			this.institution = institution;
		}

		public String getInstitution() {
			return this.institution;
		}

		public void setLevel1time(String level1time) {
			this.level1time = level1time;
		}

		public String getLevel1time() {
			return this.level1time;
		}

		public void setPersonhouseaddr(String personhouseaddr) {
			this.personhouseaddr = personhouseaddr;
		}

		public String getPersonhouseaddr() {
			return this.personhouseaddr;
		}

		public void setLevel1userid(String level1userid) {
			this.level1userid = level1userid;
		}

		public String getLevel1userid() {
			return this.level1userid;
		}

		public void setLevel2date(String level2date) {
			this.level2date = level2date;
		}

		public String getLevel2date() {
			return this.level2date;
		}

		public void setImplementflag(String implementflag) {
			this.implementflag = implementflag;
		}

		public String getImplementflag() {
			return this.implementflag;
		}

		public void setTask2date(String task2date) {
			this.task2date = task2date;
		}

		public String getTask2date() {
			return this.task2date;
		}

		public void setBranchsuggestion(String branchsuggestion) {
			this.branchsuggestion = branchsuggestion;
		}

		public String getBranchsuggestion() {
			return this.branchsuggestion;
		}

		public void setPartnercertno(String partnercertno) {
			this.partnercertno = partnercertno;
		}

		public String getPartnercertno() {
			return this.partnercertno;
		}

		public void setApplyid(String applyid) {
			this.applyid = applyid;
		}

		public String getApplyid() {
			return this.applyid;
		}

		public void setInstallmentamount(String installmentamount) {
			this.installmentamount = installmentamount;
		}

		public String getInstallmentamount() {
			return this.installmentamount;
		}

		public void setPartnersalary(String partnersalary) {
			this.partnersalary = partnersalary;
		}

		public String getPartnersalary() {
			return this.partnersalary;
		}

		public void setCarprice(String carprice) {
			this.carprice = carprice;
		}

		public String getCarprice() {
			return this.carprice;
		}

		public void setTask2time(String task2time) {
			this.task2time = task2time;
		}

		public String getTask2time() {
			return this.task2time;
		}

		public void setLevel2username(String level2username) {
			this.level2username = level2username;
		}

		public String getLevel2username() {
			return this.level2username;
		}

		public void setLevel1username(String level1username) {
			this.level1username = level1username;
		}

		public String getLevel1username() {
			return this.level1username;
		}

		public void setLevel3time(String level3time) {
			this.level3time = level3time;
		}

		public String getLevel3time() {
			return this.level3time;
		}

		public void setGuaranteename(String guaranteename) {
			this.guaranteename = guaranteename;
		}

		public String getGuaranteename() {
			return this.guaranteename;
		}

		public void setPersoncomptype(String personcomptype) {
			this.personcomptype = personcomptype;
		}

		public String getPersoncomptype() {
			return this.personcomptype;
		}

		public void setSuggestionmoney2(String suggestionmoney2) {
			this.suggestionmoney2 = suggestionmoney2;
		}

		public String getSuggestionmoney2() {
			return this.suggestionmoney2;
		}

		public void setSuggestionmoney1(String suggestionmoney1) {
			this.suggestionmoney1 = suggestionmoney1;
		}

		public String getSuggestionmoney1() {
			return this.suggestionmoney1;
		}

		public Applybc(String levelsigntime, String suggestionpercentage1,
				String suggestionpercentage2, String carcoowner,
				String implementtime, String installmentperiods, String userid,
				String createdate, String partnercomptype, String level1date,
				String username, String zoneno, String familyrepay,
				String personcredit, String personedu, String branchno,
				String shenchausername, String carlogo, String personhousetype,
				String level3date, String guaranteecredit,
				String personmarriage, String backreason,
				String partnercerttype, String comprehsubmitdate,
				String task1flag, String guarantyname, String spousecerttype,
				String spousesalary, String personfamily, String personid,
				String level4date, String taskexamine1userid,
				String partnercredit, String businessno, String personsex,
				String backlevel, String task1date, String task2userid,
				String task1userid, String contact, String taskcomprehdate,
				String partnercompaddr, String level3username,
				String taskcomprehtime, String level3userid,
				String taskcomprehuserid, String taskexamine1flag,
				String submittime, String level4username, String partnercomp,
				String partnerrelation, String personbirth,
				String taskcomprehflag, String spousecompaddr,
				String guaranteetype, String carseller, String qianpiusername,
				String persontype, String spousename, String guarantyprice,
				String spouseduty, String personrepay, String institutionaddr,
				String carmanufacturer, String personcerttype,
				String salesmanphone, String remark, String submitdate,
				String suggestionlimit2, String spousecomptype,
				String suggestionlimit1, String cartype, String level4userid,
				String spousecomphone, String shenchasubmittime,
				String partnermobile, String carguideprice, String level2time,
				String suggestionperiods2, String suggestionperiods1,
				String carexhaust, String guaranteehousetype,
				String spousecredit, String status, String salesmanid,
				String taskexamine1date, String personcompaddr,
				String shenchasubmitdate, String task2flag,
				String suggestionfee2, String tasksigndate, String salesman,
				String suggestionfee1, String levelsigndate,
				String partnercomphone, String tasksigntime,
				String personmobile, String partnername, String partnerbirth,
				String contactphone, String comprehsubmittime, String carflag,
				String cardno, String personduty, String implementdate,
				String personname, String partnerduty, String personcertno,
				String personhome, String spousebirth, String personcomp,
				String spousecomp, String tasksignuserid, String task1time,
				String guaranteecomp, String personcomphone,
				String taskexamine1time, String createtime,
				String guaranteesalary, String level2userid,
				String spousemobile, String spousecertno, String tasksignflag,
				String carlogotype, String personsalary,
				String suggestionrate2, String suggestionrate1,
				String institution, String level1time, String personhouseaddr,
				String level1userid, String level2date, String implementflag,
				String task2date, String branchsuggestion,
				String partnercertno, String applyid, String installmentamount,
				String partnersalary, String carprice, String task2time,
				String level2username, String level1username,
				String level3time, String guaranteename, String personcomptype,
				String suggestionmoney2, String suggestionmoney1) {
			super();
			this.levelsigntime = levelsigntime;
			this.suggestionpercentage1 = suggestionpercentage1;
			this.suggestionpercentage2 = suggestionpercentage2;
			this.carcoowner = carcoowner;
			this.implementtime = implementtime;
			this.installmentperiods = installmentperiods;
			this.userid = userid;
			this.createdate = createdate;
			this.partnercomptype = partnercomptype;
			this.level1date = level1date;
			this.username = username;
			this.zoneno = zoneno;
			this.familyrepay = familyrepay;
			this.personcredit = personcredit;
			this.personedu = personedu;
			this.branchno = branchno;
			this.shenchausername = shenchausername;
			this.carlogo = carlogo;
			this.personhousetype = personhousetype;
			this.level3date = level3date;
			this.guaranteecredit = guaranteecredit;
			this.personmarriage = personmarriage;
			this.backreason = backreason;
			this.partnercerttype = partnercerttype;
			this.comprehsubmitdate = comprehsubmitdate;
			this.task1flag = task1flag;
			this.guarantyname = guarantyname;
			this.spousecerttype = spousecerttype;
			this.spousesalary = spousesalary;
			this.personfamily = personfamily;
			this.personid = personid;
			this.level4date = level4date;
			this.taskexamine1userid = taskexamine1userid;
			this.partnercredit = partnercredit;
			this.businessno = businessno;
			this.personsex = personsex;
			this.backlevel = backlevel;
			this.task1date = task1date;
			this.task2userid = task2userid;
			this.task1userid = task1userid;
			this.contact = contact;
			this.taskcomprehdate = taskcomprehdate;
			this.partnercompaddr = partnercompaddr;
			this.level3username = level3username;
			this.taskcomprehtime = taskcomprehtime;
			this.level3userid = level3userid;
			this.taskcomprehuserid = taskcomprehuserid;
			this.taskexamine1flag = taskexamine1flag;
			this.submittime = submittime;
			this.level4username = level4username;
			this.partnercomp = partnercomp;
			this.partnerrelation = partnerrelation;
			this.personbirth = personbirth;
			this.taskcomprehflag = taskcomprehflag;
			this.spousecompaddr = spousecompaddr;
			this.guaranteetype = guaranteetype;
			this.carseller = carseller;
			this.qianpiusername = qianpiusername;
			this.persontype = persontype;
			this.spousename = spousename;
			this.guarantyprice = guarantyprice;
			this.spouseduty = spouseduty;
			this.personrepay = personrepay;
			this.institutionaddr = institutionaddr;
			this.carmanufacturer = carmanufacturer;
			this.personcerttype = personcerttype;
			this.salesmanphone = salesmanphone;
			this.remark = remark;
			this.submitdate = submitdate;
			this.suggestionlimit2 = suggestionlimit2;
			this.spousecomptype = spousecomptype;
			this.suggestionlimit1 = suggestionlimit1;
			this.cartype = cartype;
			this.level4userid = level4userid;
			this.spousecomphone = spousecomphone;
			this.shenchasubmittime = shenchasubmittime;
			this.partnermobile = partnermobile;
			this.carguideprice = carguideprice;
			this.level2time = level2time;
			this.suggestionperiods2 = suggestionperiods2;
			this.suggestionperiods1 = suggestionperiods1;
			this.carexhaust = carexhaust;
			this.guaranteehousetype = guaranteehousetype;
			this.spousecredit = spousecredit;
			this.status = status;
			this.salesmanid = salesmanid;
			this.taskexamine1date = taskexamine1date;
			this.personcompaddr = personcompaddr;
			this.shenchasubmitdate = shenchasubmitdate;
			this.task2flag = task2flag;
			this.suggestionfee2 = suggestionfee2;
			this.tasksigndate = tasksigndate;
			this.salesman = salesman;
			this.suggestionfee1 = suggestionfee1;
			this.levelsigndate = levelsigndate;
			this.partnercomphone = partnercomphone;
			this.tasksigntime = tasksigntime;
			this.personmobile = personmobile;
			this.partnername = partnername;
			this.partnerbirth = partnerbirth;
			this.contactphone = contactphone;
			this.comprehsubmittime = comprehsubmittime;
			this.carflag = carflag;
			this.cardno = cardno;
			this.personduty = personduty;
			this.implementdate = implementdate;
			this.personname = personname;
			this.partnerduty = partnerduty;
			this.personcertno = personcertno;
			this.personhome = personhome;
			this.spousebirth = spousebirth;
			this.personcomp = personcomp;
			this.spousecomp = spousecomp;
			this.tasksignuserid = tasksignuserid;
			this.task1time = task1time;
			this.guaranteecomp = guaranteecomp;
			this.personcomphone = personcomphone;
			this.taskexamine1time = taskexamine1time;
			this.createtime = createtime;
			this.guaranteesalary = guaranteesalary;
			this.level2userid = level2userid;
			this.spousemobile = spousemobile;
			this.spousecertno = spousecertno;
			this.tasksignflag = tasksignflag;
			this.carlogotype = carlogotype;
			this.personsalary = personsalary;
			this.suggestionrate2 = suggestionrate2;
			this.suggestionrate1 = suggestionrate1;
			this.institution = institution;
			this.level1time = level1time;
			this.personhouseaddr = personhouseaddr;
			this.level1userid = level1userid;
			this.level2date = level2date;
			this.implementflag = implementflag;
			this.task2date = task2date;
			this.branchsuggestion = branchsuggestion;
			this.partnercertno = partnercertno;
			this.applyid = applyid;
			this.installmentamount = installmentamount;
			this.partnersalary = partnersalary;
			this.carprice = carprice;
			this.task2time = task2time;
			this.level2username = level2username;
			this.level1username = level1username;
			this.level3time = level3time;
			this.guaranteename = guaranteename;
			this.personcomptype = personcomptype;
			this.suggestionmoney2 = suggestionmoney2;
			this.suggestionmoney1 = suggestionmoney1;
		}

		public Applybc() {
			super();
		}

		@Override
		public String toString() {
			return "Applybc [levelsigntime=" + levelsigntime
					+ ", suggestionpercentage1=" + suggestionpercentage1
					+ ", suggestionpercentage2=" + suggestionpercentage2
					+ ", carcoowner=" + carcoowner + ", implementtime="
					+ implementtime + ", installmentperiods="
					+ installmentperiods + ", userid=" + userid
					+ ", createdate=" + createdate + ", partnercomptype="
					+ partnercomptype + ", level1date=" + level1date
					+ ", username=" + username + ", zoneno=" + zoneno
					+ ", familyrepay=" + familyrepay + ", personcredit="
					+ personcredit + ", personedu=" + personedu + ", branchno="
					+ branchno + ", shenchausername=" + shenchausername
					+ ", carlogo=" + carlogo + ", personhousetype="
					+ personhousetype + ", level3date=" + level3date
					+ ", guaranteecredit=" + guaranteecredit
					+ ", personmarriage=" + personmarriage + ", backreason="
					+ backreason + ", partnercerttype=" + partnercerttype
					+ ", comprehsubmitdate=" + comprehsubmitdate
					+ ", task1flag=" + task1flag + ", guarantyname="
					+ guarantyname + ", spousecerttype=" + spousecerttype
					+ ", spousesalary=" + spousesalary + ", personfamily="
					+ personfamily + ", personid=" + personid + ", level4date="
					+ level4date + ", taskexamine1userid=" + taskexamine1userid
					+ ", partnercredit=" + partnercredit + ", businessno="
					+ businessno + ", personsex=" + personsex + ", backlevel="
					+ backlevel + ", task1date=" + task1date + ", task2userid="
					+ task2userid + ", task1userid=" + task1userid
					+ ", contact=" + contact + ", taskcomprehdate="
					+ taskcomprehdate + ", partnercompaddr=" + partnercompaddr
					+ ", level3username=" + level3username
					+ ", taskcomprehtime=" + taskcomprehtime
					+ ", level3userid=" + level3userid + ", taskcomprehuserid="
					+ taskcomprehuserid + ", taskexamine1flag="
					+ taskexamine1flag + ", submittime=" + submittime
					+ ", level4username=" + level4username + ", partnercomp="
					+ partnercomp + ", partnerrelation=" + partnerrelation
					+ ", personbirth=" + personbirth + ", taskcomprehflag="
					+ taskcomprehflag + ", spousecompaddr=" + spousecompaddr
					+ ", guaranteetype=" + guaranteetype + ", carseller="
					+ carseller + ", qianpiusername=" + qianpiusername
					+ ", persontype=" + persontype + ", spousename="
					+ spousename + ", guarantyprice=" + guarantyprice
					+ ", spouseduty=" + spouseduty + ", personrepay="
					+ personrepay + ", institutionaddr=" + institutionaddr
					+ ", carmanufacturer=" + carmanufacturer
					+ ", personcerttype=" + personcerttype + ", salesmanphone="
					+ salesmanphone + ", remark=" + remark + ", submitdate="
					+ submitdate + ", suggestionlimit2=" + suggestionlimit2
					+ ", spousecomptype=" + spousecomptype
					+ ", suggestionlimit1=" + suggestionlimit1 + ", cartype="
					+ cartype + ", level4userid=" + level4userid
					+ ", spousecomphone=" + spousecomphone
					+ ", shenchasubmittime=" + shenchasubmittime
					+ ", partnermobile=" + partnermobile + ", carguideprice="
					+ carguideprice + ", level2time=" + level2time
					+ ", suggestionperiods2=" + suggestionperiods2
					+ ", suggestionperiods1=" + suggestionperiods1
					+ ", carexhaust=" + carexhaust + ", guaranteehousetype="
					+ guaranteehousetype + ", spousecredit=" + spousecredit
					+ ", status=" + status + ", salesmanid=" + salesmanid
					+ ", taskexamine1date=" + taskexamine1date
					+ ", personcompaddr=" + personcompaddr
					+ ", shenchasubmitdate=" + shenchasubmitdate
					+ ", task2flag=" + task2flag + ", suggestionfee2="
					+ suggestionfee2 + ", tasksigndate=" + tasksigndate
					+ ", salesman=" + salesman + ", suggestionfee1="
					+ suggestionfee1 + ", levelsigndate=" + levelsigndate
					+ ", partnercomphone=" + partnercomphone
					+ ", tasksigntime=" + tasksigntime + ", personmobile="
					+ personmobile + ", partnername=" + partnername
					+ ", partnerbirth=" + partnerbirth + ", contactphone="
					+ contactphone + ", comprehsubmittime=" + comprehsubmittime
					+ ", carflag=" + carflag + ", cardno=" + cardno
					+ ", personduty=" + personduty + ", implementdate="
					+ implementdate + ", personname=" + personname
					+ ", partnerduty=" + partnerduty + ", personcertno="
					+ personcertno + ", personhome=" + personhome
					+ ", spousebirth=" + spousebirth + ", personcomp="
					+ personcomp + ", spousecomp=" + spousecomp
					+ ", tasksignuserid=" + tasksignuserid + ", task1time="
					+ task1time + ", guaranteecomp=" + guaranteecomp
					+ ", personcomphone=" + personcomphone
					+ ", taskexamine1time=" + taskexamine1time
					+ ", createtime=" + createtime + ", guaranteesalary="
					+ guaranteesalary + ", level2userid=" + level2userid
					+ ", spousemobile=" + spousemobile + ", spousecertno="
					+ spousecertno + ", tasksignflag=" + tasksignflag
					+ ", carlogotype=" + carlogotype + ", personsalary="
					+ personsalary + ", suggestionrate2=" + suggestionrate2
					+ ", suggestionrate1=" + suggestionrate1 + ", institution="
					+ institution + ", level1time=" + level1time
					+ ", personhouseaddr=" + personhouseaddr
					+ ", level1userid=" + level1userid + ", level2date="
					+ level2date + ", implementflag=" + implementflag
					+ ", task2date=" + task2date + ", branchsuggestion="
					+ branchsuggestion + ", partnercertno=" + partnercertno
					+ ", applyid=" + applyid + ", installmentamount="
					+ installmentamount + ", partnersalary=" + partnersalary
					+ ", carprice=" + carprice + ", task2time=" + task2time
					+ ", level2username=" + level2username
					+ ", level1username=" + level1username + ", level3time="
					+ level3time + ", guaranteename=" + guaranteename
					+ ", personcomptype=" + personcomptype
					+ ", suggestionmoney2=" + suggestionmoney2
					+ ", suggestionmoney1=" + suggestionmoney1 + "]";
		}

	}

	public class Applybc_file {
		private String birthday;

		private String phone;

		private String sex;

		private String usercode;

		private String lh_url;

		private String yyhke;

		private String togather_url;

		private String cert2_url;

		private String mph_url;

		private String personedu;

		private String certtype;

		private String name;

		private String cert1_url;

		private String credit;

		private String avgmoney;

		private String marry;

		private String cert3_url;

		private String dw_url;

		private String workphone;

		private String zzzm_url;

		private String zzzk;

		private String workname;

		private String job;

		private String customerid;

		private String certnum;

		private String dy_url;

		private String applybc_id;

		private String xq_url;

		private String worktype;

		public void setBirthday(String birthday) {
			this.birthday = birthday;
		}

		public String getBirthday() {
			return this.birthday;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getPhone() {
			return this.phone;
		}

		public void setSex(String sex) {
			this.sex = sex;
		}

		public String getSex() {
			return this.sex;
		}

		public void setUsercode(String usercode) {
			this.usercode = usercode;
		}

		public String getUsercode() {
			return this.usercode;
		}

		public void setLh_url(String lh_url) {
			this.lh_url = lh_url;
		}

		public String getLh_url() {
			return this.lh_url;
		}

		public void setYyhke(String yyhke) {
			this.yyhke = yyhke;
		}

		public String getYyhke() {
			return this.yyhke;
		}

		public void setTogather_url(String togather_url) {
			this.togather_url = togather_url;
		}

		public String getTogather_url() {
			return this.togather_url;
		}

		public void setCert2_url(String cert2_url) {
			this.cert2_url = cert2_url;
		}

		public String getCert2_url() {
			return this.cert2_url;
		}

		public void setMph_url(String mph_url) {
			this.mph_url = mph_url;
		}

		public String getMph_url() {
			return this.mph_url;
		}

		public void setPersonedu(String personedu) {
			this.personedu = personedu;
		}

		public String getPersonedu() {
			return this.personedu;
		}

		public void setCerttype(String certtype) {
			this.certtype = certtype;
		}

		public String getCerttype() {
			return this.certtype;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getName() {
			return this.name;
		}

		public void setCert1_url(String cert1_url) {
			this.cert1_url = cert1_url;
		}

		public String getCert1_url() {
			return this.cert1_url;
		}

		public void setCredit(String credit) {
			this.credit = credit;
		}

		public String getCredit() {
			return this.credit;
		}

		public void setAvgmoney(String avgmoney) {
			this.avgmoney = avgmoney;
		}

		public String getAvgmoney() {
			return this.avgmoney;
		}

		public void setMarry(String marry) {
			this.marry = marry;
		}

		public String getMarry() {
			return this.marry;
		}

		public void setCert3_url(String cert3_url) {
			this.cert3_url = cert3_url;
		}

		public String getCert3_url() {
			return this.cert3_url;
		}

		public void setDw_url(String dw_url) {
			this.dw_url = dw_url;
		}

		public String getDw_url() {
			return this.dw_url;
		}

		public void setWorkphone(String workphone) {
			this.workphone = workphone;
		}

		public String getWorkphone() {
			return this.workphone;
		}

		public void setZzzm_url(String zzzm_url) {
			this.zzzm_url = zzzm_url;
		}

		public String getZzzm_url() {
			return this.zzzm_url;
		}

		public void setZzzk(String zzzk) {
			this.zzzk = zzzk;
		}

		public String getZzzk() {
			return this.zzzk;
		}

		public void setWorkname(String workname) {
			this.workname = workname;
		}

		public String getWorkname() {
			return this.workname;
		}

		public void setJob(String job) {
			this.job = job;
		}

		public String getJob() {
			return this.job;
		}

		public void setCustomerid(String customerid) {
			this.customerid = customerid;
		}

		public String getCustomerid() {
			return this.customerid;
		}

		public void setCertnum(String certnum) {
			this.certnum = certnum;
		}

		public String getCertnum() {
			return this.certnum;
		}

		public void setDy_url(String dy_url) {
			this.dy_url = dy_url;
		}

		public String getDy_url() {
			return this.dy_url;
		}

		public void setApplybc_id(String applybc_id) {
			this.applybc_id = applybc_id;
		}

		public String getApplybc_id() {
			return this.applybc_id;
		}

		public void setXq_url(String xq_url) {
			this.xq_url = xq_url;
		}

		public String getXq_url() {
			return this.xq_url;
		}

		public void setWorktype(String worktype) {
			this.worktype = worktype;
		}

		public String getWorktype() {
			return this.worktype;
		}

		public Applybc_file(String birthday, String phone, String sex,
				String usercode, String lh_url, String yyhke,
				String togather_url, String cert2_url, String mph_url,
				String personedu, String certtype, String name,
				String cert1_url, String credit, String avgmoney, String marry,
				String cert3_url, String dw_url, String workphone,
				String zzzm_url, String zzzk, String workname, String job,
				String customerid, String certnum, String dy_url,
				String applybc_id, String xq_url, String worktype) {
			super();
			this.birthday = birthday;
			this.phone = phone;
			this.sex = sex;
			this.usercode = usercode;
			this.lh_url = lh_url;
			this.yyhke = yyhke;
			this.togather_url = togather_url;
			this.cert2_url = cert2_url;
			this.mph_url = mph_url;
			this.personedu = personedu;
			this.certtype = certtype;
			this.name = name;
			this.cert1_url = cert1_url;
			this.credit = credit;
			this.avgmoney = avgmoney;
			this.marry = marry;
			this.cert3_url = cert3_url;
			this.dw_url = dw_url;
			this.workphone = workphone;
			this.zzzm_url = zzzm_url;
			this.zzzk = zzzk;
			this.workname = workname;
			this.job = job;
			this.customerid = customerid;
			this.certnum = certnum;
			this.dy_url = dy_url;
			this.applybc_id = applybc_id;
			this.xq_url = xq_url;
			this.worktype = worktype;
		}

		public Applybc_file() {
			super();
		}

		@Override
		public String toString() {
			return "Applybc_file [birthday=" + birthday + ", phone=" + phone
					+ ", sex=" + sex + ", usercode=" + usercode + ", lh_url="
					+ lh_url + ", yyhke=" + yyhke + ", togather_url="
					+ togather_url + ", cert2_url=" + cert2_url + ", mph_url="
					+ mph_url + ", personedu=" + personedu + ", certtype="
					+ certtype + ", name=" + name + ", cert1_url=" + cert1_url
					+ ", credit=" + credit + ", avgmoney=" + avgmoney
					+ ", marry=" + marry + ", cert3_url=" + cert3_url
					+ ", dw_url=" + dw_url + ", workphone=" + workphone
					+ ", zzzm_url=" + zzzm_url + ", zzzk=" + zzzk
					+ ", workname=" + workname + ", job=" + job
					+ ", customerid=" + customerid + ", certnum=" + certnum
					+ ", dy_url=" + dy_url + ", applybc_id=" + applybc_id
					+ ", xq_url=" + xq_url + ", worktype=" + worktype + "]";
		}

	}

}
