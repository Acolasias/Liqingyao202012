package com.bawei.lqy.contract;

import com.bawei.lqy.model.bean.CartBean;
import com.bawei.lqy.model.bean.SecondGson;

/**
 * Time:2020/1/7 0007上午 09:00202001
 * 邮箱:2094158527@qq.com
 * 作者:李庆瑶
 * 类功能:
 */
public interface ICartContract {

    interface IView{
        void onCartSueccess(CartBean bean);
        void onCartFailure(Throwable throwable);
    }

    interface IPresenter{
        void onCartData();
    }

    interface IModel{
        void onCartData(ICartCallBack iCartCallBack);
        interface ICartCallBack{
            void onCartSueccess(CartBean bean);
            void onCartFailure(Throwable throwable);
        }
    }
}
