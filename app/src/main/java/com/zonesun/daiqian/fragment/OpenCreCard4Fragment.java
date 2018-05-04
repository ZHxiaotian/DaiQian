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

public class OpenCreCard4Fragment extends Fragment {

	@Bind(R.id.et_postxflg)
	public EditText et_postxflg;// POS转帐标志
	@Bind(R.id.et_depostxflg1)
	public EditText et_depostxflg1;// 副卡1POS转帐标志
	@Bind(R.id.et_depostxflg2)
	public EditText et_depostxflg2;// 副卡2POS转帐标志
	@Bind(R.id.et_slftxflg)
	public EditText et_slftxflg;// 自助终端转帐标志
	@Bind(R.id.et_deslftxflg1)
	public EditText et_deslftxflg1;// 副卡1自助终端转帐标志
	@Bind(R.id.et_deslftxflg2)
	public EditText et_deslftxflg2;// 副卡2自助终端转帐标志
	@Bind(R.id.et_crdruflag)
	public EditText et_crdruflag;// 主卡是否两卡一U盾套餐
	@Bind(R.id.et_crdrueflag)
	public EditText et_crdrueflag;// 主卡是否追加为网上银行注册账户
	@Bind(R.id.et_crdruflag1)
	public EditText et_crdruflag1;// 副卡1是否两卡一U盾套餐
	@Bind(R.id.et_crdrueflag1)
	public EditText et_crdrueflag1;// 副卡1是否追加为网上银行注册账户
	@Bind(R.id.et_crdruflag2)
	public EditText et_crdruflag2;// 副卡2是否两卡一U盾套餐
	@Bind(R.id.et_deatmtxflg2)
	public EditText et_crdrueflag2;// 副卡2是否追加为网上银行注册账户
	@Bind(R.id.et_fixpday)
	public EditText et_fixpday;// 固定到期还款日标志
	@Bind(R.id.et_accamountflag)
	public EditText et_accamountflag;// 主卡提醒账户余额标志
	@Bind(R.id.et_useramountflag)
	public EditText et_useramountflag;// 主卡提醒可用余额标志
	@Bind(R.id.et_deaccamountflag1)
	public EditText et_deaccamountflag1;// 副卡一提醒账户余额标志
	@Bind(R.id.et_deuseramountflag1)
	public EditText et_deuseramountflag1;// 副卡一提醒可用余额标志
	@Bind(R.id.et_deaccamountflag2)
	public EditText et_deaccamountflag2;// 副卡二提醒账户余额标志
	@Bind(R.id.et_deuseramountflag2)
	public EditText et_deuseramountflag2;// 副卡二提醒可用余额标志
	@Bind(R.id.et_emplyid)
	public EditText et_emplyid;// 主卡员工编号
	@Bind(R.id.et_deemplyid1)
	public EditText et_deemplyid1;// 副卡一员工编号
	@Bind(R.id.et_deemplyid2)
	public EditText et_deemplyid2;// 副卡二员工编号
	@Bind(R.id.et_smobilepay)
	public EditText et_smobilepay;// 附属卡芯片异形卡类型标志
	@Bind(R.id.et_smobilepay1)
	public EditText et_smobilepay1;// 副卡一附属卡芯片异形卡类型标志
	@Bind(R.id.et_smobilepay2)
	public EditText et_smobilepay2;// 副卡二附属卡芯片异形卡类型标志
	@Bind(R.id.et_cuonop)
	public EditText et_cuonop;// 主卡银联境外免输密标志
	@Bind(R.id.et_cuonopamt)
	public EditText et_cuonopamt;// 主卡银联境外免输密网络交易限额
	@Bind(R.id.et_cuonop1)
	public EditText et_cuonop1;// 副卡一银联境外免输密标志
	@Bind(R.id.et_cuonop2)
	public EditText et_cuonop2;// 副卡二银联境外免输密标志
	@Bind(R.id.et_cuonopamt2)
	public EditText et_cuonopamt2;// 副卡二银联境外免输密网络交易限额
	@Bind(R.id.et_cuonopa)
	public EditText et_cuonopa;// 主卡附属卡银联境外免输密标志
	@Bind(R.id.et_cuonopamta)
	public EditText et_cuonopamta;// 主卡附属卡银联境外免输密网络交易限额
	@Bind(R.id.et_cuonop1a)
	public EditText et_cuonop1a;// 副卡一附属卡银联境外免输密标志
	@Bind(R.id.et_cuonopamt1a)
	public EditText et_cuonopamt1a;// 副卡一附属卡银联境外免输密网络交易限额
	@Bind(R.id.et_cuonop2a)
	public EditText et_cuonop2a;// 副卡二附属卡银联境外免输密标志
	@Bind(R.id.et_cuonopamt2a)
	public EditText et_cuonopamt2a;// 副卡二附属卡银联境外免输密网络交易限额
	@Bind(R.id.et_saleno)
	public EditText et_saleno;// 营销档案编号
	@Bind(R.id.et_ppdzduflg)
	public EditText et_ppdzduflg;// 纸质账单是否合并标志
	@Bind(R.id.et_gjjaccno)
	public EditText et_gjjaccno;// 公积金帐号
	@Bind(R.id.et_acqflag)
	public EditText et_acqflag;// 是否申请绑定专用消费额度标志
	@Bind(R.id.et_assaccno)
	public EditText et_assaccno;// 代发工资帐户
	@Bind(R.id.et_assday)
	public EditText et_assday;// 代发工资日
	@Bind(R.id.et_mminassamt)
	public EditText et_mminassamt;// 月最低代发工资额
	@Bind(R.id.et_drcardno)
	public EditText et_drcardno;// 借记卡卡号
	@Bind(R.id.et_fftrxtype)
	public EditText et_fftrxtype;// 同步签订外币自动还款
	@Bind(R.id.et_authref)
	public EditText et_authref;// 发证机关
	@Bind(R.id.et_brithcry)
	public EditText et_brithcry;// 出生国家
	@Bind(R.id.et_birthcty)
	public EditText et_birthcty;// 出生城市
	@Bind(R.id.et_statdate)
	public EditText et_statdate;// 证件有效期
	@Bind(R.id.et_destdate1)
	public EditText et_destdate1;// 副卡一证件有效期
	@Bind(R.id.et_destdate2)
	public EditText et_destdate2;// 副卡二证件有效期
	@Bind(R.id.et_primnat)
	public EditText et_primnat;// 国籍
	@Bind(R.id.et_empltype)
	public EditText et_empltype;// 所属行业
	@Bind(R.id.et_banknum)
	public EditText et_banknum;// 已有信用卡的银行数
	@Bind(R.id.et_cardsum)
	public EditText et_cardsum;// 已持有信用卡总数（含他行）
	@Bind(R.id.et_creditsum)
	public EditText et_creditsum;// 已持有信用卡授信总额度（含他行）
	@Bind(R.id.et_deprof1)
	public EditText et_deprof1;// 副卡一申请人职业
	@Bind(R.id.et_deprof2)
	public EditText et_deprof2;// 副卡二申请人职业
	@Bind(R.id.et_authtype)
	public EditText et_authtype;// 授信类型

