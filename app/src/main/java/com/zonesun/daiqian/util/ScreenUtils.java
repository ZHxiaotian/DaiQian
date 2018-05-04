package com.zonesun.daiqian.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.DisplayMetrics;
import android.util.TypedValue;
/**
 * 此类里出了有像素的转换，还存在了一些截屏，将录制好的视频截屏一个BitMap的代码
 * @author Administrator
 *
 */
public class ScreenUtils {
	private static int screenW;
	private static int screenH;
	private static float screenDensity;

	public static void initScreen(Activity mActivity) {
		DisplayMetrics metric = new DisplayMetrics();
		mActivity.getWindowManager().getDefaultDisplay().getMetrics(metric);
		screenW = metric.widthPixels;
		screenH = metric.heightPixels;
		screenDensity = metric.density;
	}

	public static int getScreenW() {
		return screenW;
	}

	public static int getScreenH() {
		return screenH;
	}

	public static float getScreenDensity() {
		return screenDensity;
	}

	/** 根据手机的分辨率从 dp 的单位 转成为 px(像素) */
	public static int dp2px(float dpValue) {
		return (int) (dpValue * getScreenDensity() + 0.5f);
	}

	/** 根据手机的分辨率从 px(像素) 的单位 转成为 dp */
	public static int px2dp(float pxValue) {
		return (int) (pxValue / getScreenDensity() + 0.5f);
	}
	
    /**
     * 像素转换
     * @param dp
     * @param context
     * @return
     */
    public static int dpToPx(int dp, Context context) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
    }
    /**
     * 像素转换
     * @param sp
     * @param context
     * @return
     */
    public static int spToPx(int sp,Context context) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, context.getResources().getDisplayMetrics());
    }
    
    /**
    * 获取视频文件截图
    *
    * @param path 视频文件的路径
    * @return Bitmap 返回获取的Bitmap
    */
    public static Bitmap getVideoThumb(String path) {
    MediaMetadataRetriever media = new MediaMetadataRetriever();
    media.setDataSource(path);
    return media.getFrameAtTime();
    }
    /**
    * 获取视频文件缩略图 API>=8(2.2)
    *
    * @param path 视频文件的路径
    * @param kind 缩略图的分辨率：MINI_KIND、MICRO_KIND、FULL_SCREEN_KIND
    * @return Bitmap 返回获取的Bitmap
    */
    public static Bitmap getVideoThumb2(String path, int kind) {
    return ThumbnailUtils.createVideoThumbnail(path, kind);
    }
    public static Bitmap getVideoThumb2(String path) {
    return getVideoThumb2(path, MediaStore.Video.Thumbnails.FULL_SCREEN_KIND);
    }
    
    /**
    * Bitmap保存成File
    *
    * @param bitmap input bitmap
    * @param name output file's name
    * @return String output file's path
    */
    public static String bitmap2File(Bitmap bitmap, String name) {
    File f = new File(Environment.getExternalStorageDirectory() + name + ".jpg");
    if (f.exists()) f.delete();
    FileOutputStream fOut = null;
    try {
    fOut = new FileOutputStream(f);
    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fOut);
    fOut.flush();
    fOut.close();
    } catch (IOException e) {
    return null;
    }
    return f.getAbsolutePath();
    }
}
