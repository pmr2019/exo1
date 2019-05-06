package com.example.pmr_exo1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    public final String CAT="PMR";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(CAT,"onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(CAT,"onStart");
    }
}
