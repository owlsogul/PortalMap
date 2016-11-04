package com.example.user.portalmap;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public PortalManager pManager;

    public Button help, allPortal;
    public ImageView iView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        help = (Button) findViewById(R.id.help);
        allPortal = (Button) findViewById(R.id.all);
        iView = (ImageView) findViewById(R.id.map);

        new AsyncTask<Object, Object, Void>(){

            @Override
            protected Void doInBackground(Object... voids) {
                pManager = new PortalManager();
                return null;
            }
        };

    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}
