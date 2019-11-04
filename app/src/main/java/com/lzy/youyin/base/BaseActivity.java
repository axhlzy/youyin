package com.lzy.youyin.base;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.blankj.utilcode.util.SPUtils;
import com.coder.zzq.smartshow.dialog.LoadingDialog;
import com.jaeger.library.StatusBarUtil;
import com.lzy.youyin.utils.Event;
import com.lzy.youyin.utils.EventBusUtil;
import com.vondear.rxtool.RxActivityTool;
import com.vondear.rxtool.RxKeyboardTool;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.ButterKnife;
import cn.com.superLei.aoparms.annotation.Intercept;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.BehaviorSubject;

public abstract class BaseActivity extends AppCompatActivity {

    public static final String TAG = "TAG";
    private EditText editText;
    private LoadingDialog progressLoading;
    private CompositeDisposable disposable;
    private final BehaviorSubject lifecycleSubject = BehaviorSubject.create();

    private boolean isFullScreen = false;

    private boolean isSetStatusBar = true;

    private boolean isAllowScreenRoate = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ConfigActivity();
        setContentView(this.getLayoutId());
        RxActivityTool.addActivity(this);
        ButterKnife.bind(this);
        //是否沉浸式任务栏
        if (isSetStatusBar) {
            StatusBarUtil.setTranslucent(this,0);
            StatusBarUtil.setLightMode(this);
        }
        if (isRegisterEventBus()) {
            EventBusUtil.register(this);
        }
        disposable = new CompositeDisposable();
        progressLoading = new LoadingDialog().middle().message("加载中...");
        initView();
        initDate();
    }

    private void ConfigActivity() {
        //是否全屏
        if (isFullScreen) {
            this.getWindow().setFlags(
                    WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
            requestWindowFeature(Window.FEATURE_NO_TITLE);
        }
        //是否允许旋转屏幕
        if (!isAllowScreenRoate) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        } else {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }

    public abstract int getLayoutId();

    public abstract void initView();

    public void initDate() {
    }

    public void setAllowFullScreen(boolean allowFullScreen) {
        this.isFullScreen = allowFullScreen;
    }

    public void setScreenRoate(boolean isAllowScreenRoate) {
        this.isAllowScreenRoate = isAllowScreenRoate;
    }

    public Context getContext() {
        return this;
    }

    public int getResouseColor(@ColorRes int colorId) {
        return getResources().getColor(colorId);
    }

    public Drawable getResouseDrawable(@DrawableRes int drawableId) {
        return getResources().getDrawable(drawableId);
    }

    public void showLoading() {
        progressLoading.showInActivity(this);
    }

    public void hideLoading() {
        progressLoading.dismiss();
    }

    public void Goto(Class<?> clz) {
        startActivity(new Intent(this, clz), null);
    }

    public void Goto(Class<?> clz, String key, String value) {
        startActivity(new Intent(this, clz).putExtra(key, value), null);
    }

    public void Goto(Class<?> clz, String key, String value, String key1, String value1) {
        startActivity(new Intent(this, clz).putExtra(key, value).putExtra(key1, value1), null);
    }

    public void Goto(Class<?> clz, String key0, String value0, String key1, String value1, String key2, String value2) {
        startActivity(new Intent(this, clz).putExtra(key0, value0).putExtra(key1, value1).putExtra(key2, value2), null);
    }

    public void Goto(Class<?> clz, String key0, String value0, String key1, String value1, String key2, String value2, String key3, String value3) {
        startActivity(new Intent(this, clz).putExtra(key0, value0).putExtra(key1, value1).putExtra(key2, value2).putExtra(key3, value3), null);
    }

    public void Goto(Class<?> clz, String key0, String value0, String key1, String value1, String key2, String value2, String key3, String value3, String key4, String value4) {
        startActivity(new Intent(this, clz).putExtra(key0, value0).putExtra(key1, value1).putExtra(key2, value2).putExtra(key3, value3).putExtra(key4, value4), null);
    }

    public void Goto(Class<?> clz, String key, int value) {
        startActivity(new Intent(this, clz).putExtra(key, value), null);
    }

    public void Goto(Class<?> clz, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(this, clz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    public void Goto(Class<?> clz, int flag) {
        startActivity(new Intent(this, clz).setFlags(flag), null);
    }

    public void Goto(Class<?> clz, int flag, String key, String value) {
        startActivity(new Intent(this, clz).setFlags(flag).putExtra(key,value), null);
    }

    public void Goto(Class<?> clz, Bundle bundle, int flag) {
        Intent intent = new Intent();
        intent.setFlags(flag);
        intent.setClass(this, clz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    public void startActivityForResult(Class<?> cls, Bundle bundle, int requestCode) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }

    public String getToken() {
        return SPUtils.getInstance().getString("token");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // 点击手机上的返回键，返回上一层
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            RxActivityTool.finishActivity();
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * 是否注册事件分发
     *
     * @return true绑定EventBus事件分发，默认绑定
     */
    protected boolean isRegisterEventBus() {
        return true;
    }

    /**
     * EventBus事件订阅
     *
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
     *
     * @param event 事件
     */
    @Intercept("EventBus_Receiver_intercept")
    protected void receiveEvent(Event event) {
    }

    /**
     * 接受到分发的粘性事件
     *
     * @param event 粘性事件
     */
    @Intercept("EventBus_Receiver_intercept")
    protected void receiveStickyEvent(Event event) {
    }

    //使editText点击外部时候失去焦点
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (isShouldHideInput(v, ev)) {//点击editText控件外部
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    assert v != null;
                    RxKeyboardTool.hideKeyboard(this, v);
                    if (editText != null) {
                        editText.clearFocus();
                    }
                }
            }
            return super.dispatchTouchEvent(ev);
        }
        // 必不可少，否则所有的组件都不会有TouchEvent了
        return getWindow().superDispatchTouchEvent(ev) || onTouchEvent(ev);
    }

    public boolean isShouldHideInput(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText)) {
            editText = (EditText) v;
            int[] leftTop = {0, 0};
            //获取输入框当前的location位置
            v.getLocationInWindow(leftTop);
            int left = leftTop[0];
            int top = leftTop[1];
            int bottom = top + v.getHeight();
            int right = left + v.getWidth();
            return !(event.getX() > left && event.getX() < right
                    && event.getY() > top && event.getY() < bottom);
        }
        return false;
    }

    public CompositeDisposable getDisposable() {
        return disposable;
    }

}
