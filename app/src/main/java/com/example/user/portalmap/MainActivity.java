package com.example.user.portalmap;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

    public PortalManager pManager;

    public Button help, allPortal;
    public ImageView iView;

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
