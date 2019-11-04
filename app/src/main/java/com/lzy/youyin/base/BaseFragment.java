package com.lzy.youyin.base;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.coder.zzq.smartshow.dialog.LoadingDialog;
import com.jaeger.library.StatusBarUtil;
import com.lzy.youyin.R;
import com.lzy.youyin.utils.Event;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.Objects;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.com.superLei.aoparms.annotation.Intercept;
import io.reactivex.annotations.NonNull;


public abstract class BaseFragment extends Fragment {

    private Context context;
    private Unbinder unBinder;
    private LoadingDialog progressLoading;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        progressLoading = new LoadingDialog().middle().message("加载中...");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(this.getLayoutId(), container, false);
        unBinder = ButterKnife.bind(this, view);
        EventBus.getDefault().register(this);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        StatusBarUtil.setColor(getActivity(),getResources().getColor(R.color.white),0);
        StatusBarUtil.setTranslucent(getActivity(), 0);
        StatusBarUtil.setLightMode(Objects.requireNonNull(getActivity()));
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        fetchData();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unBinder.unbind();
        EventBus.getDefault().unregister(this);
    }

    @androidx.annotation.NonNull
    @Override
    public Context getContext() {
        return context==null? Objects.requireNonNull(getActivity()).getApplicationContext():context;
    }

    /**
     * EventBus事件订阅
     * @param event 事件类
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventBusCome(Event event) {
        if (event != null) {
            receiveEvent(event);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onStickyEventBusCome(Event event) {
        if (event != null) {
            receiveStickyEvent(event);
        }
    }

    /**
     * 接收到分发到事件
     * @param event 事件
     */
    @Intercept("EventBus_Receiver_intercept")
    protected void receiveEvent(Event event) {}

    /**
     * 接受到分发的粘性事件
     * @param event 粘性事件
     */
    @Intercept("EventBus_Receiver_intercept")
    protected void receiveStickyEvent(Event event) {}

    public void showLoading() {
        progressLoading.showInFragment(this);
    }

    public void hideLoading() {
        progressLoading.dismiss();
    }

    protected abstract void initView(View view);

    protected abstract int getLayoutId();

    protected abstract void fetchData();

    public void Goto(Class<?> clz) {
        startActivity(new Intent(getContext(), clz), null);
    }

    public void Goto(Class<?> clz, int flag) {
        startActivity(new Intent(getContext(), clz).setFlags(flag), null);
    }

    public void Goto(Class<?> clz, String key, int value) {
        startActivity(new Intent(getContext(), clz).putExtra(key, value), null);
    }

    public void Goto(Class<?> clz, String key, String value) {
        startActivity(new Intent(getContext(), clz).putExtra(key, value), null);
    }

    public void Goto(Class<?> clz, String key, String value, String key1, String value1) {
        startActivity(new Intent(getContext(), clz).putExtra(key, value).putExtra(key1, value1), null);
    }
    public void Goto(Class<?> clz, String key, String value, String key1, String value1, String key2, String value2) {
        startActivity(new Intent(getContext(), clz).putExtra(key, value).putExtra(key1, value1).putExtra(key2, value2), null);
    }
    public void Goto(Class<?> clz, String key, String value, String key1, String value1, String key2, String value2, String key3, String value3) {
        startActivity(new Intent(getContext(), clz).putExtra(key, value).putExtra(key1, value1).putExtra(key2, value2).putExtra(key3, value3), null);
    }
}
