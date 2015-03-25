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

import java.util.ArrayList;


public class ScareActivity extends Activity {

//    private Bitmap image;
    private int sound;
    private int soundId;
    private ImageView imagView;
    MediaPlayer mp;
    private ArrayList<Integer> imageList;
    private ArrayList<String> soundList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scare);
        Intent intent=getIntent();
        int image=intent.getIntExtra("image", 0);
        int  sound = intent.getIntExtra("sound", 0);

//        image = (Bitmap) intent.getParcelableExtra("image");
        imagView= (ImageView) findViewById(R.id.imagView);
//        imagView.setImageBitmap(image);
        soundList=new ArrayList<>();

        soundList.add("exorcist sound 1");
        soundList.add("woman scream 2");
        soundList.add("woman short 3");
        soundList.add("man scream 4");
        soundList.add("cyber scream 5");
        soundList.add("man light 6");

        imageList=new ArrayList<>();
        imageList.add(R.drawable.scary1);
        imageList.add(R.drawable.scary2);
        imageList.add(R.drawable.scary3);
        imageList.add(R.drawable.scary4);
        imageList.add(R.drawable.scary5);
        imageList.add(R.drawable.scary6);
        imageList.add(R.drawable.scary7);
        imageList.add(R.drawable.scary8);
        imageList.add(R.drawable.scary9);

        imagView.setImageResource(imageList.get(image));
        soundId= getResources().getIdentifier((new StringBuilder("scary_sound")).append(soundList.get(sound).split(" ")[2]).toString(), "raw", getPackageName());
        if(mp!=null){
            if(mp.isPlaying()){
                mp.stop();
            }
        }
        mp= MediaPlayer.create(this, soundId);
        mp.start();
//        Toast.makeText(ScareActivity.this,image+""+sound,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(ScareActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
