package com.zonesun.daiqian.entity;

public class CreditCard2 {

	
	
	
	private String 	DERELT1;//副卡一与主卡关系
	private String  	DEUNAME1;//副卡一工作单位名称
	private String  	DEMOBL1;//副卡一手机号码
	private String     	DECOPHZN1;//副卡一单位电话区号
	private String   	DECOPHON1;// 副卡一单位电话号码
	private String   	DECOPHET1;//副卡一单位电话分机
	private String     	DEHPHZN1; //副卡一住宅电话区号
	private String    DEHPHON1;//副卡一住宅电话号码	
	private String  	DEHPHET1;// 副卡一住宅电话分机
	private String    	DEIDYPE2;//副卡二证件类型
	private String     	DEIDCODE2;//副卡二证件号码
	private String    	DECHNNAM2;// 副卡二姓名
	private String     	DEENGNAM2;//副卡二姓名拼音或英文名
	private String      DESEX2;//副卡二性别	
	private String      	DEBIRTH2;//副卡二出生日期
	private String    	DERELT2;// 副卡二与主卡关系
	private String      	DECONAME2;//副卡二工作单位
	private String      	DEMOBL2;//副卡二手机号码
	private String     	DECOPHZN2;//副卡二单位电话区号
	private String      	DECOPHON2;//副卡二单位电话号码
	private String      	DECOPHET2;//副卡二单位电话分机
	private String      	DEHPHZN2;//副卡二住宅电话区号
	private String       	DEHPHON2;//副卡二住宅电话号码
	private String        	DEHPHET2;//副卡二住宅电话分机
	private String          OMACARDNO;//原主卡卡号	
	private String     SEQNO;// 申请卡序号	
	private String     	CARDKIND;//申请卡种
	private String      	CARDLOGO;//申请品牌
	private String      CARDTYPE;//申请卡类	
	private String      CARDBIN;//申请卡BIN	
	private String      	BRHNO;//联行行号
	private String     	ACCEPTF;//是否接受推荐次级产品
	private String      	CARDMEDM;//卡片介质
	private String      	ALLYNO;//联名编号
	private String         	ALMEBNO;//联名单位会员号
	private String        	AGRUNNO;//认同编号
	private String        	FCURRTYP;//  币种
	private String       	COLRFLAG;// 彩照卡标志
	private String         	EXPDATE;//有效期
	private String        	FEEFLAG;// 年费标志
	private String     	FRFEEFLAG;//  免年费标志
	private String     	PSWSETM;// 密码设置方式
	private String      		PSWFLAG;//自定义消费输密标志
	private String       	PSWLAMT;//自定义消费输密限额
	private String      	ACCGETM;//对帐单寄送方式
	private String       	ACCSTDAY;//对帐单日
	private String       ACCADDRF;//对帐单寄送地址	
	private String      DUTYFLAG;//责任标志	
	private String    	GETCASHF;// 可取现标志
	private String    	RMBCRED;// 申请本币额度
	private String      	CTLCODE;//授权控制代码
	private String      	PCT;//卡片控制代码
	private String      	DRAWMODE;//卡片领取方式
	private String          	DRAWADDR;//卡片寄送地址类型
	private String       	FIELD2;//密码领取方式
	private String         	PSWADDRF;// 密码寄送地址类型
	private String         	DEHCARD1;//副卡一办卡
	private String         	DEALMEBNO1;//副卡一联名单位会员号
	private String       	DEPSWFLAG1;//副卡一自定义消费输密标志
	private String          	DEPSWLAMT1;//副卡一自定义消费输密限额
	private String         	CTLCODE1;//副卡一授权控制代码
	private String           	DEPCT1;//副卡一卡片控制代码
	private String           	DEHCARD2;//副卡二办卡
	private String           	DEALMEBNO2;//副卡二联名单位会员号
	private String            	DEPSWFLAG2;//副卡二自定义消费输密标志
	private String             	DEPSWLAMT2;//副卡二自定义消费输密限额
	private String              	CTLCODE2;//副卡二授权控制代码
	private String              	DEPCT2;//副卡二卡片控制代码
	private String              	CISCOPHN;//已有客户信息系统登记的单位电话
	private String          	CISCONAME;//已有客户信息系统登记的单位名称
	private String              	CISHPHNO;//已有客户信息系统登记的住宅电话
	private String             	CISMOBLNO;//    已有客户信息系统登记的移动电话
	private String             	NOTES;// 预留
	private String             	EMNYUPLMT;// 电子现金余额上限
	private String              	EMYBLC;//电子现金余额
	private String             	EMYCSHLMT;//电子现金单笔交易限额
	private String               	EMNBLCFZ;//电子现金余额重置阀值
	private String               	QCMODE;//圈存方式
	private String                  	QCEMYBLC;//圈存额度
	private String                  	EMNYUPLMT1;//副卡1电子现金余额上限
	private String               	EMYBLC1;//副卡1电子现金余额
	private String                	EMYCSHLMT1;//副卡1电子现金单笔交易
	private String                   	EMNBLCFZ1;//副卡1电子现金余额重置阀值
	private String                	QCMODE1;// 副卡1圈存方式
	private String                  	QCEMYBLC1;// 副卡1圈存额度
	private String                 	EMNYUPLMT2;// 副卡2电子现金余额上限
	private String                 	EMYBLC2;// 副卡2电子现金余额
	private String                   	EMYCSHLMT2;//副卡2电子现金单笔交易
	private String                    	EMNBLCFZ2;//副卡2电子现金余额重置阀值
	private String                 	QCMODE2;// 副卡2圈存方式
	private String                  	QCEMYBLC2;// 副卡2圈存额度
	private String                  	ECSHFLAG;//电子现金标志
	private String                    	DEECSHFLAG1;//副卡一电子现金标志
	private String                   	DEECSHFLAG2;//副卡二电子现金标志
	private String                   	BUSICRNO;// 商圈编号
	private String                  	ICNNO;// 个性化编码
	private String                    	DEICNNO1;// 副卡一个性化编码
	private String                      	DEICNNO2;//副卡二个性化编码
	
}

