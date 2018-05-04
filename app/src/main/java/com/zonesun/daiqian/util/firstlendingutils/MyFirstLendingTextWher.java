package com.zonesun.daiqian.util.firstlendingutils;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;

import com.zonesun.daiqian.activity.R;
import com.zonesun.daiqian.fragment.FirstLendingFragment;
import com.zonesun.daiqian.fragment.RuhuSurveyFragment;
import com.zonesun.daiqian.util.IdCardUtil;
import com.zonesun.daiqian.util.ToastUtil;

/**
 * Created by Administrator on 2018/1/24 0024.
 */

public class MyFirstLendingTextWher implements TextWatcher {

    private FirstLendingFragment fragment;
    private TextView et;

    // private TextView tv_birthday;

    public MyFirstLendingTextWher(FirstLendingFragment fragment, TextView et) {

        this.fragment = fragment;
        this.et = et;

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
        //判额是那个输入框在进行操作
        switch (et.getId()) {
            case R.id.gtczrzjhm_edittext://共同偿债人身份证号
                String gtczrzjhm = et.getText().toString().trim();
                if (gtczrzjhm.length() == 18) {
                    System.out.println(gtczrzjhm);

                    fragment.gtczrcsnyEdittext.setText(gtczrzjhm.subSequence(6, 10)
                            + "-" + gtczrzjhm.subSequence(10, 12) + "-"
                            + gtczrzjhm.subSequence(12, 14));
                }

                break;
            case R.id.dbrzjhm_edittext://担保人身份证号
                String dbrzjhm = et.getText().toString().trim();
                if (dbrzjhm.length() == 18) {
                    fragment.dbrcsnyEdittext.setText(dbrzjhm.subSequence(6, 10) + "-"
                            + dbrzjhm.subSequence(10, 12) + "-"
                            + dbrzjhm.subSequence(12, 14));

                }

                break;
            case R.id.pozjhm_edittext://配偶身份证号
                String pozjhm = et.getText().toString().trim();
                if(pozjhm.length()==18||pozjhm.length()==15) {
                    int correct = new IdCardUtil(pozjhm).isCorrect();
                    if (0 == correct) {
                        //根据简单算法确定身份证号上的出生年月，可计算出申请人的性别
                        fragment.pocsnyEdittext.setText(pozjhm.subSequence(6, 10) + "-"
                                + pozjhm.subSequence(10, 12) + "-"
                                + pozjhm.subSequence(12, 14));

                        String end = pozjhm.substring(pozjhm.length() - 2,
                                pozjhm.length() - 1);

//					int num = Integer.parseInt(end);
//					if (num % 2 != 0) {
//						fragment.xbSpinnerText.setText("男");
//					} else {
//						fragment.xbSpinnerText.setText("女");
//					}

                    } else if (4 == correct) {
                        ToastUtil.showShort(fragment.getActivity(), "身份证中出生日期不合法");

                    }else if(3==correct){
                        ToastUtil.showShort(fragment.getActivity(), "身份证有非法字符");

                    }
                }

                break;
            case R.id.hyzk_spinner_text://申请人的婚姻状况分别对应未婚已婚和
                String hyzk = et.getText().toString().trim();
                if ("未婚".equals(hyzk)) {
                    fragment.sqrpoqkLayout.setVisibility(View.GONE);
                    fragment.ll_gtczordbr.setVisibility(View.VISIBLE);
                } else {
                    fragment.sqrpoqkLayout.setVisibility(View.VISIBLE);
                    fragment.ll_gtczordbr.setVisibility(View.GONE);
                    fragment.gtczrLayout.setVisibility(View.GONE);
                    fragment.dbrLayout.setVisibility(View.GONE);
                }
                break;
            case R.id.gtczrordbr_spinner_text://当申请人的婚姻状况是未婚时可选择共同偿债人或担保人来做担保
                String gtczrordbr = et.getText().toString();

                if (gtczrordbr.equals("担保人")) {
                    fragment.dbrLayout.setVisibility(View.VISIBLE);
                    fragment.gtczrLayout.setVisibility(View.GONE);
                    fragment.sqrpoqkLayout.setVisibility(View.GONE);
                } else {
                    fragment.dbrLayout.setVisibility(View.GONE);
                    fragment.gtczrLayout.setVisibility(View.VISIBLE);
                    fragment.sqrpoqkLayout.setVisibility(View.GONE);
                }
                break;
            case R.id.zzzk_spinner_text://用户买车的用途
                String zzzk = et.getText().toString().trim();
                if ("自有".equals(zzzk)) {
                    fragment.xjzdShengSpinnerText
                            .setText(fragment.hkszdShengSpinnerText.getText()
                                    .toString());
                    fragment.xjzdShiSpinnerText
                            .setText(fragment.hkszdShiSpinnerText.getText()
                                    .toString());
                    fragment.xjzdXxdzEditText.setText(fragment.hkszdXxdzEditText
                            .getText().toString());
                    fragment.xjzdxianEditText.setText(fragment.hkszdxianEditText
                            .getText().toString());
                } else {
                    fragment.xjzdShengSpinnerText.setText("");
                    fragment.xjzdShiSpinnerText.setText("");
                    fragment.xjzdXxdzEditText.setText("");

                }

                break;
            case R.id.zjhm_edittext://身份证号码的输入监听
                String zjhm = fragment.zjhmEdittext.getText().toString().trim();

                if(zjhm.length()==18||zjhm.length()==15) {
                    int correct = new IdCardUtil(zjhm).isCorrect();
                    if (0 == correct) {
                        //根据简单算法确定身份证号上的出生年月，可计算出申请人的性别
                        fragment.csnyEdittext.setText(zjhm.subSequence(6, 10) + "-"
                                + zjhm.subSequence(10, 12) + "-"
                                + zjhm.subSequence(12, 14));

                        String end = zjhm.substring(zjhm.length() - 2,
                                zjhm.length() - 1);

                        int num = Integer.parseInt(end);
                        if (num % 2 != 0) {
                            fragment.xbSpinnerText.setText("男");
                        } else {
                            fragment.xbSpinnerText.setText("女");
                        }

                    } else if (4 == correct) {
                        ToastUtil.showShort(fragment.getActivity(), "身份证中出生日期不合法");

                    }else if(3==correct){
                        ToastUtil.showShort(fragment.getActivity(), "身份证有非法字符");

                    }
                }
                break;
            default:
                break;
        }

    }

}