	@Bind(R.id.et_sacctype)
	public EditText et_sacctype;// 特殊帐户控制标志
	@Bind(R.id.et_instalno)
	public EditText et_instalno;// 专项分期业务编号
	@Bind(R.id.et_contractno)
	public EditText et_contractno;// 专项分期合同编号
	@Bind(R.id.et_crtype)
	public EditText et_crtype;// 专项分期分类
	@Bind(R.id.et_assuretype)
	public EditText et_assuretype;// 担保类型
	@Bind(R.id.et_deadline)
	public EditText et_deadline;// 专项分期期限
	@Bind(R.id.et_percent)
	public EditText et_percent;// 专项分期成数
	@Bind(R.id.et_info1)
	public EditText et_info1;// 经销商信息
	@Bind(R.id.et_info2)
	public EditText et_info2;// 担保公司信息
	@Bind(R.id.et_pleamt)
	public EditText et_pleamt;// 质押额度
	@Bind(R.id.et_hypamt)
	public EditText et_hypamt;// 抵押额度
	@Bind(R.id.et_grnamt)
	public EditText et_grnamt;// 保证额度
	@Bind(R.id.et_impamt)
	public EditText et_impamt;// 押品金额
	@Bind(R.id.et_islongterm)
	public EditText et_islongterm;// 证件是否长期有效
	@Bind(R.id.deislongterm1)
	public EditText deislongterm1;// 副卡1证件是否长期有效
	@Bind(R.id.et_deislongterm2)
	public EditText et_deislongterm2;// 副卡2证件是否长期有效
	@Bind(R.id.promotedsrc)
	public EditText promotedsrc;// 推广渠道
	@Bind(R.id.et_de1primnat)
	public EditText et_de1primnat;// 副卡申请人一国籍
	@Bind(R.id.de1adrchoic)
	public EditText de1adrchoic;// 副卡申请人一住宅地址选择
	@Bind(R.id.et_de1addrid)
	public EditText et_de1addrid;// 副卡申请人一住宅地址ID
	@Bind(R.id.deprovince1)
	public EditText deprovince1;// 副卡申请人一住宅地址省份
	@Bind(R.id.et_decity1)
	public EditText et_decity1;// 副卡申请人一住宅地址市
	@Bind(R.id.decounty1)
	public EditText decounty1;// 副卡申请人一住宅地址县（区）
	@Bind(R.id.et_dehaddr1)
	public EditText et_dehaddr1;// 副卡申请人一住宅地址
	@Bind(R.id.et_de1homezip)
	public EditText et_de1homezip;// 副卡申请人一住宅邮编
	@Bind(R.id.et_de2primnat)
	public EditText et_de2primnat;// 副卡申请人二国籍
	@Bind(R.id.et_de2adrchoic)
	public EditText et_de2adrchoic;// 副卡申请人二住宅地址选择
	@Bind(R.id.et_de2addrid)
	public EditText et_de2addrid;// 副卡申请人二住宅地址ID
	@Bind(R.id.et_deprovince)
	public EditText et_deprovince;// 副卡申请人二住宅地址省份
	@Bind(R.id.et_decity2)
	public EditText et_decity2;// 副卡申请人二住宅地址市
	@Bind(R.id.et_decounty2)
	public EditText et_decounty2;// 副卡申请人二住宅地址县（区）
	@Bind(R.id.et_dehaddr2)
	public EditText et_dehaddr2;// 副卡申请人二住宅地址
	@Bind(R.id.et_de2homezip)
	public EditText et_de2homezip;// 副卡申请人二住宅邮编
	@Bind(R.id.et_agentzone)
	public EditText et_agentzone;// 代理发卡地区号
	@Bind(R.id.et_agentbrno)
	public EditText et_agentbrno;// 代理发卡网点号
	@Bind(R.id.et_outsidebid)
	public EditText et_outsidebid;// 外部系统业务编号

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = View.inflate(getActivity(), R.layout.fragment_creditcard4,
				null);
		// TODO Auto-generated method stub
		ButterKnife.bind(this, v);
		return v;

	}

}
