package com.lzy.youyin.bean;

import java.util.List;

/**
 * Created by Lzy On 2019/8/19
 * Describe:
 */
public class HotInfoBean {

    /**
     * code : 1000
     * data : [{"classId":185,"buystatus":1,"surfacePic":"http://file.uyinmusic.com/classroom/Single/guitar/%E5%BE%80%E5%90%8E%E4%BD%99%E7%94%9F.png","readNum":238922,"price":8.88,"opernId":14521,"title":"《往后余生》吉他弹唱教学","wechatLink":""},{"classId":188,"buystatus":1,"surfacePic":"http://file.uyinmusic.com/classroom/Single/guitar/%E6%88%90%E9%83%BD7.29.mp4.0_0.p0.png","readNum":189542,"price":8.88,"opernId":14524,"title":"《成都》吉他弹唱教学","wechatLink":""},{"classId":210,"buystatus":0,"surfacePic":"http://file.uyinmusic.com/classroom/Single/guitar/%E3%80%8A%E7%9C%9F%E7%9A%84%E7%88%B1%E4%BD%A0%E3%80%8B%E5%BC%B9%E5%94%B1%2B%E6%95%99%E5%AD%A6%E5%B7%B1%E8%B4%B4%E8%B0%B1.jpg","readNum":176126,"price":0,"opernId":14545,"title":"《真的爱你》吉他弹唱教学","wechatLink":""},{"classId":221,"buystatus":1,"surfacePic":"http://file.uyinmusic.com/classroom/Single/guitar/%E7%8E%AB%E7%91%B0.jpg","readNum":160664,"price":8,"opernId":14558,"title":"贰佰《玫瑰》吉他弹唱教学","wechatLink":""},{"classId":211,"buystatus":1,"surfacePic":"http://file.uyinmusic.com/classroom/Single/guitar/%E3%80%8A%E6%B5%B7%E9%98%94%E5%A4%A9%E7%A9%BA%E3%80%8B%E5%BC%B9%E5%94%B1%2B%E6%95%99%E5%AD%A6%E5%B7%B1%E8%B4%B4%E8%B0%B1.png","readNum":151315,"price":8,"opernId":14546,"title":"beyond《海阔天空》吉他弹唱教学","wechatLink":""},{"classId":213,"buystatus":0,"surfacePic":"http://file.uyinmusic.com/classroom/Single/guitar/%E7%AA%81%E7%84%B6%E5%A5%BD%E6%83%B3%E4%BD%A0.jpg","readNum":138385,"price":0,"opernId":14548,"title":"《突然好想你》吉他弹唱教学","wechatLink":""},{"classId":226,"buystatus":0,"surfacePic":"http://file.uyinmusic.com/classroom/Single/guitar/%E5%B0%8F%E5%B9%B8%E8%BF%90.jpg","readNum":138068,"price":0,"opernId":14575,"title":"《小幸运》吉他弹唱教学","wechatLink":""},{"classId":223,"buystatus":1,"surfacePic":"http://file.uyinmusic.com/classroom/Single/guitar/%E8%B4%9D%E5%8A%A0%E5%B0%94%E6%B9%96%E7%95%94.jpg","readNum":137632,"price":6.8,"opernId":14561,"title":"李健《贝加尔湖畔》吉他弹唱教学","wechatLink":""},{"classId":180,"buystatus":1,"surfacePic":"http://file.uyinmusic.com/classroom/Single/guitar/%E3%80%8A%E6%99%B4%E5%A4%A9%E3%80%8B.mp4.0_0.p0.jpg","readNum":136475,"price":6.86,"opernId":14516,"title":"《晴天》 吉他弹唱教学","wechatLink":""},{"classId":214,"buystatus":1,"surfacePic":"http://file.uyinmusic.com/classroom/Single/guitar/%E3%80%8A%E5%8D%97%E5%B1%B1%E5%8D%97%E3%80%8B%E5%BC%B9%E5%94%B1%2B%E6%95%99%E5%AD%A6%E5%B7%B1%E8%B4%B4%E8%B0%B1%20_new.png","readNum":134939,"price":8,"opernId":14549,"title":"《南山南》吉他弹唱教学","wechatLink":""},{"classId":227,"buystatus":1,"surfacePic":"http://file.uyinmusic.com/classroom/Single/guitar/%E5%A4%96%E9%9D%A2%E7%9A%84%E4%B8%96%E7%95%8C.jpg","readNum":131515,"price":6.6,"opernId":14564,"title":"《外面的世界》吉他弹唱教学","wechatLink":""},{"classId":207,"buystatus":1,"surfacePic":"http://file.uyinmusic.com/classroom/Single/guitar/%E5%A4%9C%E7%A9%BA%E4%B8%AD%E6%9C%80%E4%BA%AE%E7%9A%84%E6%98%9F%E5%AE%8C%E6%95%B4new.jpg","readNum":125933,"price":5.5,"opernId":14542,"title":"《夜空中最亮的星》弹唱教学","wechatLink":""},{"classId":220,"buystatus":1,"surfacePic":"http://file.uyinmusic.com/classroom/Single/guitar/%E6%95%85%E4%B9%A1.jpg","readNum":124276,"price":8,"opernId":14555,"title":"许巍《故乡》吉他弹唱教学","wechatLink":""},{"classId":189,"buystatus":1,"surfacePic":"http://file.uyinmusic.com/classroom/Single/guitar/%E3%80%8A%E7%BA%B8%E7%9F%AD%E6%83%85%E9%95%BF%E3%80%8B%E5%BC%B9%E5%94%B1%2B%E6%95%99%E5%AD%A6%E8%A7%86%E9%A2%91.mp4.0_0.p0.jpg","readNum":122835,"price":6.8,"opernId":14525,"title":"《纸短情长》吉他弹唱教学","wechatLink":""},{"classId":197,"buystatus":1,"surfacePic":"http://file.uyinmusic.com/classroom/Single/guitar/%E3%80%8A%E4%B8%80%E7%94%9F%E6%89%80%E7%88%B1%E3%80%8B%E5%BC%B9%E5%94%B1%2B%E6%95%99%E5%AD%A6%E6%97%A0%E6%B0%B4%E5%8D%B0%E6%9C%89%E8%B0%B1new_09_22.png","readNum":121280,"price":6.6,"opernId":14532,"title":"《一生所爱》吉他弹唱教学","wechatLink":""},{"classId":216,"buystatus":0,"surfacePic":"http://file.uyinmusic.com/classroom/Single/guitar/%E5%BD%A9%E8%99%B9.jpg","readNum":118026,"price":0,"opernId":14551,"title":"周杰伦《彩虹》吉他弹唱教学","wechatLink":""},{"classId":203,"buystatus":1,"surfacePic":"http://file.uyinmusic.com/classroom/Single/guitar/%E3%80%8A%E5%90%8E%E6%9D%A5%E3%80%8B%E5%BC%B9%E5%94%B1%2B%E6%95%99%E5%AD%A6new.jpg","readNum":114094,"price":5.8,"opernId":14538,"title":"《后来》吉他弹唱教学","wechatLink":""},{"classId":178,"buystatus":1,"surfacePic":"http://file.uyinmusic.com/classroom/Single/guitar/%E6%96%91%E9%A9%AC%E6%96%91%E9%A9%AC-%E9%98%BF%E6%9D%B0.mp4.0_0.p0.png","readNum":113572,"price":6.86,"opernId":14514,"title":"《斑马斑马》 吉他弹唱教学","wechatLink":""},{"classId":199,"buystatus":1,"surfacePic":"http://file.uyinmusic.com/classroom/Single/guitar/%E3%80%8A%E5%AE%89%E5%92%8C%E6%A1%A5%E3%80%8B%E5%BC%B9%E5%94%B1%2B%E6%95%99%E5%AD%A6%E5%B7%B1%E8%B4%B4%E8%B0%B1new.jpg","readNum":113405,"price":8,"opernId":14534,"title":"《安和桥》吉他弹唱教学","wechatLink":""},{"classId":215,"buystatus":1,"surfacePic":"http://file.uyinmusic.com/classroom/Single/guitar/%E4%B8%8D%E5%86%8D%E7%8A%B9%E8%B1%AB.jpg","readNum":112377,"price":5,"opernId":14550,"title":"《不再犹豫》吉他弹唱教学","wechatLink":""}]
     * message : success
     */

    private int code;
    private String message;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * classId : 185
         * buystatus : 1
         * surfacePic : http://file.uyinmusic.com/classroom/Single/guitar/%E5%BE%80%E5%90%8E%E4%BD%99%E7%94%9F.png
         * readNum : 238922
         * price : 8.88
         * opernId : 14521
         * title : 《往后余生》吉他弹唱教学
         * wechatLink :
         */

        private int classId;
        private int buystatus;
        private String surfacePic;
        private int readNum;
        private double price;
        private int opernId;
        private String title;
        private String wechatLink;

        public int getClassId() {
            return classId;
        }

        public void setClassId(int classId) {
            this.classId = classId;
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

        public int getReadNum() {
            return readNum;
        }

        public void setReadNum(int readNum) {
            this.readNum = readNum;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getOpernId() {
            return opernId;
        }

        public void setOpernId(int opernId) {
            this.opernId = opernId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getWechatLink() {
            return wechatLink;
        }

        public void setWechatLink(String wechatLink) {
            this.wechatLink = wechatLink;
        }
    }
}
