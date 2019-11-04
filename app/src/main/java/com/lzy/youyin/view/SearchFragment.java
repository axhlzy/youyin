package com.lzy.youyin.view;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
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

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import rxhttp.wrapper.param.RxHttp;

import static com.lzy.youyin.base.Constance.USERID;
import static com.lzy.youyin.base.app.getLoading;

/**
 * Created by Lzy On 2019/8/19
 * Describe:
 */
public class SearchFragment extends BaseFragment implements TextWatcher {

    @BindView(R.id.et_text)
    EditText etText;
    @BindView(R.id.rec)
    RecyclerView rec;
    @BindView(R.id.icon_close)
    ImageView icon_close;

    private BaseQuickAdapter<HotInfoBean.DataBean, BaseViewHolder> mAdapter;

    @Override
    protected void initView(View view) {
        etText.addTextChangedListener(this);
        rec.setLayoutManager(new LinearLayoutManager(getContext()));
        rec.setAdapter(mAdapter = new BaseQuickAdapter<HotInfoBean.DataBean, BaseViewHolder>(R.layout.item_layout_item_fragment) {
            @Override
            protected void convert(BaseViewHolder helper, HotInfoBean.DataBean item) {
                Glide.with(getContext()).load(item.getSurfacePic()).into((ImageView) helper.getView(R.id.img));
                helper.setText(R.id.tv_name, String.valueOf(item.getTitle()))
                        .setText(R.id.tv_count, String.valueOf(item.getReadNum()));
                helper.addOnClickListener(R.id.btn_see_operas);
            }
        });
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Goto(VideoDetailActivity.class, "classid", mAdapter.getData().get(position).getClassId());
            }
        });
        mAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                Goto(OperasDetailActivity.class, "classid", mAdapter.getData().get(position).getClassId());
            }
        });
        mAdapter.setEmptyView(LayoutInflater.from(getContext()).inflate(R.layout.layout_input_null, null));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_fragment_search;
    }

    @Override
    protected void fetchData() {

    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        if (charSequence.length() == 0) {
            icon_close.setVisibility(View.GONE);
        } else {
            icon_close.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }


    @OnClick({R.id.icon_close, R.id.btn_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.icon_close:
                etText.setText("");
                break;
            case R.id.btn_search:
                RxHttp.get("/guitar/open/search/searchSingleClass")
                        .add("page",1)
                        .add("rows",10)
                        .add("userId",USERID)
                        .add("keyword",etText.getText().toString())
                        .asObject(HotInfoBean.class)
                        .as(RxLife.asOnMain(this))
                        .subscribe(new Observer<HotInfoBean>() {
                            @Override
                            public void onSubscribe(Disposable d) {
                                getLoading().showInFragment(SearchFragment.this);
                            }

                            @Override
                            public void onNext(HotInfoBean hotInfoBean) {
                                List<HotInfoBean.DataBean> data = hotInfoBean.getData();
                                mAdapter.setNewData(data);
                                mAdapter.setEmptyView(LayoutInflater.from(getContext()).inflate(R.layout.layout_no_data_income, null));
                            }

                            @Override
                            public void onError(Throwable e) {
                                getLoading().dismiss();
                            }

                            @Override
                            public void onComplete() {
                                getLoading().dismiss();
                            }
                        });
                break;
        }
    }
}
