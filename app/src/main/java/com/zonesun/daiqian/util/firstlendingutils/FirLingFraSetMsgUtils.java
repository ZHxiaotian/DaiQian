package com.zonesun.daiqian.util.firstlendingutils;

import android.view.View;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lidroid.xutils.BitmapUtils;
import com.zonesun.daiqian.entity.RuHuData;
import com.zonesun.daiqian.entity.RuHuSurveyEntity;
import com.zonesun.daiqian.fragment.FirstLendingFragment;
import com.zonesun.daiqian.fragment.RuhuSurveyFragment;
import com.zonesun.daiqian.util.JsonUtils;
import com.zonesun.daiqian.util.ToastUtil;

import java.util.List;

/**
 * Created by Administrator on 2018/1/17 0017.
 */

public class FirLingFraSetMsgUtils {
    FirstLendingFragment     fragment ;

    public FirLingFraSetMsgUtils(FirstLendingFragment fragment) {
        this.fragment = fragment;
    }

    // 入户调查界面已完成方法
    public void setJRYYText(RuHuSurveyEntity.VisitalrearyEntity myEntity) {
        System.out.println("setJRYYText...............走了");
        fragment. saveButton.setVisibility(View.GONE);
        fragment.btn_submit_save.setVisibility(View.GONE);
        System.out.println("--------------------" + myEntity);

        // 购车品牌
        fragment. gcppEdittext.setText(myEntity.getPp());

        // 购车原因
        fragment.gcyyEdittext.setText(myEntity.getReason());

        // 裸车价格
        fragment.lcjgEdittext.setText(myEntity.getOnlycar());
        // 还款途径
        fragment. hktjSpinnerText.setText(myEntity.getHkly());
        // 分期金额
        fragment.fqJE_et.setText(myEntity.getEd() + "");
        // 分期付款期数
        fragment. fqfkqs_et.setText(myEntity.getSuggestionperiods1() + "");
        // 信用总额度
        fragment. xinyongzongED_et.setText(myEntity.getSuggestionlimit1() + "");
        // 手续费金额
        fragment. sxfje_text.setText(myEntity.getSuggestionfee1() + "");
        // 成数
        fragment.cs_et.setText(myEntity.getSuggestionpercentage1() + "");
        // 申请人家庭还贷比
        fragment. sqrjtsrhkb_et.setText(myEntity.getPersonrepay() + "");
        // 首月还款金额
        fragment.syhkje_et.setText(myEntity.getSuggestionmoney2() + "");
        // 月还款金额
        fragment. yhkje_et.setText(myEntity.getSuggestionpercentage2() + "");
        // 分期付款手续费率
        fragment.fqfksxfl_et.setText(myEntity.getSuggestionrate1() + "");
        // 进口车标志
      String isjkc = myEntity.getIsjk();
        if (isjkc.equals("1")) {
            isjkc = "是";
        } else if (isjkc.equals("0")) {
            isjkc = "否";
        }
        // 进口车标志
        fragment. jkcbzSpinnerText.setText(isjkc);
        // 车型
        fragment.cxSpinnerText.setText(myEntity.getCartype());
        // 排气量
        fragment.pqlSpinnerText.setText(myEntity.getPql());

        // 中文姓名
        fragment. zwxmEdittext.setText(myEntity.getName());
        // 手机号码
        fragment.sjhmEdittext.setText(myEntity.getPhone());
        // 证件类型
        String zjtype = "";
        if (myEntity.getCerttype().equals("1")) {
            zjtype = "身份证";
        } else if (myEntity.getCerttype().equals("2")) {
            zjtype = "护照";
        } else if (myEntity.getCerttype().equals("3")) {
            zjtype = "军人证";
        } else if (myEntity.getCerttype().equals("4")) {
            zjtype = "残疾证";
        }
        fragment.zjlxSpinnerText.setText(zjtype);

        // 证件号码
        fragment.zjhmEdittext.setText(myEntity.getCertnum());

        if (myEntity.getMarry().equals("1")) {
            getpoData(myEntity);
            fragment. hyzk = "已婚";

        } else if (myEntity.getMarry().equals("2")) {
            fragment. hyzk = "未婚";
        } else if (myEntity.getMarry().equals("3")) {
            fragment. hyzk = "离异";
        } else if (myEntity.getMarry().equals("4")) {
            fragment. hyzk = "丧偶";

        }
        fragment. hyzkSpinnerText.setText(fragment.hyzk);

        // 户口所在省 市 县 详细信息
        fragment. hkszdShengSpinnerText.setText(myEntity.getHkadd_sheng());
        fragment. hkszdShiSpinnerText.setText(myEntity.getHkadd_shi());
        fragment. hkszdxianEditText.setText(myEntity.getHkadd_xian());
        fragment. hkszdXxdzEditText.setText(myEntity.getHkadd_detail());
        // 住宅状况
        fragment. zzzk = myEntity.getZzzk();

        if (fragment.zzzk.equals("1")) {
            fragment. zzzk = "自有";
        } else if (fragment.zzzk.equals("2")) {
            fragment.zzzk = "贷款";
        } else if (fragment.zzzk.equals("3")) {
            fragment.zzzk = "租房";
        } else if (fragment.zzzk.equals("4")) {
            fragment. zzzk = "其它";
        }
        fragment.zzzkSpinnerText.setText(fragment.zzzk);

        // 现居地
        fragment.xjzdShengSpinnerText.setText(myEntity.getNowadd_sheng());
        fragment. xjzdShiSpinnerText.setText(myEntity.getNowadd_shi());
        fragment. xjzdxianEditText.setText(myEntity.getNowadd_xian());
        fragment. xjzdXxdzEditText.setText(myEntity.getNowadd_detail());

        // 所住单位
        fragment. szdwEditText.setText(myEntity.getWorkname());
        // 单位性质
        fragment. dwxz = myEntity.getWorktype();
        if (fragment.dwxz.equals("1")) {
            fragment.dwxz = "国家机关";
        } else if (fragment.dwxz.equals("2")) {
            fragment.dwxz = "国有企业";
        } else if (fragment.dwxz.equals("3")) {
            fragment. dwxz = "股份制企业";
        } else if (fragment.dwxz.equals("4")) {
            fragment. dwxz = "事业单位";
        } else if (fragment.dwxz.equals("5")) {
            fragment.dwxz = "集体企业";
        } else if (fragment.dwxz.equals("6")) {
            fragment. dwxz = "私营企业";
        } else if (fragment.dwxz.equals("7")) {
            fragment.dwxz = "外资企业";
        } else if (fragment.dwxz.equals("8")) {
            fragment.dwxz = "其它";
        }

        fragment.dwxzSpinnerText.setText(fragment.dwxz);

        // 单位电话
        fragment.dwdhEditText.setText(myEntity.getWorkphone());

        // 职务
        fragment. zwlbSpinnerText.setText(myEntity.getJob());
        // 月均收入
        fragment. yjsrEditText.setText(myEntity.getAvgmoney());

        // 单位所在地 省 市 县 详细信息
        fragment. dwdzShengSpinnerText.setText(myEntity.getWorkadd_sheng());
        fragment. dwdzShiSpinnerText.setText(myEntity.getWorkadd_shi());
        fragment. dwdzxianEditText.setText(myEntity.getWorkadd_xian());
        fragment.  dwdzxxdzEditText.setText(myEntity.getWorkadd_detail());

        // 家庭已有月还款额
        fragment. jtyydkyhkeEditText.setText(myEntity.getYyhke());

        // 身份资料
        if (myEntity.getCert1_url().equals("")) {

        } else {
            fragment. sfzzmurl = myEntity.getCert1_url();
            fragment. ruhuphotonumber.showImages(fragment.sfzzmurl, fragment.sfzzmImageview, 1);
        }

        // 地址详情
        if (myEntity.getCert2_url().equals("")) {

        } else {
            fragment.sfzfmurl = myEntity.getCert2_url();
            fragment.ruhuphotonumber.showImages(fragment.sfzfmurl, fragment.sfzfmImageview, 2);
        }

        // 地址定位
        if (myEntity.getCert3_url().equals("")) {

        } else {
            fragment. scsfzurl = myEntity.getCert3_url();
            fragment.ruhuphotonumber. showImages(fragment.scsfzurl, fragment.scsfzImageview, 3);
        }
        // 收入文件证明
        if (myEntity.getTogather_url().equals("")) {

        } else {
            fragment.ydcyhymurl = myEntity.getTogather_url();
            fragment. ruhuphotonumber.showImages(fragment.ydcyhymurl,fragment. ydcyhyImageview, 4);
        }

        // 购车发票证明
        if (myEntity.getZzzm_url().equals("")) {

        } else {
            fragment. zzzmurl = myEntity.getZzzm_url();
            fragment.ruhuphotonumber. showImages(fragment.zzzmurl, fragment.zzzmImageview, 5);
        }

        // 首付款文件证明
        if (myEntity.getXq_url().equals("")) {

        } else {
            fragment. xqurl = myEntity.getXq_url();
            fragment. ruhuphotonumber.showImages(fragment.xqurl,fragment. sqrxqImageview, 6);
        }

        // 车辆抵押文件证明
        if (myEntity.getLh_url().equals("")) {

        } else {
            fragment.lhurl = myEntity.getLh_url();
            fragment.ruhuphotonumber.showImages(fragment.lhurl, fragment.sqrszlhImageview, 7);
        }

        // 车辆保险单文件
        if (myEntity.getDy_url().equals("")) {

        } else {
            fragment. dyurl = myEntity.getDy_url();
            fragment. ruhuphotonumber.showImages(fragment.dyurl, fragment.sqrszdyImageview, 8);
        }

        // 购车合同文件证明
        if (myEntity.getMph_url().equals("")) {

        } else {
            fragment. mphurl = myEntity.getMph_url();
            fragment.ruhuphotonumber.showImages(fragment.mphurl, fragment.sqrszmphImageview, 9);
        }

        // 征信报告文件证明
        if (myEntity.getDw_url().equals("")) {

        } else {
            fragment.dwurl = myEntity.getDw_url();
            fragment.ruhuphotonumber.showImages(fragment.dwurl, fragment.dwImageview, 10);
        }
        // ----------------------配偶信息------------------------------------

    }

