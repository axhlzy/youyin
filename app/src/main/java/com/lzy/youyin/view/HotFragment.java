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
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;

import java.util.List;

import butterknife.BindView;
import io.reactivex.annotations.NonNull;
import rxhttp.wrapper.param.RxHttp;

public class HotFragment extends BaseFragment implements OnLoadMoreListener {
    @BindView(R.id.rec)
    RecyclerView rec;
    @BindView(R.id.layout_refresh)
    SmartRefreshLayout refreshLayout;

    private BaseQuickAdapter<HotInfoBean.DataBean, BaseViewHolder> mAdapter;
    private int page = 1;

    @Override
    protected void initView(View view) {
        refreshLayout.setOnLoadMoreListener(this);
        rec.setLayoutManager(new LinearLayoutManager(getContext()));
        rec.setAdapter(mAdapter = new BaseQuickAdapter<HotInfoBean.DataBean, BaseViewHolder>(R.layout.item_layout_item_fragment) {
            @Override
            protected void convert(BaseViewHolder helper, HotInfoBean.DataBean item) {
                Glide.with(getContext()).load(item.getSurfacePic()).into((ImageView) helper.getView(R.id.img));
                helper.setText(R.id.tv_name,String.valueOf(item.getTitle()))
                        .setText(R.id.tv_count,String.valueOf(item.getReadNum()));
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
        RxHttp.get("/guitar/open/classroom/getSingleClassListPage?page="+page+"&rows=20")
                .asObject(HotInfoBean.class)
                .as(RxLife.asOnMain(this))
                .subscribe(hotInfoBean -> {
                    List<HotInfoBean.DataBean> data = hotInfoBean.getData();
                    mAdapter.setNewData(data);
                });
    }


    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        ++page;
        RxHttp.get("/guitar/open/classroom/getSingleClassListPage?page="+page+"&rows=20")
                .asObject(HotInfoBean.class)
                .as(RxLife.asOnMain(this))
                .subscribe(hotInfoBean -> {
                    List<HotInfoBean.DataBean> data = hotInfoBean.getData();
                    if (data.isEmpty()) {
                        --page;
                        refreshLayout.setNoMoreData(true);
                    }else{
                        mAdapter.addData(data);
                    }
                    refreshLayout.finishLoadMore();
                });
    }
}
