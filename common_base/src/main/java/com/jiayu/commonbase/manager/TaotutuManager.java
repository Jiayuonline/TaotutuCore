package com.jiayu.commonbase.manager;

import android.content.Context;

import com.jiayu.commonbase.http.ExceptionHandler;
import com.jiayu.commonbase.http.RetrofitClient;
import com.jiayu.commonbase.util.SharedPreferenceUtil;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.HashMap;

public class TaotutuManager {

    static Context context;
    static String accessSecret;
    static String accessKey;
    /**
     * 唯一设备号
     */
    static String uniqueCode;
    /**
     * 来源
     */
    static String channel;
    /***
     *  类型-android ios
     */
    static String platform;
    /***
     * 鉴权token
     */
    static String access_token;
    static String imei;
    static String mobile;
    static String nickname;
    static String aliasName;




    public static void  init(Context c){

        context  = c;
        RetrofitClient.getInstance(context);
        SharedPreferenceUtil.init(context);
        ExceptionHandler.init(context);
    }


    public static String getAliasName() {
        return aliasName;
    }

    public static void setAliasName(String aliasName) {
        TaotutuManager.aliasName = aliasName;
    }

    public static String getUniqueCode() {
        return uniqueCode;
    }

    public static void setUniqueCode(String uniqueCode) {
        TaotutuManager.uniqueCode = uniqueCode;
    }

    public static String getChannel() {
        return channel;
    }

    public static void setChannel(String channel) {
        TaotutuManager.channel = channel;
    }

    public static String getPlatform() {
        return platform;
    }

    public static void setPlatform(String platform) {
        TaotutuManager.platform = platform;
    }

    public static String getAccess_token() {
        return access_token;
    }

    public static void setAccess_token(String access_token) {
        TaotutuManager.access_token = access_token;
    }

    public static String getImei() {
        return imei;
    }

    public static void setImei(String imei) {
        TaotutuManager.imei = imei;
    }

    public static String getMobile() {
        return mobile;
    }

    public static void setMobile(String mobile) {
        TaotutuManager.mobile = mobile;
    }

    public static String getNickname() {
        return nickname;
    }

    public static void setNickname(String nickname) {
        TaotutuManager.nickname = nickname;
    }

    public static String getAccessSecret() {
        return accessSecret;
    }

    public static void setAccessSecret(String accessSecret) {
        TaotutuManager.accessSecret = accessSecret;
    }

    public static String getAccessKey() {
        return accessKey;
    }

    public static void setAccessKey(String accessKey) {
        TaotutuManager.accessKey = accessKey;
    }

    public static String MD5Encode(String origin, String charsetname) {
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

    private static String byteArrayToHexString(byte b[]) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++)
            resultSb.append(byteToHexString(b[i]));
        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0)
            n += 256;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    private static final String hexDigits[] = { "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

    public static HashMap<String,String> getParam(HashMap<String,String> params){

        String timestamp = String.valueOf(System.currentTimeMillis());

//          accessSecret = "56cbaf232dbd48d9b6b7b88760b5784e";
//          accessKey = "7b51de35ba4f465a81c48af594df38e1";

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
}
