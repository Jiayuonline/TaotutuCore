package com.jiayu.online.myapplication;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jiayu.commonbase.base.BaseObserver;
import com.jiayu.commonbase.manager.UserLoginManager;
import com.jiayu.commonbase.mvp.BasePresenter;
import com.jiayu.commonbase.util.GsonUtils;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;

public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {
    @Override
    public void login(HashMap<String, String> param) {


        param.put("uniqueCode","123");
        param.put("channel","taotutu");
        param.put("platform","andorid");
        param.put("aliasName","驾御");
//        param.put("imei","");
//        param.put("mobile","");
//        param.put("nickname","");

        Gson gson = new Gson();
        String json =  gson.toJson(param,new TypeToken<HashMap<String, String>>() {
        }.getType())  ;
        addSubscribe(create(MainApi.class).getLogin(json),
                new BaseObserver<String>(getView()) {
                    @Override
                    protected void onSuccess(String data) {
                        getView().onLoginSuccess();
                    }
                });
    }
}