    private void getpoData(RuHuSurveyEntity.VisitalrearyEntity myEntity) {
        // 配偶姓名
        fragment. poxmEditText.setText(myEntity.getMname());
        // 配偶手机电话
        fragment. posjhmEdittext.setText(myEntity.getMphone());
        // 配偶证件类型
        String pozjtype = "";
        if (myEntity.getMcerttype().equals("1")) {
            pozjtype = "身份证";
        } else if (myEntity.getCerttype().equals("2")) {
            pozjtype = "护照";
        } else if (myEntity.getCerttype().equals("3")) {
            pozjtype = "军人证";
        } else if (myEntity.getCerttype().equals("4")) {
            pozjtype = "残疾证";
        }
        fragment. pozjlxSpinnerText.setText(pozjtype);
        // 配偶证件号码
        fragment. pozjhmEditText.setText(myEntity.getMcertnum());
        // 配偶出生年月
        fragment. pocsnyEdittext.setText(myEntity.getMbirth());
        // 配偶所在单位
        fragment.poszdwEditText.setText(myEntity.getMworkname());

        fragment. podwxz = myEntity.getMworktype();
        if (fragment.podwxz.equals("1")) {
            fragment.podwxz = "国家机关";
        } else if (fragment.podwxz.equals("2")) {
            fragment.podwxz = "国有企业";
        } else if (fragment.podwxz.equals("3")) {
            fragment. podwxz = "股份制企业";
        } else if (fragment.podwxz.equals("4")) {
            fragment. podwxz = "事业单位";
        } else if (fragment.podwxz.equals("5")) {
            fragment.podwxz = "集体企业";
        } else if (fragment.podwxz.equals("6")) {
            fragment. podwxz = "私营企业";
        } else if (fragment.podwxz.equals("7")) {
            fragment. podwxz = "外资企业";
        } else if (fragment.podwxz.equals("8")) {
            fragment.podwxz = "其它";
        }

        fragment. podwxzSpinnerText.setText(fragment.podwxz);

        // 配偶单位职务
        fragment. podwzwEditText.setText(myEntity.getMjob());
        // 配偶单位电话
        fragment. podwdhEditText.setText(myEntity.getMworkphone());

        // 配偶单位地址
        fragment. podwxxdzEditText.setText(myEntity.getMworkaddress());

        // podwdzShengSpinnerText.setText(myEntity.get)

        // TextView podwdzShiSpinnerText;

        // EditText podwdzxianEditText;

        // EditText podwxxdzEditText;

    }


