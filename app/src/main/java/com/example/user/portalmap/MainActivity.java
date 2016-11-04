package com.example.user.portalmap;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {

    public PortalManager pManager;

    public Button help, allPortal;
    public ImageView iView;
    public ScrollView sView;
    public HorizontalScrollView hSview;

    protected float drag_x = 0, drag_y = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("TEST", "create");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("TEST", "help");
        help = (Button) findViewById(R.id.help);
        Log.i("TEST", "all");
        allPortal = (Button) findViewById(R.id.all);
        Log.i("TEST", "map");
        iView = (ImageView) findViewById(R.id.map);

        sView = (ScrollView)findViewById(R.id.sView);
        hSview = (HorizontalScrollView)findViewById(R.id.hSview);

        iView.setOnTouchListener(new View.OnTouchListener(){

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Log.i("TEST", "rx : " +  motionEvent.getX() + hSview.getScrollX() + "  ry : "  + motionEvent.getY() + sView.getScrollY());

                return false;
            }
        });


        //데이터 관리
        new AsyncTask<Object, Object, Void>(){

            @Override
            protected Void doInBackground(Object... voids) {
                pManager = new PortalManager();
                return null;
            }
        };
        //
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}

