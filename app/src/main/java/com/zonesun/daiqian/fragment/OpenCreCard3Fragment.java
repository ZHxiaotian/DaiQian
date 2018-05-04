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

public class OpenCreCard3Fragment extends Fragment {

	@Bind(R.id.et_ddtrxtype)
	public EditText  et_ddtrxtype;//自动还款交易类型
	@Bind(R.id.et_outacctype1)
	public EditText  et_outacctype1;//自动还款转出帐户类型1
	@Bind(R.id.et_outacctype2)
	public EditText  et_outacctype2;//自动还款转出帐户类型2
	@Bind(R.id.et_outcardno1)
	public EditText  et_outcardno1;//转出卡号/帐号1
	@Bind(R.id.et_outcardno2)
	public EditText  et_outcardno2;//转出卡号/帐号2
	@Bind(R.id.et_ddamttype1)
	public EditText  et_ddamttype1;//还款金额类型1
	@Bind(R.id.et_ddamttype2)
	public EditText  et_ddamttype2;//还款金额类型2
	@Bind(R.id.et_paydays)
	public EditText  et_paydays;//提前还款天数
	@Bind(R.id.et_partpayf1)
	public EditText  et_partpayf1;//部分还款1
	@Bind(R.id.et_partpayf2)
	public EditText  et_partpayf2;//部分还款2
	@Bind(R.id.et_machgf)
	public EditText  et_machgf;//主卡开通余额变动提醒
	@Bind(R.id.et_mamobile)
	public EditText  et_mamobile;//主卡发送移动电话
	@Bind(R.id.et_marmbamt)
	public EditText  et_marmbamt;//主卡人民币定制金额
	@Bind(R.id.et_maforamt)
	public EditText  et_maforamt;//主卡外币定制金额
	@Bind(R.id.et_dechgf1)
	public EditText  et_dechgf1;//副卡一开通余额变动提醒
	@Bind(R.id.et_demobile1)
	public EditText  et_demobile1;//副卡一发送移动电话
	@Bind(R.id.et_dermbamt1)
	public EditText  et_dermbamt1;//副卡一人民币定制金额
	@Bind(R.id.et_deforamt1)
	public EditText  et_deforamt1;//副卡一外币定制金额
	@Bind(R.id.et_decallf1)
	public EditText  et_decallf1;//副卡一短信定制期限
	@Bind(R.id.et_decallexf1)
	public EditText  et_decallexf1;//副卡一短信自动展期
	@Bind(R.id.et_dechgf2)
	public EditText  et_dechgf2;//副卡二开通余额变动提醒
	@Bind(R.id.et_demobile2)
	public EditText  et_demobile2;//副卡二发送移动电话
	@Bind(R.id.et_dermbamt2)
	public EditText  et_dermbamt2;//副卡二人民币定制金额
	@Bind(R.id.et_deforamt2)
	public EditText  et_deforamt2;//副卡二外币定制金额
	@Bind(R.id.et_decallf2)
	public EditText  et_decallf2;//副卡二短信定制期限
	@Bind(R.id.et_decallexf2)
	public EditText  et_decallexf2;//副卡二短信自动展期
	@Bind(R.id.et_emaladdrf)
	public EditText  et_emaladdrf;//开通email对账单
	@Bind(R.id.et_stmtemail)
	public EditText  et_stmtemail;//对帐单EMAIL
	@Bind(R.id.et_wardidtype)
	public EditText  et_wardidtype;//监护人证件类型
	@Bind(R.id.et_wardidcode)
	public EditText  et_wardidcode;//监护人证件号码
	@Bind(R.id.et_wardchsname)
	public EditText  et_wardchsname;//监护人姓名
	@Bind(R.id.et_dewardidty1)
	public EditText  et_dewardidty1;//副卡一监护人证件类型
	@Bind(R.id.et_dewardid1)
	public EditText  et_dewardid1;//副卡一监护人证件号码
	@Bind(R.id.et_dewardname1)
	public EditText  et_dewardname1;//副卡一监护人姓名
	@Bind(R.id.et_dewardidty2)
	public EditText  et_dewardidty2;//副卡二监护人证件类型
	@Bind(R.id.et_dewardid2)
	public EditText  et_dewardid2;//副卡二监护人证件号码
	@Bind(R.id.et_dewardname2)
	public EditText  et_dewardname2;//副卡二监护人姓名
	@Bind(R.id.et_outcashexf1)
	public EditText  et_outcashexf1;//转出方钞汇标志1
	@Bind(R.id.et_outcashexf2)
	public EditText  et_outcashexf2;//转出方钞汇标志2
	@Bind(R.id.et_lowtramt)
	public EditText  et_lowtramt;//自动还款余额标准
	@Bind(R.id.et_tranamt)
	public EditText  et_tranamt;//还款后帐户余额
	@Bind(R.id.et_picno)
	public EditText  et_picno;//图片编码
	@Bind(R.id.et_picno1)
	public EditText  et_picno1;//副卡1图片编码
	@Bind(R.id.et_picno2)
	public EditText  et_picno2;//副卡2图片编码
	@Bind(R.id.et_scdmdu)
	public EditText  et_scdmdu;//发附属卡标志
	@Bind(R.id.et_scdmdu1)
	public EditText  et_scdmdu1;//副卡1发附属卡标志
	@Bind(R.id.et_scdmdu2)
	public EditText  et_scdmdu2;//副卡2发附属卡标志
	@Bind(R.id.et_sicnno)
	public EditText  et_sicnno;//主卡附属卡个性化编码
	@Bind(R.id.et_sicnno1)
	public EditText  et_sicnno1;//副卡1附属卡个性化编码
	@Bind(R.id.et_sicnno2)
	public EditText  et_sicnno2;//副卡2附属卡个性化编码
	@Bind(R.id.et_spicno)
	public EditText  et_spicno;//主卡附属卡图片编码
	@Bind(R.id.et_spicno1)
	public EditText  et_spicno1;//副卡1附属卡图片编码
	@Bind(R.id.et_spicno2)
	public EditText  et_spicno2;//副卡2附属卡图片编码
	@Bind(R.id.et_smsaddrf)
	public EditText  et_smsaddrf;//开通短信对账单
	@Bind(R.id.et_smsphone)
	public EditText  et_smsphone;//发送短信帐单手机号码
	@Bind(R.id.et_qesno)
	public EditText  et_qesno;//问题编号
	@Bind(R.id.et_answer)
	public EditText  et_answer;//问题答案
	@Bind(R.id.et_crdrflag)
	public EditText  et_crdrflag;//产品标志
	@Bind(R.id.et_crdrflag1)
	public EditText  et_crdrflag1;//副卡一产品标志
	@Bind(R.id.et_crdrflag2)
	public EditText  et_crdrflag2;//副卡二产品标志
	@Bind(R.id.et_scrdrflag)
	public EditText  et_scrdrflag;//附属卡产品标志
	@Bind(R.id.et_scrdrflag1)
	public EditText  et_scrdrflag1;//副卡一附属卡产品标志
	@Bind(R.id.et_scrdrflag2)
	public EditText  et_scrdrflag2;//副卡二附属卡产品标志
	@Bind(R.id.et_crdropf)
	public EditText  et_crdropf;//借记贷记联动开关
	@Bind(R.id.et_crdropf1)
	public EditText  et_crdropf1;//副卡一借记贷记联动开关
	@Bind(R.id.et_crdropf2)
	public EditText  et_crdropf2;//副卡二借记贷记联动开关
	@Bind(R.id.et_scrdropf)
	public EditText  et_scrdropf;//附属卡借记贷记联动开关
	@Bind(R.id.et_scrdropf1)
	public EditText  et_scrdropf1;//副卡一附属卡借记贷记联动开关
	@Bind(R.id.et_scrdropf2)
	public EditText  et_scrdropf2;//副卡二附属卡借记贷记联动开关
	@Bind(R.id.et_fundopf)
	public EditText  et_fundopf;//批量资金归集开关
	@Bind(R.id.et_fundopf1)
	public EditText  et_fundopf1;//副卡一批量资金归集开关
	@Bind(R.id.et_fundopf2)
	public EditText  et_fundopf2;//副卡二批量资金归集开关
	@Bind(R.id.et_sfundopf)
	public EditText  et_sfundopf;//附属卡批量资金归集开关
	@Bind(R.id.et_sfundopf1)
	public EditText  et_sfundopf1;//副卡一附属卡批量资金归集开关
	@Bind(R.id.et_sfundopf2)
	public EditText  et_sfundopf2;//副卡二附属卡批量资金归集开关
	@Bind(R.id.et_fcrdropf)
	public EditText  et_fcrdropf;//借记贷记联动开关(外币)
	@Bind(R.id.et_fcrdropf1)
	public EditText  et_fcrdropf1;//副卡一借记贷记联动开关(外币)
	@Bind(R.id.et_fcrdropf2)
	public EditText  et_fcrdropf2;//副卡二借记贷记联动开关(外币)
	@Bind(R.id.et_sfcrdropf)
	public EditText  et_sfcrdropf;//附属卡借记贷记联动开关(外币)
	@Bind(R.id.et_sfcrfropf1)
	public EditText  et_sfcrfropf1;//副卡一附属卡借记贷记联动开关(外币)
	@Bind(R.id.et_sfcrdropf2)
	public EditText  et_sfcrdropf2;//副卡二附属卡借记贷记联动开关(外币)
	@Bind(R.id.et_ffundopf)
	public EditText  et_ffundopf;//批量资金归集开关(外币)
	@Bind(R.id.et_ffundopf1)
	public EditText  et_ffundopf1;//副卡一批量资金归集开关(外币)
	@Bind(R.id.et_ffundopf2)
	public EditText  et_ffundopf2;//副卡二批量资金归集开关(外币)
	@Bind(R.id.et_sffundopf)
	public EditText  et_sffundopf;//附属卡批量资金归集开关(外币)
	@Bind(R.id.et_sffundopf1)
	public EditText  et_sffundopf1;//副卡一附属卡批量资金归集开关(外币)
	@Bind(R.id.et_sffundopf2)
	public EditText  et_sffundopf2;//副卡二附属卡批量资金归集开关(外币)
	@Bind(R.id.et_cityno)
	public EditText  et_cityno;//城市圈编号
	@Bind(R.id.et_chkflg)
	public EditText  et_chkflg;//联网核查结果
	@Bind(R.id.et_dechkflg1)
	public EditText  et_dechkflg1;//副卡1联网核查结果
	@Bind(R.id.et_dechkflg2)
	public EditText  et_dechkflg2;//副卡2联网核查结果
	@Bind(R.id.et_chkdesc)
	public EditText  et_chkdesc;//核查结果说明
	@Bind(R.id.et_dechkdesc1)
	public EditText  et_dechkdesc1;//副卡1核查结果说明
	@Bind(R.id.et_dechkdesc2)
	public EditText  et_dechkdesc2;//副卡2核查结果说明
	@Bind(R.id.et_signflg)
	public EditText  et_signflg;//亲见客户签名
	@Bind(R.id.et_designflg1)
	public EditText  et_designflg1;//副卡1亲见客户签名
	@Bind(R.id.et_designflg2)
	public EditText  et_designflg2;//副卡2亲见客户签名
	@Bind(R.id.et_atmtxflg)
	public EditText  et_atmtxflg;//ATM转帐标志
	@Bind(R.id.et_deatmtxflg1)
	public EditText  et_deatmtxflg1;//副卡1ATM转帐标志
	@Bind(R.id.et_deatmtxflg2)
	public EditText  et_deatmtxflg2;//副卡2ATM转帐标志

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v=View.inflate(getActivity(), R.layout.fragment_creditcard3,null);
		// TODO Auto-generated method stub
		ButterKnife.bind(this, v);
		return v;
	
	}
	
	
	
}
