package com.example.pc.siscomp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import  com.example.pc.siscomp.activities.AboutUsActivity;
import  com.example.pc.siscomp.activities.ProductListActivity;
import com.example.pc.siscomp.activities.RegisterUserActivity;
import com.example.pc.siscomp.generals.Settings;

public class MainActivity extends AppCompatActivity {

    private Button btnProducts;
    private Button btnAboutUs;
    private Button btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnProducts = (Button) findViewById(R.id.btnEnter);
        btnAboutUs = (Button) findViewById(R.id.btnAboutUs);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        btnProducts.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i(Settings.INFO, "Products");
                Intent i = new Intent(MainActivity.this, ProductListActivity.class);
                startActivity(i);
            }
        });
        btnAboutUs.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i(Settings.INFO, "About us");
                Intent i = new Intent(MainActivity.this, AboutUsActivity.class);
                startActivity(i);
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(Settings.INFO, "Register");
                Intent i = new Intent(MainActivity.this, RegisterUserActivity.class);
                startActivity(i);
            }
        });
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
