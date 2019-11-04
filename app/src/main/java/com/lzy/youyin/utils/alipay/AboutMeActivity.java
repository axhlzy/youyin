package com.lzy.youyin.utils.alipay;

import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.lzy.youyin.R;
import com.lzy.youyin.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class AboutMeActivity extends BaseActivity {

    @BindView(R.id.tv_about_msg)
    TextView tv_about_msg;
    @BindView(R.id.btn_donate_alipay)
    Button btn_donate_alipay;

    @Override
    public int getLayoutId() {
        return R.layout.activity_about_me;
    }

    @Override
    public void initView() {
        tv_about_msg.setAutoLinkMask(Linkify.ALL);
        tv_about_msg.setMovementMethod(LinkMovementMethod.getInstance());
        boolean hasInstalledAlipayClient = AlipayZeroSdk.hasInstalledAlipayClient(this);
        if (hasInstalledAlipayClient) {
            btn_donate_alipay.setEnabled(true);
            btn_donate_alipay.setClickable(true);
        } else {
            btn_donate_alipay.setEnabled(false);
            btn_donate_alipay.setClickable(false);
        }
    }

    @OnClick({R.id.img_back, R.id.btn_donate_alipay})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                onBackPressed();
                break;
            case R.id.btn_donate_alipay:
                AlipayZeroSdk.startAlipayClient(AboutMeActivity.this, "fkx06190q1yraibiakvqnbf");
                ToastUtils.showShort("感谢大佬对小弟的支持   ^_^");
                break;
        }
    }
}