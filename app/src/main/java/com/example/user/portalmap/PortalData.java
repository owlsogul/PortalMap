package com.example.user.portalmap;

/**
 * Created by user on 2016-11-04.
 */

public class PortalData {

    //연결된 건물의 관을 저장하는 배열
    protected int edgeBuilding[] = {0 , 0};

    //포탈의 타입에 대한 정보를 저장
    protected int portalType;


    public PortalData(int edge1, int edge2, int type){
        edgeBuilding[0] = edge1;
        edgeBuilding[1] = edge2;
        portalType = type;
    }

}
