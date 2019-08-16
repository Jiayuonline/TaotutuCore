package com.jiayu.commonbase.bean;

public class UserBean {

        /**
         * uid : 820760304
         * mobile : 18360903445
         * nickname : 将计就计
         * headImg : https://jiayu-taotutu.oss-cn-beijing.aliyuncs.com/user/820760304_cc001f3a-f2b8-4dd8-a0e0-6c40fdd7bf44.jpg
         * coverImage : https://jiayu-taotutu.oss-cn-beijing.aliyuncs.com/user/820760304_2b2796dc-b967-4e37-8a86-c9bff747d7cc.jpg
         * gender : 0
         * isWeiboBind : false
         * isWechatBind : false
         * isQqBind : true
         * access_token : eyJhbGciOiJIUzUxMiJ9.eyJ1aWQiOiI4MjA3NjAzMDQiLCJuaWNrbmFtZSI6IuWwhuiuoeWwseiuoSIsIm1vYmlsZSI6IjE4MzYwOTAzNDQ1IiwiY2hhbm5lbCI6InRhb3R1dHVhcHAiLCJleHAiOjE1NjMyNDkzNTYsImlhdCI6MTU2MjY0NDU1NiwiYWNjb3VudCI6IuWwhuiuoeWwseiuoSJ9.GY0P9V6fgnLcYgw2ZimrK-ZGw7fl2LM0_kSl44uPrxPRoq4PBIu8GEuHUnRS1WA5vDiYSL-yHvFD6ndW9MBB1A
         * attentionSum : 5
         * fansSum : 2
         * attentionsStatus : false
         * labels : 途途大咖
         */

        private String uid;
        private String mobile;
        private String nickname;
        private String headImg;
        private String coverImage;
        private int gender;
        private boolean isWeiboBind;
        private boolean isWechatBind;
        private boolean isQqBind;
        private String access_token;
        private int attentionSum;
        private int fansSum;
        private boolean attentionsStatus;
        private String labels;

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getHeadImg() {
            return headImg;
        }

        public void setHeadImg(String headImg) {
            this.headImg = headImg;
        }

        public String getCoverImage() {
            return coverImage;
        }

        public void setCoverImage(String coverImage) {
            this.coverImage = coverImage;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public boolean isIsWeiboBind() {
            return isWeiboBind;
        }

        public void setIsWeiboBind(boolean isWeiboBind) {
            this.isWeiboBind = isWeiboBind;
        }

        public boolean isIsWechatBind() {
            return isWechatBind;
        }

        public void setIsWechatBind(boolean isWechatBind) {
            this.isWechatBind = isWechatBind;
        }

        public boolean isIsQqBind() {
            return isQqBind;
        }

        public void setIsQqBind(boolean isQqBind) {
            this.isQqBind = isQqBind;
        }

        public String getAccess_token() {
            return access_token;
        }

        public void setAccess_token(String access_token) {
            this.access_token = access_token;
        }

        public int getAttentionSum() {
            return attentionSum;
        }

        public void setAttentionSum(int attentionSum) {
            this.attentionSum = attentionSum;
        }

        public int getFansSum() {
            return fansSum;
        }

        public void setFansSum(int fansSum) {
            this.fansSum = fansSum;
        }

        public boolean isAttentionsStatus() {
            return attentionsStatus;
        }

        public void setAttentionsStatus(boolean attentionsStatus) {
            this.attentionsStatus = attentionsStatus;
        }

        public String getLabels() {
            return labels;
        }

        public void setLabels(String labels) {
            this.labels = labels;
        }
}
