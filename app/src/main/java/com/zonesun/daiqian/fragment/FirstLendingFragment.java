package com.zonesun.daiqian.fragment;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.provider.Settings;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Base64;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.LocationClientOption.LocationMode;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;
import com.zonesun.daiqian.activity.MyMapActivity;
import com.zonesun.daiqian.activity.OcrActivity;
import com.zonesun.daiqian.activity.PlayerActivity;
import com.zonesun.daiqian.activity.R;
import com.zonesun.daiqian.activity.RecordVideoActivity;
import com.zonesun.daiqian.activity.ResearchReportActivity;
import com.zonesun.daiqian.activity.ShowImagesActivity;
import com.zonesun.daiqian.activity.UploadSussessActivity;
import com.zonesun.daiqian.adapter.PopAdapter;
import com.zonesun.daiqian.base.BaseFragment;
import com.zonesun.daiqian.base.MyApplication;
import com.zonesun.daiqian.entity.CardBin;
import com.zonesun.daiqian.entity.DsomeThings;
import com.zonesun.daiqian.entity.EventT;
import com.zonesun.daiqian.entity.GLobleData;
import com.zonesun.daiqian.entity.GetIdCardInfo;
import com.zonesun.daiqian.entity.IdentifyResult;
import com.zonesun.daiqian.entity.RuHuData;
import com.zonesun.daiqian.entity.RuHuSurveyEntity.VisitalrearyEntity;
import com.zonesun.daiqian.entity.RuHuSurveyEntity.VisityetEntity;
import com.zonesun.daiqian.entity.ZhengXinEntity;
import com.zonesun.daiqian.entity.mBankEntity;
import com.zonesun.daiqian.util.Constants;
import com.zonesun.daiqian.util.DoSomeThsDao;
import com.zonesun.daiqian.util.EditInputFilter;
import com.zonesun.daiqian.util.GetDateUtil;
import com.zonesun.daiqian.util.IsNetWorkAvailable;
import com.zonesun.daiqian.util.JsonUtils;
import com.zonesun.daiqian.util.JudgeUtil;
import com.zonesun.daiqian.util.MyEvent;
import com.zonesun.daiqian.util.MyFocusChangeListener;
import com.zonesun.daiqian.util.MyTestWher;
import com.zonesun.daiqian.util.MyTextWachert;
import com.zonesun.daiqian.util.NetRequestCallBack;
import com.zonesun.daiqian.util.NoCode;
import com.zonesun.daiqian.util.NoHttpRequest;
import com.zonesun.daiqian.util.RegexUtil;
import com.zonesun.daiqian.util.ScreenUtils;
import com.zonesun.daiqian.util.ShowTextSpinnerUtils;
import com.zonesun.daiqian.util.ToastUtil;
import com.zonesun.daiqian.util.firstlendingutils.FirLingFraSetMsgUtils;
import com.zonesun.daiqian.util.firstlendingutils.FirstlingPhotoCountUtil;
import com.zonesun.daiqian.util.firstlendingutils.MyFirstLendingTextWher;
import com.zonesun.daiqian.util.ruhusurveyutils.RuhuFraSetMsgUtils;
import com.zonesun.daiqian.util.ruhusurveyutils.RuhuSurveyPhotoCountUtil;
import com.zonesun.daiqian.view.AbstractSpinerAdapter;
import com.zonesun.daiqian.view.BadgeView;
import com.zonesun.daiqian.view.CustemObject;
import com.zonesun.daiqian.view.CustemSpinerAdapter;
import com.zonesun.daiqian.view.SpinerPopWindow;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;
import de.greenrobot.event.EventBus;
import io.realm.Realm;
import io.realm.RealmAsyncTask;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

/**
 * @author 基础档案
 */

@SuppressLint("SimpleDateFormat")
public class FirstLendingFragment extends BaseFragment {

    private View view;// 缓存页面
    private List<CustemObject> spinnerList = new ArrayList<CustemObject>();
    private AbstractSpinerAdapter<CustemObject> spinnerAdapter;
    private SpinerPopWindow spinnerPopWindow;
    private TextView selectedSpinnerText;
    private ShowTextSpinnerUtils showTextSpinnerUtils = new ShowTextSpinnerUtils();
    private DoSomeThsDao DoDao;
    private SharedPreferences videosp;
    Editor videoeditor;
    @Bind(R.id.tv_rlsb)
    TextView tv_rlsb;

    /**
     * 身份证正面 身份正反面 手持身份证 与调查员合影 资质证明 申请人小区 申请人所住楼号 申请人所住单元 申请人所住门牌号 定位
     */
    public ArrayList<String> sfzzmList;// 身份证正面图片路径集合    2//身份信息
    public ArrayList<String> sfzfmList;// 身份正反面 图片路径集合  2//地址详情
    public ArrayList<String> scsfzmList;// 手持身份证图片路径集合
    public ArrayList<String> ydcyhyList;// 与调查员合影 图片路径集合
    public ArrayList<String> zzzmList;// 资质证明图片路径集合
    public ArrayList<String> sqrxqList;// 申请人小区图片路径集合
    public ArrayList<String> sqrszlhList;// 申请人所住楼号图片路径集合
    public ArrayList<String> sqrszdyList;// 申请人所住单元图片路径集合
    public ArrayList<String> sqrszmphList;// 申请人所住门牌号 图片路径集合
    public ArrayList<String> dwList;// 定位图片路径集合

    /**
     * 身份证正面 身份正反面 手持身份证 与调查员合影 资质证明 申请人小区 申请人所住楼号 申请人所住单元 申请人所住门牌号 定位
     */
    public String getsfzzmList;// 身份证正面图片路径集合
    public String getsfzfmList;// 身份正反面 图片路径集合
    public String getscsfzmList;// 手持身份证图片路径集合
    public String getydcyhyList;// 与调查员合影 图片路径集合
    public String getzzzmList;// 资质证明图片路径集合
    public String getsqrxqList;// 申请人小区图片路径集合
    public String getsqrszlhList;// 申请人所住楼号图片路径集合
    public String getsqrszdyList;// 申请人所住单元图片路径集合
    public String getsqrszmphList;// 申请人所住门牌号 图片路径集合
    public String getdwList;// 定位图片路径集合

    public PopupWindow mPopup;
    public ListView mListView;

    public PopAdapter mPopAdapter;
    public ArrayList<String> mList;
    public int localListSize = 0;
    public int networkListSize = 0;
    public List<String> locapalList;
    public List<String> networkpaList;

    public ImageView viewBadge;
    public ArrayList<String> msfzlList;// 身份信息
    public ArrayList<String> mdzxxList;// 地址信息
    public ArrayList<String> mdwList;// 地图定位
    public ArrayList<String> msrzmlList;// 收入证明文件
    public ArrayList<String> mgcfpList;// 购车发票文件
    public ArrayList<String> msfkList;// 首付款证明文件
    public ArrayList<String> mcldyList;// 车辆抵押证明文件
    public ArrayList<String> mclbxList;// 车辆保险单文件
    public ArrayList<String> mgchtList;// 购车合同文件
    public ArrayList<String> mzxbgList;// 征信报告文件

    public String[] splits;
    public BadgeView badge3;
    public List<String> sfzlList;// 身份资料
    public List<String> dzxqList;// 地址详情
    public List<String> dzdwList;// 地址定位
    public List<String> srwjzmList;// 收入文件证明
    public List<String> gcfpwjzmList;// 购车发票证明
    public List<String> sfkwjzmList;// 首付款文件证明
    public List<String> cldiwjzmList;// 车辆抵押文件证明
    public List<String> clbxdwjList;// 车辆保险单文件
    public List<String> gchewjzmList;// 购车合同文件
    public List<String> zxbgwjzmList;// 征信报告文件

    public NetRequestCallBack netRequestCallBack =new NetRequestCallBack();
    public FirstlingPhotoCountUtil ruhuphotonumber = new FirstlingPhotoCountUtil(this);
    private FirLingFraSetMsgUtils ruhuFraSetMsgUtils = new FirLingFraSetMsgUtils(this);
    // 采用注解的方式找控件id省略找id的代码
    // 显示图片张数的资料
    public BadgeView badgeSfzzm;
    public BadgeView badgesfzfm;
    public BadgeView badgedw;
    public BadgeView badgeydcyhy;
    public BadgeView badgezzzm;
    public BadgeView badgesqrxq;
    public BadgeView badgesqrszl;
    public BadgeView badgesqrszdy;
    public BadgeView badgesqrszmph;
    public BadgeView badgescsfzm;

    // 认证
    @Bind(R.id.ll_zxrz)
    public  LinearLayout ll_zxrz;
    @Bind(R.id.iv_sm)
    public ImageView iv_sm;
    @Bind(R.id.iv_sr)
    public   ImageView iv_sr;
    @Bind(R.id.iv_htrz)
    public   ImageView iv_htrz;
    @Bind(R.id.iv_yhkzd)
    public  ImageView iv_yhkzd;
    @Bind(R.id.iv_hmd)
    public  ImageView iv_hmd;

    // --------------------------申请原因---------------------------
    // 购车品牌
    @Bind(R.id.gcpp_spinner_text)
    public  EditText gcppEdittext;
    @Bind(R.id.rl_buyCarModel)
    public ImageButton rl_gcpp;
    // 购车原因
    @Bind(R.id.gcyy_edittext)
    public  EditText gcyyEdittext;
    // 裸车价格
    @Bind(R.id.lcjg_edittext)
    public EditText lcjgEdittext;

    // 还款途径
    @Bind(R.id.hktj_spinner_text)
    public  TextView hktjSpinnerText;
    @Bind(R.id.rl_huankuanzhengming)
    public   RelativeLayout hktjBtn;
    // 进口车标志
    @Bind(R.id.jkcbz_spinner_text)
    public  TextView jkcbzSpinnerText;
    @Bind(R.id.rl_jkcenterport)
    public   RelativeLayout jkcbzBtn;
    // 车型
    @Bind(R.id.cx_spinner_text)
    public  EditText cxSpinnerText;
    // private RelativeLayout cxBtn;
    // 排气量
    @Bind(R.id.pql_spinner_text)
    public TextView pqlSpinnerText;
    @Bind(R.id.rl_Displacement)
    public  RelativeLayout pqlBtn;

    // --------------------申请人基本情况-----------------------------------------
    // 中文姓名
    @Bind(R.id.zwxm_edittext)
    public   EditText zwxmEdittext;
    // 性别
    @Bind(R.id.xb_spinner_text)
    public TextView xbSpinnerText;
    // private ImageButton xbBtn;
    // 出生年月
    @Bind(R.id.csny_edittext)
    public TextView csnyEdittext;
    // 证件类型
    @Bind(R.id.zjlx_spinner_text)
    public   TextView zjlxSpinnerText;
    @Bind(R.id.rl_CredentialsModel)
    public RelativeLayout zjlxBtn;
    // 证件号码
    @Bind(R.id.zjhm_edittext)
    public EditText zjhmEdittext;
    @Bind(R.id.bt_hqsfxx)
    public Button bt_getidcardinfo;

    // 婚姻状况
    @Bind(R.id.hyzk_spinner_text)
    public   TextView hyzkSpinnerText;
    @Bind(R.id.rl_MaritalStatus)
    public   RelativeLayout hyzkBtn;

    // 共同偿债人或者担保人
    @Bind(R.id.gtczrordbr_spinner_text)
    public TextView gtczrordbrSpinnerText;
    @Bind(R.id.gtczrordbr_btn)
    public  ImageButton gtczrordbrBtn;
    @Bind(R.id.ll_gtczrordbr)
    public LinearLayout ll_gtczordbr;
    // 手机号码
    @Bind(R.id.sjhm_edittext)
    public EditText sjhmEdittext;

    // 户口所在地
    @Bind(R.id.hkszd_sheng_spinner_text)
    public EditText hkszdShengSpinnerText;
    // private RelativeLayout hkszdShengBtn;
    @Bind(R.id.hkszd_shi_spinner_text)
    public EditText hkszdShiSpinnerText;
    @Bind(R.id.rl_City)
    public RelativeLayout hkszdShiBtn;
    @Bind(R.id.hkszd_xian_spinner_text)
    public EditText hkszdxianEditText;
    @Bind(R.id.hkszd_xx_edittext)
    public EditText hkszdXxdzEditText;
    @Bind(R.id.hkszd_sheng_btn)
    public ImageButton hkszd_sheng_btn;
    // 住宅状况
    @Bind(R.id.zzzk_spinner_text)
    public TextView zzzkSpinnerText;
    @Bind(R.id.rl_Residential)
    public   RelativeLayout zzzkBtn;

    // 现居住地
    @Bind(R.id.xjzd_sheng_spinner_text)
    public TextView xjzdShengSpinnerText;
    @Bind(R.id.rl_NowLive)
    public  RelativeLayout xjzdShengBtn;
    @Bind(R.id.xjzd_shi_spinner_text)
    public TextView xjzdShiSpinnerText;
    @Bind(R.id.rl_NowCity)
    public  RelativeLayout xjzdShiBtn;
    @Bind(R.id.xjzd_xian_spinner_text)
    public EditText xjzdxianEditText;
    @Bind(R.id.xjzd_xx_edittext)
    public EditText xjzdXxdzEditText;

    // 所住单位
    @Bind(R.id.szdw_edittext)
    public  EditText szdwEditText;
    // 单位性质
    @Bind(R.id.dwxz_spinner_text)
    public  TextView dwxzSpinnerText;
    @Bind(R.id.rl_unitnature)
    public  RelativeLayout dwxzBtn;

    // 单位电话
    @Bind(R.id.dwdh_edittext)
    public EditText dwdhEditText;
    // 职务类别
    @Bind(R.id.zwlb_spinner_text)
    public  TextView zwlbSpinnerText;
    @Bind(R.id.rl_Postnature)
    public RelativeLayout zwlbBtn;
    // 月均收入
    @Bind(R.id.yjsr_edittext)
    public EditText yjsrEditText;

    // 单位地址
    @Bind(R.id.dwdz_sheng_spinner_text)
    public  TextView dwdzShengSpinnerText;
    @Bind(R.id.rl_PostAddP)
    public  RelativeLayout dwdzShengBtn;
    @Bind(R.id.dwdz_shi_spinner_text)
    public TextView dwdzShiSpinnerText;
    @Bind(R.id.rl_PostAddC)
    public RelativeLayout dwdzShiBtn;
    @Bind(R.id.dwdz_xian_spinner_text)
    public EditText dwdzxianEditText;
    @Bind(R.id.dwdz_xx_edittext)
    public EditText dwdzxxdzEditText;

    // 家庭已有贷款月还款额
    @Bind(R.id.jtyydkhke_edittext)
    public EditText jtyydkyhkeEditText;
    // 综合服务费
    @Bind(R.id.sxfstatus_edittext)
    public EditText sxfstatusEditText;
    @Bind(R.id.ll_sxfstatus)
    public  LinearLayout ll_sxfstatus;
    // 银行卡号
    @Bind(R.id.yhkh_edittext)
    public  EditText yhkhEditText;
    @Bind(R.id.tv_yhkxffx)
    public TextView tv_yhkxffx;
    @Bind(R.id.ll_dcwj)
    public LinearLayout ll_dcwj;

    // -----------------------------申请人配偶情况---------------------------------
    @Bind(R.id.sqrpoqk_layout)
    public LinearLayout sqrpoqkLayout;// 申请人配偶基本情况
    // 配偶姓名
    @Bind(R.id.poxm_edittext)
    public EditText poxmEditText;
    // 配偶出身年月
    @Bind(R.id.pocsny_edittext)
    public TextView pocsnyEdittext;
    // 配偶证件类型
    @Bind(R.id.pozjlx_spinner_text)
    public  TextView pozjlxSpinnerText;
    @Bind(R.id.pozjlx_btn)
    public ImageButton pozjlxBtn;

    // 配偶证件号码
    @Bind(R.id.pozjhm_edittext)
    public  EditText pozjhmEditText;
    // 配偶手机号码
    @Bind(R.id.posjhm_edittext)
    public EditText posjhmEdittext;
    // 配偶所住单位
    @Bind(R.id.poszdw_edittext)
    public EditText poszdwEditText;
    // 配偶单位性质
    @Bind(R.id.podwxz_spinner_text)
    public  TextView podwxzSpinnerText;
    @Bind(R.id.podwxz_btn)
    public ImageButton podwxzBtn;

    // 配偶单位职务
    @Bind(R.id.podwzw_edittext)
    public EditText podwzwEditText;
    // 配偶月均收入
    @Bind(R.id.poyjsr_edittext)
    public EditText poyjsrEditText;
    // 配偶单位电话
    @Bind(R.id.podwdh_edittext)
    public  EditText podwdhEditText;
    // 配偶单位地址
    @Bind(R.id.podwdz_sheng_spinner_text)
    public  TextView podwdzShengSpinnerText;
    @Bind(R.id.podwdz_sheng_btn)
    public   ImageButton podwdzShengBtn;
    @Bind(R.id.podwdz_shi_spinner_text)
    public TextView podwdzShiSpinnerText;
    @Bind(R.id.podwdz_shi_btn)
    public  ImageButton podwdzShiBtn;
    @Bind(R.id.podwdz_xian_spinner_text)
    public EditText podwdzxianEditText;
    @Bind(R.id.podwdz_xx_edittext)
    public  EditText podwxxdzEditText;
    @Bind(R.id.tv_spzl)
    public  TextView tv_shipinziliao;
    private int first = 1;

    // -----------------------------共同偿债人------------------------------
    @Bind(R.id.gtczr_layout)
    public LinearLayout gtczrLayout;// 共同偿债人基本情况
    // 共同偿债人姓名
    @Bind(R.id.gtczrxm_edittext)
    public   EditText gtczrxmEditText;

    // 共同偿债人出身年月
    @Bind(R.id.gtczrcsny_edittext)
    public TextView gtczrcsnyEdittext;
    // 共同偿债人证件类型
    @Bind(R.id.gtczrzjlx_spinner_text)
    public  TextView gtczrzjlxSpinnerText;
    @Bind(R.id.gtczrzjlx_btn)
    public  ImageButton gtczrzjlxBtn;

    // 共同偿债人证件号码
    @Bind(R.id.gtczrzjhm_edittext)
    public  EditText gtczrzjhmEditText;
    // 共同偿债人 手机号码
    @Bind(R.id.gtczrsjhm_edittext)
    public EditText gtczrsjhmEdittext;
    // 共同偿债人所住单位
    @Bind(R.id.gtczrszdw_edittext)
    public  EditText gtczrszdwEditText;
    // 共同偿债人单位性质
    @Bind(R.id.gtczrdwxz_spinner_text)
    public  TextView gtczrdwxzSpinnerText;
    @Bind(R.id.gtczrdwxz_btn)
    public  ImageButton gtczrdwxzBtn;

    // 共同偿债人单位职务
    @Bind(R.id.gtczrdwzw_edittext)
    public  EditText gtczrdwzwEditText;
    // 共同偿债人单位电话
    @Bind(R.id.gtczrdwdh_edittext)
    public  EditText gtczrdwdhEditText;
    // 共同偿债人单位地址
    @Bind(R.id.gtczrdwdz_sheng_spinner_text)
    public  TextView gtczrdwdzShengSpinnerText;
    @Bind(R.id.gtczrdwdz_sheng_btn)
    public  ImageButton gtczrdwdzShengBtn;
    @Bind(R.id.gtczrdwdz_shi_spinner_text)
    public  TextView gtczrdwdzShiSpinnerText;
    @Bind(R.id.gtczrdwdz_shi_btn)
    public  ImageButton gtczrdwdzShiBtn;
    @Bind(R.id.gtczrdwdz_xian_spinner_text)
    public  EditText gtczrdwdzxianEditText;
    @Bind(R.id.gtczrdwdz_xx_edittext)
    public   EditText gtczrdwxxdzEditText;

    // ----------------------担保人--------------------------
    @Bind(R.id.dbr_layout)
    public LinearLayout dbrLayout;// 担保人基本情况

    // 担保人姓名
    @Bind(R.id.dbrxm_edittext)
    public EditText dbrxmEditText;
    // 担保人出身年月
    @Bind(R.id.dbrcsny_edittext)
    public TextView dbrcsnyEdittext;
    // 担保人证件类型
    @Bind(R.id.dbrzjlx_spinner_text)
    public TextView dbrzjlxSpinnerText;
    @Bind(R.id.dbrzjlx_btn)
    public ImageButton dbrzjlxBtn;

    // 担保人证件号码
    @Bind(R.id.dbrzjhm_edittext)
    public  EditText dbrzjhmEditText;
    // 担保人 手机号码
    @Bind(R.id.dbrsjhm_edittext)
    public EditText dbrsjhmEdittext;
    // 担保人所住单位
    @Bind(R.id.dbrszdw_edittext)
    public EditText dbrszdwEditText;
    // 担保人单位性质
    @Bind(R.id.dbrdwxz_spinner_text)
    public TextView dbrdwxzSpinnerText;
    @Bind(R.id.dbrdwxz_btn)
    public ImageButton dbrdwxzBtn;

