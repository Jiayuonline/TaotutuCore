package com.jiayu.online.myapplication;

import android.app.Application;

import com.jiayu.commonbase.manager.TaotutuManager;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        TaotutuManager.setAccessKey(" ");
        TaotutuManager.setAccessSecret(" ");
        TaotutuManager.setChannel("taotutu");
        TaotutuManager.setPlatform("andorid");
        TaotutuManager.setUniqueCode("123");

        TaotutuManager.init(this);
    }
}
