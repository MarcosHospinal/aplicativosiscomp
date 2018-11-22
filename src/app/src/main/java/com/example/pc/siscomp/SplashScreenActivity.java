package com.example.pc.siscomp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.pc.siscomp.activities.LoginActivity;

public class SplashScreenActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Intent o = new Intent(this, LoginActivity.class);
        startActivity(o);
        finish();
    }
}
