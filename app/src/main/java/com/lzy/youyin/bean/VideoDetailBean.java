package com.lzy.youyin.bean;

/**
 * Created by Lzy On 2019/8/19
 * Describe:
 */
public class VideoDetailBean {
    /**
     * code : 1000
     * data : {"opern":"<img src=\"http://uyin-opern-1251295399.cos.ap-guangzhou.myqcloud.com/uyin_opern/guitar/%E7%90%86%E6%83%B3_UYIN_1.png\" alt=\"\" /><img src=\"http://uyin-opern-1251295399.cos.ap-guangzhou.myqcloud.com/uyin_opern/guitar/%E7%90%86%E6%83%B3_UYIN_2.png\" alt=\"\" /><img src=\"http://uyin-opern-1251295399.cos.ap-guangzhou.myqcloud.com/uyin_opern/guitar/%E7%90%86%E6%83%B3_UYIN_3.png\" alt=\"\" />","appWechatShare":"","buystatus":0,"surfacePic":"http://file.uyinmusic.com/classroom/Single/guitar/%E7%90%86%E6%83%B3.jpg","price":0,"buy":false,"startTime":"0","title":"赵雷《理想》","url":"http://file.uyinmusic.com/classroom/Single/guitar/%E7%90%86%E6%83%B3%E6%95%99%E5%AD%A6.mp4.f30.mp4"}
     * message : success
     */

    private int code;
    private DataBean data;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        /**
         * opern : <img src="http://uyin-opern-1251295399.cos.ap-guangzhou.myqcloud.com/uyin_opern/guitar/%E7%90%86%E6%83%B3_UYIN_1.png" alt="" /><img src="http://uyin-opern-1251295399.cos.ap-guangzhou.myqcloud.com/uyin_opern/guitar/%E7%90%86%E6%83%B3_UYIN_2.png" alt="" /><img src="http://uyin-opern-1251295399.cos.ap-guangzhou.myqcloud.com/uyin_opern/guitar/%E7%90%86%E6%83%B3_UYIN_3.png" alt="" />
         * appWechatShare :
         * buystatus : 0
         * surfacePic : http://file.uyinmusic.com/classroom/Single/guitar/%E7%90%86%E6%83%B3.jpg
         * price : 0.0
         * buy : false
         * startTime : 0
         * title : 赵雷《理想》
         * url : http://file.uyinmusic.com/classroom/Single/guitar/%E7%90%86%E6%83%B3%E6%95%99%E5%AD%A6.mp4.f30.mp4
         */

        private String opern;
        private String appWechatShare;
        private int buystatus;
        private String surfacePic;
        private double price;
        private boolean buy;
        private String startTime;
        private String title;
        private String url;

        public String getOpern() {
            return opern;
        }

        public void setOpern(String opern) {
            this.opern = opern;
        }

        public String getAppWechatShare() {
            return appWechatShare;
        }

        public void setAppWechatShare(String appWechatShare) {
            this.appWechatShare = appWechatShare;
        }

        public int getBuystatus() {
            return buystatus;
        }

        public void setBuystatus(int buystatus) {
            this.buystatus = buystatus;
        }

        public String getSurfacePic() {
            return surfacePic;
        }

        public void setSurfacePic(String surfacePic) {
            this.surfacePic = surfacePic;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public boolean isBuy() {
            return buy;
        }

        public void setBuy(boolean buy) {
            this.buy = buy;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
