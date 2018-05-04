package com.zonesun.daiqian.util;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import com.zonesun.daiqian.entity.GLobleData;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;

public class MyTextWachert implements TextWatcher {

    /**
     * 分期金额
     */
    private EditText FQJE;
    /**
     * 信用总额度
     */
    private TextView XYZED;
    private EditText LCJG;
    private TextView FQFKQS;
    private TextView SYHKJE;
    private TextView YHKJE;
    private TextView CS;
    private TextView FQHKSXFL;

    /**
     * 月均收入 * private TextView YJSR; /** 家庭已有贷款月还款额
     */
    private TextView JTYYDKYHKE;
    /**
     * 申请人家庭收入还款比
     */
    private TextView SQRJTSRHKB;
    // 手续费金额
    private TextView SXFJE;
    // 申请人月均收入
    private TextView YJSR;
    // 配偶月均收入
    private EditText POYJSR;
    private EditText ZHFWF;//综合服务费
    /*
     * 将所有的View对象传入以便控制金额的变动;
	 */



    public MyTextWachert(EditText fQJE, TextView xYZED, EditText lCJG,
                         TextView fQFKQS, TextView sYHKJE, TextView yHKJE, TextView cS,
                         TextView fQHKSXFL, TextView yJSR, TextView jTYYDKYHKE,
                         TextView sQRJTSRHKB, TextView sXFJE, EditText poyjsr,EditText zHFWF) {
        super();
        FQJE = fQJE;
        XYZED = xYZED;
        LCJG = lCJG;
        FQFKQS = fQFKQS;
        SYHKJE = sYHKJE;
        YHKJE = yHKJE;
        CS = cS;
        FQHKSXFL = fQHKSXFL;
        YJSR = yJSR;
        JTYYDKYHKE = jTYYDKYHKE;
        SQRJTSRHKB = sQRJTSRHKB;
        SXFJE = sXFJE;
        POYJSR = poyjsr;
        this.ZHFWF=zHFWF;
    }

    public MyTextWachert(EditText fQJE, TextView xYZED, EditText lCJG,
                         TextView fQFKQS, TextView sYHKJE, TextView yHKJE, TextView cS,
                         TextView fQHKSXFL, TextView sQRJTSRHKB, TextView sXFJE) {
        super();
        FQJE = fQJE;
        XYZED = xYZED;
        LCJG = lCJG;
        FQFKQS = fQFKQS;
        SYHKJE = sYHKJE;
        YHKJE = yHKJE;
        CS = cS;
        FQHKSXFL = fQHKSXFL;
        SQRJTSRHKB = sQRJTSRHKB;
        SXFJE = sXFJE;
    }




