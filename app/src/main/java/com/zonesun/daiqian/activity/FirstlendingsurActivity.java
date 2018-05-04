package com.zonesun.daiqian.activity;


import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.living.activity.hxcr.util.Util;

import com.zonesun.daiqian.base.AppManager;
import com.zonesun.daiqian.base.BaseActivity;
import com.zonesun.daiqian.fragment.FirstLSlideMenuFragment;
import com.zonesun.daiqian.fragment.FirstLendingFragment;
import com.zonesun.daiqian.fragment.RuhuSurveyFragment;
import com.zonesun.daiqian.fragment.SlideMenuFragment;
import com.zonesun.daiqian.util.MyEvent;

import de.greenrobot.event.EventBus;

public class FirstlendingsurActivity extends BaseActivity {

    public FragmentTransaction ft;

    private String name;
    private FirstLendingFragment fragment;
    private TextView tv_titleText;
    public ProgressBar progressBar;
    Button bt_reset;
    // private SqliteUtils sqliteUtils;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // No Titlebar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        AppManager.getAppManager().addActivity(this);
        setContentView(R.layout.activity_ruhu_survey);
        // MyApplication.getInstance().addActivity(this);
        EventBus.getDefault().register(this);
        initView();

    }

    /**
     * 初始化数据
     */
    private void initView() {
        // 设置标题文字
        tv_titleText = (TextView) findViewById(R.id.tv_title_text);
        tv_titleText.setText("贷前管理系统》先放款后抵押");// 改变标题文字-->个人设置
//
        bt_reset=(Button) findViewById(R.id.bt_ChangeUser);
        bt_reset.setText("重置");
        bt_reset.setVisibility(View.VISIBLE);

        bt_reset.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                fragment.clearAll();//重置入户调查界面的信息
            }
        });
        tv_titleText.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Util.getCamera(FirstlendingsurActivity.this, "杨林林",
                        "130131199508180920");
            }
        });
        progressBar = (ProgressBar) this.findViewById(R.id.progressBar1);
        progressBar.setVisibility(View.VISIBLE);
        progressBar.setMax(100);
        progressBar.setProgress(0);
        ft = getSupportFragmentManager().beginTransaction();
        fragment = new FirstLendingFragment();
        ft.replace(R.id.fl_main, fragment);


    }

    private   FirstLSlideMenuFragment fragment2 =new FirstLSlideMenuFragment();

    // 继承父类方法,设置Fragment边侧栏
    @Override
    public void allocationFragment() {
        super.createFragment(fragment2);
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            // 创建退出对话框
            AlertDialog isExit = new AlertDialog.Builder(this).create();
            // 设置对话框标题
            isExit.setTitle("系统提示");
            // 设置对话框消息
            isExit.setMessage("确定要退出吗？一旦退出信息将不保存。");
            // 添加选择按钮并注册监听
            isExit.setButton("确定", listener);
            isExit.setButton2("取消", listener);
            // 显示对话框
            isExit.show();

        }

        return false;

    }

    /** 监听对话框里面的button点击事件 */
    DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
            switch (which) {
                case AlertDialog.BUTTON_POSITIVE:// "确认"按钮退出程序
                    finish();
                    break;
                case AlertDialog.BUTTON_NEGATIVE:// "取消"第二个按钮取消对话框
                    break;
                default:
                    break;
            }
        }
    };

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        switch (level) {
            case TRIM_MEMORY_UI_HIDDEN:
                // 进行资源释放操作
                break;
        }
    }

    @Override
    protected void onResume() {

        // System.out.println("Activity------------------onResume-------------------");

        super.onResume();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {

        super.onConfigurationChanged(newConfig);
        System.out.println("onConfigurationChanged......");
    }

    /**
     * 生命周期方法
     */
    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
        AppManager.getAppManager().finishActivity(this);
        EventBus.getDefault().unregister(this);
        // System.out.println("不要问为什么，是你的相机杀死了我");
    }

    public void onEventMainThread(MyEvent event) {

        if (event.isFlag()) {
            fragment2.refreshData();
        }

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        fragment.onActivityResult(requestCode, resultCode, data);

    }

}