    // 担保人单位职务
    @Bind(R.id.dbrdwzw_edittext)
    public EditText dbrdwzwEditText;
    // 担保人单位电话
    @Bind(R.id.dbrdwdh_edittext)
    public EditText dbrdwdhEditText;
    // 担保人单位地址
    @Bind(R.id.dbrdwdz_sheng_spinner_text)
    public TextView dbrdwdzShengSpinnerText;
    @Bind(R.id.dbrdwdz_sheng_btn)
    public  ImageButton dbrdwdzShengBtn;
    @Bind(R.id.dbrdwdz_shi_spinner_text)
    public TextView dbrdwdzShiSpinnerText;
    @Bind(R.id.dbrdwdz_shi_btn)
    public ImageButton dbrdwdzShiBtn;
    @Bind(R.id.dbrdwdz_xian_spinner_text)
    public EditText dbrdwdzxianEditText;
    @Bind(R.id.dbrdwdz_xx_edittext)
    public  EditText dbrdwxxdzEditText;

    // ----------------------添加视频资料
    @Bind(R.id.spzl_imageview)
    public ImageView spzlImageview;
    @Bind(R.id.spzl_textView)
    public TextView spzlTextview;

    // ---------------------------添加照片------------------------
    // 身份证正面
    @Bind(R.id.sfzzm_imageview)
    public ImageView sfzzmImageview;
    @Bind(R.id.sfzzm_textView)
    public TextView sfzzmTextview;
    // 身份证反面
    @Bind(R.id.sfzfm_imageview)
    public ImageView sfzfmImageview;
    @Bind(R.id.sfzfm_textView)
    public TextView sfzfmTextview;
    // 手持身份证
    @Bind(R.id.scsfz_imageview)
    public ImageView scsfzImageview;
    @Bind(R.id.scsfz_textView)
    public TextView scsfzTextview;
    // 与调查员合影
    @Bind(R.id.ydcyhy_imageview)
    public ImageView ydcyhyImageview;
    @Bind(R.id.ydcyhy_textView)
    public  TextView ydcyhyTextview;

    // 资质证明
    @Bind(R.id.zzzm_imageView)
    public  ImageView zzzmImageview;
    @Bind(R.id.zzzm_textView)
    public  TextView zzzmTextview;
    // 申请人小区
    @Bind(R.id.sqrxq_imageView)
    public ImageView sqrxqImageview;
    @Bind(R.id.sqrxq_textView)
    public  TextView sqrxqTextview;
    // 申请人所住楼号
    @Bind(R.id.sqrszlh_imageView)
    public ImageView sqrszlhImageview;
    @Bind(R.id.sqrszlh_textView)
    public TextView sqrszlhTextview;
    // 申请人所住单元
    @Bind(R.id.sqrszdy_imageView)
    public  ImageView sqrszdyImageview;
    @Bind(R.id.sqrszdy_textView)
    public  TextView sqrszdyTextview;
    // 申请人所住门牌号、
    @Bind(R.id.sqrszmph_imageView)
    public ImageView sqrszmphImageview;
    @Bind(R.id.sqrszmph_textView)
    public  TextView sqrszmphTextview;
    // 定位
    @Bind(R.id.dw_imageView)
    public ImageView dwImageview;
    @Bind(R.id.dw_textView)
    public TextView dwTextview;
    // 图片名称
    String picName = "";
    // 所有图片路径的集合
    public List<List<String>> allImgList;

    // 缓存数据的数据对象
    public RuHuData data;
    // ---------------------------保存按钮-------------------------------
    @Bind(R.id.ll_savedata)
    public LinearLayout ll_save;
    // 保存按钮
    @Bind(R.id.submit_btn)
    public Button saveButton;
    @Bind(R.id.btn_submit_save)
    public Button btn_submit_save;
    @Bind(R.id.btn_submit_delete)
    public Button btn_submit_delete;

    private String path;// 图片的保存路径
    private Bitmap bitmap;// 获取到的图片
    private Bitmap zteBitmap;// 压缩后的
    private String year;// 年份
    private String date;// 日期
    // private String str;// 总字段
    private String locationStr;// 获取的经纬度

    private Intent intent;

    // -------------------------------获取数据变量-------------------------------

    // 购车品牌
    public String gcpp;
    // 购车原因
    public String gcyy;
    // 裸车价格
    public String lcjg;
    // 还款途径
    public String hktj;
    // 进口车标志
    public String jkcbz;
    // 车型
    public String cx;
    // 排气量
    public String pql;
    // 中文姓名
    public String zwxm;
    //

    // 性别
    public String xb;
    // 出身年月
    public String csny;
    // 证件类型
    public String zjlx;

    // 证件号码
    public String zjhm;

    // 婚姻状况
    public String hyzk;

    // 共同s债人或者担保人
    public String gtczrordbr;
    // 手机号码
    public String sjhm;

    // 户口所在地
    public String hkszdsheng;
    public String hkszdshi;
    public String hkszdxxdz;
    public String hkszdxian;

    // 住宅状况
    public String zzzk;

    // 现居住地
    public String xjzdsheng;
    public String xjzdshi;
    public String xjzdxxdz;
    public String xjzdxian;

    // 所住单位
    public String szdw;
    // 单位性质
    public String dwxz;
    // 单位电话
    public String dwdh;
    // 职务类别
    public String zwlb;
    // 月均收入
    public String yjsr;
    // 单位地址
    public String dwdzsheng;
    public String dwdzshi;
    public String dwdzxxdz;
    public String dwdzxian;
    // 家庭已有贷款月还额度ac
    public String jtyydkyhed;
    // 银行卡号
    public String yhkh;

    // ---------------------------------申请人配偶情况-------------------------------
    // 配偶姓名
    public String poxm;

    // 配偶出生年月
    public String pocsny;
    // 配偶证件类型
    public String pozjlx;

    // 配偶证件号码
    public String pozjhm;

    // 配偶手机号码
    public String posjhm;

    // 配偶所住单位
    public String poszdw;
    // 配偶单位性质
    public String podwxz;
    // 配偶单位职务
    public String podwzw;
    // 配偶月均收入
    public String poyjsr;
    // 配偶单位电话
    public String podwdh;
    // 配偶单位地址
    public String podwdzsheng;
    public String podwdzshi;
    public String podwxxdz;
    public String podwdzxian;

    // ---------------------------担保人-----------------------------------
    // 担保人姓名
    public String dbrxm;

    // 担保人出生年月
    public String dbrcsny;
    // 担保人证件类型
    public String dbrzjlx;

    // 担保人证件号码
    public String dbrzjhm;

    // 担保人手机号码
    public String dbrsjhm;
    // 担保人所住单位
    public String dbrszdw;
    // 担保人单位性质
    public String dbrdwxz;
    // 担保人单位职务
    public String dbrdwzw;
    // 担保人单位电话
    public String dbrdwdh;
    // 担保人单位地址
    public String dbrdwdzsheng;
    public String dbrdwdzshi;
    public String dbrdwxxdz;
    public String dbrdwdzxian;

    // -----------------------------共同偿债人------------------------------------
    // 共同偿债人姓名
    public String gtczrxm;

    // 共同偿债人出生年月
    public String gtczrcsny;
    // 共同偿债人证件类型
    public String gtczrzjlx;

    // 共同偿债人证件号码
    public String gtczrzjhm;

    // 共同偿债人手机号码
    public String gtczrsjhm;

    // 共同偿债人所住单位
    public String gtczrszdw;
    // 共同偿债人单位性质
    public String gtczrdwxz;

    // 共同偿债人单位职务
    public String gtczrdwzw;
    // 共同偿债人单位电话
    public String gtczrdwdh;
    // 共同偿债人单位地址
    public String gtczrdwdzsheng;

    public String gtczrdwdzshi;

    public String gtczrdwxxdz;
    public String gtczrdwdzxian;

    // -------------------开卡补充资料-----------------------
    public String nameorEnglishname;// 姓名或英文名字
    public String zzyb;// 住宅邮编
    public String hsruaddress;// 何时入住地址
    public String zzdhhm;// 住宅电话号码
    public String jrxdwgzsj;// 进入现单位工作时间
    public String dwyp;// 单位邮编
    public String zy;// 职业

    public String gj;// 国籍
    public String zjsfcqyx;// 证件是否长期有效
    public String kkzjyxq;//证件有效期
    public String kkemail;//电子邮箱
    public String kkszbm;//所在部门
    public String kkdwdhfj;//单位电话分机
    public String kkzzdzsf;//开卡申请住宅地址省份
    public String kkzzdzs;//开卡住宅地址市
    public String kkzzdzx;//开卡住宅地址县
    public String kkzzdhqh;//开卡人住宅电话区号
    public String kkdwdhqh;//开卡人单位电话区号
    public String kkdwdzsf;//开发人单位地址省份
    public String kkdwdzs;//开卡人单位地址市
    public String kknsr;//开卡人年收入
    public String kkdwdzyb;//开卡人单位地址邮编
    public String lxryxm;// 联系人一姓名
    public String lxryyzksqrgx;// 联系人一与主卡申请人关系
    public String lxrylxdhh;// 联系人一联系电话号
    public String lxrysex;//联系人一性别
    public String kklxryzz;//联系人一住址
    public String kklxrylxdhqh;//联系人一联系电话区号
    public String lxrename;// 联系人二姓名
    public String lxreyzksqrgx;// 联系人二与主卡申请人关系zdw
    public String lxresex;//联系人二性别;
    public String kklxregzdw;//联系人二工作单位
    public String kklxrelxdhqh;//联系人二联系电话区号
    public String kklxrelxdhh;//联系人二联系电话号
    public String kklxrelxdhfj;//联系人二联系电话分机
    public String cardbin;//卡bin
//    public String cardlogo;//申请卡种类
//    public String cardtype;//申请卡类别
//    public String cardmedm;//k卡片介质；
//    public String saleno;//产品编码


    //    @Bind(R.id.rl_occpin)
//    // 开发补充职业
//            RelativeLayout rl_kaikazy;
//    @Bind(R.id.tv_occpin)
//    public TextView et_ocppin;


//    // 国籍
//    @Bind(R.id.rl_primnat)
//    RelativeLayout rl_gj;
//    @Bind(R.id.et_primnat)
//    public TextView et_gj;

//    // 证件是否长期有效
//    @Bind(R.id.rl_islongterm)
//    RelativeLayout rl_sfcqyx;
//    @Bind(R.id.et_islongterm)
//    public TextView et_sfcqyx;

    @Bind(R.id.et_kkname)
    // 开卡人姓名或应为名
    public EditText et_xmorEnclishName;
    //    @Bind(R.id.et_zzyb)
//    // 住宅邮编
//    public EditText et_kkrzzyp;
//    @Bind(R.id.et_hsrz)
//    // 何时入住现址
//    public TextView et_kkrhsrz;
//    @Bind(R.id.et_zztelnb)
    // 住宅电话号码
//    public EditText et_kkrzzdh;
    @Bind(R.id.et_joindate)
    // 进入现单位工作时间
    public TextView et_kkrjrdwgzsj;
    //    @Bind(R.id.et_corpzip)
//    // 单位邮编
//    public EditText et_dwyp;

    //卡bin
    @Bind(R.id.et_cardbin)
    public TextView et_cardbin;
    //证件有效期
    @Bind(R.id.et_zjyxq)
    public EditText zjyxq;
    //电子邮箱
    @Bind(R.id.et_email)
    public EditText email;
    //所在部门
    @Bind(R.id.et_szbm)
    public EditText szbm;
    //单位电话分机
    @Bind(R.id.et_dwdhfj)
    public EditText dwdhfj;
    //住在地址省份
    @Bind(R.id.et_zzdzsf)
    public EditText zzdzsf;
    //住宅地址市
    @Bind(R.id.et_zzdzs)
    public EditText zzdzs;
    //住在地址县
    @Bind(R.id.et_zzdzx)
    public EditText zzdzx;
    //住宅电话区号
    @Bind(R.id.et_zzdhqh)
    public EditText zzdhqh;
    //开卡单位电话区号
    @Bind(R.id.et_dwdhqh)
    public EditText dwdhqh;
    // 单位地址省份
    @Bind(R.id.et_dwdzsf)
    public EditText dwdzsf;
    //单位地址市
    @Bind(R.id.et_dwdzs)
    public EditText dwdzs;
    //单位地址邮编
    @Bind(R.id.et_dwdzyb)
    public EditText dwdzyb;
    //年收入
    @Bind(R.id.et_nsr)
    public EditText nsr;


    @Bind(R.id.et_reltname1)
    // 联系人一姓名
    public EditText et_kkrlxrxm;
    @Bind(R.id.et_relaphone1)
    // 联系人一联系电话号
    public EditText et_kkrlxr1lxhm;
    // 开发补充联系人一与主卡申请人关系
    @Bind(R.id.rl_reltship1)
    RelativeLayout rl_kkryyzkrgx;
    @Bind(R.id.et_reltship1)
    public TextView et_kkryyzkrgx;
    //联系人一性别
    @Bind(R.id.et_lxryxb)
    public EditText lxryxb;
    //联系人一住址
    @Bind(R.id.et_lxryzz)
    public EditText lxryzz;
    //联系人一联系电话区号
    @Bind(R.id.et_reltphzon1)
    public EditText lxrylxdhqh;

    @Bind(R.id.et_relaphone2)
    // 联系人二姓名
    public EditText et_kkrlxr2xm;
    // 开发补充联系人二与主卡申请人关系
    @Bind(R.id.rl_reltship2)
    RelativeLayout rl_kkreyzkrgx;
    @Bind(R.id.et_reltship2)
    public TextView et_kkreyzkrgx;
    //联系人二性别
    @Bind(R.id.et_lxr2xb)
    public EditText lxrexb;
    //联系人二工作单位
    @Bind(R.id.et_lxr2gzdw)
    public EditText lxregzdw;
    //联系人二联系电话区号
    @Bind(R.id.et_lxr2dhqh)
    public EditText lxrelxdhqh;
    //联系人二联系电话号
    @Bind(R.id.et_lxr2lxdhh)
    public EditText lxrelxdhh;
    //联系人二联系电话分机
    @Bind(R.id.et_lxr2lxdhfj)
    public EditText lxrelxdhfj;
    //----------------------------  ---------------------------------------------------------
    String stauta = "";
    @Bind(R.id.scrollview)
    ScrollView scrollView;// 跟布局文件()
    @Bind(R.id.ll_scrolllinearlayout)
    LinearLayout ll;
    private ProgressBar progressBar;
    // private TextView tv_uploading;// 上传图片时，显示的已上传的张数
    // private TextView tv_upimgTotal;// 上传图片时显示为需要上传的总数。
    public BasicNameValuePair sfzlbnv;// 身份信息
    public BasicNameValuePair dzxqbnv;// 地址详情
    public BasicNameValuePair dtdwbnv;// 地图定位
    public BasicNameValuePair srwjzmbnv;// 收入文件证明
    public BasicNameValuePair gcfpwjbnv;// 购车发票文件
    public BasicNameValuePair sfkzmwjbnv;// 首付款证明文件
    public BasicNameValuePair cldiwjzmbnv;// 车辆抵押文件证明
    public BasicNameValuePair clbxdwjbnv;// 车辆保险单文件
    public BasicNameValuePair gchtbnv;// 购车合同文件
    public BasicNameValuePair zxbgbnv;// 征信报告文件

    // -----------------------------征信-------------------------
    // 申请人配偶征信状况
    @Bind(R.id.sqrpozxzk_spinner_text)
    public TextView sqrpozxzk_tv;
    @Bind(R.id.rl_sqrpozx)
    public  RelativeLayout sqrpozxzk_btn;
    // 申请人征信状况
    @Bind(R.id.sqrzxzk_spinner_text)
    public  TextView sqrzxzk_et;
    @Bind(R.id.rl_sqrzx)
    public  RelativeLayout rl_sqrzx;
    // 申请人学历
    @Bind(R.id.sqrxl_spinner_text)
    public TextView sqrxl_tv;
    @Bind(R.id.rl_sqrxl)
    public RelativeLayout sqrxl_btn;

    // 分期金额fenqiJE_edittext
    @Bind(R.id.fenqiJE_edittext)
    public EditText fqJE_et;

    // 信用总额度
    @Bind(R.id.xinyongkaZED_edittext)
    public TextView xinyongzongED_et;

    // 申请人家庭收入还款比
    @Bind(R.id.sqrjtsrhdb_edittext)
    public  TextView sqrjtsrhkb_et;

    // 成数
    @Bind(R.id.cs_edittext)
    public TextView cs_et;
    // 分期付款期数
    @Bind(R.id.fqfkqs_edittext)
    public TextView fqfkqs_et;
    @Bind(R.id.rl_fqfkqs)
    public RelativeLayout fqfkqs_rl;
    // 首月还款金额
    @Bind(R.id.syhkje_edittext)
    public TextView syhkje_et;
    // 月还款金额
    @Bind(R.id.yhkje_edittext)
    public TextView yhkje_et;
    // 分期付款手续费率
    @Bind(R.id.fqfksxfl_edittext)
    public TextView fqfksxfl_et;
    // 手续费金额
    @Bind(R.id.sxfje_textview)
    public TextView sxfje_text;

    // 用于生成报告或是保存数据或是上传照片是否成功的回调
    public Handler handler = new Handler() {

        public void handleMessage(android.os.Message msg) {

            if (msg.what == 0) {
                // System.out.println("---------0--------");
                postData();

            }

            if (msg.what == 1) {
                // System.out.println("------1-------------");

            }
        }

        ;
    };
    private String MYCOOKIES;
    public SharedPreferences sp;
    private Realm mRealm;//缓存用数据库对象
    /**
     * 初始化布局
     */

    @Override
    public View initView() {
        view = View.inflate(mActivity, R.layout.fragment_first_lending, null);

        EventBus.getDefault().register(this);

        ButterKnife.bind(this, view);
        DoDao = new DoSomeThsDao(getActivity());
        return view;
    }

    /**
     * 初始化数据
     */
    @Override
    public void initData() {
        videosp = getActivity().getSharedPreferences("video_url",
                Context.MODE_PRIVATE);
        videoeditor = videosp.edit();
        sp = getActivity().getSharedPreferences("login", Context.MODE_PRIVATE);
        MYCOOKIES = sp.getString("MYCOOKIES", null);

        nameValuePairs = new ArrayList<NameValuePair>();

        sfzzmList = new ArrayList<String>();
        sfzfmList = new ArrayList<String>();
        scsfzmList = new ArrayList<String>();
        ydcyhyList = new ArrayList<String>();
        zzzmList = new ArrayList<String>();
        sqrxqList = new ArrayList<String>();
        sqrszlhList = new ArrayList<String>();
        sqrszdyList = new ArrayList<String>();
        sqrszmphList = new ArrayList<String>();
        dwList = new ArrayList<String>();
        allImgList = new ArrayList<List<String>>();

        spinnerAdapter = new CustemSpinerAdapter(getActivity());
        spinnerPopWindow = new SpinerPopWindow(getActivity());
        //初始化缓存数据数据库的操作
        Realm.init(getActivity());
        RealmConfiguration config = new RealmConfiguration.Builder()
                .name("FirstLending.realm")
                .build();
        Realm.setDefaultConfiguration(config);
        mRealm = Realm.getDefaultInstance();
        //spinnerPopWindow.setItemListener(this);

        // // 定位
        getWeiZhi();

        // 申请原因控件初始
        requestReasonInitView();

        // 申请人基本情况初始化控件
        requestPersonInitView();

        // 申请人配偶信息控件的初始化
        requstPersonalSpouse();

        // 共同偿债人控件初始化
        requestGtczrInitView();

        // 担保人控件初始化
        requestDbrInitView();

        // 认证
        renzhengInitView();

        // 添加照片初始化控件
        AddImgInitView();

        // 保存按钮

        // 初始化控件状态
        sqrpoqkLayout.setVisibility(View.GONE);
        dbrLayout.setVisibility(View.GONE);
        gtczrLayout.setVisibility(View.GONE);
        ll_gtczordbr.setVisibility(View.GONE);
        if (GLobleData.logindata.getData().getSxfstatus().equals("0")) {
            ll_sxfstatus.setVisibility(View.GONE);
        } else {
            ll_sxfstatus.setVisibility(View.VISIBLE);
        }


        // 申请人初始化基本信息
        requestPersonInitData();
        // 配偶初始化基本信息
        spouseInitData();
        // 担保人初始化信息
        dbrInitData();
        // 共同偿债人初始化信息
        gtczrInitData();

    }


    /**
     * 征信
     */
    private void renzhengInitView() {

    }

    private void scrollTo() {
        handler.post(new Runnable() {
            // ll_scrolllinearlayout
            @Override
            public void run() {
                System.out.println("执行了滚动");

                scrollView.fullScroll(ScrollView.FOCUS_DOWN);

            }

        });

    }

    /**
     * 共同偿债人初始化信息
     */
    private void gtczrInitData() {
        gtczrzjhmEditText.addTextChangedListener(new MyFirstLendingTextWher(this,
                gtczrzjhmEditText));
        // 共同偿债人证件号码

    }

    /**
     * 担保人初始化信息
     */
    private void dbrInitData() {

        // 证件担保人号码
        dbrzjhmEditText.addTextChangedListener(new MyFirstLendingTextWher(this,
                dbrzjhmEditText));

    }

    /**
     * 配偶初始化基本信息
     */
    private void spouseInitData() {

        // 配偶证件号码
        pozjhmEditText.addTextChangedListener(new MyFirstLendingTextWher(this,
                pozjhmEditText));

    }

