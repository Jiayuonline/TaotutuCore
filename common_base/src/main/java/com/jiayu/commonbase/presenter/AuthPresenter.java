package com.jiayu.commonbase.presenter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jiayu.commonbase.apiservice.ApiService;
import com.jiayu.commonbase.base.BaseObserver;
import com.jiayu.commonbase.contract.AuthContract;
import com.jiayu.commonbase.manager.TaotutuManager;
import com.jiayu.commonbase.mvp.BasePresenter;

import java.util.HashMap;

import okhttp3.RequestBody;

public class AuthPresenter extends BasePresenter<AuthContract.View> implements AuthContract.Presenter {

   public  interface  OnLoginCallback {
       void onSuccess(String token);
       void  onFailed(Throwable e);
   };

    @Override
    public void authLogin(final OnLoginCallback callback) {
        HashMap<String ,String> param = new HashMap<>();

        param.put("uniqueCode", TaotutuManager.getUniqueCode());
        param.put("channel", TaotutuManager.getChannel());
        param.put("platform", TaotutuManager.getPlatform());
        param.put("aliasName",TaotutuManager.getAliasName());
        param.put("aliasName",TaotutuManager.getAliasName());
        param.put("imei",TaotutuManager.getImei());
        param.put("mobile",TaotutuManager.getMobile());
        param.put("nickname",TaotutuManager.getNickname());

        HashMap<String ,String> map = TaotutuManager.getParam(param);

        Gson gson = new Gson();
        String json =  gson.toJson(map,new TypeToken<HashMap<String, String>>() {
        }.getType())  ;

        RequestBody body=RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),json);

        addSubscribe(create( ApiService.class).authLogin(body),
                new BaseObserver<String>( ) {
                    @Override
                    protected void onSuccess(String data) {
                        callback.onSuccess(data);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFailed(e   );


                    }
                });


    }


}
