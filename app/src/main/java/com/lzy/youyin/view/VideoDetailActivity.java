package com.lzy.youyin.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.blankj.utilcode.util.RegexUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.github.chrisbanes.photoview.PhotoView;
import com.jaeger.library.StatusBarUtil;
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
import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;
import rxhttp.wrapper.param.RxHttp;

import static com.lzy.youyin.base.Constance.TOKEN;
import static com.lzy.youyin.base.Constance.USERID;

public class VideoDetailActivity extends BaseActivity {

    @BindView(R.id.jz_video)
    JZVideoPlayerStandard jzVideoPlayerStandard;
    @BindView(R.id.tv_name)
    TextView tv_name;
    @BindView(R.id.banner)
    Banner banner;
    private ArrayList<String> imgs;

    @Override
    public int getLayoutId() {
        return R.layout.activity_video_detail;
    }

    @Override
    public void initView() {
        StatusBarUtil.setDarkMode(this);
        StatusBarUtil.setColor(this,getResouseColor(R.color.black));
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                if (imgs.isEmpty()) {
                    return;
                }
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
                    tv_name.setText(data.getTitle());
                    jzVideoPlayerStandard.setUp(data.getUrl(), JZVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, data.getTitle());
                    Glide.with(this).load(data.getSurfacePic()).into(jzVideoPlayerStandard.thumbImageView);
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
//                final ObjectAnimator anim = ObjectAnimator.ofInt(imageView, "ImageLevel", 0, 10000);
//                anim.setDuration(800);
//                anim.setRepeatCount(ObjectAnimator.INFINITE);
//                anim.start();
                Glide.with(context)
                        .load(path)
                        .optionalCenterInside()
//                        .placeholder(getResouseDrawable(R.drawable.waitting))
//                        .listener(new RequestListener<Drawable>() {
//                    @Override
//                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
//                        anim.cancel();
//                        return false;
//                    }
//
//                    @Override
//                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
//                        anim.cancel();
//                        return false;
//                    }
//                })
                    .into(imageView);
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        JZVideoPlayer.releaseAllVideos();
    }

    @Override
    protected void onStop() {
        super.onStop();
        jzVideoPlayerStandard.onStatePause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        jzVideoPlayerStandard.onStatePlaying();
    }

    @Override
    public void onBackPressed() {
        if (JZVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }
}
