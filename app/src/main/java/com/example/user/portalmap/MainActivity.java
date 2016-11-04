package com.example.user.portalmap;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public PortalManager pManager;
    public BuildingManager bManager;

    public Button help, allPortal;
    public ImageView iView;
    public ScrollView sView;
    public HorizontalScrollView hSview;
    public FrameLayout fl;

    protected float drag_x = 0, drag_y = 0;

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        Log.i("TEST", "create");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //데이터 관리
        new AsyncTask<Object, Object, Void>(){

            @Override
            protected Void doInBackground(Object... voids) {
                pManager = new PortalManager();
                bManager = new BuildingManager();
                return null;
            }
        }.execute();
        //

        Log.i("TEST", "help");
        help = (Button) findViewById(R.id.help);
        Log.i("TEST", "all");
        allPortal = (Button) findViewById(R.id.all);
        Log.i("TEST", "map");
        iView = (ImageView) findViewById(R.id.map);

        sView = (ScrollView)findViewById(R.id.sView);
        hSview = (HorizontalScrollView)findViewById(R.id.hSview);
        fl = (FrameLayout) findViewById(R.id.fLayout);
        final MainActivity ma = this;
        //데이터 관리
        new AsyncTask<Object, Object, Void>(){

            @Override
            protected Void doInBackground(Object... voids) {
                pManager.addButton(0, 160, 900, 280, 835, ma, fl);
                pManager.addButton(1, 280, 835, 254, 733, ma, fl);
                pManager.addButton(2, 254, 733, 335, 630, ma, fl);
                pManager.addButton(3, 364, 836, 333, 777, ma, fl);
                pManager.addButton(4, 721, 666, 664, 581, ma, fl);
//re
                pManager.addButton(5, 972, 724, 932, 515, ma, fl);
                pManager.addButton(6, 972, 724, 1068, 560, ma, fl);
                pManager.addButton(7, 758, 552, 981, 498, ma, fl);
                pManager.addButton(8, 758, 552, 916, 262, ma, fl);
                pManager.addButton(9, 981, 498, 916, 262, ma, fl);

                return null;
            }
        }.execute();
        //

        iView.setOnTouchListener(new View.OnTouchListener(){

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int x = (int)motionEvent.getX();
                int y = (int)motionEvent.getY();
                Log.i("TEST", "rx : " +  x + "  ry : "  + y);
                boolean building = false;
                for (int i = 0; i < bManager.bData.length; i++){
                    if ((bManager.bData[i].x1 <= x && x <= bManager.bData[i].x2) && (bManager.bData[i].y1 <= y && y <= bManager.bData[i].y2)){
                        //TODO: 건물 터치됬을 경우
                        Toast.makeText(MainActivity.this, bManager.bData[i].code+"관을 눌렀어요 헤헤", Toast.LENGTH_SHORT).show();
                        Log.i("TEST", "touched : " + bManager.bData[i].code);
                        building = true;
                        break;
                    }
                }
                if (!building){
                    Toast.makeText(MainActivity.this, "거긴 포탈이 없어요 헿", Toast.LENGTH_SHORT).show();
                }

                return false;
            }
        });

    }

    public void showHelp(View v){
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("설명");
        alertDialog.setMessage("건물을 클릭하면 연결되어 있는 포탈이 드러납니다. 찾는 재미가 쏠쏠~(라라솔솔미솔솔미미레)");
        alertDialog.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface/*자기자신*/, int i) {
                dialogInterface.dismiss();
            }
        });
        alertDialog.show();
    }


    @Override
    protected void onResume() {
        super.onResume();
    }
}

