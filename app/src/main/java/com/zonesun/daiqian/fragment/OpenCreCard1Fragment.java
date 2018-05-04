package com.zonesun.daiqian.fragment;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.greenrobot.event.EventBus;

import com.zonesun.daiqian.activity.R;
import com.zonesun.daiqian.entity.EventT;
import com.zonesun.daiqian.util.Constants;
import com.zonesun.daiqian.util.JsonUtils;
import com.zonesun.daiqian.util.MyEvent;
import com.zonesun.daiqian.util.NoCode;
import com.zonesun.daiqian.util.NoHttpRequest;
import com.zonesun.daiqian.util.ToastUtil;
import com.zonesun.daiqian.view.AbstractSpinerAdapter;
import com.zonesun.daiqian.view.CustemObject;
import com.zonesun.daiqian.view.CustemSpinerAdapter;
import com.zonesun.daiqian.view.SpinerPopWindow;

import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OpenCreCard1Fragment extends Fragment implements AbstractSpinerAdapter.IOnItemSelectListener {

	@Bind(R.id.et_jydqh)
	public EditText  et_jydqh;//交易地区号
	@Bind(R.id.et_jywdh)
	public EditText  et_jywdh;//交易网点号
	@Bind(R.id.et_khdqh)
	public EditText  et_khdqh;//开户地区号
	@Bind(R.id.et_lefhduh)
	public EditText  et_lefhduh;//录入/复核地区号
	@Bind(R.id.et_lrfhwdh)
	public EditText  et_lrfhwdh;//录入/复核网点号
	@Bind(R.id.et_smzjdqh)
	public EditText  et_smzjdqh;//扫描/质检地区号
	@Bind(R.id.et_smzjwdh)
	public EditText  et_smzjwdh;//扫描/质检网点号
	@Bind(R.id.et_sldqh)
	public EditText  et_sldqh;//受理地区号
	@Bind(R.id.et_slwdh)
	public EditText  et_slwdh;//受理网点号
	@Bind(R.id.et_lkdqh)
	public EditText  et_lkdqh;//领卡地区号
    @Bind(R.id.et_lkwdh)
	public EditText et_lkwdh;//领卡地区号
	@Bind(R.id.et_zjhm)
	public EditText  et_zjhm;//证件号码
	@Bind(R.id.et_zjyxq)
	public EditText  et_zjyxq;//证件有效期
	@Bind(R.id.et_xm)
	public EditText et_xm;//姓名
	@Bind(R.id.et_xb)
	public TextView  et_xb;//性别
	@Bind(R.id.et_csrq)
	public TextView  et_csrq;//出生日期
	@Bind(R.id.et_zzdzs)
	public EditText  et_zzdzs;//住宅地址市
	@Bind(R.id.et_zzdz)
	public EditText  et_zzdz;//住宅地址
	@Bind(R.id.et_zzdhhm)
	public EditText  et_zzdhhm;//住宅电话号码
	@Bind(R.id.et_sjhm)
	public EditText  et_sjhm;//手机号码
	@Bind(R.id.et_dwdhhm)
	public EditText  et_dwdhhm;//单位电话号码
	@Bind(R.id.et_zw)
	public TextView  et_zw;//职务
	@Bind(R.id.et_dwdzs)
	public EditText  et_dwdzs;//单位地址市
	@Bind(R.id.et_gzdwdz)
	public EditText  et_gzdwdz;//工作单位地址
	@Bind(R.id.et_dwyb)
	public EditText  et_dwyb;//单位邮编
	@Bind(R.id.et_jrxdwgzsj)
	public TextView  et_jrxdwgzsj;//进入现单位工作时间
	@Bind(R.id.et_lxryxm)
	public EditText  et_lxryxm;//联系人一姓名
	@Bind(R.id.et_xmpyhzwm)//姓名拼音或是中英文名
	public EditText et_xmpyhzwm;
	@Bind(R.id.et_lxryyzkrgx)
	public TextView  et_lxryyzkrgx;//联系人一与主卡申请人关系
	@Bind(R.id.et_lxrysj)
	public EditText  et_lxrysj;//联系人一手机
	@Bind(R.id.et_lxrylxdhh)
	public EditText  et_lxrylxdhh;//联系人一联系电话号
	@Bind(R.id.et_lxrexm)
	public EditText  et_lxrexm;//联系人二姓名
	@Bind(R.id.et_lxreyzksqrgx)
	public TextView  et_lxreyzksqrgx;//联系人二与主卡申请人关系
	@Bind(R.id.et_lxresj)
	public EditText  et_lxresj;//联系人二手机
	@Bind(R.id.et_lxrelxdhh)
	public EditText  et_lxrelxdhh;//联系人二联系电话号
	@Bind(R.id.et_yxdabm)
	public EditText  et_yxdabm;//营销档案编码
	@Bind(R.id.et_sqpp)
	public TextView  et_sqpp;//申请品牌
	@Bind(R.id.et_sqkl)
	public TextView  et_sqkl;//申请卡类
	@Bind(R.id.et_sqkbin)
	public TextView  et_sqkbin;//申请卡BIN
	@Bind(R.id.et_kpjz)
	public TextView  et_kpjz;//卡片介质
	@Bind(R.id.et_bz)
	public TextView  et_bz;//币种
	@Bind(R.id.et_dxtxsjh)
	public EditText  et_dxtxsjh;//短信提醒手机号码
	@Bind(R.id.et_yxdm)
	public EditText  et_yxdm;//营销代码
	@Bind(R.id.et_sxlx)
	public TextView et_sxlx;//授信类型
	private List<CustemObject> spinnerList = new ArrayList<CustemObject>();
	private AbstractSpinerAdapter<CustemObject> spinnerAdapter;
	private SpinerPopWindow spinnerPopWindow;
	public  TextView selectedSpinnerText;
	//--------------------------------------------------------------
    private String   jydqh;//交易地区号
	private String  jywdh; //交易网点号
	private String   khdqh; //开户地区号
	private String   lefhduh;//录入/复核地区号
	private String    lrfhwdh;//录入/复核网点号
	private String    smzjdqh;//扫描/质检地区号
	private String   smzjwdh;//扫描/质检网点号
	private String    sldqh;//受理地区号
	private String    slwdh;//受理网点号
	private String    lkdqh;//领卡地区号
	private String   lkwdh;//领卡网点号
	private String    zjhm;//证件号码
	private String    zjyxq;//证件有效期
	private String    xm;//姓名
	private String    xb;//性别
	private String    csrq;//出生日期
	private String    zzdzs;//住宅地址市
	private String    zzdz;//住宅地址
	private String     zzdhhm;//住宅电话号码
	private String    sjhm;//手机号码
	private String    dwdhhm;//单位电话号码
	private String    zw;//职务
	private String    dwdzs;//单位地址市
	private String     gzdwdz;//工作单位地址
	private String     dwyb;//单位邮编sd
	private String     jrxdwgzsj;//进入现单位工作时间
	private String    lxryxm;//联系人一姓名
	private String     lxryyzkrgx;//联系人一与主卡申请人关系
	private String     lxrysj;//联系人一手机
	private String     lxrylxdhh;//联系人一联系电话号
	private String     lxrexm;//联系人二姓名
	private String     lxreyzksqrgx;//联系人二与主卡申请人关系
	private String     lxresj;//联系人二手机
	private String     lxrelxdhh;//联系人二联系电话号
	private String     yxdabm;//营销档案编码
	private String     sqpp;//申请品牌
	private String     sqkl;//申请卡类
	private String     sqkbin;//申请卡BIN
	private String     kpjz;//卡片介质
	private String     bz;//币种
	private String     dxtxsjh;//短信提醒手机号码
	private String     yxdm;//营销代码
	private String     sxlx;//授信类型

    private NoHttpRequest norequest;

	SharedPreferences sp;
	Map<String, String> map;




	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v=View.inflate(getActivity(), R.layout.fragment_creditcard1,null);
		// TODO Auto-generated method stub
		ButterKnife.bind(this, v);
		initView();
		return v;

	
	}
	int mYear, mMonth, mDay = 0;
	private DatePickerDialog DatapickeDialog;
	/***
	 * 初始化方法
	 */
	private void initView() {
		EventBus.getDefault().register(this);
		sp = getActivity().getSharedPreferences("login", Context.MODE_PRIVATE);
		norequest=new NoHttpRequest(getActivity(),sp);
		spinnerAdapter = new CustemSpinerAdapter(getActivity());
		spinnerPopWindow = new SpinerPopWindow(getActivity());
		spinnerPopWindow.setItemListener(this);

//
		et_zjhm.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {

			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {

			}

			@Override
			public void afterTextChanged(Editable s) {
				String gtczrzjhm = et_zjhm.getText().toString().trim();
				if (gtczrzjhm.length() == 18) {
			System.out.println(gtczrzjhm);

                    et_csrq.setText(gtczrzjhm.subSequence(6, 10)
					+ "-" + gtczrzjhm.subSequence(10, 12) + "-"
					+ gtczrzjhm.subSequence(12, 14));
		}
			}
		});
		et_jrxdwgzsj.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				DatapickeDialog = new DatePickerDialog(getActivity(),
						mdateListener, mYear, mMonth, mDay);
				DatapickeDialog.show();
			}
		});

		et_sqpp.setText("4-银联");
		et_sqkl.setText("1-普卡");
		et_sqkbin.setText("622232");
		et_kpjz.setText("3-磁条+非接触+IC");
		et_bz.setText("001-人民币");

	}
	// 日期选择器的监听
	private DatePickerDialog.OnDateSetListener mdateListener = new DatePickerDialog.OnDateSetListener() {

		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear,
							  int dayOfMonth) {
			mYear = year;
			mMonth = monthOfYear;
			mDay = dayOfMonth;

			et_jrxdwgzsj.setText(new StringBuffer().append(mYear)
					.append(mMonth + 1 < 10 ? "0" + (mMonth + 1) : mMonth + 1).append(""));

			DatapickeDialog.cancel();
		}
	};
	// 使用注解加监听的方法
	@OnClick({R.id.rl_xb,R.id.rl_zw,R.id.rl_lxryyzkrgx,R.id.rl_lxreyzksqrgx,R.id.rl_sqpp,R.id.rl_sqkl,R.id.rl_sqkbin,R.id.rl_kpjz,R.id.rl_bz,R.id.rl_sxlx
	,R.id.bt_tjiao
	})
	public void onClick(View v) {

		switch(v.getId()){
			case R.id.rl_xb:
				selectedSpinnerText = et_xb;
				String[] xblist = getResources().getStringArray(
						R.array.xb2_list);
				showSpinWindow(xblist);

				break;
			case R.id.rl_lxryyzkrgx:// 开卡联系人二与开卡人关系R.id.rl_primnat
				selectedSpinnerText = et_lxryyzkrgx;
				String[] gx2list = getResources().getStringArray(
						R.array.lxr1ykkrgxs_list);
				showSpinWindow(gx2list);
				break;
            case R.id.rl_zw:// 职务
                selectedSpinnerText = et_zw;
                String[] gjlist = getResources().getStringArray(R.array.zy_list);
                showSpinWindow(gjlist);
                break;
            case R.id.rl_lxreyzksqrgx:// 开卡联系人二与开卡人关系
                selectedSpinnerText = et_lxreyzksqrgx;
				String[] lxr2list = getResources().getStringArray(
						R.array.lxr1ykkrgxss_list);
				showSpinWindow(lxr2list);
                break;
            case R.id.rl_sqpp:// 申请品牌
//                selectedSpinnerText = et_sqpp;
//                String[] sqkpz = getResources().getStringArray(
//                        R.array.sqpp_list);
//                showSpinWindow(sqkpz);
                break;
            case R.id.rl_sqkl:// 申请卡类
//                selectedSpinnerText = et_sqkl;
//                String[] sqklb = getResources().getStringArray(
//                        R.array.sqklb_list);
//                showSpinWindow(sqklb);
                break;
            case R.id.rl_kpjz:// 卡片介质
//                selectedSpinnerText = et_kpjz;
//                String[] kpjz = getResources().getStringArray(
//                        R.array.kpjz_list);
//                showSpinWindow(kpjz);
                break;
			case R.id.rl_sxlx:// 币种
//				selectedSpinnerText = et_sxlx;
//			     String[] kbin=getResources().getStringArray(R.array.sxlx_list);
//
//				showSpinWindow(kbin);
				break;
			case R.id.rl_bz:// 授信类型
				selectedSpinnerText = et_bz;
				String[] sxlx=getResources().getStringArray(R.array.bz_list);
				showSpinWindow(sxlx);

				break;
			case R.id.rl_sqkbin:// kBin
				selectedSpinnerText = et_sqkbin;
				String[] kabin=getResources().getStringArray(R.array.kabin_list);
				showSpinWindow(kabin);

				break;
            case R.id.bt_tjiao:
				 map = new HashMap <String, String>();

                 getData();
				System.out.println(map.toString());
//				norequest.Request(map, Constants.POSTOPENCARD,null, NoCode.NOHTTP_WHAT_POSTOPENCARD);
				RequestParams params = new RequestParams(Constants.POSTOPENCARD);
                   params.addHeader("Cookie",
						   "JSESSIONID=" + sp.getString("MYCOOKIES", null));

				for (String key : map.keySet()) {
					params.addBodyParameter(key.trim(), map.get(key).trim());

					// System.out.println(map.get(key));
				}
				System.out.println(params.toString());
				x.http().post(params, new XCallBack(100));
				System.out.println(params.toString());
            	break;
			default:
				break;

		}


	}

	/**
	 * eventbus 的回调
	 * @param event
	 */
	public void onEventMainThread(MyEvent event) {
//		NOHTTP_WHAT_POSTOPENCARD


	}
	private void setSpinnerText(int pos) {
		if (pos >= 0 && pos <= spinnerList.size()) {

			if(selectedSpinnerText.getId()==R.id.et_sqkbin){


				CustemObject value = spinnerList.get(pos);
                   if(value.toString().equals("622232")){
					   selectedSpinnerText.setText(value.toString());
					   et_sqkl.setText("1-普卡");

					   et_sqpp.setText("4-银联");
					   et_kpjz.setText("3-磁条+非接触+IC");
					   et_bz.setText("001-人民币");

				   }else if(value.toString().equals("622239")){
					   selectedSpinnerText.setText(value.toString());
					   et_sqkl.setText("1-普卡");
					  et_sqpp.setText("4-银联");
					   et_kpjz.setText("3-磁条+非接触+IC");
					   et_bz.setText("001-人民币");
				   }else if(value.toString().equals("427029")){
					   selectedSpinnerText.setText(value.toString());
					   et_sqkl.setText("1-普卡");
					   et_sqpp.setText("1-VISA");
					   et_kpjz.setText("0-磁条");
					   et_bz.setText("013-人民币/港币");
				   }else if(value.toString().equals("427039")){
					   selectedSpinnerText.setText(value.toString());
					   et_sqkl.setText("0-金卡");
					   et_sqpp.setText("1-VISA");
					   et_kpjz.setText("0-磁条");
					   et_bz.setText("013-人民币/港币");
				   }
			}else {
				CustemObject value = spinnerList.get(pos);
				selectedSpinnerText.setText(value.toString());
			}

		}
	}

	/**
	 * @param list 显示列表
	 */
	public void showSpinWindow(String[] list) {
		spinnerList.clear();

		for (int i = 0; i < list.length; i++) {
			CustemObject object = new CustemObject();
			object.data = list[i];
			spinnerList.add(object);
		}
		spinnerAdapter.refreshData(spinnerList, 0);
		spinnerPopWindow.setAdatper(spinnerAdapter);
		spinnerPopWindow.setWidth(selectedSpinnerText.getWidth());
		spinnerPopWindow.showAsDropDown(selectedSpinnerText);

	}
    public void  getData(){

		jydqh=et_jydqh.getText().toString();
		map.put("tzoneno",jydqh);//交易地区号
		jywdh=et_jywdh.getText().toString();
		map.put("branchno",jywdh);//交易网点号
		khdqh=et_khdqh.getText().toString();
		map.put("openzone",khdqh);//开户地区号
		lefhduh=et_lefhduh.getText().toString();
		map.put("regtzono",lefhduh);//录入、复合地区号
		lrfhwdh=et_lrfhwdh.getText().toString();
		map.put("regtbrno",lrfhwdh);//录入复合网点号
		smzjdqh=et_smzjdqh.getText().toString();
		map.put("scanzono",smzjdqh);//扫面质检地区号
		smzjwdh=et_smzjwdh.getText().toString();
		map.put("scanbrno",smzjwdh);//扫面质检网点号
		sldqh=et_sldqh.getText().toString();
		map.put("agnzono",sldqh);//受理地区号
		slwdh=et_slwdh.getText().toString();
		map.put("agnbrno",slwdh);//受理网点号

		lkdqh=et_lkdqh.getText().toString();
		map.put("drawzono",lkdqh);//领卡地区号
		lkwdh=et_lkwdh.getText().toString();//领卡网点号
		map.put("drawbrno",lkwdh);
		zjhm=et_zjhm.getText().toString();//证件号码
		map.put("custcode",zjhm);
		zjyxq=et_zjyxq.getText().toString();//证件有效期
		map.put("statdate",zjyxq);
		xm=et_xm.getText().toString();//姓名
		map.put("chnsname",xm);

		map.put("engname",et_xmpyhzwm.getText().toString().trim());//中文名拼音或英文名
				xb=et_xb.getText().toString();//性别
//		if("请选择".equals(xb)){
//
//			xb="";
//		}else if("1-男".equals(xb)){
//			xb="1";
//		}else if("2-女".equals(xb)){
//			xb="2";
//		}

		map.put("sex",xb);
		csrq=et_csrq.getText().toString();//出生日期
		map.put("birthdate",csrq);
		zzdzs=et_zzdzs.getText().toString();//住宅地址市
		map.put("hcity",zzdzs);
		zzdz=et_zzdz.getText().toString();//住宅地址
		map.put("haddress",zzdz);
		zzdhhm=et_zzdhhm.getText().toString();//住宅电话号码
		 map.put("hphoneno",zzdhhm);
		sjhm=et_sjhm.getText().toString();//手机号码
		map.put("mvblno",sjhm);
		dwdhhm=et_dwdhhm.getText().toString();//单位电话号码
		map.put("cophoneno",dwdhhm);
		zw=et_zw.getText().toString();//职务
		map.put("duty",JsonUtils.SqrZw(zw));
		dwdzs=et_dwdzs.getText().toString();//单位地址市
		map.put("ccity",dwdzs);
		gzdwdz=et_gzdwdz.getText().toString();//工作单位地址
		map.put("caddress",gzdwdz);
		dwyb=et_dwyb.getText().toString();//单位邮编
         map.put("corpzip",dwyb);
		jrxdwgzsj=et_jrxdwgzsj.getText().toString();//进入现单位和工作时间
		map.put("joindate",jrxdwgzsj);
		lxryxm=et_lxryxm.getText().toString();//联系人一姓名
		map.put("reltname1",lxryxm);
		lxryyzkrgx=et_lxryyzkrgx.getText().toString() ;//联系人一与主卡申请人关系
//		map.put("reltship1", JsonUtils.toResultGc(lxryyzkrgx));
		map.put("reltship1", lxryyzkrgx);
		lxrysj=et_lxrysj.getText().toString();//联系人一手机
		map.put("reltmobl1",lxrysj);
		lxrylxdhh=et_lxrylxdhh.getText().toString();//联系人一联系电话号
		map.put("relaphone1",lxrylxdhh);
		lxrexm=et_lxrexm.getText().toString();//联系人二姓名
		map.put("reltname2",lxrexm);
		lxreyzksqrgx=et_lxreyzksqrgx.getText().toString();//联系人二与主卡申请人关系
//		map.put("reltship2",JsonUtils.toResultGc(lxreyzksqrgx ));
		map.put("reltship2",lxreyzksqrgx );
		lxresj=et_lxresj.getText().toString();//联系人二手机
		map.put("reltmobl2",lxresj);
		lxrelxdhh=et_lxrelxdhh.getText().toString();//联系人二联系电话号
		map.put("rtcophon2",lxrelxdhh);
		yxdabm=et_yxdabm.getText().toString();//营销档案编码
		map.put("saleno",yxdabm);
		sqpp=et_sqpp.getText().toString();//申请品牌
//		map.put("cardlogo",JsonUtils.Sqkpz(sqpp));
		map.put("cardlogo",sqpp);
		sqkl=et_sqkl.getText().toString();//申请卡类
//		map.put("cardtype", JsonUtils.Sqkclass(sqkl));
		map.put("cardtype", sqkl);
		sqkbin=et_sqkbin.getText().toString();//申请卡BIN
		map.put("cardbin",sqkbin);
		kpjz=et_kpjz.getText().toString();//卡片介质
//		map.put("cardmedm",JsonUtils.Sqkpjz(kpjz) );
		map.put("cardmedm",kpjz );
		bz=et_bz.getText().toString();//币种
//		if("001-人民币".equals(bz)){
//			bz="001";
//		}else if("013-人民币/港币".equals(bz)){
//			bz="013";
//		}else{
//			bz="";
//		}

		map.put("fcurrtyp",bz);
		dxtxsjh=et_dxtxsjh.getText().toString();//短信提醒手机号码
		map.put("mamobile",dxtxsjh);
		yxdm=et_yxdm.getText().toString();//营销代码
		map.put("dscode",yxdm);

		sxlx=et_sxlx.getText().toString();//授信类型
//
//		if("0-共享".equals(sxlx)){
//			sxlx="0";
//		}else if("5-不共享".equals(sxlx)){
//			sxlx="5";
//		}else{
//			sxlx="";
//		}
		map.put("authtype",sxlx);

	}


	@Override
	public void onItemClick(int pos) {

		setSpinnerText(pos);

	}


	class XCallBack implements Callback.CommonCallback<String>{

		int id;

		public XCallBack(int id) {
			this.id = id;
		}

		@Override
		public void onSuccess(String result) {
			if(!TextUtils.isEmpty(result)&&!("[]".equals(result))) {
				switch (id) {
					case 100:
						//initData(result);
						System.out.print(result);
						ToastUtil.showShort(getActivity(),"保存成功");
                         getActivity().finish();
						break;




					default:
						break;

				}
			}else{
				ToastUtil.showShort(getActivity(),"保存失败");
			}
		}

		@Override
		public void onError(Throwable ex, boolean isOnCallback) {
			ToastUtil.showShort(getActivity(),"请检查您的网络");
		}

		@Override
		public void onCancelled(CancelledException cex) {

		}

		@Override
		public void onFinished() {

		}
	}

}
