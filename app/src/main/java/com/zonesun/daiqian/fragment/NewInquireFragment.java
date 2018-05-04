package com.zonesun.daiqian.fragment;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zonesun.daiqian.activity.R;
import com.zonesun.daiqian.activity.ShowImagesActivity;
import com.zonesun.daiqian.entity.DsomeThings;
import com.zonesun.daiqian.entity.GLobleData;
import com.zonesun.daiqian.entity.IdentifyResult;
import com.zonesun.daiqian.util.BitMapUtils;
import com.zonesun.daiqian.util.Constants;
import com.zonesun.daiqian.util.DoSomeThsDao;
import com.zonesun.daiqian.util.GetDateUtil;
import com.zonesun.daiqian.util.JudgeUtil;
import com.zonesun.daiqian.util.NoHttpRequest;
import com.zonesun.daiqian.util.RequestCode;
import com.zonesun.daiqian.util.ToastUtil;
import com.zonesun.daiqian.view.AbstractSpinerAdapter;
import com.zonesun.daiqian.view.AbstractSpinerAdapter.IOnItemSelectListener;
import com.zonesun.daiqian.view.CustemObject;
import com.zonesun.daiqian.view.CustemSpinerAdapter;
import com.zonesun.daiqian.view.HttpServceUtil;
import com.zonesun.daiqian.view.SpinerPopWindow;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NewInquireFragment extends Fragment implements
        IOnItemSelectListener {
    public Activity mActivity;
    private ArrayList<String> sfzzmList = new ArrayList<String>();// 身份证图片路径集合
    private ArrayList<String> authorizeList = new ArrayList<String>();// 授权书图片路径集合
    private List<CustemObject> spinnerList = new ArrayList<CustemObject>();
    private AbstractSpinerAdapter<CustemObject> spinnerAdapter;
    private SpinerPopWindow spinnerPopWindow;
    private TextView selectedSpinnerText;
    private String path;// 图片的保存路径
    private Bitmap bitmap;// 获取到的图片
    private Bitmap zteBitmap;// 压缩后的
    private Bitmap zhengmian;// 身份证正面照片
    private Bitmap fanmian;// 身份证反面照片

    private DoSomeThsDao Dao;

    private int flag = 0;
    private Intent intent = new Intent();
    String MYCOOKIES;

    // ----------控件id---------
    // 姓名
    @Bind(R.id.et_newinquire_name)
    EditText et_name;
    // 证件类型
    @Bind(R.id.tv_newinquire_CredentialsModel)
    TextView tv_idmodel;
    @Bind(R.id.rl_newinqire_CredentialsModel)
    RelativeLayout rl;
    // 身份证号
    @Bind(R.id.et_newinquire_idnumber)
    EditText et_idnumber;
    // 授权书照片
    @Bind(R.id.iv_newinquire_Authorize)
    ImageView iv_authorize;
    // 授权书的textview
    @Bind(R.id.tv_newinquire_Authorize)
    TextView tv_Authorize;
    // 身份证复印件照片
    @Bind(R.id.iv_newinquire_picard)
    ImageView iv_picard;
    // 身份证照片显示的TextView
    @Bind(R.id.tv_newinquire_picard)
    TextView tv_picard;
    @Bind(R.id.bt_newinquire_commit)
    Button bt_commit;
    // 图片名称
    String picName = "";
    // 图片的保存路径
    String url = "";
    // 设置网络请求参数的集合
    private Map<String, String> commitMap = new HashMap<String, String>();
    private SharedPreferences sp;

    /*
     * 初始化界面初始化所有控件 (non-Javadoc)
     *
     * @see
     * android.support.v4.app.Fragment#onCreateView(android.view.LayoutInflater,
     * android.view.ViewGroup, android.os.Bundle)
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = View
                .inflate(getActivity(), R.layout.fragment_newinquire, null);
        ButterKnife.bind(this, v);
        Dao = new DoSomeThsDao(getActivity());
        initView();
        return v;
    }

    // 定义一个map集合添加网络请求参数
    Map<String, String> map = new HashMap<String, String>();

    /*
     * 定义Handler处理网络请求后的的返回结果
     */
    private Handler myHandler = new Handler(new Handler.Callback() {

        @Override
        public boolean handleMessage(Message msg) {
            // TODO Auto-generated method stub
            if (msg.arg1 == RequestCode.newinquire_photoupload_onFailure) {

                Toast.makeText(getActivity(), "上传失败，检查一下服务器地址是否正确",
                        Toast.LENGTH_LONG).show();
            } else if (msg.arg1 == RequestCode.newinquire_photoupload_onsuccess) {

                Toast.makeText(getActivity(), "上传成功" + msg.obj.toString(),
                        Toast.LENGTH_LONG).show();
                System.out.println(msg.obj.toString());

                List<String> list = new Gson().fromJson(msg.obj.toString(),
                        new TypeToken<List<String>>() {
                        }.getType());
                if ("1".equals(list.get(1))) {

                    String idcardurl = getGsonPictulurl(list);// 将图片路径转为Gson串
                    commitMap.put("idcardurl", idcardurl);
                    // 在此提交需要查询征信的分享用户
                    if (commitMap.containsKey("idcardurl")
                            & commitMap.containsKey("authurl")) {
                        upload();
                    }
                } else if ("2".equals(list.get(1))) {

                    commitMap.put("authurl", getGsonPictulurl(list));

                    System.out.println("............" + getGsonPictulurl(list));
                    // 在此提交需要查询征信的分享用户
                    if (commitMap.containsKey("idcardurl")
                            & commitMap.containsKey("authurl")) {
                        upload();
                    }
                }

            } else if (msg.arg1 == RequestCode.newinquire_datacommit_onsuccess) {

                Toast.makeText(getActivity(), "提交成功" + msg.obj.toString(),
                        Toast.LENGTH_LONG).show();
                Dateclear();// 当提交用户数据后清空本页数据
            } else if (msg.arg1 == RequestCode.newinquire_datacommit_onFailure) {

                Toast.makeText(getActivity(), "请检查网络" + msg.obj.toString(),
                        Toast.LENGTH_LONG).show();
            }
            return false;
        }
    });

    /**
     * 将上传图片中成功后返回的路径转化为Gson串
     *
     * @param list
     * @return
     */
    private String getGsonPictulurl(List<String> list) {
        ArrayList<String> urlist = new ArrayList<String>();
        urlist.add(list.get(0));

        return new Gson().toJson(urlist).toString();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        mActivity = getActivity();
    }

    // 初始化方法
    private void initView() {
        // TODO Auto-generated method stub
        sp = getActivity().getSharedPreferences("login", Context.MODE_PRIVATE);
        MYCOOKIES = sp.getString("MYCOOKIES", null);
        tv_idmodel.setText("身份证");
        spinnerAdapter = new CustemSpinerAdapter(getActivity());
        spinnerPopWindow = new SpinerPopWindow(getActivity());
        spinnerPopWindow.setItemListener(this);

    }

    /*
     * ui控件的监听方法
     */
    @OnClick({R.id.rl_newinqire_CredentialsModel,
            R.id.iv_newinquire_Authorize, R.id.iv_newinquire_picard,
            R.id.bt_newinquire_commit, R.id.tv_newinquire_Authorize,
            R.id.tv_newinquire_picard})
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.rl_newinqire_CredentialsModel:

                selectedSpinnerText = tv_idmodel;

                String[] zjlxList = getResources()
                        .getStringArray(R.array.zjlx_list);

                showSpinWindow(zjlxList);
                break;
            // 授权书照片
            case R.id.iv_newinquire_Authorize:
                // 调用照相机拍照
                camera(2);

                break;
            // 身份证复印件拍照
            case R.id.iv_newinquire_picard:
                // 调用照相机拍照
                camera(1);
                break;
            // 提交按钮
            case R.id.bt_newinquire_commit:
                if(GLobleData.DeviceBrand.equals(android.os.Build.BRAND)&&GLobleData.Devicemodel.equals(android.os.Build.MODEL)){

                    if (!(et_name.getText().toString().isEmpty())
                            && !(tv_idmodel.getText().toString().isEmpty())
                            && !(et_idnumber.getText().toString().isEmpty())) {

                        if (sfzzmList != null && sfzzmList.size() > 0 && authorizeList != null && authorizeList.size() > 0) {
                            ToastUtil.showShort(getActivity(), "正在上传");
                            addPamar(1);
                            addPamar(2);
                        }else{
                            ToastUtil.showShort(getActivity(), "请先添加照片");
                        }
                    } else {
                        ToastUtil.showShort(getActivity(), "姓名或身份证号不能为空");
                    }
                }else{

                    ToastUtil.showShort(getActivity(),"当前设别受限，无法添加征信信息");
                }

                break;
            // 授权书
            case R.id.tv_newinquire_Authorize:
                isempty(authorizeList, path);
                break;
            // 身份证复印件
            case R.id.tv_newinquire_picard:

                isempty(sfzzmList, path);
                break;
            default:
                break;
        }

    }

    /*
     *
     * 添加网络请求参数进行申请人姓名的信息提交到服务器
     */
    private void upload() {
        commitMap.put("Cookie", "JSESSIONID=" + MYCOOKIES);
        if (et_idnumber.getText().toString().isEmpty()
                && et_name.getText().toString().isEmpty()) {
            Toast.makeText(getActivity(), "姓名或身份证号不能为空", Toast.LENGTH_SHORT)
                    .show();
            return;
        }
        commitMap.put("idcardno", et_idnumber.getText().toString());
        commitMap.put("name", et_name.getText().toString());
//        System.out.println(commitMap.toString());
        //当所有信息都完善进行征信数据提交到后台
        HttpServceUtil.Httprequest(commitMap, Constants.POSTBankAddInquire,
                myHandler, RequestCode.newinquire_datacommit_relizecode);
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
                if (!dir.exists())
                    dir.mkdirs();
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File f = new File(dir, picName);// ImageFileName是自己定义的名字
                Uri u = Uri.fromFile(f);
                System.out.println("+++++" + u);
                intent.putExtra(MediaStore.Images.Media.ORIENTATION, 0);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, u);
                startActivityForResult(intent, requestCode);
            } catch (ActivityNotFoundException e) {
                Toast.makeText(getActivity(), "没有找到储存目录", Toast.LENGTH_LONG)
                        .show();
            }
        } else {
            Toast.makeText(getActivity(), "没有储存卡", Toast.LENGTH_LONG).show();
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

    @Override
    public void onItemClick(int pos) {
        setSpinnerText(pos);

    }

    // 用来显示身份证件文本内容的方法
    private void setSpinnerText(int pos) {
        if (pos >= 0 && pos <= spinnerList.size()) {
            CustemObject value = spinnerList.get(pos);
            selectedSpinnerText.setText(value.toString());

        }

    }

    int takephototimes = 0;

    /**
     * 调用系统相机返回结构获取照片方法的回调
     */
    @SuppressWarnings("static-access")
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (takephototimes == 0) {
            String str = GetDateUtil.getCurrentTime();

            Dao.addMessage(new DsomeThings(GLobleData.logindata.getData()
                    .getJobnum(), "1", "拍照", str, ""));
            takephototimes++;
        }
        if (resultCode == mActivity.RESULT_OK) {
            switch (requestCode) {
                case 2:
                    // 授权书
                    getBitmap(requestCode);
                    if (zteBitmap != null) {
                        // iv_picard.setImageBitmap(zteBitmap);
                        iv_authorize.setImageBitmap(zteBitmap);
                        // authorizeList.add(path);
                    }

                    break;
                case 1:
                    ++flag;
                    // 身份证复印件
                    getBitmap(requestCode);

                    break;
            }

        }

    }

    /**
     * 判断当前的是否有没有图片是否需要去查看当前存在的图片
     *
     * @param list
     * @param url
     */
    private void isempty(ArrayList<String> list, String url) {
        if (!list.isEmpty()) {
            intent = new Intent(getActivity(), ShowImagesActivity.class);
            intent.putStringArrayListExtra("list", list);
            intent.putExtra("url", url);
            startActivity(intent);
        } else {
            Toast.makeText(getActivity(), "您还没有添加照片", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * 获取返回图片进行添加水印
     */
    private void getBitmap(int requestcode) {
        // 名字为null
        path = Environment.getExternalStorageDirectory() + "/" + "dq" + "/"
                + picName;
        System.out.println("path==" + path);
        File file = new File(path);
        Uri uri = Uri.fromFile(file);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 4;
        options.inJustDecodeBounds = false;
        try {
            bitmap = BitmapFactory.decodeStream(getActivity()
                    .getContentResolver().openInputStream(uri), null, options);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        if (requestcode == 1) {
            if (flag == 1) {
                if (!bitmap.equals("")) {
                    zhengmian = Bitmap.createBitmap(bitmap.getWidth(),
                            bitmap.getHeight(), Config.ARGB_8888);
                    Canvas canvas = new Canvas(zhengmian);

                    Paint paint = new Paint();
                    canvas.drawBitmap(bitmap, 0, 0, paint);
                    zhengmian = JudgeUtil.rotateBitmapByDegree(zhengmian);
                    FileOutputStream fout1 = null;
                    try {
                        zteBitmap = zhengmian;
                        fout1 = new FileOutputStream(file);
                        zteBitmap.compress(CompressFormat.JPEG, 100, fout1);
                        NoHttpRequest.uploadIdCard(BitMapUtils.bitmapToBase64(zteBitmap), "0", new NoHttpRequest.SimpleCallBack() {

                            public void Succ(String result) {
                                System.out.println(result);
                                IdentifyResult res = new Gson().fromJson(result, IdentifyResult.class);
                                System.out.println(res.toString());
                                if (res.getErrorcode() !=0) {
                                    ToastUtil.showShort(getActivity(),"您拍摄的身份证无法识别。");

                                } else {
                                    if (res != null) {
                                       et_name.setText(res.getName());
                                        et_idnumber.setText(res.getId());

                                    }
                                }
                            }

                            ;

                            public void error() {


                            }

                            ;

                        });

                    } catch (FileNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    iv_picard.setImageBitmap(zhengmian);

                    sfzzmList.add(path);
                } else {
                    Toast.makeText(getActivity(), "null2", Toast.LENGTH_SHORT)
                            .show();
                }
            } else if (flag == 2) {
                if (sfzzmList.isEmpty()) {

                } else {
                    sfzzmList = new ArrayList<String>();
                }
                flag = 0;

                fanmian = Bitmap.createBitmap(bitmap.getWidth(),
                        bitmap.getHeight(), Config.ARGB_8888);
                Canvas canvas = new Canvas(fanmian);

                Paint paint = new Paint();
                canvas.drawBitmap(bitmap, 0, 0, paint);
                fanmian = JudgeUtil.rotateBitmapByDegree(fanmian);
                FileOutputStream fout1 = null;

                try {
                    fout1 = new FileOutputStream(file);
                    zteBitmap = JudgeUtil.mergeBitmap_TB(zhengmian, fanmian,
                            false);
                    zteBitmap.compress(CompressFormat.JPEG, 100, fout1);
                    fout1.flush();
                    fout1.close();
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                iv_picard.setImageBitmap(zteBitmap);
                sfzzmList.add(path);

                // addPamar(requestcode);

            }

        } else if (requestcode == 2) {
            if (!bitmap.equals("")) {
                zteBitmap = Bitmap.createBitmap(bitmap.getWidth(),
                        bitmap.getHeight(), Config.ARGB_8888);
                Canvas canvas = new Canvas(zteBitmap);

                Paint paint = new Paint();
                canvas.drawBitmap(bitmap, 0, 0, paint);

                FileOutputStream fout1 = null;
                try {
                    fout1 = new FileOutputStream(file);
                    zteBitmap.compress(CompressFormat.JPEG, 100, fout1);
                    fout1.flush();
                    fout1.close();
                    authorizeList.add(path);
                    // 上传图片到服务器

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                Toast.makeText(getActivity(), "null2", Toast.LENGTH_SHORT)
                        .show();
            }
            // addPamar(requestcode);
        }

    }

    /*
     *
     * 添加上传照片的参数的方法
     */
    private void addPamar(int extra) {
        // String mime = MimeTypeMap.getSingleton()
        // .getMimeTypeFromExtension("png");
        map.put("extra", extra + "");
        System.out.println(sfzzmList.size());
        if (extra == 1) {
            System.out.println("sfzzmList+" + sfzzmList.get(0));
//            HttpServceUtil.upload(sfzzmList.get(0), map, myHandler,
//                    RequestCode.newinquire_photoupload_relizecode);
            HttpServceUtil.UpLoad(sfzzmList.get(0), map, myHandler,
                    RequestCode.newinquire_photoupload_relizecode);
        } else if (extra == 2) {
            HttpServceUtil.UpLoad(authorizeList.get(0), map, myHandler,
                    RequestCode.newinquire_photoupload_relizecode);
        }
    }

    /**
     * 提交数据成功后清楚数据的方法
     */
    private void Dateclear() {

        sfzzmList.clear();// 身份证图片路径集合
        authorizeList.clear();
        commitMap.clear();
        zteBitmap.recycle();
        et_name.setText("");

        et_idnumber.setText("");

        iv_authorize.setImageResource(R.drawable.tianjian);
        // 身份证复印件照片

        iv_picard.setImageResource(R.drawable.tianjian);

    }


}
