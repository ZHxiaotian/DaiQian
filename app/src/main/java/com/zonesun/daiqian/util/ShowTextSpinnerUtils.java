package com.zonesun.daiqian.util;

import android.content.Context;
import android.widget.TextView;

import com.zonesun.daiqian.entity.GLobleData;
import com.zonesun.daiqian.view.AbstractSpinerAdapter;
import com.zonesun.daiqian.view.CustemObject;
import com.zonesun.daiqian.view.SpinerPopWindow;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/1/12 0012.
 */

public class ShowTextSpinnerUtils implements AbstractSpinerAdapter.IOnItemSelectListener{


    private List<CustemObject> spinnerList = new ArrayList<CustemObject>();
    private AbstractSpinerAdapter<CustemObject> spinnerAdapter;
    private SpinerPopWindow spinnerPopWindow;
    private TextView selectedSpinnerText;


    /**
     * @param
     */
    public  void showSpinWindow(Context context,int resId,AbstractSpinerAdapter<CustemObject> spinnerAdapter,
                               SpinerPopWindow spinnerPopWindow,TextView selectedSpinnerText) {
         this.spinnerAdapter = spinnerAdapter;
         this.spinnerPopWindow = spinnerPopWindow;
         this.selectedSpinnerText = selectedSpinnerText;
        spinnerPopWindow.setItemListener(this);
        String[] list =context.getResources().getStringArray(resId);
        spinnerList=new ArrayList<CustemObject>();

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
    public  void showSpinWindow(Context context,AbstractSpinerAdapter<CustemObject> spinnerAdapter,
                                SpinerPopWindow spinnerPopWindow,TextView selectedSpinnerText,int z){
        this.spinnerAdapter = spinnerAdapter;
        this.spinnerPopWindow = spinnerPopWindow;
        this.selectedSpinnerText = selectedSpinnerText;
        spinnerList =new ArrayList<CustemObject>();
        for (int i = 0; i < GLobleData.cardbinmsglist.size(); i++) {
                    CustemObject object = new CustemObject();
                    object.data = GLobleData.cardbinmsglist.get(i).getCardbin();
                    spinnerList.add(object);
                }
        spinnerPopWindow.setItemListener(this);
        spinnerAdapter.refreshData(spinnerList, 0);
        spinnerPopWindow.setAdatper(spinnerAdapter);
        spinnerPopWindow.setWidth(selectedSpinnerText.getWidth());
        spinnerPopWindow.showAsDropDown(selectedSpinnerText);
    }

    /**
     *
     */
    
    public  void    showSpinWindow(Context context,AbstractSpinerAdapter<CustemObject> spinnerAdapter,
                                SpinerPopWindow spinnerPopWindow,TextView selectedSpinnerText) {
        this.spinnerAdapter = spinnerAdapter;
        this.spinnerPopWindow = spinnerPopWindow;
        this.selectedSpinnerText = selectedSpinnerText;
        spinnerPopWindow.setItemListener(this);
        spinnerList =new ArrayList<CustemObject>();

//        for (int i = 0; i < GLobleData.addresslist.size(); i++) {
//            CustemObject object = new CustemObject();
//            object.data = GLobleData.addresslist.get(i).getRegion();
//            spinnerList.add(object);
//        }
        spinnerAdapter.refreshData(spinnerList, 0);
        spinnerPopWindow.setAdatper(spinnerAdapter);
        spinnerPopWindow.setWidth(selectedSpinnerText.getWidth());
        spinnerPopWindow.showAsDropDown(selectedSpinnerText);
    }

    public void onItemClick(int pos) {
        setSpinnerText(pos);
    }
    private void setSpinnerText(int pos) {
        if (pos >= 0 && pos <= spinnerList.size()) {
            CustemObject value = spinnerList.get(pos);
            selectedSpinnerText.setText(value.toString());
        }
    }



}
