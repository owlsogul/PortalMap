package com.example.user.portalmap;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

/**
 * Created by user on 2016-11-04.
 */

public class PortalButton extends ImageButton {

    int edges[] = {0, 0};
    final static int
            TYPE_WALK = 1,
            TYPE_STAIR = 2,
            TYPE_ELEVATOR = 3,
            TYPE_ESCALATOR = 4;
    int type = 0;

    public PortalButton(Context context, int edge1, int edge2, int type) {
        super(context);
        edges[0] = edge1;
        edges[1] = edge2;
        this.type = type;
    }

}
