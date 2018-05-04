package com.zonesun.daiqian.util;

import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import com.zonesun.daiqian.activity.R;

import fr.bmartel.speedtest.SpeedTestReport;
import fr.bmartel.speedtest.SpeedTestSocket;
import fr.bmartel.speedtest.inter.ISpeedTestListener;
import fr.bmartel.speedtest.model.SpeedTestError;

public class IsNetWorkAvailable {

    private ConnectivityManager manager;
    private Context context1;

//    private Handler nethandler;

    /**
     * 检测网络是否连接
     */
    @SuppressWarnings("unused")
    public boolean checkNetWorkState(Context context) {
        this.context1 = context;

        boolean flag = false;
        manager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        // 去进行判断网络是否连接
        if (manager.getActiveNetworkInfo() != null) {
            flag = manager.getActiveNetworkInfo().isAvailable();

        }

        if (!flag) {
            setNetWork();
        }
        return flag;
    }

    /**
     * 网络未连接时 调用该方法
     */
    private void setNetWork() {
        Toast.makeText(context1, "wifi is closed", Toast.LENGTH_SHORT).show();

        AlertDialog.Builder builder = new AlertDialog.Builder(context1);
        builder.setIcon(R.drawable.ic_launcher);
        builder.setTitle("网络提示信息");
        builder.setMessage("网络连接不可用，如果继续，请先设置网络");
        builder.setPositiveButton("设置", new OnClickListener() {

            @Override
            public void onClick(DialogInterface arg0, int arg1) {

                Intent intent = null;
                /**
                 * 判断手机系统的版本！如果API大于10 就是3.0+ 因为3.0以上的版本的设置和3.0以下的设置不一样，调用的方法不同
                 */

                if (android.os.Build.VERSION.SDK_INT > 10) {
                    intent = new Intent(
                            android.provider.Settings.ACTION_WIFI_SETTINGS);

                } else {
                    intent = new Intent();
                    ComponentName componentName = new ComponentName(
                            "com.android.settings",
                            "com.android.settings.WirelessSettings");
                    intent.setComponent(componentName);
                    intent.setAction("android.intent.action.VIEW");

                }

                context1.startActivity(intent);

            }
        });

        builder.setNegativeButton("取消", new OnClickListener() {

            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                // TODO Auto-generated method stub

            }
        });

        builder.create().show();

    }

    /**
     * 对网络连接状态进行判断
     *
     * @return true, 可用； false， 不可用
     */
    public static boolean isOpenNetwork(Context context) {
        ConnectivityManager connManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connManager.getActiveNetworkInfo();
        boolean flag = false;
        if (networkInfo != null) {
            // 2.获取当前网络连接的类型信息
            int networkType = networkInfo.getType();
            if (ConnectivityManager.TYPE_WIFI == networkType) {
                flag = true;

            } else if (ConnectivityManager.TYPE_MOBILE == networkType) {
                flag = false;

            }

        }
        return flag;
    }


    public void getNetSpeed(final Handler handler) {

        final SpeedTestSocket speedTestSocket = new SpeedTestSocket();
//        speedTestSocket.setUploadSetupTime(5000);
        new Thread() {

            @Override
            public void run() {
                super.run();

                speedTestSocket.startUpload("http://2.testdebit.info/", 1000000);
            }
        }.start();
// add a listener to wait for speedtest completion and progress
        speedTestSocket.addSpeedTestListener(new ISpeedTestListener() {

//            @Override
//            public void onDownloadFinished(SpeedTestReport report) {
//                // called when download is finished
//                System.out.println("[DL FINISHED] rate in octet/s : " + report.getTransferRateOctet());
//                System.out.println("[DL FINISHED] rate in bit/s   : " + report.getTransferRateBit());
//            }
//
//             @Override
//            public void onDownloadError(SpeedTestError speedTestError, String errorMessage) {
//                // called when a download error occur
//
//            }
//
//            @Override
//            public void onUploadFinished(SpeedTestReport report) {
//                // called when an upload is finished
//                System.out.println("[UL FINISHED] rate in octet/s : " + report.getTransferRateOctet());
//                System.out.println("[UL FINISHED] rate in bit/s   : " + report.getTransferRateBit());
//            }
//
//            @Override
//            public void onUploadError(SpeedTestError speedTestError, String errorMessage) {
//                // called when an upload error occur
//            }
//
//            @Override
//            public void onDownloadProgress(float percent, SpeedTestReport report) {
//                // called to notify download progress
//                System.out.println("[DL PROGRESS] progress : " + percent + "%");
//                System.out.println("[DL PROGRESS] rate in octet/s : " + report.getTransferRateOctet());
//                System.out.println("[DL PROGRESS] rate in bit/s   : " + report.getTransferRateBit());
//            }
//
//            @Override
//            public void onUploadProgress(float percent, SpeedTestReport report) {
//                // called to notify upload progress
//                System.out.println("[UL PROGRESS] progress : " + percent + "%");
//                System.out.println("[UL PROGRESS] rate in octet/s : " + report.getTransferRateOctet());
//                System.out.println("[UL PROGRESS] rate in bit/s   : " + report.getTransferRateBit());
//
//                if((int)percent==100){
//
//                   long speed=report.getTransferRateBit().longValue()/1024;
//
//                    if(((int)speed)<20){
//
//                        Message msg=new Message();
//                        msg.obj=false;
//                        handler.sendMessage(msg);
//                    }else{
//                        Message msg=new Message();
//                        msg.obj=true;
//                        handler.sendMessage(msg);
//                    }
//
//                }else if(((int)percent)%5==0){
//                    Message msg=new Message();
//                    msg.what=1;
//                    handler.sendMessage(msg);
//                }
//            }

            @Override
            public void onCompletion(SpeedTestReport report) {
                System.out.println("[UL PROGRESS] rate in octet/s : " + report.getTransferRateOctet());
                System.out.println("[UL PROGRESS] rate in bit/s   : " + report.getTransferRateBit());
//                long speed=report.getTransferRateBit().longValue()/1024;
//
//                    if(((int)speed)<20){
//
//                        Message msg=new Message();
//                        msg.obj=false;
//                        handler.sendMessage(msg);
//                    }else{
//                        Message msg=new Message();
//                        msg.obj=true;
//                        handler.sendMessage(msg);
//                    }
            }

            @Override
            public void onProgress(float percent, SpeedTestReport report) {
//                 called to notify upload progress
                System.out.println("[UL PROGRESS] progress : " + percent + "%");
                System.out.println("[UL PROGRESS] rate in octet/s : " + report.getTransferRateOctet());
                System.out.println("[UL PROGRESS] rate in bit/s   : " + report.getTransferRateBit());
//
                if ((int) percent == 6) {

                    long speed = report.getTransferRateBit().longValue() / 1024;

                    if (((int) speed) < 20) {

                        Message msg = new Message();
                        msg.obj = false;
                        handler.sendMessage(msg);
                    } else {
                        Message msg = new Message();
                        msg.obj = true;
                        handler.sendMessage(msg);
                    }

                }
            }

            @Override
            public void onError(SpeedTestError speedTestError, String errorMessage) {

                System.out.println(errorMessage);
            }

            @Override
            public void onInterruption() {
                // triggered when forceStopTask is called
            }
        });

    }


}
