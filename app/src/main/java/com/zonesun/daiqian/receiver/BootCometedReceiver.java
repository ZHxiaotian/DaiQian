package com.zonesun.daiqian.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.zonesun.daiqian.activity.LoginActivity;

public class BootCometedReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		System.out.println("收到广播了");
		Toast.makeText(context, "收到广播了", Toast.LENGTH_SHORT).show();
		// TODO Auto-generated method stub
		if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) { // boot
			Intent intent2 = new Intent(context, LoginActivity.class);
			 intent2.setAction("android.intent.action.MAIN");
			 intent2.addCategory("android.intent.category.LAUNCHER");
			 intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			context.startActivity(intent2);
		}

	}
}