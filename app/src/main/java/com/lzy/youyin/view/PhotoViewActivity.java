package com.lzy.youyin.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.lzy.youyin.R;
import com.lzy.youyin.base.BaseActivity;

public class PhotoViewActivity extends BaseActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_photo_view;
    }

    @Override
    public void initView() {
        Glide.with(this).load(getIntent().getStringExtra("img")).into((ImageView) findViewById(R.id.photoView));
    }
}
