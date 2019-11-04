package com.lzy.youyin.view;

import android.content.Context;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.blankj.utilcode.util.RegexUtils;
import com.bumptech.glide.Glide;
import com.lzy.youyin.R;
import com.lzy.youyin.base.BaseActivity;
import com.lzy.youyin.bean.VideoDetailBean;
import com.rxjava.rxlife.RxLife;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import rxhttp.wrapper.param.RxHttp;

import static com.lzy.youyin.base.Constance.TOKEN;
import static com.lzy.youyin.base.Constance.USERID;

public class OperasDetailActivity extends BaseActivity {

    @BindView(R.id.banner)
    Banner banner;
    private ArrayList<String> imgs;

    @Override
    public int getLayoutId() {
        return R.layout.activity_operas_detail;
    }

    @Override
    public void initView() {
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                Goto(PhotoViewActivity.class,"img",imgs.get(position));
            }
        });
    }

    @Override
    public void initDate() {
        super.initDate();
        RxHttp.get("/guitar/open/classroom/getSingleClassDetail")
                .add("userId",USERID)
                .add("classId",getIntent().getIntExtra("classid",0))
                .add("access_token",TOKEN)
                .asObject(VideoDetailBean.class)
                .as(RxLife.asOnMain(this))
                .subscribe(bean -> {
                    VideoDetailBean.DataBean data = bean.getData();
                    List<String> matches = RegexUtils.getMatches("src\\s*=\\s*\"?(.*?)(\"|>|\\s+)", data.getOpern());
                    imgs = new ArrayList<>(3);
                    for (String match : matches) {
                        imgs.add(match.substring(5,match.length()-1));
                    }
                    banner.setImages(imgs);
                    startBanner();
                });
    }

    private void startBanner() {
        //设置banner样式(显示圆形指示器)
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置指示器位置（指示器居右）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //设置图片加载器
        banner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(context).load(path).into(imageView);
            }
        });
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.DepthPage);
        //设置自动轮播，默认为true
        banner.isAutoPlay(false);
        //设置轮播时间
        banner.setDelayTime(5000);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }
}