    /**
     * 初始化未走访数据
     */
    public void setYetText(RuHuSurveyEntity.VisityetEntity yetEntity) {
        System.out.println("-----------yetEntity-------------" + yetEntity);
        fragment. saveButton.setVisibility(View.VISIBLE);
        fragment. btn_submit_save.setVisibility(View.VISIBLE);
        // 购车品牌
        fragment.  gcppEdittext.setText(yetEntity.getPp());

        // 购车原因
        fragment.gcyyEdittext.setText(yetEntity.getReason());

        // 裸车价格
        fragment.  lcjgEdittext.setText(yetEntity.getOnlycar());
        // 还款途径
        fragment.hktjSpinnerText.setText(yetEntity.getHkly());

        String isjkc = yetEntity.getIsjk();
        if (isjkc.equals("1")) {
            isjkc = "是";
        } else if (isjkc.equals("0")) {
            isjkc = "否";
        }
        // 进口车标志
        fragment.jkcbzSpinnerText.setText(isjkc);
        // 车型
        fragment.cxSpinnerText.setText(yetEntity.getCartype());
        // 排气量
        fragment.pqlSpinnerText.setText(yetEntity.getPql());

        // 中文姓名
        fragment.zwxmEdittext.setText(yetEntity.getName());
        // 手机号码
        fragment.sjhmEdittext.setText(yetEntity.getPhone());
        // 证件类型
        String zjtype = "";
        if (yetEntity.getCerttype().equals("1")) {
            zjtype = "身份证";
        } else if (yetEntity.getCerttype().equals("2")) {
            zjtype = "护照";
        } else if (yetEntity.getCerttype().equals("3")) {
            zjtype = "军人证";
        } else if (yetEntity.getCerttype().equals("4")) {
            zjtype = "残疾证";
        }
        fragment. zjlxSpinnerText.setText(zjtype);

        // 证件号码
        fragment.zjhmEdittext.setText(yetEntity.getCertnum());

        // 婚姻状况
        String marry = "";
        if (yetEntity.getMarry().equals("1")) {
            marry = "已婚";
        } else if (yetEntity.getMarry().equals("2")) {
            marry = "未婚";
        } else if (yetEntity.getMarry().equals("3")) {
            marry = "离异";
        } else if (yetEntity.getMarry().equals("4")) {
            marry = "丧偶";
        }
        fragment. hyzkSpinnerText.setText(marry);

        // 户口所在省 市 县 详细信息
        fragment. hkszdShengSpinnerText.setText(yetEntity.getHkadd_sheng());
        fragment. hkszdShiSpinnerText.setText(yetEntity.getHkadd_shi());
        fragment. hkszdxianEditText.setText(yetEntity.getHkadd_xian());
        fragment.hkszdXxdzEditText.setText(yetEntity.getHkadd_detail());
        // 住宅状况
        fragment.zzzk = yetEntity.getZzzk();

        if (fragment.zzzk.equals("1")) {
            fragment. zzzk = "自有";
        } else if (fragment.zzzk.equals("2")) {
            fragment.zzzk = "贷款";
        } else if (fragment.zzzk.equals("3")) {
            fragment. zzzk = "租房";
        } else if (fragment.zzzk.equals("4")) {
            fragment. zzzk = "其它";
        }
        fragment.zzzkSpinnerText.setText(fragment.zzzk);

        // 现居地
        fragment. xjzdShengSpinnerText.setText(yetEntity.getNowadd_sheng());
        fragment.xjzdShiSpinnerText.setText(yetEntity.getNowadd_shi());
        fragment. xjzdxianEditText.setText(yetEntity.getNowadd_xian());
        fragment.xjzdXxdzEditText.setText(yetEntity.getNowadd_detail());

        // 所住单位
        fragment.szdwEditText.setText(yetEntity.getWorkname());
        // 单位性质
        fragment.dwxz = yetEntity.getWorktype();
        if (fragment.dwxz.equals("1")) {
            fragment. dwxz = "国家机关";
        } else if (fragment.dwxz.equals("2")) {
            fragment.  dwxz = "国有企业";
        } else if (fragment.dwxz.equals("3")) {
            fragment. dwxz = "股份制企业";
        } else if (fragment.dwxz.equals("4")) {
            fragment.dwxz = "事业单位";
        } else if (fragment.dwxz.equals("5")) {
            fragment. dwxz = "集体企业";
        } else if (fragment.dwxz.equals("6")) {
            fragment. dwxz = "私营企业";
        } else if (fragment.dwxz.equals("7")) {
            fragment. dwxz = "外资企业";
        } else if (fragment.dwxz.equals("8")) {
            fragment. dwxz = "其它";
        }

        fragment. dwxzSpinnerText.setText(fragment.dwxz);

        // 单位电话
        fragment.dwdhEditText.setText(yetEntity.getWorkphone());

        // 职务
        fragment.zwlbSpinnerText.setText(yetEntity.getJob());
        // 月均收入
        fragment.yjsrEditText.setText(yetEntity.getAvgmoney());

        // 单位所在地 省 市 县 详细信息
        fragment. dwdzShengSpinnerText.setText(yetEntity.getWorkadd_sheng());
        fragment.dwdzShiSpinnerText.setText(yetEntity.getWorkadd_shi());
        fragment.dwdzxianEditText.setText(yetEntity.getWorkadd_xian());
        fragment.dwdzxxdzEditText.setText(yetEntity.getWorkadd_detail());

        // 家庭已有月还款额
        fragment.jtyydkyhkeEditText.setText(yetEntity.getYyhke());

        // ----------------------配偶信息------------------------------------
        // 配偶姓名
        fragment. poxmEditText.setText(yetEntity.getMname());
        // 配偶手机电话
        fragment.posjhmEdittext.setText(yetEntity.getMphone());
        // 配偶证件类型
        String pozjtype = "";
        if (yetEntity.getMcerttype().equals("1")) {
            pozjtype = "身份证";
        } else if (yetEntity.getCerttype().equals("2")) {
            pozjtype = "护照";
        } else if (yetEntity.getCerttype().equals("3")) {
            pozjtype = "军人证";
        } else if (yetEntity.getCerttype().equals("4")) {
            pozjtype = "残疾证";
        }
        fragment.pozjlxSpinnerText.setText(pozjtype);
        // 配偶证件号码
        fragment.pozjhmEditText.setText(yetEntity.getMcertnum());
        // 配偶出生年月
        fragment.pocsnyEdittext.setText(yetEntity.getMbirth());
        // 配偶所在单位
        fragment. poszdwEditText.setText(yetEntity.getMworkname());

        fragment. podwxz = yetEntity.getMworktype();
        if (fragment.podwxz.equals("1")) {
            fragment. podwxz = "国家机关";
        } else if (fragment.podwxz.equals("2")) {
            fragment.podwxz = "国有企业";
        } else if (fragment.podwxz.equals("3")) {
            fragment. podwxz = "股份制企业";
        } else if (fragment.podwxz.equals("4")) {
            fragment. podwxz = "事业单位";
        } else if (fragment.podwxz.equals("5")) {
            fragment. podwxz = "集体企业";
        } else if (fragment.podwxz.equals("6")) {
            fragment.podwxz = "私营企业";
        } else if (fragment.podwxz.equals("7")) {
            fragment. podwxz = "外资企业";
        } else if (fragment.podwxz.equals("8")) {
            fragment.podwxz = "其它";
        }

        fragment.podwxzSpinnerText.setText(fragment.podwxz);

        // 配偶单位职务
        fragment.podwzwEditText.setText(yetEntity.getMjob());
        // 配偶单位电话
        fragment. podwdhEditText.setText(yetEntity.getMworkphone());

        // 配偶单位地址
        fragment. podwxxdzEditText.setText(yetEntity.getMworkaddress());
    }

