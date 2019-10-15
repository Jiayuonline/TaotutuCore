package com.jiayu.online.myapplication;

import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.jiayu.commonbase.base.BaseMVPActivity;
import com.jiayu.commonbase.manager.TaotutuManager;
import com.jiayu.commonbase.util.GsonUtils;

import java.util.HashMap;

/***
 * commonbase 库项目
 */
public class MainActivity extends BaseMVPActivity<MainPresenter> implements MainContract.View {


    private HashMap<String, String> param;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        Button btn = findViewById(R.id.btn_test);
        btn .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i    = new Intent(MainActivity.this,TestActivity.class);
//                startActivity(i);



                HashMap<String,String> map = new HashMap<>();
//                map.put("pageNo","1");
                map.put("uniqueCode", TaotutuManager.getUniqueCode());
                map.put("channel", TaotutuManager.getChannel());
                map.put("platform", TaotutuManager.getPlatform());

                param = TaotutuManager. getParam(map);
                Log.d("test", GsonUtils.toJson(param));
            }
        });

        Button btnLogin = findViewById(R.id.btn_login);
        btnLogin .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TaotutuManager.authLogin(new TaotutuManager.OnAuthLoginCallback() {
                    @Override
                    public void onSuccess(String token) {
                        Log.d("OnAuthLoginCallback", "onSuccess: "+token);
                    }

                    @Override
                    public void onFailed(Throwable e) {

                    }
                });
            }
        });
    }

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    public void onLoginSuccess() {
        Log.e("loginsuccess", "onLoginSuccess: 登录成功"  );
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
