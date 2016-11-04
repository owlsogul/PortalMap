package com.example.user.portalmap;

import android.util.Log;

import java.util.HashMap;

/**
 * Created by user on 2016-11-05.
 */

public class BuildingManager {

    public BuildingData bData[];
    //건물번호, 포탈&데이터코드들
    public HashMap<Integer, int[]> bPotalData;
    public BuildingManager(){
        bData = new BuildingData[8];
        bPotalData = new HashMap<>();
        //RND
        bData[0] = new BuildingData(102, 51, 818, 195, 954);
        //간호대
        bData[1] = new BuildingData(103, 187, 793, 293, 885);
        //의대
        bData[2] = new BuildingData(105, 167, 703, 266, 802);
        //제2의대
        bData[3] = new BuildingData(106, 257, 579, 309, 697);
        //자연과학대
        bData[4] = new BuildingData(104, 329, 757, 477, 864);
        //서라벌
        bData[5] = new BuildingData(203, 689, 551, 920, 704);
        //법학관
        bData[6] = new BuildingData(303, 923, 526, 1077, 728);
        //310
        bData[7] = new BuildingData(310, 847, 275, 1075, 494);
        Log.i("TEST", "BMANAGER");
    }


}
