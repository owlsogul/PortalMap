package com.example.user.portalmap;

import java.util.HashMap;

/**
 * Created by user on 2016-11-04.
 */

public class PortalManager {

    public HashMap<Integer, PortalData> portalData;
    //public HashMap<Integer, ImageButton> portalButtons;

    public PortalManager(){

        //알엔디 > 간호대
        add(0, 102, 2, 103, 2, PortalData.TYPE_WALK);
        //간호대 > 의대
        add(1, 103, 3, 105, 1, PortalData.TYPE_WALK);
        //의대 > 제2의대
        add(2, 105, 4, 106, 4, PortalData.TYPE_WALK);
        //자연과학대 1층 > 3층 : 계단대신
        add(3, 104, 1, 104, 3, PortalData.TYPE_ELEVATOR);
        //서라벌호 2층 > 4층 : 계단대신
        add(4, 203, 2, 203, 4, PortalData.TYPE_ELEVATOR);
        //법학관 지하1층 > 동판CAU쪽
        add(5, 303, -1, 303, 3, PortalData.TYPE_ELEVATOR);
        //법학관 지하1층 > 후문쪽
        add(6, 303, -1, 303, 6, PortalData.TYPE_ELEVATOR);
        //310관 지하 5층 > 동판CAU쪽
        add(7, 310, -5, 303, -3, PortalData.TYPE_ELEVATOR);
        //310관 지하 5층 > 310관 지하 1층
        add(8, 310, -5, 303, 1, PortalData.TYPE_ELEVATOR);
        //310관 지하 3층 > 310관 1층
        add(9, 310, -3, 303, 1, PortalData.TYPE_ESCALATOR);

    }

    private void add(int id, int ...args){
        portalData.put(id, new PortalData(id, args[0], args[1], args[2], args[3], args[4]));
    }

}
