package com.lzy.youyin.bean;

import java.util.List;

/**
 * Created by Lzy On 2019/8/19
 * Describe:
 */
public class NewInfoBean {
//    https://www.uyinmusic.com/guitar/open/home/getHomeSingleClassroom
    /**
     * code : 1000
     * data : [{"classId":307,"surfacePic":"http://file.uyinmusic.com/classroom/Single/guitar/%E7%90%86%E6%83%B3.jpg","buystatus":0,"readNum":53,"price":0,"opernId":15040,"title":"赵雷《理想》","wechatLink":""},{"classId":306,"surfacePic":"http://file.uyinmusic.com/classroom/Single/guitar/%E4%BD%A0%E7%9A%84%E5%A7%91%E5%A8%98.png","buystatus":0,"readNum":15134,"price":0,"opernId":15039,"title":"隔壁老樊《你的姑娘》","wechatLink":""},{"classId":305,"surfacePic":"http://file.uyinmusic.com/classroom/Single/guitar/%E6%88%91%E6%9B%BE.jpg","buystatus":1,"readNum":35684,"price":6,"opernId":15038,"title":"隔壁老樊《我曾》","wechatLink":""},{"classId":304,"surfacePic":"http://file.uyinmusic.com/classroom/Single/guitar/%E9%99%AA%E4%BD%A0%E5%BA%A6%E8%BF%87%E6%BC%AB%E9%95%BF%E5%B2%81%E6%9C%88.jpg","buystatus":0,"readNum":22519,"price":0,"opernId":15037,"title":"陈奕迅《陪你度过漫长岁月》","wechatLink":""},{"classId":303,"surfacePic":"http://file.uyinmusic.com/classroom/Single/guitar/%E5%A4%9A%E6%83%B3%E5%9C%A8%E5%B9%B3%E5%BA%B8%E7%9A%84%E7%94%9F%E6%B4%BB%E6%8B%A5%E6%8A%B1%E4%BD%A0.jpg","buystatus":0,"readNum":45882,"price":6,"opernId":15036,"title":"隔壁老樊《多想在平庸的生活拥抱你》","wechatLink":""},{"classId":302,"surfacePic":"http://file.uyinmusic.com/classroom/Single/guitar/%E5%B0%8F%E5%AE%87.png","buystatus":0,"readNum":23504,"price":6,"opernId":15035,"title":"张震岳《小宇》","wechatLink":""},{"classId":301,"surfacePic":"http://file.uyinmusic.com/classroom/Single/guitar/%E8%8E%89%E8%8E%89%E5%AE%89.jpg","buystatus":0,"readNum":33061,"price":3,"opernId":15034,"title":"宋冬野《莉莉安》","wechatLink":""},{"classId":300,"surfacePic":"https://uyin1-10080725.cos.ap-shanghai.myqcloud.com/classroom/Single/guitar/%E7%AD%89%E4%BD%A0%E4%B8%8B%E8%AF%BE.jpg","buystatus":0,"readNum":37627,"price":0,"opernId":15033,"title":"周杰伦《等你下课》","wechatLink":""},{"classId":299,"surfacePic":"http://file.uyinmusic.com/classroom/Single/guitar/%E4%BA%91%E7%83%9F%E6%88%90%E9%9B%A8.jpg","buystatus":0,"readNum":45405,"price":6,"opernId":15032,"title":"房东的猫《云烟成雨》","wechatLink":""},{"classId":298,"surfacePic":"http://file.uyinmusic.com/classroom/Single/guitar/%E6%BC%AB%E6%AD%A5.png","buystatus":0,"readNum":34664,"price":6,"opernId":15031,"title":"许巍《漫步》吉他弹唱教学","wechatLink":""},{"classId":297,"surfacePic":"http://file.uyinmusic.com/classroom/Single/guitar/%E9%87%8E%E5%AD%90.png","buystatus":0,"readNum":25680,"price":0,"opernId":15030,"title":"《野子》吉他弹唱教学","wechatLink":""},{"classId":296,"surfacePic":"http://file.uyinmusic.com/classroom/Single/guitar/%E6%89%A7%E7%9D%80.jpg","buystatus":0,"readNum":47475,"price":6,"opernId":15029,"title":"许巍《执着》吉他弹唱教学","wechatLink":""},{"classId":295,"surfacePic":"http://file.uyinmusic.com/classroom/Single/guitar/%E7%BA%A2%E8%89%B2%E9%AB%98%E8%B7%9F%E9%9E%8B.jpg","buystatus":0,"readNum":74420,"price":0,"opernId":15028,"title":"蔡健雅《红色高跟鞋》吉他弹唱教学","wechatLink":""},{"classId":294,"surfacePic":"http://file.uyinmusic.com/classroom/Single/guitar/%E9%82%A3%E4%B8%80%E5%B9%B4.jpeg","buystatus":0,"readNum":42171,"price":6,"opernId":15027,"title":"许巍《那一年》吉他弹唱教学","wechatLink":""},{"classId":293,"surfacePic":"https://file.qixiongfiles.cn/%E6%98%8E%E5%A4%A9.jpg","buystatus":0,"readNum":36836,"price":6,"opernId":15026,"title":"赵雷新歌《明天》吉他弹唱教学","wechatLink":""},{"classId":292,"surfacePic":"http://file.uyinmusic.com/classroom/Single/guitar/%E6%97%B6%E5%85%89.jpg","buystatus":0,"readNum":38847,"price":6,"opernId":15024,"title":"许巍《时光》吉他弹唱教学","wechatLink":""},{"classId":291,"surfacePic":"http://file.uyinmusic.com/classroom/Single/guitar/%E6%BC%94%E5%91%98.jpg","buystatus":0,"readNum":57538,"price":0,"opernId":15023,"title":"薛之谦《演员》吉他弹唱教学","wechatLink":""},{"classId":290,"surfacePic":"http://file.uyinmusic.com/classroom/Single/guitar/%E8%B5%B0%E9%A9%AC.png","buystatus":1,"readNum":48341,"price":3,"opernId":15022,"title":"陈粒《走马》吉他弹唱教学","wechatLink":""},{"classId":289,"surfacePic":"http://file.uyinmusic.com/classroom/Single/guitar/%E5%80%9F%E6%88%91.jpg","buystatus":0,"readNum":40819,"price":5.8,"opernId":15021,"title":"谢春花《借我》吉他弹唱教学","wechatLink":""},{"classId":288,"surfacePic":"http://file.uyinmusic.com/classroom/Single/guitar/%E5%A3%B0%E5%BE%8B%E5%90%AF%E8%92%99.png","buystatus":1,"readNum":25002,"price":6,"opernId":15020,"title":"经典咏流传《声律启蒙》吉他弹唱教学","wechatLink":""}]
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
         * classId : 307
         * surfacePic : http://file.uyinmusic.com/classroom/Single/guitar/%E7%90%86%E6%83%B3.jpg
         * buystatus : 0
         * readNum : 53
         * price : 0.0
         * opernId : 15040
         * title : 赵雷《理想》
         * wechatLink :
         */

        private int classId;
        private String surfacePic;
        private int buystatus;
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

        public String getSurfacePic() {
            return surfacePic;
        }

        public void setSurfacePic(String surfacePic) {
            this.surfacePic = surfacePic;
        }

        public int getBuystatus() {
            return buystatus;
        }

        public void setBuystatus(int buystatus) {
            this.buystatus = buystatus;
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
