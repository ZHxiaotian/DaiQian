package bypay.living.activity;

import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.living.activity.hxcr.biz.AsyncGwBiz;
import com.living.activity.hxcr.sax.SaxData.GwBiz;
import com.living.activity.hxcr.util.Info;
import com.living.activity.hxcr.util.Living_Interface;
import com.living.activity.hxcr.util.Util;
import com.living.activity.hxcr.util.Utils;
import com.living.activity.hxcr.util.ViewUtil;
import com.zhengtong.activity.open.BaseActivity;
import com.zhengtong.util.IConents;
import com.zhengtong.utils.Base64;

public class VoidResultActivity extends BaseActivity implements
		Living_Interface {
	private RelativeLayout select_city_title = null;
	private TextView back_text = null, myaccount_header_title_tv = null;
	private ImageView result_img = null, user_img = null;
	private TextView outcome = null, result_fraction = null;
	private Button bt_next_mobilePay = null;
	private boolean fal = false;
	private int sex = 0;


	@Override
	protected void doOnCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		setContentView(mResource.getLayoutIdByName("activity_void_result"));
		Info.currentActivity = this;
		Info.currentContext = this;
		initView();
	}

	private void initView() {
		select_city_title = (RelativeLayout) findViewById(mResource
				.getIdByName("select_city_title"));
		back_text = (TextView) select_city_title.findViewById(ViewUtil
				.getResourseIdByName(getApplicationContext().getPackageName(),
						"id", "back_text"));// 标题栏返回按钮
		myaccount_header_title_tv = (TextView) select_city_title
				.findViewById(ViewUtil.getResourseIdByName(
						getApplicationContext().getPackageName(), "id",
						"myaccount_header_title_tv"));
		myaccount_header_title_tv.setText("视频人像对比认证");
		back_text.setVisibility(View.INVISIBLE);

		result_img = (ImageView) findViewById(mResource
				.getIdByName("result_img"));
		outcome = (TextView) findViewById(mResource.getIdByName("outcome"));
		result_fraction = (TextView) findViewById(mResource
				.getIdByName("result_fraction"));
		bt_next_mobilePay = (Button) findViewById(mResource
				.getIdByName("bt_next_mobilePay"));
		user_img = (ImageView) findViewById(mResource.getIdByName("user_img"));

		if (userInfo.getCertseq() != null
				&& !userInfo.getCertseq().equals("")
				&& (userInfo.getCertseq().length() == 15 || userInfo
						.getCertseq().length() == 18)) {
			sex = Integer.parseInt(userInfo.getCertseq().substring(
					userInfo.getCertseq().length() - 2,
					userInfo.getCertseq().length() - 1));
		}

		if (getIntent().getBooleanExtra(IConents.CONFIG.ISFAKEBODY, false)) {
			try {
				userInfo.setFaceImgCaptureFile(new String(Base64
						.encode(getIntent().getByteArrayExtra("YTHT")), "utf-8"));
				Util.showLoadingDialog("请稍后");
				new AsyncGwBiz("11008076", "100050", Utils.getSendTime(),
						userInfo.getUsernm(), "", userInfo.getCertseq(), "",
						userInfo.getFaceImgCaptureFile(), this);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			imgUpdate(false, sex);
			/**
			 * 修改时间 2015/08/16 16:23 注释之前的活体检测错误结果提示 新的SDK中活体检测错误结果提示
			 * 发给券商前需要再次确认活体错误结果提示
			 */
			fal = false;
			outcome.setText("认证失败");
			result_fraction.setText("视频检测失败，请根据动作提示重新尝试");
			bt_next_mobilePay.setText("重新自助认证");
		}

		bt_next_mobilePay.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				onBackPressed();
			}
		});
	}

	public void onBackPressed() {
		if (fal) {
			setResult(2);
			finish();
			System.out.println("--------------------成功了啦啦啦啦啦");
		} else {
			setResult(RESULT_OK);
			finish();
			System.out.println("------------------------------是不是都是失败");
		}
	}

	private void imgUpdate(boolean fal, int sex) {
		if (sex % 2 == 0) {
			if (fal) {
				result_img.setImageResource(mResource
						.getDrawableIdByName("app_ui_expression_icon3"));

				user_img.setVisibility(View.VISIBLE);
				user_img.setImageBitmap(BitmapFactory.decodeByteArray(
						getIntent().getByteArrayExtra("YTHT"), 0, getIntent()
								.getByteArrayExtra("YTHT").length));
			} else {
				result_img.setImageResource(mResource
						.getDrawableIdByName("app_ui_expression_icon1"));
			}
		} else {
			if (fal) {
				result_img.setImageResource(mResource
						.getDrawableIdByName("app_ui_expression_icon4"));

				user_img.setVisibility(View.VISIBLE);
				user_img.setImageBitmap(BitmapFactory.decodeByteArray(
						getIntent().getByteArrayExtra("YTHT"), 0, getIntent()
								.getByteArrayExtra("YTHT").length));
			} else {
				result_img.setImageResource(mResource
						.getDrawableIdByName("app_ui_expression_icon2"));
			}
		}
		result_img.setVisibility(View.VISIBLE);
	}

	public void update(GwBiz gwBiz, String text) {
		if (gwBiz == null) {
			fal = false;
			imgUpdate(fal, sex);
			outcome.setText("认证失败");
			result_fraction.setText(text);
			bt_next_mobilePay.setText("重新自助认证");
		} else if (gwBiz.getRespCode().equals("0000")) {
			fal = true;
			imgUpdate(fal, sex);
			outcome.setText("认证成功");
			outcome.setTextColor(Color.rgb(36, 178, 0));
			result_fraction.setText("相似度 ：" + gwBiz.getResultXpFs() + "%");
			bt_next_mobilePay.setText("完成");
		} else {
			fal = false;
			imgUpdate(fal, sex);
			outcome.setText("认证失败");
			result_fraction.setText(gwBiz.getRespDesc());
			bt_next_mobilePay.setText("重新自助认证");
		}
	}

	@Override
	public void returnResult() {

		
	}

}