    @Override
    public void beforeTextChanged(CharSequence s, int start, int count,
                                  int after) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        // TODO Auto-generated method stub

    }

    @Override
    public void afterTextChanged(Editable s) {
        // TODO Auto-generated method stub

        DecimalFormat df = new DecimalFormat("######0.00"); // 保留最后小数，四舍五入
        String fenqiJE = FQJE.getText().toString().trim();

        String lcPrice = LCJG.getText().toString().trim();
        String hkqs = FQFKQS.getText().toString().trim();
        float fqfkll = 0;
        // 分期金额
        double xyzed = 0;
        // 裸车价格
        double lc_pricoat = 0;
        int Hk_dm = 0;
        float zhfuf=0;//综合服务费
        // if(fenqiJE!=null&&!("".equals(fenqiJE))){
        //
        // FQJE.setText(df.format(Double.valueOf(fenqiJE))+"");
        //
        // }

        if (!("请选择".equals(hkqs)) && null != hkqs && !("".equals(hkqs))) {
            Hk_dm = Integer.parseInt(hkqs.replace("期", ""));
            NumberFormat nf = NumberFormat.getPercentInstance();// NumberFormat是一个工厂，可以直接getXXX创建，而getPercentInstance()
            Number m = null;
            if (Hk_dm == 12) {
                System.out.println(GLobleData.list.toString());
                if (null == GLobleData.map.get(Hk_dm + "")) {
                    FQHKSXFL.setText("");
                    return;
                } else {
                    String str = GLobleData.map.get(Hk_dm + "");
                    FQHKSXFL.setText(str);
                    String feilv = str.replace("%", "");
                    try {
                        m = nf.parse(str);
                        fqfkll = Float.parseFloat(m + "");
                    } catch (ParseException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                }
            } else if (Hk_dm == 24) {
                String str = GLobleData.map.get(Hk_dm + "");

                FQHKSXFL.setText(str);
                try {
                    m = nf.parse(str);
                    fqfkll = Float.parseFloat(m + "");
                } catch (ParseException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            } else if (Hk_dm == 36) {
                String str = GLobleData.map.get(Hk_dm + "");
                FQHKSXFL.setText(GLobleData.map.get(Hk_dm + ""));

                try {
                    m = nf.parse(str);
                    fqfkll = Float.parseFloat(m + "");
                } catch (ParseException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        }
        //获取综合服务费
        if(null!=ZHFWF.getText().toString()&&!("".equals(ZHFWF.getText().toString()))){
            zhfuf=Float.valueOf(ZHFWF.getText().toString());
        }

        //获取信用总额度的值并计算成数
        if (!("".equals(fenqiJE)) && null != fenqiJE && !("".equals(lcPrice))
                && null != lcPrice) {

                xyzed= Double.valueOf(FQJE.getText().toString().trim());

            lc_pricoat = Double.valueOf(lcPrice);

            CS.setText(df.format((xyzed / lc_pricoat * 100)) + "%");
            // CS.setText((int) (xyzed / lc_pricoat * 100) + "%");

        } else if ("".equals(fenqiJE) && null != fenqiJE) {

            // FQFKQS.setText("");
            YHKJE.setText("");
            SYHKJE.setText("");
            CS.setText("");
        }

        if (0 != Hk_dm) {
            if(zhfuf==0) {
                YHKJE.setText(df.format((int) (xyzed / Hk_dm)));
                // YHKJE.setText((int) (xyzed / Hk_dm) + ".00");
                SYHKJE.setText(df.format(xyzed - ((int) (xyzed / Hk_dm))
                        * (Hk_dm - 1)));
            }else{
                double nv= xyzed+zhfuf+zhfuf*fqfkll;
                YHKJE.setText(df.format((int) (nv / Hk_dm)+(int)(xyzed*fqfkll)/Hk_dm));
                // YHKJE.setText((int) (xyzed / Hk_dm) + ".00");
                SYHKJE.setText(df.format((int)(nv-(int)(nv/Hk_dm)*(Hk_dm-1)+(int)(xyzed*fqfkll-((int)(xyzed*fqfkll/Hk_dm)*(Hk_dm-1))))));

            }
        } else {

            return;
        }

        if (fqfkll != 0) {

            XYZED.setText(df.format((xyzed + (int) (xyzed * fqfkll)+zhfuf+(int)(zhfuf*fqfkll))));

        } else {

            return;
        }

        if (!"".equals(FQJE.getText().toString())
                && null != FQJE.getText().toString()
                && !"".equals(FQHKSXFL.getText().toString())
                && null != FQHKSXFL.getText().toString()) {

            SXFJE.setText(df.format(xyzed * fqfkll) + "");//手续费金额

        }
        if (null != YJSR && null != JTYYDKYHKE) {
            if (exists(XYZED.getText(), YJSR.getText(), Hk_dm,
                    JTYYDKYHKE.getText(), POYJSR.getText())) {
                double xyzed2db = Double
                        .parseDouble(XYZED.getText().toString());
                double jtyydkyhke2db = Double.parseDouble(JTYYDKYHKE.getText()
                        .toString());
                double yjsr2db = Double.parseDouble(YJSR.getText().toString());
                double poyjsrdb = Double.parseDouble(POYJSR.getText().toString());

                SQRJTSRHKB
                        .setText(df
                                .format((((xyzed2db / Hk_dm) + jtyydkyhke2db) / (yjsr2db + poyjsrdb)) * 100)
                                + "%");
            }
        } else {
            return;
        }
    }

    /**
     * 判断可变长参数是否为为空
     *
     * @param obj
     * @return
     */
    private boolean exists(Object... obj) {
        for (Object o : obj) {
            if (o == null || o.toString().trim().equals("")) {
                return false;
            }
        }
        return true;
    }

}
