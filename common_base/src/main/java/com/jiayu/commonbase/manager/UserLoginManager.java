package com.jiayu.commonbase.manager;

import com.jiayu.commonbase.bean.UserBean;
import com.jiayu.commonbase.util.SharedPreferenceUtil;
import com.jiayu.commonbase.util.StringUtils;

import java.util.HashMap;

public class UserLoginManager {
    private static String SHARED_USER = "userinfo";
    private static String USERID = "userid";
    private static String ISLOGGEDIN = "isloggedin";
    private static String USERNAME = "username";
    private static String USERHEADIMG = "userheadimg";
    private static String ACCESSTOKEN = "accesstoken";

    /**
     * 是否已登录
     */
    private boolean loggedIn = false;
    private String uid ;
    private String access_token ;
    private String userName ;
    private String userHeadImage ;

    public String getUserName() {
        if (userName==null){
            userName = SharedPreferenceUtil.read(SHARED_USER,USERNAME,"");
        }
        return userName;
    }

    public String getUserHeadImage() {
        if (userHeadImage==null){
            userHeadImage = SharedPreferenceUtil.read(SHARED_USER,USERHEADIMG,"");
        }
        return userHeadImage;
    }

    public String getUid() {
        if (uid==null){
            uid=  SharedPreferenceUtil.read(SHARED_USER,USERID,"");
        }
        return uid;
    }

    public String getAccess_token() {
        if (access_token==null){
            access_token=  SharedPreferenceUtil.read(SHARED_USER,ACCESSTOKEN,"");
        }
        return access_token;
    }

    HashMap<String,String> header ;

    public HashMap<String,String> getHttpHeader(){
        if (header==null|| StringUtils.isEmpty(header.get("access-token"))){
            header = new HashMap();
            header.put("access-token",getAccess_token());
            header.put("uid",getUid());
        }
        return header;
    }

    private UserLoginManager() {

    }

    public static class UserLoginManagerHolder {
        private static final UserLoginManager instance = new UserLoginManager();
    }

    public static UserLoginManager getInstance() {
        return UserLoginManagerHolder.instance;
    }

    public boolean isLoggedin() {
        if (!loggedIn){
           loggedIn = SharedPreferenceUtil.read(SHARED_USER,"isloggedin",false);
        }
        return loggedIn;
    }

    public void setLoggedin(boolean loggedIn, UserBean userBean) {
        this.loggedIn = loggedIn;
        if (loggedIn){

            userName = userBean.getNickname();
            access_token = userBean.getAccess_token();
            userHeadImage = userBean.getHeadImg();
            uid = userBean.getUid();


            SharedPreferenceUtil.write(SHARED_USER,ISLOGGEDIN,true);
            SharedPreferenceUtil.write(SHARED_USER,USERID,uid);
            SharedPreferenceUtil.write(SHARED_USER,USERNAME,userName);
            SharedPreferenceUtil.write(SHARED_USER,USERHEADIMG,userHeadImage);
            SharedPreferenceUtil.write(SHARED_USER,ACCESSTOKEN,access_token);
        }else {
            SharedPreferenceUtil.write(SHARED_USER,ISLOGGEDIN,false);
            SharedPreferenceUtil.write(SHARED_USER,USERID,"");
            SharedPreferenceUtil.write(SHARED_USER,USERNAME,"");
            SharedPreferenceUtil.write(SHARED_USER,USERHEADIMG,"");
            SharedPreferenceUtil.write(SHARED_USER,ACCESSTOKEN,"");
        }
    }
}