    /**
     * 申请人初始化基本数据
     */
    private void requestPersonInitData() {
        // 婚姻状况
        hyzkSpinnerText.addTextChangedListener(new MyFirstLendingTextWher(this,
                hyzkSpinnerText));

        // 共同偿债人或者担保人
        gtczrordbrSpinnerText.addTextChangedListener(new MyFirstLendingTextWher(this,
                gtczrordbrSpinnerText));

        // 住宅状况
        zzzkSpinnerText.addTextChangedListener(new MyFirstLendingTextWher(this,
                zzzkSpinnerText));

        // 证件号码
        zjhmEdittext.addTextChangedListener(new MyFirstLendingTextWher(this, zjhmEdittext));

    }

    /**
     * 添加图片控件初始化
     */
    private void AddImgInitView() {

    }

    /**
     * 担保人控件初始化
     */
    private void requestDbrInitView() {

        dbrzjlxSpinnerText.setText("身份证");

    }

    /**
     * 共同偿债人控件初始化
     */
    private void requestGtczrInitView() {

        gtczrzjlxSpinnerText.setText("身份证");

    }

    /**
     * 申请人配偶控件初始化
     */
    private void requstPersonalSpouse() {

        pozjlxSpinnerText.setText("身份证");

    }

    int mYear, mMonth, mDay = 0;
    private DatePickerDialog DatapickeDialog;

    /**
     * 申请人控件的初始化
     */
    private void requestPersonInitView() {

        zjlxSpinnerText.setText("身份证");
        sjhmEdittext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String moblestr = sjhmEdittext.getText().toString().trim();

                if (moblestr.length() == 11) {
                    if (RegexUtil.isMobileNO(moblestr)) {
                    } else {
                        ToastUtil.showShort(getActivity(), "请输入正确的手机号");

                    }
                }
            }

        });

        //设置邮箱验证
        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String emailstr = email.getText().toString().trim();
                if (emailstr.contains("@") && emailstr.contains(".com")) {
                    if (RegexUtil.isEmail(emailstr)) {

                    } else {
                        ToastUtil.showShort(getActivity(), "请输入正确邮箱");
                    }
                }
            }
        });
        // 家庭已有贷款月还款额

        jtyydkyhkeEditText
                .setFilters(new InputFilter[]{new EditInputFilter()});

        jtyydkyhkeEditText.setOnFocusChangeListener(new MyFocusChangeListener(
                jtyydkyhkeEditText));

        // 首月还款金额

        syhkje_et.setFilters(new InputFilter[]{new EditInputFilter()});

        syhkje_et
                .setOnFocusChangeListener(new MyFocusChangeListener(syhkje_et));
        // 月还款金额

        yhkje_et.setFilters(new InputFilter[]{new EditInputFilter()});

        yhkje_et.setOnFocusChangeListener(new MyFocusChangeListener(yhkje_et));
        // 分期金额
        fqJE_et.addTextChangedListener(new MyTextWachert(fqJE_et,
                xinyongzongED_et, lcjgEdittext, fqfkqs_et, syhkje_et, yhkje_et,
                cs_et, fqfksxfl_et, yjsrEditText, jtyydkyhkeEditText,
                sqrjtsrhkb_et, sxfje_text, poyjsrEditText, sxfstatusEditText

        ));
        // 分期付款期数
        fqfkqs_et.addTextChangedListener(new MyTextWachert(fqJE_et,
                xinyongzongED_et, lcjgEdittext, fqfkqs_et, syhkje_et, yhkje_et,
                cs_et, fqfksxfl_et, yjsrEditText, jtyydkyhkeEditText,
                sqrjtsrhkb_et, sxfje_text, poyjsrEditText, sxfstatusEditText));

        // 申请人月均收入
        yjsrEditText.addTextChangedListener(new MyTextWachert(fqJE_et,
                xinyongzongED_et, lcjgEdittext, fqfkqs_et, syhkje_et, yhkje_et,
                cs_et, fqfksxfl_et, yjsrEditText, jtyydkyhkeEditText,
                sqrjtsrhkb_et, sxfje_text, poyjsrEditText, sxfstatusEditText));
//        sxfstatusEditText.addTextChangedListener();
//        // 何時入住现地址
//        et_kkrhsrz.setOnClickListener(new OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
//
//                DatapickeDialog = new DatePickerDialog(getActivity(),
//                        dateListener, mYear, mMonth, mDay);
//                DatapickeDialog.show();
//            }
//        });
        // 给开卡资料补充的入职时间监听
        et_kkrjrdwgzsj.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                DatapickeDialog = new DatePickerDialog(getActivity(),
                        mdateListener, mYear, mMonth, mDay);
                DatapickeDialog.show();
            }
        });
    }

    // 日期选择器的监听
    private DatePickerDialog.OnDateSetListener mdateListener = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            mYear = year;
            mMonth = monthOfYear;
            mDay = dayOfMonth;

            et_kkrjrdwgzsj.setText(new StringBuffer().append(mYear)
                    .append(mMonth + 1 < 10 ? "0" + (mMonth + 1) : mMonth + 1).append(""));

            DatapickeDialog.cancel();
        }
    };
    // 日期选择器的监听
    private DatePickerDialog.OnDateSetListener dateListener = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            mYear = year;
            mMonth = monthOfYear;
            mDay = dayOfMonth;

