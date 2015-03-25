package com.example.niravkalola.scarefriends;

import android.app.Activity;
import android.graphics.Bitmap;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;


public class MainActivity extends Activity {

    private Spinner spinnerImage,spinnerTime,spinnerSound;
    private Button btnStart,rateThisApp;
    public static Bitmap imageResBitmap;
    public static int soundResId;
    public static int timeMiliSec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        spinnerImage= (Spinner) findViewById(R.id.spinnerImage);
        spinnerTime= (Spinner) findViewById(R.id.spinnerTime);
        spinnerSound= (Spinner) findViewById(R.id.spinnerSound);
        btnStart= (Button) findViewById(R.id.btnStart);
        rateThisApp= (Button) findViewById(R.id.rateThisApp);
        LinkedList linkedlist = new LinkedList();
        linkedlist.add(new SpinnerImageEntry("Classic", R.drawable.scary1, getResources()));
        linkedlist.add(new SpinnerImageEntry("Big mouth", R.drawable.scary2, getResources()));
        linkedlist.add(new SpinnerImageEntry("Angry dog", R.drawable.scary3, getResources()));
        linkedlist.add(new SpinnerImageEntry("Big mouth 2", R.drawable.scary4, getResources()));
        linkedlist.add(new SpinnerImageEntry("Child", R.drawable.scary5, getResources()));
        linkedlist.add(new SpinnerImageEntry("Dr House", R.drawable.scary6, getResources()));
        linkedlist.add(new SpinnerImageEntry("Clown", R.drawable.scary7, getResources()));
        linkedlist.add(new SpinnerImageEntry("Blind", R.drawable.scary8, getResources()));
        linkedlist.add(new SpinnerImageEntry("Real scary", R.drawable.scary9, getResources()));
        spinnerImage.setAdapter(new ImageSpinnerAdapter(linkedlist, this));
        spinnerImage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                MainActivity.imageResBitmap = ((SpinnerImageEntry) parent.getItemAtPosition(position)).getImage();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter arrayadapter1 = ArrayAdapter.createFromResource(MainActivity.this,R.array.sound,android.R.layout.simple_spinner_item);
        arrayadapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSound.setAdapter(arrayadapter1);
        spinnerSound.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String s = (String)parent.getItemAtPosition(position);
                MainActivity.soundResId = getResources().getIdentifier((new StringBuilder("scary_sound")).append(s.split(" ")[2]).toString(), "raw", getPackageName());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter arrayadapter = ArrayAdapter.createFromResource(this, R.array.time, android.R.layout.simple_spinner_item);
        arrayadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTime.setAdapter(arrayadapter);
        spinnerTime.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int j = (new Integer(((String)parent.getItemAtPosition(position)).split(" ")[0])).intValue();
                MainActivity.timeMiliSec = 1000 * (j * 60);
                if (j == 15)
                {
                    MainActivity.timeMiliSec = 15000;
                } else
                if (j == 30)
                {
                    MainActivity     .timeMiliSec = 30000;
                    return;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void playSound(View view)
    {
//        MusicManager.playSound(getApplicationContext(), soundResId);
    }


    public class ImageSpinnerAdapter extends BaseAdapter
            implements SpinnerAdapter
    {

        private final Activity activity;
        private final List content;

        public ImageSpinnerAdapter(List list, Activity activity1)
        {
            content = list;
            activity = activity1;
        }

        public int getCount()
        {
            return content.size();
        }

        public Object getItem(int i)
        {
            return content.get(i);
        }

        public long getItemId(int i)
        {
            return (long)i;
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            View view1 = activity.getLayoutInflater().inflate(R.layout.spinner_entry_with_icon, null);
            TextView textview = (TextView)view1.findViewById(R.id.spinnerTextEntry);
            ImageView imageview = (ImageView)view1.findViewById(R.id.spinnerImageEntry);
            SpinnerImageEntry spinnerimageentry = (SpinnerImageEntry)content.get(i);
            textview.setText(spinnerimageentry.getText());
            imageview.setImageBitmap(spinnerimageentry.getImage());
            return view1;
        }
    }
}
