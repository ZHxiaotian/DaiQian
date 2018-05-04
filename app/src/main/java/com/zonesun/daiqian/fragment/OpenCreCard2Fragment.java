package com.zonesun.daiqian.fragment;

import butterknife.Bind;
import butterknife.ButterKnife;

import com.zonesun.daiqian.activity.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class OpenCreCard2Fragment extends Fragment {

	
	@Bind(R.id.et_derelt1)
	public EditText  et_derelt1;//副卡一与主卡关系地址
	@Bind(R.id.et_deuname1)
	public EditText  et_deuname1;//副卡一工作单位名称
	@Bind(R.id.et_demobl1)
	public EditText  et_demobl1;//副卡一手机号码
	@Bind(R.id.et_decophzn1)
	public EditText  et_decophzn1;//副卡一单位电话区号
	@Bind(R.id.et_decophon1)
	public EditText  et_decophon1;//副卡一单位电话号码
	@Bind(R.id.et_decophet1)
	public EditText  et_decophet1;//副卡一单位电话分机
	@Bind(R.id.et_dephhzn1)
	public EditText  et_dephhzn1;//副卡一住宅电话区号
	@Bind(R.id.et_dehphon1)
	public EditText  et_dehphon1;//副卡一住宅电话号码
	@Bind(R.id.et_dehphet1)
	public EditText  et_dehphet1;//副卡一住宅电话分机
	@Bind(R.id.et_deidype2)
	public EditText  et_deidype2;//副卡二证件类型
	@Bind(R.id.et_deidcode2)
	public EditText  et_deidcode2;//副卡二证件号码
	@Bind(R.id.et_dechnnam2)
	public EditText  et_dechnnam2;//副卡二姓名
	@Bind(R.id.et_deengnam2)
	public EditText  et_deengnam2;//副卡二姓名拼音或英文名
	@Bind(R.id.et_desex2)
	public EditText  et_desex2;//副卡二性别
	@Bind(R.id.et_debirth2)
	public EditText  et_debirth2;//副卡二出生日期
	@Bind(R.id.et_derelt2)
	public EditText  et_derelt2;//副卡二与主卡关系
	@Bind(R.id.et_deconame2)
	public EditText  et_deconame2;//副卡二工作单位
	@Bind(R.id.et_demobl2)
	public EditText  et_demobl2;//副卡二手机号码
	@Bind(R.id.et_decophzn2)
	public EditText  et_decophzn2;//副卡二单位电话区号
	@Bind(R.id.et_decophon2)
	public EditText  et_decophon2;//副卡二单位电话号码
	@Bind(R.id.et_decophet2)
	public EditText  et_decophet2;//副卡二单位电话分机
	@Bind(R.id.et_dehphzn2)
	public EditText  et_dehphzn2;//副卡二住宅电话区号
	@Bind(R.id.et_dehphon2)
	public EditText  et_dehphon2;//副卡二住宅电话号码
	@Bind(R.id.et_dehphet2)
	public EditText  et_dehphet2;//副卡二住宅电话分机
	@Bind(R.id.et_omacardno)
	public EditText  et_omacardno;//原主卡卡号
	@Bind(R.id.et_seqno)
	public EditText  et_seqno;//申请卡序号
	@Bind(R.id.et_cardkind)
	public EditText  et_cardkind;//申请卡种
	@Bind(R.id.et_cardloho)
	public EditText  et_cardloho;//申请品牌
	@Bind(R.id.et_cardtype)
	public EditText  et_cardtype;//申请卡类
	@Bind(R.id.et_cardBin)
	public EditText  et_cardBin;//申请卡BIN
	@Bind(R.id.et_brhno)
	public EditText  et_brhno;//联行行号
	@Bind(R.id.et_acceptf)
	public EditText  et_acceptf;//是否接受推荐次级产品
	@Bind(R.id.et_cardmedm)
	public EditText  et_cardmedm;//卡片介质
	@Bind(R.id.et_allyno)
	public EditText  et_allyno;//联名编号
	@Bind(R.id.et_almebno)
	public EditText  et_almebno;//联名单位会员号
	@Bind(R.id.et_agrunno)
	public EditText  et_agrunno;//认同编号
	@Bind(R.id.et_fcurrtyp)
	public EditText  et_fcurrtyp;//币种
	@Bind(R.id.et_colrflag)
	public EditText  et_colrflag;//彩照卡标志
	@Bind(R.id.et_expdate)
	public EditText  et_expdate;//有效期
	@Bind(R.id.et_feeflag)
	public EditText  et_feeflag;//年费标志
	@Bind(R.id.et_frfeeflag)
	public EditText  et_frfeeflag;//免年费标志
	@Bind(R.id.et_pswsetm)
	public EditText  et_pswsetm;//密码设置方式
	@Bind(R.id.et_pswflag)
	public EditText  et_pswflag;//自定义消费输密标志
	@Bind(R.id.et_pswlamt)
	public EditText  et_pswlamt;//自定义消费输密限额
	@Bind(R.id.et_accgetm)
	public EditText  et_accgetm;//对帐单寄送方式
	@Bind(R.id.et_accstday)
	public EditText  et_accstday;//对帐单日
	@Bind(R.id.et_accaddrf)
	public EditText  et_accaddrf;//对帐单寄送地址
	@Bind(R.id.et_dutyflag)
	public EditText  et_dutyflag;//责任标志
	@Bind(R.id.et_getcashf)
	public EditText  et_getcashf;//可取现标志
	@Bind(R.id.et_rmbcred)
	public EditText  et_rmbcred;//申请本币额度
	@Bind(R.id.et_ctlcode)
	public EditText  et_ctlcode;//授权控制代码

	@Bind(R.id.et_pct)
	public EditText  et_pct;//通讯地址
	@Bind(R.id.et_drawmode)
	public EditText  et_drawmode;//卡片领取方式
	@Bind(R.id.et_drawaddr)
	public EditText  et_drawaddr;//卡片寄送地址类型
	@Bind(R.id.et_field2)
	public EditText  et_field2;//密码领取方式
	@Bind(R.id.et_pswaddrf)
	public EditText  et_pswaddrf;//密码寄送地址类型
	@Bind(R.id.et_dehcard1)
	public EditText  et_dehcard1;//副卡一办卡
	@Bind(R.id.et_dealmebno1)
	public EditText  et_dealmebno1;//副卡一联名单位会员号
	@Bind(R.id.et_depswflag1)
	public EditText  et_depswflag1;//副卡一自定义消费输密标志
	@Bind(R.id.et_depswlamt1)
	public EditText  et_depswlamt1;//副卡一自定义消费输密限额
	@Bind(R.id.et_ctlcode1)
	public EditText  et_ctlcode1;//副卡一授权控制代码
	@Bind(R.id.et_depct1)
	public EditText  et_depct1;//副卡一卡片控制代码
	@Bind(R.id.et_dehcard2)
	public EditText  et_dehcard2;//副卡二办卡
	@Bind(R.id.et_dealmebno2)
	public EditText  et_dealmebno2;//副卡二联名单位会员号
	@Bind(R.id.et_depswflag2)
	public EditText  et_depswflag2;//副卡二自定义消费输密标志
	@Bind(R.id.et_depswlamt2)
	public EditText  et_depswlamt2;//副卡二自定义消费输密限额
	@Bind(R.id.et_ctlcode2)
	public EditText  et_ctlcode2;//副卡二授权控制代码
	@Bind(R.id.et_depct2)
	public EditText  et_depct2;//副卡二卡片控制代码
	@Bind(R.id.et_ciscophn)
	public EditText  et_ciscophn;//已有客户信息系统登记的单位电话
	@Bind(R.id.et_cisconame)
	public EditText  et_cisconame;//已有客户信息系统登记的单位名称
	@Bind(R.id.et_cishphno)
	public EditText  et_cishphno;//已有客户信息系统登记的住宅电话
	@Bind(R.id.et_cismoblno)
	public EditText  et_cismoblno;//已有客户信息系统登记的移动电话
	@Bind(R.id.et_notes)
	public EditText  et_notes;//预留
	@Bind(R.id.et_emnyuplmt)
	public EditText  et_emnyuplmt;//电子现金余额上限
	@Bind(R.id.et_emyblc)
	public EditText  et_emyblc;//电子现金余额
	@Bind(R.id.et_emycshlmt)
	public EditText  et_emycshlmt;//电子现金单笔交易限额
	@Bind(R.id.et_emnblcfz)
	public EditText  et_emnblcfz;//电子现金余额重置阀值
	@Bind(R.id.et_qcmode)
	public EditText  et_qcmode;//圈存方式
	@Bind(R.id.et_qcemyblc)
	public EditText  et_qcemyblc;//圈存额度
	@Bind(R.id.et_emnyuplmt1)
	public EditText  et_emnyuplmt1;//副卡1电子现金余额上限
	@Bind(R.id.et_emyblc1)
	public EditText  et_emyblc1;//副卡1电子现金余额
	@Bind(R.id.et_emycshlmt1)
	public EditText  et_emycshlmt1;//副卡1电子现金单笔交易
	@Bind(R.id.et_emnblcfz1)
	public EditText  et_emnblcfz1;//副卡1电子现金余额重置阀值
	@Bind(R.id.et_qcmode1)
	public EditText  et_qcmode1;//副卡1圈存方式
	@Bind(R.id.et_qcemyblc1)
	public EditText  et_qcemyblc1;//副卡1圈存额度
	@Bind(R.id.et_emnyuplmt2)
	public EditText  et_emnyuplmt2;//副卡2电子现金余额上限
	@Bind(R.id.et_emyblc2)
	public EditText  et_emyblc2;//副卡2电子现金余额
	@Bind(R.id.et_emycshlmt2)
	public EditText  et_emycshlmt2;//副卡2电子现金单笔交易
	@Bind(R.id.et_emnblcfz2)
	public EditText  et_emnblcfz2;//副卡2电子现金余额重置阀值
	@Bind(R.id.et_qcmode2)
	public EditText  et_qcmode2;//副卡2圈存方式
	@Bind(R.id.et_qcemyblc2)
	public EditText  et_qcemyblc2;//副卡2圈存额度
	@Bind(R.id.et_ecshflage)
	public EditText  et_ecshflage;//电子现金标志
	@Bind(R.id.et_deecshflag1)
	public EditText  et_deecshflag1;//副卡一电子现金标志
	@Bind(R.id.et_deecshflag2)
	public EditText  et_deecshflag2;//副卡二电子现金标志
	@Bind(R.id.et_busicrno)
	public EditText  et_busicrno;//商圈编号
	@Bind(R.id.et_icnno)
	public EditText  et_icnno;//个性化编码
	@Bind(R.id.et_deicnno1)
	public EditText  et_deicnno1;//副卡一个性化编码
	@Bind(R.id.et_deicnno2)
	public EditText  et_deicnno2;//副卡二个性化编码
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v=View.inflate(getActivity(), R.layout.fragment_creditcard2,null);
		// TODO Auto-generated method stub
		ButterKnife.bind(this, v);//注解框架寻找控件id
		return v;
	
	}
	
	
	
}
