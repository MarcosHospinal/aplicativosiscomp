package com.example.pc.siscomp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.pc.siscomp.activities.CarActivity;
import com.example.pc.siscomp.activities.CheckoutActivity;
import com.example.pc.siscomp.activities.LoginActivity;
import com.example.pc.siscomp.activities.ProductActivity;
import com.example.pc.siscomp.activities.ProductListActivity;
import com.example.pc.siscomp.activities.WholesaleOrderActivity;

public class SplashScreenActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Intent o = new Intent(this, LoginActivity.class);
        startActivity(o);
        finish();
    }
}
