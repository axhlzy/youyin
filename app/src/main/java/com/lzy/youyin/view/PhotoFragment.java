package com.lzy.youyin.view;

import android.view.View;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;
import com.lzy.youyin.R;
import com.lzy.youyin.base.BaseFragment;

import butterknife.BindView;

/**
 * Created by Lzy On 2019/8/19
 * Describe:
 */
public class PhotoFragment extends BaseFragment {

    @BindView(R.id.photoView)
    PhotoView photoView;


    public PhotoFragment(String img) {
        Glide.with(getContext()).load(img).into(photoView);
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_fragment_photo;
    }

    @Override
    protected void fetchData() {

    }
}
