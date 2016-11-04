package com.example.user.portalmap;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Matrix;
import android.text.Layout;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.HashMap;

/**
 * Created by user on 2016-11-04.
 */

public class PortalManager {

    //포탈 데이터
    public HashMap<Integer, PortalData> portalData;
    //포탈 버튼
    public HashMap<Integer, ImageButton> portalButtons;

    public PortalManager(){

        portalData = new HashMap<>();
        portalButtons = new HashMap<>();

        //알엔디 > 간호대
        addData(0, 102, 2, 103, 2, PortalData.TYPE_WALK);

        //간호대 > 의대
        addData(1, 103, 3, 105, 1, PortalData.TYPE_WALK);

        //의대 > 제2의대
        addData(2, 105, 4, 106, 4, PortalData.TYPE_WALK);

        //자연과학대 1층 > 3층 : 계단대신
        addData(3, 104, 1, 104, 3, PortalData.TYPE_ELEVATOR);
        //서라벌호 2층 > 4층 : 계단대신
        addData(4, 203, 2, 203, 4, PortalData.TYPE_ELEVATOR);
        //법학관 지하1층 > 동판CAU쪽
        addData(5, 303, -1, 303, 3, PortalData.TYPE_ELEVATOR);
        //법학관 지하1층 > 후문쪽
        addData(6, 303, -1, 303, 6, PortalData.TYPE_ELEVATOR);
        //310관 지하 5층 > 동판CAU쪽
        addData(7, 310, -5, 310, -3, PortalData.TYPE_ELEVATOR);
        //310관 지하 5층 > 310관 1층
        addData(8, 310, -5, 310, 1, PortalData.TYPE_ELEVATOR);
        //310관 지하 3층 > 310관 1층
        addData(9, 310, -3, 310, 1, PortalData.TYPE_ESCALATOR);

    }

    private void addData(int id, int ...args){
        portalData.put(id, new PortalData(id, args[0], args[1], args[2], args[3], args[4]));
    }

    public void addButton(final int id, int x1, int y1, int x2, int y2, MainActivity ma, FrameLayout layout){
        ImageButton ib = new ImageButton(ma);
        double radian = Math.atan((double)(y2-y1)/(x2-x1));
        double degree = Math.toDegrees(radian);
        double r = Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));


        //Matrix mtrx=new Matrix();
        //((ImageView)ib).setScaleType(ImageView.ScaleType.MATRIX);
        //mtrx.postRotate((float) degree, x1, y1);
        //((ImageView)ib).setImageMatrix(mtrx);

        //ib.setRotation((float)degree);
        //ib.setLayoutParams(new FrameLayout.LayoutParams((int)r, 30));
        //ib.setX((float) (x1);
        //ib.setY((float) (y1);

        ib.setLayoutParams(new FrameLayout.LayoutParams(60, 40));
        ib.setX(x1);
        ib.setY(y1);





        ib.setBackgroundResource(R.drawable.stick);
        layout.addView(ib);
        ib.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                final AlertDialog.Builder alertDialog = new AlertDialog.Builder(view.getContext());
                alertDialog.setTitle("설명");
                String 가는방법 = "";
                switch(portalData.get(id).type){
                    case PortalData.TYPE_WALK:
                        가는방법 = "걸어서";
                        break;
                    case PortalData.TYPE_STAIR:
                        가는방법 = "계단으로";
                        break;
                    case PortalData.TYPE_ESCALATOR:
                        가는방법 = "에스컬레이터로";
                        break;
                    case PortalData.TYPE_ELEVATOR:
                        가는방법 = "엘리베이터로";
                        break;
                }
                alertDialog.setMessage(portalData.get(id).edges[0] +"(" + portalData.get(id).floors[0]+"층) <-> " + portalData.get(id).edges[1]+"("+portalData.get(id).floors[1] + "층)\n가는방법 : "+ 가는방법);
                alertDialog.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface/*자기자신*/, int i) {
                        dialogInterface.dismiss();
                    }
                });
                alertDialog.show();
                return false;
            }
        });
        addButton(id, ib);
    }

    public void addButton(int id, ImageButton button){
        portalButtons.put(id, button);
    }

}
