package com.example.pc.siscomp;

import android.app.Application;
import android.os.SystemClock;


public class MySisComp extends Application{
    @Override
    public void onCreate(){
        super.onCreate();
        SystemClock.sleep(2000);
    }
}
