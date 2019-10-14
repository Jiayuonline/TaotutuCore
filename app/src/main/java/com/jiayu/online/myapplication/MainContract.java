package com.jiayu.online.myapplication;

import com.jiayu.commonbase.mvp.IView;

import java.util.HashMap;

public class MainContract  {
    interface View extends IView {

        void onLoginSuccess();

    }

    interface Presenter {
        void login(HashMap<String, String> param);

    }
}
