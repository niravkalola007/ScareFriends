package com.example.niravkalola.scarefriends;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;


public class ScareActivity extends Activity {

//    private Bitmap image;
    private int sound;
//    private ImageView imagView;
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scare);
        Intent intent=getIntent();
        int image=intent.getIntExtra("image", 0);
        int  sound = intent.getIntExtra("sound", 0);

//        image = (Bitmap) intent.getParcelableExtra("image");
//        imagView= (ImageView) findViewById(R.id.imagView);
//        imagView.setImageBitmap(image);
//        if(mp!=null){
//            if(mp.isPlaying()){
//                mp.stop();
//            }
//        }
//        mp= MediaPlayer.create(this, sound);
//        mp.start();
        Toast.makeText(ScareActivity.this,image+""+sound,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(ScareActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
