package com.zonesun.daiqian.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.umeng.message.PushAgent;
import com.zonesun.daiqian.adapter.MainActivityAdapter;
import com.zonesun.daiqian.base.AppManager;
import com.zonesun.daiqian.entity.CardBinRoot;
import com.zonesun.daiqian.entity.CardBinmsg;
import com.zonesun.daiqian.entity.Data;
import com.zonesun.daiqian.entity.DataChild;
import com.zonesun.daiqian.entity.EventT;
import com.zonesun.daiqian.entity.GLobleData;
import com.zonesun.daiqian.entity.addresses.ProvinceAddress;
import com.zonesun.daiqian.util.Constants;
import com.zonesun.daiqian.util.IOUtils;
import com.zonesun.daiqian.util.NoCode;
import com.zonesun.daiqian.util.NoHttpRequest;
import com.zonesun.daiqian.util.ToastUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.greenrobot.event.EventBus;

/**
 * 主布局
 *
 * @author yll
 */
public class MainActivity extends Activity implements OnClickListener {

    // 六宫格
    private GridView gv_main;
    private TextView tv_title;
    // 适配器对象
    private MainActivityAdapter adapter;

    private SharedPreferences sp;

    private String MYCOOKIES;
    private Button bt_changeuse;
    // 友盟推送的deviceToken
    private String deviceToken;

    private Map<String, String> map = new HashMap<String, String>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // No Titlebar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        AppManager.getAppManager().addActivity(this);
        setContentView(R.layout.activity_main);
        // 添加Activity到堆栈
        PushAgent.getInstance(getApplicationContext()).onAppStart();// 检测友盟推送的启动次数
        deviceToken = PushAgent.getInstance(this).getRegistrationId();
        System.out.println(deviceToken);
        EventBus.getDefault().register(this);
        sp = getSharedPreferences("login", MODE_PRIVATE);
        MYCOOKIES = sp.getString("MYCOOKIES", null);
        initView();
        bt_changeuse.setVisibility(View.VISIBLE);
        setonClick();
        request();
        requestMessagePush();//友盟推送相关信息
//        TestCardBin();

    }

    /**
     * 更新推送的通知。。
     */
    private void requestMessagePush() {

        Map<String, String> map = new HashMap<String, String>();
        map.put("token", deviceToken);

        new NoHttpRequest(this, sp).Request(map, Constants.UPDATEMSGPUSH, null,
                NoCode.NOHTTP_WHAT_UPDATEUMMSGPUSH);
    }

    /**
     * 在此请求分期付款期数的数据
     */
    private void request() {
        new NoHttpRequest(this, sp).Request(map, Constants.GETPERIODURL, null,
                NoCode.NOHTTP_WHAT_RHDCFQFKQS);

    }

    /**
     * evenbus的回调方法
     *
     * @param event
     */
    public void onEventMainThread(EventT event) {

        if (event.getNoCode() == NoCode.NOHTTP_WHAT_RHDCFQFKQS) {
            String str = event.getObj().toString();
            Gson gson = new Gson();
            Data data = gson.fromJson(str, Data.class);

            GLobleData.list = data.getData();
            for (DataChild datachild : GLobleData.list) {
                GLobleData.map.put(datachild.getPeriodnum(), datachild.getRate());
            }
            System.out.println(GLobleData.map.toString());


        } else if (event.getNoCode() == NoCode.NOHTTP_WHAT_UPDATEUMMSGPUSH) {

            String str = event.getObj().toString();
            //System.out.println("MianActivity更新通知的有梦推送接口。。。。。。。。。" + str);
        } else if (NoCode.NOHTTP_WHAT_GETCARDBINS == event.getNoCode()) {//获取开卡申请卡bin的数据
//            System.out.print("zou le .....");

            String str = event.getObj().toString();
            Gson gson = new Gson();
            CardBinRoot root = gson.fromJson(str, CardBinRoot.class);
            for (CardBinmsg msg : root.getRows()) {
                GLobleData.cardbinmsglist.add(msg);
                System.out.print(msg.getCardbin());
            }
        }
    }

    /**
     * 设置点击事件
     */
    private void setonClick() {
        gv_main.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                switch (position) {

                    case 0:// 入户调查
                        startActivity(new Intent(MainActivity.this,
                                RuhuSurveyActivity.class));

                        break;

                    case 1:// 调研报告

                        Intent intent = new Intent(MainActivity.this,
                                ResearchReportActivity.class);
                        intent.putExtra("flag", "1");
                        startActivity(intent);

                        break;
                    case 2:// 调查预约 改成 开卡申请了

                        startActivity(new Intent(MainActivity.this,
                                OpenBreditCardActivity.class));

                        break;
                    case 3:// 征信查询

                        startActivity(new Intent(MainActivity.this,
                                ZhengXinresearchActivity.class));

                        break;
                    case 4:// 公告通知

					/*
                     * startActivity(new Intent(MainActivity.this,
					 * ResearchReport1Activity.class));
					 */

                        startActivity(new Intent(MainActivity.this,
                                InformActivity.class));

                        break;
                    case 5:// 个人设置

                        startActivity(new Intent(MainActivity.this,
                                PersonalSettingActivity.class));

                        break;
                    case 6://先放款后抵押

//                        ToastUtil.showShort(MainActivity.this, "此功能赞未开放");
                        startActivity(new Intent(MainActivity.this,FirstlendingsurActivity.class));

                        break;
                    default:
                        break;
                }
                // MainActivity.this.finish();
            }
        });
    }

    /**
     * 获取控件对象
     */
    private void initView() {

        System.out.println("===============" + MYCOOKIES);
        gv_main = (GridView) findViewById(R.id.gv_main);
        adapter = new MainActivityAdapter(MainActivity.this);

        // 设置适配
        gv_main.setAdapter(adapter);
        tv_title = (TextView) this.findViewById(R.id.tv_title_text);
        tv_title.setText("贷前管理系统");
        bt_changeuse = (Button) findViewById(R.id.bt_ChangeUser);
        bt_changeuse.setOnClickListener(this);

    }

    private EditText et;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        View view = View.inflate(MainActivity.this, R.layout.backdialog, null);
