package com.zonesun.daiqian.activity;

import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.PixelFormat;
import android.hardware.Camera;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.media.MediaRecorder.OnErrorListener;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.Settings;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.zonesun.daiqian.util.CirclePercentView;

public class RecordVideoActivity extends Activity implements
		Callback {
	private SharedPreferences sp;
	Editor editor;
	String name;
	private CirclePercentView record_button;// 停止录制按钮
	private MediaRecorder mediaRecorder;// 录制视频的类
	private SurfaceView surfaceview;// 显示视频的控件
	private MediaPlayer player;// 播放视频的控件
	// 用来显示视频的一个接口，我靠不用还不行，也就是说用mediarecorder录制视频还得给个界面看
	// 想偷偷录视频的同学可以考虑别的办法。。嗯需要实现这个接口的Callback接口
	private SurfaceHolder surfaceHolder;
	private TextView tv;
	private int mRecordMaxTime = 62;// 一次拍摄最长时间
	private Camera mCamera;
	private Timer mTimer;// 计时器
	private int mTimeCount;// 时间计数

	private String mp4Path;
	private File mRecordFile = null;// 文件
	private boolean is_show = false;
	private String path;
	private Timer mTimer1;

	private int mRecordtime;

	Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			if (!is_show) {
				showOpenCameraDialog();
			}
			is_show = !is_show;
		};
	};

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 去掉标题栏

		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);// 设置全屏
		// 设置横屏显示
		// setRequestedOrientation(ActivityInfo.S);
		// 选择支持半透明模式,在有surfaceview的activity中使用。
		getWindow().setFormat(PixelFormat.TRANSLUCENT);
		setContentView(R.layout.activity_recordvideo);
		init();
		initCamera();
	}

	@SuppressWarnings("deprecation")
	private void init() {
		name = getIntent().getStringExtra("name");// 获取申请人的名字让它来作为存储Video路径的sp键；
		sp = getSharedPreferences("video_url", MODE_PRIVATE);
		editor = sp.edit();
		tv = (TextView) findViewById(R.id.tv);
		surfaceview = (SurfaceView) this.findViewById(R.id.surfaceview);
		surfaceHolder = surfaceview.getHolder();// 取得holder
		// setType必须设置，要不出错
		surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
		surfaceHolder.setFixedSize(1280, 800); // 设置Surface分辨率
		surfaceHolder.setKeepScreenOn(true);// 屏幕常亮
		surfaceHolder.addCallback(new CustomCallBack()); // holder加入回调接口

		record_button = (CirclePercentView) findViewById(R.id.record_button);
		record_button.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					createRecordDir();
					startRecord();
					mTimer1 = new Timer();
					mTimer1.schedule(new TimerTask() {

						@Override
						public void run() {
							mRecordtime++;

							runOnUiThread(new Runnable() {

								@Override
								public void run() {
									// TODO Auto-generated method stub
									tv.setText(mRecordtime + "秒");
								}
							});
							record_button.setPercent(mRecordtime);
						}

					}, 0, 1000);
					// up_vdioe.setVisibility(View.INVISIBLE);

				}
				if (event.getAction() == MotionEvent.ACTION_CANCEL) {
					if (mRecordtime != 0) {
						mRecordtime = 0;
						record_button.setPercent(mRecordtime);
					}
					stopRecord();
					initCamera();
				} else if (event.getAction() == MotionEvent.ACTION_UP) {
					if (getTimeCount() > 1) {
						mRecordtime = 0;
						record_button.setPercent(mRecordtime);
						Toast toast = Toast.makeText(RecordVideoActivity.this,
								"保存中", Toast.LENGTH_LONG);

						toast.setGravity(Gravity.CENTER, 0, 0);
						toast.show();
						stopRecord();
						tv.setText("长按录像,松开录制完成,录制时间必须三秒以上");
						
						// Intent intent = new Intent(RecordVideoActivity.this,
						// PlayerActivity.class);
						// intent.putExtra("path", path);
						// startActivity(intent);//跳转到视频播放界面用来查看刚录制好的视频

						// 录制完成后视频直接上传用Xutils上传视频前提是判断当前的网络环境

						editor.putString(name, path);
						editor.commit();
						Intent intent = new Intent();
						intent.putExtra("mvpath", path);
						setResult(11,intent);
						finish();

						// up_vdioe.setVisibility(View.VISIBLE);
					} else {
						if (getmRecordFile().length() == 0) {
							stopRecord();
							initCamera();
							getmRecordFile().delete();
							mRecordFile.delete();
							ProgressBar();

						} else {
							mRecordtime = 0;
							record_button.setPercent(mRecordtime);
							getmRecordFile().delete();
							mRecordFile.delete();
							stopRecord();
							initCamera();
							Toast.makeText(RecordVideoActivity.this,
									"视频录制时间太短", Toast.LENGTH_SHORT).show();
						}
					}
				}
				return true;
			}
		});

		// up_vdioe.setOnClickListener(new OnClickListener() {
		//
		// @Override
		// public void onClick(View arg0) {
		// System.out.println("视频路径：mp4Path==" + mp4Path);
		// System.out.println("视频路径2：mp4Path=="
		// + mRecordFile.getAbsolutePath());
		// System.out.println("视频时长：mp4Path==" + getTimeCount());
		//
		// // 返回到播放页面
		//
		// }
		// // });
		// findViewById(R.id.iv_return).setOnClickListener(new OnClickListener()
		// {
		//
		// @Override
		// public void onClick(View arg0) {
		// stopRecord();
		// Toast.makeText(MainActivity.this, "暂未开放", Toast.LENGTH_SHORT)
		// .show();
		// }
		// });
		boolean b = getCameraInstance();
		System.out.println("相机权限是否开启：：==" + b);
		if (!b) {
			showOpenCameraDialog();
		}
	}

	private void ProgressBar() {
		mTimeCount = 0;// 时间计数器重新赋值
		mTimer = new Timer();
		mTimer.schedule(new TimerTask() {

			@Override
			public void run() {
				mTimeCount++;
				if (mTimeCount > 0) {
					if (getmRecordFile().length() == 0) {
						stopRecord();
						initCamera();
						getmRecordFile().delete();
						mRecordFile.delete();
						// handler.sendEmptyMessage(0);
					}
				}
				if (mRecordtime > 2) {
					if (getmRecordFile().length() == 0) {
						stopRecord();
						initCamera();
						getmRecordFile().delete();
						mRecordFile.delete();
						handler.sendEmptyMessage(0);
					}
				}

				if (mTimeCount == mRecordMaxTime) {// 达到指定时间，停止拍摄
					stopRecord();
				}
			}
		}, 0, 1000);
	}

	private void startRecord() {
		mediaRecorder = new MediaRecorder();// 创建mediarecorder对象
		mediaRecorder.reset();
		if (mCamera != null) {
			mediaRecorder.setCamera(mCamera);// 设置录制视频源为Camera(相机)
		} else {
			try {
				initCamera();
				mediaRecorder.setCamera(mCamera);// 设置录制视频源为Camera(相机)
			} catch (Exception e) {
				e.printStackTrace();
				showOpenCameraDialog();
			}
		}
		// 设置音频录入源
		try {
			mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
		} catch (Exception e) {
			e.printStackTrace();
			// showOpenCameraDialog();
		}
		try {

			mediaRecorder.setVideoSource(MediaRecorder.VideoSource.CAMERA); // 设置视频图像的录入源

			// 设置录制完成后视频的封装格式THREE_GPP为3gp.MPEG_4为mp4
			mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
			mediaRecorder.setVideoEncoder(MediaRecorder.VideoEncoder.H264);// 设置录制的视频编码h263
																			// h264ccc
		} catch (Exception e) {
			e.printStackTrace();
			showOpenCameraDialog();
		}
		try {
			mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC); // 设置音频的编码格式
		} catch (Exception e) {
			e.printStackTrace();
			// showOpenCameraDialog();
		}
		try {
			// 设置视频录制的分辨率。必须放在设置编码和格式的后面，否则报错
			mediaRecorder.setVideoEncodingBitRate(1 * 800 * 1080);
			mediaRecorder.setVideoSize(640, 480);
			// 设置录制的视频帧率。必须放在设置编码和格式的后面，否则报错
			// mediaRecorder.setVideoFrameRate(4);
			mediaRecorder.setPreviewDisplay(surfaceHolder.getSurface());// 设置捕获视频图像的预览界面
		} catch (Exception e) {
		}
		// 设置视频文件输出的路径
		if (mCamera != null) {

			try {
				// mediaRecorder.setOrientationHint(90);// 输出旋转90度，保持竖屏录制
			} catch (Exception e) {

			}
		}
		mp4Path = mRecordFile.getAbsolutePath();
		path = mp4Path;
		// GLobleData.VideoPath=mp4Path;
		try {
			mediaRecorder.setOutputFile(mp4Path); // 设置视频文件输出的路径
		} catch (Exception e) {
		}
		System.out.println(" 录制视频地址==" + mp4Path);

		mediaRecorder.setOnErrorListener(new OnErrorListener() {

			@Override
			public void onError(MediaRecorder mr, int what, int extra) {
				// 发生错误，停止录制
				mediaRecorder.stop();
				mediaRecorder.release();
				mediaRecorder = null;
				Toast.makeText(RecordVideoActivity.this, "录制出错",
						Toast.LENGTH_LONG).show();
			}
		});
		try {
			mediaRecorder.prepare();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			mediaRecorder.start(); // 开始录制
		} catch (Exception e) {
			e.printStackTrace();
			showOpenCameraDialog();
		}
		ProgressBar();
	}

	public void stopRecord() {

		if (mTimer != null)
			mTimer.cancel();
		if (mTimer1 != null) {
			mTimer1.cancel();
		}
		if (mediaRecorder != null) {
			// 设置后不会崩
			mediaRecorder.setOnErrorListener(null);
			mediaRecorder.setPreviewDisplay(null);
			try {
				mediaRecorder.stop();
				// 释放资源

			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (RuntimeException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				mediaRecorder.release();

			} catch (Exception e) {
			}
			try {
				mediaRecorder = null;

			} catch (Exception e) {
			}
			try {
				freeCameraResource();
			} catch (Exception e) {
			}
		}
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// 将holder，这个holder为开始在oncreat里面取得的holder，将它赋给surfaceHolder
		surfaceHolder = holder;
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// 将holder，这个holder为开始在oncreat里面取得的holder，将它赋给surfaceHolder
		surfaceHolder = holder;
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// surfaceDestroyed的时候同时对象设置为null
		surfaceview = null;
		surfaceHolder = null;
		mediaRecorder = null;
	}

	public int getTimeCount() {
		return mTimeCount;
	}

	/**
	 * @return the mVecordFile
	 */
	public File getmRecordFile() {
		return mRecordFile;
	}

	private void createRecordDir() {
		/*
		 * Environment. getExternalStorageDirectory ()+ File.separator +
		 * "im/video/"
		 */
		File sampleDir = new File(Environment.getExternalStorageDirectory()
				+ "/" + "dq" + "/");
		if (!sampleDir.exists()) {
			sampleDir.mkdirs();
		}
		File vecordDir = sampleDir;
		// 创建文件
		try {
			mRecordFile = new File(vecordDir, "recording"
					+ System.currentTimeMillis() + ".mp4");
			mRecordFile.createNewFile();
		} catch (IOException e) {
		}
	}

	/**
	 * 删除单个文件
	 * 
	 * @param filePath
	 *            被删除文件的文件名
	 * @return 文件删除成功返回true，否则返回false
	 */
	public boolean deleteFile(String filePath) {
		File file = new File(filePath);
		if (file.isFile() && file.exists()) {
			return file.delete();
		}
		return false;
	}

	/**
	 * 初始化摄像头
	 * 
	 * @date 2015-2-5
	 * @throws IOException
	 */
	@SuppressLint("NewApi")
	private void initCamera() {
		if (mCamera != null) {
			freeCameraResource();
		}
		try {
			mCamera = Camera.open();
			Camera.Parameters parameters = mCamera.getParameters();
			parameters.setRotation(90);
			mCamera.setParameters(parameters);
		} catch (Exception e) {
			e.printStackTrace();
			freeCameraResource();
		}
		if (mCamera == null)
			return;
		try {
			mCamera.setDisplayOrientation(90);
			mCamera.setPreviewDisplay(surfaceHolder);
			mCamera.startPreview();
			mCamera.unlock();// 解锁
		} catch (Exception e) {
			e.printStackTrace();
			handler.sendEmptyMessage(0);
		}
	}

	/**
	 * 释放摄像头资源
	 * 
	 * @date 2015-2-5
	 */
	private void freeCameraResource() {
		if (mCamera != null) {
			try {
				mCamera.setPreviewCallback(null);

			} catch (Exception e) {
			}
			try {
				mCamera.stopPreview();

			} catch (Exception e) {
			}
			try {
				mCamera.lock();

			} catch (Exception e) {
			}
			try {
				mCamera.release();

			} catch (Exception e) {
			}
			try {
				mCamera = null;
			} catch (Exception e) {
			}
		}
	}

	private class CustomCallBack implements Callback {

		@Override
		public void surfaceCreated(SurfaceHolder holder) {
			// if (!isOpenCamera)
			// return;
			initCamera();
		}

		@Override
		public void surfaceChanged(SurfaceHolder holder, int format, int width,
				int height) {

		}

		@Override
		public void surfaceDestroyed(SurfaceHolder holder) {
			// if (!isOpenCamera)
			// return;
			// freeCameraResource();
		}
	}

	public boolean getCameraInstance() {
		Camera c = null;
		try {
			c = Camera.open();
		} catch (Exception e) {
			return false;
		} finally {
			if (c != null) {
				c.release();
				c = null;
			}
		}
		return true;
	}

	public void showOpenCameraDialog() {
		AlertDialog.Builder builer = new AlertDialog.Builder(this);
		builer.setTitle("温馨提示");
		builer.setMessage("请在应用权限设置里面手动打开拍照和录音权限");
		builer.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Intent intent = new Intent(Settings.ACTION_SETTINGS);
				startActivity(intent);
				dialog.dismiss();
			}
		});
		builer.setCancelable(false);
		AlertDialog dialog = builer.create();
		dialog.show();
	}

	@Override
	protected void onDestroy() {
		stopRecord();
		freeCameraResource();
		if (mTimer != null)
			mTimer.cancel();
		if (mTimer1 != null) {
			mTimer1.cancel();
		}
		super.onDestroy();
	}
}
