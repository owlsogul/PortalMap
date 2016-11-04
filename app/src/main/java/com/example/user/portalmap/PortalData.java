package com.example.user.portalmap;

/**
 * Created by user on 2016-11-04.
 */

public class PortalData {

    int id;
    int edges[] = {0, 0};
    int floors[] = {0, 0};
    int type = 0;
    public final static int
            TYPE_WALK = 1,
            TYPE_STAIR = 2,
            TYPE_ELEVATOR = 3,
            TYPE_ESCALATOR = 4;

    public PortalData(int id, int edge1, int floor1, int edge2, int floor2, int type) {
        this.id = id;
        edges[0] = edge1;
        floors[0] = floor1;
        edges[1] = edge2;
        floors[1] = floor2;
        this.type = type;
    }

}
