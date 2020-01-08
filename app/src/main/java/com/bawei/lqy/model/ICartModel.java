package com.bawei.lqy.model;

import com.bawei.lqy.contract.ICartContract;
import com.bawei.lqy.model.bean.CartBean;
import com.bawei.lqy.model.bean.SecondGson;
import com.bawei.lqy.utile.NetUtile;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Time:2020/1/7 0007上午 09:03202001
 * 邮箱:2094158527@qq.com
 * 作者:李庆瑶
 * 类功能:
 */
public class ICartModel implements ICartContract.IModel {
    @Override
    public void onCartData(ICartCallBack iCartCallBack) {
        NetUtile.getInstance().getApi().getCartData("13111","157847225167013111")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CartBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CartBean bean) {

                        iCartCallBack.onCartSueccess(bean);
                    }

                    @Override
                    public void onError(Throwable e) {

                        iCartCallBack.onCartFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
