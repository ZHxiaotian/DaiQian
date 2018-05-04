package com.zonesun.daiqian.adapter;

import java.util.ArrayList;

import com.zonesun.daiqian.activity.R;
import com.zonesun.daiqian.entity.Report;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MainReportAdapter extends BaseAdapter {
    private Activity context;
    private ArrayList<Report> reportList;

    public MainReportAdapter(Activity context, ArrayList<Report> reportList){
        this.context = context;
        this.reportList = reportList;
    }

    @Override
    public int getCount() {
        return reportList.size();
    }

    @Override
    public Object getItem(int i) {
        return reportList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            view = View.inflate(context, R.layout.main_report_item, null);
            holder = new ViewHolder();

            holder.nameTextView = (TextView) view.findViewById(R.id.name_textview);
           
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        Report report = reportList.get(i);
        holder.nameTextView.setText(report.getZwxm());
       
        return view;
    }

    class ViewHolder {
        TextView nameTextView;
    }
}