    /**
     * 初始化已走访
     */
    public void setAlreadyText(RuHuSurveyEntity.VisitalrearyEntity visitalrearyEntity) {
        fragment. saveButton.setVisibility(View.VISIBLE);
        fragment. btn_submit_save.setVisibility(View.VISIBLE);
        // System.out.println("==============" + visitalrearyEntity);

        // 购车品牌
        fragment. gcppEdittext.setText(visitalrearyEntity.getPp());

        // 购车原因
        fragment. gcyyEdittext.setText(visitalrearyEntity.getReason());

        // 裸车价格
        fragment.lcjgEdittext.setText(visitalrearyEntity.getOnlycar());
        // 还款途径
        fragment.hktjSpinnerText.setText(visitalrearyEntity.getHkly());
        // 分期金额
        fragment. fqJE_et.setText(visitalrearyEntity.getEd() + "");
        // 分期付款期数
        fragment.fqfkqs_et.setText(visitalrearyEntity.getSuggestionperiods1() + "");
        // 信用总额度
        fragment. xinyongzongED_et.setText(visitalrearyEntity.getSuggestionlimit1() + "");
        // 手续费金额
        fragment.sxfje_text.setText(visitalrearyEntity.getSuggestionfee1() + "");
        // 成数
        fragment. cs_et.setText(visitalrearyEntity.getSuggestionpercentage1() + "");
        // 申请人家庭还贷比
        fragment.sqrjtsrhkb_et.setText(visitalrearyEntity.getPersonrepay() + "");
        // 首月还款金额
        fragment. syhkje_et.setText(visitalrearyEntity.getSuggestionmoney2() + "");
        // 月还款金额
        fragment. yhkje_et.setText(visitalrearyEntity.getSuggestionpercentage2() + "");
        // 分期付款手续费率
        fragment. fqfksxfl_et.setText(visitalrearyEntity.getSuggestionrate1() + "");

        String isjkc = visitalrearyEntity.getIsjk();
        if (isjkc.equals("1")) {
            isjkc = "是";
        } else if (isjkc.equals("0")) {
            isjkc = "否";
        }
        // 进口车标志
        fragment.jkcbzSpinnerText.setText(isjkc);
        // 车型
        fragment. cxSpinnerText.setText(visitalrearyEntity.getCartype());
        // 排气量
        fragment.pqlSpinnerText.setText(visitalrearyEntity.getPql());

        // 中文姓名
        fragment.zwxmEdittext.setText(visitalrearyEntity.getName());
        // 手机号码
        fragment. sjhmEdittext.setText(visitalrearyEntity.getPhone());
        // 证件类型
        String zjtype = null;
        if (visitalrearyEntity.getCerttype().equals("1")) {
            zjtype = "身份证";
        } else if (visitalrearyEntity.getCerttype().equals("2")) {
            zjtype = "护照";
        } else if (visitalrearyEntity.getCerttype().equals("3")) {
            zjtype = "军人证";
        } else if (visitalrearyEntity.getCerttype().equals("4")) {
            zjtype = "残疾证";
        }
        fragment.zjlxSpinnerText.setText(visitalrearyEntity.getCerttype());

        // 证件号码
        fragment. zjhmEdittext.setText(visitalrearyEntity.getCertnum());

        // 婚姻状况
        String marry = "";
        if (visitalrearyEntity.getMarry().equals("1")) {
            marry = "已婚";
            fragment.  sqrpoqkLayout.setVisibility(View.VISIBLE);
        } else if (visitalrearyEntity.getMarry().equals("2")) {
            marry = "未婚";
        } else if (visitalrearyEntity.getMarry().equals("3")) {
            marry = "离异";
        } else if (visitalrearyEntity.getMarry().equals("4")) {
            marry = "丧偶";
        }
        fragment. hyzkSpinnerText.setText(marry);

        // 户口所在省 市 县 详细信息
        fragment. hkszdShengSpinnerText.setText(visitalrearyEntity.getHkadd_sheng());
        fragment. hkszdShiSpinnerText.setText(visitalrearyEntity.getHkadd_shi());
        fragment. hkszdxianEditText.setText(visitalrearyEntity.getHkadd_xian());
        fragment. hkszdXxdzEditText.setText(visitalrearyEntity.getHkadd_detail());
        // 住宅状况
        fragment. zzzk = visitalrearyEntity.getZzzk();

        if (fragment.zzzk.equals("1")) {
            fragment. zzzk = "自有";
        } else if (fragment.zzzk.equals("2")) {
            fragment.zzzk = "贷款";
        } else if (fragment.zzzk.equals("3")) {
            fragment. zzzk = "租房";
        } else if (fragment.zzzk.equals("4")) {
            fragment. zzzk = "其它";
        }
        fragment. zzzkSpinnerText.setText(fragment.zzzk);

        // 现居地
        fragment. xjzdShengSpinnerText.setText(visitalrearyEntity.getNowadd_sheng());
        fragment. xjzdShiSpinnerText.setText(visitalrearyEntity.getNowadd_shi());
        fragment. xjzdxianEditText.setText(visitalrearyEntity.getNowadd_xian());
        fragment. xjzdXxdzEditText.setText(visitalrearyEntity.getNowadd_detail());

        // 所住单位
        fragment.szdwEditText.setText(visitalrearyEntity.getWorkname());
        // 单位性
        fragment. dwxz = visitalrearyEntity.getWorktype();
        if (fragment.dwxz.equals("1")) {
            fragment.dwxz = "国家机关";
        } else if (fragment.dwxz.equals("2")) {
            fragment.dwxz = "国有企业";
        } else if (fragment.dwxz.equals("3")) {
            fragment.dwxz = "股份制企业";
        } else if (fragment.dwxz.equals("4")) {
            fragment.dwxz = "事业单位";
        } else if (fragment.dwxz.equals("5")) {
            fragment. dwxz = "集体企业";
        } else if (fragment.dwxz.equals("6")) {
            fragment.dwxz = "私营企业";
        } else if (fragment.dwxz.equals("7")) {
            fragment.dwxz = "外资企业";
        } else if (fragment.dwxz.equals("8")) {
            fragment.dwxz = "其它";
        }

        fragment. dwxzSpinnerText.setText(fragment.dwxz);

        // 单位电话
        fragment.dwdhEditText.setText(visitalrearyEntity.getWorkphone());

        // 职务
        fragment. zwlbSpinnerText.setText(visitalrearyEntity.getJob());
        // 月均收入
        fragment. yjsrEditText.setText(visitalrearyEntity.getAvgmoney());

        // 单位所在地 省 市 县 详细信息
        fragment.dwdzShengSpinnerText.setText(visitalrearyEntity.getWorkadd_sheng());
        fragment.dwdzShiSpinnerText.setText(visitalrearyEntity.getWorkadd_shi());
        fragment.dwdzxianEditText.setText(visitalrearyEntity.getWorkadd_xian());
        fragment. dwdzxxdzEditText.setText(visitalrearyEntity.getWorkadd_detail());

        // 家庭已有月还款额
        fragment.jtyydkyhkeEditText.setText(visitalrearyEntity.getYyhke());
        // 申请人学历。。。
        fragment.sqrxl = visitalrearyEntity.getPersonedu();
        if (fragment.sqrxl.equals("1")) {
            fragment.sqrxl = "初中或者以下";
        } else if (fragment.sqrxl.equals("2")) {
            fragment.sqrxl = "高中或中专";
        } else if (fragment.sqrxl.equals("3")) {
            fragment. sqrxl = "大专";
        } else if (fragment.sqrxl.equals("4")) {
            fragment.sqrxl = "大学本科";
        } else if (fragment.sqrxl.equals("5")) {
            fragment. sqrxl = "硕士研究生或以上";
        }
        fragment. sqrxl_tv.setText(fragment.sqrxl);
        // 申请人征信状况
        fragment.sqrzxzk = visitalrearyEntity.getCredit();

        fragment.sqrzxzk_et.setText(fragment.sqrzxzk);

        if (fragment.sqrpoqkLayout.getVisibility() == View.VISIBLE) {
            // ----------------------配偶信息------------------------------------
            // 配偶姓名
            fragment.poxmEditText.setText(visitalrearyEntity.getMname());
            // 配偶手机电话
            fragment. posjhmEdittext.setText(visitalrearyEntity.getMphone());
            // 配偶证件类型
            String pozjtype = "";
            if (visitalrearyEntity.getMcerttype().equals("1")) {
                pozjtype = "身份证";
            } else if (visitalrearyEntity.getCerttype().equals("2")) {
                pozjtype = "护照";
            } else if (visitalrearyEntity.getCerttype().equals("3")) {
                pozjtype = "军人证";
            } else if (visitalrearyEntity.getCerttype().equals("4")) {
                pozjtype = "残疾证";
            }
            fragment.pozjlxSpinnerText.setText(pozjtype);
            // 配偶证件号码
            fragment.pozjhmEditText.setText(visitalrearyEntity.getMcertnum());
            fragment. // 配偶出生年月
            pocsnyEdittext.setText(visitalrearyEntity.getMbirth());
            // 配偶所在单位
            fragment. poszdwEditText.setText(visitalrearyEntity.getMworkname());

            fragment. podwxz = visitalrearyEntity.getMworktype();

            fragment.podwxzSpinnerText.setText(JsonUtils.Toemployer(fragment.podwxz));

            // 配偶单位职务
            fragment.  podwzwEditText.setText(visitalrearyEntity.getMjob());
            // 配偶月均收入
            fragment.poyjsrEditText.setText(visitalrearyEntity.getMavgmoney());
            // 配偶单位电话
            fragment.podwdhEditText.setText(visitalrearyEntity.getMworkphone());

            // 配偶单位地址
            fragment. podwxxdzEditText.setText(visitalrearyEntity.getMworkaddress());
            // 申请人配偶征信
            fragment. sqrpozxzk_tv.setText(visitalrearyEntity.getMcredit());
            // podwdzShengSpinnerText.setText(visitalrearyEntity.getMw);
            //
            // podwdzshi = JudgeUtil.getResult(podwdzShiSpinnerText.getText()
            // .toString().trim());
            // podwxxdz = podwxxdzEditText.getText().toString().trim();
            // podwdzxian

        }
        // 开卡信息补充的逻辑回放
        // 开卡人姓名或应为名
        fragment.et_xmorEnclishName.setText(visitalrearyEntity.getEngname());
        // 住宅邮编
//        et_kkrzzyp.setText(visitalrearyEntity.getHomezip());
//        // 何时入住现址
//        et_kkrhsrz.setText(visitalrearyEntity.getIndate());
        // 住宅电话号码
//        et_kkrzzdh.setText(visitalrearyEntity.getHphoneno());
        // 进入现单位工作时间
        fragment. et_kkrjrdwgzsj.setText(visitalrearyEntity.getJoindate());
        // 联系人一姓名
        fragment.et_kkrlxrxm.setText(visitalrearyEntity.getReltname1());
        // 联系人一联系电话号
        fragment. et_kkrlxr1lxhm.setText(visitalrearyEntity.getRelaphone1());
        // 联系人二姓名
        fragment.et_kkrlxr2xm.setText(visitalrearyEntity.getReltname2());
        // 职业
//        et_ocppin.setText(JsonUtils.toRquest(visitalrearyEntity.getOccptn()));
        // 开发补充联系人一与主卡申请人关系
        fragment. et_kkryyzkrgx.setText(JsonUtils.toRquestGc(visitalrearyEntity
                .getReltship1()));
        // 开发补充联系人二与主卡申请人关系
        fragment.et_kkreyzkrgx.setText(JsonUtils.toRquestGc(visitalrearyEntity
                .getReltship2()));
        //证件有效期
        fragment.zjyxq.setText(visitalrearyEntity.getStatdate());
        //电子邮箱
        fragment. email.setText(visitalrearyEntity.getEmail());
        //所在部门
        fragment. szbm.setText(visitalrearyEntity.getDeptname());
        //单位电话分机
        fragment.dwdhfj.setText(visitalrearyEntity.getCophonext());
        //住宅地址省份
        fragment. zzdzsf.setText(visitalrearyEntity.getHprovince());
        //住宅地址市
        fragment.zzdzs.setText(visitalrearyEntity.getHcity());
        //住宅地址县
        fragment. zzdzx.setText(visitalrearyEntity.getHcounty());
        //住宅电话号码
        fragment.  zzdhqh.setText(visitalrearyEntity.getHphonzono());
        //单位电话区号
        fragment.dwdhqh.setText(visitalrearyEntity.getCophonext());
        //单位地址省份
        fragment. dwdzsf.setText(visitalrearyEntity.getCprovince());
        //单位地址市
        fragment. dwdzs.setText(visitalrearyEntity.getCcity());
        //年收入邮编
        fragment. dwdzyb.setText(visitalrearyEntity.getCommazip());
        //联系人一性别
        fragment.lxryxb.setText(visitalrearyEntity.getReltsex1());
        //联系人一住址
        fragment. lxrexb.setText(visitalrearyEntity.getReltsex2());
        //联系人一电话区号
        fragment. lxrylxdhqh.setText(visitalrearyEntity.getReltphzon1());
        //联系人二性别
        fragment. lxrexb.setText(visitalrearyEntity.getReltsex2());
        //联系人二工作单位
        fragment. lxregzdw.setText(visitalrearyEntity.getReltuname2());
        //联系人二联系电话区号
        fragment.lxrelxdhqh.setText(visitalrearyEntity.getRtcophzn2());
        //联系人二联系电话号
        fragment. lxrelxdhh.setText(visitalrearyEntity.getRtcophon2());
        //联系人二联系电话分机
        fragment. lxrelxdhfj.setText(visitalrearyEntity.getRtcophet2());
        //cardbin
        fragment.et_cardbin.setText(visitalrearyEntity.getCardbin());


//        // 国籍
//        if ("156".equals(visitalrearyEntity.getPrimnat())) {
//            et_gj.setText("中国");
//        } else {
//            et_gj.setText("");
//        }

//        // 证件是否长期有效
//        if ("1".equals(visitalrearyEntity.getIslongterm())) {
//
//            et_sfcqyx.setText("是");
//        } else if ("0".equals(visitalrearyEntity.getIslongterm())) {
//            et_sfcqyx.setText("否");
//
//        }
        // 单位邮编
        // et_dwyp.setText(visitalrearyEntity.getCorpzip());

        // 身份资料
        if (visitalrearyEntity.getCert1_url().equals("")) {

        } else {
            fragment. sfzzmurl = visitalrearyEntity.getCert1_url();
            fragment. ruhuphotonumber.showImages(fragment.sfzzmurl, fragment.sfzzmImageview, 1);
        }

        // 地址详情
        if (visitalrearyEntity.getCert2_url().equals("")) {

        } else {
            fragment.  sfzfmurl = visitalrearyEntity.getCert2_url();
            fragment. ruhuphotonumber. showImages(fragment.sfzfmurl, fragment.sfzfmImageview, 2);
        }

        // 地址定位
        if (visitalrearyEntity.getCert3_url().equals("")) {

        } else {
            fragment. scsfzurl = visitalrearyEntity.getCert3_url();
            fragment.ruhuphotonumber.showImages(fragment.scsfzurl,fragment. scsfzImageview, 3);
        }
        // 收入文件证明
        if (visitalrearyEntity.getTogather_url().equals("")) {

        } else {
            fragment. ydcyhymurl = visitalrearyEntity.getTogather_url();
            fragment.ruhuphotonumber.showImages(fragment.ydcyhymurl, fragment.ydcyhyImageview, 4);
        }

        // 购车发票证明
        if (visitalrearyEntity.getZzzm_url().equals("")) {

        } else {
            fragment.  zzzmurl = visitalrearyEntity.getZzzm_url();
            fragment.ruhuphotonumber.showImages(fragment.zzzmurl, fragment.zzzmImageview, 5);
        }

        // 首付款文件证明
        if (visitalrearyEntity.getXq_url().equals("")) {

        } else {
            fragment. xqurl = visitalrearyEntity.getXq_url();
            fragment. ruhuphotonumber.showImages(fragment.xqurl, fragment.sqrxqImageview, 6);
        }

        // 车辆抵押文件证明
        if (visitalrearyEntity.getLh_url().equals("")) {

        } else {
            fragment.lhurl = visitalrearyEntity.getLh_url();
            fragment. ruhuphotonumber.showImages(fragment.lhurl, fragment.sqrszlhImageview, 7);
        }

        // 车辆保险单文件
        if (visitalrearyEntity.getDy_url().equals("")) {

        } else {
            fragment. dyurl = visitalrearyEntity.getDy_url();
            fragment. ruhuphotonumber.showImages(fragment.dyurl, fragment.sqrszdyImageview, 8);
        }

        // 购车合同文件证明
        if (visitalrearyEntity.getMph_url().equals("")) {

        } else {
            fragment.mphurl = visitalrearyEntity.getMph_url();
            // System.out.println("实验的...:"+mphurl);

            fragment. ruhuphotonumber.showImages(fragment.mphurl, fragment.sqrszmphImageview, 9);
        }

        // 征信报告文件证明
        if (visitalrearyEntity.getDw_url().equals("")) {

        } else {
            fragment.dwurl = visitalrearyEntity.getDw_url();
            fragment.ruhuphotonumber. showImages(fragment.dwurl, fragment.dwImageview, 10);
        }

    }


