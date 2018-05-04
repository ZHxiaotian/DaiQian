package com.zonesun.daiqian.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;
import com.zonesun.daiqian.base.AppManager;
import com.zonesun.daiqian.base.BaseActivity;
import com.zonesun.daiqian.entity.ResearchReportEntity;
import com.zonesun.daiqian.fragment.SlideMenu2Fragment;
import com.zonesun.daiqian.util.Constants;
import com.zonesun.daiqian.util.MyEvent;

import de.greenrobot.event.EventBus;

public class ResearchReport1Activity extends BaseActivity implements
		OnClickListener {

	// ----------------------------申请人摘要----------------------------------------
	// 申请人姓名
	private TextView name_tv;
	// 购车原因
	private TextView reason_tv;
	// 还款来源
	private TextView hkly_tv;
	// 住房情况
	private TextView zfqk_tv;
	// 婚姻情况
	private TextView hyqk_tv;
	// ------------------------------------申请人基本情况-------------------------------
	// 姓名
	private TextView username_tv;
	// 性别
	private TextView sex_tv;
	// 出生年月
	private TextView brithday_tv;
	// 证件类型
	private TextView zjlx_tv;
	// 证件号码
	private TextView zjhm_tv;
	// 住宅地址
	private TextView zzdz_tv;
	// 住宅状况
	private TextView zzzk_tv;
	// 户口所在地
	private TextView hkszd_tv;
	// 手机号码
	private TextView phone_tv;
	// 工作单位
	private TextView gzdw_tv;
	// 职务
	private TextView zw_tv;
	// 单位地址
	private TextView dwdz_tv;
	// 单位电话

	private TextView dwdh_tv;
	// 单位性质
	private TextView dwxz_tv;
	// 月均收入
	private TextView yjsr_tv;
	// 家庭已有贷款月还款额
	private TextView jtyydkyhke_tv;
	// 家庭月收入还贷比
	private TextView jtysrhdb_tv;
	// ------------------------------申请人配偶情况---------------------------------------
	// 配偶姓名
	private TextView poname_tv;
	// 配偶出生年月
	private TextView pobrithday_tv;
	// 配偶证件类型
	private TextView pozjlx_tv;
	// 配偶证件号码
	private TextView pozjhm_tv;
	// 配偶移动电话
	private TextView pophone_tv;
	// 配偶月均收入
	private TextView poyjsr_tv;
	// 配偶单位性质
	private TextView podwxz_tv;
	// 配偶单位名称
	private TextView podwmc_tv;
	// 配偶单位地址
	private TextView podwdz_tv;
	// 配偶单位职务
	private TextView pobrzw_tv;
	// 配偶单位电话
	private TextView podwdh_tv;

	// -------------------------------------调查评价------------------------------------
	// 调查员
	private TextView dcy_tv;
	// -----------------------------------调查资料---------------------------------------
	// 身份证正面
	private ImageView sfzzm_iv;
	// 身份证反面
	private ImageView sfzfm_iv;
	// 手持身份证
	private ImageView scsfz_iv;
	// 与调查员合影
	private ImageView ydcyhy_iv;
	// 资质证明
	private ImageView zzzm_iv;
	// 申请人小区
	private ImageView xq_iv;
	// 申请人所住楼号
	private ImageView lh_iv;
	// 申请人所住单元
	private ImageView dy_iv;
	// 申请人门牌号
	private ImageView mph_iv;
	// 定位
	private ImageView dw_iv;

	private SharedPreferences sp;
	private String MYCOOKIES;
	String applyid;
	private ResearchReportEntity reportEntity;
	private String[] splits;
	private String sfzzmurl;
	private String sfzfmurl;
	private String scsfzurl;
	private String ydcyhyurl;
	private String zzzmurl;
	private String xqurl;
	private String lhurl;
	private String dyurl;
	private String mphurl;
	private String dwurl;
	private Intent intent;
	private TextView tv_titleText;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		// No Titlebar
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		 AppManager.getAppManager().addActivity(this);  
		setContentView(R.layout.activity_research_report1);
//		MyApplication.getInstance().addActivity(this);
		EventBus.getDefault().register(this);

		initView();

		setonclick();

	}

	/**
	 * 设置点击时间
	 */
	private void setonclick() {
		// 身份证正面
		sfzzm_iv.setOnClickListener(this);
		// 身份证反面
		sfzfm_iv.setOnClickListener(this);
		// 手持身份证
		scsfz_iv.setOnClickListener(this);
		// 与调查员合影
		ydcyhy_iv.setOnClickListener(this);
		// 资质证明
		zzzm_iv.setOnClickListener(this);
		// 申请人小区
		xq_iv.setOnClickListener(this);
		// 申请人所住楼号
		lh_iv.setOnClickListener(this);
		// 申请人所住单元
		dy_iv.setOnClickListener(this);
		// 申请人门牌号
		mph_iv.setOnClickListener(this);
		// 定位
		dw_iv.setOnClickListener(this);
	}

	/**
	 * 初始化数据
	 */
	private void initView() {

		// 设置标题文字
		tv_titleText = (TextView) findViewById(R.id.tv_title_text);
		tv_titleText.setText("贷前管理系统》个人设置");// 改变标题文字-->个人设置
		// ------------------申请人摘要--------------------------
		// 申请人姓名
		name_tv = (TextView) this.findViewById(R.id.name_tv);
		// 购车原因
		reason_tv = (TextView) this.findViewById(R.id.reason_tv);
		// 还款来源
		hkly_tv = (TextView) this.findViewById(R.id.hkly_tv);
		// 住房情况
		zfqk_tv = (TextView) this.findViewById(R.id.zfqk_tv);
		// 婚姻情况
		hyqk_tv = (TextView) this.findViewById(R.id.hyqk_tv);

		// ------------------------------------申请人基本情况-------------------------------
		// 姓名
		username_tv = (TextView) this.findViewById(R.id.username_tv);
		// 性别
		sex_tv = (TextView) this.findViewById(R.id.sex_tv);
		// 出生年月
		brithday_tv = (TextView) this.findViewById(R.id.birthday_tv);
		// 证件类型
		zjlx_tv = (TextView) this.findViewById(R.id.zjlx_tv);
		// 证件号码
		zjhm_tv = (TextView) this.findViewById(R.id.zjhm_tv);
		// 住宅地址
		zzdz_tv = (TextView) this.findViewById(R.id.zzdz_tv);
		// 住宅状况
		zzzk_tv = (TextView) this.findViewById(R.id.zzzk_tv);
		// 户口所在地
		hkszd_tv = (TextView) this.findViewById(R.id.hkszd_tv);
		// 手机号码
		phone_tv = (TextView) this.findViewById(R.id.phone_tv);
		// 工作单位
		gzdw_tv = (TextView) this.findViewById(R.id.gzdw_tv);
		// 职务
		zw_tv = (TextView) this.findViewById(R.id.zw_tv);
		// 单位地址
		dwdz_tv = (TextView) this.findViewById(R.id.dwdz_tv);
		// 单位电话
		dwdh_tv = (TextView) this.findViewById(R.id.dwdh_tv);
		// 单位性质
		dwxz_tv = (TextView) this.findViewById(R.id.dwxz_tv);
		// 月均收入
		yjsr_tv = (TextView) this.findViewById(R.id.yjsr_tv);
		// 家庭已有贷款月还款额
		jtyydkyhke_tv = (TextView) this.findViewById(R.id.jtyydkyhke_tv);
		// 家庭月收入还贷比
		jtysrhdb_tv = (TextView) this.findViewById(R.id.jtysrhkb_tv);

		// ------------------------------申请人配偶情况---------------------------------------
		// 配偶姓名
		poname_tv = (TextView) this.findViewById(R.id.poname_tv);
		// 配偶出生年月
		pobrithday_tv = (TextView) this.findViewById(R.id.pobirthday_tv);
		// 配偶证件类型
		pozjlx_tv = (TextView) this.findViewById(R.id.pozjlx_tv);
		// 配偶证件号码
		pozjhm_tv = (TextView) this.findViewById(R.id.pozjhm_tv);
		// 配偶移动电话
		pophone_tv = (TextView) this.findViewById(R.id.pophone_tv);
		// 配偶月均收入
		poyjsr_tv = (TextView) this.findViewById(R.id.poyjsr_tv);
		// 配偶单位性质
		podwxz_tv = (TextView) this.findViewById(R.id.podwxz_tv);
		// 配偶单位名称
		podwmc_tv = (TextView) this.findViewById(R.id.podwmc_tv);
		// 配偶单位地址
		podwdz_tv = (TextView) this.findViewById(R.id.podwdz_tv);
		// 配偶单位职务
		pobrzw_tv = (TextView) this.findViewById(R.id.pobrzw_tv);
		// 配偶单位电话
		podwdh_tv = (TextView) this.findViewById(R.id.podwdh_tv);

		// -------------------------------------调查评价------------------------------------
		// 调查员
		dcy_tv = (TextView) this.findViewById(R.id.dcy_tv);
		// -----------------------------------调查资料---------------------------------------
		// 身份证正面
		sfzzm_iv = (ImageView) this.findViewById(R.id.sfzzm_iv);
		// 身份证反面
		sfzfm_iv = (ImageView) this.findViewById(R.id.sfzfm_iv);
		// 手持身份证
		scsfz_iv = (ImageView) this.findViewById(R.id.scsfz_iv);
		// 与调查员合影
		ydcyhy_iv = (ImageView) this.findViewById(R.id.ydcyhy_iv);
		// 资质证明
		zzzm_iv = (ImageView) this.findViewById(R.id.zzzm_iv);
		// 申请人小区
		xq_iv = (ImageView) this.findViewById(R.id.xq_iv);
		// 申请人所住楼号
		lh_iv = (ImageView) this.findViewById(R.id.lh_iv);
		// 申请人所住单元
		dy_iv = (ImageView) this.findViewById(R.id.dy_iv);
		// 申请人门牌号
		mph_iv = (ImageView) this.findViewById(R.id.mph_iv);
		// 定位
		dw_iv = (ImageView) this.findViewById(R.id.dw_iv);

		sp = getSharedPreferences("login", Context.MODE_PRIVATE);
		MYCOOKIES = sp.getString("MYCOOKIES", null);

	}

	/**
	 * 请求网络
	 */
	private void requestInternet() {

		HttpUtils httpUtils = new HttpUtils();
		RequestParams params = new RequestParams();
		params.setHeader("Cookie", "JSESSIONID=" + MYCOOKIES);
		params.addBodyParameter("applyid", applyid);
		httpUtils.send(HttpMethod.POST, Constants.GETDYBGURL, params,
				new RequestCallBack<String>() {

					@Override
					public void onFailure(HttpException arg0, String arg1) {

						System.out.println("-----------------网络请求失败");
					}

					@Override
					public void onSuccess(ResponseInfo<String> Info) {

						Gson gson = new Gson();
						reportEntity = gson.fromJson(Info.result,
								ResearchReportEntity.class);
						System.out.println("---------------reportEntity-----"
								+ reportEntity);

						setText();
					}

				});
	}

	/**
	 * 设置数据
	 */
	private void setText() {
		// 申请人姓名
		name_tv.setText(reportEntity.getApplybc().get(0).getPersonname());
		// 购车原因
		// reason_tv.setText(reportEntity.);
		// 还款来源
		// hkly_tv.setText();
		// 住房情况 1-自有,2-贷款,3-租房,4-其它
		String zfqk = reportEntity.getApplybc_file().get(0).getZzzk();
		if (zfqk.equals("1")) {
			zfqk = "自有";
		} else if (zfqk.equals("2")) {
			zfqk = "贷款";
		} else if (zfqk.equals("3")) {
			zfqk = "租房";
		} else if (zfqk.equals("4")) {
			zfqk = "其它";
		}
		zfqk_tv.setText(zfqk);
		// 婚姻情况 1-已婚,2-未婚,3-离异,4-丧偶
		String hyzk = reportEntity.getApplybc_file().get(0).getMarry();
		if (hyzk.equals("1")) {
			hyzk = "已婚";
		} else if (hyzk.equals("2")) {
			hyzk = "未婚";
		} else if (hyzk.equals("3")) {
			hyzk = "离异";
		} else if (hyzk.equals("4")) {
			hyzk = "丧偶";
		}
		hyqk_tv.setText(hyzk);
		// ------------------------------------申请人基本情况-------------------------------
		// 姓名
		username_tv.setText(reportEntity.getApplybc_file().get(0).getName());
		// 性别
		String sex = reportEntity.getApplybc().get(0).getPersonsex();
		if (sex.equals("1")) {
			sex = "男";
		} else if (sex.equals("2")) {
			sex = "女";
		}
		sex_tv.setText(sex);

		// 出生年月
		brithday_tv
				.setText(reportEntity.getApplybc_file().get(0).getBirthday());
		// 证件类型
		// 证件类型
		String zjtype = "";
		if (reportEntity.getApplybc_file().get(0).getCerttype().equals("1")) {
			zjtype = "身份证";
		} else if (reportEntity.getApplybc_file().get(0).getCerttype()
				.equals("2")) {
			zjtype = "护照";
		} else if (reportEntity.getApplybc_file().get(0).getCerttype()
				.equals("3")) {
			zjtype = "军人证";
		} else if (reportEntity.getApplybc_file().get(0).getCerttype()
				.equals("4")) {
			zjtype = "残疾证";
		}
		zjlx_tv.setText(zjtype);
		// 证件号码
		zjhm_tv.setText(reportEntity.getApplybc_file().get(0).getCertnum());
		// 住宅地址
		zzdz_tv.setText(reportEntity.getApplybc_file().get(0).getBirthday());
		// 住宅状况
		zzzk_tv.setText(reportEntity.getApplybc().get(0).getPersonhouseaddr());
		// 户口所在地
		hkszd_tv.setText(reportEntity.getApplybc().get(0).getPersonhome());
		// 手机号码
		phone_tv.setText(reportEntity.getApplybc().get(0).getPersonmobile());
		// 工作单位
		gzdw_tv.setText(reportEntity.getApplybc_file().get(0).getWorkname());
		// 职务
		zw_tv.setText(reportEntity.getApplybc_file().get(0).getJob());
		// 单位地址
		dwdz_tv.setText(reportEntity.getApplybc().get(0).getPersoncompaddr());
		// 单位电话
		dwdh_tv.setText(reportEntity.getApplybc_file().get(0).getWorkphone());
		// 单位性质
		String dwxz = reportEntity.getApplybc_file().get(0).getWorktype();
		if (dwxz.equals("1")) {
			dwxz = "国家机关";
		} else if (dwxz.equals("2")) {
			dwxz = "国有企业";
		} else if (dwxz.equals("3")) {
			dwxz = "股份制企业";
		} else if (dwxz.equals("4")) {
			dwxz = "事业单位";
		} else if (dwxz.equals("5")) {
			dwxz = "集体企业";
		} else if (dwxz.equals("6")) {
			dwxz = "私营企业";
		} else if (dwxz.equals("7")) {
			dwxz = "外资企业";
		} else if (dwxz.equals("8")) {
			dwxz = "其它";
		}

		dwxz_tv.setText(dwxz);
		// 月均收入
		yjsr_tv.setText(reportEntity.getApplybc_file().get(0).getAvgmoney());
		// 家庭已有贷款月还款额
		jtyydkyhke_tv
				.setText(reportEntity.getApplybc().get(0).getFamilyrepay());
		// 家庭月收入还贷比
		// jtysrhdb_tv.setText();
		// ------------------------------申请人配偶情况---------------------------------------
		// 配偶姓名
		poname_tv.setText(reportEntity.getApplybc().get(0).getSpousename());
		// 配偶出生年月
		pobrithday_tv
				.setText(reportEntity.getApplybc().get(0).getSpousebirth());
		// 配偶证件类型
		pozjlx_tv.setText(reportEntity.getApplybc().get(0).getSpousecerttype());
		// 配偶证件号码
		// pozjhm_tv.setText(reportEntity.getApplybc().get(0).getSpousec);
		// 配偶移动电话
		pophone_tv.setText(reportEntity.getApplybc().get(0).getSpousemobile());
		// 配偶月均收入
		poyjsr_tv.setText(reportEntity.getApplybc().get(0).getSpousesalary());
		// 配偶单位性质
		// podwxz_tv.setText(reportEntity.getApplybc_file().get(0).get);
		// // 配偶单位名称
		// private TextView podwmc_tv;
		// // 配偶单位地址
		// private TextView podwdz_tv;
		// // 配偶单位职务
		// private TextView pobrzw_tv;
		// // 配偶单位电话
		// private TextView podwdh_tv;

		// -------------------------------------调查评价------------------------------------
		// 调查员
		dcy_tv.setText(sp.getString("name", null));
		sfzzmurl = reportEntity.getApplybc_file().get(0).getCert1_url();
		if (!sfzzmurl.equals("")) {

			showImages(sfzzmurl, sfzzm_iv);
		}
		sfzfmurl = reportEntity.getApplybc_file().get(0).getCert2_url();
		if (!sfzfmurl.equals("")) {

			showImages(sfzfmurl, sfzfm_iv);
		}

		scsfzurl = reportEntity.getApplybc_file().get(0).getCert3_url();
		if (!scsfzurl.equals("")) {

			showImages(scsfzurl, scsfz_iv);

		}

		ydcyhyurl = reportEntity.getApplybc_file().get(0).getTogather_url();
		if (!ydcyhyurl.equals("")) {

			showImages(ydcyhyurl, ydcyhy_iv);
		}

		zzzmurl = reportEntity.getApplybc_file().get(0).getZzzm_url();
		if (!zzzmurl.equals("")) {

			showImages(zzzmurl, zzzm_iv);

			xqurl = reportEntity.getApplybc_file().get(0).getXq_url();
			if (!xqurl.equals("")) {

				showImages(xqurl, xq_iv);
			}

			lhurl = reportEntity.getApplybc_file().get(0).getLh_url();
			if (!lhurl.equals("")) {

				showImages(lhurl, lh_iv);
			}

			dyurl = reportEntity.getApplybc_file().get(0).getDy_url();
			if (!dyurl.equals("")) {

				showImages(dyurl, dy_iv);
			}

			mphurl = reportEntity.getApplybc_file().get(0).getMph_url();
			if (!mphurl.equals("")) {

				showImages(mphurl, mph_iv);
			}

			dwurl = reportEntity.getApplybc_file().get(0).getDw_url();
			if (!dwurl.equals("")) {

				showImages(dwurl, dw_iv);
			}

		}

	}

	@Override
	public void allocationFragment() {

		super.createFragment(new SlideMenu2Fragment());
	}

	@Override
	protected void onDestroy() {
		EventBus.getDefault().unregister(this);
		super.onDestroy();
		 AppManager.getAppManager().finishActivity(this); 
	}

	public void onEventMainThread(MyEvent event) {
		event.getVisitalreadyEntity();
		applyid = event.getVisitalreadyEntity().getApplybc_id();

		clearAll();
		requestInternet();

	}

	private void showImages(String url, ImageView imageView) {
		String result = url.replace("[", "").replace("]", "").replace("\"", "")
				.replace("\\", "");
		System.out.println("---------------result---------" + result);
		BitmapUtils bitmapUtils = new BitmapUtils(this);
		if (result.contains(",")) {

			splits = result.split(",");
			for (int i = 0; i < splits.length; i++) {
			}
			bitmapUtils.display(imageView, Constants.GETIMGURL + splits[0]);
		} else {

			bitmapUtils.display(imageView, Constants.GETIMGURL + result);
		}
	}

	@Override
	public void onClick(View view) {

		switch (view.getId()) {
		// 身份证正面
		case R.id.sfzzm_iv:
			intent = new Intent(ResearchReport1Activity.this,
					ShowImagesActivity.class);
			intent.putExtra("url", sfzzmurl);
			startActivity(intent);
			break;
		// 身份证反面
		case R.id.sfzfm_iv:
			intent = new Intent(ResearchReport1Activity.this,
					ShowImagesActivity.class);
			intent.putExtra("url", sfzfmurl);
			startActivity(intent);
			break;
		// 手持身份证
		case R.id.scsfz_iv:
			intent = new Intent(ResearchReport1Activity.this,
					ShowImagesActivity.class);
			intent.putExtra("url", scsfzurl);
			startActivity(intent);
			break;
		// 与调查员合影
		case R.id.ydcyhy_iv:
			intent = new Intent(ResearchReport1Activity.this,
					ShowImagesActivity.class);
			intent.putExtra("url", ydcyhyurl);
			startActivity(intent);
			break;
		// 资质证明
		case R.id.zzzm_iv:
			intent = new Intent(ResearchReport1Activity.this,
					ShowImagesActivity.class);
			intent.putExtra("url", zzzmurl);
			startActivity(intent);
			break;
		// 申请人小区
		case R.id.xq_iv:
			intent = new Intent(ResearchReport1Activity.this,
					ShowImagesActivity.class);
			intent.putExtra("url", xqurl);
			startActivity(intent);
			break;
		// 所住楼号
		case R.id.lh_iv:
			intent = new Intent(ResearchReport1Activity.this,
					ShowImagesActivity.class);
			intent.putExtra("url", lhurl);
			startActivity(intent);
			break;
		// 单元
		case R.id.dy_iv:
			intent = new Intent(ResearchReport1Activity.this,
					ShowImagesActivity.class);
			intent.putExtra("url", dyurl);
			startActivity(intent);
			break;
		// 门牌号
		case R.id.mph_iv:
			intent = new Intent(ResearchReport1Activity.this,
					ShowImagesActivity.class);
			intent.putExtra("url", mphurl);
			startActivity(intent);
			break;
		// 定位
		case R.id.dw_iv:
			intent = new Intent(ResearchReport1Activity.this,
					ShowImagesActivity.class);
			intent.putExtra("url", dwurl);
			startActivity(intent);
			break;

		default:
			break;
		}
	}

	public void clearAll() {

		name_tv.setText("");
		reason_tv.setText("");
		hkly_tv.setText("");
		zfqk_tv.setText("");
		hyqk_tv.setText("");

		username_tv.setText("");
		sex_tv.setText("");
		brithday_tv.setText("");
		zzdz_tv.setText("");
		zzzk_tv.setText("");
		hkszd_tv.setText("");
		phone_tv.setText("");
		gzdw_tv.setText("");
		zw_tv.setText("");
		dwdz_tv.setText("");
		dwdh_tv.setText("");
		dwxz_tv.setText("");
		yjsr_tv.setText("");
		jtyydkyhke_tv.setText("");
		jtysrhdb_tv.setText("");

		poname_tv.setText("");
		pobrithday_tv.setText("");
		pozjlx_tv.setText("");
		pozjhm_tv.setText("");
		pophone_tv.setText("");
		poyjsr_tv.setText("");
		podwxz_tv.setText("");
		podwmc_tv.setText("");
		podwdz_tv.setText("");
		pobrzw_tv.setText("");
		podwdh_tv.setText("");

		dcy_tv.setText("");

		sfzzm_iv.setImageResource(R.drawable.add_picture_normal);
		sfzfm_iv.setImageResource(R.drawable.add_picture_normal);
		scsfz_iv.setImageResource(R.drawable.add_picture_normal);
		ydcyhy_iv.setImageResource(R.drawable.add_picture_normal);
		zzzm_iv.setImageResource(R.drawable.add_picture_normal);
		xq_iv.setImageResource(R.drawable.add_picture_normal);
		lh_iv.setImageResource(R.drawable.add_picture_normal);
		dy_iv.setImageResource(R.drawable.add_picture_normal);
		mph_iv.setImageResource(R.drawable.add_picture_normal);
		dw_iv.setImageResource(R.drawable.add_picture_normal);

	}

}
