package com.jiayu.online.myapplication;

import com.alibaba.fastjson.annotation.JSONType;
import com.jiayu.commonbase.base.BaseResponse;
import com.jiayu.commonbase.bean.UserBean;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface MainApi {
    /**
     * 鉴权登录
     *
     * @return
     */

    @Headers({"Content-Type: application/json","Accept: application/json"})//需要添加头
    @POST ("http://test.taotutu.jiayuonline.com/openapi/v1/user")
    Observable<BaseResponse<String>> getLogin(@Body String loginInfo);   // 请求体味RequestBody 类型
}
