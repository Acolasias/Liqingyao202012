package com.bawei.lqy.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.lqy.R;
import com.bawei.lqy.base.BaseActivity;
import com.bawei.lqy.contract.ICartContract;
import com.bawei.lqy.model.bean.CartBean;
import com.bawei.lqy.presenter.ICartPresenter;
import com.bawei.lqy.view.adapter.CartAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CartActivity extends BaseActivity<ICartPresenter> implements ICartContract.IView {

    @BindView(R.id.lv)
    ExpandableListView lv;
    @BindView(R.id.it_all)
    CheckBox itAll;
    @BindView(R.id.it_price)
    TextView itPrice;
    @BindView(R.id.it_btn)
    Button itBtn;
    private CartAdapter cartAdapter;

    @Override
    protected void initData() {
        mPresenter.onCartData();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected ICartPresenter providerPresenter() {
        return new ICartPresenter();
    }

    @Override
    protected int LayoutId() {
        return R.layout.activity_cart;
    }

    @Override
    public void onCartSueccess(CartBean bean) {

        List<CartBean.ResultBean> result = bean.getResult();
        cartAdapter = new CartAdapter(result);
        cartAdapter.setOnItemClickListener(new CartAdapter.onItemClickListener() {
            @Override
            public void onItemClick() {
                //Toast.makeText(CartActivity.this, "总价" + cartAdapter.calculateTotalPrice(), Toast.LENGTH_SHORT).show();
                itAll.setChecked(cartAdapter.calculateAllIsChecked());
                itPrice.setText("合计:￥"+cartAdapter.calculateTotalPrice());
                itBtn.setText("去结算("+cartAdapter.calculateTotalNumber()+")");
            }
        });
        lv.setAdapter(cartAdapter);
        for (int i = 0; i < result.size(); i++) {
            lv.expandGroup(i);
        }

    }

    @Override
    public void onCartFailure(Throwable throwable) {
        Toast.makeText(this, "请求失败" + throwable.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @OnClick({R.id.it_all, R.id.it_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.it_all:
                if (cartAdapter != null) {
                    boolean b = cartAdapter.calculateAllIsChecked();
                    b=!b;
                    cartAdapter.calculateisAllChecked(b);
                    itPrice.setText("合计:￥"+cartAdapter.calculateTotalPrice());
                    itBtn.setText("去结算("+cartAdapter.calculateTotalNumber()+")");
                }
                break;
            case R.id.it_btn:
                break;
        }
    }
}
