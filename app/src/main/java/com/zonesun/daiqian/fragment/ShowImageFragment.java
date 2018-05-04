package com.zonesun.daiqian.fragment;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lidroid.xutils.BitmapUtils;
import com.zonesun.daiqian.activity.R;
import com.zonesun.daiqian.base.BaseFragment;
import com.zonesun.daiqian.util.Constants;

@SuppressLint({ "InflateParams", "ValidFragment" })
public class ShowImageFragment extends BaseFragment {

	private String url;
	private String flag;
	private int page;
	private int photototal;
	private String newadd;

	public ShowImageFragment(String url, String flag, int page, int photototal) {
		super();
		this.url = url;
		this.flag = flag;
		this.page = page;
		this.photototal = photototal;
	}

	public ShowImageFragment(String url, String flag, int page, int photototal,
			String newadd) {
		super();
		this.url = url;
		this.flag = flag;
		this.page = page;
		this.photototal = photototal;
		this.newadd = newadd;
	}

	private View view;
	private ImageView imageView;
	private TextView tv_page;
	private TextView tv_stext;

	@Override
	public View initView() {
		view = View.inflate(mActivity, R.layout.fragment_show_image, null);
		imageView = (ImageView) view.findViewById(R.id.iv);
		tv_page = (TextView) view.findViewById(R.id.tv_showImageActivity_page);
		tv_stext = (TextView) view.findViewById(R.id.tv_sphotoact);

		if (flag == "1") {

			BitmapUtils bitmapUtils = new BitmapUtils(mActivity);
			bitmapUtils.display(imageView, Constants.GETIMGURL + url);
			System.out.println("............." + Constants.GETIMGURL + url);
			tv_page.setText("当前为第" + page + "张/共" + photototal + "张");
		}
		if (flag == null) {

			if("新增".equals(newadd)){
				tv_stext.setVisibility(View.VISIBLE);
				tv_stext.setText("！新添加");
			}
			// Bitmap bitmap = BitmapFactory.decodeFile(url);
			// imageView.setImageBitmap(bitmap);
			BitmapUtils bitmapUtils = new BitmapUtils(mActivity);
			bitmapUtils.display(imageView, url);
			tv_page.setText("当前为第" + page + "张/共" + photototal + "张");

		}

		return view;
	}

}
