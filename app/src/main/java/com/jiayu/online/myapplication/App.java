package com.jiayu.online.myapplication;

import android.app.Application;

import com.jiayu.commonbase.manager.TaotutuManager;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        TaotutuManager.getInstance().setAccessKey(" ");
        TaotutuManager.getInstance().setAccessSecret(" ");
        TaotutuManager.getInstance().setChannel("taotutu");
        TaotutuManager.getInstance().setPlatform("andorid");
        TaotutuManager.getInstance().setUniqueCode("123");

        TaotutuManager.getInstance().init(this);
    }
}
