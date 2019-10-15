package com.jiayu.commonbase.apiservice;



import com.jiayu.commonbase.base.BaseResponse;

import java.util.HashMap;
import java.util.List;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface ApiService {




   /**
     * 鉴权login
     * @return
     */
   @Headers({"Content-Type: application/json","Accept: application/json"})//需要添加头
   @POST("https://test.taotutu.jiayuonline.com/openapi/v1/user")
    Observable<BaseResponse<String>> authLogin(@Body RequestBody loginInfo);

}
