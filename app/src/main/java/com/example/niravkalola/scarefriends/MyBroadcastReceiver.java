package com.example.niravkalola.scarefriends;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;


public class MyBroadcastReceiver extends BroadcastReceiver {

	private Context context;
	@Override
	public void onReceive(Context context, final Intent intent) {
		this.context=context;
		Bundle bundle = intent.getExtras();
		int image=bundle.getInt("image");
		int  sound = bundle.getInt("sound");
//		Log.e("bitmap", image+"");
		// Vibrate the mobile phone
//		Vibrator vibrator = (Vibrator) context
//				.getSystemService(Context.VIBRATOR_SERVICE);
//		vibrator.vibrate(2000);

		Intent trIntent = new Intent("android.intent.action.MAIN");
		intent.putExtra("image", image);
		intent.putExtra("sound",sound);
		trIntent.setClass(context, ScareActivity.class);
		trIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);



		context.startActivity(trIntent);
//		mMediaPlayer = MediaPlayer.create(context, R.raw.ringtone);
//		mMediaPlayer.setLooping(true);
//		mMediaPlayer.start();
	}
}
