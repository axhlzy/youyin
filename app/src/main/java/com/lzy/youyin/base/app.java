package com.lzy.youyin.base;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.multidex.MultiDex;

import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.Utils;
import com.coder.zzq.smartshow.core.SmartShow;
import com.coder.zzq.smartshow.dialog.LoadingDialog;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreator;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator;
import com.scwang.smartrefresh.layout.api.DefaultRefreshInitializer;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.vondear.rxtool.RxTool;

import net.qiujuer.genius.kit.handler.Run;
import net.qiujuer.genius.kit.handler.runable.Action;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.plugins.RxJavaPlugins;
import okhttp3.OkHttpClient;
import rxhttp.HttpSender;
import rxhttp.wrapper.param.DeleteRequest;
import rxhttp.wrapper.param.GetRequest;
import rxhttp.wrapper.param.Param;
import rxhttp.wrapper.param.PostRequest;
import rxhttp.wrapper.param.PutRequest;

/**
 * Created by Lzy On 2019/8/19
 * Describe:
 */
public class app extends Application {

    private static LoadingDialog progressLoading;

    static {//使用static代码段可以防止内存泄漏

        //设置全局默认配置（优先级最低，会被其他设置覆盖）
        SmartRefreshLayout.setDefaultRefreshInitializer(new DefaultRefreshInitializer() {
            @Override
            public void initialize(@NonNull Context context, @NonNull RefreshLayout layout) {
                //开始设置全局的基本参数（可以被下面的DefaultRefreshHeaderCreator覆盖）
//                layout.autoRefresh();
                layout.setEnableRefresh(false);
                layout.setEnableLoadMore(true);
                layout.setEnableFooterTranslationContent(true);
                layout.setEnableHeaderTranslationContent(true);
                layout.setDisableContentWhenRefresh(true);//是否在刷新的时候禁止列表的操作
                layout.setDisableContentWhenLoading(true);//是否在加载的时候禁止列表的操作
            }
        });

        //全局设置默认的 Header
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
            @Override
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
                //开始设置全局的基本参数（这里设置的属性只跟下面的MaterialHeader绑定，其他Header不会生效，能覆盖DefaultRefreshInitializer的属性和Xml设置的属性）
                layout.setEnableHeaderTranslationContent(true);
                return new ClassicsHeader(context);
            }
        });

        SmartRefreshLayout.setDefaultRefreshFooterCreator(new DefaultRefreshFooterCreator() {
            @NonNull
            @Override
            public RefreshFooter createRefreshFooter(@NonNull Context context, @NonNull RefreshLayout layout) {
                layout.setEnableFooterTranslationContent(true);
                return new ClassicsFooter(context).setDrawableSize(20);
            }
        });

    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(base);
    }

    public static LoadingDialog getLoading() {
        return progressLoading;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
        RxTool.init(this);
        SmartShow.init(this);
        HttpSender.init(new OkHttpClient(), true);
        HttpSender.setOnParamAssembly(new Function<Param, Param>() {
            @Override
            public Param apply(Param p) {
                if (p instanceof GetRequest) {//根据不同请求添加不同参数
                } else if (p instanceof PostRequest) {

                } else if (p instanceof PutRequest) {

                } else if (p instanceof DeleteRequest) {

                }
                //可以通过 p.getSimpleUrl() 拿到url更改后，重新设置
                //p.setUrl("");
                return p.addHeader("deviceType", "android"); //添加公共请求头
            }
        });

        RxJavaPlugins.setErrorHandler(new Consumer<Throwable>() {
            public void accept(Throwable throwable) {
                Log.e("err", throwable.getMessage());
            }
        });

        progressLoading = new LoadingDialog().middle().message("加载中...");

        Run.onBackground(new Action() {
            @Override
            public void call() {
                Constance.USERID = SPUtils.getInstance().getString("USERID","264555");
                Constance.TOKEN = SPUtils.getInstance().getString("TOKEN","18131515d3904669a915d6a0a38b6b2f");
            }
        });
    }
}
