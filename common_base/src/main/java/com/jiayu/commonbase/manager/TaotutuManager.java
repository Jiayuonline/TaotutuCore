package com.jiayu.commonbase.manager;

import android.content.Context;

import com.jiayu.commonbase.http.ExceptionHandler;
import com.jiayu.commonbase.http.RetrofitClient;
import com.jiayu.commonbase.presenter.AuthPresenter;
import com.jiayu.commonbase.util.SharedPreferenceUtil;
import com.jiayu.commonbase.util.StringUtils;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.HashMap;

public class TaotutuManager {

      Context context;
      String accessSecret;
      String accessKey;
    /**
     * 唯一设备号
     */
      String uniqueCode;
    /**
     * 来源
     */
      String channel;
    /***
     *  类型-android ios
     */
      String platform;
    /***
     * 鉴权token
     */
      String access_token;
      String imei;
      String mobile;
      String nickname;
      String aliasName;

    static   TaotutuManager taotutuManager;

    public static TaotutuManager getInstance(){
        if (taotutuManager == null) {
            taotutuManager = new TaotutuManager();
        }
        return  taotutuManager;
    }



    public   void  init(Context c){

        context  = c;
        RetrofitClient.getInstance(context);
        SharedPreferenceUtil.init(context);
        ExceptionHandler.init(context);
    }


    public   String getAliasName() {
        return StringUtils.isEmpty(aliasName)?"":aliasName;
    }

    public   void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    public   String getUniqueCode() {
        return StringUtils.isEmpty(uniqueCode)?"":uniqueCode;

    }

    public   void setUniqueCode(String uniqueCode) {
        this.uniqueCode = uniqueCode;
    }

    public   String getChannel() {
        return StringUtils.isEmpty(channel)?"":channel;

    }

    public   void setChannel(String channel) {
        this.channel = channel;
    }

    public   String getPlatform() {
        return StringUtils.isEmpty(platform)?"":platform;

    }

    public   void setPlatform(String platform) {
        this.platform = platform;
    }

    public   String getAccess_token() {
        return access_token;
    }

    public   void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public   String getImei() {
        return StringUtils.isEmpty(imei)?"":imei;

    }

    public   void setImei(String imei) {
        this.imei = imei;
    }

    public   String getMobile() {
        return StringUtils.isEmpty(mobile)?"":mobile;

    }

    public   void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public   String getNickname() {
        return StringUtils.isEmpty(nickname)?"":nickname;
    }

    public   void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public   String getAccessSecret() {
        return accessSecret;
    }

    public   void setAccessSecret(String accessSecret) {
        this.accessSecret = accessSecret;
    }

    public   String getAccessKey() {
        return accessKey;
    }

    public   void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public   String MD5Encode(String origin, String charsetname) {
        String resultString = null;
        try {
            resultString = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            if (charsetname == null || "".equals(charsetname))
                resultString = byteArrayToHexString(md.digest(resultString
                        .getBytes()));
            else
                resultString = byteArrayToHexString(md.digest(resultString
                        .getBytes(charsetname)));
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return resultString;
    }

    private   String byteArrayToHexString(byte b[]) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++)
            resultSb.append(byteToHexString(b[i]));
        return resultSb.toString();
    }

    private   String byteToHexString(byte b) {
        int n = b;
        if (n < 0)
            n += 256;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    private   final String hexDigits[] = { "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

    public   HashMap<String,String> getParam(HashMap<String,String> params){

        String timestamp = String.valueOf(System.currentTimeMillis());


        params.put("timestamp",timestamp);
        params.put("accessSecret",accessSecret);

        Object[] keys = params.keySet().toArray();
        Arrays.sort(keys);

        StringBuilder sb = new StringBuilder();
        for(Object key:keys) {
            sb.append(key + "=" + params.get(key) + "&");
        }
        sb.append("accessKey=" + accessKey);

        String sign = MD5Encode(sb.toString(),"");
        sign =  MD5Encode(sign,"");
        sign =  MD5Encode(sign,"");
        params.put("sign",sign);

        return params;
    }

    public   void authLogin(final OnAuthLoginCallback authCallback){
        AuthPresenter authPresenter = new AuthPresenter();
        authPresenter.authLogin(new AuthPresenter.OnLoginCallback() {
            @Override
            public void onSuccess(String token) {
                 setAccess_token(token);
                authCallback.onSuccess(token);
            }

            @Override
            public void onFailed(Throwable e) {
                authCallback.onFailed(e);
            }
        });
    }

    public interface OnAuthLoginCallback{
        void onSuccess(String token);
        void onFailed(Throwable e);
    }
}