//            et_kkrhsrz.setText(new StringBuffer().append(mYear).append("-")
//                    .append(mMonth + 1 < 10 ? "0" + (mMonth + 1) : mMonth + 1).append("-").append(mDay >= 10 ? mDay : "0" + mDay).append(""));

            DatapickeDialog.cancel();
        }
    };

    /**
     * 申请原因控件的初始化
     */
    private void requestReasonInitView() {

        // 裸车价格
        lcjgEdittext.setFilters(new InputFilter[]{new EditInputFilter()});
        lcjgEdittext.setOnFocusChangeListener(new MyFocusChangeListener(
                lcjgEdittext));
        // 分期金额
        fqJE_et.setFilters(new InputFilter[]{new EditInputFilter()});
        fqJE_et.setOnFocusChangeListener(new MyFocusChangeListener(fqJE_et));

        yjsrEditText.setFilters(new InputFilter[]{new EditInputFilter()});
        yjsrEditText.setOnFocusChangeListener(new MyFocusChangeListener(
                yjsrEditText));

        et_cardbin.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!(et_cardbin.getText().toString().equals("")) && null != et_cardbin.getText().toString()) {

                    Map<String, String> map = new HashMap<String, String>();
                    map.put("cardbin", et_cardbin.getText().toString());
                    new NoHttpRequest(getActivity(), sp).Request(map, Constants.CARDMESSAGEURL, null,
                            NoCode.NOHTTP_WHAT_GETCARDBINSMSG);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void setSpinnerText(int pos) {
        if (pos >= 0 && pos <= spinnerList.size()) {
            CustemObject value = spinnerList.get(pos);
            selectedSpinnerText.setText(value.toString());
        }
    }



    /**
     * 调用照相机拍照
     */
    private void camera(int requestCode) {
        String status = Environment.getExternalStorageState();
        if (status.equals(Environment.MEDIA_MOUNTED)) {
            try {
                picName = new Date().getTime() + ".jpg";
                System.out.println("picName=====" + picName);
                File dir = new File(Environment.getExternalStorageDirectory()
                        + "/" + "dq" + "/");
                System.out.println("..........ruhufragment" + dir.toString());
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File f = new File(dir, picName);// localTempImgDir和localTempImageFileName是自己定义的名字
                System.out.println("..........ruhufragment" + f.toString());
                Uri u = Uri.fromFile(f);
                System.out.println("+++++" + u);
                intent.putExtra(MediaStore.Images.Media.ORIENTATION, 0);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, u);
                startActivityForResult(intent, requestCode);
            } catch (ActivityNotFoundException e) {

                ToastUtil.showShort(getActivity(), "没有找到储存目录");
            }
        } else {
            ToastUtil.showLong(getActivity(), "没有储存卡");

        }
    }



    public  int takephototimes = 0;

    @SuppressLint("SetTextI18n")
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        scrollTo();
        // 记录操作员的拍照这一操作
        if (takephototimes == 0) {
            String str = GetDateUtil.getCurrentTime();

            DoDao.addMessage(new DsomeThings(GLobleData.logindata.getData()
                    .getJobnum(), "1", "拍照", str, ""));
            takephototimes++;
        }
        if (resultCode == 13) {
            IdentifyResult result = (IdentifyResult) data.getSerializableExtra("result");

            if (result != null && (result.getAddress().contains("省") )) {
                String address = result.getAddress();
                String sheng=address.substring(0, address.indexOf("省") + 1)+"";

                byte[] bitmapArray;
                bitmapArray = Base64.decode(result.getFrontimage(), Base64.DEFAULT);
                Bitmap   bitmap = BitmapFactory.decodeByteArray(bitmapArray, 0,
                        bitmapArray.length);
                try {
                    String picName = new Date().getTime() + ".jpg";
                    String path = Environment.getExternalStorageDirectory() + "/" + "dq" + "/"
                            + picName;
                    File file=new File(path);
                    FileOutputStream fos=new FileOutputStream(file);
                    bitmap.compress(CompressFormat.JPEG,100,fos);
                    fos.flush();

                    fos.close();
                    sfzzmImageview.setImageBitmap(bitmap);
                    sfzzmList.add(path);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                zwxmEdittext.setText(result.getName());
                zwxmEdittext.setText(result.getName());
                zjhmEdittext.setText(result.getId());
                hkszdShengSpinnerText.setText(sheng);
                if(result.getAddress().contains("市")){
                    hkszdShiSpinnerText.setText(address.substring(address.indexOf("省") + 1, address.indexOf("市") + 1)+"");
                    if(result.getAddress().contains("县")){
                        hkszdxianEditText.setText(address.substring(address.indexOf("市") + 1, address.indexOf("县") + 1)+"");
                        hkszdXxdzEditText.setText(address.substring(address.indexOf("县") + 1, address.length() - 1)+"");
                        return;
                    }else if(result.getAddress().contains("区")){

                        hkszdxianEditText.setText(address.substring(address.indexOf("市") + 1, address.indexOf("区") + 1)+"");
                        hkszdXxdzEditText.setText(address.substring(address.indexOf("区") + 1, address.length() - 1)+"");
                        return;
                    }else if(result.getAddress().contains("镇")){

                        hkszdXxdzEditText.setText(address.substring(address.indexOf("市") + 1, address.length() - 1)+"");
                    }

                }else if(result.getAddress().contains("县")){
                    hkszdxianEditText.setText(address.substring(address.indexOf("省") + 1, address.indexOf("县") + 1)+"");
                    hkszdXxdzEditText.setText(address.substring(address.indexOf("县") + 1, address.length() - 1)+"");

                }else if(result.getAddress().contains("州")){
                    hkszdShiSpinnerText.setText(address.substring(address.indexOf("省") + 1, address.indexOf("州") + 1)+"");
                    if(result.getAddress().contains("市")){
                        hkszdxianEditText.setText(address.substring(address.indexOf("州") + 1, address.indexOf("市") + 1)+"");
                        hkszdXxdzEditText.setText(address.substring(address.indexOf("市") + 1, address.length() - 1)+"");

                    }
                }

            }else if(result.getAddress().contains("市")){
                String address = result.getAddress();
                hkszdShiSpinnerText.setText(address.substring(0, address.indexOf("市") + 1)+"");
                if(result.getAddress().contains("区")){
                    hkszdxianEditText.setText(address.substring(address.indexOf("市") + 1, address.indexOf("区") + 1)+"");
                    hkszdXxdzEditText.setText(address.substring(address.indexOf("区") + 1, address.length() - 1)+"");

                }else if(result.getAddress().contains("县")){
                    hkszdxianEditText.setText(address.substring(address.indexOf("市") + 1, address.indexOf("县") + 1)+"");
                    hkszdXxdzEditText.setText(address.substring(address.indexOf("县") + 1, address.length() - 1)+"");
                }


            }else{
                ToastUtil.showShort(getActivity(),"您的身份证地址信息暂时无法识别，请手动输入地址");

            }
//            else if(result.getAddress().contains("自治区")){
//                String address = result.getAddress();
//                hkszdShengSpinnerText.setText(address.substring(0, address.indexOf("自治区") + 1)+"");
//                hkszdShiSpinnerText.setText(address.substring(address.indexOf("自治区") + 1, address.indexOf("州") + 1)+"");
//                if(result.getAddress().contains("市")){
//                    hkszdxianEditText.setText(address.substring(address.indexOf("州") + 1, address.indexOf("市") + 1)+"");
//                    hkszdXxdzEditText.setText(address.substring(address.indexOf("市") + 1, address.length() - 1)+"");
//
//                }
//            }


            System.out.print(result.getName());



        } else if (resultCode == 14) {

            IdentifyResult result = (IdentifyResult) data.getSerializableExtra("result");
            if (result != null && (result.getAddress().contains("省") || result.getAddress().contains("市"))) {

//                pozjlxSpinnerText.setText(pozjtype);
//               pozjhmEditText
                poxmEditText.setText(result.getName());
                pozjhmEditText.setText(result.getId());
//                String address=result.getAddress();

            }
        }
        if (resultCode == 11) {

            spzlImageview.setImageBitmap(ScreenUtils.getVideoThumb(data
                    .getStringExtra("mvpath")));

        }
        if (resultCode == getActivity().RESULT_OK) {
            switch (requestCode) {
                case 1:
                    // 身份证正面
                    getBitmap();
                    if (zteBitmap != null) {
                        sfzzmImageview.setImageBitmap(zteBitmap);
                        sfzzmList.add(path);
                        if (badgeSfzzm == null) {
                            badgeSfzzm = new BadgeView(getActivity(),
                                    sfzzmImageview);
                            sfzzmImageview.setTag(badgeSfzzm);
                        } else {
                            badgeSfzzm = (BadgeView) sfzzmImageview.getTag();
                        }
                        if (sfzlList != null && sfzlList.size() > 0) {
                            msfzlList = addmList(sfzlList, sfzzmList);// 此步骤是将网络图片和本地照片添加到一个路径
                            badgeSfzzm.setText(""
                                    + (sfzzmList.size() + sfzlList.size()));
                        } else {
                            badgeSfzzm.setText("" + sfzzmList.size());
                        }
                        badgeSfzzm.show();

                    }

                    break;
                case 2:
                    // 身份证反面
                    getBitmap();
                    if (zteBitmap != null) {
                        sfzfmImageview.setImageBitmap(zteBitmap);
                        sfzfmList.add(path);
                        if (badgesfzfm == null) {
                            badgesfzfm = new BadgeView(getActivity(),
                                    sfzfmImageview);
                            sfzfmImageview.setTag(badgesfzfm);
                        }
                        if (dzxqList != null && dzxqList.size() > 0) {

                            mdzxxList = addmList(dzxqList, sfzfmList);
                            badgesfzfm.setText(""
                                    + (sfzfmList.size() + dzxqList.size()));
                        } else {
                            badgesfzfm.setText("" + sfzfmList.size());
                        }
                        badgesfzfm.show();
                    }
                    break;
                case 10:
                    // 征信报告文件
                    getBitmap();
                    if (zteBitmap != null) {
                        dwImageview.setImageBitmap(zteBitmap);
                        dwList.add(path);
                        if (badgedw == null) {
                            badgedw = new BadgeView(getActivity(), dwImageview);
                            dwImageview.setTag(badgedw);
                        } else {
                            badgedw = (BadgeView) dwImageview.getTag();
                        }
                        if (zxbgwjzmList != null && zxbgwjzmList.size() > 0) {
                            mzxbgList = addmList(zxbgwjzmList, dwList);
                            badgedw.setText(""
                                    + (dwList.size() + zxbgwjzmList.size()));
                        } else {
                            badgedw.setText("" + dwList.size());
                        }
                        badgedw.show();
                    }
                    break;
                case 4:
                    // 收入证明文件
                    getBitmap();
                    if (zteBitmap != null) {
                        ydcyhyImageview.setImageBitmap(zteBitmap);
                        ydcyhyList.add(path);
                        if (badgeydcyhy == null) {
                            badgeydcyhy = new BadgeView(getActivity(),
                                    ydcyhyImageview);
                            ydcyhyImageview.setTag(badgeydcyhy);
                        } else {
                            badgeydcyhy = (BadgeView) ydcyhyImageview.getTag();
                        }
                        if (srwjzmList != null && srwjzmList.size() > 0) {
                            msrzmlList = addmList(srwjzmList, ydcyhyList);
                            badgeydcyhy.setText(""
                                    + (ydcyhyList.size() + srwjzmList.size()));
                        } else {
                            badgeydcyhy.setText("" + ydcyhyList.size());
                        }
                        badgeydcyhy.show();
                    }

                    break;

                case 5:
                    // 资质证明
                    getBitmap();
                    if (zteBitmap != null) {
                        zzzmImageview.setImageBitmap(zteBitmap);
                        zzzmList.add(path);
                        if (badgezzzm == null) {
                            badgezzzm = new BadgeView(getActivity(), zzzmImageview);
                            zzzmImageview.setTag(badgezzzm);
                        } else {
                            badgezzzm = (BadgeView) zzzmImageview.getTag();
                        }
                        if (gcfpwjzmList != null && gcfpwjzmList.size() > 0) {
                            mgcfpList = addmList(gcfpwjzmList, zzzmList);
                            badgezzzm.setText(""
                                    + (zzzmList.size() + gcfpwjzmList.size()));
                        } else {

                            badgezzzm.setText("" + zzzmList.size());
                        }
                        badgezzzm.show();
                    }
                    break;

                case 6:
                    // 首付款证明
                    getBitmap();
                    if (zteBitmap != null) {
                        sqrxqImageview.setImageBitmap(zteBitmap);
                        sqrxqList.add(path);
                        if (badgesqrxq == null) {
                            badgesqrxq = new BadgeView(getActivity(),
                                    sqrxqImageview);
                            sqrxqImageview.setTag(badgesqrxq);
                        } else {

                            badgesqrxq = (BadgeView) sqrxqImageview.getTag();
                        }
                        if (sfkwjzmList != null && sfkwjzmList.size() > 0) {
                            msfkList = addmList(sfkwjzmList, sqrxqList);
                            badgesqrxq.setText(""
                                    + (sqrxqList.size() + sfkwjzmList.size()));
                        } else {
                            badgesqrxq.setText("" + sqrxqList.size());
                        }
                        badgesqrxq.show();
                    }
                    break;

                case 7:
                    // 申请人所住楼号
                    getBitmap();
                    if (zteBitmap != null) {
                        sqrszlhImageview.setImageBitmap(zteBitmap);
                        sqrszlhList.add(path);
                        if (badgesqrszl == null) {
                            badgesqrszl = new BadgeView(getActivity(),
                                    sqrszlhImageview);
                            sqrszlhImageview.setTag(badgesqrszl);
                        } else {
                            badgesqrszl = (BadgeView) sqrszlhImageview.getTag();

                        }
                        if (cldiwjzmList != null && cldiwjzmList.size() > 0) {
                            mcldyList = addmList(cldiwjzmList, sqrszlhList);
                            badgesqrszl.setText(""
                                    + (sqrszlhList.size() + cldiwjzmList.size()));
                        } else {
                            badgesqrszl.setText("" + sqrszlhList.size());
                        }
                        badgesqrszl.show();
                    }
                    break;

                case 8:
                    // 申请人所住单元
                    getBitmap();
                    if (zteBitmap != null) {
                        sqrszdyImageview.setImageBitmap(zteBitmap);
                        sqrszdyList.add(path);
                        if (badgesqrszdy == null) {
                            badgesqrszdy = new BadgeView(getActivity(),
                                    sqrszdyImageview);
                            sqrszdyImageview.setTag(badgesqrszdy);

                        } else {
                            badgesqrszdy = (BadgeView) sqrszdyImageview.getTag();
                        }
                        if (clbxdwjList != null && clbxdwjList.size() > 0) {

                            mclbxList = addmList(clbxdwjList, sqrszdyList);
                            badgesqrszdy.setText(""
                                    + (sqrszdyList.size() + clbxdwjList.size()));
                        } else {
                            badgesqrszdy.setText("" + sqrszdyList.size());
                        }
                        badgesqrszdy.show();
                    }
                    break;

                case 9:
                    // 购车合同文件
                    getBitmap();
                    if (zteBitmap != null) {
                        sqrszmphImageview.setImageBitmap(zteBitmap);
                        sqrszmphList.add(path);
                        if (badgesqrszmph == null) {
                            badgesqrszmph = new BadgeView(getActivity(),
                                    sqrszmphImageview);
                            sqrszmphImageview.setTag(badgesqrszmph);
                        } else {
                            badgesqrszmph = (BadgeView) sqrszmphImageview.getTag();
                        }
                        if (gchewjzmList != null && gchewjzmList.size() > 0) {
                            mgchtList = addmList(gchewjzmList, sqrszmphList);
                            badgesqrszmph.setText(""
                                    + (sqrszmphList.size() + gchewjzmList.size()));
                        } else {

                            badgesqrszmph.setText("" + sqrszmphList.size());
                        }
                        badgesqrszmph.show();
                    }
                    break;
            }

        }

        if (requestCode == 3 ) {

//            String strPath = data.getStringExtra("path");
//
//            if (null != strPath && !(strPath.equals(""))) {
//                BitmapFactory.Options options = new BitmapFactory.Options();
//                // options.inJustDecodeBounds = true;
//                options.inSampleSize = 4;
//                options.inJustDecodeBounds = false;
//                Bitmap dwbitmap = BitmapFactory.decodeFile(strPath, options);
//
//                scsfzImageview.setImageBitmap(dwbitmap);
//
//                scsfzmList.add(strPath);
//            } else {
//
//                ToastUtil.showShort(getActivity(), "请您确认点击的是截屏而不是返回");
//            }   以上是保留地址定位的逻辑
            getBitmap();
            if (zteBitmap != null) {
                scsfzImageview.setImageBitmap(zteBitmap);
//
                scsfzmList.add(path);
                if (badgescsfzm == null) {
                    badgescsfzm = new BadgeView(getActivity(), scsfzImageview);
                    scsfzImageview.setTag(badgescsfzm);
                }
                if (dzdwList != null && dzdwList.size() > 0) {
                    mdwList = addmList(dzdwList, scsfzmList);
                    badgescsfzm.setText("" + (scsfzmList.size() + dzdwList.size()));
                } else {
                    badgescsfzm.setText("" + scsfzmList.size());
                }
                badgescsfzm.show();

            }

        }
        zteBitmap = null;
    }

    Handler netHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            if (msg.what != 1) {
                if ((boolean) msg.obj) {

                    ToastUtil.showShort(getActivity(), "当前网络状况较好可以上传图片");
                    saveButton.setClickable(false);
                    stauta = "1";
                    CacheLocation();//先将需要提交的数据缓存在本地
                    if (GLobleData.VideoPath != null
                            && !("".equals(GLobleData.VideoPath))) {
                        nameValuePairs.add(new BasicNameValuePair("video_url",
                                GLobleData.VideoPath));
                        System.out.println("没上传视频之后的：" + nameValuePairs.toString());
                        GLobleData.VideoPath = null;
                    }

                    submitData(stauta);

                    String str = GetDateUtil.getCurrentTime();
                    DoDao.addMessage(new DsomeThings(GLobleData.logindata.getData()
                            .getJobnum(), "1", "提交数据到服务器", str, ""));
                } else {
                    ToastUtil.showShort(getActivity(), "当前网络情况不好建议不要上传图片");
                    CacheLocation();//先将需要提交的数据缓存在本地
                }
            } else {
                ToastUtil.showShort(getActivity(), "正在检测当前网速");

            }
        }
    };


    // 使用注解加监听的方法
    @OnClick({R.id.submit_btn, R.id.tv_yhkxffx, R.id.ll_zxrz, R.id.tv_rlsb,
            R.id.ll_dcwj, R.id.rl_huankuanzhengming, R.id.rl_jkcenterport,
            R.id.rl_fqfkqs, R.id.rl_Displacement, R.id.rl_CredentialsModel,
            R.id.rl_MaritalStatus, R.id.gtczrordbr_btn, R.id.rl_Residential,
            R.id.rl_unitnature, R.id.rl_Postnature, R.id.pozjlx_btn,
            R.id.podwxz_btn, R.id.gtczrzjlx_btn, R.id.gtczrdwxz_btn,
            R.id.dbrzjlx_btn, R.id.dbrdwxz_btn, R.id.hkszd_sheng_btn, R.id.hkszd_shi_btn,
            R.id.xjzd_sheng_spinner_text, R.id.xjzd_shi_btn, R.id.rl_sqrpozx, R.id.rl_sqrzx,
            R.id.rl_sqrxl, R.id.rl_buyCarModel, R.id.dwdz_sheng_btn,
            R.id.dwdz_shi_btn, R.id.podwdz_sheng_btn, R.id.podwdz_shi_btn,
            R.id.gtczrdwdz_sheng_btn, R.id.gtczrdwdz_shi_btn,
            R.id.dbrdwdz_sheng_btn, R.id.dbrdwdz_shi_btn, R.id.sfzzm_imageview,
            R.id.sfzzm_textView, R.id.sfzfm_imageview, R.id.sfzfm_textView,
            R.id.scsfz_imageview, R.id.scsfz_textView, R.id.ydcyhy_imageview,
            R.id.ydcyhy_textView, R.id.zzzm_imageView, R.id.zzzm_textView,
            R.id.sqrxq_imageView, R.id.sqrszlh_textView,
            R.id.sqrszdy_imageView, R.id.sqrszdy_textView,
            R.id.sqrszmph_imageView, R.id.sqrszmph_textView, R.id.dw_imageView,
            R.id.dw_textView, R.id.btn_submit_save, R.id.sqrszlh_imageView,
            R.id.sqrxq_textView, R.id.rl_reltship1,
            R.id.rl_reltship2,
            R.id.spzl_imageview, R.id.spzl_textView, R.id.playsp_textView,
            R.id.btn_submit_delete, R.id.tv_sfsm, R.id.tv_po_sfsm, R.id.rl_cardbin,R.id.bt_hqsfxx,R.id.tv_spzl,R.id.xjzd_sheng_btn})
    public void onClick(View v) {

        String[] shengList = getResources().getStringArray(R.array.sheng_list);
        String[] shiList = getResources().getStringArray(R.array.shi_list);

        switch (v.getId()) {

//            // 银行卡消费分析
//            case R.id.tv_yhkxffx:
//                yhkh = yhkhEditText.getText().toString().trim();
//                requstYhkxffx();
//                break;

            // 征信认证
            case R.id.ll_zxrz:
                requestZx();
                break;
            // 人脸识别
//            case R.id.tv_rlsb:
//
//                String nowname = zwxmEdittext.getText().toString().trim();
//                String nowzjhm = zjhmEdittext.getText().toString().trim();
//                Intent rlsbintent = new Intent(mActivity, RLSBActivity.class);
//                rlsbintent.putExtra("name", nowname);
//                rlsbintent.putExtra("zjhm", nowzjhm);
//                startActivity(rlsbintent);
//                // requesthtrz();
//                break;
            case R.id.ll_dcwj:
                showDailogDCWJ();
                // 还款途径
            case R.id.rl_huankuanzhengming:

                showTextSpinnerUtils.showSpinWindow(getActivity(),
                        R.array.hkly_list,spinnerAdapter,spinnerPopWindow,hktjSpinnerText);
                break;
            // 进口车标志
            case R.id.rl_jkcenterport:

                showTextSpinnerUtils.showSpinWindow(getActivity(),
                        R.array.jkcbz_list,spinnerAdapter,spinnerPopWindow,jkcbzSpinnerText);
                break;
            // 分期还款期数
            case R.id.rl_fqfkqs:

                showTextSpinnerUtils.showSpinWindow(getActivity(),
                        R.array.fqhkqs_list,spinnerAdapter,spinnerPopWindow,fqfkqs_et);
                break;
            // 排气量
            case R.id.rl_Displacement:

                showTextSpinnerUtils.showSpinWindow(getActivity(),
                        R.array.pql_list,spinnerAdapter,spinnerPopWindow,pqlSpinnerText);
                break;
            // 证件类型
            case R.id.rl_CredentialsModel:

                showTextSpinnerUtils.showSpinWindow(getActivity(),
                        R.array.zjlx_list,spinnerAdapter,spinnerPopWindow,zjlxSpinnerText);
                break;
            // 婚姻状况
            case R.id.rl_MaritalStatus:

                showTextSpinnerUtils.showSpinWindow(getActivity(),
                        R.array.hyzk_list,spinnerAdapter,spinnerPopWindow,hyzkSpinnerText);
                break;
            // 共同偿债人或者担保人
            case R.id.gtczrordbr_btn:

                showTextSpinnerUtils.showSpinWindow(getActivity(),
                        R.array.gtczrordbr_list,spinnerAdapter,spinnerPopWindow,gtczrordbrSpinnerText);
                break;
            // 住宅状况
            case R.id.rl_Residential:

                showTextSpinnerUtils.showSpinWindow(getActivity(),
                        R.array.zzzk_list,spinnerAdapter,spinnerPopWindow,zzzkSpinnerText);
                break;
            // 单位性质
            case R.id.rl_unitnature:

                showTextSpinnerUtils.showSpinWindow(getActivity(),
                        R.array.dwxz_list,spinnerAdapter,spinnerPopWindow,dwxzSpinnerText);
                break;
            // 职务类别
            case R.id.rl_Postnature:


                showTextSpinnerUtils.showSpinWindow(getActivity(),
                        R.array.zwlb_list,spinnerAdapter,spinnerPopWindow,zwlbSpinnerText);
                break;
            // 配偶证件类型
            case R.id.pozjlx_btn:

                showTextSpinnerUtils.showSpinWindow(getActivity(),
                        R.array.zjlx_list,spinnerAdapter,spinnerPopWindow,pozjlxSpinnerText);
                break;
            // 配偶单位性质
            case R.id.podwxz_btn:

                showTextSpinnerUtils.showSpinWindow(getActivity(),
                        R.array.dwxz_list,spinnerAdapter,spinnerPopWindow,podwxzSpinnerText);
                break;
            // 共同偿债人证件类型
            case R.id.gtczrzjlx_btn:

                showTextSpinnerUtils.showSpinWindow(getActivity(),
                        R.array.zjlx_list,spinnerAdapter,spinnerPopWindow,gtczrzjlxSpinnerText);
                break;
            // 共同偿债人单位性质
            case R.id.gtczrdwxz_btn:

                showTextSpinnerUtils.showSpinWindow(getActivity(),
                        R.array.dwxz_list,spinnerAdapter,spinnerPopWindow,gtczrdwxzSpinnerText);
                break;
            // 担保人证件类型R.id.dbrzjlx_btn
            case R.id.dbrzjlx_btn:

                showTextSpinnerUtils.showSpinWindow(getActivity(),
                        R.array.zjlx_list,spinnerAdapter,spinnerPopWindow,dbrzjlxSpinnerText);
                break;
            // 担保人单位性质
            case R.id.dbrdwxz_btn:

                showTextSpinnerUtils.showSpinWindow(getActivity(),
                        R.array.dwxz_list,spinnerAdapter,spinnerPopWindow,dbrdwxzSpinnerText);
                break;
            // 户口所在地
            case R.id.hkszd_sheng_btn:

                showTextSpinnerUtils.showSpinWindow(getActivity(),R.array.sheng_list,
                     spinnerAdapter,spinnerPopWindow,hkszdShengSpinnerText);

                break;
            case R.id.hkszd_shi_btn:

                showTextSpinnerUtils.showSpinWindow(getActivity(),
                        R.array.shi_list,spinnerAdapter,spinnerPopWindow,hkszdShiSpinnerText);
                break;
            // 现居住地
            case R.id.xjzd_sheng_btn:

                showTextSpinnerUtils.showSpinWindow(getActivity(),
                        R.array.sheng_list,spinnerAdapter,spinnerPopWindow,xjzdShengSpinnerText);
                break;
            case R.id.xjzd_shi_btn:

                showTextSpinnerUtils.showSpinWindow(getActivity(),
                        R.array.shi_list,spinnerAdapter,spinnerPopWindow,xjzdShiSpinnerText);
                break;
            // 申请人配偶的征信情况
            case R.id.rl_sqrpozx:

                showTextSpinnerUtils.showSpinWindow(getActivity(),
                        R.array.sqrzxzk_list,spinnerAdapter,spinnerPopWindow,sqrpozxzk_tv);
                break;
            // 申请人征信
            case R.id.rl_sqrzx:

                showTextSpinnerUtils.showSpinWindow(getActivity(),
                        R.array.sqrzxzk_list,spinnerAdapter,spinnerPopWindow,sqrzxzk_et);
                break;
            // 申请人学历
            case R.id.rl_sqrxl:

                showTextSpinnerUtils.showSpinWindow(getActivity(),
                        R.array.sqrxl_list,spinnerAdapter,spinnerPopWindow,sqrxl_tv);
                break;
            //获取身份信息
            case R.id.bt_hqsfxx:
                if(!TextUtils.isEmpty(zjhmEdittext.getText().toString().trim())&&!TextUtils.isEmpty(zwxmEdittext.getText().toString().trim())) {
                    if(zjhmEdittext.getText().toString().trim().length()<18){
                        ToastUtil.showShort(getActivity(),"请输入正确的身份证号码");
                        return;
                    }
                    ToastUtil.showShort(getActivity(),"正在获取身份信息");
                    //zjhmEdittext   zwxmEdittext
                    Map<String, String> map = new HashMap<String, String>();
                    map.put("cardNo",zjhmEdittext.getText().toString().trim());
                    map.put("realName",zwxmEdittext.getText().toString());
                    map.put("appkey","c9032bb83640b1625873e5b442dafb7c");
                    new NoHttpRequest(getActivity(), sp).Request(map, Constants.GETCARDINFO, null, NoCode.NOHTTP_WHAT_GETIDCARDINFO);
                }
                break;
            // rl_gcpp 购车品牌
            case R.id.rl_buyCarModel:

                showTextSpinnerUtils.showSpinWindow(getActivity(),
                        R.array.cx_list,spinnerAdapter,spinnerPopWindow,gcppEdittext);
                break;
            // 单位地址
            case R.id.dwdz_sheng_btn:

                showTextSpinnerUtils.showSpinWindow(getActivity(),
                        R.array.sheng_list,spinnerAdapter,spinnerPopWindow,dwdzShengSpinnerText);
                break;
            case R.id.dwdz_shi_btn:

                showTextSpinnerUtils.showSpinWindow(getActivity(),
                        R.array.shi_list,spinnerAdapter,spinnerPopWindow,dwdzShiSpinnerText);
                break;
            // 配偶单位地址
            case R.id.podwdz_sheng_btn:

                showTextSpinnerUtils.showSpinWindow(getActivity(),
                        R.array.sheng_list,spinnerAdapter,spinnerPopWindow,podwdzShengSpinnerText);
                break;
            case R.id.podwdz_shi_btn:

                showTextSpinnerUtils.showSpinWindow(getActivity(),
                        R.array.shi_list,spinnerAdapter,spinnerPopWindow,podwdzShiSpinnerText);
                break;
            // 共同偿债人单位地址
            case R.id.gtczrdwdz_sheng_btn:

                showTextSpinnerUtils.showSpinWindow(getActivity(),
                        R.array.sheng_list,spinnerAdapter,spinnerPopWindow,gtczrdwdzShengSpinnerText);
                break;
            case R.id.gtczrdwdz_shi_btn:

                showTextSpinnerUtils.showSpinWindow(getActivity(),
                        R.array.shi_list,spinnerAdapter,spinnerPopWindow,gtczrdwdzShiSpinnerText);
                break;
            // 担保人位地址
            case R.id.dbrdwdz_sheng_btn:
                selectedSpinnerText = dbrdwdzShengSpinnerText;
                showTextSpinnerUtils.showSpinWindow(getActivity(),
                        R.array.sheng_list,spinnerAdapter,spinnerPopWindow,dbrdwdzShengSpinnerText);
                break;
            case R.id.dbrdwdz_shi_btn:

                showTextSpinnerUtils.showSpinWindow(getActivity(),
                        R.array.shi_list,spinnerAdapter,spinnerPopWindow,dbrdwdzShiSpinnerText);
                break;
//            case R.id.rl_occpin:// 开发补充职业R.id.rl_reltship1
//                selectedSpinnerText = et_ocppin;
//                String[] zylist = getResources()
//                        .getStringArray(R.array.kksqzy_list);
//                showSpinWindow(zylist);
//                break;
            case R.id.rl_reltship1:// 开卡联系人一与开卡人关系R.id.rl_reltship2

                showTextSpinnerUtils.showSpinWindow(getActivity(),
                        R.array.lxr1ykkrgx_list,spinnerAdapter,spinnerPopWindow,et_kkryyzkrgx);
                break;
            case R.id.rl_reltship2:// 开卡联系人二与开卡人关系R.id.rl_primnat

                showTextSpinnerUtils.showSpinWindow(getActivity(),
                        R.array.lxr1ykkrgx_list,spinnerAdapter,spinnerPopWindow,et_kkreyzkrgx);
                break;
//            case R.id.rl_primnat:// 国籍
//                selectedSpinnerText = et_gj;
//                String[] gjlist = getResources().getStringArray(R.array.gj_list);
//                showSpinWindow(gjlist);
//                break;
//            case R.id.rl_islongterm:// 开卡联系人二与开卡人关系
//                selectedSpinnerText = et_sfcqyx;
//                String[] zjsfcqyx = getResources().getStringArray(
//                        R.array.zjsfyx_list);
//                showSpinWindow(zjsfcqyx);
//                break;
//            case R.id.rl_sqkpz:// 申请卡品种
//                selectedSpinnerText = et_sqkpz;
//                String[] sqkpz = getResources().getStringArray(
//                        R.array.sqkpz_list);
//                showSpinWindow(sqkpz);
//                break;
//            case R.id.rl_sqklb:// 申请卡类别
//                selectedSpinnerText = et_sqklb;
//                String[] sqklb = getResources().getStringArray(
//                        R.array.sqklb_list);
//                showSpinWindow(sqklb);
//                break;
//            case R.id.rl_kpjz:// 申请卡类别
//                selectedSpinnerText = et_kpjz;
//                String[] kpjz = getResources().getStringArray(
//                        R.array.kpjz_listsqklb_list);
//                showSpinWindow(kpjz);
//                break;
            case R.id.rl_cardbin:// 卡bin
                showTextSpinnerUtils.showSpinWindow(getActivity(),spinnerAdapter,spinnerPopWindow,et_cardbin,0);
//                selectedSpinnerText = et_cardbin;
//                spinnerList.clear();
//
//                for (int i = 0; i < GLobleData.cardbinmsglist.size(); i++) {
//                    CustemObject object = new CustemObject();
//                    object.data = GLobleData.cardbinmsglist.get(i).getCardbin();
//                    spinnerList.add(object);
//                }
//                spinnerAdapter.refreshData(spinnerList, 0);
//                spinnerPopWindow.setAdatper(spinnerAdapter);
//                spinnerPopWindow.setWidth(selectedSpinnerText.getWidth());
//                spinnerPopWindow.showAsDropDown(selectedSpinnerText);

                break;
            //视频通话资料录入
            case R.id.tv_spzl:
//                 Intent  Roomintent=new Intent(getActivity(), JoinRoomActivity.class);
//                 startActivity(Roomintent);
                break;
            //申请人身份证扫描
            case R.id.tv_sfsm:

                Intent sfsmIntent = new Intent(getActivity(), OcrActivity.class);
                sfsmIntent.putExtra("flag", 13);
                startActivityForResult(sfsmIntent, 13);
                break;
            //申请人配偶身份证扫描
            case R.id.tv_po_sfsm:

                Intent sfsmpoIntent = new Intent(getActivity(), OcrActivity.class);
                sfsmpoIntent.putExtra("flag", 14);
                startActivityForResult(sfsmpoIntent, 14);
                break;
            // ---------------------------------视频录制-----------------------------------

            case R.id.spzl_imageview:// 视频录制
                if (!(zwxmEdittext.getText().toString().trim().isEmpty())) {
                    Intent intentVideo = new Intent(getActivity(),
                            RecordVideoActivity.class);
                    intentVideo.putExtra("name", zwxmEdittext.getText().toString()
                            .trim());
                    startActivityForResult(intentVideo, 11);
                } else {

                    ToastUtil.showShort(getActivity(), "请填写姓名后再开始录制");
                }
                break;

            case R.id.spzl_textView:// 上传视频

                if (IsNetWorkAvailable.isOpenNetwork(getActivity())
                        && !(videosp.getString(zwxmEdittext.getText().toString(),
                        "").equals(""))) {


                    HttpUtils utils = new HttpUtils();
                    RequestParams params = new RequestParams();

                    params.addBodyParameter(
                            "files",
                            new File(videosp.getString(zwxmEdittext.getText()
                                    .toString(), "")));
                    // 采用Post的方式提交
                    utils.send(HttpMethod.POST, Constants.POSTVIDEO, params,
                            new RequestCallBack<String>() {

                                @Override
                                public void onFailure(HttpException arg0,
                                                      String arg1) {
                                    // TODO Auto-generated method stub
                                    System.out.println("failure.......:" + arg1);
                                }

                                @Override
                                public void onSuccess(ResponseInfo<String> arg0) {
                                    // TODO Auto-generated method stub
                                    System.out.println("success......:"
                                            + arg0.result);
                                    String video_url = arg0.result.replace("[", "")
                                            .replace("]", "");

                                    ToastUtil.showShort(getActivity(), "上传成功");
                                    // GLobleData.VideoPath = video_url;
                                    nameValuePairs.add(new BasicNameValuePair(
                                            "video_url", video_url));
                                    GLobleData.VideoPath = null;
                                    videoeditor.remove(zwxmEdittext.getText()
                                            .toString());
                                    videoeditor.commit();
                                    System.out.println("上传视频之后的："
                                            + nameValuePairs.toString());
                                    // 上传完成后删除录制的视频文件
                                    JsonUtils.deleteFile(new File(videosp
                                            .getString(zwxmEdittext.getText()
                                                    .toString(), "")));
                                }
                            });
                } else {

                    ToastUtil.showShort(getActivity(), "请先录制视频或是检查是否链接wify");
                }
                break;
            case R.id.playsp_textView:
                if (!(videosp.getString(zwxmEdittext.getText().toString(), "")
                        .equals(""))) {

                    Intent playintent = new Intent(getActivity(),
                            PlayerActivity.class);
                    playintent.putExtra("path", videosp.getString(zwxmEdittext
                            .getText().toString(), ""));
                    startActivity(playintent);
                } else {

                    ToastUtil.showShort(mActivity, "请先录制视频");
                }

                break;

            // ---------------------------------------添加照片--------------------------------
            // 身份资料
            case R.id.sfzzm_imageview:
                camera(1);
                break;
            case R.id.sfzzm_textView:

                makesurephoto(sfzzmList, msfzlList, sfzzmurl);
                break;
            // 地址详情
            case R.id.sfzfm_imageview:
                camera(2);
                break;
            case R.id.sfzfm_textView:

                makesurephoto(sfzfmList, mdzxxList, sfzfmurl);
                break;
            // 地图定位   ***2017、12、26修改为其他暂时保留地图定位功能
            case R.id.scsfz_imageview:

//                Intent intent = new Intent(mActivity, MyMapActivity.class);
//                startActivityForResult(intent, 3);保存的地图定位功能
                camera(3);

                break;

            case R.id.scsfz_textView:

                makesurephoto(scsfzmList, mdwList, scsfzurl);
                break;
            // 收入文件证明
            case R.id.ydcyhy_imageview:
                camera(4);
                break;
            case R.id.ydcyhy_textView:

                makesurephoto(ydcyhyList, msrzmlList, ydcyhymurl);
                break;
            // 购车发票文件
            case R.id.zzzm_imageView:
                camera(5);
                break;
            case R.id.zzzm_textView:

                makesurephoto(zzzmList, mgcfpList, zzzmurl);
                break;
            // 首付款证明文件
            case R.id.sqrxq_imageView:
                camera(6);
                break;
            case R.id.sqrxq_textView:

                makesurephoto(sqrxqList, msfkList, xqurl);
                break;
            // 车辆抵押证明文件
            case R.id.sqrszlh_imageView:
                camera(7);
                break;
            case R.id.sqrszlh_textView:

                makesurephoto(sqrszlhList, mcldyList, lhurl);
                break;
            // 车辆保险单文件
            case R.id.sqrszdy_imageView:
                camera(8);
                break;
            case R.id.sqrszdy_textView:
                makesurephoto(sqrszdyList, mclbxList, dyurl);
                break;
            // 购车合同文件
            case R.id.sqrszmph_imageView:
                camera(9);
                break;
            case R.id.sqrszmph_textView:

                makesurephoto(sqrszmphList, mgchtList, mphurl);
                break;
            // 征信报告文件
            case R.id.dw_imageView:
                camera(10);
                break;
            case R.id.dw_textView:
                makesurephoto(dwList, mzxbgList, dwurl);
                break;
            // -------------------------------------保存按钮------------------------------------------
            case R.id.submit_btn:// 此功能为将未来得及提交到服务器的资料缓存到本地

                // 缓存数据的方法
               CacheLocation();

                break;
            // 提交数据到服务器
            case R.id.btn_submit_save:
                ToastUtil.showShort(getActivity(), "开始检测网速。。。");
                new IsNetWorkAvailable().getNetSpeed(netHandler);

                break;

            case R.id.btn_submit_delete:
                DeleteCatchItem();
                break;
            default:
                break;
        }
    }

    /**
     * 删除本地缓存信息操作本地数据库
     */
    private void DeleteCatchItem() {
        if (data != null) {
            final RealmResults<RuHuData> userList = mRealm.where(RuHuData.class)
                    .equalTo("name", data.getName()).findAll();
            Realm.Transaction ts = new Realm.Transaction(){

                @Override
                public void execute(Realm realm) {
                    for(int i=0;i<userList.size();i++) {
                        userList.get(0).deleteFromRealm();

                    }
                }
            };

            mRealm.executeTransaction(ts);
            if(userList.isLoaded()){
                ToastUtil.showShort(getActivity(), "删除成功");
                data = null;
                clearAll();
                EventBus.getDefault().post(new EventT(true));
            }else{
                ToastUtil.showShort(getActivity(), "删除失败");
            }
        } else {
            ToastUtil.showShort(getActivity(), "还没有缓存数据，请先缓存数据");
        }
    }

    private boolean CacheLocation() {
        boolean issuccessful = false;
        getData();
        if ("".equals(zwxm)) {
            ToastUtil.showShort(getActivity(), "缓存失败");
            return false;
        }

        final RealmResults<RuHuData> userList = mRealm.where(RuHuData.class)
                .equalTo("name", zwxm).findAll();
        if(null != userList){
            mRealm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    for(int i=0;i<userList.size();i++) {
                        userList.get(i).deleteFromRealm();
                    }
                }
            });
        }
