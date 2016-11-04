package com.example.user.portalmap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {

    public PortalManager pManager;

    public Button help, allPortal;
    public ImageView iView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pManager = new PortalManager();

        help = (Button) findViewById(R.id.help);
        allPortal = (Button) findViewById(R.id.all);
        iView = (ImageView) findViewById(R.id.map);


    }
}
