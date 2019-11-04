package com.lzy.youyin.view;

import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.androidkun.xtablayout.XTabLayout;
import com.blankj.utilcode.util.SPUtils;
import com.lzy.youyin.R;
import com.lzy.youyin.base.BaseActivity;
import com.lzy.youyin.base.BaseFragment;
import com.lzy.youyin.utils.CommonUtils;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.OnDismissListener;
import com.orhanobut.dialogplus.ViewHolder;

import net.qiujuer.genius.kit.handler.Run;
import net.qiujuer.genius.kit.handler.runable.Action;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.OnLongClick;

import static com.lzy.youyin.base.Constance.TOKEN;
import static com.lzy.youyin.base.Constance.USERID;

public class MainActivity extends BaseActivity {

    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.tab_layout)
    XTabLayout tabLayout;

    private List<BaseFragment> fragments;
    private List<String> tabs;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        tabs = Arrays.asList(getResources().getString(R.string.tv_new), getResources().getString(R.string.tv_hot),getResources().getString(R.string.tv_search));
        initFragment();
        initViewPager();
        LoadDate();
    }

    private void LoadDate() {

    }

    //初始化ViewPager
    private void initViewPager() {
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return fragments.get(i);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return tabs.get(position);
            }
        });
        tabLayout.setupWithViewPager(viewPager);
    }

    //初始化两个Fragment
    private void initFragment() {
        NewFragment newFragment = new NewFragment();
        HotFragment hotFragment = new HotFragment();
        SearchFragment searchFragment = new SearchFragment();
        fragments = Arrays.asList(newFragment, hotFragment,searchFragment);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        CommonUtils.doubleClickExitApp();
    }
    public static class Solution {
        public static void main(String[] args) {

            boolean palindrome = isPalindrome(123);

        }
        public static boolean isPalindrome(int x) {
            String s = String.valueOf(x);
            char[] chars = s.toCharArray();
            int length = s.length();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = s.length(); i > 0; i--) {
                stringBuffer.append(chars[i]);
            }
            return stringBuffer.toString().equals(s);
        }
    }
    @OnLongClick(R.id.frameLayout)
    public void onLongClick(){
        ViewHolder viewHolder = new ViewHolder(R.layout.content_view);
        DialogPlus.newDialog(this)
                .setContentHolder(viewHolder)
                .setContentWidth(ViewPager.LayoutParams.WRAP_CONTENT)
                .setContentHeight(ViewPager.LayoutParams.WRAP_CONTENT)
                .setOnDismissListener(dialog -> {
                    View holderView = dialog.getHolderView();
                    EditText et_id = holderView.findViewById(R.id.et_id);
                    EditText et_token = holderView.findViewById(R.id.et_token);
                    Run.onBackground(() -> {
                        SPUtils.getInstance().put("USERID",et_id.getText().toString());
                        SPUtils.getInstance().put("TOKEN",et_token.getText().toString());
                    });
                }).create().show();
        ((EditText)viewHolder.getInflatedView().findViewById(R.id.et_id)).setText(USERID);
        ((EditText)viewHolder.getInflatedView().findViewById(R.id.et_token)).setText(TOKEN);
    }
}
