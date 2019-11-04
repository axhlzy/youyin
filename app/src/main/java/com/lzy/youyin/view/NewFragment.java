package com.lzy.youyin.view;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lzy.youyin.R;
import com.lzy.youyin.base.BaseFragment;
import com.lzy.youyin.bean.HotInfoBean;
import com.rxjava.rxlife.RxLife;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.List;

import butterknife.BindView;
import rxhttp.wrapper.param.RxHttp;

public class NewFragment extends BaseFragment {
    @BindView(R.id.rec)
    RecyclerView rec;
    @BindView(R.id.layout_refresh)
    SmartRefreshLayout refreshLayout;

    private BaseQuickAdapter<HotInfoBean.DataBean, BaseViewHolder> mAdapter;

    @Override
    protected void initView(View view) {
        refreshLayout.setEnableRefresh(false);
        refreshLayout.setEnableLoadMore(false);
        rec.setLayoutManager(new LinearLayoutManager(getContext()));
        rec.setAdapter(mAdapter = new BaseQuickAdapter<HotInfoBean.DataBean, BaseViewHolder>(R.layout.item_layout_item_fragment) {
            @Override
            protected void convert(BaseViewHolder helper, HotInfoBean.DataBean item) {
                Glide.with(getContext()).load(item.getSurfacePic()).into((ImageView) helper.getView(R.id.img));
                helper.setText(R.id.tv_name,item.getTitle()+"")
                        .setText(R.id.tv_count,item.getReadNum()+"");
                helper.addOnClickListener(R.id.btn_see_operas);
            }
        });
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Goto(VideoDetailActivity.class,"classid",mAdapter.getData().get(position).getClassId());
            }
        });
        mAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                Goto(OperasDetailActivity.class,"classid",mAdapter.getData().get(position).getClassId());
            }
        });
        mAdapter.setEmptyView(LayoutInflater.from(getContext()).inflate(R.layout.layout_no_data_income,null));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_fragment_hot;
    }

    @Override
    protected void fetchData() {
        RxHttp.get("/guitar/open/home/getHomeSingleClassroom")
                .asObject(HotInfoBean.class)
                .as(RxLife.asOnMain(this))
                .subscribe(hotInfoBean -> {
                    List<HotInfoBean.DataBean> data = hotInfoBean.getData();
                    mAdapter.setNewData(data);
                });
    }
}