    /**
     * 未发送数据
     */
    public void setWfsText(RuHuData dat) {

        fragment.data = dat;
        fragment.saveButton.setVisibility(View.VISIBLE);
        fragment.btn_submit_save.setVisibility(View.VISIBLE);
        System.out.println( fragment.data.toString());
        ToastUtil.showShort( fragment.getActivity(),
                "此次缓存总共有了" +  fragment.sp.getString(fragment.data.getName(), "") + "张照片");

        // 购车品牌
        fragment.gcppEdittext.setText( fragment.data.getGcpp() + "");

        // 购车原因
        fragment.gcyyEdittext.setText( fragment.data.getGcyy() + "");

        // 裸车价格
        fragment.lcjgEdittext.setText( fragment.data.getLcjg() + "");
        // 还款途径
        fragment. hktjSpinnerText.setText( fragment.data.getHktj());
        // 进口车标志
        String isjkc =  fragment.data.getJkcbz();
        if (isjkc != null) {
            if (isjkc.equals("1")) {
                isjkc = "是";
            } else if (isjkc.equals("0")) {
                isjkc = "否";
            }
        }
        // 进口车标志
        fragment.jkcbzSpinnerText.setText(isjkc);
        // 车型
        fragment. cxSpinnerText.setText(  fragment.data.getCx() + "");
        // 排气量
        fragment. pqlSpinnerText.setText(  fragment.data.getPql() + "");

        // 中文姓名
        fragment.zwxmEdittext.setText( fragment.data.getName() + "");
        // 手机号码
        fragment.sjhmEdittext.setText(fragment.data.getTel() + "");
        // 证件类型
        fragment. zjlxSpinnerText.setText(fragment.data.getZjlx());

        // 证件号码
        fragment.zjhmEdittext.setText(fragment.data.getZjhm());
        fragment. hyzk = fragment.data.getHyzk();
        if (fragment.hyzk != null) {
            if (fragment.hyzk.equals("1")) {
                // getpoData(myEntity);
                fragment.hyzk = "已婚";

            } else if (fragment.hyzk.equals("2")) {
                fragment.hyzk = "未婚";

            } else if (fragment.hyzk.equals("3")) {
                fragment. hyzk = "离异";
            } else if (fragment.hyzk.equals("4")) {
                fragment.hyzk = "丧偶";

            }
        }
        fragment. hyzkSpinnerText.setText(fragment.hyzk);

        // 户口所在省 市 县 详细信息
        fragment. hkszdShengSpinnerText.setText(fragment.data.getHkszdSheng());
        fragment. hkszdShiSpinnerText.setText(fragment.data.getHkszdshi());
        fragment. hkszdxianEditText.setText(fragment.data.getHkszdxian());
        fragment. hkszdXxdzEditText.setText(fragment.data.getXiangxiaddress());
        // 住宅状况
        fragment.zzzk = fragment.data.getZzqk();
        if (fragment.zzzk != null) {
            if (fragment.zzzk.equals("1")) {
                fragment.zzzk = "自有";
            } else if (fragment.zzzk.equals("2")) {
                fragment. zzzk = "贷款";
            } else if (fragment.zzzk.equals("3")) {
                fragment. zzzk = "租房";
            } else if (fragment.zzzk.equals("4")) {
                fragment.zzzk = "其它";
            }
        }
        fragment.zzzkSpinnerText.setText(fragment.zzzk);

        // 现居地
        fragment.xjzdShengSpinnerText.setText(fragment.data.getXjuxjzdsheng());
        fragment.xjzdShiSpinnerText.setText(fragment.data.getXjzdshi());
        fragment.xjzdxianEditText.setText(fragment.data.getXjzdxian());
        fragment. xjzdXxdzEditText.setText(fragment.data.getXjzdxxdz());

        // 所住单位
        fragment.szdwEditText.setText(fragment.data.getSzdw() + "");
        // 单位性质
        fragment.dwxz = fragment.data.getDwxz();
        if (fragment.dwxz != null) {
            if (fragment.dwxz.equals("1")) {
                fragment.dwxz = "国家机关";
            } else if (fragment.dwxz.equals("2")) {
                fragment. dwxz = "国有企业";
            } else if (fragment.dwxz.equals("3")) {
                fragment. dwxz = "股份制企业";
            } else if (fragment.dwxz.equals("4")) {
                fragment. dwxz = "事业单位";
            } else if (fragment.dwxz.equals("5")) {
                fragment.dwxz = "集体企业";
            } else if (fragment.dwxz.equals("6")) {
                fragment. dwxz = "私营企业";
            } else if (fragment.dwxz.equals("7")) {
                fragment.dwxz = "外资企业";
            } else if (fragment.dwxz.equals("8")) {
                fragment. dwxz = "其它";
            }
        }
        fragment. dwxzSpinnerText.setText(fragment.dwxz);

        // 单位电话
        fragment.dwdhEditText.setText(fragment.data.getDwdh());

        // 职务
        fragment. zwlbSpinnerText.setText(fragment.data.getZwlb());
        // 月均收入
        fragment. yjsrEditText.setText(fragment.data.getYjsr());

        // 单位所在地 省 市 县 详细信息
        fragment.dwdzShengSpinnerText.setText(fragment.data.getDwdzSheng());
        fragment. dwdzShiSpinnerText.setText(fragment.data.getDwdzShi());
        fragment.dwdzxianEditText.setText(fragment.data.getDwdzXian());
        fragment. dwdzxxdzEditText.setText(fragment.data.getDwxianxiaddress());

        // 分期金额
        fragment.fqJE_et.setText(fragment.data.getFqje() + "");
        // 分期付款期数
        fragment.  fqfkqs_et.setText(fragment.data.getFqfkqs() + "");
        // 信用总额度
        fragment.xinyongzongED_et.setText(fragment.data.getXyzed() + "");
        // 手续费金额
        fragment. sxfje_text.setText(fragment.data.getSxfje() + "");
        // 成数
        fragment.cs_et.setText(fragment.data.getCs() + "");
        // 申请人家庭还贷比
        fragment.sqrjtsrhkb_et.setText(fragment.data.getSqrjthdb() + "");
        // 首月还款金额
        fragment. syhkje_et.setText(fragment.data.getSyhkje() + "");
        // 月还款金额
        fragment.yhkje_et.setText(fragment.data.getYhkje() + "");
        // 分期付款手续费率
        fragment. fqfksxfl_et.setText(fragment.data.getFqfksxfl() + "");

        // 家庭已有月还款额
        fragment.jtyydkyhkeEditText.setText(fragment.data.getJtyyyhkje() + "");
        // 申请人学历。。。
        fragment.sqrxl = fragment.data.getSqrxl();
        if (null != fragment.sqrxl) {
            if (fragment.sqrxl.equals("1")) {
                fragment. sqrxl = "初中或者以下";
            } else if (fragment.sqrxl.equals("2")) {
                fragment.sqrxl = "高中或中专";
            } else if (fragment.sqrxl.equals("3")) {
                fragment.sqrxl = "大专";
            } else if (fragment.sqrxl.equals("4")) {
                fragment.sqrxl = "大学本科";
            } else if (fragment.sqrxl.equals("5")) {
                fragment.sqrxl = "硕士研究生或以上";
            }
        }
        fragment.sqrxl_tv.setText(fragment.sqrxl + "");
        // 申请人征信状况

        fragment.sqrzxzk_et.setText(fragment.data.getSqrzxqk());

        // ----------------------配偶信息------------------------------------
        if (fragment.hyzk.equals("已婚")) {
            // 配偶姓名
            fragment.poxmEditText.setText(fragment.data.getDname());
            // 配偶手机电话
            fragment. posjhmEdittext.setText(fragment.data.getTelnuber());
            // 配偶证件类型
            String pozjtype = fragment.data.getDzjlx();
            if (null != pozjtype) {
                if (pozjtype.equals("1")) {
                    pozjtype = "身份证";
                } else if (pozjtype.equals("2")) {
                    pozjtype = "护照";
                } else if (pozjtype.equals("3")) {
                    pozjtype = "军人证";
                } else if (pozjtype.equals("4")) {
                    pozjtype = "残疾证";
                }
            }
            fragment.pozjlxSpinnerText.setText(pozjtype);
            // 配偶证件号码
            fragment. pozjhmEditText.setText(fragment.data.getDzjhm());
            // 配偶出生年月
            fragment.pocsnyEdittext.setText(fragment.data.getDcsny());
            // 配偶所在单位
            fragment. poszdwEditText.setText(fragment.data.getDszdw());

            fragment. podwxz = fragment.data.getDdwxz();
            if (null != fragment.podwxz) {
                if (fragment.podwxz.equals("1")) {
                    fragment.podwxz = "国家机关";
                } else if (fragment.podwxz.equals("2")) {
                    fragment. podwxz = "国有企业";
                } else if (fragment.podwxz.equals("3")) {
                    fragment. podwxz = "股份制企业";
                } else if (fragment.podwxz.equals("4")) {
                    fragment.podwxz = "事业单位";
                } else if (fragment.podwxz.equals("5")) {
                    fragment. podwxz = "集体企业";
                } else if (fragment.podwxz.equals("6")) {
                    fragment.podwxz = "私营企业";
                } else if (fragment.podwxz.equals("7")) {
                    fragment.podwxz = "外资企业";
                } else if (fragment.podwxz.equals("8")) {
                    fragment. podwxz = "其它";
                }
                fragment.podwxzSpinnerText.setText(fragment.podwxz);
            }

            // 配偶单位职务
            fragment.podwzwEditText.setText(fragment.data.getDdwzw());
            // 配偶单位电话
            fragment. podwdhEditText.setText(fragment.data.getDdwdh());
            // 配偶月均收入
            fragment.poyjsrEditText.setText(fragment.data.getDyjsr());

            // 配偶单位地址
            fragment. podwxxdzEditText.setText(fragment.data.getDdwszdi());
            // 配偶征信状况
            // 申请人配偶征信
            fragment. sqrpozxzk_tv.setText(fragment.data.getSqrpozxzk());
            // 配偶单位地址省
            // 配偶单位地址市
            // 配偶单位地址县

        }
        //开卡资料申请
        fragment.et_xmorEnclishName.setText(fragment.data.getEngname());
        // 住宅邮编
//        et_kkrzzyp.setText(visitalrearyEntity.getHomezip());
//        // 何时入住现址
//        et_kkrhsrz.setText(visitalrearyEntity.getIndate());
        // 住宅电话号码
//        et_kkrzzdh.setText(visitalrearyEntity.getHphoneno());
        // 进入现单位工作时间
        fragment.et_kkrjrdwgzsj.setText(fragment.data.getJoindate());
        // 联系人一姓名
        fragment. et_kkrlxrxm.setText(fragment.data.getReltname1());
        // 联系人一联系电话号
        fragment.et_kkrlxr1lxhm.setText(fragment.data.getRelaphone1());
        // 联系人二姓名
        fragment.et_kkrlxr2xm.setText(fragment.data.getReltname2());
        // 职业
//        et_ocppin.setText(JsonUtils.toRquest(visitalrearyEntity.getOccptn()));
        // 开发补充联系人一与主卡申请人关系
        fragment. et_kkryyzkrgx.setText(JsonUtils.toRquestGc(fragment.data
                .getReltship1()));
        // 开发补充联系人二与主卡申请人关系
        fragment.et_kkreyzkrgx.setText(JsonUtils.toRquestGc(fragment.data
                .getReltship2()));
        //证件有效期
        fragment.zjyxq.setText(fragment.data.getStatdate());
        //电子邮箱
        fragment.email.setText(fragment.data.getEmail());
        //所在部门
        fragment. szbm.setText(fragment.data.getDeptname());
        //单位电话分机
        fragment.dwdhfj.setText(fragment.data.getCophonext());
        //住宅地址省份
        fragment.zzdzsf.setText(fragment.data.getHprovince());
        //住宅地址市
        fragment. zzdzs.setText(fragment.data.getHcity());
        //住宅地址县
        fragment. zzdzx.setText(fragment.data.getHcounty());
        //住宅电话号码
        fragment.zzdhqh.setText(fragment.data.getHphonzono());
        //单位电话区号
        fragment.dwdhqh.setText(fragment.data.getCophonext());
        //单位地址省份
        fragment. dwdzsf.setText(fragment.data.getCprovince());
        //单位地址市
        fragment.dwdzs.setText(fragment.data.getCcity());
        //年收入邮编
        fragment. dwdzyb.setText(fragment.data.getCommazip());
        //联系人一性别
        fragment.lxryxb.setText(fragment.data.getReltsex1());
        //联系人一住址
        fragment.lxrexb.setText(fragment.data.getReltsex2());
        //联系人一电话区号
        fragment. lxrylxdhqh.setText(fragment.data.getReltphzon1());
        //联系人二性别
        fragment.lxrexb.setText(fragment.data.getReltsex2());
        //联系人二工作单位
        fragment. lxregzdw.setText(fragment.data.getReltuname2());
        //联系人二联系电话区号
        fragment.lxrelxdhqh.setText(fragment.data.getRtcophzn2());
        //联系人二联系电话号
        fragment. lxrelxdhh.setText(fragment.data.getRtcophon2());
        //联系人二联系电话分机
        fragment. lxrelxdhfj.setText(fragment.data.getRtcophet2());
        //cardbin
        fragment.et_cardbin.setText(fragment.data.getCardbin());


        BitmapUtils utils = new BitmapUtils(fragment.getActivity());
        // 身份资料
        if (null != fragment.data.getSfzl()) {
            System.out.println(fragment.data.getSfzl());
            fragment.sfzzmList = new Gson().fromJson(fragment.data.getSfzl(),
                    new TypeToken<List<String>>() {
                    }.getType());
            // sfzzmImageview
            utils.display(fragment.sfzzmImageview, fragment.sfzzmList.get(0));
            fragment. ruhuphotonumber. showImageTwo(fragment.sfzzmList, fragment.sfzzmImageview, 1);
        } else {

        }
        // 地址详情
        if (fragment.data.getDzxq() != null) {

            fragment.sfzfmList = new Gson().fromJson(fragment.data.getDzxq(),
                    new TypeToken<List<String>>() {
                    }.getType());
            utils.display(fragment.sfzfmImageview, fragment.sfzfmList.get(0));
            fragment. ruhuphotonumber.showImageTwo(fragment.sfzfmList, fragment.sfzfmImageview, 2);
        }
        // 地图定位
        if (fragment.data.getDw() != null) {
            fragment. scsfzmList = new Gson().fromJson(fragment.data.getDw(),
                    new TypeToken<List<String>>() {
                    }.getType());
            utils.display(fragment.scsfzImageview, fragment.scsfzmList.get(0));
            fragment.ruhuphotonumber.showImageTwo(fragment.scsfzmList, fragment.scsfzImageview, 3);
        }
        // 收入文件证明
        if (fragment.data.getSrwjzm() != null) {
            fragment.ydcyhyList = new Gson().fromJson(fragment.data.getSrwjzm(),
                    new TypeToken<List<String>>() {
                    }.getType());

            utils.display(fragment.ydcyhyImageview, fragment.ydcyhyList.get(0));
            fragment.ruhuphotonumber.showImageTwo(fragment.ydcyhyList, fragment.ydcyhyImageview, 4);
        }

        // 购车发票证明
        if (fragment.data.getGcfpwj() != null) {

            fragment. zzzmList = new Gson().fromJson(fragment.data.getGcfpwj(),
                    new TypeToken<List<String>>() {
                    }.getType());
            utils.display(fragment.zzzmImageview, fragment.zzzmList.get(0));
            fragment. ruhuphotonumber.showImageTwo(fragment.zzzmList, fragment.zzzmImageview, 5);
        }

        // 首付款文件证明
        if (fragment.data.getSfkzmwj() != null) {
            fragment. sqrxqList = new Gson().fromJson(fragment.data.getSfkzmwj(),
                    new TypeToken<List<String>>() {
                    }.getType());
            utils.display(fragment.sqrxqImageview,fragment. sqrxqList.get(0));
            fragment.ruhuphotonumber.showImageTwo(fragment.sqrxqList, fragment.sqrxqImageview, 6);
        }

        // 车辆抵押文件证明
        if (fragment.data.getCldyzmwj() != null) {

            fragment.sqrszlhList = new Gson().fromJson(fragment.data.getCldyzmwj(),
                    new TypeToken<List<String>>() {
                    }.getType());
            utils.display(fragment.sqrszlhImageview,fragment. sqrszlhList.get(0));
            fragment. ruhuphotonumber.showImageTwo(fragment.sqrszlhList, fragment.sqrszlhImageview, 7);
        }

        // 车辆保险单文件
        if (fragment.data.getClbxdwj() != null) {

            fragment.sqrszdyList = new Gson().fromJson(fragment.data.getClbxdwj(),
                    new TypeToken<List<String>>() {
                    }.getType());
            utils.display(fragment.sqrszdyImageview, fragment.sqrszdyList.get(0));
            fragment. ruhuphotonumber.showImageTwo(fragment.sqrszdyList, fragment.sqrszdyImageview, 8);
        }

        // 购车合同文件证明
        if (fragment.data.getGchtwj() != null) {
            fragment.sqrszmphList = new Gson().fromJson(fragment.data.getGchtwj(),
                    new TypeToken<List<String>>() {
                    }.getType());
            utils.display(fragment.sqrszmphImageview, fragment.sqrszmphList.get(0));
            fragment.ruhuphotonumber. showImageTwo(fragment.sqrszmphList, fragment.sqrszmphImageview, 9);
        }

        // 征信报告文件证明
        if (fragment.data.getZxbgwj() != null) {

            fragment.dwList = new Gson().fromJson(fragment.data.getZxbgwj(),
                    new TypeToken<List<String>>() {
                    }.getType());
            utils.display(fragment.dwImageview, fragment.dwList.get(0));
            fragment.ruhuphotonumber.showImageTwo(fragment.dwList, fragment.dwImageview, 10);
        }

    }









}
