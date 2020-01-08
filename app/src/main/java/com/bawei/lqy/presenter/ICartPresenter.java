package com.bawei.lqy.presenter;

import com.bawei.lqy.base.BasePresenter;
import com.bawei.lqy.contract.ICartContract;
import com.bawei.lqy.model.ICartModel;
import com.bawei.lqy.model.bean.CartBean;
import com.bawei.lqy.model.bean.SecondGson;

/**
 * Time:2020/1/7 0007上午 09:06202001
 * 邮箱:2094158527@qq.com
 * 作者:李庆瑶
 * 类功能:
 */
public class ICartPresenter extends BasePresenter<ICartContract.IView> implements ICartContract.IPresenter {

    private ICartModel iCartModel;

    @Override
    protected void initModel() {
        iCartModel = new ICartModel();
    }

    @Override
    public void onCartData() {

        iCartModel.onCartData(new ICartContract.IModel.ICartCallBack() {
            @Override
            public void onCartSueccess(CartBean bean) {
                view.onCartSueccess(bean);
            }

            @Override
            public void onCartFailure(Throwable throwable) {

                view.onCartFailure(throwable);
            }
        });
    }
}
