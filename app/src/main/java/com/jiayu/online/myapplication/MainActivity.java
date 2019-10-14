package com.jiayu.online.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.jiayu.commonbase.base.BaseMVPActivity;
import com.jiayu.commonbase.manager.TaotutuManager;
import com.jiayu.commonbase.util.DeviceUtil;
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
                map.put("channel", "taotutu");
                map.put("platform", "android");

                param = TaotutuManager. getParam(map);
                Log.d("test", GsonUtils.toJson(param));

            }
        });

        Button btnLogin = findViewById(R.id.btn_login);
        btnLogin .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.login(param);
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