//		System.out.println(data.toString());
        issuccessful = cacheLocal();
        return issuccessful;
    }

    private void makesurephoto(ArrayList<String> takephotolist,
                               ArrayList<String> downloadlist, String dowmurl) {
        if (downloadlist != null && downloadlist.size() > 0) {

            if (takephotolist.size() > 0) {

                isempty(downloadlist, "", takephotolist.size());
            } else {
                isempty(downloadlist, "", 0);

            }
        } else {
            isempty(takephotolist, dowmurl, 0);
        }
    }

    /**
     * 将数据缓存到本地
     *
     * @return
     */
    boolean dataflag = false;
    private boolean cacheLocal() {



        data = new RuHuData();
        // gcpp;
        data.setGcpp(gcpp);
        // 购车原因 gcyy;
        data.setGcyy(gcyy);

        // 裸车价格lcjg;
        data.setLcjg(lcjg);

        // 还款途径 hktj;
        data.setHktj(hktj);

        // 进口车标志 jkcbz;

        data.setJkcbz(jkcbz);
        // 车型 cx;
        data.setCx(cx);
        // 排气量pql

        data.setPql(pql);
        // 中文姓名zwxm;

        data.setName(zwxm);
        // 性别xb;
        data.setSex(xb);
        // 出身年月csny;

        data.setBrithday(csny);
        // 证件类型zjlx
        data.setZjlx(zjlx);
        // 证件号码
        data.setZjhm(zjhm);
        // 婚姻状况;hyzk
        data.setHyzk(hyzk);
        // 共同s债人或者担保人gtczrordbr
        data.setDbrhgtczr(gtczrordbr);
        // 手机号码sjhm
        data.setTel(sjhm);

        // 户口所在地
        data.setHkszdSheng(hkszdsheng);
        data.setHkszdshi(hkszdshi);
        data.setHkszdxian(hkszdxian);
        data.setXiangxiaddress(hkszdxxdz);
        // 住宅状况
        data.setZzqk(zzzk);
        // 现居住地xjzdsheng;;xjzdxian;;

        data.setXjuxjzdsheng(xjzdsheng);

        data.setXjzdshi(xjzdshi);
        data.setXjzdxian(xjzdxian);
        data.setXjzdxxdz(xjzdxxdz);

        // 所住单位szdw;
        data.setSzdw(szdw);
        // 单位性质 dwxz;
        data.setDwxz(dwxz);
        // 单位电话
        data.setDwdh(dwdh);
        // 职务类别
        data.setZwlb(zwlb);

        // 月均收入yjsr;

        data.setYjsr(yjsr);
        // 单位地址
        data.setDwdzSheng(dwdzsheng);// 单位地址省
        data.setDwdzShi(dwdzshi);// 单位地址市
        data.setDwdzXian(dwdzxian);// 单位地址县
        data.setDwxianxiaddress(dwdzxxdz);// 单位所在地详细地址

        // 家庭已有贷款月还额度ac
        data.setJtyyyhkje(jtyydkyhed);
        // 申请人学历
        data.setSqrxl(sqrxl);
        data.setSqrzxqk(sqrzxzk);// 申请人征信状况sqrzxzk
        data.setSqrjthdb(sqrjtsrhkb); // 申请人家庭收入还贷比
        data.setSqrxl(sqrxl);// sqrxl;//申请人学历
        // sqrpozxzk;//申请人配偶征信情况
        data.setFqfkqs(fqfkqs);// fqfkqs分期付款期数
        data.setSyhkje(syhkje);// syhkje;首月还款金额
        data.setCs(cs);// cs;//成数
        data.setYhkje(yhkje);// yhkje;//月还款金额
        data.setFqfksxfl(fqfksxfl);// fqfksxfl;//分期付款手续费率
        data.setSxfje(sxfje);// sxfje;//手续费金额
        data.setXyzed(xyzed);// xyzed;//信用总额度
        data.setFqje(fqje);// fqje;//分期金额

        if ("1".equals(hyzk)) {
            data.setSqrpozxzk(sqrpozxzk);
            data.setDname(poxm);// 配偶姓名
            data.setTelnuber(posjhm);// 配偶手机号码
            data.setDzjlx(pozjlx);// 配偶证件类型
            data.setDzjhm(pozjhm);// 配偶证件号码
            data.setDcsny(pocsny);// 配偶出生年月
            data.setDszdw(poszdw);// 配偶所住单位
            data.setDdwxz(podwxz);// 配偶单位性质
            data.setDdwzw(podwzw);// 配偶单位职务
            data.setDdwdh(podwdh);// 配偶单位电话
            data.setDyjsr(poyjsr);// 配偶月均收入
            data.setDdwszSheng(podwdzsheng);// 配偶单位地址
            data.setDdwszShi(podwdzshi);
            data.setDdwszXian(podwdzxian);
            data.setDdwszdi(podwxxdz);
        } else {

            if ("共同偿债人".equals(gtczrordbr)) {

                data.setDname(gtczrxm);// 姓名
                data.setTelnuber(gtczrsjhm);// 手机号码
                data.setDzjlx(gtczrzjlx);// 证件类型
                data.setDzjhm(gtczrzjhm);// 证件号码
                data.setDcsny(gtczrcsny);// 出生年月
                data.setDszdw(gtczrszdw);// 所住单位
                data.setDdwxz(gtczrdwxz);// 单位性质
                data.setDdwzw(gtczrdwzw);// 单位职务
                data.setDdwdh(gtczrdwdh);// 单位电话
                data.setDdwszSheng(gtczrdwdzsheng);// 配偶单位地址
                data.setDdwszShi(gtczrdwdzshi);
                data.setDdwszXian(gtczrdwdzxian);
                data.setDdwszdi(gtczrdwxxdz);

            } else {

                System.out.println("担保人");
                data.setDname(dbrxm);// 姓名
                data.setTelnuber(dbrsjhm);// 手机号码
                data.setDzjlx(dbrzjlx);// 证件类型
                data.setDzjhm(dbrzjhm);// 证件号码
                data.setDcsny(dbrcsny);// 出生年月
                data.setDszdw(dbrszdw);// 所住单位
                data.setDdwxz(dbrszdw);// 单位性质
                data.setDdwzw(dbrdwzw);// 单位职务
                data.setDdwdh(dbrdwdh);// 单位电话
                data.setDdwszSheng(dbrdwdzsheng);// 配偶单位地址
                data.setDdwszShi(dbrdwdzshi);
                data.setDdwszXian(dbrdwdzxian);
                data.setDdwszdi(dbrdwxxdz);
            }
        }
        //开卡资料补充缓存
        data.setEmail(kkemail);
        data.setEngname(nameorEnglishname);//英文名或姓名拼音
        data.setJoindate(jrxdwgzsj);//进入现单位工作时间
        data.setDeptname(kkszbm);//坐在部门
        data.setCophonext(kkdwdhfj);//单位电话分机
        data.setHprovince(kkzzdzsf);//住宅地址省份
        data.setHcity(kkzzdzs);//住宅地址市
        data.setHcounty(kkzzdzx);//住宅地址县
        data.setHphonzono(kkzzdhqh);//住宅电话区号
        data.setCphozono(kkdwdhqh);//单位电话区号
        data.setCprovince(kkdwdzsf);//单位地址省份
        data.setCcity(kkdwdzs);//单位地址市
        data.setYearincome(kknsr);//年收入
        data.setCommazip(kkdwdzyb);//单位地址邮编
        data.setReltname1(lxryxm);//联系人一姓名
        data.setReltship1(lxryyzksqrgx);//联系人一与主卡申请人关系
        data.setRelaphone1(lxrylxdhh);//联系人一联系电话号
        data.setReltsex1(lxrysex);//联系人一性别
        data.setReltaddr1(kklxryzz);//联系人一住址
        data.setReltphzon1(kklxrylxdhqh);//联系人一住宅电话区号
        data.setReltname2(lxrename);//联系人二姓名
        data.setReltship2(lxreyzksqrgx);//联系人二与主卡申请人关系
        data.setReltsex2(lxresex);//联系人二性别
        data.setReltuname2(kklxregzdw);//联系人二工作单位
        data.setRtcophzn2(kklxrelxdhfj);//联系人 二联系电话区号
        data.setRtcophon2(kklxrelxdhh);//联系人二联系电话号
        data.setRtcophet2(kklxrelxdhfj);//联系人二联系电话分机
        data.setCardbin(cardbin);//cardbin
        if (null != bin) {
            data.setCardlogo(bin.getCardlogo() + "");//申请卡品种
            data.setCardtype(bin.getCardtype() + "");//神奇卡类别
            data.setCardmedm(bin.getCardmedm() + "");//卡片介质
            data.setSaleno(bin.getSaleno() + "");//产品编码
        }

        // 本地图片路径的缓存 sfzl;// 身份资料dzxq;// 地址详情 dw; // 定位srwjzm;// 收入文件证明gcfpwj;//
        // 购车发票文件
        // sfkzmwj;// 首付款证明文件cldyzmwj;// 车辆抵押证明文件clbxdwj;// 车辆保险单文件gchtwj;//
        // 购车合同文件 zxbgwj;// 征信报告文件

        if (sfzzmList.size() > 0) {
            if (sfzzmList.contains("0")) {
                sfzzmList.remove("0");
            }
            data.setSfzl(new Gson().toJson(sfzzmList));
        }
        if (sfzfmList.size() > 0) {
            if (sfzfmList.contains("1")) {
                sfzfmList.remove("1");
            }
            data.setDzxq(new Gson().toJson(sfzfmList));
        }
        if (scsfzmList.size() > 0) {
            if (scsfzmList.contains("2")) {
                scsfzmList.remove("2");
            }
            data.setDw(new Gson().toJson(scsfzmList));
        }
        if (ydcyhyList.size() > 0) {
            if (ydcyhyList.contains("3")) {
                ydcyhyList.remove("3");
            }
            data.setSrwjzm(new Gson().toJson(ydcyhyList));
        }
        if (zzzmList.size() > 0) {
            if (zzzmList.contains("4")) {
                zzzmList.remove("4");
            }
            data.setGcfpwj(new Gson().toJson(zzzmList));
        }
        // ----------------------------------------------------------------
        if (sqrxqList.size() > 0) {
            if (sqrxqList.contains("5")) {
                sqrxqList.remove("5");
            }
            data.setSfkzmwj(new Gson().toJson(sqrxqList));
        }
        if (sqrszlhList.size() > 0) {
            if (sqrszlhList.contains("6")) {
                sqrszlhList.remove("6");
            }

            data.setCldyzmwj(new Gson().toJson(sqrszlhList));
        }
        if (sqrszdyList.size() > 0) {
            if (sqrszdyList.contains("7")) {
                sqrszdyList.remove("7");
            }
            data.setClbxdwj(new Gson().toJson(sqrszdyList));
        }
        if (sqrszmphList.size() > 0) {
            if (sqrszmphList.contains("8")) {
                sqrszmphList.remove("8");
            }
            data.setGchtwj(new Gson().toJson(sqrszmphList));
        }
        if (dwList.size() > 0) {
            if (dwList.contains("9")) {
                dwList.remove("9");
            }
            data.setZxbgwj(new Gson().toJson(dwList));
        }
        //
        // data.setImgnumber(sfzzmList.size() + sfzfmList.size()
        // + scsfzmList.size() + ydcyhyList.size() + sqrxqList.size()
        // + sqrszlhList.size() + sqrszdyList.size() + sqrszmphList.size()
        // + dwList.size()+"");
        // ToastUtil.showShort(getActivity(), "您此次总共缓存了" + data.getImgnumber()
        // + "张照片");
        Editor edit = sp.edit();
        edit.putString(data.getName(), sfzzmList.size() + sfzfmList.size()
                + scsfzmList.size() + zzzmList.size() + ydcyhyList.size()
                + sqrxqList.size() + sqrszlhList.size() + sqrszdyList.size()
                + sqrszmphList.size() + dwList.size() + "");
        edit.putString(
                "dataurl",
                sfzzmList.toString() + sfzfmList.toString()
                        + scsfzmList.toString() + ydcyhyList.toString()
                        + zzzmList.toString() + sqrxqList.toString()
                        + sqrszlhList.toString() + sqrszdyList.toString()
                        + sqrszmphList.toString() + dwList.toString());
        edit.commit();

        RealmAsyncTask transaction = mRealm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealm(data);
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                //成功回调
                System.out.println("当前线程名称。。。。。。" + Thread.currentThread().getName());


                dataflag = true;
                ToastUtil.showShort(getActivity(), "缓存成功");
                clearAll();
                EventBus.getDefault().post(new EventT(true));

            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                //失败回调

                ToastUtil.showShort(getActivity(), "缓存失败");
            }
        });


        return false;

    }

    /**
     * 判断当前的是否有没有图片是否需要去查看当前存在的图片
     *
     * @param list
     * @param url
     */
    private void isempty(ArrayList<String> list, String url, int size) {

        if (!list.isEmpty() || url != null) {
            intent = new Intent(mActivity, ShowImagesActivity.class);
            intent.putStringArrayListExtra("list", list);
            intent.putExtra("url", url);
            intent.putExtra("size", size);
            startActivity(intent);
        } else {

            ToastUtil.showShort(mActivity, "您还没有添加照片");
        }
    }

    /**
     * 银行卡账单消费分析
     */

    private void requstYhkxffx() {

        System.out.println("----------------------" + yhkh);
        HttpUtils httpUtils = new HttpUtils();
        RequestParams params = new RequestParams();
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        nameValuePairs.add(new BasicNameValuePair("cardno", yhkh));
        params.setHeader("Cookie", "JSESSIONID=" + MyApplication.mySession());
        params.addBodyParameter(nameValuePairs);
        System.out.println("-------------" + Constants.YHKXFFXURL);
        httpUtils.send(HttpMethod.POST, Constants.YHKXFFXURL, params,
                new RequestCallBack<String>() {

                    @Override
                    public void onFailure(HttpException arg0, String arg1) {

                    }

                    @Override
                    public void onSuccess(ResponseInfo<String> Info) {

                        System.out.println("==============" + Info.result);
                        try {
                            JSONObject object = new JSONObject(Info.result);
                            String result = object.getString("result");
                            System.out.println("------------" + result);

                            mBankEntity msgEntity = new mBankEntity();
                            String string = object.getString("msg");
                            Gson gson = new Gson();
                            mBankEntity fromJson = gson.fromJson(string,
                                    mBankEntity.class);

                        } catch (JSONException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }

                    }

                });

    }

    /**
     * 征信请求接口
     */
    private void requestZx() {
        HttpUtils httpUtils = new HttpUtils();
        params = new RequestParams();
        params.setHeader("Cookie", "JSESSIONID=" + MyApplication.mySession());
        params.addBodyParameter("customerid", customerid);
        httpUtils.send(HttpMethod.POST, Constants.ZXURL, params,
                new RequestCallBack<String>() {

                    @Override
                    public void onFailure(HttpException arg0, String arg1) {

                    }

                    @Override
                    public void onSuccess(ResponseInfo<String> arg0) {

                        if (arg0.result != null) {

                            Gson gson = new Gson();
                            ZhengXinEntity fromJson = gson.fromJson(
                                    arg0.result, ZhengXinEntity.class);

                            List<ZhengXinEntity.Data> list = fromJson
                                    .getData();
                            if (list != null && list.size() != 0) {
                                for (int i = 0; i < list.size(); i++) {

                                    switch (Integer.parseInt(list.get(i)
                                            .getAtype())) {
                                        case 1:

                                            if (Integer.parseInt(list.get(i)
                                                    .getAstatus()) == 1) {

                                                iv_sm.setImageResource(R.drawable.tongguo);
                                                System.out
                                                        .println("============================"
                                                                + i);
                                            } else {

                                            }
                                            break;
                                        case 2:
                                            if (Integer.parseInt(list.get(i)
                                                    .getAstatus()) == 1) {

                                                iv_sr.setImageResource(R.drawable.tongguo);
                                                System.out
                                                        .println("============================"
                                                                + i);

                                            } else {

                                            }
                                            break;
                                        case 3:
                                            if (Integer.parseInt(list.get(i)
                                                    .getAstatus()) == 1) {

                                                iv_htrz.setImageResource(R.drawable.tongguo);
                                                System.out
                                                        .println("============================"
                                                                + i);

                                            } else {

                                            }
                                            break;

                                        case 4:
                                            if (Integer.parseInt(list.get(i)
                                                    .getAstatus()) == 1) {

                                                iv_yhkzd.setImageResource(R.drawable.tongguo);
                                                System.out
                                                        .println("============================"
                                                                + i);

                                            } else {

                                            }
                                            break;
                                        case 5:
                                            if (Integer.parseInt(list.get(i)
                                                    .getCustomerid()) == 1) {

                                                iv_hmd.setImageResource(R.drawable.tongguo);
                                                System.out
                                                        .println("============================"
                                                                + i);

                                            } else {

                                            }
                                            break;

                                        default:
                                            break;
                                    }

                                }
                            }

                        }

                        System.out.println("----------------" + arg0.result);
                    }
                });
    }

    private void submitData(String save) {

        showDialog(1);
        for (int i = 0; i < 100; i++) {

            progress = progressBar.getProgress();
            progress += i;
            progressBar.setProgress(progress);
        }
        if (first == 1) {

            addImagesPath();
            first++;
            System.out.println("----------addImagesPath-------------");
        } else {
            ;
            System.out.println("----------addnextImagesPath-------------");

            addnextImagesPath();
        }
        if (allImgList != null && allImgList.size() != 0) {
            // System.out.println(allImgList.toString() +
            // "........路径");

            len = 0;

            for (int i = 0; i < allImgList.size(); i++) {
                len = 100 / allImgList.size();

                // 上传所有图片
                //  upload(allImgList.get(i));
                netRequestCallBack.upload(allImgList.get(i),this);
            }

        } else {

            handler.sendEmptyMessage(0);
        }

    }

    private void addImagesPath() {
        if (sfzzmList != null && sfzzmList.size() != 0) {
            sfzzmList.add("0");
            allImgList.add(sfzzmList);
            System.out.println("==========" + sfzzmList);

        }
        if (sfzfmList != null && sfzfmList.size() != 0) {
            sfzfmList.add("1");
            allImgList.add(sfzfmList);
            System.out.println("==========" + sfzfmList);

        }
        if (scsfzmList != null && scsfzmList.size() != 0) {
            scsfzmList.add("2");
            System.out.println("==========" + scsfzmList);

            allImgList.add(scsfzmList);

        }
        if (ydcyhyList != null && ydcyhyList.size() != 0) {
            ydcyhyList.add("3");
            System.out.println("==========" + ydcyhyList);

            allImgList.add(ydcyhyList);

        }
        if (zzzmList != null && zzzmList.size() != 0) {
            zzzmList.add("4");
            System.out.println("==========" + zzzmList);

            allImgList.add(zzzmList);

        }
        if (sqrxqList != null && sqrxqList.size() != 0) {
            sqrxqList.add("5");
            System.out.println("==========" + sqrxqList);

            allImgList.add(sqrxqList);

        }
        if (sqrszlhList != null && sqrszlhList.size() != 0) {
            sqrszlhList.add("6");
            System.out.println("==========" + sqrszlhList);

            allImgList.add(sqrszlhList);

        }
        if (sqrszdyList != null && sqrszdyList.size() != 0) {
            sqrszdyList.add("7");
            System.out.println("==========" + sqrszdyList);

            allImgList.add(sqrszdyList);

        }
        if (sqrszmphList != null && sqrszmphList.size() != 0) {
            sqrszmphList.add("8");
            System.out.println("==========" + sqrszmphList);

            allImgList.add(sqrszmphList);

        }
        if (dwList != null && dwList.size() != 0) {

            dwList.add("9");
            System.out.println("==========" + dwList);

            allImgList.add(dwList);
        }
    }

    private void addnextImagesPath() {
        getsfzzmList = null;
        getsfzfmList = null;
        getscsfzmList = null;
        getydcyhyList = null;
        getzzzmList = null;
        getsqrxqList = null;
        getsqrszlhList = null;
        getsqrszdyList = null;
        getsqrszmphList = null;
        getdwList = null;
        allImgList.clear();
        mIndex = 0;
        if (sfzzmList != null && sfzzmList.size() != 0) {
            System.out.println("--------sfzfmList.size()---------" + sfzzmList);
            sfzzmList.remove(sfzzmList.size() - 1);
            sfzzmList.add("0");
            allImgList.add(sfzzmList);
            System.out.println("=====addnextImagesPath==sfzzmList==="
                    + sfzzmList);

        }
        if (sfzfmList != null && sfzfmList.size() != 0) {
            sfzfmList.remove(sfzfmList.size() - 1);

            sfzfmList.add("1");
            allImgList.add(sfzfmList);
            System.out.println("==========" + sfzfmList);

        }
        if (scsfzmList != null && scsfzmList.size() != 0) {
            scsfzmList.remove(scsfzmList.size() - 1);

            scsfzmList.add("2");
            System.out.println("==========" + scsfzmList);

            allImgList.add(scsfzmList);

        }
        if (ydcyhyList != null && ydcyhyList.size() != 0) {
            ydcyhyList.remove(ydcyhyList.size() - 1);

            ydcyhyList.add("3");
            System.out.println("==========" + ydcyhyList);

            allImgList.add(ydcyhyList);

        }
        if (zzzmList != null && zzzmList.size() != 0) {
            zzzmList.remove(zzzmList.size() - 1);

            zzzmList.add("4");
            System.out.println("==========" + zzzmList);

            allImgList.add(zzzmList);

        }
        if (sqrxqList != null && sqrxqList.size() != 0) {
            sqrxqList.remove(sqrxqList.size() - 1);

            sqrxqList.add("5");
            System.out.println("==========" + sqrxqList);

            allImgList.add(sqrxqList);

        }
        if (sqrszlhList != null && sqrszlhList.size() != 0) {
            sqrszlhList.remove(sqrszlhList.size() - 1);

            sqrszlhList.add("6");
            System.out.println("==========" + sqrszlhList);

            allImgList.add(sqrszlhList);

        }
        if (sqrszdyList != null && sqrszdyList.size() != 0) {
            sqrszdyList.remove(sqrszdyList.size() - 1);

            sqrszdyList.add("7");
            System.out.println("==========" + sqrszdyList);

            allImgList.add(sqrszdyList);

        }
        if (sqrszmphList != null && sqrszmphList.size() != 0) {
            sqrszmphList.remove(sqrszmphList.size() - 1);

            sqrszmphList.add("8");
            System.out.println("==========" + sqrszmphList);

            allImgList.add(sqrszmphList);

        }
        if (dwList != null && dwList.size() != 0) {
            dwList.remove(dwList.size() - 1);

            dwList.add("9");
            System.out.println("==========" + dwList);

            allImgList.add(dwList);
        }

        System.out.println("==========allImgList============" + allImgList);
    }

    /**
     * 调查问卷
     */
    @SuppressWarnings("deprecation")
    private void showDailogDCWJ() {
        View view = View.inflate(mActivity, R.layout.layout_dcwj, null);

        AlertDialog dialog = new AlertDialog.Builder(mActivity).create();
        dialog.setTitle("调查问卷");
        dialog.setView(view);
        dialog.setButton("确定", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface arg0, int arg1) {

                ToastUtil.showShort(mActivity, "确定");
            }
        });
        dialog.setButton2("取消", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface arg0, int arg1) {

                ToastUtil.showShort(mActivity, "取消");
            }
        });
        dialog.show();
        WindowManager m = mActivity.getWindowManager();
        Display d = m.getDefaultDisplay();

        dialog.getWindow().setLayout(d.getWidth(), d.getHeight());
    }

    /**
     * 清除所有图片路径的集合
     */





    /**
     * 获取返回图片进行添加水印
     */
    private void getBitmap() {

        // 名字为null
        path = Environment.getExternalStorageDirectory() + "/" + "dq" + "/"
                + picName;
        System.out.println("path==" + path);
        File file = new File(path);

        Uri uri = Uri.fromFile(file);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2;
        options.inJustDecodeBounds = false;
        try {
            bitmap = BitmapFactory.decodeStream(mActivity.getContentResolver()
                    .openInputStream(uri), null, options);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        if (null!= bitmap) {
            int width = bitmap.getWidth();
            int heiht = bitmap.getHeight();
            zteBitmap = Bitmap.createBitmap(width, heiht,
                    Bitmap.Config.ARGB_8888);

            Canvas canvas = new Canvas(zteBitmap);
            String familyName = "宋体";
            Typeface font = Typeface.create(familyName, Typeface.NORMAL);
            Paint textPaint = new Paint();
            textPaint.setColor(Color.BLACK);
            textPaint.setAlpha(60);
            textPaint.setTypeface(font);
            textPaint.setTextSize(25);
            Paint paint = new Paint();
            canvas.drawBitmap(bitmap, 0, 0, paint);
            SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
            year = df1.format(new Date());
            SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
            date = df.format(new Date());
            Path path1 = new Path();
            path1.rLineTo(1000, 100);
            Path path2 = new Path();
            path2.rLineTo(300, -200);

            if (!locationStr.equals("")) {
                canvas.drawTextOnPath("操作员:" + sp.getString("name", null),
                        path1, 100, 320, textPaint);
                canvas.drawTextOnPath(year + "   " + date, path1, 100, 380,
                        textPaint);
                canvas.drawTextOnPath(locationStr, path1, 100, 440, textPaint);

                textPaint.setColor(Color.WHITE);
                textPaint.setAlpha(60);
                textPaint.setTypeface(font);
                textPaint.setTextSize(25);
                canvas.drawTextOnPath("操作员:" + sp.getString("name", null),
                        path2, 100, 320, textPaint);
                canvas.drawTextOnPath(year + "   " + date, path2, 100, 380,
                        textPaint);
                canvas.drawTextOnPath(locationStr, path2, 100, 440, textPaint);

            } else {
                ToastUtil.showShort(mActivity, "暂无法获取地理位置");

                canvas.drawTextOnPath("操作员:" + sp.getString("name", null),
                        path1, 100, 320, textPaint);
                canvas.drawTextOnPath(year + "   " + date, path1, 100, 380,
                        textPaint);
                textPaint.setColor(Color.WHITE);
                textPaint.setAlpha(60);
                textPaint.setTypeface(font);
                textPaint.setTextSize(25);

                canvas.drawTextOnPath("操作员:" + sp.getString("name", null),
                        path1, 100, 320, textPaint);
                canvas.drawTextOnPath(year + "   " + date, path1, 100, 380,
                        textPaint);
            }
            zteBitmap = JudgeUtil.rotateBitmapByDegree(zteBitmap);
            FileOutputStream fout1 = null;
            try {
                fout1 = new FileOutputStream(file);
                // 设置未60表示压缩
                zteBitmap.compress(CompressFormat.JPEG, 60, fout1);

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                bitmap.recycle();
                try {
                    fout1.flush();
                    fout1.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        } else {

            ToastUtil.showShort(mActivity, "所选的照片不存在");
        }

    }

    // 此处需要注意：LocationClient类必须在主线程中声明。需要Context类型的参数。
    // Context需要时全进程有效的context,推荐用getApplicationConext获取全进程有效的context
    public LocationClient mLocationClient = null;
    public BDLocationListener myListener = new MyLocationListener();
    public List<NameValuePair> nameValuePairs;
    private RequestParams params;
    private String customerid;
    public List<NameValuePair> nameValuePairs1;

    /**
     * 获取地理经纬度
     */
    private void getWeiZhi() {
        mLocationClient = new LocationClient(getActivity()
                .getApplicationContext()); // 声明LocationClient类
        mLocationClient.registerLocationListener(myListener); // 注册监听函数
        initLocation();
        mLocationClient.start();
    }

    /**
     * 配置location参数
     */
    @SuppressWarnings("deprecation")
    private void initLocation() {
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationMode.Hight_Accuracy);// 可选，默认高精度，设置定位模式，高精度，低功耗，仅设备
        // option.setCoorType("gcj02");// 可选，默认gcj02，设置返回的定位结果坐标系
        option.setCoorType("bd09ll");// 返回百度经纬度坐标系 ：bd09ll
        // option.setCoorType("bd09");//返回百度墨卡托坐标系 ：bd09
        int span = 1000;
        option.setScanSpan(0);//
        // 可选，默认0，即仅定位一次，设置发起定位请求的间隔需要大于等于1000ms才是有效的
        option.setIsNeedAddress(true);// 可选，设置是否需要地址信息，默认不需要

        option.setAddrType("all");// 返回的定位结果包含地址信息,如果不填写all 容易返回"null"值
        option.setPriority(LocationClientOption.GpsFirst); // 设置GPS优先
        option.disableCache(false);// 禁止启用缓存定位

        option.setOpenGps(true);// 可选，默认false,设置是否使用gps
        option.setLocationNotify(true);// 可选，默认false，设置是否当gps有效时按照1S1次频率输出GPS结果
        option.setIsNeedLocationDescribe(true);// 可选，默认false，设置是否需要位置语义化结果，可以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近”
        option.setIsNeedLocationPoiList(true);// 可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到
        option.setIgnoreKillProcess(false);// 可选，默认true，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死
        option.SetIgnoreCacheException(false);// 可选，默认false，设置是否收集CRASH信息，默认收集
        option.setEnableSimulateGps(false);// 可选，默认false，设置是否需要过滤gps仿真结果，默认需要
        mLocationClient.setLocOption(option);
    }

    public double latitude;
    public double longitude;
    public int mIndex = 0;

    public String sfzzmurl;
    public String sfzfmurl;
    public String scsfzurl;
    public String ydcyhymurl;
    public String zzzmurl;
    public String xqurl;
    public String lhurl;
    public String dyurl;
    public String mphurl;
    public String dwurl;
    public String sqrpozxzk;// 申请人配偶征信情况
    public String sqrzxzk;// 申请人征信情况
    public String sqrxl;// 申请人学历
    public String sqrjtsrhkb; // 申请人家庭收入还贷比
    public String cs;// 成数
    public String fqfkqs;// 分期付款期数
    public String syhkje;// 首月还款金额
    public String yhkje;// 月还款金额
    public String fqfksxfl;// 分期付款手续费率
    public String sxfje;// 手续费金额
    public String xyzed;// 信用总额度
    public String fqje;// 分期金额

    class MyLocationListener implements BDLocationListener {

        @Override
        public void onReceiveLocation(final BDLocation location) {

            String city = location.getCity();
            String district = location.getDistrict();
            String street = location.getStreet();
            String locationDescribe = location.getLocationDescribe();
            System.out.println("city:" + city);
            System.out.println("district" + district);
            System.out.println("street:" + street);
            System.out.println("locationDescribe:" + locationDescribe);
            System.out.println("location:" + location.getLocType());

            latitude = location.getLatitude();
            longitude = location.getLongitude();
            locationStr = "" + longitude + "°E " + latitude + "°N";

            String str = GetDateUtil.getCurrentTime();

            DoDao.addMessage(new DsomeThings(GLobleData.logindata.getData()
                    .getJobnum(), "2", locationStr, str, ""));
            mLocationClient.stop();// 停止定位
            if (city == null || district == null || street == null
                    || locationDescribe == null) {// 说明获取地址信息失败,editext输入框不显示内容,并提示用户

                ToastUtil.showShort(mActivity, "获取地理位置信息失败,请检查网络");
            } else {

            }
        }


    }


    /**
     * 获取数据
     */

    private void getData() {

        // ---------------------------申请原因和申请人基本情况---------------------------------
        // 购车品牌
        gcpp = JudgeUtil.getResult(gcppEdittext.getText().toString().trim());
        // 购车原因
        gcyy = gcyyEdittext.getText().toString().trim();
        // 裸车价格
        lcjg = lcjgEdittext.getText().toString().trim();
        // 还款途径
        hktj = hktjSpinnerText.getText().toString().trim();
        // 进口车标志
        jkcbz = JudgeUtil.getResult(jkcbzSpinnerText.getText().toString()
                .trim());
        if (jkcbz.equals("是")) {
            jkcbz = "1";
        } else if (jkcbz.equals("否")) {
            jkcbz = "0";
        }
        // 车型
        cx = cxSpinnerText.getText().toString();
        // 排气量
        pql = JudgeUtil.getResult(pqlSpinnerText.getText().toString().trim());
        // 中文姓名
        zwxm = zwxmEdittext.getText().toString().trim();
        //
        if ("".equals(zwxm)) {

            ToastUtil.showShort(mActivity, "用户姓名能为空");
            return;
        }

        // 性别
        xb = xbSpinnerText.getText().toString().trim();

        if (xb.equals("男")) {
            xb = "1";
        } else if (xb.equals("女")) {
            xb = "2";
        }
        // 出身年月
        csny = csnyEdittext.getText().toString().trim();
        // 证件类型
        zjlx = zjlxSpinnerText.getText().toString().trim();

        if (zjlx.equals("身份证")) {
            zjlx = "身份证";
        } else if (zjlx.equals("护照")) {
            zjlx = "护照";
        } else if (zjlx.equals("军人证")) {
            zjlx = "军人证";
        } else if (zjlx.equals("残疾证")) {
            zjlx = "残疾证";
        }

        // 证件号码
        zjhm = zjhmEdittext.getText().toString().trim();

        // 婚姻状况
        hyzk = JudgeUtil.getResult(hyzkSpinnerText.getText().toString().trim());

        // （0：未婚1：已婚）
        if (hyzk.equals("已婚")) {
            hyzk = "1";
        } else if (hyzk.equals("未婚")) {
            hyzk = "2";
        } else if (hyzk.equals("离异")) {
            hyzk = "3";
        } else if (hyzk.equals("丧偶")) {
            hyzk = "4";
        }

        // 共同s债人或者担保人
        gtczrordbr = gtczrordbrSpinnerText.getText().toString().trim();
        // 手机号码
        sjhm = sjhmEdittext.getText().toString().trim();

        // 户口所在地
        hkszdsheng = JudgeUtil.getResult(hkszdShengSpinnerText.getText()
                .toString().trim());
        hkszdshi = JudgeUtil.getResult(hkszdShiSpinnerText.getText().toString()
                .trim());
        hkszdxxdz = JudgeUtil.getResult(hkszdXxdzEditText.getText().toString()
                .trim());
        hkszdxian = JudgeUtil.getResult(hkszdxianEditText.getText().toString()
                .trim());
        // 住宅状况
        zzzk = JudgeUtil.getResult(zzzkSpinnerText.getText().toString().trim());
        if (zzzk.equals("自有")) {
            zzzk = "1";
        } else if (zzzk.equals("贷款")) {
            zzzk = "2";
        } else if (zzzk.equals("租房")) {
            zzzk = "3";
        } else if (zzzk.equals("其它")) {
            zzzk = "4";
        }
        // 现居住地
        xjzdsheng = JudgeUtil.getResult(xjzdShengSpinnerText.getText()
                .toString().trim());
        xjzdshi = JudgeUtil.getResult(xjzdShiSpinnerText.getText().toString()
                .trim());
        xjzdxxdz = JudgeUtil.getResult(xjzdXxdzEditText.getText().toString()
                .trim());
        xjzdxian = JudgeUtil.getResult(xjzdxianEditText.getText().toString()
                .trim());

        // 所住单位
        szdw = szdwEditText.getText().toString().trim();

        // 单位性质
        dwxz = JudgeUtil.getResult(dwxzSpinnerText.getText().toString().trim());

        if (dwxz.equals("国家机关")) {
            dwxz = "1";
        } else if (dwxz.equals("国有企业")) {
            dwxz = "2";
        } else if (dwxz.equals("股份制企业")) {
            dwxz = "3";
        } else if (dwxz.equals("事业单位")) {
            dwxz = "4";
        } else if (dwxz.equals("集体企业")) {
            dwxz = "5";
        } else if (dwxz.equals("私营企业")) {
            dwxz = "6";
        } else if (dwxz.equals("外资企业")) {
            dwxz = "7";
        } else if (dwxz.equals("其它")) {
            dwxz = "8";
        }
        // 单位电话
        dwdh = dwdhEditText.getText().toString().trim();
        // 职务类别
        zwlb = JudgeUtil.getResult(zwlbSpinnerText.getText().toString().trim());
        // 月均收入
        yjsr = yjsrEditText.getText().toString().trim();
        // 单位地址
        dwdzsheng = JudgeUtil.getResult(dwdzShengSpinnerText.getText()
                .toString().trim());
        dwdzshi = JudgeUtil.getResult(dwdzShiSpinnerText.getText().toString()
                .trim());
        dwdzxxdz = dwdzxxdzEditText.getText().toString().trim();
        dwdzxian = dwdzxianEditText.getText().toString().trim();
        // 家庭已有贷款月还额度
        jtyydkyhed = jtyydkyhkeEditText.getText().toString().trim();

        // 银行卡号
        yhkh = yhkhEditText.getText().toString().trim();
        // 申请人配偶征信状况
        sqrpozxzk = JudgeUtil.getResult(sqrpozxzk_tv.getText().toString()
                .trim());
        // 申请人征信状况
        sqrzxzk = JudgeUtil.getResult(sqrzxzk_et.getText().toString().trim());
        // 申请人学历
        sqrxl = JudgeUtil.getResult(sqrxl_tv.getText().toString().trim());
        if (sqrxl.equals("初中或者以下")) {
            sqrxl = "1";
        } else if (sqrxl.equals("高中或中专")) {
            sqrxl = "2";
        } else if (sqrxl.equals("大专")) {
            sqrxl = "3";
        } else if (sqrxl.equals("大学本科")) {
            sqrxl = "4";
        } else if (sqrxl.equals("硕士研究生或以上")) {
            sqrxl = "5";
        }
        // 申请人家庭收入还款比
        sqrjtsrhkb = sqrjtsrhkb_et.getText().toString().trim();
        // 成数
        cs = cs_et.getText().toString().trim();
        // 分期付款期数
        fqfkqs = JudgeUtil.getResult(fqfkqs_et.getText().toString().trim());
        // 首月还款金额
        syhkje = syhkje_et.getText().toString().trim();
        // 月还款金额
        yhkje = yhkje_et.getText().toString().trim();
        // 分期付款手续费率
        fqfksxfl = fqfksxfl_et.getText().toString().trim();
        // 手续费金额
        sxfje = sxfje_text.getText().toString().trim();
        // 信用总额度
        xyzed = xinyongzongED_et.getText().toString().trim();
        // 分期金额 fenqiJE_edittext
        fqje = fqJE_et.getText().toString().trim();

        // ---------------------------------申请人配偶情况-------------------------------

        if (hyzk.equals("1")) {
            // 配偶姓名
            poxm = poxmEditText.getText().toString().trim();

            // 配偶出生年月
            pocsny = pocsnyEdittext.getText().toString().trim();
            // 配偶证件类型

            pozjlx = pozjlxSpinnerText.getText().toString().trim();
            if (pozjlx != null) {

                if (pozjlx.equals("身份证")) {
                    pozjlx = "1";
                } else if (pozjlx.equals("护照")) {
                    pozjlx = "2";
                } else if (pozjlx.equals("军人证")) {
                    pozjlx = "3";
                } else if (pozjlx.equals("残疾证")) {
                    pozjlx = "4";
                }
            }
            // 配偶证件号码
            pozjhm = pozjhmEditText.getText().toString().trim();

            // 配偶手机号码
            posjhm = posjhmEdittext.getText().toString().trim();

            // 配偶所住单位
            poszdw = poszdwEditText.getText().toString().trim();
            // 配偶单位性质
            podwxz = JudgeUtil.getResult(podwxzSpinnerText.getText().toString()
                    .trim());
            if (podwxz.equals("国家机关")) {
                podwxz = "1";
            } else if (podwxz.equals("国有企业")) {
                podwxz = "2";
            } else if (podwxz.equals("股份制企业")) {
                podwxz = "3";
            } else if (podwxz.equals("事业单位")) {
                podwxz = "4";
            } else if (podwxz.equals("集体企业")) {
                podwxz = "5";
            } else if (podwxz.equals("私营企业")) {
                podwxz = "6";
            } else if (podwxz.equals("外资企业")) {
                podwxz = "7";
            } else if (podwxz.equals("其它")) {
                podwxz = "8";
            }
            // 配偶单位职务
            podwzw = podwzwEditText.getText().toString().trim();
            poyjsr = poyjsrEditText.getText().toString().trim();
            // 配偶单位电话
            podwdh = podwdhEditText.getText().toString().trim();
            // 配偶单位地址
            podwdzsheng = JudgeUtil.getResult(podwdzShengSpinnerText.getText()
                    .toString().trim());
            podwdzshi = JudgeUtil.getResult(podwdzShiSpinnerText.getText()
                    .toString().trim());
            podwxxdz = podwxxdzEditText.getText().toString().trim();
            podwdzxian = podwdzxianEditText.getText().toString().trim();
        }

        // ---------------------------担保人-----------------------------------
        // 担保人姓名
        if (gtczrordbrSpinnerText.equals("担保人")) {
            dbrxm = dbrxmEditText.getText().toString().trim();

            // 担保人出生年月
            dbrcsny = dbrcsnyEdittext.getText().toString().trim();
            // 担保人证件类型
            dbrzjlx = dbrzjlxSpinnerText.getText().toString().trim();

            // 担保人证件号码
            dbrzjhm = dbrzjhmEditText.getText().toString().trim();

            // 担保人手机号码
            dbrsjhm = dbrsjhmEdittext.getText().toString().trim();

            // 担保人所住单位
            dbrszdw = dbrszdwEditText.getText().toString().trim();
            // 担保人单位性质
            dbrdwxz = JudgeUtil.getResult(dbrdwxzSpinnerText.getText()
                    .toString().trim());
            // 担保人单位职务
            dbrdwzw = JudgeUtil.getResult(dbrdwzwEditText.getText().toString()
                    .trim());
            // 担保人单位电话
            dbrdwdh = dbrdwdhEditText.getText().toString().trim();
            // 担保人单位地址
            dbrdwdzsheng = JudgeUtil.getResult(dbrdwdzShengSpinnerText
                    .getText().toString().trim());
            dbrdwdzshi = JudgeUtil.getResult(dbrdwdzShiSpinnerText.getText()
                    .toString().trim());
            dbrdwxxdz = dbrdwxxdzEditText.getText().toString().trim();
            dbrdwdzxian = dbrdwdzxianEditText.getText().toString().trim();
        }

        // -----------------------------共同偿债人------------------------------------
        // 共同偿债人姓名
        if (gtczrordbrSpinnerText.equals("共同偿债人")) {
            gtczrxm = gtczrxmEditText.getText().toString().trim();

            // 共同偿债人出生年月
            gtczrcsny = gtczrcsnyEdittext.getText().toString().trim();
            // 共同偿债人证件类型
            gtczrzjlx = gtczrzjlxSpinnerText.getText().toString().trim();

            // 共同偿债人证件号码
            gtczrzjhm = gtczrzjhmEditText.getText().toString().trim();

            // 共同偿债人手机号码
            gtczrsjhm = gtczrsjhmEdittext.getText().toString().trim();

            // 共同偿债人所住单位
            gtczrszdw = gtczrszdwEditText.getText().toString().trim();
            // 共同偿债人单位性质
            gtczrdwxz = JudgeUtil.getResult(gtczrdwxzSpinnerText.getText()
                    .toString().trim());
            // 共同偿债人单位职务
            gtczrdwzw = JudgeUtil.getResult(gtczrdwzwEditText.getText()
                    .toString().trim());
            // 共同偿债人单位电话
            gtczrdwdh = gtczrdwdhEditText.getText().toString().trim();
            // 共同偿债人单位地址
            gtczrdwdzsheng = JudgeUtil.getResult(gtczrdwdzShengSpinnerText
                    .getText().toString().trim());
            gtczrdwdzshi = JudgeUtil.getResult(gtczrdwdzShiSpinnerText
                    .getText().toString().trim());
            gtczrdwdzxian = gtczrdwdzxianEditText.getText().toString().trim();
            gtczrdwxxdz = gtczrdwxxdzEditText.getText().toString().trim();
        }

        // -------------------------------------开发资料补充---------------------------------

        // 姓名或英文名字
        nameorEnglishname = et_xmorEnclishName.getText().toString();
        // 进入现单位工作时间
        jrxdwgzsj = et_kkrjrdwgzsj.getText().toString();
//        // 住宅邮编
//        zzyb = et_kkrzzyp.getText().toString();
//        // 何时入住地址
//        hsruaddress = et_kkrhsrz.getText().toString();
        // 住宅电话号码
//        zzdhhm = et_kkrzzdh.getText().toString();

        // 单位邮编
//        dwyp = et_dwyp.getText().toString();
        // 职业
//        zy = JsonUtils.toResult(et_ocppin.getText().toString());

        // 国籍
//        gj = et_gj.getText().toString();
//        if ("中国".equals(gj)) {
//            gj = "156";
//        } else {
//            gj = "";
//        }
//        // 证件是否长期有效
//        zjsfcqyx = et_sfcqyx.getText().toString();
//        if ("是".equals(zjsfcqyx)) {
//            zjsfcqyx = "1";
//        } else if ("否".equals(zjsfcqyx)) {
//            zjsfcqyx = "0";
//        } else {
//            zjsfcqyx = "";
//        }
        //证件有效期
        kkzjyxq = zjyxq.getText().toString().trim();
        //电子邮箱
        kkemail = email.getText().toString().trim();
        //所在部门
        kkszbm = szbm.getText().toString().trim();
        //单位电话分机
        kkdwdhfj = dwdhfj.getText().toString().trim();
        //住宅地址省份
        kkzzdzsf = zzdzsf.getText().toString().trim();
        //住宅地址市
        kkzzdzs = zzdzs.getText().toString().trim();
        //住宅地址县
        kkzzdzx = zzdzx.getText().toString().trim();
        //住宅电话区号
        kkzzdhqh = zzdhqh.getText().toString().trim();
        //单位电话区号
        kkdwdhqh = dwdhqh.getText().toString().trim();
        //单位地址省份
        kkdwdzsf = dwdzsf.getText().toString().trim();
        //单位地址市
        kkdwdzs = dwdzs.getText().toString().trim();
        //单位地址邮编
        kkdwdzyb = dwdzyb.getText().toString().trim();
        //年收入
        kknsr = nsr.getText().toString().trim();
        // 联系人一姓名
        lxryxm = et_kkrlxrxm.getText().toString();
        // 联系人一与主卡申请人关系
        lxryyzksqrgx = JsonUtils.toResultGc(et_kkryyzkrgx.getText().toString());
        // 联系人一联系电话号
        lxrylxdhh = et_kkrlxr1lxhm.getText().toString();
        //联系人一性别
        lxrysex = lxryxb.getText().toString().trim();
        //联系人yi住址
        kklxryzz = lxryzz.getText().toString().trim();
        //联系人一联系电话区号
        kklxrylxdhqh = lxrylxdhqh.getText().toString().trim();
        // 联系人二姓名
        lxrename = et_kkrlxr2xm.getText().toString();
        // 联系人二与主卡申请人关系
        lxreyzksqrgx = JsonUtils.toResultGc(et_kkreyzkrgx.getText().toString());
        //联系人二性别
        lxresex = lxrexb.getText().toString().trim();
        //联系人二工作单位
        kklxregzdw = lxregzdw.getText().toString().trim();
        //联系人二联系电话区号
        kklxrelxdhqh = lxrelxdhqh.getText().toString().trim();
        //联系人二联系电话号
        kklxrelxdhh = lxrelxdhh.getText().toString().trim();
        //联系人二联系电话分机
        kklxrelxdhfj = lxrelxdhfj.getText().toString().trim();
        //卡bin
        cardbin = et_cardbin.getText().toString().trim();

    }

    /**
     * 向网络提交数据
     */
    int flag = 0;

    private void postData() {

        getData();
        HttpUtils httpUtils = new HttpUtils();
        params = new RequestParams();
        System.out.println("JSESSIONID=" + MYCOOKIES);
        params.setHeader("Cookie", "JSESSIONID=" + MYCOOKIES);

        addDataToParmars();// 将需要提交服务器的数据单独抽象成一个方法
        nameValuePairs.add(new BasicNameValuePair("type","1"));
        System.out.println(nameValuePairs);

        params.addBodyParameter(nameValuePairs);
        // httpUtils.configCurrentHttpCacheExpiry(1000 * 10); // 设置超时时间 10s
        // httpUtils.configTimeout(1000 * 10);// 设置连接超时时间
        // httpUtils.configSoTimeout(1000 * 10);// 设置连接超时时间
        httpUtils.send(HttpMethod.POST, Constants.POSTFIRSTLENDING, params,
                new RequestCallBack<String>() {
                    private String result;

                    @Override
                    public void onFailure(HttpException arg0, String mag) {
                        saveButton.setClickable(true);
                        if (data != null) {
                            ToastUtil.showShort(getActivity(), "data不为空");
                            CacheLocation();
                        }

                        ToastUtil.showShort(mActivity, "请检查您的网络是否可用");
                        arg0.printStackTrace();
                    }

                    @Override
                    public void onSuccess(ResponseInfo<String> resultInfo) {
                        result = resultInfo.result;
                        // ToastUtil.showShort(mActivity, result);
                        System.out.println("-----------" + resultInfo.result);

                        if (result.contains("result")) {
                            try {
                                JSONObject object = new JSONObject(result);
                                String result = object.getString("result");
                                if (result.equals("error")) {

                                    ToastUtil.showShort(mActivity, "上传数据失败");
                                    nameValuePairs = new ArrayList<NameValuePair>();
                                    // System.out
                                    // .println("getsfzzmList............."
                                    // + getsfzzmList);
                                    if (getsfzzmList != null) {
                                        nameValuePairs
                                                .add(new BasicNameValuePair(
                                                        "cert1_url",
                                                        getsfzzmList));
                                    }
                                    if (getsfzfmList != null) {

                                        nameValuePairs
                                                .add(new BasicNameValuePair(
                                                        "cert2_url",
                                                        getsfzfmList));
                                    }
                                    if (getscsfzmList != null) {
                                        nameValuePairs
                                                .add(new BasicNameValuePair(
                                                        "cert3_url",
                                                        getscsfzmList));
                                    }
                                    if (getydcyhyList != null) {
                                        nameValuePairs
                                                .add(new BasicNameValuePair(
                                                        "togather_url",
                                                        getydcyhyList));
                                    }
                                    if (getzzzmList != null) {
                                        nameValuePairs
                                                .add(new BasicNameValuePair(
                                                        "zzzm_url", getzzzmList));
                                    }
                                    if (getsqrxqList != null) {
                                        nameValuePairs
                                                .add(new BasicNameValuePair(
                                                        "xq_url", getsqrxqList));
                                    }
                                    if (getsqrszlhList != null) {
                                        nameValuePairs
                                                .add(new BasicNameValuePair(
                                                        "lh_url",
                                                        getsqrszlhList));
                                    }
                                    if (getsqrszdyList != null) {
                                        nameValuePairs
                                                .add(new BasicNameValuePair(
                                                        "dy_url",
                                                        getsqrszdyList));
                                    }
                                    if (getsqrszmphList != null) {
                                        nameValuePairs
                                                .add(new BasicNameValuePair(
                                                        "mph_url",
                                                        getsqrszmphList));
                                    }
                                    if (getdwList != null) {

                                        nameValuePairs
                                                .add(new BasicNameValuePair(
                                                        "dw_url", getdwList));
                                    }
                                    flag = 0;
                                } else if (result.equals("ok")) {

                                    if (stauta.equals("0")) {
                                        saveButton.setClickable(true);
                                        flag = 0;

                                        ToastUtil.showShort(mActivity,
                                                "保存数据成功，可进行修改");
                                        Intent intent = new Intent(mActivity,
                                                UploadSussessActivity.class);
                                        startActivity(intent);
                                        mActivity.finish();

                                    } else if (stauta.equals("1")) {
                                        flag = 0;
                                        ToastUtil.showShort(mActivity,
                                                "保存数据成功,并生成调研报告，不可进行修改");

                                        // if (data != null) {
                                        //
                                        // DataSupport.deleteAll(
                                        // RuHuData.class, "name=?",
                                        // data.getName());
                                        //
                                        // }
                                        Intent intent = new Intent(mActivity,
                                                UploadSussessActivity.class);
                                        startActivity(intent);
                                        mActivity.finish();

                                    }
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                });

    }

    private void addDataToParmars() {
        if (customerid == null) {
            if (GLobleData.visityetalrearyList != null) {
                for (VisitalrearyEntity it : GLobleData.visityetalrearyList) {

                    if (zwxmEdittext.getText().toString().equals(it.getName())) {
                        customerid = it.getCustomerid();
                    }

                }
            }
        }
        nameValuePairs.add(new BasicNameValuePair("equip", "4"));
        nameValuePairs.add(new BasicNameValuePair("customerid", customerid));
        System.out.println("---------customerid------------" + customerid);
        // ------------------------------申请原因-------------------------------------
        // 购车品牌
        nameValuePairs.add(new BasicNameValuePair("pp", gcpp));
        // 购车原因
        nameValuePairs.add(new BasicNameValuePair("reason", gcyy));
        // 购车价格
        nameValuePairs.add(new BasicNameValuePair("onlycar", lcjg));
        // 还款途径
        nameValuePairs.add(new BasicNameValuePair("hkly", hktj));
        // 进口车标志
        nameValuePairs.add(new BasicNameValuePair("isjk", jkcbz));
        // 车型
        nameValuePairs.add(new BasicNameValuePair("cartype", cx));
        // 排气量
        nameValuePairs.add(new BasicNameValuePair("pql", pql));

        // --------------------------申请人基本情况-------------------------------------
        // 姓名
        nameValuePairs.add(new BasicNameValuePair("name", zwxm));
        // 性别

        nameValuePairs.add(new BasicNameValuePair("sex", xb));
        // 出身年月
        nameValuePairs.add(new BasicNameValuePair("birthday", csny));

        // 证件类型
        nameValuePairs.add(new BasicNameValuePair("certtype", zjlx));

        // 证件号码
        nameValuePairs.add(new BasicNameValuePair("certnum", zjhm));
        // 婚姻状态

        nameValuePairs.add(new BasicNameValuePair("marry", hyzk));

        // 手机号码
        nameValuePairs.add(new BasicNameValuePair("phone", sjhm));

        // 申请人征信情况
        nameValuePairs.add(new BasicNameValuePair("credit", sqrzxzk));

        // 申请人学历
        nameValuePairs.add(new BasicNameValuePair("personedu", sqrxl));

        // 申请人家庭收入还贷比
        nameValuePairs.add(new BasicNameValuePair("personrepay", sqrjtsrhkb));
        if (ll_sxfstatus.getVisibility() == View.VISIBLE) {
            // 申请人家庭收入还贷比
            String str = !(sxfstatusEditText.getText().toString().equals("")) ? sxfstatusEditText.getText().toString() : "";
            nameValuePairs.add(new BasicNameValuePair("sxfstatus", str));
        }
        // 户口所在地省 市 县 详细

        nameValuePairs.add(new BasicNameValuePair("hkadd_sheng", hkszdsheng));
        nameValuePairs.add(new BasicNameValuePair("hkadd_shi", hkszdshi));
        nameValuePairs.add(new BasicNameValuePair("hkadd_xian", hkszdxian));
        nameValuePairs.add(new BasicNameValuePair("hkadd_detail", hkszdxxdz));

        // 住宅状况
        nameValuePairs.add(new BasicNameValuePair("zzzk", zzzk));
        // 现居住地详细省 市 县 详细
        nameValuePairs.add(new BasicNameValuePair("nowadd_sheng", xjzdsheng));
        nameValuePairs.add(new BasicNameValuePair("nowadd_shi", xjzdshi));
        nameValuePairs.add(new BasicNameValuePair("nowadd_xian", xjzdxian));
        nameValuePairs.add(new BasicNameValuePair("nowadd_detail", xjzdxxdz));
        // 所在单位
        nameValuePairs.add(new BasicNameValuePair("workname", szdw));

        // 单位性质
        nameValuePairs.add(new BasicNameValuePair("worktype", dwxz));
        // 单位电话
        nameValuePairs.add(new BasicNameValuePair("workphone", dwdh));

        // 职务类别
        nameValuePairs.add(new BasicNameValuePair("job", zwlb));
        // 月均收入
        nameValuePairs.add(new BasicNameValuePair("avgmoney", yjsr));
        // 单位详细地址 省 市 县 详细
        nameValuePairs.add(new BasicNameValuePair("workadd_sheng", dwdzsheng));
        nameValuePairs.add(new BasicNameValuePair("workadd_shi", dwdzshi));
        nameValuePairs.add(new BasicNameValuePair("workadd_xian", dwdzxian));
        nameValuePairs.add(new BasicNameValuePair("workadd_detail", dwdzxxdz));
        nameValuePairs.add(new BasicNameValuePair("yyhke", jtyydkyhed));
        System.out.println("-------------------" + hkszdsheng + hkszdshi
                + hkszdxian + hkszdxxdz);
        System.out.println("-------------------" + xjzdsheng + xjzdshi
                + xjzdxian + xjzdxxdz);
        System.out.println("-------------------" + dwdzsheng + dwdzshi
                + dwdzshi + dwdzxxdz);
        System.out.println("-------------" + yjsr + "----------" + jtyydkyhed);

        // -------------------------配偶信息----------------------------
        int visibility = sqrpoqkLayout.getVisibility();
        if (visibility == View.VISIBLE) {
            // 配偶姓名
            nameValuePairs.add(new BasicNameValuePair("mname", poxm));
            // 配偶出生年月
            nameValuePairs.add(new BasicNameValuePair("mbirth", pocsny));
            // 配偶证件类型
            nameValuePairs.add(new BasicNameValuePair("mcerttype", pozjlx));
            // 配偶证件号码
            nameValuePairs.add(new BasicNameValuePair("mcertnum", pozjhm));
            // 配偶手机号码
            nameValuePairs.add(new BasicNameValuePair("mphone", posjhm));
            // 配偶所在单位
            nameValuePairs.add(new BasicNameValuePair("mworkname", poszdw));
            // 配偶单位性质
            nameValuePairs.add(new BasicNameValuePair("mworktype", podwxz));
            // 配偶职务
            nameValuePairs.add(new BasicNameValuePair("mjob", podwzw));
            // 配偶月均收入
            nameValuePairs.add(new BasicNameValuePair("mavgmoney", poyjsr));
            // 配偶单位电话
            nameValuePairs.add(new BasicNameValuePair("mworkphone", podwdh));
            // 配偶单位地址 省 市 县 详细
            nameValuePairs.add(new BasicNameValuePair("mworkaddress_sheng",
                    podwdzsheng));
            nameValuePairs.add(new BasicNameValuePair("mworkaddress_shi",
                    podwdzshi));
            nameValuePairs.add(new BasicNameValuePair("mworkaddress_xian",
                    podwdzxian));

            nameValuePairs
                    .add(new BasicNameValuePair("mworkaddress", podwxxdz));
            nameValuePairs.add(new BasicNameValuePair("mcredit", sqrpozxzk));

            System.out.println("-------------" + poxm + pocsny + pozjlx
                    + pozjhm + posjhm + poszdw + podwxz + podwzw + podwdh
                    + podwdzsheng + podwdzshi + podwdzxian);
            System.out.println("-----------配偶信息");

            //

        } else if (gtczrLayout.getVisibility() == View.VISIBLE) {

        }

        // 申请额度
        nameValuePairs.add(new BasicNameValuePair("ed", fqje));
        // 分期付款手续费金额
        nameValuePairs.add(new BasicNameValuePair("suggestionfee1", sxfje));
        // 分期付款信用总额度
        nameValuePairs.add(new BasicNameValuePair("suggestionlimit1", xyzed));
        // 首月还款金额
        nameValuePairs.add(new BasicNameValuePair("suggestionmoney2", syhkje));
        // 成数
        nameValuePairs.add(new BasicNameValuePair("suggestionpercentage1", cs));
        // 月还款金额
        nameValuePairs.add(new BasicNameValuePair("suggestionpercentage2",
                yhkje));
        // 分期付款期数
        nameValuePairs
                .add(new BasicNameValuePair("suggestionperiods1", fqfkqs));
        // 分期手续费率
        nameValuePairs.add(new BasicNameValuePair("suggestionrate1", fqfksxfl));

        // 最后添加的是保存状态的值
        nameValuePairs.add(new BasicNameValuePair("save", stauta));

        // -------------------------开发资料补充----------------------------
        nameValuePairs
                .add(new BasicNameValuePair("engname", nameorEnglishname));
//        nameValuePairs.add(new BasicNameValuePair("homezip", zzyb));
//        nameValuePairs.add(new BasicNameValuePair("indate", hsruaddress));
//        nameValuePairs.add(new BasicNameValuePair("hphoneno", zzdhhm));
//        nameValuePairs.add(new BasicNameValuePair("corpzip", dwyp));
        nameValuePairs.add(new BasicNameValuePair("joindate", jrxdwgzsj));
//        nameValuePairs.add(new BasicNameValuePair("occptn", zy));
        nameValuePairs.add(new BasicNameValuePair("reltname1", lxryxm));
        nameValuePairs.add(new BasicNameValuePair("reltship1", lxryyzksqrgx));
        nameValuePairs.add(new BasicNameValuePair("relaphone1", lxrylxdhh));
        nameValuePairs.add(new BasicNameValuePair("reltname2", lxrename));
        nameValuePairs.add(new BasicNameValuePair("reltship2", lxreyzksqrgx));
//        nameValuePairs.add(new BasicNameValuePair("primnat", gj));
//        nameValuePairs.add(new BasicNameValuePair("islongterm", zjsfcqyx));
        nameValuePairs.add(new BasicNameValuePair("email", kkemail));//emial
        nameValuePairs.add(new BasicNameValuePair("deptname", kkszbm));//所在部门
        nameValuePairs.add(new BasicNameValuePair("cophonext", kkdwdhfj));//单位电话分机
        nameValuePairs.add(new BasicNameValuePair("hprovince", kkzzdzsf));//住宅地址省份
        nameValuePairs.add(new BasicNameValuePair("hcity", kkzzdzs));//住宅地址市
        nameValuePairs.add(new BasicNameValuePair("hcounty", kkzzdzx));//住宅地址县（区）
        nameValuePairs.add(new BasicNameValuePair("hphonzono", kkzzdhqh));//住宅电话区号
        nameValuePairs.add(new BasicNameValuePair("cphozono", kkdwdhqh));//单位电话区号
        nameValuePairs.add(new BasicNameValuePair("cprovince", kkdwdzsf));//单位地址省份
        nameValuePairs.add(new BasicNameValuePair("ccity", kkdwdzs));//单位地址市
        nameValuePairs.add(new BasicNameValuePair("yearincome", kknsr));//年收入
        nameValuePairs.add(new BasicNameValuePair("commazip", kkdwdzyb));//单位地址邮编

        nameValuePairs.add(new BasicNameValuePair("reltsex1", lxrysex));//联系人一性别
        nameValuePairs.add(new BasicNameValuePair("reltaddr1", kklxryzz));//联系人一住址
        nameValuePairs.add(new BasicNameValuePair("reltphzon1", kklxrylxdhqh));//联系人一住电话区号
        nameValuePairs.add(new BasicNameValuePair("reltsex2", lxresex));//联系人二性别
        nameValuePairs.add(new BasicNameValuePair("reltmobl1", lxrylxdhh));//联系人一电话
        nameValuePairs.add(new BasicNameValuePair("reltuname2", kklxregzdw));//联系人 二工作单位
        nameValuePairs.add(new BasicNameValuePair("rtcophzn2", kklxrelxdhfj));//联系人 二联系电话区号
        nameValuePairs.add(new BasicNameValuePair("rtcophon2", kklxrelxdhh));//联系人二联系电话号
        nameValuePairs.add(new BasicNameValuePair("rtcophet2", kklxrelxdhfj));//联系人二联系电话分机
        nameValuePairs.add(new BasicNameValuePair("reltmobl2", kklxrelxdhfj));//联系人二电话
        nameValuePairs.add(new BasicNameValuePair("statdate", kkzjyxq));//联系人二电话

        nameValuePairs.add(new BasicNameValuePair("cardbin", cardbin));//cardbin
        if (bin != null) {
            nameValuePairs.add(new BasicNameValuePair("cardlogo", bin.getCardlogo() + ""));//申请卡品种
            nameValuePairs.add(new BasicNameValuePair("cardtype", bin.getCardtype() + ""));//申请卡类别
            nameValuePairs.add(new BasicNameValuePair("cardmedm", bin.getCardmedm() + ""));//卡片介质
            nameValuePairs.add(new BasicNameValuePair("saleno", bin.getSaleno() + ""));//产品编码
        }


    }

    @Override
    public void onDestroy() {

        super.onDestroy();
        EventBus.getDefault().unregister(this);
        // 如果bitMap不为空 释放bitmap占用的内存
        if (null != bitmap) {
            bitmap.recycle();
        }
        if (zteBitmap != null) {
            zteBitmap.recycle();
        }
        if (alertDialog != null && alertDialog.isShowing()) {
            alertDialog.dismiss();
            alertDialog.cancel();

        }
        // CacheLocation();
    }

    CardBin bin;

    /**
     * eventbus运行在主线程
     *
     * @param event
     */
    public void onEventMainThread(MyEvent event) {

        // saveButton;

        if (event.getNoCode() == 0) {
            // btn_submit_save;
            // 未走访的数据
            VisityetEntity visityetEntity = event.getVisityetEntity();
            if (visityetEntity != null && event.getFlag1() == 1) {

                customerid = visityetEntity.getCustomerid();
                clearAll();

                sqrpoqkLayout.setVisibility(View.GONE);
//                setYetText(visityetEntity);
                ruhuFraSetMsgUtils.setYetText(visityetEntity);
            }

            // 已走访的数据
            VisitalrearyEntity visitalrearyEntity = event.getVisitalreadyEntity();
            if (visitalrearyEntity != null && event.getFlag1() == 2) {
                // System.out.println("Gone....." + View.GONE + "...."
                // + btn_submit_save.getVisibility());

                customerid = visitalrearyEntity.getCustomerid();
                System.out.println("----------visitalrearyEntity-----------"
                        + customerid + "...." + visitalrearyEntity.toString());
                clearAll();
                ruhuFraSetMsgUtils. setAlreadyText(visitalrearyEntity);

            }
            // 未发送数据
            data = event.getData();
            if (data != null && event.getFlag1() == 4) {

                ruhuFraSetMsgUtils.setWfsText(data);
            }
            // 初始化已完成
            VisitalrearyEntity myEntity = event
                    .getVisitalreadyEntity();
            ;
            if (myEntity != null && event.getFlag1() == 3) {
                // customerid = visitalrearyEntity.getCustomerid();
                clearAll();
//                setJRYYText(myEntity);
                ruhuFraSetMsgUtils.setJRYYText(myEntity);
            }
        } else if (event.getNoCode() == NoCode.NOHTTP_WHAT_GETCARDBINSMSG) {
            Gson gson = new Gson();
            bin = gson.fromJson(event.getResult(), CardBin.class);
            System.out.print(bin.toString());
//            et_sqkpz.setText(getResources().getStringArray(
//                        R.array.sqkpz_list)[bin.getCardlogo()]);
//            et_sqklb.setText(getResources().getStringArray(
//                        R.array.sqklb_list)[bin.getCardtype()]);
//            et_kpjz.setText(getResources().getStringArray(
//                        R.array.kpjz_list)[bin.getCardmedm()]);

        }else if(event.getNoCode()==NoCode.NOHTTP_WHAT_GETIDCARDINFO){

            try {
                JSONObject obj=new JSONObject(event.getResult());
                if(obj.getString("code").equals("10000")){

                    Gson gson=new Gson();
                    GetIdCardInfo info=gson.fromJson(event.getResult(),GetIdCardInfo.class);

                    System.out.println(info.getResult().getResult().getIdCardPhoto());
                    Bitmap bitmap = null;
                    try {
                        byte[] bitmapArray;
                        bitmapArray = Base64.decode(info.getResult().getResult().getIdCardPhoto(), Base64.DEFAULT);
                        bitmap = BitmapFactory.decodeByteArray(bitmapArray, 0,
                                bitmapArray.length);

                        String picName = new Date().getTime() + ".jpg";
                        String path = Environment.getExternalStorageDirectory() + "/" + "dq" + "/"
                                + picName;
                        File file=new File(path);
                        FileOutputStream fos=new FileOutputStream(file);
                        bitmap.compress(CompressFormat.JPEG,100,fos);
                        fos.flush();
                        fos.close();
                        sfzzmImageview.setImageBitmap(bitmap);
                        sfzzmList.add(path);
                        ToastUtil.showShort(getActivity(),"获取身份信息成功，身份证头像已显示到身份资料");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else if(obj.getString("code").equals("10004")){
                    ToastUtil.showShort(getActivity(),"获取身份信息失败请检查你输入的身份证号/姓名是否有误");
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }


        }
    }

    /**
     * 清空所有数据
     */
    public void clearAll() {
        gcppEdittext.setText("");
        gcyyEdittext.setText("");
        lcjgEdittext.setText("");
        hktjSpinnerText.setText("请选择");
        jkcbzSpinnerText.setText("请选择");
        cxSpinnerText.setText("请选择");
        pqlSpinnerText.setText("请选择");
        fqfkqs_et.setText("请选择");

        zwxmEdittext.setText("");
        sjhmEdittext.setText("");
        zjlxSpinnerText.setText("请选择");
        zjhmEdittext.setText("");
        xbSpinnerText.setText("");
        csnyEdittext.setText("");
        hyzkSpinnerText.setText("请选择");

        // gtczrordbrSpinnerText.setText("");

        hkszdShengSpinnerText.setText("请选择");
        hkszdShiSpinnerText.setText("请选择");
        hkszdxianEditText.setText("");
        hkszdXxdzEditText.setText("");
        zzzkSpinnerText.setText("请选择");
        xjzdShengSpinnerText.setText("请选择");
        xjzdShiSpinnerText.setText("请选择");
        xjzdxianEditText.setText("");
        xjzdXxdzEditText.setText("");

        szdwEditText.setText("");
        dwxzSpinnerText.setText("请选择");
        dwdhEditText.setText("");
        zwlbSpinnerText.setText("请选择");
        yjsrEditText.setText("");
        dwdzShengSpinnerText.setText("请选择");
        dwdzShiSpinnerText.setText("请选择");
        dwdzxianEditText.setText("");
        dwdzxxdzEditText.setText("");
        jtyydkyhkeEditText.setText("");

        // 申请人家庭收入还款比
        sqrjtsrhkb_et.setText("");
        // 成数
        cs_et.setText("");
        // 分期付款期数

        // 首月还款金额
        syhkje_et.setText("");
        // 月还款金额
        yhkje_et.setText("");
        // 分期付款手续费率
        fqfksxfl_et.setText("");
        // 手续费金额
        sxfje_text.setText("");
        // 信用总额度
        xinyongzongED_et.setText("");
        // 分期金额 fenqiJE_edittext
        fqJE_et.setText("");

        customerid = null;

        sfzzmImageview.setImageResource(R.drawable.add_picture_normal);
        sfzfmImageview.setImageResource(R.drawable.add_picture_normal);
        scsfzImageview.setImageResource(R.drawable.add_picture_normal);
        ydcyhyImageview.setImageResource(R.drawable.add_picture_normal);
        zzzmImageview.setImageResource(R.drawable.add_picture_normal);
        sqrxqImageview.setImageResource(R.drawable.add_picture_normal);
        sqrszlhImageview.setImageResource(R.drawable.add_picture_normal);
        sqrszdyImageview.setImageResource(R.drawable.add_picture_normal);
        sqrszmphImageview.setImageResource(R.drawable.add_picture_normal);
        dwImageview.setImageResource(R.drawable.add_picture_normal);
        sfzzmList = new ArrayList<String>();
        sfzfmList = new ArrayList<String>();
        scsfzmList = new ArrayList<String>();
        ydcyhyList = new ArrayList<String>();
        zzzmList = new ArrayList<String>();
        sqrxqList = new ArrayList<String>();
        sqrszlhList = new ArrayList<String>();
        sqrszdyList = new ArrayList<String>();
        sqrszmphList = new ArrayList<String>();
        dwList = new ArrayList<String>();
        allImgList = new ArrayList<List<String>>();

        if (badgeSfzzm == null) {
            badgeSfzzm = new BadgeView(getActivity(), sfzzmImageview);
            sfzzmImageview.setTag(badgeSfzzm);
        } else {
            badgeSfzzm = (BadgeView) sfzzmImageview.getTag();
        }

        if (badgesfzfm == null) {
            badgesfzfm = new BadgeView(getActivity(), sfzfmImageview);
            sfzfmImageview.setTag(badgesfzfm);
        } else {
            badgesfzfm = (BadgeView) sfzfmImageview.getTag();
        }

        if (badgescsfzm == null) {

            badgescsfzm = new BadgeView(getActivity(), scsfzImageview);
            scsfzImageview.setTag(badgescsfzm);

        } else {
            badgescsfzm = (BadgeView) scsfzImageview.getTag();
        }

        if (badgeydcyhy == null) {

            badgeydcyhy = new BadgeView(getActivity(), ydcyhyImageview);
            ydcyhyImageview.setTag(badgeydcyhy);
        } else {
            badgeydcyhy = (BadgeView) ydcyhyImageview.getTag();
        }

        if (badgezzzm == null) {

            badgezzzm = new BadgeView(getActivity(), zzzmImageview);
            zzzmImageview.setTag(badgezzzm);
        } else {

            badgezzzm = (BadgeView) zzzmImageview.getTag();
        }

        if (badgesqrxq == null) {

            badgesqrxq = new BadgeView(getActivity(), sqrxqImageview);
            sqrxqImageview.setTag(badgesqrxq);
        } else {

            badgesqrxq = (BadgeView) sqrxqImageview.getTag();
        }

        if (badgesqrszl == null) {

            badgesqrszl = new BadgeView(getActivity(), sqrszlhImageview);
            sqrszlhImageview.setTag(badgesqrszl);
        } else {

            badgesqrszl = (BadgeView) sqrszlhImageview.getTag();
        }

        if (badgesqrszdy == null) {

            badgesqrszdy = new BadgeView(getActivity(), sqrszdyImageview);
            sqrszdyImageview.setTag(badgesqrszdy);
        } else {

            badgesqrszdy = (BadgeView) sqrszdyImageview.getTag();
        }

        if (badgesqrszmph == null) {

            badgesqrszmph = new BadgeView(getActivity(), sqrszmphImageview);
            sqrszmphImageview.setTag(badgesqrszmph);
        } else {

            badgesqrszmph = (BadgeView) sqrszmphImageview.getTag();
        }

        if (badgedw == null) {

            badgedw = new BadgeView(getActivity(), dwImageview);
            dwImageview.setTag(badgedw);
        } else {

            badgedw = (BadgeView) dwImageview.getTag();
        }

        if (data != null) {
            data = null;
        }
        badgeSfzzm.hide();

        badgesfzfm.hide();
        badgedw.hide();
        badgeydcyhy.hide();
        badgezzzm.hide();
        badgesqrxq.hide();
        badgesqrszl.hide();
        badgesqrszdy.hide();
        badgesqrszmph.hide();
        badgescsfzm.hide();
    }

    public AlertDialog alertDialog;
    private int len;
    private int progress;

    private void showDialog(int i) {
        alertDialog = new AlertDialog.Builder(getActivity()).create();
        alertDialog.show();
        Window window = alertDialog.getWindow();
        if (1 == i) {

            window.setContentView(R.layout.dialog_main_info);
            progressBar = (ProgressBar) window
                    .findViewById(R.id.progrssbar_fragment);

        } else {
            window.setContentView(R.layout.dialog_info);
            Button btn_canlce = (Button) window.findViewById(R.id.frag_cancel);
            Button btn_go = (Button) window.findViewById(R.id.frag_go);
            btn_canlce.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(),
                            ResearchReportActivity.class);
                    startActivity(intent);

                }
            });
            btn_go.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    alertDialog.dismiss();
                }
            });
        }

    }

    @Override
    public void onResume() {

        super.onResume();
    }


    /**
     * frament 生命周期方法
     */
    @Override
    public void onDestroyView() {
        // TODO Auto-generated method stub
        super.onDestroyView();

    }

    /**
     * frament 生命周期方法
     */
    @Override
    public void onPause() {
        // TODO Auto-generated method stub
        super.onPause();

    }

    /**
     * frament 生命周期方法
     */
    @Override
    public void onStart() {
        // TODO Auto-generated method stub
        super.onStart();

    }

    /**
     * frament 生命周期方法
     */
    @Override
    public void onStop() {
        // TODO Auto-generated method stub
        super.onStop();

    }

    /**
     * 给照片显示的加一个长按监听
     */
    @OnLongClick({R.id.sfzzm_imageview, R.id.sfzfm_imageview,
            R.id.scsfz_imageview, R.id.ydcyhy_imageview, R.id.zzzm_imageView,
            R.id.sqrxq_imageView, R.id.sqrszlh_imageView,
            R.id.sqrszdy_imageView, R.id.sqrszmph_imageView, R.id.dw_imageView,
            R.id.spzl_imageview})
    public boolean onLongClick(View v) {

        System.out.println("zoule");
        switch (v.getId()) {
            // 身份资料
            case R.id.sfzzm_imageview:
                // initPopup(sfzlList, sfzzmList, v);
                ruhuphotonumber.initPopup(sfzlList, sfzzmList, v);
                break;
            // 地址详情
            case R.id.sfzfm_imageview:

//                initPopup(dzxqList, sfzfmList, v);
                ruhuphotonumber.initPopup(dzxqList, sfzfmList, v);

                break;
            // 地图定位
            case R.id.scsfz_imageview:
                // scsfzmList

                ruhuphotonumber.initPopup(dzdwList, scsfzmList, v);
                break;
            // 收入文件证明
            case R.id.ydcyhy_imageview:


                ruhuphotonumber.initPopup(srwjzmList, ydcyhyList, v);
                break;

            // 购车发票文件
            case R.id.zzzm_imageView:


                ruhuphotonumber.initPopup(gcfpwjzmList, zzzmList, v);
                break;

            // 首付款证明文件
            case R.id.sqrxq_imageView:


                ruhuphotonumber.initPopup(sfkwjzmList, sqrxqList, v);
                break;

            // 车辆抵押证明文件
            case R.id.sqrszlh_imageView:


                ruhuphotonumber.initPopup(cldiwjzmList, sqrszlhList, v);
                break;
            // 车辆保险单文件
            case R.id.sqrszdy_imageView:

                ruhuphotonumber.initPopup(clbxdwjList, sqrszdyList, v);
                break;

            // 购车合同文件
            case R.id.sqrszmph_imageView:


                ruhuphotonumber.initPopup(gchewjzmList, sqrszmphList, v);
                break;

            // 征信报告文件
            case R.id.dw_imageView:


                ruhuphotonumber.initPopup(zxbgwjzmList, dwList, v);
                break;
            // 视频信息 长按删除某个人的视频
            case R.id.spzl_imageview:
                if (videosp.getString(zwxmEdittext.getText().toString(), "")
                        .equals("")) {
                    ToastUtil.showShort(mActivity, "请先检查视频文件是否存在");
                } else {
                    File file = new File(videosp.getString(zwxmEdittext.getText()
                            .toString(), ""));
                    if (file.isFile())
                        ;
                    {
                        JsonUtils.deleteFile(file);
                        videoeditor.remove(zwxmEdittext.getText().toString());
                        videoeditor.commit();
                        ToastUtil.showShort(getActivity(), "删除成功");
                    }

                }

                break;

            default:
                break;
        }

        return true;

    }

    /**
     * 将所有的图片路径添加到mLsit当中
     */
    private ArrayList<String> addmList(List<String> networkList,
                                       ArrayList<String> localList) {

        if (localList != null && localList.size() > 0 && networkList != null
                && networkList.size() > 0) {

            mList = new ArrayList<String>();
            localListSize = localList.size();
            networkListSize = networkList.size();
            for (String path : localList) {
                mList.add(path);
            }
            for (String path : networkList) {
                mList.add(Constants.GETIMGURL + path);
            }
        }
        return mList;

    }

}