//    
//    LinearLayout layout=(LinearLayout) view.findViewById(R.id.ll_backdialog);
        if (keyCode == KeyEvent.KEYCODE_BACK) {


            AlertDialog isExit = new AlertDialog.Builder(this).create();
            // 设置对话框标题
            isExit.setTitle("系统提示");
            // 设置对话框消息
            isExit.setMessage("请输入密码退出");
            // 添加选择按钮并注册监听
            et = new EditText(MainActivity.this);
            et.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
//			LayoutParams params=new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
//			isExit.addContentView(layout, params);
            isExit.setView(et);
            isExit.setButton("是", listener);
            isExit.setButton2("否", listener);
            // 显示对话框
            isExit.show();

        }

        return super.onKeyDown(keyCode, event);
    }

    ;

    /**
     * 监听对话框里面的button点击事件
     */
    DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
            switch (which) {
                case AlertDialog.BUTTON_POSITIVE:// "确认"按钮退出程序
                    //finish();
//				AppManager.getAppManager().AppExit(MainActivity.this);
                    // MyApplication.getInstance().exit();
                    if (et.getText().toString().equals("112233")) {

                        AppManager.getAppManager().AppExit(MainActivity.this);
                    } else {

                        Toast.makeText(MainActivity.this, "请输入正确密码", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case AlertDialog.BUTTON_NEGATIVE:// "取消"第二个按钮取消对话框
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_ChangeUser:
                Intent itent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(itent);
                finish();
                break;

            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        AppManager.getAppManager().finishActivity(this);
    }

    private void TestCardBin() {

        Map<String, String> map = new HashMap<String, String>();
        new NoHttpRequest(this, sp).Request(map, Constants.CARDBINURL, null,
                NoCode.NOHTTP_WHAT_GETCARDBINS);

    }


    @Override
    protected void onRestart() {
        super.onRestart();


    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();

    }
}
