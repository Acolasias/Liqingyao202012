package com.bawei.lqy.base;

/**
 * Time:2020/1/7 0007上午 08:53202001
 * 邮箱:2094158527@qq.com
 * 作者:李庆瑶
 * 类功能:
 */
public abstract class BasePresenter<V> {
    protected V view;

    public BasePresenter( ) {
        initModel();
    }

    protected abstract void initModel();

    public void detach() {
        view=null;
    }

    public void attach(V view) {
        this.view = view;
    }
}
