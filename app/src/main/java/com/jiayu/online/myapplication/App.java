package com.jiayu.online.myapplication;

import android.app.Application;

import com.jiayu.commonbase.manager.TaotutuManager;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        TaotutuManager.setAccessKey("7b51de35ba4f465a81c48af594df38e1");
        TaotutuManager.setAccessSecret("56cbaf232dbd48d9b6b7b88760b5784e");




        TaotutuManager.init(this);
    }
}
