package com.zonesun.daiqian.util;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.TextView;

public class MyFocusChangeListener implements OnFocusChangeListener {

	private TextView edit;

	public MyFocusChangeListener(TextView edit) {
		super();
		this.edit = edit;
	}
                         
	/*
	 * 监听EditText把用户输入的资金额全部加.00; (non-Javadoc)
	 * 
	 * @see
	 * android.view.View.OnFocusChangeListener#onFocusChange(android.view.View,
	 * boolean)
	 */
	@Override
	public void onFocusChange(View v, boolean hasFocus) {

		if (!hasFocus) {

			String str = edit.getText().toString();

			if (str.contains(".")) {
				int length = str.length();
				int index = str.indexOf(".");
				int len = length - index;

				if (len <= 2) {

					edit.setText(str + "0");
				} else {

					return;

				}

			} else if (null!=str&&(!"".equals(str))) {
				edit.setText(str + ".00");
			}

			else {
				edit.setText("");
			}
		}

	}

}
