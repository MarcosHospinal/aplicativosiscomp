package com.example.pc.siscomp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(Settings.DEBUG, "La aplicacion entró en start");
    }
    @Override
    public void onResume(){
        super.onResume();
        Log.d(Settings.DEBUG, "La aplicacion entró en resume");
        // put your code here...

    }
    @Override
    protected void onStop() {
        // call the superclass method first
        super.onStop();
        Log.d(Settings.DEBUG, "La aplicacion entró en stop");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.v(Settings.DEBUG, "La aplicacion entró en pause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(Settings.DEBUG, "La aplicacion entró en destroy");
    }
}
