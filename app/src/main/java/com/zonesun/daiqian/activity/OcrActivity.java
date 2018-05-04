package com.zonesun.daiqian.activity;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.zonesun.daiqian.base.AppManager;
import com.zonesun.daiqian.entity.IdentifyResult;
import com.zonesun.daiqian.util.BitMapUtils;
import com.zonesun.daiqian.util.NoHttpRequest;
import com.zonesun.daiqian.util.ToastUtil;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class OcrActivity extends Activity implements View.OnClickListener {
    InputMethodManager manager;
    Button bt;
    TextView tv_title;

    int flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppManager.getAppManager().addActivity(this);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // No Titlebar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        setContentView(R.layout.activity_ocr);

        flag = getIntent().getIntExtra("flag", 0);
        inti();

    }

    /**
     * 初始化方法
     */
    private void inti() {

        tv_title = (TextView) this.findViewById(R.id.tv_title_text);
        tv_title.setText("Ocr身份证识别");
        bt = (Button) findViewById(R.id.bt_takephoto);
        bt.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        camera(1);

    }

    private String path;// 图片的保存路径
    private Bitmap bitmap;// 获取到的图片
    // 图片名称
    String picName = "";
    // 图片的保存路径
    String url = "";
    private Bitmap zteBitmap;// 压缩后的

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
                Toast.makeText(this, "没有找到储存目录", Toast.LENGTH_LONG)
                        .show();
            }
        } else {
            Toast.makeText(this, "没有储存卡", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);


        if (resultCode == RESULT_OK) {


            getBitmap(requestCode);


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
            bitmap = BitmapFactory.decodeStream(this
                    .getContentResolver().openInputStream(uri), null, options);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        if (!bitmap.equals("")) {
            zteBitmap = Bitmap.createBitmap(bitmap.getWidth(),
                    bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(zteBitmap);

            Paint paint = new Paint();
            canvas.drawBitmap(bitmap, 0, 0, paint);

            FileOutputStream fout1 = null;
            try {
                fout1 = new FileOutputStream(file);
                zteBitmap.compress(Bitmap.CompressFormat.JPEG, 79, fout1);
                fout1.flush();
                fout1.close();
                NoHttpRequest.uploadIdCard(BitMapUtils.bitmapToBase64(zteBitmap), "0", new NoHttpRequest.SimpleCallBack() {

                    public void Succ(String result) {
                        System.out.println(result);
                        IdentifyResult res = new Gson().fromJson(result, IdentifyResult.class);
                        System.out.println(res.toString());
                        if (res.getErrorcode() !=0) {
                            ToastUtil.showShort(OcrActivity.this,"您拍摄的身份证无法识别。");
                             finish();
                        } else {
                            if (res != null) {
                                Intent mIntent = new Intent(OcrActivity.this, RuhuSurveyActivity.class);
                                Bundle mBundle = new Bundle();
                                mBundle.putSerializable("result", res);
                                mIntent.putExtras(mBundle);
                                if (flag == 13) {

                                    setResult(13, mIntent);
                                } else if (flag == 14) {
                                    setResult(14, mIntent);

                                }
                                finish();
                            }
                        }
                    }

                    ;

                    public void error() {


                    }

                    ;

                });

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }

    private Bitmap getImage(String srcPath) {
        BitmapFactory.Options newOpts = new BitmapFactory.Options();
        // 开始读入图片，此时把options.inJustDecodeBounds 设回true了
        newOpts.inJustDecodeBounds = true;
        Bitmap bitmap = BitmapFactory.decodeFile(srcPath, newOpts);// 此时返回bm为空

        newOpts.inJustDecodeBounds = false;
        int w = newOpts.outWidth;
        int h = newOpts.outHeight;
        // 现在主流手机比较多是800*480分辨率，所以高和宽我们设置为
        float hh = 800f;// 这里设置高度为800f
        float ww = 480f;// 这里设置宽度为480f
        // 缩放比。由于是固定比例缩放，只用高或者宽其中一个数据进行计算即可
        int be = 1;// be=1表示不缩放
        if (w > h && w > ww) {// 如果宽度大的话根据宽度固定大小缩放
            be = (int) (newOpts.outWidth / ww);
        } else if (w < h && h > hh) {// 如果高度高的话根据宽度固定大小缩放
            be = (int) (newOpts.outHeight / hh);
        }
        if (be <= 0)
            be = 1;
        newOpts.inSampleSize = be;// 设置缩放比例
        // 重新读入图片，注意此时已经把options.inJustDecodeBounds 设回false了
        bitmap = BitmapFactory.decodeFile(srcPath, newOpts);
        return compressImage(bitmap);// 压缩好比例大小后再进行质量压缩
    }

    private Bitmap compressImage(Bitmap image) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.JPEG, 100, baos);// 质量压缩方法，这里100表示不压缩，把压缩后的数据存放到baos中
        int options = 100;
        while (baos.toByteArray().length / 1024 > 100) {  // 循环判断如果压缩后图片是否大于100kb,大于继续压缩
            baos.reset();// 重置baos即清空baos
            image.compress(Bitmap.CompressFormat.JPEG, options, baos);// 这里压缩options%，把压缩后的数据存放到baos中
            options -= 10;// 每次都减少10
        }
        ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());// 把压缩后的数据baos存放到ByteArrayInputStream中
        Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, null);// 把ByteArrayInputStream数据生成图片
        return bitmap;
    }
}
